using System;
using System.Text;
using System.Xml;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Xml.Linq;
using System.IO;

namespace WebApplication1
{

    public partial class blog : System.Web.UI.Page
    {
        public static void Show(string message)
        {
            // Cleans the message to allow single quotation marks 
            string cleanMessage = message.Replace("'", "\\'");
            string script = "<script type=\"text/javascript\">alert('" + cleanMessage + "');</script>";

            // Gets the executing web page 
            Page page = HttpContext.Current.CurrentHandler as Page;

            // Checks if the handler is a Page and that the script isn't allready on the Page 
            if (page != null && !page.ClientScript.IsClientScriptBlockRegistered("alert"))
            {
                page.ClientScript.RegisterClientScriptBlock(typeof(Alert), "alert", script);
            }
        }
        public string xmlfile;
        public string xmlfile1;
        public string name1;
        public string title;
        public string blog1;
        protected void Page_Load(object sender, EventArgs e)
        {
            /*if (Request.QueryString["name"].ToString() != "" && Request.QueryString["xmlfile"].ToString() != "" && Request.QueryString["blog"].ToString() != "")
            {*/

            if (Request.QueryString["name"] == null && Request.QueryString["xmlfile"] == null && Request.QueryString["blog"] == null)
            {
                Response.Redirect("faq.aspx");

            }
            else
            {
                name1 = Request.QueryString["name"];
                title = Request.QueryString["title"];
                blog1 = Request.QueryString["blog"];
                xmlfile1 = Request.QueryString["xmlfile"];
                xmlfile = xmlfile1 + ".xml";
                name.Text = name1;
                quetion.Text = blog1;
                Title1.Text = title;
                // Put user code to initialize the page here
                // initialize Blog and read it into a dataset
                try
                {
                DataSet ds = ReadBlogIntoTable();

                RebuildTableView(ds);
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex);
                           
                    Alert.Show("Problem in the data transfer , Please contact authorities");


                }
               
            }


        }
        DataSet ReadBlogIntoTable()
        {
            return ReadXmlComments();
        }

        private DataSet ReadXmlComments()
        {
            // construct the DataSet
            DataSet ds = new DataSet();

            // form the server path of the feedback database
            string filename = Server.MapPath(".\\App_Data\\") + xmlfile;

            // if the file exists, read  the blog database into the data set
          
                ds.ReadXml(filename);
       
            return ds;
        }

        private void WriteXmlComments(DataSet ds)
        {
            string filename = Server.MapPath(".\\App_Data\\") + xmlfile;
            ds.WriteXml(filename);
        }

        /// <summary>
        ///  Append comments to xml file
        /// </summary>
        /// <param name="ds"></param>
        void AppendComments(DataSet ds)
        {
            // create a new DataRow
            DataRow dr = ds.Tables["Comments"].NewRow();
            // Populate the row from the text boxes filled by the user
            dr[0] = Request.Cookies["userName"].Value;
            dr[1] = DateTime.Now;
            dr[2] = tt.Text;
            dr[3] = Subject.Text;


            // add the row to the DataSet
            ds.Tables["Comments"].Rows.InsertAt(dr, 0);

            WriteXmlComments(ds);
        }

        void RebuildTableView(DataSet ds)
        {
           // string previousUser = "";  // track previous

            // loop through each row in the data set and create
            // the row on the web page in a web table
          //  int i = 0;
            foreach (DataRow dr in ds.Tables[0].Rows)
            {



                // add title (use a single column)
                TableRow tr = new TableRow();
                tr.Cells.Add(new TableCell());

                // change title color slightly
                tr.Cells[0].ForeColor = Color.Navy;
                tr.Cells[0].Width = 400;
                //string s = "vik";
                //  make the text title big and purple
                tr.Cells[0].Text = "<FONT SIZE=5 COLOR=Black FACE=Rockwell><B>" + dr[2].ToString() + "</B></FONT>";
                this.BlogTable.Rows.Add(tr);

                // add blog in a single column and span 2 columns
                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
                tr.Cells[0].Text = dr[0].ToString(); 
                this.BlogTable.Rows.Add(tr);

                // add user who posted and date (use two columns in the row)
                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
                tr.Cells[0].Text = "Says :- " + dr[3].ToString();
                this.BlogTable.Rows.Add(tr);

                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
                DateTime postTime;
                try
                {
                    postTime = DateTime.Parse(dr[1].ToString());
                    tr.Cells[0].Text = String.Format("<i>{0}</i></a>", postTime.ToString(" @ hh:mm"));
                    //   this.BlogTable.Rows.Add(tr);

                    tr = new TableRow();
                    tr.Height = 50;
                    tr.HorizontalAlign = HorizontalAlign.Left;
                    tr.VerticalAlign = VerticalAlign.Bottom;
                    tr.Cells.Add(new TableCell());
                    tr.Cells.Add(new TableCell());



                    tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                    //   DateTime postTime = DateTime.Parse(dr[1].ToString());
                    tr.Cells[1].Text = String.Format("<i>{0}</i>", postTime.ToString("MMM dd, 2005 @ hh:mm"));
                    this.BlogTable.Rows.Add(tr);

                }
                catch (Exception err)
                {

                    Console.WriteLine(err);
                    tr = new TableRow();
                    tr.Height = 50;
                    tr.HorizontalAlign = HorizontalAlign.Left;
                    tr.VerticalAlign = VerticalAlign.Bottom;
                    tr.Cells.Add(new TableCell());
                    tr.Cells.Add(new TableCell());

                    tr.Cells[1].Text = String.Format("<i>{0}</i></a>", "Date is not valied");

                    tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                    this.BlogTable.Rows.Add(tr);
                }




                // add separtor graphic and span 2 columns
                tr = new TableRow();
                
                tr.Cells.Add(new TableCell());
                tr.Cells[0].ColumnSpan = 2;

                this.BlogTable.Rows.Add(tr);

                string imageFile = this.ResolveUrl(@".\image\separator.jpg");
                System.Web.UI.WebControls.Image separator = new System.Web.UI.WebControls.Image();
                separator.ImageUrl = imageFile;
                separator.Width = 600;
                separator.Height = 32;
                separator.Visible = true;

                tr.Cells[0].Controls.Add(separator);
                tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;



            }

        }


        #region Web Form Designer generated code
        override protected void OnInit(EventArgs e)
        {
            //
            // CODEGEN: This call is required by the ASP.NET Web Form Designer.
            //
            InitializeComponent();
            base.OnInit(e);
        }

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {

        }
        #endregion

        protected void btnOpenEntry_Click(object sender, System.EventArgs e)
        {
            Response.Redirect("BlogEntry.aspx");
        }
      
        protected void Button1_Click(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] == null && Request.Cookies["password"] == null)
            {
                Show("You must login into the site before u ask quetion");
            }
            else
            {

                if (tt.Text == "" && Subject.Text == "")
                {
                    Show("You must Enter title and comment");

                }
                else
                {
                    try
                    {
                        DataSet ds = ReadBlogIntoTable();
                        AppendComments(ds);
                        WriteXmlComments(ds);

                        Response.Redirect("blog.aspx?xmlfile=" + xmlfile1 + "&name=" + name1 + "&title=" + title + "&blog=" + blog1);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex);
                        Alert.Show("Problem in the data transfer , Please contact authorities");
                    }
                }
            }
            
        }
    }
}