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
using System.Collections.Generic;

namespace WebApplication1
{
    public partial class chng_pw : System.Web.UI.Page
    {
        public string pw,id;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {
                id = Request.Cookies["userName"].Value.ToString();
                pw = Request.Cookies["password"].Value.ToString();

            }
            else
            {
                Response.Redirect("Default.aspx");
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
        protected void Button3_Click(object sender, EventArgs e)
        {
            if (New_pw.Text == confirm_pw.Text)
            {
                if (CURR_pw.Text == pw)
                {

                    string a = id;
            string b = a.Substring(0, 3);

            if (b == "BEI")
            {
                try
                {// Define ADO.NET objects.
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;



                    //SqlConnection conn = new SqlConnection(strConn);
                    string updateSQL;
                    updateSQL = "UPDATE SIGN_UP SET ";
                    updateSQL += "PASSWORD=@Org_name ";
                    updateSQL += "where Inst_ID='" + id + "'";

                    SqlConnection con = new SqlConnection(strConn);
                    SqlCommand cmd = new SqlCommand(updateSQL, con);
                    // Add the parameters.
                    cmd.Parameters.AddWithValue("@Org_name", New_pw.Text);


                    // Try to open database and execute the update.
                    int updated = 0;
                    con.Open();
                    updated = cmd.ExecuteNonQuery();
                    Show("Password Successfully Changed");

                    con.Close();
                }
                catch (SqlException ex)
                {
                    Console.WriteLine(ex);
                    Show("Problem in Data Transfer");
                }
            }
            else if (b == "BES")
            {
                try
                {// Define ADO.NET objects.
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;



                    //SqlConnection conn = new SqlConnection(strConn);
                    string updateSQL;
                    updateSQL = "UPDATE STUDENT SET ";
                    updateSQL += "STUD_PW=@Org_name ";
                    updateSQL += "where STUD_ID='" + id + "'";

                    SqlConnection con = new SqlConnection(strConn);
                    SqlCommand cmd = new SqlCommand(updateSQL, con);
                    // Add the parameters.
                    cmd.Parameters.AddWithValue("@Org_name", New_pw.Text);


                    // Try to open database and execute the update.
                    int updated = 0;
                    con.Open();
                    updated = cmd.ExecuteNonQuery();
                    Show("Password Successfully Changed");

                    con.Close();
                }
                catch (SqlException ex)
                {
                    Console.WriteLine(ex);
                    Show("Problem in Data Transfer");
                }
            }
                
                }
                
            }

        }
    }
}