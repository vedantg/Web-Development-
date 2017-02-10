using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;

using System.Data;
using System.Configuration;
using System.Web.Configuration;
using System.Collections;

using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Net;
using System.Net.Mail;
using System.Collections.Generic;

namespace WebApplication1
{
    /// <summary>
    /// Summary description for ext
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ext : System.Web.Services.WebService
    {
        ArrayList stud_cor = new ArrayList();
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }
        public string inst_name = "", cont_no = "", email = "", addrs = "", inst_us = "", stud_us = "";

        public void select()
        {
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from ATC where INST_ID  ='" + inst_us + "'";

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



                inst_name = reader["INST_NAME"].ToString();
                cont_no = reader["INST_PHN"].ToString();
                email = reader["INST_EMAIL"].ToString();
                addrs = reader["INST_ADD"].ToString();
            }



            reader.Close();

            conn.Close();




        }
        [WebMethod]
        public string mail(string username1, string username2)
        {
            inst_us = username2;
            select();
            try
            {

                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                string sqlQuery = "select * from STUDENT where STUD_ID  ='" + username1 + "'";

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
                                    s1 += " " + pr;
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
                    sendMail(email);
                    s3 = "Dear User,\r\nYou have applied for " + inst_name + ".\r\nwe are sending your basic information.\r\n\r\n\r\nemail :-" + email + " \r\nphn no :- " + cont_no;
                    sendMail(reader["STUD_EMAIL"].ToString());
                    //Show("APPLIED SUCCESSFULLY");



                }

                //Show("APPLIED SUCCESSFULLY");

                reader.Close();

                conn.Close();
                return "send";
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                return "error";
            }
        }

        public string s3 = "";
        void sendMail(string mail)
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
        [WebMethod]
        public string login(string username, string password)
        {
            string s = "";
            if (username != "" && password != "")
            {
                try
                {
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                    string sqlQuery = "select * from STUDENT where STUD_ID='" + username + "'";

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


                        if (password == reader["STUD_PW"].ToString())
                        {
                            s = "LS";
                        }

                        else
                        {
                            s = "PI";
                        }


                    }
                    else
                    {
                        s = "BI";
                    }




                    reader.Close();
                    //string s = "kk";
                    conn.Close();
                }
                catch (SqlException ex)
                {
                    Console.WriteLine(ex);
                    s = "EXCEPTION";

                }
            }
            else
            {
                s = "PFD";
            }
            return s;
        }
        public class BlogData
        {
            public string blogID;
            public string blogTitle;
            public string blogPostID;
            public string blogPostContent;
            public string blogPostTime;
            public string commentID;
            public string commentContent;
            public string commentTime;
        }
        BlogData b = new BlogData();
        [WebMethod]
        public string Subtract(int x, int y)
        {
            List<string> info = new List<string>();
       


            info.Add("vik");
            info.Add("vik");
            info.Add("vik");
            return "aa";
        }

        [WebMethod]
        public List<string> home(string username)
        {
            List<string> info = new List<string>();


            try
            {
                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                string sqlQuery = "select * from STUDENT where STUD_ID='" + username + "'";

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


                    info.Add(reader["FIRST_NAME"].ToString());
                    info.Add(reader["LAST_NAME"].ToString());
                    info.Add(reader["CURRENT_COURSE"].ToString());
                    info.Add(reader["FUTURE_COURSE"].ToString());


                }




                reader.Close();
                conn.Close();
            }
            catch (SqlException ex)
 {
     Console.WriteLine(ex);
                info.Add("EXCEPTION");
            }


            return info;
        }
        string s11 = "";
        [WebMethod]
        public List<string> alerts(string username, string course)
        {
            s11 = username;
            List<string> info = new List<string>();


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

                    co = "";
                    co = reader["course_offered"].ToString();

                    string s = reader["course_offered"].ToString();
                    // str = s;
                    int cnt = conts(s);
                    string pr = "";
                    int j = 0;
                    try
                    {

                        for (i = 0; i < cnt; i++)
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



                    for (int x = 0; x < stud_cor.Count; x++)
                    {


                        int v = String.Compare(course, stud_cor[x].ToString());

                        if (0 == v)
                        {
                            info.Add(reader["INST_NAME"].ToString());
                            info.Add(reader["INST_PHN"].ToString());
                            info.Add(reader["INST_ID"].ToString());
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
                //  Show("Problem in the data transfer , Please contact authorities");


            }


            return info;
        }


        [WebMethod]
        public List<string> Institute(string username)
        {
            s11 = username;
            List<string> info = new List<string>();


            try
            {


                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                string sqlQuery = "select * from ATC where INST_ID='" + username + "'";


                SqlConnection conn = new SqlConnection(strConn);

                SqlCommand cmd = new SqlCommand();

                SqlDataReader reader;

                cmd.Connection = conn;

                cmd.CommandText = sqlQuery;

                cmd.CommandType = CommandType.Text;

                conn.Open();

                reader = cmd.ExecuteReader();

               // int i = 0;
                if (reader.Read())
                {
                    info.Add(reader["INST_NAME"].ToString());
                    info.Add(reader["INST_ADD"].ToString());
                    info.Add(reader["INST_EMAIL"].ToString());
                    info.Add(reader["INST_PHN"].ToString());
                    info.Add(reader["course_offered"].ToString());

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
                //  Show("Problem in the data transfer , Please contact authorities");


            }


            return info;
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

    }
}
