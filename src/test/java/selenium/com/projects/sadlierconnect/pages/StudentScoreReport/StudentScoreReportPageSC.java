package selenium.com.projects.sadlierconnect.pages.StudentScoreReport;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.StudentScoreReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import static selenium.com.constants.FrameworkConstants.WAIT_EXPLICIT;

public class StudentScoreReportPageSC extends CommonPageSC{
    private static By convertStringToXpath(String name) {
        return By.xpath(name);
    }
    private  final By clickReport = convertStringToXpath("//span[normalize-space()='Reports']");
    private  final StudentScoreReportModel studentScoreReportModel = new StudentScoreReportModel();
    private  final By clickStudentScores = convertStringToXpath("//a[@href='/report/export/studentScore.html']");
    private  final By clickDropdownClass = convertStringToXpath("(//div[@class='ant-select-selector'])[1]");
    private  final By clickDropdownStudent = convertStringToXpath("(//div[@class='ant-select-selector'])[2]");
    private  final By clickDropdownProgram = convertStringToXpath("(//div[@class='ant-select-selector'])[3]");
    private  final By clickDropdownAssessments = convertStringToXpath("(//span[@class='ant-select-selection-item'])[5]");
    private  final By btnExport = convertStringToXpath("//div[@class='btn-default']");



    private  final By clickDropdownFrom = convertStringToXpath("(//div[@class='ant-picker-input'])[1]");
    private  final By clickDropdownTo = convertStringToXpath("(//div[@class='ant-picker-input'])[2]");
    private  final By clickDropdownSection = convertStringToXpath("//span[contains(text(),'All Chapters/Units')]");
    private  final By clickDropdownSectionCurrent = convertStringToXpath("(//span[@class='ant-select-selection-item'])[4]");
    private  final By clickSetTextClass = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH')]");
    private  final By clickSetTextStudent = convertStringToXpath("//div[contains(@class,'ant-select-dropdown select-student-group assignment-report ant-select-dropdown-placement-bottomLeft')]//div//input[contains(@type,'text')]");
    private  final By clickSetTextProgram = convertStringToXpath("//input[@class='ant-input sc-ezWOiH hmYkqp']");
    private  final By clickSetTextProgram2 = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH')]");
    private  final By clickSetTextSection = convertStringToXpath("(//input[@type='text'])[5]");
    private  final By clickSetTextSection2 = convertStringToXpath("(//div[@class='sc-dropdown-select']//input)[2]");

    private  final By clickLastName = convertStringToXpath("//span[normalize-space()='Last Name']");
    private  final By clickFirstName = convertStringToXpath("//span[normalize-space()='First Name']");
    private  final By clickAssignmentName = convertStringToXpath("//span[normalize-space()='Assignment Name']");
    private  final By clickDueDate = convertStringToXpath("//span[normalize-space()='Due Date']");
    private  final By clickScore = convertStringToXpath("//span[normalize-space()='Score']");





    private  final By btnApplyfilter = convertStringToXpath("//button[@type='button']");


    public void TC_STUDENT_SCORE_REPORT_01(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.verifyElementNotPresent(By.xpath("(//ul[@role='menu'])//span[contains(text(),'Student Scores')]"),2);
    }

    public void TC_STUDENT_SCORE_REPORT_02(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_03(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownStudent);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.sleep(3);
        WebUI.pressEnterByAction();
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }


