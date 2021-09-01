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

'For index >= 22, the responses use scientific notation so the result may not be exactly same as generated from this script.\r\nOnly checking if that there is a response. There is a computational limitation with the upper limit of 170!'
for (def index : (169..172)) {
    expectedResult = CustomKeywords.'factorial.Factorial.factorial'(index)

    WebUI.setText(findTestObject('Page_Factoriall/input_The greatest factorial calculator_number'), index.toString())

    WebUI.click(findTestObject('Page_Factoriall/button_Calculate'))

    resultText = WebUI.getText(findTestObject('Page_Factoriall/p_resultDiv'), FailureHandling.STOP_ON_FAILURE)

    'Expecting a result that has a numerical value; not "Infinity"'
    expPattern = (('^The factorial of ' + index) + ' is: \\d.*')

    WebUI.verifyMatch(resultText, expPattern, true, FailureHandling.CONTINUE_ON_FAILURE)
}

