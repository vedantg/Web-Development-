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
using System.Net;
using System.Net.Mail;
namespace WebApplication1
{
    public partial class apply : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            warning.Visible = false;
            if (Request.QueryString["instid"] == null)
            {
                Response.Redirect("information.aspx");

            }
            else
            {
                select();

            }
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

       
        public void select()
        {
            try
                        {
                        
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from ATC where INST_ID  ='" + Request.QueryString["instid"] + "'";

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



                inst_name.Text = reader["INST_NAME"].ToString();
                cont_no.Text = reader["INST_PHN"].ToString();
                email.Text = reader["INST_EMAIL"].ToString();
                addrs.Text = reader["INST_ADD"].ToString();
            }



            reader.Close();

            conn.Close();
                        }
            catch (SqlException ex)
            {
                Console.WriteLine(ex);
                Show("Problem in the data transfer , Please contact authorities");

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
        string s3 = "";
        protected void Button1_Click(object sender, EventArgs e)
        {
           
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {


                string a = Request.Cookies["userName"].Value;
                string b = a.Substring(0, 3);

                if (b == "BES")
                {

                    try
                    {
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "select * from STUDENT where STUD_ID  ='" + Request.Cookies["userName"].Value + "'";

                        SqlConnection conn = new SqlConnection(strConn);

                        SqlCommand cmd = new SqlCommand();

                        SqlDataReader reader;

                        cmd.Connection = conn;

                        cmd.CommandText = sqlQuery;

                        cmd.CommandType = CommandType.Text;

                        conn.Open();

                        reader = cmd.ExecuteReader();


                        string s1 = "";
                        string v = "";
                        if (reader.Read())
                        {
                            string s = reader["CURRENT_COURSE"].ToString();
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
                                            s1 += " "+pr;
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
                                            v += pr;
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
                            s3 = "Dear User,\r\nYou have one applicant for your institute and we are\r\nsending you his basic information.\r\n\r\nApplicant Name:-" + reader["FIRST_NAME"].ToString() + " " + reader["LAST_NAME"].ToString() + "\r\nemail :-" + reader["STUD_EMAIL"].ToString() + " \r\nphn no :- " + reader["PH_NO"].ToString() + "\r\nCurrent Applied Courses:- " + s1 + "\r\nCourses Prefferd in Future:- " + v;
                            // s3 = "Dear User,\r\nYou have one applicant for your institute and we are\r\nsending you his basic information.\r\n\r\nApplicant Name:- vedant\r\nemail :- vedu16\r\nphn no :- 1323546\r\napplied course:- c cpp";
                            sendMail(email.Text);
                            s3 = "Dear User,\r\nYou have applied for " + inst_name.Text + ".\r\nwe are sending your basic information.\r\n\r\n\r\nemail :-" + email.Text+ " \r\nphn no :- " + cont_no.Text ;
                            sendMail(reader["STUD_EMAIL"].ToString());
                            //Show("APPLIED SUCCESSFULLY");
                            warning.Visible = true;
                         
                        }

                        //Show("APPLIED SUCCESSFULLY");

                        reader.Close();

                        conn.Close();
                    }
                    catch (SqlException ex)
                    {
                        Console.WriteLine(ex);
                        Show("Problem in the data transfer , Please contact authorities");

                    }
                }
                else
                {
                    Show("Sorry we cant procced , You are not login as student please login as student");
                }
            }
            else
            {
                Show("Sorry we cant procced , You must login First");
            }
        }
        void sendMail(string mail)
        {
            try
            {
                //Below I mention From id(Gmail), To mail ID, Subject of the mail, Mail Message
                MailMessage msg = new MailMessage("thoughtbeat4@gmail.com", mail, "NEW APPLICANT", s3);
                SmtpClient mailClient = new SmtpClient("smtp.gmail.com", 587);
                //Change your gmail user id and password for send email
                NetworkCredential NetCrd = new NetworkCredential("thoughtbeat4@gmail.com", "beproject");
                mailClient.UseDefaultCredentials = false;
                mailClient.Credentials = NetCrd;
                mailClient.EnableSsl = true;
                mailClient.DeliveryMethod = SmtpDeliveryMethod.Network;
                mailClient.Send(msg);
                //Show("");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Show("Problem in the sending email  , Please Check Internet Connection on Your machine");
            }
            
        }

        protected void AdRotator1_AdCreated(object sender, AdCreatedEventArgs e)
        {

        }        
    }
}