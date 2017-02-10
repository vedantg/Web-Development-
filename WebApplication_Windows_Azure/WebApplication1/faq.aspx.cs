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
    public static class Alert
    {

        /// <summary> 
        /// Shows a client-side JavaScript alert in the browser. 
        /// </summary> 
        /// <param name="message">The message to appear in the alert.</param> 
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
    }
    public partial class faq : System.Web.UI.Page
    {
        public string xmlfile;
        protected void Page_Load(object sender, System.EventArgs e)
        {

            // Put user code to initialize the page here
            if (IsPostBack)
            {

            }
            else
            {
                try
                {
                    // initialize Blog and read it into a dataset
                    DataSet ds = ReadBlogIntoTable();

                    // if we created a new entry, append it to the BlogList
                    // and save it to the xml file


                    // Dynamically build the blog into a WebControls.Table
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
            string filename = Server.MapPath(".\\App_Data\\") + "comments.xml";

            // if the file exists, read  the blog database into the data set
          
                ds.ReadXml(filename);
         
            return ds;
        }

        private void WriteXmlComments(DataSet ds)
        {
            string filename = Server.MapPath(".\\App_Data\\") + "comments.xml";
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
            dr[2] = Subject.Text;
            dr[3] = Quetion.Text;
            dr[4] = xmlfile;

            // add the row to the DataSet
            ds.Tables["Comments"].Rows.InsertAt(dr, 0);

            WriteXmlComments(ds);
        }

        void RebuildTableView(DataSet ds)
        {
            //string previousUser = "";  // track previous

            // loop through each row in the data set and create
            // the row on the web page in a web table
            foreach (DataRow dr in ds.Tables[0].Rows)
            {
                // add title (use a single column)
                TableRow tr = new TableRow();
                tr.Cells.Add(new TableCell());

                // change title color slightly
                tr.Cells[0].ForeColor = Color.Navy;
                tr.Cells[0].Width = 400;
                string s = dr[3].ToString();
                s = s.Replace(" ", "%20");

                string s1 = dr[2].ToString();
                s1 = s1.Replace(" ", "%20");
                //  make the text title big and purple
                tr.Cells[0].Text = "<a href=blog.aspx?xmlfile=" + dr[4].ToString() + "&name=" + dr[0].ToString() + "&title=" + s1 + "&blog=" + s + "><FONT SIZE=5 COLOR=Black FACE=Rockwell><B>" + dr[2].ToString() + "</B></FONT>";
                this.BlogTable.Rows.Add(tr);

                // add blog in a single column and span 2 columns
                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
                tr.Cells[0].Text = "Subject :- " + dr[3].ToString();
                this.BlogTable.Rows.Add(tr);

                // add user who posted and date (use two columns in the row)
                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
                tr.Cells[0].Text = "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Posted by " + dr[0].ToString();
                this.BlogTable.Rows.Add(tr);

                tr = new TableRow();
                tr.Cells.Add(new TableCell());
                tr.Cells[0].Width = 550;
                tr.Cells[0].ColumnSpan = 2;
              
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
            try
            {
                create();

                DataSet ds = ReadBlogIntoTable();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Alert.Show("Problem in the data transfer , Please contact authorities error is "+ ex.Message );


            }
        
        }
        private void create()
        {

            // Create a new XmlTextWriter instance
            DataSet ds = ReadBlogIntoTable();
            if (Quetion.Text != "" && Subject.Text != "")
            {
                if (Request.Cookies["userName"] == null && Request.Cookies["password"] == null)
                {
         
           Alert.Show("You must login into the site before u ask quetion");
                }
                else
                {
                    Random rand = new Random((int)DateTime.Now.Ticks);
                    int numIterations = 0;
                    numIterations = rand.Next(1, 100);


                    xmlfile = Request.Cookies["userName"].Value + numIterations.ToString();
                    XmlTextWriter writer = new XmlTextWriter(Server.MapPath(".//App_Data//" + xmlfile + ".xml"), Encoding.UTF8);

                    // start writing!
                    writer.WriteStartDocument();
                    writer.WriteStartElement("NewDataSet");

                    // Creating the <browserInfo> element
                    writer.WriteStartElement("Comments");

                    writer.WriteElementString("Name", Request.Cookies["userName"].Value);
                    writer.WriteElementString("Time", DateTime.Now.ToString());
                    writer.WriteElementString("Title", Subject.Text);
                    writer.WriteElementString("Blog", Quetion.Text);


                    //   writer.WriteElementString("urlReferrer",
                    //                    Request.UrlReferrer.PathAndQuery);

                    // writer.WriteElementString("userAgent", Request.UserAgent);
                    //writer.WriteElementString("userLanguages", String.Join(", ", Request.UserLanguages));
                    writer.WriteEndElement();
                    /*
                    // Creating the <visitInfo> element
                    writer.WriteStartElement("visitInfo");
                    writer.WriteAttributeString("timeVisited", DateTime.Now.ToString());
                    writer.WriteElementString("ip", Request.UserHostAddress);
                    writer.WriteElementString("rawUrl", Request.RawUrl);
                    writer.WriteEndElement();
                    */
                    writer.WriteEndElement();
                    writer.WriteEndDocument();
                    writer.Close();

                    AppendComments(ds);
                    WriteXmlComments(ds);

                }
            }
            else
            {
                Alert.Show("You must ENTER subject and quetion");

            }
            Subject.Text = "";
            Quetion.Text = "";
            RebuildTableView(ds);


        }
      
    }
}