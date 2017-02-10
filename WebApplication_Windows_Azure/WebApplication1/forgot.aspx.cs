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
    public partial class forgot : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

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
        public void SEND()
        {
   
            try
            {
                string s3 = "Dear User,\r\n\r\nYou are requested us for sending email about your Login failure .\r\n\r\nYour Information is,\r\n\r\nUsername =" + username.Text + "\r\nPassword =" + pw + "\r\n\r\nIf you cant login further then please contact autheroties for further details";
                //Below I mention From id(Gmail), To mail ID, Subject of the mail, Mail Message
                //Email_id.Text = "vikram_ghadge@yahoo.com";
                MailMessage msg = new MailMessage("thoughtbeat4@gmail.com", em, "Forgot Password", s3);
                SmtpClient mailClient = new SmtpClient("smtp.gmail.com", 587);
                //Change your gmail user id and password for send email
                NetworkCredential NetCrd = new NetworkCredential("thoughtbeat4@gmail.com", "beproject");
                mailClient.UseDefaultCredentials = false;
                mailClient.Credentials = NetCrd;
                mailClient.EnableSsl = true;
                mailClient.DeliveryMethod = SmtpDeliveryMethod.Network;
                mailClient.Send(msg);

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Show("Problem in the sending email  , Please Check Internet Connection on Your machine");
            }

        }
        string pw = "";
        string em = "";
        protected void Button2_Click(object sender, EventArgs e)
        {
            string a = username.Text;
            string b = a.Substring(0, 3);

            if (b == "BEI")
            {
                try
                {
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                    string sqlQuery = "select * from SIGN_UP where Inst_ID='" + username.Text + "'";

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
                        pw = reader["PASSWORD"].ToString();
                        //Add_org0.Text = reader["INST_ADD"].ToString();*/
                        em = reader["Org_email"].ToString();
                        if (em == email.Text)
                        {
                            SEND();
                        }
                        else
                        {
                            Show("Your Email and UserName is not validate , please enter correct information");

                        }

                    }
                    else
                    {
                        Show("Your Email and UserName is not validate , please enter correct information");

                    }

                    reader.Close();

                    conn.Close();
                    email.Text = "";
                    username.Text = "";

                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex);
                    Show("Problem in the data transfer , Please contact authorities");


                }
            }
            else
            {
                try
                {
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                    string sqlQuery = "select * from STUDENT where STUD_ID='" + username.Text + "'";

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
                        pw = reader["STUD_PW"].ToString();
                        //Add_org0.Text = reader["INST_ADD"].ToString();*/
                        em = reader["STUD_EMAIL"].ToString();
                        if (em == email.Text)
                        {
                            SEND();
                        }
                        else
                        {
                            Show("Your Email and UserName is not validate , please enter correct information");

                        }

                    }
                    else
                    {
                        Show("Your Email and UserName is not validate , please enter correct information");

                    }

                    reader.Close();

                    conn.Close();
                    email.Text = "";
                    username.Text = "";

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