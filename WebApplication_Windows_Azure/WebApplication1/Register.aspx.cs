
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
    public partial class Register : System.Web.UI.Page
    {
        public String x;
        public string pw;
        public int sr;
        
        protected void Page_Load(object sender, EventArgs e)
        {
            pw = GeneratePassword();
            inst_id();

        }
        public void SEND()
        {
            try
            {
                string s3 = "Dear user,\r\nYou have successfully registered in our system.\r\n\r\nYour Username =" + Inst_id.Text + "\r\n\r\nYour Password = " + pw + "\r\n\r\n           Thank You for registration";
                //Below I mention From id(Gmail), To mail ID, Subject of the mail, Mail Message
                //Email_id.Text = "vikram_ghadge@yahoo.com";
                MailMessage msg = new MailMessage("thoughtbeat4@gmail.com", EMAIL_ID.Text, "NEW Registratoion", s3);
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
        protected void Button2_Click(object sender, EventArgs e)
        {

     
         try
         {
             insert();
             SEND();
             ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert(' DONE. PLEASE CHECK YOUR EMAIL ACCOUNT');", true);
             NAME_ORG.Text = "";
             EMAIL_ID.Text = "";
             PHN_ORG.Text = "";
             TYP_ORG.Text = "";
             pw = GeneratePassword();
             inst_id();
             
         }
         catch (SqlException ex)
         {
             Console.WriteLine(ex);
             Show("Problem in the data transfer , Please contact authorities");

         }
       
        }

        public void select()
        {
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from SIGN_UP";

            SqlConnection conn = new SqlConnection(strConn);

            SqlCommand cmd = new SqlCommand();

            SqlDataReader reader;

            cmd.Connection = conn;

            cmd.CommandText = sqlQuery;

            cmd.CommandType = CommandType.Text;

            conn.Open();

            reader = cmd.ExecuteReader();



            while (reader.Read())
            {



               NAME_ORG.Text = reader["INST_NAME"].ToString();
                EMAIL_ID.Text = reader["INST_EMAIL"].ToString();
               PHN_ORG.Text = reader["INST_PHN"].ToString();
                TYP_ORG.Text = reader["INST_TYPE"].ToString();
            }



            reader.Close();

            conn.Close();

        }

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
         public void insert()
        {
           String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            SqlConnection conn = new SqlConnection(strConn);

            SqlCommand cmd = new SqlCommand();

            cmd.Connection = conn;
            // sr='1';

            string strQuery = "Insert into SIGN_UP values ('" + sr + "','" + Inst_id.Text + "','" + NAME_ORG.Text + "','" + EMAIL_ID.Text + "','" + PHN_ORG.Text + "','" + TYP_ORG.Text + "','" + pw + "')";

            cmd.CommandText = strQuery;

            cmd.CommandType = CommandType.Text;

         

                conn.Open();

                cmd.ExecuteNonQuery();
          
           
              conn.Close();


        }
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
         public void UPDATE()
         {
             // Define ADO.NET objects.
             String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;



             //SqlConnection conn = new SqlConnection(strConn);
             string updateSQL;
             updateSQL = "UPDATE SIGN_UP SET ";
             updateSQL += "INST_NAME=@Org_name, INST_EMAIL=@Org_email,INST_PHN=@Org_ph,INST_TYPE=@Org_type ";
             updateSQL += "WHERE INST_ID='abc12'";
             SqlConnection con = new SqlConnection(strConn);
             SqlCommand cmd = new SqlCommand(updateSQL, con);
             // Add the parameters.
             cmd.Parameters.AddWithValue("@Org_name", NAME_ORG.Text);
             cmd.Parameters.AddWithValue("@Org_email", EMAIL_ID.Text);
             cmd.Parameters.AddWithValue("@Org_ph", PHN_ORG.Text);
             cmd.Parameters.AddWithValue("@Org_type", TYP_ORG.Text);

             // Try to open database and execute the update.
             int updated = 0;
             con.Open();
             updated = cmd.ExecuteNonQuery();


             con.Close();
         }

         protected void Button3_Click(object sender, EventArgs e)
         {
             UPDATE();
         }
         int M;
         public void inst_id()
         {
             
             String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;
             String query = "select SR_NO from SIGN_UP;";
             SqlConnection conn = new SqlConnection(strConn);
             SqlCommand cmd = new SqlCommand();
             SqlDataReader reader;
             cmd.Connection = conn;
            cmd.CommandText = query;
             cmd.CommandType = CommandType.Text;
             conn.Open();
             reader = cmd.ExecuteReader();
             int x = -1;
             while(reader.Read())
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
                 M = 1000 + sr;
             }
             else
             {
                 M = 1000;
                 sr = 0;

             }
              reader.Close();

             conn.Close();
             
             Inst_id.Text = "BEI" + M;
            
         }


         public string X { get; set; }
    }
}
    




       