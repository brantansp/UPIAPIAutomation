package mBankingPageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author brantansp
 *
 */
public class StaticStore {
	protected static Properties prop;
	
	/*
	 * 0
	 */
	public static void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./Requests/requests.properties")));
	}
	
	static{
		try {
			loadObjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {


	}
	
	//prop.getProperty("OrgId")
	
	/*
	 * <req> XML template
	 */
	public static String ReqMenuDesc[][] = new String[][]{
		{"Request=Login","ReqMethodType="+prop.getProperty("login.ReqMethodType"),"MobileOsType="+prop.getProperty("login.MobileOsType"),"GcmID="+prop.getProperty("login.GcmID"),"AppPwd="+prop.getProperty("login.AppPwd")}, //0 #Login
		{"Request=BalanceInq","AddrType="+prop.getProperty("balInq.AddrType"),"PayerCode="+prop.getProperty("balInq.PayerCode"),"Pin="+prop.getProperty("balInq.Pin"),"AccNo="+prop.getProperty("balInq.AccNo"),"DevType="+prop.getProperty("balInq.DevType"),"DevIp="+prop.getProperty("balInq.DevIp"),"DevOs="+prop.getProperty("balInq.DevOs"),"DevId="+prop.getProperty("balInq.DevId"),"DevApp="+prop.getProperty("balInq.DevApp"),"CredType="+prop.getProperty("balInq.CredType"),"DevLocation="+prop.getProperty("balInq.DevLocation"),"KeyCode="+prop.getProperty("balInq.KeyCode"),"KeyIndex="+prop.getProperty("balInq.KeyIndex"),"GeoCode="+prop.getProperty("balInq.GeoCode"),"DevCapability="+prop.getProperty("balInq.DevCapability")},   //1 #BalanceInquiry
		{"Request=AddBank",""} //2 #AddBank
	};
	
	/*
	 * <UPI> XML template
	 */
	public static String UPIMenuDesc[][] = new String[][] {
		{"Request=Login","UserID="+prop.getProperty("login.UserID"),"BankId="+prop.getProperty("login.BankId"),"OrgId="+prop.getProperty("login.OrgId"),"PayerType="+prop.getProperty("login.PayerType"),"MobileNo="+prop.getProperty("login.MobileNo"),"Remarks="+prop.getProperty("login.Remarks"),"PayerCode="+prop.getProperty("login.PayerCode"),"Channel="+prop.getProperty("login.Channel"),"AppVersion="+prop.getProperty("login.AppVersion"),"UserPwd="+prop.getProperty("login.UserPwd"),"DeviceID="+prop.getProperty("login.DeviceID"),"MsgId="+prop.getProperty("login.MsgId"),"TimeStamp="+prop.getProperty("login.TimeStamp")},   //0  #Login
        {"Request=BalanceInq","UserID="+prop.getProperty("balInq.UserID"),"BankId="+prop.getProperty("balInq.BankId"),"OrgId="+prop.getProperty("balInq.OrgId"),"PayerType	="+prop.getProperty("balInq.PayerType"),"MobileNo="+prop.getProperty("balInq.MobileNo"),"Remarks	="+prop.getProperty("balInq.Remarks"),"PayerCode="+prop.getProperty("balInq.PayerCode"),"Channel="+prop.getProperty("balInq.Channel"),"AppVersion="+prop.getProperty("balInq.AppVersion"),"UserPwd="+prop.getProperty("balInq.UserPwd"),"DeviceID="+prop.getProperty("balInq.DeviceID"),"MsgId="+prop.getProperty("balInq.MsgId"),"TimeStamp="+prop.getProperty("balInq.TimeStamp")},   //1 #BalanceInquiry
		{"Request=AddBank","UserID="+prop.getProperty("AddBank.UserID"),"BankId="+prop.getProperty("AddBank.BankId"),"OrgId="+prop.getProperty("AddBank.OrgId"),"PayerType="+prop.getProperty("AddBank.PayerType"),"MobileNo="+prop.getProperty("AddBank.MobileNo"),"Remarks="+prop.getProperty("AddBank.Remarks"),"PayerCode="+prop.getProperty("AddBank.PayerCode"),"Channel="+prop.getProperty("AddBank.Channel"),"AppVersion="+prop.getProperty("AddBank.AppVersion"),"UserPwd="+prop.getProperty("AddBank.UserPwd"),"DeviceID="+prop.getProperty("AddBank.DeviceID"),"MsgId="+prop.getProperty("AddBank.MsgId"),"TimeStamp="+prop.getProperty("AddBank.TimeStamp")} //2 #AddBank
	};
	


}
