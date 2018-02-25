package mBankingControlCenter;

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

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void Login() throws IOException, SQLException {
		index=0; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void BalanceInq() throws IOException, SQLException {
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void AddBank() throws IOException, SQLException {
		index=2; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	public static void main(String[] args) throws IOException, SQLException {
        /**
         * For checking Single transactions
         */
		index=0; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
		}
}














