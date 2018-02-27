package mBankingControlCenter;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.Properties;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.WriteToCSVFile;
import mBankingUtilityCenter.XMLBuilder;
import mBankingUtilityCenter.dbTransactionlog;

import org.testng.annotations.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * 
 * @author brantansp
 *
 */

public class Transactions extends ExtentManager{
	private static String response;
	static HttpConnect obj=new HttpConnect();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	protected static Properties prop;
	public static Properties dbprop;
	private static String dbResult[];
	
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	static{
		try {
			prop =XMLBuilder.loadObjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void AddBank() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.AddBank());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	
	@Test
	public void ListBankAcc() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ListBankAcc());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public void RegisterAcc() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.RegisterAcc());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void ConfirmCollectMoney() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ConfirmCollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void listpendingapproval() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.listpendingapproval());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void GenerateVirAddr() throws IOException, SQLException {
		

		response = postXML(XMLBuilder.GenerateVirAddr());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void ViewRegAccnts() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void GenerateBankOTP() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.GenerateBankOTP());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void MobBankRegistration() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.MobBankRegistration());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void ReqValAddress() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ReqValAddress());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void CollectMoney() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
		
	@Test
	public void AddBankTransactionPositiveFlow() throws IOException,SQLException{
		
		response = postXML(XMLBuilder.AddBank());
		response = postXML(XMLBuilder.ListBankAcc());
		response = postXML(XMLBuilder.ViewRegAccnts());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	
	public static void main(String[] args) throws IOException, SQLException {
		response = postXML(AddBank());
		if(true)
		{
			dbResult = dbTransactionlog.fetchRecord("VJB91D569AF1AEC4227B7D8B43D82A810BC");
			System.out.println("DB Result : "+dbResult);
			WriteToCSVFile.reportGeneration( dbResult);
		}		
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
}














