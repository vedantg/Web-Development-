<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="information.aspx.cs" Inherits="WebApplication1.information" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
   <title>Information </title>
    <style type="text/css">

    .style1
    {
        font-size: x-large;
        font-family: Arial, Helvetica, sans-serif;
            background-color: #003366;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
   
    <div id="MyDivTag" runat="server" onscroll="javascript:SetDivPosition()" 
        style="border-style: double; width: 1056px; height: 300px; overflow: auto; z-index: 55">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Table ID="BlogTable" runat="server" GridLines="None" Height="16px" 
            
            style="Z-INDEX: 101; LEFT: 228px; POSITION: absolute; TOP: 491px; width: 1058px;">
        </asp:Table>
        <strong><em><span class="style1" 
            style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000; background-color: #FFFFFF">
        Registered Institutes according to your preferences.....</span></em></strong></div>
    <p>
    </p>
     <p>
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:be_con %>" 
            SelectCommand="SELECT * FROM [ATC]"></asp:SqlDataSource>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
