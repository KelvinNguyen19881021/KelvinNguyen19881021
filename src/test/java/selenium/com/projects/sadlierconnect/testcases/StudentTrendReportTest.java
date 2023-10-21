package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.constants.FrameworkConstants;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCStudentTrendReport;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.StudentTrendReport.StudentTrendReportPageSC;

import java.io.IOException;
import java.util.Hashtable;

public class StudentTrendReportTest extends BaseTest {
    private final static String title = "SC_Student_Trend_Report";
    private final LoginPageSC loginPageSC;
    private final StudentTrendReportPageSC studentTrendReportPageSC;


    public StudentTrendReportTest() {
        loginPageSC = new LoginPageSC();
        studentTrendReportPageSC = new StudentTrendReportPageSC();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTrend_Report})
    @Test(priority = 1, description = "Check display [Student Trend Report] screen.")
    public void TC_StudentTrend_01() {
//       1. go to url https://cqa2.sadlierconnect.com/@No_Report
//       2. Input Passcode, Username, Password
//       3. Click Login button
        loginPageSC.logInWithTeacherRoleWithNoReport();
//      4. Click on Reports dropdown
        studentTrendReportPageSC.TC_StudentTrend_01();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTrend_Report})
    @Test(priority = 2, description = "Check display [Student Trend Report] screen.")
    public void TC_StudentTrend_02() {
//       1. Login new school
//       2. Input Passcode, Username, password
//       3. On dropdown [Reports] click text "Student Trend"
        loginPageSC.logInWithTeacherRoleWithReport();
        studentTrendReportPageSC.TC_StudentTrend_02();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTrend_Report})
    @Test(priority = 3, description = "Check Show Report when not select class filter")
    public void TC_StudentTrend_03() {
//        1. Login school by Teacher
        loginPageSC.logInWithTeacherRoleWithReport();
//        2. Open [Student Trend Report] screen
//        3. Not choose class
//        4. At report click [Apply Filters] button
        studentTrendReportPageSC.TC_StudentTrend_03();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTrend_Report})
    @Test(priority = 4, description = "Check Show Report when not select class filter - Verify when no student done assignment",
            dataProvider = "getStudentTrendReportDataHashTable04", dataProviderClass = DataProviderSCStudentTrendReport.class)
    public void TC_StudentTrend_04(Hashtable<String, String> data) {
//        1. Login school by Teacher
        loginPageSC.logInWithTeacherRoleWithReport();
//        2. Open [Student Trend Report] screen
//        3. Click dropdown [Class] and select class
//        4. Choose All Students, tick all Assessment Type
//        5. At report Click Apply Filters button
        studentTrendReportPageSC.TC_StudentTrend_04(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTrend_Report})
    @Test(priority = 5, description = "Check show report when student has not done any assignment.",
            dataProvider = "getStudentTrendReportDataHashTable05", dataProviderClass = DataProviderSCStudentTrendReport.class)
    public void TC_StudentTrend_05(Hashtable<String, String> data) throws IOException {
        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
//        1. Login school by Teacher
            loginPageSC.logInWithTeacherRoleWithReport();
//        2. Open [Student Trend Report] screen
//        3. Choose class
//        4. Choose student
//        5. Click [Apply Filters] button
            studentTrendReportPageSC.TC_StudentTrend_05(data);
            DriverManager.quit();
        }
        else
        {
//        1. Login school by Teacher
            loginPageSC.logInWithTeacherRoleWithReport();
//        2. Open [Student Trend Report] screen
//        3. Choose class
//        4. Choose student
//        5. Click [Apply Filters] button
            studentTrendReportPageSC.TC_StudentTrend_05(data);
        }
    }
}



