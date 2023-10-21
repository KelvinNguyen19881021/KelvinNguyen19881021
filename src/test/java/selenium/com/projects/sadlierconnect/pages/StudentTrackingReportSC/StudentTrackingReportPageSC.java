package selenium.com.projects.sadlierconnect.pages.StudentTrackingReportSC;

import net.datafaker.providers.entertainment.SouthPark;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.ManageParentImportModel;
import selenium.com.projects.sadlierconnect.models.StudentTrackingReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.report.ExtentTestManager;
import selenium.com.utils.DateUtils;
import selenium.com.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

public class StudentTrackingReportPageSC extends CommonPageSC {

    private  final By clickDropDown = convertStringToXpath("(//span[@class='dropdown-label'])[1]");
    private  final By pageClick = convertStringToXpath("(//a[normalize-space()='Manage Parents'])[1]");
    private  By convertStringToXpath(String name) {
        return By.xpath(name);
    }
    private  final By clickReport = convertStringToXpath("//span[normalize-space()='Reports']");
    private  final By clickStudentTracking = convertStringToXpath("//a[@href='/report/studentActivityTracking.html']");
    private  final By clickApplyFilter = convertStringToXpath("//span[normalize-space()='Apply Filters']");
    private  final StudentTrackingReportModel studentTrackingReportModel = new StudentTrackingReportModel();
    private  final By clickDropdownClass = convertStringToXpath("(//div[@class='ant-select-selector'])[1]");
    private  final By clickSetText = convertStringToXpath("//div[contains(@class,'ant-select-dropdown ant-select-dropdown-placement-bottomLeft')]//div//input[@type='text']");
    private  final By clickDropdownStudent = convertStringToXpath("(//span[contains(text(),'Select a Student')])[1]");
    private  final By clickSetText2 = convertStringToXpath("(//div//input[@type='text'])[3]");

    private  final By clickSetText3 = convertStringToXpath("(//input[contains(@class,'ant-input sc-ezWOiH')])[3]");

    private  final By clickSetTextStudent = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH')]");


    private  final By clickDropdownFrom = convertStringToXpath("//i[@class='icon-calendar'])[1]");
    private  final By clickDropdownTo = convertStringToXpath("(//div[@class='ant-picker-input'])[2]");
    private  final By btnApplyfilter = convertStringToXpath("(//button[@type='button'])[1]");
    private  final By btnBackofDropdownFrom = convertStringToXpath("(//button[@class='ant-picker-header-prev-btn'])");
    private  final By btnBackofDropdownTo = convertStringToXpath("//button[@class='ant-picker-header-prev-btn']");
    private  final By listNoResultsFound = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')]//following::span");
    String dayOfLastWeek = WebUI.getDayOfLastWeekByTimeZone();
    String getDayOfLastWeek2 = studentTrackingReportModel.getFrom1();
    String dayofCurrentWeek = WebUI.getDateOfCurrentWeekByTimeZone();
    private final By dropDownFromValue = By.xpath(ObjectUtils.getXpathDynamic("(//input[@title='%s'])",dayOfLastWeek));
    private final By dropDownToValue = By.xpath(ObjectUtils.getXpathDynamic("(//input[@title='%s'])",dayofCurrentWeek));
    private final By dropDownFromValue2 = By.xpath(ObjectUtils.getXpathDynamic("(//input[@title='%s'])",getDayOfLastWeek2));
    private  final By currentDayOfDropdownFrom = convertStringToXpath("(//div[@class='ant-picker-input'])[1]");
    private  final By currentDayOfDropdownTo = convertStringToXpath("(//div[@class='ant-picker-input'])[2]");

    public void visitPage() {
        WebUI.sleep(5);
        WebUI.clickElement(clickDropDown);
        WebUI.sleep(2);
        WebUI.clickElement(pageClick);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }

