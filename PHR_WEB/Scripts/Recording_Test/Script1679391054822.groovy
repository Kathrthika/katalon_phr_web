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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://172.23.27.80:6543/phrportal')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Login'))

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_IN_mobilenumber'), '1100000681')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Get OTP'))

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit1'), '2')

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit2'), '8')

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit3'), '6')

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit4'), '5')

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit5'), '8')

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Verify OTP_loginOtpdigit6'), '1')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/div_(General Medicine)_overlay'))

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input_Visakhapatnam_header-input-search-bar_5b2ba0'), 
    'karthi')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span_Karthi K'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span_Hospital Visit'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_745 PM'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Continue'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span_Add New Patient'))

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input__patientName'), 'manish')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span__icon-portal_calender'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/span_1'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/label_Male'))

WebUI.setText(findTestObject('Object Repository/recording_objects/Page_PHR Portal/input__patientPincode'), '560021')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Book Appointment'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Pay Online'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/button_Proceed'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Netbanking  All Indian banks'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/div_Yes'))

WebUI.switchToWindowTitle('Narayana Health - Payment Link - LUBwzuFuh9oz2D')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Narayana Health - Payment Link - LUBwz_272e9e/button_Pay Now'))

WebUI.click(findTestObject('Object Repository/recording_objects/Page_Razorpay Bank/button_Success'))

WebUI.switchToWindowTitle('PHR Portal')

WebUI.click(findTestObject('Object Repository/recording_objects/Page_PHR Portal/button_Done'))

