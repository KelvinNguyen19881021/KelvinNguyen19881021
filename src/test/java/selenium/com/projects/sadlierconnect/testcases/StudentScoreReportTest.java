package selenium.com.projects.sadlierconnect.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.constants.FrameworkConstants;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCStudentScoreReport;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.StudentTrackingReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.StudentScoreReport.StudentScoreReportPageSC;

import java.io.IOException;
import java.util.Hashtable;
import java.util.TimeZone;

public class StudentScoreReportTest extends BaseTest {
    private final static String title = "SC_Student_Score_Report";
    private final LoginPageSC loginPageSC;
    private final StudentScoreReportPageSC studentScoreReportPageSC;

    public StudentScoreReportTest() {
        loginPageSC = new LoginPageSC();
        studentScoreReportPageSC = new StudentScoreReportPageSC();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 1, description = "Verify when The school doesn't have a Assignment yet",
            dataProvider = "getStudentScoreReportDataHashTable01", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_01(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithNoReport();
            //2. Click Report Dropdown
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_01(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 2, description = "Verify message when filter class have not assignment",
            dataProvider = "getStudentScoreReportDataHashTable02", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_02(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at Report Dropdown
            //4. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_02(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 3, description = "Verify message when filter student have not assignment",
            dataProvider = "getStudentScoreReportDataHashTable03", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_03(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Student at Student Dropdown
            //4. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_03(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 4, description = "Verify message when filter class have assignment but not Assessments",
            dataProvider = "getStudentScoreReportDataHashTable04", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_04(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at Class Dropdown
            //4. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_04(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 5, description = "Verify message when filter student have assignment but not Assessments",
            dataProvider = "getStudentScoreReportDataHashTable05", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_05(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Student at student Dropdown
            //4. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_05(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 6, description = "Verify message when filter student have assignment but not Assessments",
            dataProvider = "getStudentScoreReportDataHashTable06", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_06(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select program at PROGRAM dropdown
            //4. Click Apply Filters button

            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_06(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 7, description = "Verify message when filter chapters/units does not Assessments",
            dataProvider = "getStudentScoreReportDataHashTable07", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_07(Hashtable<String, String> data) {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select program at PROGRAM dropdown
            //4. Select section at SECTION dropdown
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_07(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 8, description = "Verify response result when filter class have assignment with Assessments",
            dataProvider = "getStudentScoreReportDataHashTable08", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_08(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select date < Due date of assignment at DUE DATE FROM
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_08(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 9, description = "Verify message when filter student have assignment with Assessments but not yet submit",
            dataProvider = "getStudentScoreReportDataHashTable09", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_09(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select student at STUDENT dropdown
            //4. Select date < Due date of assignment at DUE DATE FROM
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_09(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 10, description = "Verify response result when filter student have assignment with Assessments and submitted",
            dataProvider = "getStudentScoreReportDataHashTable10", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_10(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select student at STUDENT dropdown
            //4. Select date < Due date of assignment at DUE DATE FROM
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_10(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 11, description = "Verify response result when filter program with Assessments",
            dataProvider = "getStudentScoreReportDataHashTable11", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_11(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select program at PROGRAM dropdown
            //4. Select date < Due date of assignment at DUE DATE FROM
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_11(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 12, description = "Verify response result when filter chapters/units with Assessments",
            dataProvider = "getStudentScoreReportDataHashTable12", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_12(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select program at PROGRAM dropdown
            //4. Select section at SECTION dropdown
            //5. Select date < Due date of assignment at DUE DATE FROM
            //6. Click Apply Filters button
            //7. Select section at SECTION dropdown
            //8. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_12(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 13, description = "Verify response result when filter Assessments",
            dataProvider = "getStudentScoreReportDataHashTable13", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_13(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select assessments at ASSESSMENTS dropdown
            //4. Select date < Due date of assignment at DUE DATE FROM
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_13(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 14, description = "Verify response result when filter class and student",
            dataProvider = "getStudentScoreReportDataHashTable14", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_14(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select student at STUDENT dropdown
            //5. Select date < Due date of assignment at DUE DATE FROM
            //6. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_14(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 15, description = "Verify response result when filter class,  student and program",
            dataProvider = "getStudentScoreReportDataHashTable15", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_15(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select student at STUDENT dropdown
            //5. Select program at PROGRAM dropdown
            //6. Select date < Due date of assignment at DUE DATE FROM
            //7. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_15(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 16, description = "Verify response result when filter class,  student, program and section",
            dataProvider = "getStudentScoreReportDataHashTable16", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_16(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select student at STUDENT dropdown
            //5. Select program at PROGRAM dropdown
            //6. Select section at SECTION dropdown
            //7. Select date < Due date of assignment at DUE DATE FROM
            //8. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_16(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 17, description = "Verify response result when filter class,  student, program, section and assessments",
            dataProvider = "getStudentScoreReportDataHashTable17", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_17(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select student at STUDENT dropdown
            //5. Select program at PROGRAM dropdown
            //6. Select section at SECTION dropdown
            //7. Select assessments at ASSESSMENTS dropdown
            //8. Select date < Due date of assignment at DUE DATE FROM
            //9. Click Apply Filters button
            //10. Select assessments at ASSESSMENTS dropdown
            //11. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_17(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 18, description = "Verify response result when select Show Only Graded Assignments",
            dataProvider = "getStudentScoreReportDataHashTable18", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_18(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Click Apply Filters button
            //5. Tick Show Only Graded Assignments
            //6. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_18(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 19, description = "Verify message when filter assignments have Due date < Due date from",
            dataProvider = "getStudentScoreReportDataHashTable19", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_19(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select assessments at ASSESSMENTS dropdown
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_19(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 20, description = "Verify response result when filter assignments have Due date < Due date from",
            dataProvider = "getStudentScoreReportDataHashTable20", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_20(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select assessments at ASSESSMENTS dropdown
            //5. Select date < Due date of assignment at DUE DATE FROM
            //6. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_20(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 21, description = "Verify message when filter assignments have Due date > Login date",
            dataProvider = "getStudentScoreReportDataHashTable21", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_21(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select assessments at ASSESSMENTS dropdown
            //5. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_21(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 22, description = "Verify response result when filter assignments have Due date > Login date",
            dataProvider = "getStudentScoreReportDataHashTable22", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_22(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select assessments at ASSESSMENTS dropdown
            //5. Select date > Login date of assignment at TO
            //6. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_22(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 23, description = "Verify message when filter TO date < DUE DATE FROM",
            dataProvider = "getStudentScoreReportDataHashTable23", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_23(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select TO date < DUE DATE FROM
            //4. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_23(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 24, description = "Verify response result when filter class,  student, program, section, assessments and date",
            dataProvider = "getStudentScoreReportDataHashTable24", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_24(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Select student at STUDENT dropdown
            //5. Select assessments at ASSESSMENTS dropdown
            //6. Select date < Due date of assignment at DUE DATE FROM
            //7. Select date > Login date of assignment at TO
            //8. Tick Show Only Graded Assignments
            //9. Click Apply Filters button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_24(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 25, description = "Verify sort by Last name when click on Last Name title",
            dataProvider = "getStudentScoreReportDataHashTable25", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_25(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Click on Last Name title
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_25(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 26, description = "Verify sort by First name when click on First Name title",
            dataProvider = "getStudentScoreReportDataHashTable26", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_26(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Click on First Name title
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_26(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 27, description = "Verify sort by Assignment Name when click on Assignment Name title",
            dataProvider = "getStudentScoreReportDataHashTable27", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_27(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Click on Assignment Name title
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_27(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 28, description = "Verify sort by Due date when click on Due date title",
            dataProvider = "getStudentScoreReportDataHashTable28", dataProviderClass = DataProviderSCStudentScoreReport.class)
        public void TC_STUDENT_SCORE_REPORT_28(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Click on Due date title
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_28(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 29, description = "Verify sort by Score when click on Score title",
            dataProvider = "getStudentScoreReportDataHashTable29", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_29(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Click on Score title
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_29(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_StudentScore_Report})
    @Test(priority = 31, description = "Verify data when click Export button",
            dataProvider = "getStudentScoreReportDataHashTable31", dataProviderClass = DataProviderSCStudentScoreReport.class)
            public void TC_STUDENT_SCORE_REPORT_31(Hashtable<String, String> data) throws IOException {
            //1. Log in teacher role
            loginPageSC.logInWithTeacherRoleWithReport();
            //2. Select Student Scores Report at Report Dropdown
            //3. Select Class at CLASS dropdown
            //4. Click Apply Filters button
            //5. Click Export button
            studentScoreReportPageSC.TC_STUDENT_SCORE_REPORT_31(data);
    }
}
