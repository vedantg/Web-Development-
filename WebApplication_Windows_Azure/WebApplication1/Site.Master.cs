using System;
using System.Data;
using System.Configuration;
using System.Web.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;

namespace WebApplication1
{
    
        /// <summary> 
        /// Shows a client-side JavaScript alert in the browser. 
        /// </summary> 
        /// <param name="message">The message to appear in the alert.</param> 
       
    
    public partial class SiteMaster : System.Web.UI.MasterPage
    {
        public  void Show(string message)
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
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {
              //  wel_nm.Text = Server.HtmlEncode(Request.Cookies["userName"].Value);
                Panel2.Visible = false;
                CheckBox1.Visible = false;

            }
            else
            {
                Panel1.Visible = false;

            }
        }
        public void ck1()
        {
            Response.Cookies["userName"].Value = Login2.UserName;
            Response.Cookies["userName"].Expires = DateTime.Now.AddYears(3);

            HttpCookie aCookie = new HttpCookie("lastVisit");
            aCookie.Value = DateTime.Now.ToString();
            aCookie.Expires = DateTime.Now.AddYears(3);
            Response.Cookies.Add(aCookie);
            Response.Cookies["password"].Value = Login2.Password;
            Response.Cookies["password"].Expires = DateTime.Now.AddYears(3);

            HttpCookie aCookie1 = new HttpCookie("lastVisit");
            aCookie1.Value = DateTime.Now.ToString();
            aCookie1.Expires = DateTime.Now.AddYears(3);
            Response.Cookies.Add(aCookie1);

        }

        public void ck()
        {
            Response.Cookies["userName"].Value = Login2.UserName;
            Response.Cookies["userName"].Expires = DateTime.Now.AddHours(5);

            HttpCookie aCookie = new HttpCookie("lastVisit");
            aCookie.Value = DateTime.Now.ToString();
            aCookie.Expires = DateTime.Now.AddHours(5);
            Response.Cookies.Add(aCookie);
            Response.Cookies["password"].Value = Login2.Password;
            Response.Cookies["password"].Expires = DateTime.Now.AddHours(5);

            HttpCookie aCookie1 = new HttpCookie("lastVisit");
            aCookie1.Value = DateTime.Now.ToString();
            aCookie1.Expires = DateTime.Now.AddHours(5);
            Response.Cookies.Add(aCookie1);

        }


        protected void Button1_Click(object sender, EventArgs e)
        {
            HttpCookie aCookie;
            string cookieName;
            int limit = Request.Cookies.Count;
            for (int i = 0; i < limit; i++)
            {
                cookieName = Request.Cookies[i].Name;
                aCookie = new HttpCookie(cookieName);
                aCookie.Expires = DateTime.Now.AddDays(-1);
                Response.Cookies.Add(aCookie);


            }
            Panel2.Visible = true;
         
            CheckBox1.Visible = true;
            Panel1.Visible = false;
            Response.Redirect("Default.aspx");
        }

        protected void LoginButton_Click(object sender, EventArgs e)
        {


        }
      
        protected void Button2_Click(object sender, EventArgs e)
        {
            try
            {

                string a = Login2.UserName;
                int x = a.Length;
                if (x >= 3)
                {
                    string b = a.Substring(0, 3);

                    if (b == "BEI")
                    {
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "SELECT PASSWORD,ORG_NAME FROM SIGN_UP where INST_ID='" + Login2.UserName + "'";

                        SqlConnection conn = new SqlConnection(strConn);

                        SqlCommand cmd = new SqlCommand();

                        SqlDataReader reader;

                        cmd.Connection = conn;

                        cmd.CommandText = sqlQuery;

                        cmd.CommandType = CommandType.Text;

                        conn.Open();

                        reader = cmd.ExecuteReader();
                        String s1 = "";
                        String s2 = "";

                        if (reader.Read())
                        {
                            s1 = reader["password"].ToString();
                            s2 = reader["ORG_NAME"].ToString();

                            CheckBox1.Checked = true;

                            if (s1 == Login2.Password)
                            {
                                if (CheckBox1.Checked == true)
                                {
                                    ck1();
                                }
                                else
                                {
                                    ck1();
                                    HttpCookie aCookie;
                                    string cookieName;
                                    int limit = Request.Cookies.Count;
                                    for (int i = 0; i < limit; i++)
                                    {
                                        cookieName = Request.Cookies[i].Name;
                                        aCookie = new HttpCookie(cookieName);
                                        aCookie.Expires = DateTime.Now.AddDays(-1);
                                        Response.Cookies.Add(aCookie);
                                    }


                                    ck();
                                }

                                //  Label3.Text = "INSTITUTE";
                                Response.Redirect("Default.aspx");
                            }

                            else
                            {
                                Show("INVALID PASSWORD");
                            }


                        }
                        else
                        {
                            Show("PLEASE REGISTER WITH OUR SITE..!!");
                        }




                    }
                    else if (b == "BES")
                    {
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "SELECT STUD_PW,FIRST_NAME FROM STUDENT where STUD_ID='" + Login2.UserName + "'";

                        SqlConnection conn = new SqlConnection(strConn);

                        SqlCommand cmd = new SqlCommand();

                        SqlDataReader reader;

                        cmd.Connection = conn;

                        cmd.CommandText = sqlQuery;

                        cmd.CommandType = CommandType.Text;


                        conn.Open();

                        reader = cmd.ExecuteReader();
                        String s1 = "";
                        String s2 = "";

                        if (reader.Read())
                        {
                            s1 = reader["STUD_PW"].ToString();
                            s2 = reader["FIRST_NAME"].ToString();

                            CheckBox1.Checked = true;

                            if (s1 == Login2.Password)
                            {
                                if (CheckBox1.Checked == true)
                                {
                                    ck1();
                                }
                                else
                                {
                                    ck1();
                                    HttpCookie aCookie;
                                    string cookieName;
                                    int limit = Request.Cookies.Count;
                                    for (int i = 0; i < limit; i++)
                                    {
                                        cookieName = Request.Cookies[i].Name;
                                        aCookie = new HttpCookie(cookieName);
                                        aCookie.Expires = DateTime.Now.AddDays(-1);
                                        Response.Cookies.Add(aCookie);
                                    }


                                    ck();
                                }

                                //Label3.Text = "STUDENT";
                                Response.Redirect("ACCOUNT.aspx");
                            }
                            else
                            {
                                Show("INVALID PASSWORD");
                            }

                        }
                        else
                        {
                            Show("PLEASE REGISTER WITH OUR SITE..!!");
                        }

                        // wel_nm.Text = s2;


                    }
                    else
                    {
                        Show("PLEASE REGISTER WITH OUR SITE..!!");
                    }

                }
                else
                {
                    Show("PLEASE REGISTER WITH OUR SITE..!!");
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Show("Problem in the data transfer , Please contact authorities");
            }
        }

        protected void chng_pw_Click(object sender, EventArgs e)
        {
            Response.Redirect("chng_pw.aspx");
        }
    }
}
