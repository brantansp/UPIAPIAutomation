package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PostXML {

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
    
	public static void main(String[] args) throws Exception {
    	//request = "<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><ListRegPayee xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req><LastRec i:type=\"d:string\">1</LastRec><TypeInd i:type=\"d:string\">VIR</TypeInd><RecCount i:type=\"d:string\">1</RecCount><UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF51</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI></req></ListRegPayee></v:Body></v:Envelope>";
    	//StringBuilder sb = new StringBuilder();
    	//request = "<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><ListRegPayee xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req><LastRec i:type=\"d:string\">1</LastRec><TypeInd i:type=\"d:string\">VIR</TypeInd><RecCount i:type=\"d:string\">1</RecCount><UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF48</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI></req></ListRegPayee></v:Body></v:Envelope>";
    	//sendString("http://10.144.20.71:9095/UPIService?bridgeEndpoint=true",requestBuilder().toString());
    	
		//Write request working
		//XMLHelper.writeRequestToText(requestBuilder().toString());
		
		
		StringBuilder sb = new StringBuilder();
		  //Map<String, String> map = new HashMap<String, String>();
		
			String test = "Request=ListRegPayee;"
					+ "MobileNo=9791102968;"
					+ "PayerType=PERSON";	    
			Map<String, String> map = new HashMap<String, String>();
			//String test = "pet=cat;car=honda;location=Japan;food=sushi";
			String[] test1 = test.split(";");

			for (String s : test1) {
			    String[] t = s.split("=");
			    map.put(t[0], t[1]);
			}
//<UserID i:type="d:string">UserID</UserID>
			for (String s : map.keySet()) {
			    System.out.println("<"+s+" i:type=\"d:string\">"+ map.get(s)+"</UserID>");
			}
		System.out.println("here"+sb);
	}
	
	public static StringBuilder requestBuilder()
	{
		StringBuilder sb = new StringBuilder();
//		sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><");
//		sb.append("ListRegPayee");  //Transaction type
//		sb.append(" xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req><LastRec i:type=\"d:string\">1</LastRec><TypeInd i:type=\"d:string\">VIR</TypeInd><RecCount i:type=\"d:string\">1</RecCount>");
//		sb.append("<UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF52</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI>");
//		sb.append("</req></ListRegPayee></v:Body></v:Envelope>");
		
		String transaction = "GenerateVirAddr";
		
		sb.append("<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><");
		sb.append(transaction);
		sb.append(" xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req>");
		sb.append("<AccNumber i:type=\"d:string\">3699830038308</AccNumber><VirAddr i:type=\"d:string\">priya111@utbi</VirAddr><Validto i:type=\"d:string\">10-03-2020</Validto><TotalLmt i:type=\"d:string\"></TotalLmt><AvlLmt i:type=\"d:string\">15000.00</AvlLmt><Frequency i:type=\"d:string\">Muliple Use</Frequency>");
		sb.append("<UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSOn</PayerType><MobileNo i:type=\"d:string\">9943514226</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">578335d5</DeviceID><MsgId i:type=\"d:string\">UBIB7DDE000BB3E44268124675C15370751</MsgId><TimeStamp i:type=\"d:string\">1519014546</TimeStamp></UPI>");
		sb.append("</req></");
		sb.append(transaction);
		sb.append("></v:Body></v:Envelope>");
		
		return sb;
	}
	

	
	
	public static String sendString(String targetURL, String urlParameters)
    {
        java.net.URL url;
        HttpURLConnection connection = null;  
        try {
          url = new URL(targetURL);
          connection = (HttpURLConnection)url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("SOAPAction", "");
          connection.setUseCaches (false);
          connection.setDoInput(true);
          connection.setDoOutput(true);
          
          //Send request
          DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
          wr.writeBytes (urlParameters);
          wr.flush ();
          wr.close ();
          //Get Response    
          InputStream is ;
          log.info("response code="+connection.getResponseCode());
          if(connection.getResponseCode()<=400){
              is=connection.getInputStream();
          }else{
              /* error from server */
              is = connection.getErrorStream();
        } 
         // is= connection.getInputStream();
          BufferedReader rd = new BufferedReader(new InputStreamReader(is));
          String line;
          StringBuffer response = new StringBuffer(); 
          while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
          }
          rd.close();
          log.info("response"+response.toString());
          return response.toString();

        } catch (Exception e) {
        	log.info("here"+e);
          return null;

        } finally {

          if(connection != null) {
            connection.disconnect(); 
          }
        }}
	
}






