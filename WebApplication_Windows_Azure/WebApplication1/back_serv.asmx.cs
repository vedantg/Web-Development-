
using System.Linq;

using System.Web.Services;
using System.Web.Services.Protocols;
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
using System.Collections.Generic;

namespace WebApplication1
{
    /// <summary>
    /// Summary description for back_serv
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class back_serv : System.Web.Services.WebService
    {
        public string s2;
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }
        [WebMethod]
        public DataSet SQLBranchMaster( string flag)
        {
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "SELECT        ID AS User_Identity, Name, Email_Id AS Email, level_authority AS Level_of_authority, ph_no AS Phone_number FROM back_worker WHERE        (flag = '" + flag + "')";

            SqlConnection conn = new SqlConnection(strConn);

            SqlCommand cmd = new SqlCommand();

          

            cmd.Connection = conn;

            cmd.CommandText = sqlQuery;

            cmd.CommandType = CommandType.Text;

            conn.Open();

            SqlDataAdapter adapt = new SqlDataAdapter(sqlQuery, conn);
            DataSet ds = new DataSet();
            adapt.Fill(ds);
            conn.Close();
            return ds;

        }
        [WebMethod]
        public string name(string id)
        {
            string cert = "";
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from back_worker where ID='"+id+"'";

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

                cert = reader["Name"].ToString();



            }



            reader.Close();

            conn.Close();

            return cert;
        }

        ArrayList stud_cor = new ArrayList();
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
        [WebMethod]
        public List<string> inst()
        {
           
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

              //  int i = 0;

                while (reader.Read())
                {
                    int v = String.Compare("NO", reader["STATUS"].ToString());

                    if (v == 0)
                    {

                        info.Add(reader["INST_NAME"].ToString());
                        // info.Add(reader["INST_PHN"].ToString());
                        info.Add(reader["INST_ID"].ToString());
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
        public string reject(string id)
        {

            string s = "NO";
            try
            {
                
                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                SqlConnection conn = new SqlConnection(strConn);

                SqlCommand cmd = new SqlCommand();

                cmd.Connection = conn;
                // sr='1';ce

                string strQuery = "DELETE FROM ATC WHERE INST_ID='"+id +"'";

                //string strQuery = "Insert into back_worker(Name, ID) values (' " + nm + "','" + id + "','" + level + "','" + phone + "','" + email + "',@Content,@vik,'" + flag + "','" + cert("01") + "')";
                cmd.CommandText = strQuery;

                cmd.CommandType = CommandType.Text;

                conn.Open();

                cmd.ExecuteNonQuery();
                s = "yes";

                conn.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                s = "exception";
            }
            return s;
        }
        [WebMethod]
        public string issue(string id, string emp_id, Byte[] thumb1)
        {
            string s = "NO";

            try
            {
                // Define ADO.NET objects.
                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;



                //SqlConnection conn = new SqlConnection(strConn);
                string updateSQL;
                updateSQL = "UPDATE ATC SET ";
                updateSQL += "STATUS=@Org_name,emp_ID=@Org_name1,cert=@Content ";
                updateSQL += "WHERE INST_ID='" + id + "'";
                SqlConnection con = new SqlConnection(strConn);
                SqlCommand cmd = new SqlCommand(updateSQL, con);
                // Add the parameters.

                cmd.Parameters.AddWithValue("@Org_name", "YES");

                cmd.Parameters.AddWithValue("@Org_name1", emp_id);

                SqlParameter param = cmd.Parameters.Add("@Content", SqlDbType.VarBinary);
                param.Value = thumb1;

                // Try to open database and execute the update.
                int updated = 0;
                con.Open();
                updated = cmd.ExecuteNonQuery();

                Int32 i = updated;
                s = "yes";


                con.Close();
            }
            catch (SqlException ex)
            {
                Console.WriteLine(ex);
                return "exception";
            }
            return s;


        }

        [WebMethod]
        public string cert(string id)
        {
            string cert = "";
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from back_worker where ID='01'";

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

                cert = reader["cert"].ToString();



            }



            reader.Close();

            conn.Close();

            return cert;
        }

        [WebMethod]
        public Byte[] login(string id, int a,string t)
        {
            byte[] raw = new Byte[260 * 300];
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "SELECT * FROM     back_worker WHERE  (ID = '"+id+"') AND (flag = '"+a+"')";

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
                if (Int32.Parse(t)==1)
                {
                    raw = (byte[])reader["Img_first"];
                }
                else if (Int32.Parse(t) == 0)
                {
                    raw = (byte[])reader["Img_Second"];
                }

            }



            reader.Close();

            conn.Close();

            return raw;
        }

        [WebMethod]
        public string rgst_work(string id, string nm, string level, string phone, string email, Byte[] thumb1, Byte[] thumb2,string flag)
        {
            string s = "NO";
            try
            {
                

                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                SqlConnection conn = new SqlConnection(strConn);

                SqlCommand cmd = new SqlCommand();

                cmd.Connection = conn;
                // sr='1';ce
                
                string strQuery = "Insert into back_worker values (' " + nm + "','" + id + "','" + level + "','" + phone + "','" + email + "',@Content,@vik,'" + flag + "','vik')";

                //string strQuery = "Insert into back_worker(Name, ID) values (' " + nm + "','" + id + "','" + level + "','" + phone + "','" + email + "',@Content,@vik,'" + flag + "','" + cert("01") + "')";
                cmd.CommandText = strQuery;

                cmd.CommandType = CommandType.Text;

                SqlParameter param = cmd.Parameters.Add("@Content", SqlDbType.VarBinary);
                param.Value = thumb1;

                SqlParameter vik = cmd.Parameters.Add("@vik", SqlDbType.VarBinary);
                vik.Value = thumb2;

                conn.Open();

                cmd.ExecuteNonQuery();
                s = "yes";

                conn.Close();
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex);
                s = "exception";
            }
            
            return s;
        }
        static byte[] GetBytes(string str)
        {
            byte[] bytes = new byte[str.Length * sizeof(char)];
            System.Buffer.BlockCopy(str.ToCharArray(), 0, bytes, 0, bytes.Length);
            return bytes;
        }
        static string GetString(byte[] bytes)
        {
            char[] chars = new char[bytes.Length / sizeof(char)];
            System.Buffer.BlockCopy(bytes, 0, chars, 0, bytes.Length);
            return new string(chars);
        }

        [WebMethod]
        public List<string> Institute(string username)
        {
            s2 = username;
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
                    info.Add(reader["LOC_REC"].ToString());
                    info.Add(reader["INST_PHN"].ToString());
                    info.Add(reader["INST_EMAIL"].ToString());
                    info.Add(reader["YEAR_EST"].ToString());
                    info.Add(reader["INST_FIRM"].ToString());
                    info.Add(reader["CENTER_HEAD"].ToString());
                    info.Add(reader["INST_BUILD"].ToString());
                    info.Add(reader["NO_ROOM"].ToString());
                    info.Add(reader["FLOOR_AREA"].ToString());
                    info.Add(reader["REC_NO"].ToString());
                    info.Add(reader["VALID_DD"].ToString());
                    info.Add(reader["ATC_CH_1"].ToString());
                    info.Add(reader["ATC_CH_2"].ToString());
                    info.Add(reader["course_offered"].ToString());
                    info.Add(reader["INST_LEG"].ToString());
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
    }
}
