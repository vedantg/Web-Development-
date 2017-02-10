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
    public partial class REGSTD : System.Web.UI.Page
    {
        public string V;
        public void SEND()
        {
            try
            {
                string s3 = "Dear user,\r\nYou have successfully registered in our system.\r\n\r\nYour Username ="+V+ "\r\n\r\nYour Password = "+ pw+"\r\n\r\n           Thank You for registration";
                //Below I mention From id(Gmail), To mail ID, Subject of the mail, Mail Message
                //Email_id.Text = "vikram_ghadge@yahoo.com";
                MailMessage msg = new MailMessage("thoughtbeat4@gmail.com", Email_id.Text, "NEW Registratoion", s3);
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
        protected void Page_Load(object sender, EventArgs e)
        {
            V = std_id();

            L_PREFERED_CURRENT.Items.Add("C / C++");
            L_PREFERED_CURRENT.Items.Add("JAVA");
            L_PREFERED_CURRENT.Items.Add("ADVANCED JAVA");
            L_PREFERED_CURRENT.Items.Add("VISUAL BASICS");
            L_PREFERED_CURRENT.Items.Add("ASP.NET");
            L_PREFERED_CURRENT.Items.Add("ORACLE");
            L_PREFERED_CURRENT.Items.Add("M1 / M2 / M3");
            L_PREFERED_CURRENT.Items.Add("GRAPHICS");
            L_PREFERED_CURRENT.Items.Add("MECHANICS");
            L_PREFERED_CURRENT.Items.Add("MD-1 / MD-2 ");
            L_PREFERED_CURRENT.Items.Add("SOM");
            L_PREFERED_CURRENT.Items.Add("TOM");
            L_PREFERED_CURRENT.Items.Add("DOM");

        }

     /*   protected void Button1_Click(object sender, EventArgs e)
        {
           
        -*/
        private string GeneratePassword()
        {
            string strPwdchar = "abcdefghijklmnopqrstuvwxyz0123456789#+@&$ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            string strPwd = "";
            Random rnd = new Random();
            for (int i = 0; i <= 7; i++)
            {
                int iRandom = rnd.Next(0, strPwdchar.Length - 1);
                strPwd += strPwdchar.Substring(iRandom, 1);
            }
            return strPwd;
        }


        public int sr, M;
        public string cur, fut;

        public string std_id()
        {
            string STR;
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;
            String query = "select SR_NO from STUDENT";
                        SqlConnection conn = new SqlConnection(strConn);
            SqlCommand cmd = new SqlCommand();
            SqlDataReader reader;
            cmd.Connection = conn;
            cmd.CommandText = query;
            cmd.CommandType = CommandType.Text;
            conn.Open();
            reader = cmd.ExecuteReader();
            int x = -1;
            while (reader.Read())
            {
                int y = Convert.ToInt32(reader["SR_NO"].ToString());

                if (y > x)
                {
                    x = y;
                }

            }
                if (x!=-1)
                {
                   
                   
                    sr = x + 1;
                    M = 5000 + sr;
                }
                else
                {
                    M = 5000;
                    sr = 0;

                }
           
            reader.Close();

            conn.Close();

            stud_id.Text = "BES" + M;
            STR = "BES" + M;
            return STR;

        }

        public void mult_list()
        {
            cur = "";
            fut = "";
            for (int i = 0; i < L_PREFERED_CURRENT.Items.Count; i++)
            {
                if (L_PREFERED_CURRENT.Items[i].Selected == true)
                {
                    cur += L_PREFERED_CURRENT.Items[i].Value + "&";
                }
            }
            for (int i = 0; i < future_course.Items.Count; i++)
            {
                if (future_course.Items[i].Selected == true)
                {
                    fut += future_course.Items[i].Value + "&";
                }
            }

        }
        public string pw;
        public void insert()
        {
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            SqlConnection conn = new SqlConnection(strConn);

            SqlCommand cmd = new SqlCommand();

            cmd.Connection = conn;
            pw = GeneratePassword();
            string strQuery = "Insert into STUDENT values ('" + V + "','" + pw  + "','" + first_nm.Text + "','" + mid_nm.Text + "','" + last_nm.Text + "','" + clg_nm.Text + "','" + addr.Text + "','" + Ph_no.Text + "','" + Email_id.Text + "','" + drop_stream.Text + "','" + cur + "','" + fut + "','" + area_interest_textbox.Text + "','" + sr + "','" + drop_degree.Text + "')";

            cmd.CommandText = strQuery;

            cmd.CommandType = CommandType.Text;


            conn.Open();

            cmd.ExecuteNonQuery();

            conn.Close();
        

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
        protected void Button2_Click(object sender, EventArgs e)
        {
             mult_list();
           
             try
             {
                insert();
                 SEND();
                 first_nm.Text = "";
                 mid_nm.Text = "";
                 last_nm.Text = "";
                 clg_nm.Text = "";
                 addr.Text = "";
                 Ph_no.Text = "";
                 Email_id.Text = "";
                 //drop_stream.Text = "";
                 //L_PREFERED_CURRENT.Text = "";
                 //future_course.Text = "";
                 area_interest_textbox.Text = "";
                 //drop_degree.Text = "";
                 ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert('DONE. PLEASE CHECK YOUR EMAIL ACCOUNT');", true);
                 
                 Page_Load(null,null);
             }
             catch (SqlException ex)
             {
                 Console.WriteLine(ex);
                 Show("Problem in the data transfer , Please contact authorities");

             }
           
        }

        }

       

       
    }
