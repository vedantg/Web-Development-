<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeBehind="Default.aspx.cs" Inherits="WebApplication1._Default" %>

<asp:Content ID="HeaderContent" runat="server" ContentPlaceHolderID="HeadContent">
     <title>Home Page </title>
    <style type="text/css">

        .style3
        {
            color: #FFFFFF;
            font-family: Arial, Helvetica, sans-serif;
        }
        .style11
        {
            text-indent: -.25in;
            line-height: 115%;
            font-size: 11.0pt;
            font-family: Calibri, sans-serif;
            margin-left: .5in;
            margin-right: 0in;
            margin-top: 0in;
            margin-bottom: .0001pt;
        }
        .style12
        {
            text-indent: -.25in;
            line-height: 115%;
            font-size: 11.0pt;
            font-family: Calibri, sans-serif;
            margin-left: .5in;
            margin-right: 0in;
            margin-top: 0in;
            margin-bottom: 10.0pt;
        }
        .style13
        {
            font-size: 16pt;
            font-family: "Times New Roman", Times, serif;
            color: #FFFFFF;
        }
    </style>
</asp:Content>
<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <span class="style3">
    
    </font>
    
    </font></span>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <p>
    </p>
    <div style=" position=absolute border: thin double #000000; POSITION: absolute; height: 718px; width: 635px; top: 507px; left: 366px;">
            <asp:ScriptManager ID="ScriptManager1" runat="server" />
            <asp:Timer ID="Timer1" runat="server" Interval="3000" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:AdRotator ID="AdRotator1" Runat="server" 
                        AdvertisementFile="~/App_Data/ads.xml" Height="600px" KeywordFilter="small" 
                        Width="630px" />
            <asp:UpdatePanel ID="up1" runat="server">
                <ContentTemplate>
                    &nbsp;&nbsp;
                </ContentTemplate>
                <Triggers>
                    <asp:AsyncPostBackTrigger ControlID="Timer1" EventName="Tick" />
                </Triggers>
            </asp:UpdatePanel>
        </div>
    <div style="border:  thin double #000000; POSITION: absolute; height: 868px; width: 303px; top: 501px; left: 14px; background-image: url('bg.jpg');">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br />
        <p class="style11" style="mso-add-space: auto; mso-list: l0 level1 lfo1">
            <i style="mso-bidi-font-style:normal">
            <span style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;; color: #FFFFFF;">&nbsp;&nbsp;&nbsp; To give students easy access 
            to diversity of useful information and students service’s.<o:p></o:p></span></i></p>
        <p class="style11" style="mso-add-space: auto; mso-list: l0 level1 lfo1">
            <i style="mso-bidi-font-style:normal">
            <span style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;&nbsp; Mobilink provides user a 
            very flexible and portable facility of viewing notification.<o:p></o:p></span></i></p>
        <p class="style11" style="mso-add-space: auto; mso-list: l0 level1 lfo1">
            <i style="mso-bidi-font-style:normal">
            <span style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;&nbsp; Adaptive android 
            applications.<o:p></o:p></span></i></p>
        <p class="style11" style="mso-add-space: auto; mso-list: l0 level1 lfo1">
            <i style="mso-bidi-font-style:normal">
            <span style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;&nbsp; Provides a new avenue to our 
            services.<o:p></o:p></span></i></p>
        <p class="style12" style="mso-add-space: auto; mso-list: l0 level1 lfo1">
            <i style="mso-bidi-font-style:normal">
            <span style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;; color: #FFFFFF;">&nbsp;&nbsp;&nbsp;&nbsp; Excellent synchronization 
            between institutes and student.<o:p></o:p></span></i></p>
        </div
    <div style="border: thin double #000000; POSITION: absolute; height: 205px; width: 739px; top: 1009px; left: 349px;">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <font color="red" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <div style="border: thin double #000000; POSITION: absolute; height: 877px; width: 283px; top: 498px; left: 1039px; background-image: url('bg.jpg');">
         &nbsp;&nbsp;&nbsp;<p class="style11" style="mso-list: l0 level1 lfo1">
             <![if !supportLists]>
             <span style="font-size:16.0pt;line-height:115%;font-family:Wingdings;mso-fareast-font-family:
Wingdings;mso-bidi-font-family:Wingdings;color:white;mso-themecolor:background1">
             <span style="mso-list:Ignore">
             <span 
                 style="font:7.0pt &quot;Times New Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </span></span></span><![endif]><i style="mso-bidi-font-style:normal"><span 
                 
                 style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;color:white;mso-themecolor:background1; text-align: left;">Education is the most powerful weapon we can use to change the world.<o:p></o:p></span></i></p>
         <p class="style11" style="mso-list: l0 level1 lfo1">
             <i style="mso-bidi-font-style:normal">
             <span 
                 style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;color:white;mso-themecolor:background1">
             &nbsp;&nbsp;&nbsp;&nbsp;
             If you think education is expensive, try ignorance.<o:p></o:p></span></i></p>
         <p class="style11" style="mso-list: l0 level1 lfo1">
             <i style="mso-bidi-font-style:normal">
             <span 
                 style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;color:white;mso-themecolor:background1">
             &nbsp;&nbsp;&nbsp;&nbsp;
             The roots of education are bitter but fruits are sweet.<o:p></o:p></span></i></p>
             <p class="style11" style="mso-list: l0 level1 lfo1">
             <![if !supportLists]>
             <span style="font-size:16.0pt;line-height:115%;font-family:Wingdings;mso-fareast-font-family:
Wingdings;mso-bidi-font-family:Wingdings;color:white;mso-themecolor:background1">
             <span style="mso-list:Ignore">
             <span 
                 style="font:7.0pt &quot;Times New Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </span></span></span><![endif]><i style="mso-bidi-font-style:normal"><span 
                 
                 style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;color:white;mso-themecolor:background1; text-align: left;">Education's purpose is to replace an empty mind with an open one<o:p></o:p></span></i></p>
<p class="style11" style="mso-list: l0 level1 lfo1">
             <![if !supportLists]>
             <span style="font-size:16.0pt;line-height:115%;font-family:Wingdings;mso-fareast-font-family:
Wingdings;mso-bidi-font-family:Wingdings;color:white;mso-themecolor:background1">
             <span style="mso-list:Ignore">
             <span 
                 style="font:7.0pt &quot;Times New Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </span></span></span><![endif]><i style="mso-bidi-font-style:normal"><span 
                 
                 style="font-size:16.0pt;line-height:
115%;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;color:white;mso-themecolor:background1; text-align: left;">The mind is not a vessel to be filled, but a fire to be ignited<o:p></o:p></span></i></p>

         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div
   
    <br />
    <div style="border: thin double #000000; POSITION: absolute; height: 205px; width: 681px; top: 1166px; left: 337px ; background-image: url('bg.jpg');">
        <br />
        <br />
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="style13">For any 
        queries, email us at :
        <br />
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; thoughtbeat4@gmail.com
        </span>

    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    </font></font>
    </asp:Content>
