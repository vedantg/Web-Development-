<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ACCOUNT.aspx.cs" Inherits="WebApplication1.ACCOUNT" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">
        .style7
        {}
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
   <title>Institute Account Page </title>
    <p>
        <br />
    </p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <div style="width: 201px; height: 115px; position: absolute; top: 430px; left: 124px;">
&nbsp;&nbsp;
        <asp:Menu ID="Menu1" runat="server" CssClass="menu" 
            onmenuitemclick="mnuMain_MenuItemClick">
            <Items>
                <asp:MenuItem Text="View User information" Value="Menu1"></asp:MenuItem>
                <asp:MenuItem Text="Update User information" Value="Menu2"></asp:MenuItem>
                <asp:MenuItem Text="Fill ATC form" Value="Menu3"></asp:MenuItem>
                <asp:MenuItem Text="Certificate Download" Value="Menu4"></asp:MenuItem>
            </Items>
        </asp:Menu>
    </div>
    <p>
        &nbsp;</p>
    <br />
    <br />
    <p>
    <div style="width: 149px; height: 167px; position: absolute; top: 595px; left: 143px; font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; font-style: italic; color: #FF0000;">
        <asp:Label ID="Label6" runat="server" 
            
            Text="Dear User , You  Have Not Filled The ATC form, Please Fill ATC Form To Register Your Institute Details."></asp:Label>
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:be_con %>" 
            SelectCommand="SELECT * FROM [ATC]"></asp:SqlDataSource>
    </p>
    <div style="position: absolute; top: 376px; left: 428px; height: 907px; width: 705px; color: #000000;">
        <asp:MultiView ID="mViewProjects" runat="server" ActiveViewIndex="0">
            <asp:View ID="Insttute_view" runat="server">
                <table width:100%;"="">
                    <tr>
                        <td>
                            &nbsp;<td class="style2">
                                <div 228px;="" 396px;="" 739px;"="" 742px;="" height:="" left:="" style="border: thin none #000000; top:; color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; font-style: normal; height: 879px;" 
                                    width:="">
                                    <asp:Panel ID="view_panel" runat="server" Height="778px" 
                                        style="margin-bottom: 0px" Width="737px">
                <br />
                                        <br />
                                        <br />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="newStyle1">&nbsp;<strong 
                                            style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000"> Check Your 
                                        Account information :-<br />
                                        <br />
                                        <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                        <font face="Arial"><span class="style8">
                                        <asp:Label ID="Label3" runat="server" style="color: #000000" 
                                            Text="Institute ID :"></asp:Label>
                                        </span></font></b><span class="style11">
                                        <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; color: #000000">
                                        -&nbsp;</b><b 
                                            style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="Black">
                                        <asp:Label ID="INST_ID" runat="server" CssClass="style7" Width="325px"></asp:Label>
                                        </font></b></span>
                                        <br />
                                        </strong></span><br />&nbsp;<br />
                                        <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                        <font face="Arial"><span class="style8">
                                        <asp:Label ID="Label2" runat="server" style="color: #000000" 
                                            Text="ATC Form Status :"></asp:Label>
                                        </span></font></b><span class="style11">
                                        <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; color: #000000">
                                        -&nbsp;</b><b 
                                            style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <font color="Black">
                                        <asp:Label ID="ATC_status" runat="server" CssClass="style7" Width="325px"></asp:Label>
                                        <br />
                                        <br />
                                        <br />
                                        </font></b></span>
                                        <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                        &nbsp;<span class="style9"><span class="style11">Name of the organization : 
                                        -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </span></span>
                                        <asp:Label ID="Name_org" runat="server" CssClass="style7" Width="325px"></asp:Label>
                                        <span class="style12">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="style11"><br class="style8" /><span 
                                            class="style8">&nbsp;
                                        <br />
                                        Address (Regd. Office)&nbsp; : -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:Label ID="Add_org" runat="server" CssClass="style7" Height="26px" 
                                            Rows="44" Width="328px"></asp:Label>
                                        &nbsp; </span></span><span class="style12">&nbsp;&nbsp;&nbsp;</span><span class="style9"><span 
                                            class="style11">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />Location 
                                        of Recognition :-&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:Label ID="location_org" runat="server" CssClass="style7" Width="325px"></asp:Label>
                                        <span class="style12">&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="style8"><span class="style11"><br /><br />Telephone 
                                        No. /&nbsp;&nbsp;&nbsp;
                                        <br />
                                        &nbsp;Mobile No. :-&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><font face="Arial">
                                        &nbsp;&nbsp;<asp:Label ID="tel_org" runat="server" CssClass="style7" Width="309px"></asp:Label>
                                        </font><span class="style12">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;<span class="style8"><span 
                                            class="style11"><br />
                                        <br />
                                        &nbsp;Email addresss :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; </span></span><font face="Arial">&nbsp;<asp:Label ID="email_org" runat="server" CssClass="style7" Width="316px"></asp:Label>
                                        <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span 
                                            class="style8"><span class="style11"><br /><br />&nbsp;Type pf Firm-Prop<br /> 
                                        /Partnership/trust :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                        <asp:Label ID="firm_org" runat="server" CssClass="style7" Width="309px"></asp:Label>
                                        <span class="style8"><span class="style11">
                                        <br />
                                        <br />
                                        <span class="style12">courses offered by institute : -<br />
                                        <br />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <asp:ListBox ID="course_offered0" runat="server" Height="100px" 
                                            SelectionMode="Multiple" Width="320px">
                                           
                                        </asp:ListBox>
                                        &nbsp;
                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator36" runat="server" 
                                            ControlToValidate="course_offered" ErrorMessage="*" ForeColor="Red" 
                                            ValidationExpression="^[A-Za-z]*$"></asp:RequiredFieldValidator>
                                        <br />
                                        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
                                        <br />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span 
                                            class="style8"><span class="style11"><br /><br />&nbsp;Name &amp; Qualification<br /> 
                                        &nbsp;of center&nbsp;head :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                        <asp:Label ID="qualify_org" runat="server" CssClass="style7" Width="310px"></asp:Label>
                                        <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span 
                                            class="style8"><span class="style11"><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span 
                                            class="style1"><i>&nbsp;Mode of Payment&nbsp;&nbsp; </i></span>
                                        <br />
                                        <br />
                                        ATC VALID TILL&nbsp;:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:Label ID="valid_dd_org" runat="server" CssClass="style7" Width="302px"></asp:Label>
                                        <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span 
                                            class="style8"><span class="style11"><br />&nbsp;<br /> ATC CHARGES Rs. 
                                        :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span></span><asp:Label ID="charg_dd_org" runat="server" CssClass="style7" Width="301px"></asp:Label>
                                        <span class="style8"><span class="style11">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span><span 
                                            class="style8"><span class="style11"><br /><br />ATC CHARGES Rs. :-&nbsp; 
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:Label ID="charg_dd_org1" runat="server" CssClass="style7" Width="301px"></asp:Label>
                                        </font><span class="style8"><span class="style11">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span>&nbsp;<span 
                                            class="style8"><span class="style10"> </span>
                                        <br class="style11" />
                                        <span class="style10">
                                        <br />
                                        <br />
                                        &nbsp;&nbsp;&nbsp;</span></span></font></div></font></b></asp:Panel>
                                </div>

        <br />
        <br />
        <br />

                            </td>
                        </td>
                    </tr>
                </table>
            </asp:View>
            <asp:View ID="update_view" runat="server">
                <table style=" width: 100%; height: 1295px;">
                    <tr>
                        <td class="style1">
                            <div style="border: thin none #000000; top: 1235px; left: 45px; height: 1541px; width: 743px;">
                                <asp:Panel ID="update_panel" runat="server" Height="1533px" Width="735px">
                                    <br />
                                    <br />
            <br />
                                    &nbsp; <span class="newStyle1" 
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000">Update Your Accounte information :-</span><b 
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><font 
                                        face="Arial"><span class="style8"><br /> </span></font><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                    &nbsp;&nbsp;&nbsp;<br /><br /></span>&nbsp;<span class="style9"><span class="style11">Name 
                                    of the organization : -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><asp:TextBox ID="Name_org0" 
                                        runat="server" CssClass="style7" Width="325px"></asp:TextBox>
                                    <span class="style12">&nbsp;&nbsp;<asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator5" runat="server" ControlToValidate="Name_org0" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    &nbsp;&nbsp;</span><span class="style11"><br class="style8" /><span 
                                        class="style8">&nbsp;
            <br />
                                    Address (Regd. Office)&nbsp; : -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                    <asp:TextBox ID="Add_org0" runat="server" CssClass="style7" Height="78px" 
                                        Rows="44" Width="328px"></asp:TextBox>
                                    <span class="style12">
                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
                                        ControlToValidate="Add_org0" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    &nbsp;&nbsp;&nbsp;</span><span class="style9"><span class="style11">&nbsp;&nbsp; 
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />Location of Recognition :-&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                    <asp:TextBox ID="location_org0" runat="server" CssClass="style7" Width="325px"></asp:TextBox>
                                    <span class="style12">&nbsp;<asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator34" runat="server" ControlToValidate="location_org0" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span><span class="style8"><span class="style11">
            <br />
            <br />
                                    Telephone No. /&nbsp;&nbsp;&nbsp;
            <br />
                                    &nbsp;Mobile No. :-&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </span></span>
                                    <font face="Arial">
                                    <asp:TextBox ID="tel_org0" runat="server" CssClass="style7" Width="331px"></asp:TextBox>
                                    &nbsp;<asp:RequiredFieldValidator ID="RequiredFieldValidator16" runat="server" 
                                        ControlToValidate="tel_org0" ErrorMessage="*" ForeColor="Red" 
                                        ValidationExpression="^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"></asp:RequiredFieldValidator>
                                    </font><span class="style12">&nbsp;</span><span class="style8"><span class="style11"><br />
                                    <br />
                                    &nbsp;Email addresss :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; </span></span>
                                    <font face="Arial">
                                    <asp:TextBox ID="email_org0" runat="server" CssClass="style7" Width="336px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;</span><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator17" runat="server" ControlToValidate="email_org0" 
                                        ErrorMessage="*" ForeColor="Red" 
                                        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RequiredFieldValidator>
                                    <span class="style11">
            <br />
            <br />
                                    &nbsp;Year of Establishment :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; </span></span>
                                    <asp:TextBox ID="year_org" runat="server" CssClass="style7" Width="340px"></asp:TextBox>
                                    &nbsp;<span class="style8"><span class="style11">
                                    <asp:RegularExpressionValidator ID="RegularExpressionValidator33" 
                                        runat="server" ControlToValidate="year_org" CssClass="style6" 
                                        ErrorMessage="* For Eg. 12/12/2012" ForeColor="Red" 
                                        ValidationExpression="[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"></asp:RegularExpressionValidator>
                                    <br />
                                    <br />
                                    &nbsp;Legal Status of<br /> &nbsp;Organization :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </span>
                                    </span>
                                    <asp:TextBox ID="legal_org" runat="server" CssClass="style7" Width="340px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator7" runat="server" ControlToValidate="legal_org" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>&nbsp;</span></span><span class="style8"><span class="style11"><br />
                                    <br />
                                    Type pf Firm-Prop<br /> /Partnership/trust :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </span>
                                    </span>
                                    <asp:TextBox ID="firm_org0" runat="server" CssClass="style7" Width="349px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator8" runat="server" ControlToValidate="firm_org0" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    <br />
                                    <br />
                                    courses offered by institute : -<br />
                                    <br />
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:ListBox ID="course_offered2" runat="server" Height="100px" 
                                        SelectionMode="Multiple" Width="320px">
                                        <asp:ListItem>C / C++</asp:ListItem>
                                        <asp:ListItem>JAVA</asp:ListItem>
                                        <asp:ListItem>ADVANCED JAVA</asp:ListItem>
                                        <asp:ListItem>ASP.NET</asp:ListItem>
                                        <asp:ListItem>VISUAL BASICS</asp:ListItem>
                                        <asp:ListItem>ORACLE</asp:ListItem>
                                        <asp:ListItem>M1 / M2 / M3</asp:ListItem>
                                        <asp:ListItem>TOM</asp:ListItem>
                                        <asp:ListItem>SOM</asp:ListItem>
                                        <asp:ListItem>DOM</asp:ListItem>
                                        <asp:ListItem>MECHANICS</asp:ListItem>
                                        <asp:ListItem>MD-1 / MD-2</asp:ListItem>
                                        <asp:ListItem>ACOUNTS</asp:ListItem>
                                        <asp:ListItem>TALLY</asp:ListItem>
                                        <asp:ListItem>FINANCE</asp:ListItem>
                                        <asp:ListItem>FINE ARTS</asp:ListItem>
                                        <asp:ListItem>COMMERCIAL ATRS</asp:ListItem>
                                    </asp:ListBox>
                                    &nbsp;&nbsp;<asp:ListBox ID="course_offered1" runat="server" Height="100px" 
                                        SelectionMode="Multiple" Width="320px"></asp:ListBox>
                                    &nbsp; &nbsp;
                                    <br />
                                    </span>
                                    <br />
                                    <br />
                                    &nbsp;Name &amp; Qualification<br /> &nbsp;of center&nbsp;head :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                        ID="qualify_org0" runat="server" CssClass="style7" Width="353px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator9" runat="server" ControlToValidate="qualify_org0" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>&nbsp; </span></span><span class="style8"><span class="style11">
                                    <br />
                                    <br />
                                    &nbsp;Infrastructure Details of
                                    <br />
                                    &nbsp;Building :-<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                        ID="infra_org" runat="server" CssClass="style7" Height="64px" 
                                        style="color: #000000" TextMode="MultiLine" Width="351px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator10" runat="server" ControlToValidate="infra_org" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>&nbsp;</span><span class="style11"><br /><br />&nbsp;No. of 
                                    Classroom:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                    <asp:TextBox ID="room_org" runat="server" CssClass="style7" Width="350px"></asp:TextBox>
                                    <span class="style12">&nbsp;<asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator11" runat="server" ControlToValidate="room_org" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span><span class="style8"><span class="style11">
                                    <br />
                                    <br />
                                    &nbsp;Floor area of each classroom :-<br /> 
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                        ID="floor_org" runat="server" CssClass="style7" Height="64px" 
                                        style="color: #000000" TextMode="MultiLine" Width="354px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator12" runat="server" ControlToValidate="floor_org" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>
                                    <br />
                                    <br />
                                    &nbsp;If any Recognition No. :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                    <asp:TextBox ID="reg_org" runat="server" CssClass="style7" Width="354px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator13" runat="server" ControlToValidate="reg_org" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>&nbsp;</span></span><span class="style8"><span class="style11"><br /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span 
                                        class="style1"><i>&nbsp;Mode of Payment&nbsp;&nbsp; </i></span>
                                    <br />
                                    <br />
                                    <br />
                                    ATC VALID TILL&nbsp;:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                        ID="valid_dd_org0" runat="server" CssClass="style7" Width="361px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;<asp:RegularExpressionValidator 
                                        ID="RegularExpressionValidator34" runat="server" 
                                        ControlToValidate="valid_dd_org0" CssClass="style6" 
                                        ErrorMessage="* For Eg. 12/12/2012" ForeColor="Red" 
                                        ValidationExpression="[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"></asp:RegularExpressionValidator>
                                    <br />
                                    &nbsp;<br /> ATC CHARGES Rs. :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                        ID="charg_dd_org2" runat="server" CssClass="style7" Width="355px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp; &nbsp;&nbsp;<span class="style12"><asp:RequiredFieldValidator 
                                        ID="RequiredFieldValidator14" runat="server" ControlToValidate="charg_dd_org2" 
                                        ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>
                                    <br />
                                    <br />
                                    ATC CHARGES Rs. :-&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox ID="charg_dd_org3" 
                                        runat="server" CssClass="style7" Width="351px"></asp:TextBox>
                                    <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span>&nbsp;<span 
                                        class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator15" 
                                        runat="server" ControlToValidate="charg_dd_org3" ErrorMessage="*" 
                                        ForeColor="Red"></asp:RequiredFieldValidator>
                                    </span>
                                    <span class="style8"><span class="style10">&nbsp;<br />
                                    <br />
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Button ID="Button1" runat="server" onclick="Button1_Click" Text="Update" />
                                    <br class="style11" />
                                    <span class="style10">
            <br />
            <br />
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;</span></span></font></div></font></b></asp:Panel>
                            </div>
                        </td>
                    </tr>
                </table>
            </asp:View>
            <asp:View ID="view3" runat="server">
                <table style=" width: 100%; height: 1265px;">
                    <tr>
                        <td class="Heading">
                            <div class="inline" 
                                
                                
                                
                                
                                
                                
                                style="border: thin none #000000; width: 724px; margin-left: 2px; top: 524px; left: -31px; height: 1443px; font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000;">
                            <br />
                                <span class="style11">
                                &nbsp;&nbsp; <strong>
                                <em style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000">
                                <br />
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Create New ATC Application </em></strong>&nbsp;<br />
                                <br />
                                <span class="newStyle1">
                                <strong style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000">
                                <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                <font face="Arial"><span class="style8">
                                <asp:Label ID="Label4" runat="server" style="color: #000000" 
                                    Text="Institute ID :-"></asp:Label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></font><font color="Black">&nbsp;<asp:Label 
                                    ID="INST_ID0" runat="server" CssClass="style7" Width="325px"></asp:Label>
                                </font></b></strong></span>
                                <br />
                            <br />
                                </span>&nbsp;<span class="style9"><span class="style11">Name of the organization 
                                : -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; </span></span>
                                <asp:TextBox ID="Name_org2" runat="server" CssClass="style7" Width="325px"></asp:TextBox>
                                <span class="style12">&nbsp;
                                <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator19" runat="server" 
                                    ControlToValidate="Name_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </b>&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="style11"><br class="style8" /><span 
                                    class="style8">&nbsp;
                            <br />
                                Address (Regd. Office)&nbsp; : -&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="Add_org2" runat="server" CssClass="style7" Height="78px" 
                                    Rows="44" Width="328px" TextMode="MultiLine"></asp:TextBox>
                                <span class="style12">&nbsp;<b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><asp:RequiredFieldValidator 
                                    ID="RequiredFieldValidator20" runat="server" ControlToValidate="Add_org2" 
                                    ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </b>&nbsp;&nbsp;&nbsp;</span><span class="style9"><span class="style11">&nbsp;&nbsp; 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />Location of Recognition :-&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                <asp:TextBox ID="location_org2" runat="server" CssClass="style7" Width="325px"></asp:TextBox>
                                <span class="style12">&nbsp;
                                <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                <asp:RegularExpressionValidator ID="RegularExpressionValidator31" 
                                    runat="server" ControlToValidate="location_org2" CssClass="style12" 
                                    ErrorMessage="*" ForeColor="Red" ValidationExpression="^[A-Za-z0-9]*$"></asp:RegularExpressionValidator>
                                </b>&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="style8"><span 
                                    class="style11"><br />
                                <br />
                                Telephone No. /&nbsp;&nbsp;&nbsp;
                                <br />
                                &nbsp;Mobile No. :-&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</span></span><font 
                                    face="Arial"><asp:TextBox ID="tel_org2" runat="server" CssClass="style7" 
                                    Width="309px"></asp:TextBox>
                                </font><span class="style12">&nbsp;&nbsp;&nbsp;&nbsp;</span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><font 
                                    face="Arial"><asp:RequiredFieldValidator ID="RequiredFieldValidator21" 
                                    runat="server" ControlToValidate="tel_org2" ErrorMessage="*" ForeColor="Red" 
                                    ValidationExpression="^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"></asp:RequiredFieldValidator>
                                </font></b>&nbsp;<span class="style8"><span class="style11"><br />
                            <br />
                                &nbsp;Email addresss :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</span></span><font face="Arial"><asp:TextBox ID="email_org2" runat="server" CssClass="style7" Width="316px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style8"><asp:RequiredFieldValidator ID="RequiredFieldValidator22" 
                                    runat="server" ControlToValidate="email_org2" ErrorMessage="*" ForeColor="Red" 
                                    ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RequiredFieldValidator>
                                </span></b><span class="style8"><span class="style11">
                                <br />
                                &nbsp;<br /> &nbsp;Year of Establishment :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; </span></span>
                                <asp:TextBox ID="year_org2" runat="server" CssClass="style7" Width="313px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style8"><span class="style11">
                                    <asp:RegularExpressionValidator ID="RegularExpressionValidator6" runat="server" 
                                    ControlToValidate="year_org2" CssClass="style6" ErrorMessage="* For Eg. 12/12/2012" ForeColor="Red" 
                                    ValidationExpression="[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"></asp:RegularExpressionValidator>
                                </span></span></b><span class="style8"><span class="style11">
                                <br />
                                <br />
                                &nbsp;Legal Status of<br /> &nbsp;Organization :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </span>
                                </span>
                                <asp:TextBox ID="legal_org2" runat="server" CssClass="style7" Width="310px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp; &nbsp;<b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator24" 
                                    runat="server" ControlToValidate="legal_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b>&nbsp; </span></span><span class="style8"><span class="style11">
                                <br />
                                <br />
                                Type of Institute :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </span></span>
                                <asp:TextBox ID="firm_org2" runat="server" CssClass="style7" Width="309px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;
                                <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                <span class="style12">
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator25" runat="server" 
                                    ControlToValidate="firm_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                <br />
                                <br />
                                <br />
                                <br />
                                courses offered by institute : -<br />
                                <br />
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <asp:ListBox ID="course_offered" runat="server" Height="100px" 
                                    SelectionMode="Multiple" Width="320px">
                                    <asp:ListItem>C / C++</asp:ListItem>
                                    <asp:ListItem>JAVA</asp:ListItem>
                                    <asp:ListItem>ADVANCED JAVA</asp:ListItem>
                                    <asp:ListItem>ASP.NET</asp:ListItem>
                                    <asp:ListItem>VISUAL BASICS</asp:ListItem>
                                    <asp:ListItem>ORACLE</asp:ListItem>
                                    <asp:ListItem>M1 / M2 / M3</asp:ListItem>
                                    <asp:ListItem>TOM</asp:ListItem>
                                    <asp:ListItem>SOM</asp:ListItem>
                                    <asp:ListItem>DOM</asp:ListItem>
                                    <asp:ListItem>MECHANICS</asp:ListItem>
                                    <asp:ListItem>MD-1 / MD-2</asp:ListItem>
                                    <asp:ListItem>ACOUNTS</asp:ListItem>
                                    <asp:ListItem>TALLY</asp:ListItem>
                                    <asp:ListItem>FINANCE</asp:ListItem>
                                    <asp:ListItem>FINE ARTS</asp:ListItem>
                                    <asp:ListItem>COMMERCIAL ATRS</asp:ListItem>
                                </asp:ListBox>
                                &nbsp;
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator35" runat="server" 
                                    ControlToValidate="course_offered" ErrorMessage="*" ForeColor="Red" 
                                    ValidationExpression="^[A-Za-z]*$"></asp:RequiredFieldValidator>
                                <br />
                                </span></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span class="style8"><span class="style11"><br />
                                <br />
                                &nbsp;Name &amp; Qualification<br /> &nbsp;of center&nbsp;head :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="qualify_org2" runat="server" CssClass="style7" Width="310px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator26" 
                                    runat="server" ControlToValidate="qualify_org2" ErrorMessage="*" 
                                    ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b>
                                <br />
                                <br />
                                &nbsp;Infrastructure Details of
                                <br />
                                &nbsp;Building :-<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="infra_org2" runat="server" CssClass="style7" Height="64px" 
                                    style="color: black" TextMode="MultiLine" Width="307px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;
                                <b style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000">
                                <span class="style12">
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator27" runat="server" 
                                    ControlToValidate="infra_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span class="style8"><span class="style11"><br />
                                <br />
                                &nbsp;No. of Classroom:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; </span></span>
                                <asp:TextBox ID="room_org2" runat="server" CssClass="style7" Width="303px"></asp:TextBox>
                                <span class="style12">&nbsp;&nbsp;&nbsp; &nbsp;</span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator28" 
                                    runat="server" ControlToValidate="room_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b><span class="style8"><span class="style11">
                                <br />
                                <br />
                                &nbsp;Floor area of each classroom :-<br /> 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="floor_org2" runat="server" CssClass="style7" Height="64px" 
                                    style="color: black" TextMode="MultiLine" Width="308px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style8"><span class="style11"><span class="style12"><asp:RequiredFieldValidator 
                                    ID="RequiredFieldValidator29" runat="server" ControlToValidate="floor_org2" 
                                    ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></span></span></b><span class="style8"><span class="style11">
                                <br />
                                <br />
                                &nbsp;If any Recognition No. :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span>
                                <asp:TextBox ID="reg_org2" runat="server" CssClass="style7" Width="298px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;<b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator30" 
                                    runat="server" ControlToValidate="reg_org2" ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b>&nbsp;</span></span><span class="style8"><span class="style11"><br />
                                <br />
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span 
                                    class="style1"><i>&nbsp;Mode of Payment&nbsp;&nbsp; </i></span>
                                <br />
                                <br />
                                <br />
                                ATC VALID TILL&nbsp;:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</span></span><asp:TextBox 
                                    ID="valid_dd_org2" runat="server" CssClass="style7" Width="302px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style8"><span class="style11"><asp:RegularExpressionValidator 
                                    ID="RegularExpressionValidator32" runat="server" 
                                    ControlToValidate="valid_dd_org2" CssClass="style6" 
                                    ErrorMessage="* For Eg. 12/12/2012" ForeColor="Red" 
                                    ValidationExpression="[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"></asp:RegularExpressionValidator>
                                </span></span></b><span class="style8"><span class="style11">
                                <br />
                                &nbsp;<br /> ATC CHARGES Rs.1 :-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="charg_dd_org10" runat="server" CssClass="style7" Width="301px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style8"><span class="style11"><span class="style12"><asp:RequiredFieldValidator 
                                    ID="RequiredFieldValidator31" runat="server" ControlToValidate="charg_dd_org10" 
                                    ErrorMessage="*" ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></span></span></b><span class="style8"><span class="style11">
                                <br />
                                <br />
                                ATC CHARGES Rs. 2:-&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><asp:TextBox 
                                    ID="charg_dd_org9" runat="server" CssClass="style7" Width="301px"></asp:TextBox>
                                <span class="style8"><span class="style11">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</span></span><b 
                                    style="font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000"><span 
                                    class="style12"><asp:RequiredFieldValidator ID="RequiredFieldValidator32" 
                                    runat="server" ControlToValidate="charg_dd_org9" ErrorMessage="*" 
                                    ForeColor="Red"></asp:RequiredFieldValidator>
                                </span></b>
                                <br />
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<span class="style8"><span class="style10"> 
                                <br />
                                <br />
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <asp:Button ID="Button2" runat="server" Text="Submit" 
                                    onclick="Button2_Click" Width="100px" />

                                &nbsp;&nbsp; 
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
                                </span></font></div>
                                
                            &nbsp;&nbsp;<br />
                        </td>
                    </tr>
                                        
                </table>
            </asp:View>
             <asp:View ID="cert" runat="server">
            <table style=" width: 100%; height: 1265px;">
                    <tr>
                        <td class="Heading">
                            <div class="inline"  style="border: thin none #000000; width: 724px; margin-left: 2px; top: 524px; left: -31px; height: 1443px; font-family: Arial, Helvetica, sans-serif; font-size: large; font-weight: normal; color: #000000;">
                            <br />
                            <br />
                                        <br />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="newStyle1">&nbsp;<strong 
                                            style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; font-weight: bold; font-style: italic; color: #000000"> 
                                Check Your Certificate details :<span class="style11"><b 
                            </td>-<br />
                                <br />
                                &nbsp; You can download from here&nbsp;
                                <asp:Button ID="cert_down_btn" runat="server" onclick="cert_down_btn_Click" 
                                    Text="Download" />
                    </tr>
                                        
                </table>
               </asp:View>
        </asp:MultiView>
    </div>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    </asp:Content>
