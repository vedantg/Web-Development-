<?xml version="1.0" encoding="utf-8"?>
<serviceModel xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" name="WebApplication1.Azure" generation="1" functional="0" release="0" Id="21a6187a-0867-4f8c-9d89-9170476a4c24" dslVersion="1.2.0.0" xmlns="http://schemas.microsoft.com/dsltools/RDSM">
  <groups>
    <group name="WebApplication1.AzureGroup" generation="1" functional="0" release="0">
      <componentports>
        <inPort name="WebApplication1:Endpoint1" protocol="http">
          <inToChannel>
            <lBChannelMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/LB:WebApplication1:Endpoint1" />
          </inToChannel>
        </inPort>
        <inPort name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput" protocol="tcp">
          <inToChannel>
            <lBChannelMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/LB:WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput" />
          </inToChannel>
        </inPort>
      </componentports>
      <settings>
        <aCS name="Certificate|WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapCertificate|WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" />
          </maps>
        </aCS>
        <aCS name="Certificate|WebApplication1:vik" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapCertificate|WebApplication1:vik" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.Diagnostics.ConnectionString" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.Diagnostics.ConnectionString" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountEncryptedPassword" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountEncryptedPassword" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountExpiration" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountExpiration" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountUsername" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountUsername" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Enabled" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Enabled" />
          </maps>
        </aCS>
        <aCS name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.Enabled" defaultValue="">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.Enabled" />
          </maps>
        </aCS>
        <aCS name="WebApplication1Instances" defaultValue="[1,1,1]">
          <maps>
            <mapMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/MapWebApplication1Instances" />
          </maps>
        </aCS>
      </settings>
      <channels>
        <lBChannel name="LB:WebApplication1:Endpoint1">
          <toPorts>
            <inPortMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Endpoint1" />
          </toPorts>
        </lBChannel>
        <lBChannel name="LB:WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput">
          <toPorts>
            <inPortMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput" />
          </toPorts>
        </lBChannel>
        <sFSwitchChannel name="SW:WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp">
          <toPorts>
            <inPortMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp" />
          </toPorts>
        </sFSwitchChannel>
      </channels>
      <maps>
        <map name="MapCertificate|WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" kind="Identity">
          <certificate>
            <certificateMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" />
          </certificate>
        </map>
        <map name="MapCertificate|WebApplication1:vik" kind="Identity">
          <certificate>
            <certificateMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/vik" />
          </certificate>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.Diagnostics.ConnectionString" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.Diagnostics.ConnectionString" />
          </setting>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountEncryptedPassword" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountEncryptedPassword" />
          </setting>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountExpiration" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountExpiration" />
          </setting>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountUsername" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountUsername" />
          </setting>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Enabled" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.Enabled" />
          </setting>
        </map>
        <map name="MapWebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.Enabled" kind="Identity">
          <setting>
            <aCSMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteForwarder.Enabled" />
          </setting>
        </map>
        <map name="MapWebApplication1Instances" kind="Identity">
          <setting>
            <sCSPolicyIDMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1Instances" />
          </setting>
        </map>
      </maps>
      <components>
        <groupHascomponents>
          <role name="WebApplication1" generation="1" functional="0" release="0" software="C:\Users\MyComp\Documents\Visual Studio 2010\Projects\WebApplication1\WebApplication1.Azure\csx\Release\roles\WebApplication1" entryPoint="base\x64\WaHostBootstrapper.exe" parameters="base\x64\WaIISHost.exe " memIndex="1792" hostingEnvironment="frontendadmin" hostingEnvironmentVersion="2">
            <componentports>
              <inPort name="Endpoint1" protocol="http" portRanges="80" />
              <inPort name="Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput" protocol="tcp" />
              <inPort name="Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp" protocol="tcp" portRanges="3389" />
              <outPort name="WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp" protocol="tcp">
                <outToChannel>
                  <sFSwitchChannelMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/SW:WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp" />
                </outToChannel>
              </outPort>
            </componentports>
            <settings>
              <aCS name="Microsoft.WindowsAzure.Plugins.Diagnostics.ConnectionString" defaultValue="" />
              <aCS name="Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountEncryptedPassword" defaultValue="" />
              <aCS name="Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountExpiration" defaultValue="" />
              <aCS name="Microsoft.WindowsAzure.Plugins.RemoteAccess.AccountUsername" defaultValue="" />
              <aCS name="Microsoft.WindowsAzure.Plugins.RemoteAccess.Enabled" defaultValue="" />
              <aCS name="Microsoft.WindowsAzure.Plugins.RemoteForwarder.Enabled" defaultValue="" />
              <aCS name="__ModelData" defaultValue="&lt;m role=&quot;WebApplication1&quot; xmlns=&quot;urn:azure:m:v1&quot;&gt;&lt;r name=&quot;WebApplication1&quot;&gt;&lt;e name=&quot;Endpoint1&quot; /&gt;&lt;e name=&quot;Microsoft.WindowsAzure.Plugins.RemoteAccess.Rdp&quot; /&gt;&lt;e name=&quot;Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput&quot; /&gt;&lt;/r&gt;&lt;/m&gt;" />
            </settings>
            <resourcereferences>
              <resourceReference name="DiagnosticStore" defaultAmount="[4096,4096,4096]" defaultSticky="true" kind="Directory" />
              <resourceReference name="EventStore" defaultAmount="[1000,1000,1000]" defaultSticky="false" kind="LogStore" />
            </resourcereferences>
            <storedcertificates>
              <storedCertificate name="Stored0Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" certificateStore="My" certificateLocation="System">
                <certificate>
                  <certificateMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" />
                </certificate>
              </storedCertificate>
              <storedCertificate name="Stored1vik" certificateStore="My" certificateLocation="System">
                <certificate>
                  <certificateMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1/vik" />
                </certificate>
              </storedCertificate>
            </storedcertificates>
            <certificates>
              <certificate name="Microsoft.WindowsAzure.Plugins.RemoteAccess.PasswordEncryption" />
              <certificate name="vik" />
            </certificates>
          </role>
          <sCSPolicy>
            <sCSPolicyIDMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1Instances" />
            <sCSPolicyUpdateDomainMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1UpgradeDomains" />
            <sCSPolicyFaultDomainMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1FaultDomains" />
          </sCSPolicy>
        </groupHascomponents>
      </components>
      <sCSPolicy>
        <sCSPolicyUpdateDomain name="WebApplication1UpgradeDomains" defaultPolicy="[5,5,5]" />
        <sCSPolicyFaultDomain name="WebApplication1FaultDomains" defaultPolicy="[2,2,2]" />
        <sCSPolicyID name="WebApplication1Instances" defaultPolicy="[1,1,1]" />
      </sCSPolicy>
    </group>
  </groups>
  <implements>
    <implementation Id="e37389d5-abde-4629-ad0a-4d904b1a500e" ref="Microsoft.RedDog.Contract\ServiceContract\WebApplication1.AzureContract@ServiceDefinition">
      <interfacereferences>
        <interfaceReference Id="69208cd8-5a5f-4641-8395-cd40ed18cd43" ref="Microsoft.RedDog.Contract\Interface\WebApplication1:Endpoint1@ServiceDefinition">
          <inPort>
            <inPortMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1:Endpoint1" />
          </inPort>
        </interfaceReference>
        <interfaceReference Id="02d437fa-d4e7-48f8-bf6e-b14db2cdfd15" ref="Microsoft.RedDog.Contract\Interface\WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput@ServiceDefinition">
          <inPort>
            <inPortMoniker name="/WebApplication1.Azure/WebApplication1.AzureGroup/WebApplication1:Microsoft.WindowsAzure.Plugins.RemoteForwarder.RdpInput" />
          </inPort>
        </interfaceReference>
      </interfacereferences>
    </implementation>
  </implements>
</serviceModel>