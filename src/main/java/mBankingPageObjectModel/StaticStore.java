package mBankingPageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import mBankingUtilityCenter.RandomNumGenerator;

/**
 * 
 * @author brantansp
 *
 */
public class StaticStore {
	protected static Properties prop;
	public static Properties dbprop;
	//public static String MSGID =RandomNumGenerator.genarate(32);
	public static void main(String[] args) {

	}
	
	/*
	 * 0
	 */
	public static void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Requests\\requests.properties")));
		dbprop = new  Properties();
		dbprop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\property\\UPI.db")));
	}
	
	static{
		try {
			loadObjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//prop.getProperty("OrgId")
	
	/*
	 * <req> XML template
	 */
	public static String ReqMenuDesc[][] = new String[][]{
		{"Request=Login","ReqMethodType="+prop.getProperty("login.ReqMethodType"),"MobileOsType="+prop.getProperty("login.MobileOsType"),"GcmID="+prop.getProperty("login.GcmID"),"AppPwd="+prop.getProperty("login.AppPwd")}, //0 #Login
		{"Request=BalanceInq","AddrType="+prop.getProperty("balInq.AddrType"),"PayerCode="+prop.getProperty("balInq.PayerCode"),"Pin="+prop.getProperty("balInq.Pin"),"AccNo="+prop.getProperty("balInq.AccNo"),"DevType="+prop.getProperty("balInq.DevType"),"DevIp="+prop.getProperty("balInq.DevIp"),"DevOs="+prop.getProperty("balInq.DevOs"),"DevId="+prop.getProperty("balInq.DevId"),"DevApp="+prop.getProperty("balInq.DevApp"),"CredType="+prop.getProperty("balInq.CredType"),"DevLocation="+prop.getProperty("balInq.DevLocation"),"KeyCode="+prop.getProperty("balInq.KeyCode"),"KeyIndex="+prop.getProperty("balInq.KeyIndex"),"GeoCode="+prop.getProperty("balInq.GeoCode"),"DevCapability="+prop.getProperty("balInq.DevCapability")},   //1 #BalanceInquiry
		{"Request=AddBank",""},//2 #AddBank
		{"Request=MobBankRegistration","AddrType="+prop.getProperty("Setpin.AddrType"),"AccType="+prop.getProperty("Setpin.AccType"),"OTP="+prop.getProperty("Setpin.OTP"),"AccNo="+prop.getProperty("Setpin.AccNo"),"DevType="+prop.getProperty("Setpin.DevType"),"DevIp="+prop.getProperty("Setpin.DevIp"),"DevOs="+prop.getProperty("Setpin.DevOs"),"ATMPIN="+prop.getProperty("Setpin.ATMPIN"),"IFSC="+prop.getProperty("Setpin.IFSC"),"DevId="+prop.getProperty("Setpin.DevId"),"DevApp="+prop.getProperty("Setpin.DevApp"),"CredType="+prop.getProperty("Setpin.CredType"),"DevLocation="+prop.getProperty("Setpin.DevLocation"),"PayerAccNo="+prop.getProperty("Setpin.PayerAccNo"),"PIN="+prop.getProperty("Setpin.PIN"),"KeyCode="+prop.getProperty("Setpin.KeyCode"),"CardDigits="+prop.getProperty("Setpin.CardDigits"),"ExpDate="+prop.getProperty("Setpin.ExpDate"),"KeyIndex="+prop.getProperty("Setpin.KeyIndex"),"GeoCode="+prop.getProperty("Setpin.GeoCode"),"DevCapability="+prop.getProperty("Setpin.DevCapability")}, //3 #Set UPI pin
		{"Request=ChangePin","OldPin"+prop.getProperty("Changepin.OldPin"),"NewKeyIndex"+prop.getProperty("Changepin.NewKeyIndex"),"OldKeyIndex"+prop.getProperty("Changepin.OldKeyIndex"),"DevType"+prop.getProperty("Changepin.DevType"),"DevIp"+prop.getProperty("Changepin.DevIp"),"DevOs"+prop.getProperty("Changepin.DevOs"),"DevId"+prop.getProperty("Changepin.DevId"),"DevApp"+prop.getProperty("Changepin.DevApp"),"CredType"+prop.getProperty("Changepin.CredType"),"DevLocation"+prop.getProperty("Changepin.DevLocation"),"PayerAccNo"+prop.getProperty("Changepin.PayerAccNo"),"BankName"+prop.getProperty("Changepin.BankName"),"NewPin"+prop.getProperty("Changepin.NewPin"),"NewKeyCode"+prop.getProperty("Changepin.NewKeyCode"),"GeoCode"+prop.getProperty("Changepin.GeoCode"),"DevCapability"+prop.getProperty("Changepin.DevCapability"),"OldKeyCode"+prop.getProperty("Changepin.OldKeyCode")},//4 #Change UPI pin
		{"Request=SendMoney","AddrType"+prop.getProperty("Remonusdeb.AddrType"),"PayeeVirAddr"+prop.getProperty("Remonusdeb.PayeeVirAddr"),"ReqMethodType"+prop.getProperty("Remonusdeb.ReqMethodType "),"PayerCode"+prop.getProperty("Remonusdeb.PayerCode"),"Pin"+prop.getProperty("Remonusdeb.Pin"),"NickName"+prop.getProperty("Remonusdeb.NickName"),"PayeeName"+prop.getProperty("Remonusdeb.PayeeName"),"CurrencyCode"+prop.getProperty("Remonusdeb.CurrencyCode"),"payeeTranserType"+prop.getProperty("Remonusdeb.payeeTranserType"),"DevType"+prop.getProperty("Remonusdeb.DevType"),"DevIp"+prop.getProperty("Remonusdeb.DevIp"),"DevOs"+prop.getProperty("Remonusdeb.DevOs"),"DevId"+prop.getProperty("Remonusdeb.DevId"),"DevApp"+prop.getProperty("Remonusdeb.DevApp"),"CredType"+prop.getProperty("Remonusdeb.CredType"),"PayerAccNo"+prop.getProperty("Remonusdeb.PayerAccNo"),"DevLocation"+prop.getProperty("Remonusdeb.DevLocation"),"PayeeCode"+prop.getProperty("Remonusdeb.PayeeCode"),"Amount"+prop.getProperty("Remonusdeb.Amount"),"KeyCode"+prop.getProperty("Remonusdeb.KeyCode"),"KeyIndex"+prop.getProperty("Remonusdeb.KeyIndex"),"PayerVirAddr"+prop.getProperty("Remonusdeb.PayerVirAddr"),"GeoCode"+prop.getProperty("Remonusdeb.GeoCode"),"DevCapability"+prop.getProperty("Remonusdeb.DevCapability")},//#5 Remote onus debit
		{"Request=RegisterAcc","DType"+prop.getProperty("Accreg.DType"),"IFSC"+prop.getProperty("Accreg.IFSC"),"AccType"+prop.getProperty("Accreg.AccType"),"AccRefNumber"+prop.getProperty("Accreg.AccRefNumber"),"VerifiedName"+prop.getProperty("Accreg.VerifiedName"),"MBEBA"+prop.getProperty("Accreg.MBEBA"),"AEBA"+prop.getProperty("Accreg.AEBA"),"BankName"+prop.getProperty("Accreg.BankName"),"DLength"+prop.getProperty("Accreg.DLength"),"AccNo"+prop.getProperty("Accreg.AccNo")},//#6 Account registration
	};
	
	/*
	 * <UPI> XML template
	 */
	public static String UPIMenuDesc[][] = new String[][] {
		{"Request=Login","UserID="+prop.getProperty("login.UserID"),"BankId="+prop.getProperty("login.BankId"),"OrgId="+prop.getProperty("login.OrgId"),"PayerType="+prop.getProperty("login.PayerType"),"MobileNo="+prop.getProperty("login.MobileNo"),"Remarks="+prop.getProperty("login.Remarks"),"PayerCode="+prop.getProperty("login.PayerCode"),"Channel="+prop.getProperty("login.Channel"),"AppVersion="+prop.getProperty("login.AppVersion"),"UserPwd="+prop.getProperty("login.UserPwd"),"DeviceID="+prop.getProperty("login.DeviceID"),"MsgId="+prop.getProperty("login.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp="+prop.getProperty("login.TimeStamp")},   //0  #Login
        {"Request=BalanceInq","UserID="+prop.getProperty("balInq.UserID"),"BankId="+prop.getProperty("balInq.BankId"),"OrgId="+prop.getProperty("balInq.OrgId"),"PayerType	="+prop.getProperty("balInq.PayerType"),"MobileNo="+prop.getProperty("balInq.MobileNo"),"Remarks	="+prop.getProperty("balInq.Remarks"),"PayerCode="+prop.getProperty("balInq.PayerCode"),"Channel="+prop.getProperty("balInq.Channel"),"AppVersion="+prop.getProperty("balInq.AppVersion"),"UserPwd="+prop.getProperty("balInq.UserPwd"),"DeviceID="+prop.getProperty("balInq.DeviceID"),"MsgId="+prop.getProperty("balInq.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp="+prop.getProperty("balInq.TimeStamp")},   //1 #BalanceInquiry
		{"Request=AddBank","UserID="+prop.getProperty("AddBank.UserID"),"BankId="+prop.getProperty("AddBank.BankId"),"OrgId="+prop.getProperty("AddBank.OrgId"),"PayerType="+prop.getProperty("AddBank.PayerType"),"MobileNo="+prop.getProperty("AddBank.MobileNo"),"Remarks="+prop.getProperty("AddBank.Remarks"),"PayerCode="+prop.getProperty("AddBank.PayerCode"),"Channel="+prop.getProperty("AddBank.Channel"),"AppVersion="+prop.getProperty("AddBank.AppVersion"),"UserPwd="+prop.getProperty("AddBank.UserPwd"),"DeviceID="+prop.getProperty("AddBank.DeviceID"),"MsgId="+prop.getProperty("AddBank.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp="+prop.getProperty("AddBank.TimeStamp")} ,//2 #AddBank
        {"Request=MobBankRegistration","UserID="+prop.getProperty("Setpin.UserID"),"BankId="+prop.getProperty("Setpin.BankId"),"OrgId="+prop.getProperty("Setpin.OrgId"),"PayerType="+prop.getProperty("Setpin.PayerType"),"MobileNo="+prop.getProperty("Setpin.MobileNo"),"Remarks="+prop.getProperty("Setpin.Remarks"),"PayerCode="+prop.getProperty("Setpin.PayerCode"),"Channel="+prop.getProperty("Setpin.Channel"),"AppVersion="+prop.getProperty("Setpin.AppVersion"),"UserPwd="+prop.getProperty("Setpin.UserPwd"),"DeviceID="+prop.getProperty("Setpin.DeviceID"),"MsgId="+prop.getProperty("Setpin.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp="+prop.getProperty("Setpin.TimeStamp")}, //3 #Set UPI pin
        {"Request=ChangePin","UserID"+prop.getProperty("Changepin.UserID"),"BankId"+prop.getProperty("Changepin.BankId"),"OrgId"+prop.getProperty("Changepin.OrgId"),"PayerType"+prop.getProperty("Changepin.PayerType"),"MobileNo"+prop.getProperty("Changepin.MobileNo"),"Remarks"+prop.getProperty("Changepin.Remarks"),"PayerCode"+prop.getProperty("Changepin.PayerCode"),"Channel"+prop.getProperty("Changepin.Channel"),"AppVersion"+prop.getProperty("Changepin.AppVersion"),"UserPwd"+prop.getProperty("Changepin.UserPwd"),"DeviceID"+prop.getProperty("Changepin.DeviceID"),"MsgId"+prop.getProperty("Changepin.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp"+prop.getProperty("Changepin.TimeStamp")},//4 #Change UPI pin
        {"Request=SendMoney","UserID"+prop.getProperty("Remonusdeb.UserID"),"BankId"+prop.getProperty("Remonusdeb.BankId"),"OrgId"+prop.getProperty("Remonusdeb.OrgId"),"PayerType"+prop.getProperty("Remonusdeb.PayerType"),"MobileNo"+prop.getProperty("Remonusdeb.MobileNo"),"Remarks"+prop.getProperty("Remonusdeb.Remarks"),"PayerCode"+prop.getProperty("Remonusdeb.PayerCode"),"Channel"+prop.getProperty("Remonusdeb.Channel"),"AppVersion"+prop.getProperty("Remonusdeb.AppVersion"),"UserPwd"+prop.getProperty("Remonusdeb.UserPwd"),"DeviceID"+prop.getProperty("Remonusdeb.DeviceID"),"MsgId"+prop.getProperty("Remonusdeb.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp"+prop.getProperty("Remonusdeb.TimeStamp")},//#5 Remote ONUS debit
        {"Request=RegisterAcc","UserID"+prop.getProperty("Accreg.UserID"),"BankId"+prop.getProperty("Accreg.BankId"),"OrgId"+prop.getProperty("Accreg.OrgId"),"PayerType"+prop.getProperty("Accreg.PayerType"),"MobileNo"+prop.getProperty("Accreg.MobileNo"),"Remarks"+prop.getProperty("Accreg.Remarks"),"PayerCode"+prop.getProperty("Accreg.PayerCode"),"Channel"+prop.getProperty("Accreg.Channel"),"AppVersion"+prop.getProperty("Accreg.AppVersion"),"UserPwd"+prop.getProperty("Accreg.UserPwd"),"DeviceID"+prop.getProperty("Accreg.DeviceID"),"MsgId"+prop.getProperty("Accreg.MsgId")+RandomNumGenerator.genarate(32),"TimeStamp"+prop.getProperty("Accreg.TimeStamp")},//#6 Account registration
	};
	


}
