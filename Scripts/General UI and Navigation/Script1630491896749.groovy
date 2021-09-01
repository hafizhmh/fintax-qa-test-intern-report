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

baseURL = 'http://qainterview.pythonanywhere.com/'

WebUI.navigateToUrl(baseURL)

windowTitle = WebUI.getWindowTitle()

'Title tag should be "Factorial"'
WebUI.verifyMatch(windowTitle, 'Factorial', false, FailureHandling.CONTINUE_ON_FAILURE)

copyright = WebUI.getText(findTestObject('Page_Factoriall/p_Qxf2 Services document.write(new Date().getFullYear())2021 -                document.write(new Date().getFullYear())2021'))

'According to the Qxf2 Service web from the copyright link, the copyright year should be 2013 - <current year>'
WebUI.verifyMatch(copyright, '© Qxf2 Services 2013.*', true)

'Text should be "The greatest factorial calculator!"'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Factoriall/h1_The greatest factorial calculator'), 'The greatest factorial calculator!', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Factoriall/button_Calculate'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Factoriall/button_Calculate'), 'Calculate!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Factoriall/a_Privacy'))

urlPrivacy = WebUI.getUrl()

'Href from the last anchor should point to \'/privacy\''
WebUI.verifyMatch(urlPrivacy, baseURL + 'privacy', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.back()

WebUI.click(findTestObject('Object Repository/Page_Factoriall/a_Terms and Conditions'))

urlTerms = WebUI.getUrl()

'Href from the last anchor should point to \'/terms\''
WebUI.verifyMatch(urlTerms, baseURL + 'terms', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.back()

WebUI.setText(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), '1')

WebUI.click(findTestObject('Object Repository/Page_Factoriall/button_Calculate'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Factoriall/p_The factorial of 1 is 1'), 'The factorial of 1 is: 1', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

WebUI.setText(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), '1')

'Testing ENTER key to send input'
WebUI.sendKeys(findTestObject('Object Repository/Page_Factoriall/input_The greatest factorial calculator_number'), Keys.chord(
        Keys.ENTER))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Factoriall/p_The factorial of 1 is 1'), 'The factorial of 1 is: 1', 
    FailureHandling.OPTIONAL)

