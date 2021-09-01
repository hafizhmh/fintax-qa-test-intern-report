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

WebUI.navigateToUrl('http://qainterview.pythonanywhere.com/')

'Prompt example: There is a validation that the input should be integer'
WebUI.setText(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), 'a')

WebUI.click(findTestObject('Object Repository/Page_Factoriall/button_Calculate'))

resultText = WebUI.getText(findTestObject('Page_Factoriall/p_resultDiv'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch(resultText, '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

WebUI.setText(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), '-1')

WebUI.click(findTestObject('Object Repository/Page_Factoriall/button_Calculate'))

resultText = WebUI.getText(findTestObject('Page_Factoriall/p_resultDiv'), FailureHandling.STOP_ON_FAILURE)

'Verify that there is a form validation that the input should be positive integers only'
WebUI.verifyNotMatch(resultText, '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), '-10')

WebUI.click(findTestObject('Object Repository/Page_Factoriall/button_Calculate'))

resultText = WebUI.getText(findTestObject('Page_Factoriall/p_resultDiv'), FailureHandling.STOP_ON_FAILURE)

'Verify that there is a form validation that the input should be positive integers only'
WebUI.verifyNotMatch(resultText, '', false, FailureHandling.CONTINUE_ON_FAILURE)

