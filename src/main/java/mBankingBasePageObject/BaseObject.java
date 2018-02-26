package mBankingBasePageObject;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.Hmac;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.RandomNumGenerator;
import mBankingUtilityCenter.dbTransactionlog;
import mBankingUtilityCenter.WriteToCSVFile;
import mBankingUtilityCenter.XMLBuilder;

/**
 * 
 * @author brantansp
 *
 */

public class BaseObject {
static HttpConnect obj=new HttpConnect();
public static String response="";
private static String dbResult[];
public static String transactionID = "";
public static ExtentReports extent;
public static ExtentTest test;

private static Log log = LogFactory.getLog(BaseObject.class);

public static String buildRequest(int index)
{
	log.info("******************************START******************************");

	try {
		//System.out.println("Request : "+Request);
		response = HttpConnect.postXML(XMLBuilder.requestBuilder(index));
		log.info("Response received from Server : "+response);
		/*transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
		log.info("Transaction ID : "+transactionID);
	*/
		if(true)
		{
			dbResult = dbTransactionlog.fetchRecord("VJB91D569AF1AEC4227B7D8B43D82A810BC");
			//System.out.println(StaticStore.menuDesc[index][0]);
			log.info("DB Result : "+dbResult);
			WriteToCSVFile.reportGeneration( dbResult);
		}		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("******************************END********************************\r\n");
		return  response;
  }

public static void main(String[] args) throws IOException {
	HttpConnect.postXML(XMLBuilder.changePin());
}
public static void assertResponse(String response)
{
 assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));		
}
}










