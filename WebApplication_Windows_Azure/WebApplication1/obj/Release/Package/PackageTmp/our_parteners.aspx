<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="our_parteners.aspx.cs" Inherits="WebApplication1.our_parteners" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <title>Our Partners </title>
    <p>
        <br />
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <span style="font-family:&quot;Andalus&quot;,&quot;serif&quot;">
    <div s="" 
        
        style="POSITION: absolute; height: 458px; top: 496px; left: 374px; width: 718px;">
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
            ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
            SelectCommand="SELECT * FROM [vik]"></asp:SqlDataSource>
        <asp:Image ID="Image1" runat="server" Height="414px" 
            ImageUrl="~/image/partners.gif" Width="564px" />
    </div>
    </span>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
