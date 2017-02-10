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
    public partial class ACCOUNT : System.Web.UI.Page
    { string s=null;
    public int st=0;
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
        Name_org2.Text = "";
        Add_org2.Text = "";
        tel_org2.Text = "";
        location_org2.Text = "";
        email_org2.Text = "";
        year_org2.Text = "";
        legal_org2.Text = "";
        firm_org2.Text = "";
        qualify_org2.Text = "";
        infra_org2.Text = "";
        room_org2.Text = "";
        floor_org2.Text = "";
        reg_org2.Text = "";
        valid_dd_org2.Text = "";
        charg_dd_org10.Text = "";
        charg_dd_org9.Text = "";
        course_offered0.Items.Clear();
        course_offered1.Items.Clear();
        cur = "";
    }
    public string str1="";
        protected void Page_Load(object sender, EventArgs e)
        {
           // clear1();
            Label6.Visible = false;
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {
                string a = Request.Cookies["userName"].Value;
                string b = a.Substring(0, 3);

                if (b == "BES")
                {
                    Response.Redirect("student_account.aspx");
                }
                else
                {
                    try
                    {
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                        string sqlQuery = "select * from ATC where Inst_ID='" + Request.Cookies["userName"].Value + "'";

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

                            Name_org.Text = reader["INST_NAME"].ToString();
                            Add_org.Text = reader["INST_ADD"].ToString();
                            location_org.Text = reader["LOC_REC"].ToString();
                            tel_org.Text = reader["INST_PHN"].ToString();
                            email_org.Text = reader["INST_EMAIL"].ToString();


                            firm_org.Text = reader["INST_FIRM"].ToString();
                            qualify_org.Text = reader["CENTER_HEAD"].ToString();




                            valid_dd_org.Text = reader["VALID_DD"].ToString();
                            charg_dd_org.Text = reader["ATC_CH_1"].ToString();
                            charg_dd_org1.Text = reader["ATC_CH_2"].ToString();
                            ATC_status.Text = reader["STATUS"].ToString();

                            INST_ID.Text = Request.Cookies["userName"].Value;
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            string s = reader["course_offered"].ToString();
                            str1 = s;
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
                                            course_offered0.Items.Add(pr);
                                            course_offered1.Items.Add(pr);
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
                            st = 1;


                        }
                        else
                        {
                            Label6.Visible = true;
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            mViewProjects.SetActiveView(view3);
                            st = 0;

                        }


                        reader.Close();

                        conn.Close();
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex);
                        Show("Problem in the data transfer , Please contact authorities");


                    }
                }
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
        protected void mnuMain_MenuItemClick(object sender, MenuEventArgs e)
        {

            switch (e.Item.Value.ToString())
            {

                case "Menu1":
                    {
                        if (st == 1)
                        {

                            mViewProjects.SetActiveView(Insttute_view);
                        }
                        else
                        {
                            Label6.Visible = true;
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            mViewProjects.SetActiveView(view3);
                        }
                        break;

                    }

                case "Menu2":
                    {

                        if (st == 1)
                        {

                       
                        mViewProjects.SetActiveView(update_view);

                        try
                        {
                            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                            string sqlQuery = "select * from ATC where Inst_ID='" + Request.Cookies["userName"].Value + "'";

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



                                Name_org0.Text = reader["INST_NAME"].ToString();
                                Add_org0.Text = reader["INST_ADD"].ToString();
                                location_org0.Text = reader["LOC_REC"].ToString();
                                tel_org0.Text = reader["INST_PHN"].ToString();
                                email_org0.Text = reader["INST_EMAIL"].ToString();
                                year_org.Text = reader["YEAR_EST"].ToString();
                                legal_org.Text = reader["INST_LEG"].ToString();
                                firm_org0.Text = reader["INST_FIRM"].ToString();
                                qualify_org0.Text = reader["CENTER_HEAD"].ToString();
                                infra_org.Text = reader["INST_BUILD"].ToString();
                                room_org.Text = reader["NO_ROOM"].ToString();
                                floor_org.Text = reader["FLOOR_AREA"].ToString();
                                reg_org.Text = reader["REC_NO"].ToString();
                                valid_dd_org0.Text = reader["VALID_DD"].ToString();
                                charg_dd_org2.Text = reader["ATC_CH_1"].ToString();
                                charg_dd_org3.Text = reader["ATC_CH_2"].ToString();


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
                        else
                        {
                            Label6.Visible = true;
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            mViewProjects.SetActiveView(view3);
                        }

                        break;

                    }
                case "Menu3":
                    {

                        if (st == 1)
                        {

                            Label6.Visible = true;
                            Label6.Text = "Dear user , you already have ATC form.";
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            mViewProjects.SetActiveView(update_view);
                        }
                        else
                        {


                            mViewProjects.SetActiveView(view3);
                        }
                        break;

                    }
                case "Menu4":
                    {

                        if (st == 1)
                        {

                            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                            string sqlQuery = "select * from ATC where Inst_ID='" + Request.Cookies["userName"].Value + "'";

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
                                s = reader["STATUS"].ToString();


                            }



                            reader.Close();

                            conn.Close();

                            if (s == "NO")
                            {
                                Show("Your request is in progress ...");

                            }
                            else if (s == "YES")
                            {
                                mViewProjects.SetActiveView(cert);
                            }
                         
                            
                        }
                        else
                        {

                            Label6.Visible = true;
                            INST_ID0.Text = Request.Cookies["userName"].Value;
                            mViewProjects.SetActiveView(view3);
                        }
                        break;

                    }

            }
        }
        public void mult_list1()
        {
            cur = "";
     
            for (int i = 0; i < course_offered2.Items.Count; i++)
            {
                if (course_offered2.Items[i].Selected == true)
                {
                    cur += course_offered2.Items[i].Value + "&";
                }
            }
           

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {

                // Define ADO.NET objects.
                String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;


                mult_list1();
                //SqlConnection conn = new SqlConnection(strConn);

                string updateSQL;
                updateSQL = "UPDATE ATC SET ";
                updateSQL += "INST_NAME=@Org_name, INST_ADD=@Org_add,LOC_REC=@rec1,INST_PHN=@phn,INST_EMAIL=@Org_email,YEAR_EST=@EST,INST_LEG=@Org_ph,INST_FIRM=@FIRM,CENTER_HEAD=@HEAD,INST_BUILD=@BUILD,NO_ROOM=@ROOM,FLOOR_AREA=@AREA,REC_NO=@REC,VALID_DD=@DD,ATC_CH_1=@CH1,ATC_CH_2=@CH2,STATUS ='NO',course_offered=@CH3 ";
                updateSQL += "WHERE INST_ID='" + Request.Cookies["userName"].Value + "'";
                SqlConnection con = new SqlConnection(strConn);
                SqlCommand cmd = new SqlCommand(updateSQL, con);
                // Add the parameters.
                cmd.Parameters.AddWithValue("@Org_name", Name_org0.Text);
                cmd.Parameters.AddWithValue("@Org_add", Add_org0.Text);
                cmd.Parameters.AddWithValue("@rec1", location_org0.Text);
                cmd.Parameters.AddWithValue("@phn", tel_org0.Text);
                cmd.Parameters.AddWithValue("@Org_email", email_org0.Text);
                cmd.Parameters.AddWithValue("@EST", year_org.Text);
                cmd.Parameters.AddWithValue("@Org_ph", legal_org.Text);
                cmd.Parameters.AddWithValue("@FIRM", firm_org0.Text);
                cmd.Parameters.AddWithValue("@HEAD", qualify_org0.Text);
                cmd.Parameters.AddWithValue("@BUILD", infra_org.Text);
                cmd.Parameters.AddWithValue("@ROOM", room_org.Text);
                cmd.Parameters.AddWithValue("@AREA", floor_org.Text);
                cmd.Parameters.AddWithValue("@REC", reg_org.Text);
                cmd.Parameters.AddWithValue("@DD", valid_dd_org0.Text);
                cmd.Parameters.AddWithValue("@CH1", charg_dd_org2.Text);
                cmd.Parameters.AddWithValue("@CH2", charg_dd_org3.Text);
                cmd.Parameters.AddWithValue("@CH4", "YES");

                // Try to open database and execute the update.
                if (course_offered2.SelectedIndex.ToString() == "-1")
                {
                    cmd.Parameters.AddWithValue("@CH3", str1);
                }

                else
                {
                    cmd.Parameters.AddWithValue("@CH3", cur);
                }
                cur = "";
                int updated = 0;
                con.Open();
                updated = cmd.ExecuteNonQuery();


                con.Close();
                if (updated == 1)
                    ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert('Your record is updated ');", true);
                else
                    ClientScript.RegisterStartupScript(typeof(_Default), "Message", "alert('Problem in  record updatation ');", true);
                Response.Redirect("ACCOUNT.aspx");
            }
            catch (SqlException ex)
            {
                Console.WriteLine(ex);
                Show("Problem in the data transfer , Please contact authorities");

            }
        }

        public void sksk()
        {
                        String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                            string sqlQuery = "select * from ATC where Inst_ID='" + Request.Cookies["userName"].Value + "'";

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
                                s=reader["INST_ID"].ToString();


                            }



                            reader.Close();

                            conn.Close();
                    
    
        }
        public string cur = "";
        
        public void mult_list()
        {
            cur = "";
           
            for (int i = 0; i <course_offered.Items.Count; i++)
            {
                if (course_offered.Items[i].Selected == true)
                {
                    cur += course_offered.Items[i].Value + "&";
                }
            }
           

        }
        protected void Button2_Click(object sender, EventArgs e)
        {
           
            try
            {
                sksk();
                mult_list();

                if(s==null)
                {
                    
                    String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

                    SqlConnection conn = new SqlConnection(strConn);

                    SqlCommand cmd = new SqlCommand();

                       cmd.Connection = conn;

                       string strQuery = "Insert into ATC values ('" + Name_org2.Text + "','" + Add_org2.Text + "','" + location_org2.Text + "','" + tel_org2.Text + "','" + email_org2.Text + "','" + year_org2.Text + "','" + legal_org2.Text + "','" + firm_org2.Text + "','" + qualify_org2.Text + "','" + infra_org2.Text + "','" + room_org2.Text + "','" + floor_org2.Text + "','" + reg_org2.Text + "','" + valid_dd_org2.Text + "','" + charg_dd_org9.Text + "','" + charg_dd_org10.Text + "','" + Request.Cookies["userName"].Value + "','NO','" + cur + "',null,' null')";

                      cmd.CommandText = strQuery;

                  cmd.CommandType = CommandType.Text;
        
                      conn.Open();

                       cmd.ExecuteNonQuery();

                   conn.Close();


                   Name_org2.Text = "";
                        Add_org2.Text = "";
                 tel_org2.Text = "";
                    location_org2.Text = "";
                 email_org2.Text = "";
                 year_org2.Text = "";
                          legal_org2.Text = "";
                          firm_org2.Text = "";
                    qualify_org2.Text = "";
                  infra_org2.Text = "";
                      room_org2.Text = "";
                          floor_org2.Text = "";
                     reg_org2.Text = "";
                       valid_dd_org2.Text = "";
                                 charg_dd_org10.Text = "";
                    charg_dd_org9.Text = "";

                    Response.Redirect("ACCOUNT.aspx");


                }
                else
                {
                    Label6.Text="Dear user , you already have ATC form.";
                    Label6.Visible=true;
                }
            }

        catch (SqlException ex)
        {
                Console.WriteLine(ex);
                Show("Problem in the data transfer , Please contact authorities");

        }
        }
        public Byte[] login()
        {
            byte[] raw = null;// new Byte[321352];
            String strConn = WebConfigurationManager.ConnectionStrings["be_con"].ConnectionString;

            string sqlQuery = "select * from ATC where Inst_ID='" + Request.Cookies["userName"].Value + "'";

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


                raw = (byte[])reader["cert"];


            }



            reader.Close();

            conn.Close();

            return raw;
        }
        protected void cert_down_btn_Click(object sender, EventArgs e)
        {
            byte[] data = login();
            Response.Clear();
            string strFileName = "ATC_certificate" + ".docx";
            Response.ContentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            Response.AddHeader("Content-Disposition", "inline;filename=" + strFileName);
            Response.BinaryWrite(data);
            Response.End();
                    
        }
        
    }

  
    }
