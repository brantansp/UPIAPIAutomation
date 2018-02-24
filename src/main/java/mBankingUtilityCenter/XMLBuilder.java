package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
	public static void main(String[] args) throws Exception {
		log.info(requestBuilder(0));
		HttpConnect.postXML(requestBuilder(0));
	}
	
	/*
	 * To get the parameterized request template from static store for UPI block
	 */
	public static String parameteriedUPI(int index)	
	{
		String Request ="";
		for(int x=1; x< StaticStore.ReqMenuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.UPIMenuDesc[index][x]+";";
    	}
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
		sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<v:Header />");
		sb.append("<v:Body>");
		sb.append("<"+transaction+" xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\">");
		sb.append("<req>");
		sb.append(XMLRequest(parameteriedReq(0)));
		sb.append("<UPI>"+XMLRequest(parameteriedUPI(0))+"</UPI>");
		sb.append("</req>");
		sb.append("</"+transaction+">");
		sb.append("</v:Body>");
		sb.append( "</v:Envelope>");
		return sb.toString();
	}
	
}






