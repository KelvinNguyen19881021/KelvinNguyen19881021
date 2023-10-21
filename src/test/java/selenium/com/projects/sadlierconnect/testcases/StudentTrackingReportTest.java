package selenium.com.projects.sadlierconnect.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.constants.FrameworkConstants;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCStudentTrackingReport;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.StudentTrackingReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.StudentTrackingReportSC.StudentTrackingReportPageSC;
import selenium.com.utils.DateUtils;

import java.io.IOException;
import java.util.Hashtable;

public class StudentTrackingReportTest extends BaseTest {
    private final static String title = "SC_Student_Tracking_Report";
    private final LoginPageSC loginPageSC;
    private final DashboardPageSC dashboardPageSC;
    private final StudentTrackingReportPageSC studentTrackingReportPageSC;
    private String abc = DateUtils.getCurrentDateTimeByZone("MM/dd/yyyy");

    public StudentTrackingReportTest() {
        loginPageSC = new LoginPageSC();
        studentTrackingReportPageSC = new StudentTrackingReportPageSC();
        dashboardPageSC = new DashboardPageSC();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 1, description = "Verify display screen initialization",
            dataProvider = "getStudentTrackingReportDataHashTable01", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_01(Hashtable<String, String> data) {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Open screen [Student Tracking Report] successful
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_01(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 2, description = "Verify Student filter  when  not select Class",
            dataProvider = "getStudentTrackingReportDataHashTable02", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_02(Hashtable<String, String> data) {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_02(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 3, description = "Verify Student filter  when  not select Student",
            dataProvider = "getStudentTrackingReportDataHashTable03", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_03(Hashtable<String, String> data) {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_03(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 4, description = "Verify Apply Filters when select Student no have data",
            dataProvider = "getStudentTrackingReportDataHashTable04", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_04(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From is 09/23/2023, TO is 09/29/2023
        //6. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_04(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 5, description = "Verify when select Class, Student and From > TO day",
            dataProvider = "getStudentTrackingReportDataHashTable05", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_05(Hashtable<String, String> data) {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select fields From - TO
        //6. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_05(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 6, description = "Verify action Enter Assignment when Student click Assignment for view.",
            dataProvider = "getStudentTrackingReportDataHashTable06", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_06(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From is 09/20/2023, TO is 09/29/2023
        //6. Click Apply Filters
        //7. Select Enter Assignment Action at action dropdown
        //8. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_06(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 7, description = "Verify action Exit Assignment display correctly when Student click Assignment then Save Assignment OR Click Next Question",
            dataProvider = "getStudentTrackingReportDataHashTable07", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_07(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select data of field [Action]
        //6. Select From,TO
        //7. Click Apply filter
        //8. Select Enter Assignment Action at action dropdown
        //9. Click Apply filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_07(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 8, description = "Verify action Submit Assignment display correctly when Student click Assignment to do Assignment and click Submit button",
            dataProvider = "getStudentTrackingReportDataHashTable08", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_08(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From, TO
        //6. Click Apply Filters (Show data  by  Action with action of student is : Enter Assignment,and Submit Assignment)
        //7. Select Submit Assignment Action at dropdown action
        //8. Click Apply filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_08(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 9, description = "Verify action when Student click View button of Assignment graded at List in navbar Grade",
            dataProvider = "getStudentTrackingReportDataHashTable09", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_09(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From, TO
        //6. Click Apply Filters (Show data  by Action with action of student is : View Graded Assignment)
        //7. Select Submit Assignment Action at dropdown action
        //8. Click Apply filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_09(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 10, description = "Verify action View Non-gradable when Student click Assignment for view.",
            dataProvider = "getStudentTrackingReportDataHashTable10", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_10(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select data of field [Action]
        //6. Select From < TO
        //7. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_10(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 11, description ="Verify when student view assignment again.",
            dataProvider = "getStudentTrackingReportDataHashTable11", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_11(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select data of field [Action]
        //6. Select From < TO
        //7. Click Apply filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_11(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 12, description ="Verify action when Student change Password",
            dataProvider = "getStudentTrackingReportDataHashTable12", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_12(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From ,TO
        //6. Click Apply Filter
        //7. Click Action Dropdown Ex: Enter Assignment
        //8. Click Apply Filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_12(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 13, description ="Verify action when Student change Password again",
            dataProvider = "getStudentTrackingReportDataHashTable13", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_13(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From , TO
        //6. Select data of field [Action]
        //7. Click Apply Filters
        //8. Select data of field [Action]
        //9. Click Apply Filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_13(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 14, description ="Verify actions Enter Assignment when student change action. Time by From = TO day",
            dataProvider = "getStudentTrackingReportDataHashTable14", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_14(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select data of field [Action]
        //6. Select fields From ,TO
        //7. Click Apply Filter
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_14(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 15, description ="Verify when  filter with Due date no data then select Due date have data",
            dataProvider = "getStudentTrackingReportDataHashTable15", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_15(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select data of field [Action]
        //6. Select From < TO (FROM: 09/01/2023 TO: 09/02/2023)
        //7. Click Apply Filter
        //8. Select From < TO (FROM: 09/23/2023 TO: 09/29/2023)
        //9. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_15(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentTracking_Report})
    @Test(priority = 16, description ="Verify filter with Action no data",
            dataProvider = "getStudentTrackingReportDataHashTable16", dataProviderClass = DataProviderSCStudentTrackingReport.class)
    public void TC_STUDENT_TRACKING_REPORT_16(Hashtable<String, String> data) throws IOException {
        //1. Log in teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Select Student Tracking at Report dropdown
        //3. Select Class at class dropdown
        //4. Select Student at student dropdown
        //5. Select From, TO
        //6. Click Apply Filter
        //7. Select data of field  "Action"
        //8. Click Apply Filters
        studentTrackingReportPageSC.TC_STUDENT_TRACKING_REPORT_16(data);
    }

}


