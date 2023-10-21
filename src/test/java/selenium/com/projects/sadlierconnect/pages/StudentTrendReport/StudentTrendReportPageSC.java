package selenium.com.projects.sadlierconnect.pages.StudentTrendReport;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.FileHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.StudentTrendReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.ObjectUtils;

import java.io.IOException;
import java.util.Hashtable;

public class StudentTrendReportPageSC extends CommonPageSC {

    private  final  StudentTrendReportModel stTrendReportModel = new StudentTrendReportModel();
    private  By convertStringToXpath(String name) {
        return By.xpath(name);
    }
    private  final String pageDashBoard = "/dashboard";
    private  final By classDropDown = convertStringToXpath("//span[@class='ant-select-selection-item']//span[contains(text(),'Select a Class')]");
    private  final By studentDropDown = convertStringToXpath("(//span[contains(text(),'Select Student')])[1]");
    private  final By clickApplyFilter = convertStringToXpath("//span[normalize-space()='Apply Filters']");
    private  final By clickMenuReport = convertStringToXpath("//span[normalize-space()='Reports']");
    private  final By clickStudentTrendReport = convertStringToXpath("//a[@href='/report/trend.html']");
    private  final By titleReportPage = convertStringToXpath(" //h1[normalize-space()='Student Trend Report']");
    private  final By alertMessage = convertStringToXpath("//div[@class='ant-alert-message']");
    private  final By alertMessageStudent = convertStringToXpath("//div[contains(@class,'ant-alert-message')]");
    private  final By inputClass = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')]");
    private  final By inputStudent = convertStringToXpath("(//input[contains(@type,'text')])[3]");
    private  final By graphTable = convertStringToXpath("//div[@class='recharts-wrapper']");




    private void navigateToTrendReportPage() {
        WebUI.clickElement(clickMenuReport);
        WebUI.sleep(3);
        WebUI.clickElement(clickStudentTrendReport);
        WebUI.sleep(5);

    }

    private void TC_StudentTrend_011(Hashtable<String, String> data) {
        navigateToTrendReportPage();
        WebUI.verifyElementText(By.xpath("(//td[@class='ant-table-cell'])[1]"),"");
    }

    public void TC_StudentTrend_01() {
        //'1. Login successful, open dashboard
        WebUI.verifyContains(WebUI.getCurrentUrl(), pageDashBoard, "Open Dashboard page.");
        WebUI.clickElement(clickMenuReport);
        WebUI.sleep(5);
        //2. On dropdown of Report not display text [Student Trend]
        WebUI.verifyElementNotPresent(clickStudentTrendReport,5);
    }

    public void TC_StudentTrend_02() {
        navigateToTrendReportPage();
        //'Display [Student Trend Report] screen successful
        WebUI.verifyElementText(titleReportPage,"Student Trend Report");
    }

    public void TC_StudentTrend_03() {
        navigateToTrendReportPage();
        clickApplyButton();
        //'Screen display message "Warning! You must select a class to run this report."
        WebUI.verifyElementText(alertMessage,"Warning You must select a class and student to run this report.");
    }

    public void TC_StudentTrend_04(Hashtable<String, String> data) {
        navigateToTrendReportPage();
        //3. Click dropdown [Class] and select class
        selectClass(data.get(stTrendReportModel.getClassTrendReport()).trim());
        clickApplyButton();
        //Screen display message "Warning! You must select a class to run this report."
        WebUI.verifyElementText(alertMessageStudent,"Warning You must select a class and student to run this report.");
    }

    public void TC_StudentTrend_05(Hashtable<String, String> data) throws IOException {
        navigateToTrendReportPage();
        //3. Click dropdown [Class] and select class
        selectClass(data.get(stTrendReportModel.getClassTrendReport()).trim());
        selectStudent(data.get(stTrendReportModel.getStudentTrendReport()).trim());
        clickApplyButton();
//       Display chart on screen include:
//       - Score chart 0~100 not have data
//       - Week chart 1 ~ week 8 not have data
        String actualName_TC_StudentTrend_05 = "Actual_TC_StudentTrend_05";
        WebUI.screenshotElement(graphTable,actualName_TC_StudentTrend_05);
        WebUI.sleep(2);
        compareImage(data.get(stTrendReportModel.getExpectedResult()).trim(),actualName_TC_StudentTrend_05.trim(),"Display chart on screen include: Score chart 0~100 not have data & Week chart 1 ~ week 8 not have data");
    }


    private void clickApplyButton()
    {
        WebUI.clickElement(clickApplyFilter);
        WebUI.sleep(5);
    }

    private void selectClass(String data)
    {
        WebUI.clickElement(classDropDown);
        WebUI.pressTabByAction();
        WebUI.setText(inputClass,data);
        WebUI.sleep(3);
        WebUI.pressEnterByAction();
        WebUI.sleep(3);
    }

    private void selectStudent(String data)
    {
        WebUI.clickElement(studentDropDown);
        WebUI.pressTabByAction();
        WebUI.setText(inputStudent,data);
        WebUI.sleep(5);
        WebUI.pressDOWNByAction();
        WebUI.pressEnterByAction();
    }

    private void compareImage(String expectedResult, String actualResult, String displayedMessage) throws IOException {
        boolean res = FileHelpers.compareImages(System.getProperty("user.dir").concat(expectedResult),
                System.getProperty("user.dir").concat("/reports/ExtentReports/images/"+actualResult+".png"));
        if(res)
        {
            ExtentReportManager.pass(displayedMessage);
            Assert.assertTrue(true,displayedMessage);
        }
        else
        {
            ExtentReportManager.fail(displayedMessage);
            Assert.fail(displayedMessage);
        }
    }


}