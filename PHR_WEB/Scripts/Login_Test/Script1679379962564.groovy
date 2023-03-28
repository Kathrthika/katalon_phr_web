import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
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
import com.sun.org.apache.xpath.internal.compiler.Keywords

import groovy.util.logging.Commons
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String loginportalurl = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('url', 2, 1)
String loginmobile = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('numbers', 2, 3)
String dbname = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 1)
String dbuser = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 2)
String dbpassword = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 3)




println("loginportalurl is "+loginportalurl)
println("loginmobile is "+loginmobile)
println("dbname is "+dbname)
println("dbuser is "+dbuser)
println("dbpassword is "+dbpassword)
//println("getOTP is "+getOTP)


//Open the chrome browser
WebUI.openBrowser('')
//Enter the url
WebUI.navigateToUrl(loginportalurl)
//maximize the window
WebUI.maximizeWindow();
//verify login button and click on login button
WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),0)
WebUI.click(findTestObject('Object Repository/phr_elements_landing_page/login_button'))

//verify login page title
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/login_page_header'), 0)

//Verify mobile number field
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), loginmobile)

//Verify get OTP button
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'),0)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'))
sleep(5000)



//Get otp from db
String getOTP = CustomKeywords.'phrweb_common_keys.GetValues.getOtp'(loginmobile, dbname, dbuser, dbpassword)

char o1 = getOTP[0]
String otp1 = o1;

char o2 = getOTP[1]
String otp2 = o2;

char o3 = getOTP[2]
String otp3 = o3;

char o4 = getOTP[3]
String otp4 = o4;

char o5 = getOTP[4]
String otp5 = o5;

char o6 = getOTP[5]
String otp6 = o6;


//verify otp fields
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field1'),0)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field1'), otp1)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field2'), otp2)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field3'), otp3)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field4'), otp4)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field5'), otp5)
sleep(500)
WebUI.setText(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field6'), otp6)
sleep(500)

//Verify the bookings tab
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/booking_tab'), 0)


//Click on user drop down and click log out

WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'))
sleep(500)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/logout_button'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/logout_button'))

WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),0)
WebUI.closeBrowser();



