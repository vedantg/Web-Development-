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
    public partial class student_account : System.Web.UI.Page
    {

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

        public void clear1()
        {
            stud_id.Text = "";
            first_nm.Text = "";
            mid_nm.Text = "";
            last_nm.Text = "";
            clg_nm.Text = "";
            addr.Text = "";
            Ph_no.Text = "";
            Email_id.Text = "";
            area_interest_textbox.Text = "";
            L_PREFERED_CURRENT.Items.Clear();
            L_PREFERED_CURRENT1.Items.Clear();
            future_course.Items.Clear();
            future_course1.Items.Clear();
        }


        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {
                clear1();
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

                    stud_id.Text = reader["STUD_ID"].ToString();
                    first_nm.Text = reader["FIRST_NAME"].ToString();
                    mid_nm.Text = reader["MID_NAME"].ToString();
                    last_nm.Text = reader["LAST_NAME"].ToString();
                    clg_nm.Text = reader["COLLEGE_NAME"].ToString();
                    addr.Text = reader["ADDR"].ToString();
                    Ph_no.Text = reader["PH_NO"].ToString();
                    Email_id.Text = reader["STUD_EMAIL"].ToString();
                    area_interest_textbox.Text = reader["AREA_INTEREST"].ToString();
                    stream1.Text = reader["STREAM"].ToString();
                    stream2.Text = reader["STUD_DEG"].ToString();
                    string s = reader["CURRENT_COURSE"].ToString();
                    str = s;
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
                                    L_PREFERED_CURRENT.Items.Add(pr);
                                    L_PREFERED_CURRENT1.Items.Add(pr);
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
                    try
                    {

                        s = reader["FUTURE_COURSE"].ToString();
                        st1 = s;
                        cnt = conts(s);
                        pr = "";
                        j = 0;
                        for (int i = 0; i < cnt; i++)
                        {
                            pr = "";
                            while (j < s.Length)
                            {
                                if (s[j].ToString() == "&")
                                {
                                    future_course.Items.Add(pr);
                                    future_course1.Items.Add(pr);
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
            else
            {
                Response.Redirect("Default.aspx");
            }

        }
       
        protected void mnuMain_MenuItemClick(object sender, MenuEventArgs e)
        {

            switch (e.Item.Value.ToString())
            {

                case "Menu1":
                    {

                        mViewProjects.SetActiveView(Insttute_view);

                        break;

                    }

                case "Menu2":
                    {
                         try
            {
                        mViewProjects.SetActiveView(upadate_view);
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
                            stud_id0.Text = reader["STUD_ID"].ToString();
                            first_nm0.Text = reader["FIRST_NAME"].ToString();
                            mid_nm0.Text = reader["MID_NAME"].ToString();
                            last_nm0.Text = reader["LAST_NAME"].ToString();
                            clg_nm0.Text = reader["COLLEGE_NAME"].ToString();
                            addr0.Text = reader["ADDR"].ToString();
                            Ph_no0.Text = reader["PH_NO"].ToString();
                            Email_id0.Text = reader["STUD_EMAIL"].ToString();
                            area_interest_textbox0.Text = reader["AREA_INTEREST"].ToString();
                            drop_stream0.Text = reader["STREAM"].ToString();
                            drop_degree0.Text = reader["STUD_DEG"].ToString();

                            switch (drop_stream0.Text)
                            {

                                case "SCIENCE":
                                    {
                                        L_PREFERED_CURRENT0.Items.Add("C / C++");
                                        L_PREFERED_CURRENT0.Items.Add("JAVA");
                                        L_PREFERED_CURRENT0.Items.Add("ADVANCED JAVA");
                                        L_PREFERED_CURRENT0.Items.Add("VISUAL BASICS");
                                        L_PREFERED_CURRENT0.Items.Add("ASP.NET");
                                        L_PREFERED_CURRENT0.Items.Add("ORACLE");
                                        L_PREFERED_CURRENT0.Items.Add("M1 / M2 / M3");
                                        L_PREFERED_CURRENT0.Items.Add("GRAPHICS");
                                        L_PREFERED_CURRENT0.Items.Add("MECHANICS");
                                        L_PREFERED_CURRENT0.Items.Add("MD-1 / MD-2 ");
                                        L_PREFERED_CURRENT0.Items.Add("SOM");
                                        L_PREFERED_CURRENT0.Items.Add("TOM");
                                        L_PREFERED_CURRENT0.Items.Add("DOM");


                                        break;
                                    }
                                case "COMMERCE":
                                    {
                                        L_PREFERED_CURRENT.Items.Add("ACCCOUNTS ");
                                        L_PREFERED_CURRENT.Items.Add("FINANCE");
                                        L_PREFERED_CURRENT.Items.Add("TALLY");

                                        break;
                                    }
                                case "ARTS":
                                    {
                                        L_PREFERED_CURRENT.Items.Add("SKETCHING ");
                                        L_PREFERED_CURRENT.Items.Add("COMMERCIAL ARTS");
                                        L_PREFERED_CURRENT.Items.Add("FINE ARTS");
                                        L_PREFERED_CURRENT.Items.Add("DANCING");

                                        break;
                                    }


                            }

                        }



                        reader.Close();

                        conn.Close();
            }
                         catch (SqlException ex)
                         {
                              Console.WriteLine(ex);
                              Show("Problem in the data transfer , Please contact authorities");

                         }

                        break;

                    }
              
            }
        }

        public int sr, M;
        public string cur, fut;
        public string str = "", st1 = "";
        public void mult_list()
        {
            cur = "";
            fut = "";
            for (int i = 0; i < L_PREFERED_CURRENT0.Items.Count; i++)
            {
                if (L_PREFERED_CURRENT0.Items[i].Selected == true)
                {
                    cur += L_PREFERED_CURRENT0.Items[i].Value + "&";
                }
            }
            for (int i = 0; i < future_course0.Items.Count; i++)
            {
                if (future_course0.Items[i].Selected == true)
                {
                    fut += future_course0.Items[i].Value + "&";
                }
            }

        }

        protected void Button2_Click(object sender, EventArgs e)
        {

            try
            {
                mult_list();
                // Define ADO.NET objects.
                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;



                //SqlConnection conn = new SqlConnection(strConn);

                string updateSQL;
                updateSQL = "UPDATE STUDENT SET ";
                updateSQL += "STUD_ID=@Org_name,FIRST_NAME=@rec1,MID_NAME=@phn,LAST_NAME=@Org_email,COLLEGE_NAME=@EST,ADDR=@Org_ph,PH_NO=@FIRM,STUD_EMAIL=@HEAD,STREAM=@BUILD,CURRENT_COURSE=@ROOM,FUTURE_COURSE=@AREA,AREA_INTEREST=@REC,STUD_DEG=@CH1 ";
                updateSQL += "WHERE STUD_ID='" + Request.Cookies["userName"].Value + "'";
                SqlConnection con = new SqlConnection(strConn);
                SqlCommand cmd = new SqlCommand(updateSQL, con);
                // Add the parameters.
                cmd.Parameters.AddWithValue("@Org_name", stud_id0.Text);
                //  cmd.Parameters.AddWithValue("@Org_add", Add_org0.Text);
                cmd.Parameters.AddWithValue("@rec1", first_nm0.Text);
                cmd.Parameters.AddWithValue("@phn", mid_nm0.Text);
                cmd.Parameters.AddWithValue("@Org_email", last_nm0.Text);
                cmd.Parameters.AddWithValue("@EST", clg_nm0.Text);
                cmd.Parameters.AddWithValue("@Org_ph", addr0.Text);
                cmd.Parameters.AddWithValue("@FIRM", Ph_no0.Text);
                cmd.Parameters.AddWithValue("@HEAD", Email_id0.Text);
                cmd.Parameters.AddWithValue("@BUILD", drop_stream0.Text);

                if (L_PREFERED_CURRENT0.SelectedIndex.ToString() == "-1")
                {
                    cmd.Parameters.AddWithValue("@ROOM", str);
                }

                else
                {
                    cmd.Parameters.AddWithValue("@ROOM", cur);
                }

                if (L_PREFERED_CURRENT0.SelectedIndex.ToString() == "-1")
                {
                    cmd.Parameters.AddWithValue("@AREA", st1);
                }

                else
                {
                    cmd.Parameters.AddWithValue("@AREA", fut);
                }

                cmd.Parameters.AddWithValue("@REC", area_interest_textbox0.Text);
                //  cmd.Parameters.AddWithValue("@DD", valid_dd_org0.Text);
                cmd.Parameters.AddWithValue("@CH1", drop_degree0.Text);
                //   cmd.Parameters.AddWithValue("@CH2", charg_dd_org3.Text);

                // Try to open database and execute the update.

                int updated = 0;
                con.Open();
                updated = cmd.ExecuteNonQuery();


                con.Close();
                if (updated == 1)
                    ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert('Your record is updated ');", true);
                else
                    ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert('Problem in  record updatation ');", true);
            }
            catch (SqlException ex)
            {
                Console.WriteLine(ex);
                 Show("Problem in the data transfer , Please contact authorities");

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

        }

    }
}