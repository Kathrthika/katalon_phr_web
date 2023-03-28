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
WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),0)
WebUI.click(findTestObject('Object Repository/phr_elements_landing_page/login_button'))

//verify login page title
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/login_page_header'), 0)

String getOTPIDbeforegetOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
if(getOTPIDbeforegetOtp == null)
{
	getOTPIDbeforegetOtp = 0;
}
int i=Integer.parseInt(getOTPIDbeforegetOtp);
println("i =  "+i)


//Verify mobile number field
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_login_page/mobile_number_field'), loginmobile)

//Verify get OTP button
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'),0)
WebUI.click(findTestObject('Object Repository/phr_elements_login_page/get_otp_button'))
sleep(5000)

String getOTPIDaftertOtp = CustomKeywords.'phrweb_common_keys.GetValues.getOtpId'(loginmobile, dbname, dbuser, dbpassword)
//println("getOTPIDbeforeLogin : "+getOTPIDbeforegetOtp)
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
sleep(500)


WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/header_doctor_search_field'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/header_doctor_search_field'))
WebUI.setText(findTestObject('Object Repository/phr_elements_home_page/header_doctor_search_field'),drname)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/searched_doctor_1st_from_the_list'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/searched_doctor_1st_from_the_list'))

WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/what_ur_looking_for'), 0)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/hospital_visit_button'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/hospital_visit_button'))


sleep(2000)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/select_slot_page_title'), 0)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'))

WebUI.scrollToElement(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'))

WebUI.verifyElementPresent(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span_Add New Patient'), 0)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_patient_details_page/book_appointment_button'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_patient_details_page/book_appointment_button'))


WebUI.verifyElementPresent(findTestObject('Object Repository/both_booking_confirmation_page/booking_confirmed_title'),0)
WebUI.verifyElementPresent(findTestObject('Object Repository/both_booking_confirmation_page/pay_online_button'), 0)
WebUI.click(findTestObject('Object Repository/both_booking_confirmation_page/pay_online_button'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUQUoy9Tudqdh3/input_Phone Number_contact'))
WebUI.setText(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUQUoy9Tudqdh3/input_Phone Number_contact'),'9738180860')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/button_Proceed'))


WebUI.scrollToElement(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Netbanking  All Indian banks'),0)
WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Netbanking  All Indian banks'))

WebUI.scrollToElement(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Yes'),0)
WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Yes'))

//WebUI.switchToWindowTitle('Narayana Health - Payment Link - LUBwzuFuh9oz2D')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/button_Pay Now'))


   WebDriver driver = DriverFactory.getWebDriver();       
   String mainWindowHandler = driver.getWindowHandle();
   
   Set<String> handles = driver.getWindowHandles();
   
   for(String handle : handles) {
	   if(!mainWindowHandler.equals(handle)) {
		   WebDriver popup = driver.switchTo().window(handle);
		   WebUI.click(findTestObject('Object Repository/recording_objects/Page_Razorpay Bank/button_Success'))
	   }
   }
   
   WebDriver popup = driver.switchTo().window(mainWindowHandler);
   sleep(3000)

  WebUI.navigateToUrl("http://172.23.27.80:6543/ocaapp/appointments")
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'), 0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'))
  WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'),'Karthik')
  
    
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/booked_status'), 0)
  
  

  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'))
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_reschedule_option'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_reschedule_option'))



  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/reschedule_appointment_popup_title'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/reschedule_appointment_popup_title'))


  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/yes_button_on_reschedule_appointment_popup'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/yes_button_on_reschedule_appointment_popup'))
  
  
  sleep(2000)
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/select_slot_page_title'), 0)
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'), 0)
  WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/3rd_available_slots'))
  
  WebUI.scrollToElement(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'), 0)
  WebUI.click(findTestObject('Object Repository/phr_elements_select_slot_page/continue_button'))
  
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_patient_details_page/reschedule_button'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_patient_details_page/reschedule_button'))
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'), 0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'))
  WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'),'Karthik')
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/rescheduled_status_for_search_patient'),0)
  

  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_for_searched_result'))
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_cancel_appointment_option'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/more_icon_cancel_appointment_option'))
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/cancel_appointment_popup_header'),0)
  

  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/others_option_on_cancel_appointment_popup'),0)

  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/others_option_on_cancel_appointment_popup'))
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/tell_us_more_field_on_cancel_appointment_popup'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/tell_us_more_field_on_cancel_appointment_popup'))
  WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/tell_us_more_field_on_cancel_appointment_popup'),'Cancelling from automation')
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/submit_button_on_cancel_appointment_popup'),0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/submit_button_on_cancel_appointment_popup'))

  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'), 0)
  WebUI.click(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'))
  WebUI.setText(findTestObject('Object Repository/phr_elements_consultation_list_page/patient_search_field'),'Karthik')
  
  
  
  WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_consultation_list_page/cancelled_appointment_status'),0)

//Click on user drop down and click log out

WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/user_selection_drop_down'))
sleep(500)
WebUI.verifyElementPresent(findTestObject('Object Repository/phr_elements_home_page/logout_button'), 0)
WebUI.click(findTestObject('Object Repository/phr_elements_home_page/logout_button'))

WebUI.verifyElementPresent((findTestObject('Object Repository/phr_elements_landing_page/login_button')),0)
WebUI.closeBrowser();

