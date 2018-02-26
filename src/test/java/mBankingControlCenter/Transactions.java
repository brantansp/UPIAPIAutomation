package mBankingControlCenter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mBankingBasePageObject.BaseObject;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 
 * @author brantansp
 *
 */

public class Transactions extends ExtentManager{
	private static String response;
	private static int index;
	static HttpConnect obj=new HttpConnect();
	private static Log log = LogFactory.getLog(Transactions.class);
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void Login() throws IOException, SQLException {
		index=0; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	@Test
	public void BalanceInq() throws IOException, SQLException {
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}

	@Test
	public void AddBank() throws IOException, SQLException {
		index=2; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	@Test
	public void MobBankRegistration() throws IOException, SQLException {
		index=3; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	@Test
	public void ChangePin() throws IOException, SQLException {
		index=4; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	@Test
	public void SendMoney() throws IOException, SQLException {
		index=5; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	@Test
	public void RegisterAcc() throws IOException, SQLException {
		index=6; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
	
	public static void main(String[] args) throws IOException, SQLException {
        /**
         * For checking Single transactions
         */
		index=3; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response);
	}
}














