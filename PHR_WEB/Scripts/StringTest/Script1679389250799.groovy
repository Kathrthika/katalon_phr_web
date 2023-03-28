import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.hamcrest.core.IsNull
import org.openqa.selenium.Keys as Keys


String loginportalurl = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('url', 2, 1)
String loginmobile = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('numbers', 3, 3)
String dbname = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 1)
String dbuser = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 2)
String dbpassword = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 3)

kk = "karthika";


char k1 = kk[0];
String ks1 = k1;
println(k1)

String getOTPIDbeforegetOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
int i=Integer.parseInt(getOTPIDbeforegetOtp);
println("i =  "+i)

String getOTPIDaftertOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
int j=Integer.parseInt(getOTPIDaftertOtp);
println("j =  "+j)

String t = null;
if(t== null) {
	t=0;
}

int k=Integer.parseInt(t);
println("k =  "+k)

