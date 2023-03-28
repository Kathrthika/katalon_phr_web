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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import internal.GlobalVariable as GlobalVariable


import org.openqa.selenium.Keys as Keys

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.By as By

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import org.openqa.selenium.WebDriver as WebDriver

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
import org.openqa.selenium.WebDriver as WebDriver

import groovy.util.logging.Commons
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String loginportalurl = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('url', 2, 1)
String loginmobile = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('numbers', 3, 3)
String dbname = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 1)
String dbuser = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 2)
String dbpassword = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('phr_sqa_db', 2, 3)

String patient_name = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('patient', 3, 1)
//String patient_dob = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('patient', 2, 2)
//String patient_email = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('patient', 2, 3)
//String patient_pincode = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('patient', 2, 4)



String drname = CustomKeywords.'phrweb_common_keys.GetValues.getExcelValues'('numbers', 3, 4)




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
WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),30)
WebUI.click(findTestObject('Object Repository/phr_elements_landing_page/login_button'))

//verify login page title
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/login_page_header'), 30)

String getOTPIDbeforegetOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
if(getOTPIDbeforegetOtp == null)
{
	getOTPIDbeforegetOtp = 0;
}
println("getOTPIDbeforegetOtp :"+getOTPIDbeforegetOtp)
int i=Integer.parseInt(getOTPIDbeforegetOtp);
println("i =  "+i)


//Verify mobile number field
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), loginmobile)

//Verify get OTP button
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'))
sleep(5000)

String getOTPIDaftertOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
println("getOTPIDaftertOtp :"+getOTPIDaftertOtp)
int j=Integer.parseInt(getOTPIDaftertOtp);
println("j =  "+j)

String getOTP ;
if (i<j)
   {
	 getOTP = CustomKeywords.'phrweb_common_keys.GetValues.getOtp'(loginmobile, dbname, dbuser, dbpassword)
  }
else
	{
	
 sleep(5000)
 getOTP = CustomKeywords.'phrweb_common_keys.GetValues.getOtp'(loginmobile, dbname, dbuser, dbpassword)
 }

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
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_verify_otp_page/otp_field1'),30)
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

WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/booking_tab'), 30)
sleep(500)




WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/bookings_drop_down'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/bookings_drop_down'))


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/my_consultation_option'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/my_consultation_option'))


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'),patient_name)

  
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/booked_status'), 30)



WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'))


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_reschedule_option'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_reschedule_option'))



WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/reschedule_appointment_popup_title'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/reschedule_appointment_popup_title'))


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/yes_button_on_reschedule_appointment_popup'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/yes_button_on_reschedule_appointment_popup'))


sleep(2000)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/select_slot_page_title'), 30)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'))

WebUI.scrollToElement(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'))



WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_patient_details_page/reschedule_button'),30)
WebUI.click(findTestObject('Object Repository/phr_elements_patient_details_page/reschedule_button'))


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'),patient_name)


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/rescheduled_status_for_search_patient'),30)



WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'))
sleep(500)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/logout_button'), 30)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/logout_button'))

WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),30)
WebUI.closeBrowser()











