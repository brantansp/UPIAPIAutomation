package mBankingControlCenter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import mBankingUtilityCenter.HttpConnect;

public class SendReq {

	public static void main(String[] args) throws IOException {
		//HttpConnect conn=new HttpConnect();
		//conn.Post("9894060407APBE;Y;143728359323132456871830477028309680594;403362;123457;4.0.5;1434134124123431;49175274512454");
		String request = "";
	request = "<v:Envelope xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\"><v:Header /><v:Body><ListRegPayee xmlns=\"http://com/fss/upi\" id=\"o0\" c:root=\"1\"><req><LastRec i:type=\"d:string\">1</LastRec><TypeInd i:type=\"d:string\">VIR</TypeInd><RecCount i:type=\"d:string\">1</RecCount><UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"></Remarks><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBI7F75A4E96CA84002A6FC8E3DA89FAF48</MsgId><TimeStamp i:type=\"d:string\">1519016595</TimeStamp></UPI></req></ListRegPayee></v:Body></v:Envelope>";
		
//request = "<AddBank xmlns=\"http://com/fss/upi\" xmlns:c=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:d=\"http://www.w3.org/1999/XMLSchema\" xmlns:i=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:v=\"http://schemas.xmlsoap.org/soap/envelope/\" c:root=\"1\" id=\"o0\"><req><UPI><UserID i:type=\"d:string\">UserID</UserID><BankId i:type=\"d:string\">504511</BankId><OrgId i:type=\"d:string\">400046</OrgId><PayerType i:type=\"d:string\">PERSON</PayerType><MobileNo i:type=\"d:string\">9791102968</MobileNo><Remarks i:type=\"d:string\"/><PayerCode i:type=\"d:string\">0000</PayerCode><Channel i:type=\"d:string\">03</Channel><AppVersion i:type=\"d:string\">1.1.1</AppVersion><UserPwd i:type=\"d:string\">111111</UserPwd><DeviceID i:type=\"d:string\">69ff6866</DeviceID><MsgId i:type=\"d:string\">UBIBDF4B7BAD10B4511BAE6AA16C99E3664</MsgId><TimeStamp i:type=\"d:string\">1516081860</TimeStamp></UPI></req></AddBank>";
				
		
     	Post(request);
	}
	public static String Post(String request) throws IOException
	{
		//http://10.144.20.71:9095/UPIService
		URL url = new URL("http://10.144.20.71:9095/UPIService"+request);
	   
	        StringBuilder postData = new StringBuilder();
	   
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	        conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	 
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String response = in.readLine();
	        return response;
	    }

}















