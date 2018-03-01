package mBankingControlCenter;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.Properties;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.Report;
import mBankingUtilityCenter.XMLBuilder;
import mBankingUtilityCenter.Db;

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
	public static String rrn;
	private static String dbResult[];
	private static String dbReport= "Y";	
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
		if(dbReport=="Y")
		{
			Report.write(Db.fetchTxn(getTranID(response)));
		}
		assertTrue (getResCode(response).contains("000"));
	}


	@Test
	public void RegisterAcc(String accno) throws IOException, SQLException {
	response = postXML(XMLBuilder.RegisterAcc(accno));
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
	public void GenerateVirAddr(String accno) throws IOException, SQLException {
		

		response = postXML(XMLBuilder.GenerateVirAddr(accno));
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
	public void MobBankRegistration(String accno) throws IOException, SQLException {
		
		response = postXML(XMLBuilder.MobBankRegistration(accno));
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
	public void RemoveRegVirAddr(String viraddr) throws IOException, SQLException {
		
		response = postXML(XMLBuilder.RemoveRegVirAddr(viraddr));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
		
	@Test
	public void ListRegPayee() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ListRegPayee());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));

	}
	@Test
	public void BalanceInq() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.BalanceInq());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	
	@Test
	public void CheckTxnStatus() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.CheckTxnStatus());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public void TxnList() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.TxnList());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	
@Test
public void AddBankTransactionPositiveFlow() throws IOException,SQLException{
			
			response = HttpConnect.postXML(XMLBuilder.AddBank());
			String bankid = response.substring(response.lastIndexOf("<BankId ")+8,response.lastIndexOf("</BankId "));
			response = postXML(XMLBuilder.ViewRegAccnts(bankid));
			String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
			response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

@Test
public void AddVPATransactionPositiveFlow() throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNumber ")+21, response.lastIndexOf("</AccNumber>"));
	response = postXML(XMLBuilder.GenerateVirAddr(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public void SetUPIPinTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+21, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.MobBankRegistration(accno));
	         /*                                 response=cardNumvEr(String lastSixdigit)
	                                      String OTP =    otp(rrn(response))
	response = HttpConnect.postXML(XMLBuilder.GenerateBankOTP(OTP)); */
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
	
@Test
public void ManageAccountTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+21, response.lastIndexOf("</AccNo>"));
	/*
	 *  Code for getting vir address from DB based on acc no
	 */
	String viraddr="mouni";
	response = postXML(XMLBuilder.RemoveRegVirAddr(viraddr));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
			
}
@Test
public void ChangeUPIPinTransactionPositiveFlow() throws IOException,SQLException{
	String AccNo;
	response = postXML(XMLBuilder.ViewRegAccnts());
	response = postXML(XMLBuilder.ChangePin());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}
@Test
public void ParticipantsTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ListRegPayee());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
@Test
public void BalanceEnquiryTransactionPositiveFlow()throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	response = postXML(XMLBuilder.BalanceInq());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
@Test
public void PendingApprovalTransactionPositiveFlow()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.listpendingapproval());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
	
}
@Test
public void SendMoneyTransactionPositiveFlow()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	response = postXML(XMLBuilder.ReqValAddress());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
@Test
public void CollectMoneyTransactionPositiveFlow()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.CollectMoney());
	response = postXML(XMLBuilder.listpendingapproval());
	response = postXML(XMLBuilder.ConfirmCollectMoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
@Test
public void TransactionStatusPositiveFlow() throws IOException,SQLException{
	
	response = postXML(XMLBuilder.CheckTxnStatus());
	response = postXML(XMLBuilder.TxnList());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
	
}

	public static void main(String[] args) throws IOException, SQLException {
		/*response = postXML(XMLBuilder.AddBank());
		if(true)
		{
			dbResult = Db.fetchTxn(rrn);
			System.out.println("DB Result : "+dbResult);
			Report.write( dbResult);
		}		
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));*/


		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<AccNo ")+21, response.lastIndexOf("</AccNo>"));
		response = postXML(XMLBuilder.MobBankRegistration(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		//test


	}
}














