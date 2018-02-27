package mBankingUtilityCenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * @author brantansp
 *
 */

public class XMLBuilder {

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
    
	/*
	 * main method to unit test page components
	 */
	protected static Properties prop;
	public static Properties dbprop;
	
	public static Properties loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Requests\\requests.properties")));
		dbprop = new  Properties();
		dbprop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\property\\UPI.db")));
return prop;
	}
	
	static{
		try {
			loadObjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		
	}
	
	/*
	 * To get the parameterized request template from static store for UPI block
	 */
	public static String parameteriedUPI(int index)	
	{
		/*String Request ="";
		for(int x=1; x< StaticStore.UPIMenuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.UPIMenuDesc[index][x]+";";
    	}
		log.info(Request);*/
		return null;
	}

	/*
	 * To get the parameterized request template from static store for Request block
	 */
	public static String parameteriedReq(int index)
	{
/*		String Request ="";
    	for(int x=1; x< StaticStore.ReqMenuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.ReqMenuDesc[index][x]+";";
    	}*/
    	return null;
	}
	
	/*
	 * Building the XML request from the parameterized template from static store
	 */
	public static String XMLRequest(String request)
	{/*
		StringBuilder sb = new StringBuilder();
		String Request = request;
		Map<String, String> map = new LinkedHashMap<String, String>();
		String[] test1 = Request.split(";");
		for (String s : test1) {
		    String[] t = s.split("=");
		    map.put(t[0], t[1]);
		}
		for (String s : map.keySet()) {
			sb.append( "<"+s+" i:type=\"d:string\">"+ map.get(s)+"</"+s+">");
		}
		return sb.toString();*/
		return null;
	}
	
	/*
	 * Building Final XML request to be sent in payload
	 */
	public static String requestBuilder(int index)
	{/*
		StringBuilder sb = new StringBuilder();		
		String transaction =StaticStore.UPIMenuDesc[index][0].substring(StaticStore.UPIMenuDesc[index][0].lastIndexOf("=")+1, StaticStore.UPIMenuDesc[index][0].length());
		log.info(StaticStore.UPIMenuDesc[index][0].substring(StaticStore.UPIMenuDesc[index][0].lastIndexOf("=")+1, StaticStore.UPIMenuDesc[index][0].length()));
		sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<v:Header />");
		sb.append("<v:Body>");
		sb.append("<"+transaction+" xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\">");
		sb.append("<req>");
		sb.append(XMLRequest(parameteriedReq(index)));
		sb.append("<UPI>"+XMLRequest(parameteriedUPI(index))+"</UPI>");
		sb.append("</req>");
		sb.append("</"+transaction+">");
		sb.append("</v:Body>");
		sb.append( "</v:Envelope>");
		return sb.toString(); */
		return null;
	}

	
	/**
	 * UPI Requests Hard coded
	 */
	
	//1
			public static String AddBank()
			{		
			StringBuilder sb = new StringBuilder();
			sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
			sb.append("<v:Header />");
			sb.append("<v:Body>");
			sb.append("<AddBank xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
			sb.append("<req>");
			sb.append("<UPI>");
			sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
			sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
			sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
			sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
			sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
			sb.append("<Remarks i:type=\"d:string\"/>");
			sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
			sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
			sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
			sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
			sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
			sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
			sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
			sb.append("</UPI>");
			sb.append("</req>");
			sb.append("</AddBank>");
			sb.append("</v:Body>");
			sb.append( "</v:Envelope>");
			log.info(sb.toString());
			return sb.toString();
			}
			
			public static String ChangePin(String AccNo)
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<ChangePin xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
				sb.append("<req>");
				sb.append("<OldPin i:type=\"d:string\">"+prop.getProperty("OldPin")+"</OldPin>");
				sb.append("<NewKeyIndex i:type=\"d:string\">"+prop.getProperty("NewKeyIndex")+"</NewKeyIndex>");
				sb.append("<OldKeyIndex i:type=\"d:string\">"+prop.getProperty("OldKeyIndex")+"</OldKeyIndex>");
				sb.append("<DevType i:type=\"d:string\">"+prop.getProperty("DevType")+"</DevType>");
				sb.append("<DevIp i:type=\"d:string\">"+prop.getProperty("DevIp")+"</DevIp>");
				sb.append("<DevOs i:type=\"d:string\">"+prop.getProperty("DevOs")+"</DevOs>");
				sb.append("<DevId i:type=\"d:string\">"+prop.getProperty("DevId")+"</DevId>");
				sb.append("<DevApp i:type=\"d:string\">"+prop.getProperty("DevApp")+"</DevApp>");
				sb.append("<CredType i:type=\"d:string\">"+prop.getProperty("CredType")+"</CredType>");
				sb.append("<DevLocation i:type=\"d:string\">"+prop.getProperty("DevLocation")+"</DevLocation>");
				sb.append("<PayerAccNo i:type=\"d:string\">"+AccNo+"</PayerAccNo>");
				sb.append("<BankName i:type=\"d:string\">"+prop.getProperty("BankName")+"</BankName>");
				sb.append("<NewPin i:type=\"d:string\">"+prop.getProperty("NewPin")+"</NewPin>");
				sb.append("<NewKeyCode i:type=\"d:string\">"+prop.getProperty("NewKeyCode")+"</NewKeyCode>");
				sb.append("<GeoCode i:type=\"d:string\">"+prop.getProperty("GeoCode")+"</GeoCode>");
				sb.append("<DevCapability i:type=\"d:string\">"+prop.getProperty("DevCapability")+"</DevCapability>");
				sb.append("<OldKeyCode i:type=\"d:string\">"+prop.getProperty("OldKeyCode")+"</OldKeyCode>");
				sb.append("<UPI>");
				sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
				sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
				sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
				sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
				sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
				sb.append("<Remarks i:type=\"d:string\">"+prop.getProperty("Remarks")+"</Remarks>");
				sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
				sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
				sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
				sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
				sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
				sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+RandomNumGenerator.genarate(32)+"</MsgId>");
				sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
				sb.append("</UPI>");
				sb.append("</req>");
				sb.append("</ChangePin>");
				sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
				
			}
			
			//2
			public static String ListBankAcc()
				{
					StringBuilder sb = new StringBuilder();
					sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
					sb.append("<v:Header />");
					sb.append("<v:Body>");
					sb.append("<ListBankAcc xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
					sb.append("<req>");
					sb.append("<CredType i:type=\"d:string\">CredType</CredType>");
					sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("AddrType")+"</AddrType>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<BankName i:type=\"d:string\">"+prop.getProperty("BankName")+"</BankName>");
					sb.append("<KeyCode i:type=\"d:string\">"+prop.getProperty("KeyCode")+"</KeyCode>");
					sb.append("<OTP i:type=\"d:string\"/>");
					sb.append("<KeyIndex i:type=\"d:string\">"+prop.getProperty("KeyIndex")+"</KeyIndex>");
					sb.append("<UPI>");
					sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
					sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
					sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
					sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
					sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
					sb.append("<Remarks i:type=\"d:string\"/>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
					sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
					sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
					sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
					sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
					sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
					sb.append("</UPI>");
					sb.append("</req>");
					sb.append("</ListBankAcc>");
					sb.append("</v:Body>");
					sb.append( "</v:Envelope>");
					log.info(sb.toString());
					return sb.toString();
				}
				
			//3
			public static String RegisterAcc()
				{
					StringBuilder sb = new StringBuilder();
					sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
					sb.append("<v:Header />");
					sb.append("<v:Body>");
					sb.append("<RegisterAcc xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
							sb.append("<req>");
							sb.append("<CredList>");
							sb.append("<CredsAllowed>");
							sb.append("<dType i:type=\"d:string\">"+prop.getProperty("dType")+"</dType>");
							sb.append("<type i:type=\"d:string\">"+prop.getProperty("type")+"</type>");
							sb.append("<subType i:type=\"d:string\">"+prop.getProperty("subType")+"</subType>");
							sb.append("<dLength i:type=\"d:string\">"+prop.getProperty("dLength")+"</dLength>");
							sb.append("</CredsAllowed>");
							sb.append("<CredsAllowed>");
							sb.append("<dType i:type=\"d:string\">"+prop.getProperty("dType")+"</dType>");
							sb.append("<type i:type=\"d:string\">"+prop.getProperty("type")+"</type>");
							sb.append("<subType i:type=\"d:string\">"+prop.getProperty("subType")+"</subType>");
							sb.append("<dLength i:type=\"d:string\">"+prop.getProperty("dLength")+"</dLength>");
							sb.append("</CredsAllowed>");
							sb.append("</CredList>");
							sb.append("<DType i:type=\"d:string\"/>");
							sb.append("<IFSC i:type=\"d:string\">"+prop.getProperty("IFSC")+"</IFSC>");
							sb.append("<AccType i:type=\"d:string\">"+prop.getProperty("AccType")+"</AccType>");
							sb.append("<AccRefNumber i:type=\"d:string\">"+prop.getProperty("AccRefNumber")+"</AccRefNumber>");
							sb.append("<VerifiedName i:type=\"d:string\">"+prop.getProperty("VerifiedName")+"</VerifiedName>");
							sb.append("<MBEBA i:type=\"d:string\">N</MBEBA>");
							sb.append("<AEBA i:type=\"d:string\">N</AEBA>");
							sb.append("<BankName i:type=\"d:string\">"+prop.getProperty("BankName")+"</BankName>");
							sb.append("<DLength i:type=\"d:string\"/>");
							sb.append("<AccNo i:type=\"d:string\">"+prop.getProperty("AccNo")+"</AccNo>");
							sb.append("<UPI>");
							sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
							sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
							sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
							sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
							sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
							sb.append("<Remarks i:type=\"d:string\"/>");
							sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
							sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
							sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
							sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
							sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
							sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
							sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
							sb.append("</UPI>");
							sb.append("</req>");
							sb.append("</RegisterAcc>");
					sb.append("</v:Body>");
					sb.append( "</v:Envelope>");
					log.info(sb.toString());
					return sb.toString();
					
				}
			

			//last 1
			public static String ConfirmCollectMoney()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("ConfirmCollectMoney xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
						sb.append("<req>");
						sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</AddrType>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</PayerCode>");
						sb.append("<Pin i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</Pin>");
						sb.append("<TxnId i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TxnId>");
						sb.append("<DevType i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevType>");
						sb.append("<DevIp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevIp>");
						sb.append("<DevOs i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevOs>");
						sb.append("<DevId i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevId>");
						sb.append("<DevApp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevApp>");
						sb.append("<CredType i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</CredType>");
						sb.append("<DevLocation i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevLocation>");
						sb.append("<PayeeCode i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</PayeeCode>");
						sb.append("<KeyCode i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</KeyCode>");
						sb.append("<CollectOption i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</CollectOption>");
						sb.append("<KeyIndex i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</KeyIndex>");
						sb.append("<GeoCode i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</GeoCode>");
						sb.append("<DevCapability i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DevCapability>");
						sb.append("<UPI>");
						sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</UserID>");
						sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</BankId>");
						sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</OrgId>");
						sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</PayerType>");
						sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</MobileNo>");
						sb.append("<Remarks i:type=\"d:string\"/>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</PayerCode>");
						sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</Channel>");
						sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</AppVersion>");
						sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</UserPwd>");
						sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</DeviceID>");
						sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</MsgId>");
						sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
						sb.append("</UPI>");
						sb.append("</req>");
						sb.append("</ConfirmCollectMoney>");
						sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}

			//last 2
			public static String listpendingapproval()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<ListPendingApproval xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
				sb.append("<req>");
				sb.append("<UPI>");
				sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
				sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
				sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
				sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
				sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
				sb.append("<Remarks i:type=\"d:string\"/>");
				sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
				sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
				sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
				sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
				sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
				sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
				sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
				sb.append("</UPI>");
				sb.append("</req>");
				sb.append("</ListPendingApproval>");
				sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}


			/**
			 *	2.Set UPI PIN: 
			 */
			//1.Generate Virtual Address:
			
			public static String GenerateVirAddr ()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<GenerateVirAddr xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
						sb.append("<req>");
						sb.append("<AccNumber i:type=\"d:string\">"+prop.getProperty("AccNumber")+"</AccNumber>");
						sb.append("<VirAddr i:type=\"d:string\">"+prop.getProperty("VirAddr")+"</VirAddr>");
						sb.append("<Validto i:type=\"d:string\">"+prop.getProperty("Validto")+"</Validto>");
						sb.append("<TotalLmt i:type=\"d:string\"/>");
						sb.append("<AvlLmt i:type=\"d:string\">"+prop.getProperty("AvlLmt")+"</AvlLmt>");
						sb.append("<Frequency i:type=\"d:string\">"+prop.getProperty("Frequency")+"</Frequency>");
						sb.append("<UPI>");
						sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
						sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
						sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
						sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
						sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
						sb.append("<Remarks i:type=\"d:string\"/>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
						sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
						sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
						sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
						sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
						sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
						sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
						sb.append("</UPI>");
						sb.append("</req>");
						sb.append("</GenerateVirAddr>");
						sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}
			/**
			* 2.Mobile Banking Registration
			*/

			//1.View Registered Accounts Request
			public static String ViewRegAccnts()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<ViewRegAccnts xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
						sb.append("<req>");
						sb.append("<UPI>");
						sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
						sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
						sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
						sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
						sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
						sb.append("<Remarks i:type=\"d:string\"/>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
						sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
						sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
						sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
						sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
						sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
						sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
						sb.append("</UPI>");
						sb.append("</req>");
						sb.append("</ViewRegAccnts>");
						sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}
			
			//2.Generate Bank OTP
			public static String GenerateBankOTP()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<GenerateBankOTP xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
						sb.append("<req>");
						sb.append("<DevIp i:type=\"d:string\">"+prop.getProperty("DevIp")+"</DevIp>");
						sb.append("<DevOs i:type=\"d:string\">"+prop.getProperty("DevOs")+"</DevOs>");
						sb.append("<DevId i:type=\"d:string\">"+prop.getProperty("DevId")+"</DevId>");
						sb.append("<DevApp i:type=\"d:string\">"+prop.getProperty("DevApp")+"</DevApp>");
						sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("AddrType")+"</AddrType>");
						sb.append("<RegDetails i:type=\"d:string\">"+prop.getProperty("RegDetails")+"</RegDetails>");
						sb.append("<DevLocation i:type=\"d:string\">"+prop.getProperty("DevLocation")+"</DevLocation>");
						sb.append("<PayerAccNo i:type=\"d:string\">"+prop.getProperty("PayerAccNo")+"</PayerAccNo>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
						sb.append("<BankName i:type=\"d:string\">"+prop.getProperty("BankName")+"</BankName>");
						sb.append("<GeoCode i:type=\"d:string\">"+prop.getProperty("GeoCode")+"</GeoCode>");
						sb.append("<DevType i:type=\"d:string\">"+prop.getProperty("DevType")+"</DevType>");
						sb.append("<DevCapability i:type=\"d:string\">"+prop.getProperty("DevCapability")+"</DevCapability>");
						sb.append("<UPI>");
						sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
						sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
						sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
						sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
						sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
						sb.append("<Remarks i:type=\"d:string\"/>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
						sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
						sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
						sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
						sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
						sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
						sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
						sb.append("</UPI>");
						sb.append("</req>");
						sb.append("</GenerateBankOTP>");
						sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}
			
			//3.Mobile Banking Registration
			
			public static String MobBankRegistration()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
				sb.append("<v:Header />");
				sb.append("<v:Body>");
				sb.append("<MobBankRegistration xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
						sb.append("<req>");
						sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("AddrType")+"</AddrType>");
						sb.append("<AccType i:type=\"d:string\">"+prop.getProperty("AccType")+"</AccType>");
						sb.append("<OTP i:type=\"d:string\">"+prop.getProperty("OTP")+"</OTP>");
						sb.append("<AccNo i:type=\"d:string\">"+prop.getProperty("AccNo")+"</AccNo>");
						sb.append("<DevType i:type=\"d:string\">"+prop.getProperty("DevType")+"</DevType>");
						sb.append("<DevIp i:type=\"d:string\">"+prop.getProperty("DevIp")+"</DevIp>");
						sb.append("<DevOs i:type=\"d:string\">"+prop.getProperty("DevOs")+"</DevOs>");
						sb.append("<ATMPIN i:type=\"d:string\"/>");
						sb.append("<IFSC i:type=\"d:string\">"+prop.getProperty("IFSC")+"</IFSC>");
						sb.append("<DevId i:type=\"d:string\">"+prop.getProperty("DevId")+"</DevId>");
						sb.append("<DevApp i:type=\"d:string\">"+prop.getProperty("DevApp")+"</DevApp>");
						sb.append("<CredType i:type=\"d:string\">"+prop.getProperty("CredType")+"</CredType>");
						sb.append("<DevLocation i:type=\"d:string\">"+prop.getProperty("DevLocation")+"</DevLocation>");
						sb.append("<PayerAccNo i:type=\"d:string\">"+prop.getProperty("PayerAccNo")+"</PayerAccNo>");
						sb.append("<PIN i:type=\"d:string\">"+prop.getProperty("PIN")+"</PIN>");
						sb.append("<KeyCode i:type=\"d:string\">"+prop.getProperty("KeyCode")+"</KeyCode>");
						sb.append("<CardDigits i:type=\"d:string\">"+prop.getProperty("CardDigits")+"</CardDigits>");
						sb.append("<ExpDate i:type=\"d:string\">"+prop.getProperty("ExpDate")+"</ExpDate>");
						sb.append("<KeyIndex i:type=\"d:string\">"+prop.getProperty("KeyIndex")+"</KeyIndex>");
						sb.append("<GeoCode i:type=\"d:string\">"+prop.getProperty("GeoCode")+"</GeoCode>");
						sb.append("<DevCapability i:type=\"d:string\">"+prop.getProperty("DevCapability")+"</DevCapability>");
						sb.append("<UPI>");
						sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
						sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
						sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
						sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
						sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
						sb.append("<Remarks i:type=\"d:string\"/>");
						sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
						sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
						sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
						sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
						sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
						sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
						sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
						sb.append("</UPI>");
						sb.append("</req>");
						sb.append("</MobBankRegistration>");
						sb.append("</v:Body>");
				sb.append( "</v:Envelope>");
				log.info(sb.toString());
				return sb.toString();
			}
			
			/**
			 * collect money 
			 */
			
			//1.View Registered Accounts
			
			
			
			
			//2.Request Validate Address
		public static String ReqValAddress()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
			sb.append("<v:Header />");
			sb.append("<v:Body>");
			sb.append("<ReqValAddress xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
					sb.append("<req>");
					sb.append("<PayeeVirAddr i:type=\"d:string\">"+prop.getProperty("PayeeVirAddr")+"</PayeeVirAddr>");
					sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("AddrType")+"</AddrType>");
					sb.append("<PayerAccNo i:type=\"d:string\">"+prop.getProperty("PayerAccNo")+"</PayerAccNo>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<PayerVirAddr i:type=\"d:string\">"+prop.getProperty("PayerVirAddr")+"</PayerVirAddr>");
					sb.append("<UPI>");
					sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
					sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
					sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
					sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
					sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
					sb.append("<Remarks i:type=\"d:string\"/>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
					sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
					sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
					sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
					sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
					sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
					sb.append("</UPI>");
					sb.append("</req>");
					sb.append("</ReqValAddress>");
					sb.append("</v:Body>");
			sb.append( "</v:Envelope>");
			log.info(sb.toString());
			return sb.toString();
		}
			
		//3.Collect Money
		public static String CollectMoney()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
			sb.append("<v:Header />");
			sb.append("<v:Body>");
			sb.append("<CollectMoney xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\">");
					sb.append("<req>");
					sb.append("<PayeeAccNo i:type=\"d:string\">"+prop.getProperty("PayeeAccNo")+"</PayeeAccNo>");
					sb.append("<AddrType i:type=\"d:string\">"+prop.getProperty("AddrType")+"</AddrType>");
					sb.append("<PayeeVirAddr i:type=\"d:string\">"+prop.getProperty("PayeeVirAddr")+"</PayeeVirAddr>");
					sb.append("<VirAddr i:type=\"d:string\"/>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<NickName i:type=\"d:string\"/>");
					sb.append("<CurrencyCode i:type=\"d:string\">"+prop.getProperty("CurrencyCode")+"</CurrencyCode>");
					sb.append("<payeeTranserType i:type=\"d:string\">"+prop.getProperty("payeeTranserType")+"</payeeTranserType>");
					sb.append("<TransferMode i:type=\"d:string\">"+prop.getProperty("TransferMode")+"</TransferMode>");
					sb.append("<DevType i:type=\"d:string\">"+prop.getProperty("DevType")+"</DevType>");
					sb.append("<DevIp i:type=\"d:string\">"+prop.getProperty("DevIp")+"</DevIp>");
					sb.append("<DevOs i:type=\"d:string\">"+prop.getProperty("DevOs")+"</DevOs>");
					sb.append("<DevId i:type=\"d:string\">"+prop.getProperty("DevId")+"</DevId>");
					sb.append("<PayerName i:type=\"d:string\">"+prop.getProperty("PayerName")+"</PayerName>");
					sb.append("<DevApp i:type=\"d:string\">"+prop.getProperty("DevApp")+"</DevApp>");
					sb.append("<Expdate i:type=\"d:string\">"+prop.getProperty("Expdate")+"</Expdate>");
					sb.append("<DevLocation i:type=\"d:string\">"+prop.getProperty("DevLocation")+"</DevLocation>");
					sb.append("<PayeeCode i:type=\"d:string\">"+prop.getProperty("PayeeCode")+"</PayeeCode>");
					sb.append("<Amount i:type=\"d:string\">"+prop.getProperty("Amount")+"</Amount>");
					sb.append("<PayerVirAddr i:type=\"d:string\">"+prop.getProperty("PayerVirAddr")+"</PayerVirAddr>");
					sb.append("<GeoCode i:type=\"d:string\">"+prop.getProperty("GeoCode")+"</GeoCode>");
					sb.append("<DevCapability i:type=\"d:string\">"+prop.getProperty("DevCapability")+"</DevCapability>");
					sb.append("<UPI>");
					sb.append("<UserID i:type=\"d:string\">"+prop.getProperty("UserID")+"</UserID>");
					sb.append("<BankId i:type=\"d:string\">"+prop.getProperty("BankId")+"</BankId>");
					sb.append("<OrgId i:type=\"d:string\">"+prop.getProperty("OrgId")+"</OrgId>");
					sb.append("<PayerType i:type=\"d:string\">"+prop.getProperty("PayerType")+"</PayerType>");
					sb.append("<MobileNo i:type=\"d:string\">"+prop.getProperty("MobileNo")+"</MobileNo>");
					sb.append("<Remarks i:type=\"d:string\">"+prop.getProperty("Remarks")+"</Remarks>");
					sb.append("<PayerCode i:type=\"d:string\">"+prop.getProperty("PayerCode")+"</PayerCode>");
					sb.append("<Channel i:type=\"d:string\">"+prop.getProperty("Channel")+"</Channel>");
					sb.append("<AppVersion i:type=\"d:string\">"+prop.getProperty("AppVersion")+"</AppVersion>");
					sb.append("<UserPwd i:type=\"d:string\">"+prop.getProperty("UserPwd")+"</UserPwd>");
					sb.append("<DeviceID i:type=\"d:string\">"+prop.getProperty("DeviceID")+"</DeviceID>");
					sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
					sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
					sb.append("</UPI>");
					sb.append("</req>");
					sb.append("</CollectMoney>");
					sb.append("</v:Body>");
			sb.append( "</v:Envelope>");
			log.info(sb.toString());
			return sb.toString();
		}


	}






