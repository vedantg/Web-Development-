using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Data.OleDb; 


namespace WebApplication1
{
    public partial class status : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] == null && Request.Cookies["password"] == null)
            {
                Response.Redirect("Register.aspx");

            }

        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Label1.Visible = false;

            string connectString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=D:\\vik.mdb";
            OleDbConnection cn = new OleDbConnection(connectString);
            cn.Open();

            string s = "SELECT * FROM atc where Form_id='" + form_id.Text + "'";
            OleDbCommand cmd = new OleDbCommand(s, cn);
            //cmd.CommandText = "Insert into student values('"+ CreateUserWizard3.Password  + "', '" +CreateUserWizard3.UserName  + "','" + CreateUserWizard3.Email  + "')";
            //Int32 x;
            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            String s5 = "";
            String s6 = "";
            String s7 = "";
            String s8 = "";
            OleDbDataReader reader = cmd.ExecuteReader();


            while (reader.Read())
            {
                s1 = reader["Form_id"].ToString();
                s2 = reader["Uni_id"].ToString();
                s3 = reader["Name_org"].ToString();
                s4 = reader["Email_org"].ToString();
                s5 = reader["year_org"].ToString();
                s6 = reader["status_0"].ToString();
                s7 = reader["status_1"].ToString();
                s8 = reader["status_2"].ToString();


            }


            if (uid_id.Text == s2)
            {
                Panel1.Visible = false;

                org.Text = s3;
                email.Text = s4;
                year.Text = s5;
                form.Text = s1;
                uid.Text = s2;
                Prime.Text = s6;
                sec.Text = s7;
                ext.Text = s8;
            }
            else
            {
                Label1.Visible = true;

            }

        }
    }
}