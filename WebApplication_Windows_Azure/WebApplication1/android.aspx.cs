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


using System.Collections.Specialized;
using System.Net;
using System.Text;
using System.IO;
using System.ComponentModel;
namespace WebApplication1
{
    public partial class android : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["userName"] != null && Request.Cookies["password"] != null)
            {

            }
            else
            {
                Response.Redirect("Default.aspx");
            }
        }
        protected void _lbtDownload_Click(object sender, EventArgs e)
        {/*
            FileInfo file = new FileInfo(@"\\RemoteServerIP_OR_Name\FolderName\Sample.zip");
            Response.Clear();
            Response.ClearHeaders();
            Response.ClearContent();
            Response.AppendHeader("Content-Disposition", "attachment; filename = Sample.zip");
            Response.AppendHeader("Content-Length", file.Length.ToString());
            Response.ContentType = "application/download";
            Response.WriteFile(file.FullName);
            Response.Flush();
            Response.Close();
            Response.End();*/

            HttpWebRequest objRequest = (HttpWebRequest)WebRequest.Create("http://localhost:4356/App_Data/ThoughtBeat%20APP.zip");
            HttpWebResponse objResponse = (HttpWebResponse)objRequest.GetResponse();
            int bufferSize = 1;
            Response.Clear();
            Response.ClearHeaders();
            Response.ClearContent();
            Response.AppendHeader("Content-Disposition:", "attachment; filename=.apk");
            Response.AppendHeader("Content-Length", objResponse.ContentLength.ToString());
            Response.ContentType = "application/download";
            byte[] byteBuffer = new byte[bufferSize + 1];
            MemoryStream memStrm = new MemoryStream(byteBuffer, true);
            Stream strm = objRequest.GetResponse().GetResponseStream();
            byte[] bytes = new byte[bufferSize + 1];
            while (strm.Read(byteBuffer, 0, byteBuffer.Length) > 0)
            {
                Response.BinaryWrite(memStrm.ToArray());
                Response.Flush();
            }
            Response.Close();
            Response.End();
            memStrm.Close();
            memStrm.Dispose();
            strm.Dispose();
        }
        protected void download_Click(object sender, EventArgs e)
        {
            try
            {
               
                Response.ContentType = "application/zip";
                Response.AppendHeader("Content-Disposition", string.Format("attachment; filename = {0}", System.IO.Path.GetFileName("~/App_Data/ThoughtBeat.zip")));
                Response.TransmitFile("~/App_Data/ThoughtBeat.zip");
                HttpContext.Current.ApplicationInstance.CompleteRequest();
            }
            catch (Exception ex)
            {
                throw ex;
            }
           
        
        }
    }
    
    

        
    }