    public void TC_STUDENT_TRACKING_REPORT_01(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[@class='ant-table-cell'])[1]"),data.get(studentTrackingReportModel.getAlertMessage().trim()));
    }

    public void TC_STUDENT_TRACKING_REPORT_02(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickApplyFilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='ant-alert-message']"),data.get(studentTrackingReportModel.getAlertMessage().trim()));
    }

    public void TC_STUDENT_TRACKING_REPORT_03(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickApplyFilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='ant-alert-message']"),data.get(studentTrackingReportModel.getAlertMessage().trim()));
    }

    public void TC_STUDENT_TRACKING_REPORT_04(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("(//td[@class='ant-table-cell'])[1]"),data.get(studentTrackingReportModel.getAlertMessage().trim()));
    }

    public void TC_STUDENT_TRACKING_REPORT_00(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.pressENTER();
        WebUI.clickElement(clickDropdownStudent);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.clickElement(dropDownFromValue,5);
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC4_1");
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC4_1");
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC4_1");
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC4_1");

    }

    public void TC_STUDENT_TRACKING_REPORT_05(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.sleep(1);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.sleep(1);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("//div[@class='ant-alert-message']"),data.get(studentTrackingReportModel.getAlertMessage().trim()));
    }

    public void TC_STUDENT_TRACKING_REPORT_06(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.sleep(1);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(clickSetText2);
        WebUI.sleep(1);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("//span[normalize-space()='Enter Assignment']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC6");

    }

    public void TC_STUDENT_TRACKING_REPORT_07(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='Exit Assignment'])[1]"),data.get(studentTrackingReportModel.getAction().trim()));
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='Enter Assignment'])[1]"),data.get(studentTrackingReportModel.getAction2().trim()));
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='Exit Assignment']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC7");
    }

    public void TC_STUDENT_TRACKING_REPORT_08(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='Enter Assignment'])[1]"),data.get(studentTrackingReportModel.getAction().trim()));
        WebUI.verifyElementText(By.xpath("(//td[contains(text(),'Submit Assignment')])[1]"),data.get(studentTrackingReportModel.getAction2().trim()));
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='Submit Assignment']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC8");
    }

    public void TC_STUDENT_TRACKING_REPORT_09(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.waitForPageLoaded();
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(5);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='View Graded Assignment'])[1]"),data.get(studentTrackingReportModel.getAction().trim()));
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='View Graded Assignment']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC9");
    }

    public void TC_STUDENT_TRACKING_REPORT_10(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='View Non-gradable'])[1]"),data.get(studentTrackingReportModel.getAction().trim()));
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='View Non-gradable']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC10",2);
    }

    public void TC_STUDENT_TRACKING_REPORT_11(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.sleep(1);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='View Non-gradable']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC11",3);
    }

    public void TC_STUDENT_TRACKING_REPORT_12(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.sleep(1);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='Student Changed Password'])[1]"),"Student Changed Password");
        WebUI.clickElement(By.xpath("(//span[contains(@class,'ant-select-selection-item')])[3]"));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[text()='%s']",data.get(studentTrackingReportModel.getAction().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC12");
    }

    public void TC_STUDENT_TRACKING_REPORT_13(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("(//td[normalize-space()='Student Changed Password'])[1]"),"Student Changed Password");
        WebUI.clickElement(By.xpath("(//span[contains(@class,'ant-select-selection-item')])[3]"));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[text()='%s']",data.get(studentTrackingReportModel.getAction().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC13",2);
    }

    public void TC_STUDENT_TRACKING_REPORT_14(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.clickElement(By.xpath("(//span[contains(@class,'ant-select-selection-item')])[3]"));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[text()='%s']",data.get(studentTrackingReportModel.getAction().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC14");
    }

    public void TC_STUDENT_TRACKING_REPORT_15(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.setDateTimeInStartDateByEnter(currentDayOfDropdownFrom,data.get(studentTrackingReportModel.getFrom2().trim()));
        WebUI.setDateTimeInStartDateByEnter(currentDayOfDropdownTo,data.get(studentTrackingReportModel.getTo2().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH,"TC15");
    }

    public void TC_STUDENT_TRACKING_REPORT_16(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.clickElement(clickStudentTracking);
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownClass);
        WebUI.clickElement(clickSetText);
        WebUI.setText(clickSetText,data.get(studentTrackingReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]",data.get(studentTrackingReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.clickElement(clickSetText2);
        WebUI.setText(clickSetText2,data.get(studentTrackingReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentTrackingReportModel.getStudent().trim()))));
        WebUI.setDateTimeInStartDateByEnter(dropDownFromValue,data.get(studentTrackingReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(dropDownToValue,data.get(studentTrackingReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.clickElement(By.xpath("(//div[@class='ant-select-selector'])[3]"));
        WebUI.clickElement(clickSetText3);
        WebUI.setText(clickSetText3,data.get(studentTrackingReportModel.getEventAction().trim()));
        WebUI.clickElement(By.xpath("//span[normalize-space()='Enter Assignment']"),5);
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("//td[@class='ant-table-cell']"),"No events matching the selected criteria.");
    }

}