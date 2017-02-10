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
using System.Configuration;
using System.Web.Configuration;
using System.Web.Security;
using System.Web.UI.WebControls.WebParts;
using System.Data.SqlClient;


namespace WebApplication1
{
    public partial class information : System.Web.UI.Page
    {
        ArrayList stud_cor = new ArrayList();
        protected void Page_Load(object sender, EventArgs e)
        {
          RebuildTableView();
        
        }


          public void Show(string message)
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
          public int conts(string s)
          {
              int cnt = 0;
              for (int i = 0; i < s.Length; i++)
              {
                  if (s[i].ToString() == "&")
                      cnt++;

              }

              return cnt;
          }
          public void course()
          {

              String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

              string sqlQuery = "select * from STUDENT where STUD_ID='" + Request.Cookies["userName"].Value + "'";

              SqlConnection conn = new SqlConnection(strConn);

              SqlCommand cmd = new SqlCommand();

              SqlDataReader reader;

              cmd.Connection = conn;

              cmd.CommandText = sqlQuery;

              cmd.CommandType = CommandType.Text;

              conn.Open();

              reader = cmd.ExecuteReader();



              if (reader.Read())
              {



                  string s = reader["CURRENT_COURSE"].ToString();
                 // str = s;
                  int cnt = conts(s);
                  string pr = "";
                  int j = 0;
                  try
                  {

                      for (int i = 0; i < cnt; i++)
                      {
                          pr = "";
                          while (j < s.Length)
                          {
                              if (s[j].ToString() == "&")
                              {
                                  stud_cor.Add(pr);
                                //  L_PREFERED_CURRENT1.Items.Add(pr);
                                  //break;
                                  pr = "";
                                  j++;
                              }
                              pr += s[j].ToString();

                              j++;
                          }

                      }


                  }
                  catch (Exception ex)
                  {

                      Console.WriteLine(ex);
                  }

                   s = reader["FUTURE_COURSE"].ToString();
                  // str = s;
                   cnt = conts(s);
                   pr = "";
                   j = 0;
                  try
                  {

                      for (int i = 0; i < cnt; i++)
                      {
                          pr = "";
                          while (j < s.Length)
                          {
                              if (s[j].ToString() == "&")
                              {
                                  stud_cor.Add(pr);
                                  //  L_PREFERED_CURRENT1.Items.Add(pr);
                                  //break;
                                  pr = "";
                                  j++;
                              }
                              pr += s[j].ToString();

                              j++;
                          }

                      }


                  }
                  catch (Exception ex)
                  {
                      Console.WriteLine(ex);
                  }

              }

              reader.Close();

              conn.Close();
          }
        void RebuildTableView()
          {
              string b = "";
            try
            {
                string a = Request.Cookies["userName"].Value;

                b = a.Substring(0, 3);
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex);
                b = "BEI";

            }
                if (b == "BEI")
                {

                    try
                    {


                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "select * from ATC";


                        SqlConnection conn = new SqlConnection(strConn);

                        SqlCommand cmd = new SqlCommand();

                        SqlDataReader reader;

                        cmd.Connection = conn;

                        cmd.CommandText = sqlQuery;

                        cmd.CommandType = CommandType.Text;

                        conn.Open();

                        reader = cmd.ExecuteReader();

                        int i = 0;

                        while (reader.Read())
                        {
                            string co = "";
                            
                                co = reader["course_offered"].ToString();
                            
                                    //  int a = co.CompareTo(stud_cor[x]);          // we can add 


                                    // reader["INST_NAME"].ToString();
                                    i = i + 7;
                                    MyDivTag.Attributes["style"] = String.Format("border-style: double; width: 1221px; height:{0}px; overflow:auto; z-index:55", i * 25);
                                    // add title (use a single column)
                                    TableRow tr = new TableRow();
                                    tr.Cells.Add(new TableCell());

                                    // change title color slightly
                                    tr.Cells[0].ForeColor = Color.Black;
                                    tr.Cells[0].Width = 400;
                                    //    string s = dr[3].ToString();
                                    //  s = s.Replace(" ", "%20");

                                    string s1 = reader["INST_NAME"].ToString();
                                    //s1 = s1.Replace(" ", "%20");
                                    //  make the text title big and purple
                                    tr.Cells[0].Text = "<a href=apply.aspx?instid=" + reader["INST_ID"].ToString() + "><FONT SIZE=6 COLOR=Black FACE=Rockwell><B>" + s1 + "</B></FONT>";
                                    this.BlogTable.Rows.Add(tr);

                                    // add blog in a single column and span 2 columns
                                    tr = new TableRow();

                                    tr.Cells.Add(new TableCell());
                                    tr.Cells[0].Width = 80;
                                    //tr.Cells[0].ColumnSpan = 2;
                                    tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                                    tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell> Email Id:- " + reader["INST_EMAIL"].ToString() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Institute type :- " + reader["INST_FIRM"].ToString() + "</br></br></Font>";

                                    this.BlogTable.Rows.Add(tr);

                                    // add user who posted and date (use two columns in the row)
                                    tr = new TableRow();
                                    /*  tr.Height = 50;
                                      tr.HorizontalAlign = HorizontalAlign.Left;
                                      tr.VerticalAlign = VerticalAlign.Bottom;
                                    tr.Cells.Add(new TableCell());
                                    tr.Cells[0].Width = 80;
                                    tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                                    // tr.Cells[0].ColumnSpan = 2;
                                    tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell> Institute type :- " + reader["INST_FIRM"].ToString() + "</Font>";
                                    this.BlogTable.Rows.Add(tr);
                                    tr = new TableRow();
                                      tr.Height = 50;
                                      tr.HorizontalAlign = HorizontalAlign.Left;
                                      tr.VerticalAlign = VerticalAlign.Bottom;*/
                                    tr.Cells.Add(new TableCell());
                                    tr.Cells[0].Width = 80;
                                    tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                                    // tr.Cells[0].ColumnSpan = 2;
                                    tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell>  course offered :- </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><em>" + co.Replace("&", "</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") + " </strong></em></Font>";
                                    this.BlogTable.Rows.Add(tr);
                                    /*  tr = new TableRow();

                                        tr.Cells.Add(new TableCell());
                                        tr.Cells[1].Width = 80;
                                        tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                                       // tr.Cells[1].ColumnSpan = 2;
                                        tr.Cells[1].Text = "PHONE NO.:- " + reader["INST_PHN"].ToString();
                                        this.BlogTable.Rows.Add(tr);
                                        tr = new TableRow();
                                        tr.Cells.Add(new TableCell());
                                        tr.Cells[0].Width = 200;
                                        tr.Cells[0].ColumnSpan = 2;
                                        tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                                        tr.Cells[0].Text = "INSTITUTE ADDRESS:- " + reader["INST_ADD"].ToString();
                                        this.BlogTable.Rows.Add(tr);
              
                                        tr = new TableRow();
               
                                        tr.Cells.Add(new TableCell());
                                        tr.Cells[0].ColumnSpan = 2;

                                        this.BlogTable.Rows.Add(tr);

                                        string imageFile = this.ResolveUrl(@".\image\separator.jpg");
                                        System.Web.UI.WebControls.Image separator = new System.Web.UI.WebControls.Image();
                                        separator.ImageUrl = imageFile;
                                        separator.Width = 700;
                                        separator.Height = 20;
                                        separator.Visible = true;

                                        tr.Cells[0].Controls.Add(separator);
                                        tr.Cells[0].HorizontalAlign = HorizontalAlign.Center;

                                       /* tr = new TableRow();
                                        tr.Height = 50;
                                        tr.HorizontalAlign = HorizontalAlign.Left;
                                        tr.VerticalAlign = VerticalAlign.Bottom;
                                        tr.Cells.Add(new TableCell());

                                        tr.Cells[0].HorizontalAlign = HorizontalAlign.Right;
                                        //   DateTime postTime = DateTime.Parse(dr[1].ToString());
                                        tr.Cells[0].Text = "xddx";
                                        tr.Cells.Add(new TableCell());



                                        tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                                        //   DateTime postTime = DateTime.Parse(dr[1].ToString());
                                        tr.Cells[1].Text = "nvtfe";
                                        this.BlogTable.Rows.Add(tr);*/
                                    


                        }



                        reader.Close();

                        conn.Close();
                        //string previousUser = "";  // track previous

                        // loop through each row in the data set and create
                        // the row on the web page in a web table

                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex);
                        Show("Problem in the data transfer , Please contact authorities");


                    }
                }
                else
                {

                    course();
                    try
                    {

                       
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "select * from ATC";

                       
                        SqlConnection conn = new SqlConnection(strConn);

                        SqlCommand cmd = new SqlCommand();

                        SqlDataReader reader;

                        cmd.Connection = conn;

                        cmd.CommandText = sqlQuery;

                        cmd.CommandType = CommandType.Text;

                        conn.Open();

                        reader = cmd.ExecuteReader();

                        int i = 0;

                        while (reader.Read())
                        {
                            string co="";
                            for (int x = 0; x < stud_cor.Count; x++)
                            {
                                co = "";
                                co = reader["course_offered"].ToString();
                                if (1==co.CompareTo(stud_cor[x]))
                                {

                                  //  int a = co.CompareTo(stud_cor[x]);          // we can add 
                              

                                // reader["INST_NAME"].ToString();
                                i = i + 7;
                            MyDivTag.Attributes["style"] = String.Format("border-style: double; width: 1221px; height:{0}px; overflow:auto; z-index:55", i * 25);
                            // add title (use a single column)
                            TableRow tr = new TableRow();
                            tr.Cells.Add(new TableCell());

                            // change title color slightly
                            tr.Cells[0].ForeColor = Color.Black;
                            tr.Cells[0].Width = 400;
                            //    string s = dr[3].ToString();
                            //  s = s.Replace(" ", "%20");

                            string s1 = reader["INST_NAME"].ToString();
                            //s1 = s1.Replace(" ", "%20");
                            //  make the text title big and purple
                            tr.Cells[0].Text = "<a href=apply.aspx?instid=" + reader["INST_ID"].ToString() + "><FONT SIZE=6 COLOR=Black FACE=Rockwell><B>" + s1 + "</B></FONT>";
                            this.BlogTable.Rows.Add(tr);

                            // add blog in a single column and span 2 columns
                            tr = new TableRow();

                            tr.Cells.Add(new TableCell());
                            tr.Cells[0].Width = 80;
                            //tr.Cells[0].ColumnSpan = 2;
                            tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                            tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell> Email Id:- " + reader["INST_EMAIL"].ToString() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Institute type :- " + reader["INST_FIRM"].ToString() + "</br></br></Font>";

                            this.BlogTable.Rows.Add(tr);

                            // add user who posted and date (use two columns in the row)
                            tr = new TableRow();
                            /*  tr.Height = 50;
                              tr.HorizontalAlign = HorizontalAlign.Left;
                              tr.VerticalAlign = VerticalAlign.Bottom;
                            tr.Cells.Add(new TableCell());
                            tr.Cells[0].Width = 80;
                            tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                            // tr.Cells[0].ColumnSpan = 2;
                            tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell> Institute type :- " + reader["INST_FIRM"].ToString() + "</Font>";
                            this.BlogTable.Rows.Add(tr);
                            tr = new TableRow();
                              tr.Height = 50;
                              tr.HorizontalAlign = HorizontalAlign.Left;
                              tr.VerticalAlign = VerticalAlign.Bottom;*/
                            tr.Cells.Add(new TableCell());
                            tr.Cells[0].Width = 80;
                            tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                            // tr.Cells[0].ColumnSpan = 2;
                            tr.Cells[0].Text = "<FONT SIZE=3 COLOR=Black FACE=Rockwell>  course offered :- </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><em>" + co.Replace("&", "</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") + " </strong></em></Font>";
                            this.BlogTable.Rows.Add(tr);
                            /*  tr = new TableRow();

                                tr.Cells.Add(new TableCell());
                                tr.Cells[1].Width = 80;
                                tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                               // tr.Cells[1].ColumnSpan = 2;
                                tr.Cells[1].Text = "PHONE NO.:- " + reader["INST_PHN"].ToString();
                                this.BlogTable.Rows.Add(tr);
                                tr = new TableRow();
                                tr.Cells.Add(new TableCell());
                                tr.Cells[0].Width = 200;
                                tr.Cells[0].ColumnSpan = 2;
                                tr.Cells[0].HorizontalAlign = HorizontalAlign.Left;
                                tr.Cells[0].Text = "INSTITUTE ADDRESS:- " + reader["INST_ADD"].ToString();
                                this.BlogTable.Rows.Add(tr);
              
                                tr = new TableRow();
               
                                tr.Cells.Add(new TableCell());
                                tr.Cells[0].ColumnSpan = 2;

                                this.BlogTable.Rows.Add(tr);

                                string imageFile = this.ResolveUrl(@".\image\separator.jpg");
                                System.Web.UI.WebControls.Image separator = new System.Web.UI.WebControls.Image();
                                separator.ImageUrl = imageFile;
                                separator.Width = 700;
                                separator.Height = 20;
                                separator.Visible = true;

                                tr.Cells[0].Controls.Add(separator);
                                tr.Cells[0].HorizontalAlign = HorizontalAlign.Center;

                               /* tr = new TableRow();
                                tr.Height = 50;
                                tr.HorizontalAlign = HorizontalAlign.Left;
                                tr.VerticalAlign = VerticalAlign.Bottom;
                                tr.Cells.Add(new TableCell());

                                tr.Cells[0].HorizontalAlign = HorizontalAlign.Right;
                                //   DateTime postTime = DateTime.Parse(dr[1].ToString());
                                tr.Cells[0].Text = "xddx";
                                tr.Cells.Add(new TableCell());



                                tr.Cells[1].HorizontalAlign = HorizontalAlign.Right;
                                //   DateTime postTime = DateTime.Parse(dr[1].ToString());
                                tr.Cells[1].Text = "nvtfe";
                                this.BlogTable.Rows.Add(tr);*/
                            break;
                                }

                            }


                        }



                        reader.Close();

                        conn.Close();
                        //string previousUser = "";  // track previous

                        // loop through each row in the data set and create
                        // the row on the web page in a web table

                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex);
                        Show("Problem in the data transfer , Please contact authorities");


                    }
                }
        }

    }
}