    public void TC_STUDENT_SCORE_REPORT_04(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(2);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.sleep(3);
        WebUI.pressEnterByAction();
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_05(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(3);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.sleep(2);
        WebUI.pressEnterByAction();
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_06(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextProgram,data.get(studentScoreReportModel.getEventProgram().trim()));
        WebUI.sleep(2);
        WebUI.pressEnterByAction();
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_07(Hashtable<String, String> data) {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextProgram,data.get(studentScoreReportModel.getEventProgram().trim()),Keys.ENTER);
        WebUI.clickElement(clickDropdownSection);
        WebUI.sleep(1);
        if(WebUI.verifyElementExists(clickSetTextSection2)) {
            WebUI.clickWebElement(clickSetTextSection2);
            WebUI.sleep(2);
            WebUI.setText(clickSetTextSection2,data.get(studentScoreReportModel.getEventSection().trim()),Keys.ENTER);
        }
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_08(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()),Keys.ENTER)));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.sleep(3);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC8",1);
    }

    public void TC_STUDENT_SCORE_REPORT_09(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(2);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.sleep(2);
        WebUI.pressEnterByAction();
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_10(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(2);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.sleep(2);
        WebUI.pressEnterByAction();
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC10",1);
    }

    public void TC_STUDENT_SCORE_REPORT_11(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextProgram,data.get(studentScoreReportModel.getEventProgram().trim()),Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC11",1);
    }

    public void TC_STUDENT_SCORE_REPORT_12(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(2);
        WebUI.setText(clickSetTextProgram,data.get(studentScoreReportModel.getEventProgram().trim()),Keys.ENTER);
        WebUI.clickElement(clickDropdownSection);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getEventSection().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.sleep(3);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
        WebUI.clickElement(clickDropdownSectionCurrent);
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getEventSection2().trim()))));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC12",1);
    }

    public void TC_STUDENT_SCORE_REPORT_13(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC13",1);
    }

    public void TC_STUDENT_SCORE_REPORT_14(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.sleep(1);
        WebUI.pressEnterByAction();
        WebUI.sleep(1);
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.sleep(1);
        WebUI.pressEnterByAction();
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC14",1);
    }

    public void TC_STUDENT_SCORE_REPORT_15(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.sleep(2);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getEventProgram().trim()))));
        WebUI.sleep(3);
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC15",1);
    }

    public void TC_STUDENT_SCORE_REPORT_16(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.clickElement(clickDropdownProgram);
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getEventProgram().trim()))));
        WebUI.clickWebElement(clickDropdownSection);
        WebUI.sleep(1);
        if(WebUI.verifyElementExists(clickSetTextSection)) {
            WebUI.clickWebElement(clickSetTextSection);
            WebUI.sleep(1);
            WebUI.setText(clickSetTextSection,data.get(studentScoreReportModel.getEventSection().trim()), Keys.ENTER);
        }
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC16",1);
    }

    public void TC_STUDENT_SCORE_REPORT_17(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.clickElement(clickDropdownProgram);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getEventProgram().trim()))));
        WebUI.clickWebElement(clickDropdownSection);
        if(WebUI.verifyElementExists(clickSetTextSection)) {
            WebUI.clickWebElement(clickSetTextSection);
            WebUI.sleep(1);
            WebUI.setText(clickSetTextSection,data.get(studentScoreReportModel.getEventSection().trim()), Keys.ENTER);
        }
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.clickElement(By.xpath("(//span[normalize-space()='Benchmark Assessments'])[4]"));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyTestDataByRow(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC17",1);
    }

    public void TC_STUDENT_SCORE_REPORT_18(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.sleep(1);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC18");
        WebUI.clickElement(By.xpath("//input[contains(@name,'graded')]"));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_19(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.sleep(2);
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_20(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC20");
    }

    public void TC_STUDENT_SCORE_REPORT_21(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.sleep(2);
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC21");
        //WebUI.verifyElementText(By.xpath("//div[@class='empty-data']"),"No graded assessments matching the selected criteria.");
    }

    public void TC_STUDENT_SCORE_REPORT_22(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.setDateTimeInStartDateByEnter(clickDropdownTo,data.get(studentScoreReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC22");
    }

    public void TC_STUDENT_SCORE_REPORT_23(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownTo,data.get(studentScoreReportModel.getTo1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        verifyPopup("From Date is greater than To Date.");
    }
    public void verifyPopup(String expectedMessage)
    {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = DriverManager.getDriver().switchTo().alert();
            String actualMessage =  DriverManager.getDriver().switchTo().alert().getText();
            Assert.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage),expectedMessage);
            ExtentReportManager.pass("From Date is greater than To Date.");
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert not shown");
        } catch (UnhandledAlertException e) {
            Assert.fail("UnhandledAlertException");
        }

    }

    public void TC_STUDENT_SCORE_REPORT_24(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')][1]",data.get(studentScoreReportModel.getEventClass().trim()))));
        WebUI.clickElement(clickDropdownStudent);
        WebUI.setText(clickSetTextStudent,data.get(studentScoreReportModel.getStudent().trim()));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]",data.get(studentScoreReportModel.getStudent().trim()))));
        WebUI.clickElement(clickDropdownAssessments);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",data.get(studentScoreReportModel.getAssessments().trim()))));
        WebUI.clickElement(clickDropdownFrom);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.setDateTimeInStartDateByEnter(clickDropdownTo,data.get(studentScoreReportModel.getTo1().trim()));
        WebUI.clickElement(By.xpath("//input[contains(@name,'graded')]"));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH,"TC24");

    }

    public void TC_STUDENT_SCORE_REPORT_25(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.clickElement(clickLastName);
        WebUI.sleep(2);
        WebUI.checkEqualsValueOnTableByColumn(1,data.get(studentScoreReportModel.getLastName().trim()));

    }

    public void TC_STUDENT_SCORE_REPORT_26(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(2);
        WebUI.clickElement(clickFirstName);
        WebUI.sleep(2);
        WebUI.checkEqualsValueOnTableByColumn(2,data.get(studentScoreReportModel.getFirstName().trim()));

    }

    public void TC_STUDENT_SCORE_REPORT_27(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(clickAssignmentName);
        WebUI.checkEqualsValueOnTableByColumn(3,data.get(studentScoreReportModel.getAssignmentName().trim()));

    }

    public void TC_STUDENT_SCORE_REPORT_28(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(clickDueDate);
        WebUI.checkEqualsValueOnTableByColumn(4,data.get(studentScoreReportModel.getDueDate().trim()));

    }

    public void TC_STUDENT_SCORE_REPORT_29(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(btnApplyfilter);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(clickScore);
        WebUI.checkEqualsValueOnTableByColumn(5,data.get(studentScoreReportModel.getScore().trim()));

    }

    public void TC_STUDENT_SCORE_REPORT_31(Hashtable<String, String> data) throws IOException {
        WebUI.clickElement(clickReport);
        WebUI.sleep(2);
        WebUI.clickElement(clickStudentScores);
        WebUI.sleep(5);
        WebUI.setDateTimeInStartDateByEnter(clickDropdownFrom,data.get(studentScoreReportModel.getFrom1().trim()));
        WebUI.clickElement(clickDropdownClass);
        WebUI.setText(clickSetTextClass,data.get(studentScoreReportModel.getEventClass().trim()));
        WebUI.sleep(2);
        WebUI.pressEnterByAction();
        WebUI.clickElement(btnApplyfilter);
        WebUI.sleep(3);
        WebUI.clickElement(btnExport);
        var file = WebUI.verifyFileDownloadedWithJS_ContainsData("assignmentCSV");
        WebUI.verifyDataReportScoreWithExportFile(file, "(//table)[1]/tbody/tr");
        String localDir = System.getProperty("user.dir");
        File downloadFileReport = new File(localDir + "/externalFiles/downloadFiles");
        FileUtils.deleteDirectory(downloadFileReport);
    }
}

