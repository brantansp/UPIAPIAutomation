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
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
/**
 * 
 * @author brantansp
 *
 */
public class ExtentManager{
	
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	protected static Properties prop;
	public static Properties dbprop;
	static String targetURL="http://10.144.20.71:9095/UPIService?bridgeEndpoint=true";
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	static{
		try {
			propertyLoader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void setUp(){
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

	@BeforeMethod
	public void beforeMethod(Method method)
	{
		extentLogger = extent.startTest(this.getClass().getSimpleName()+ " ::  " +method.getName(), method.getName()); 
		extentLogger.assignAuthor("Brantan sp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log( LogStatus.PASS, "Test started successfully");
	}
		
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}extent.endTest(extentLogger);
	}
	
	@AfterSuite
	public void endReport(){ 
                extent.flush();
    } 

    public static void propertyLoader() throws FileNotFoundException, IOException
    {
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Requests\\requestsparam.properties")));
		dbprop = new  Properties();
		dbprop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\property\\UPI.db")));
    }

    public static String postXML(String urlParams) throws IOException
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
          wr.writeBytes (urlParams);
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
        }
	
    }
}



