package phrweb_common_keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import groovy.swing.factory.CellEditorFactory
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class GetValues {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	def String getExcelValues(String sheetName,int rownum, int colnum) {
		String path = 'C:\\Users\\339154\\OneDrive - Narayana Health\\PHR_AUTO_katalon\\PHR_MOBILE_NUMBERS2.xlsx';
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook =  new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rownum-1)
		String data  = row.getCell(colnum-1);
		fis.close();

		return data;
	}

	@Keyword
	def String getOtp(String mobilenumber,String url,String user,String password) {
		println("running get otp method")
		Connection conn = DriverManager.getConnection("jdbc:postgresql://"+url, user, password)
		Statement state = conn.createStatement();
		String querystring = "select substring(SPLIT_PART(template_data,':',2),2,6) from whats_app_data where to_number like '%"+mobilenumber+"' order by id desc limit 1";
		ResultSet resultset = state.executeQuery(querystring)
		//ResultSetMetaData metadata = resultset.getMetaData();
		String dbOtp ;
		while(resultset.next())
		{
			//dbOtp = resultset.getString('template_data');
			dbOtp = resultset.getString(1);
			println("printing inside while loop : "+dbOtp);
		}

		resultset.close();
		state.close();
		conn.close();
		return dbOtp;

	}
	@Keyword
	def String getOtpId(String mobilenumber,String url,String user,String password) {
		println("running get otp method")
		Connection conn = DriverManager.getConnection("jdbc:postgresql://"+url, user, password)
		Statement state = conn.createStatement();
		String querystring = "select id from whats_app_data where to_number like '%"+mobilenumber+"' order by id desc limit 1";
		ResultSet resultset = state.executeQuery(querystring)
		//ResultSetMetaData metadata = resultset.getMetaData();
		String dbOtp ;
		while(resultset.next())
		{
			//dbOtp = resultset.getString('template_data');
			dbOtp = resultset.getString(1);
			println("printing inside while loop : "+dbOtp);
		}

		resultset.close();
		state.close();
		conn.close();
		return dbOtp;

	}






}