package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCActivityReport;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.Report.ActivityReportPageSC;

import java.util.Hashtable;

public class ActivityReportTest extends BaseTest {
    LoginPageSC loginPageSC;
    ActivityReportPageSC activityReportPageSC;
    DashboardPageSC dashboardPageSC;

    public ActivityReportTest() {
        loginPageSC = new LoginPageSC();
        activityReportPageSC = new ActivityReportPageSC();
        dashboardPageSC = new DashboardPageSC();
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 1, description = "Verify when not select Grade and Class and click Apply Filters")
    public void TC_Activity_01() {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        // 3. Click Apply Filters
        activityReportPageSC.applyFilterNotSelect();
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 2, description = "Verify when select Grade and click Apply Filters", dataProvider = "getReportDataHashTable1", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_02(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        activityReportPageSC.applyFilterSelectGrade(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 3, description = "Verify when select Action no data and click Apply Filters", dataProvider = "getReportDataHashTable2", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_03(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        // 3. Select  Class at Class dropdown
        // 4. Select Action Type
        // 5. Click Apply Filter
        activityReportPageSC.applyFilterSelectAction(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 4, description = "Verify when select Class and click Apply Filters", dataProvider = "getReportDataHashTable3", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_04(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        // 3. Select  Class at Class dropdown
        // 4. Click Apply Filter
        activityReportPageSC.applyFilterSelectClass(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 5, description = "Verify sort by Game Type", dataProvider = "getReportDataHashTable4", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_05(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        // 5. Click game type title
        activityReportPageSC.sortByGameType(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 6, description = "Verify sort by Date Last Submitted", dataProvider = "getReportDataHashTable5", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_06(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        // 5. Click Date Last Submitted title
        activityReportPageSC.sortByDate(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 7, description = "Verify sort by Average Class Score", dataProvider = "getReportDataHashTable6", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_07(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        // 5. Click Average Class Score title
        activityReportPageSC.sortByScore(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 8, description = "Verify sort by Completed Student Assignments", dataProvider = "getReportDataHashTable7", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_08(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        // 5. Click Completed Student Assignments title
        activityReportPageSC.sortByCompleteStudentAssignment(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 9, description = "Verify when 1 student do assignment with score = 0", dataProvider = "getReportDataHashTable8", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_09(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleted(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 10, description = "Verify when 1 student do assignment with score = 0", dataProvider = "getReportDataHashTable9", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_10(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportInComplete(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 11, description = "Verify when 1 student do assignment < 65% ", dataProvider = "getReportDataHashTable10", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_11(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore1(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 12, description = "Verify when 1 student do 1 time assignent with 65%<=score<80% ", dataProvider = "getReportDataHashTable11", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_12(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore2(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 13, description = "Verify when 1 student do 1 time assignment with 80%<=score<90%", dataProvider = "getReportDataHashTable12", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_13(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore3(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 14, description = "Verify when 1 student do 1 time assignment with 90%<=score<100%", dataProvider = "getReportDataHashTable13", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_14(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore4(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 15, description = "Verify when 1 student do 2 time assigmnent ", dataProvider = "getReportDataHashTable14", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_15(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore5(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 16, description = "Verify when 1 student do 3 time assignment ", dataProvider = "getReportDataHashTable15", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_16(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore6(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 17, description = "Verify when 1 student do >3 time assignment ", dataProvider = "getReportDataHashTable16", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_17(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore7(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 18, description = "Verify when 1 student do assignment then click Back button on game", dataProvider = "getReportDataHashTable17", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_18(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        activityReportPageSC.verifyReportCompleteAndScore8(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 19, description = "Verify when 1 student do assignment that stt Incomplete then Redo and Done Assignment", dataProvider = "getReportDataHashTable18", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_19(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore9(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 20, description = "Verify when 1 student do 2 time assignment with 2 time Incomplete", dataProvider = "getReportDataHashTable19", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_20(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore10(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 21, description = "Verify when 1 student do assignment then click Done button on game", dataProvider = "getReportDataHashTable20", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_21(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        activityReportPageSC.verifyReportCompleteAndScore11(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 22, description = "Verify when 1 student do assignment that stt Complete then redo and click back on game", dataProvider = "getReportDataHashTable22", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_23(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student
        activityReportPageSC.verifyReportCompleteAndScore13(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 23, description = "Verify when class have 2 student do assignment\n" +
            "1. Student Completed\n" +
            "1 student Incomplete", dataProvider = "getReportDataHashTable23", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_24(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        // 7. Click student 1
        // 8. Click X button at popup
        // 9. Click Student 2
        activityReportPageSC.verifyReportCompleteAndScore14(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 24, description = "Verify when class have 5 student do assignment, all completed", dataProvider = "getReportDataHashTable24", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_25(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select  Class at Class dropdown
        // 5. Click Apply Filter
        // 6. Click specific Assignment
        activityReportPageSC.verifyReportCompleteAndScore15(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 25, description = "Verify when 2 class of 1 grade have student do game", dataProvider = "getReportDataHashTable25", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_26(Hashtable<String, String> data) throws JsonProcessingException {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Click Apply Filter
        // 5. Select Class at Class dropdown
        // 6. Click Apply Filter
        activityReportPageSC.verifyReportCompleteAndScore16(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 26, description = "Verify select specific Action", dataProvider = "getReportDataHashTable26", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_27(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select Action at Action dropdown
        // 5. Click Apply Filter
        activityReportPageSC.verifyReportCompleteAndScore17(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Activity_Report })
    @Test(priority = 27, description = "Check export data", dataProvider = "getReportDataHashTable28", dataProviderClass = DataProviderSCActivityReport.class)
    public void TC_Activity_30(Hashtable<String, String> data) {
        // 1. Login by Teacher role
        loginPageSC.logInWithTeacherActivityReport();
        // 2. Select Activity Report at Report dropdown
        activityReportPageSC = dashboardPageSC.openActivityReportPageSC();
        WebUI.sleep(5);
        // 3. Select Grades  at Grades dropdown
        // 4. Select Action at Action dropdown
        // 5. Click Apply Filter
        // 6. Click game type
        // 7. Click student name
        // 8. Click export button
        activityReportPageSC.verifyExportReport(data);
    }
}