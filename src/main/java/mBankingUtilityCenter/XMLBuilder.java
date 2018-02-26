package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mBankingPageObjectModel.StaticStore;

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
	
	public static void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Requests\\requests.properties")));
		dbprop = new  Properties();
		dbprop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\property\\UPI.db")));
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
		//log.info("1 : "+requestBuilder(1));
		
		
		//log.info("2 : "+requestBuilder(1));
		//int index = 1;
		//log.info(StaticStore.UPIMenuDesc[index][0].substring(StaticStore.UPIMenuDesc[index][0].lastIndexOf("=")+1, StaticStore.UPIMenuDesc[index][0].length()));
		//log.info(parameteriedUPI(0));
		//log.info(StaticStore.ReqMenuDesc[2][1]);
		//log.info(XMLRequest(parameteriedReq(1)));
		//HttpConnect.postXML(requestBuilder(0));
	}
	
	/*
	 * To get the parameterized request template from static store for UPI block
	 */
	public static String parameteriedUPI(int index)	
	{
		String Request ="";
		for(int x=1; x< StaticStore.UPIMenuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.UPIMenuDesc[index][x]+";";
    	}
		log.info(Request);
		return Request;
	}

	/*
	 * To get the parameterized request template from static store for Request block
	 */
	public static String parameteriedReq(int index)
	{
		String Request ="";
    	for(int x=1; x< StaticStore.ReqMenuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.ReqMenuDesc[index][x]+";";
    	}
    	return Request;
	}
	
	/*
	 * Building the XML request from the parameterized template from static store
	 */
	public static String XMLRequest(String request)
	{
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
		return sb.toString();
	}
	
	/*
	 * Building Final XML request to be sent in payload
	 */
	public static String requestBuilder(int index)
	{
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
		return sb.toString();
	}
	
	public static String sendMoney()
	{
		return null;
	}
	
	public static String collectMoney()
	{
		return null;
	}
	
	public static String changePin(String AccNo)
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
		sb.append("<MsgId i:type=\"d:string\">"+prop.getProperty("MsgId")+RandomNumGenerator.genarate(32)+"</MsgId>");
		sb.append("<TimeStamp i:type=\"d:string\">"+prop.getProperty("TimeStamp")+"</TimeStamp>");
		sb.append("</UPI>");
		sb.append("</req>");
		sb.append("</ChangePin>");
		sb.append("</v:Body>");
		sb.append( "</v:Envelope>");
		return sb.toString();
		
	}
	
}






