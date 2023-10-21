
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourney;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentJourneyPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;

import java.io.IOException;
import java.util.Hashtable;


public class AssignmentJourneyTest extends BaseTest {

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    MyLibraryPageSC myLibraryPageSC;
    AssignmentJourneyPageSC assignmentJourneyPageSC;



    public AssignmentJourneyTest() {

        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        myLibraryPageSC =new MyLibraryPageSC();
        assignmentJourneyPageSC= new AssignmentJourneyPageSC();

    }
/*
    // Assessment ISE/TE
    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 1, description = "Check that create Assignment successful with default value", dataProvider = "getAssignmentJourney_Data_SC_001", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_001(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }



    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 2, description = "Check that create Assignment successful with class has group", dataProvider = "getAssignmentJourney_Data_SC_002", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_002(Hashtable<String, String> data) throws IOException {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentWithGroup(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }




    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 3, description = "Check that create Assignment successful with using end date", dataProvider = "getAssignmentJourney_Data_SC_003", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_003(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 4, description = "Check that create Assignment successful with multiple classes", dataProvider = "getAssignmentJourney_Data_SC_004", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_004(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 5, description = "Check that create Assignment successful with using assign icon in library", dataProvider = "getAssignmentJourney_Data_SC_005", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_005(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByAssignInLibrary(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 6, description = "Check that create Assignment successful with change section", dataProvider = "getAssignmentJourney_Data_SC_006", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_006(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 7, description = "Check that create Assignment successful with future time", dataProvider = "getAssignmentJourney_Data_SC_007", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_007(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentWithFutureTime(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }

    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 8, description = "Check that create Assignment successful with choosing \"limits to 2 choices\" option", dataProvider = "getAssignmentJourney_Data_SC_008", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_008(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 9, description = "Check that create Assignment successful with choosing \"scramble questions\" option", dataProvider = "getAssignmentJourney_Data_SC_009", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_009(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 10, description = "Check that create Assignment successful with choosing \"Exclude assignment data from reports and alerts\"option", dataProvider = "getAssignmentJourney_Data_SC_010", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_010(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }



    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 11, description = "Check that create Assignment successful with more assessment resource", dataProvider = "getAssignmentJourney_Data_SC_011", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_011(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
    }
*/

    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 12, description = "Check that create Assignment successful with assign multiple time with one resource", dataProvider = "getAssignmentJourney_Data_SC_012", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_012(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentWithMoreTime(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }


    /*


    // [CP]_Check that create Assignment successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 13, description = "Check that create Assignment successful with Multi-Part Assignment (all assessment resource)", dataProvider = "getAssignmentJourney_Data_SC_013", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_013(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }


    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 14, description = "Check that create Assignment unsuccessful with click Cancel button", dataProvider = "getAssignmentJourney_Data_SC_014", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_014(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.cancelCreateAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCancelCreateAssignmentInTeacherRole(data);

    }


    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 15, description = "Check that create Assignment unsuccessful with not fill data in field", dataProvider = "getAssignmentJourney_Data_SC_015", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_015(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentUnSuccessWithNotFillData(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithNotFillData(data);

    }


    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 16, description = "Check that create Assignment unsuccessful with invalid time (due date> end date)", dataProvider = "getAssignmentJourney_Data_SC_016", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_016(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithPopUp(data);
    }


    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 17, description = "Check that create Assignment unsuccessful with invalid time (due date < current time)", dataProvider = "getAssignmentJourney_Data_SC_017", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_017(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithPopUp(data);

    }


    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 18, description = "Check that create Assignment unsuccessful with not choose resource", dataProvider = "getAssignmentJourney_Data_SC_018", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_018(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithPopUp(data);
    }




    // [CP]_Check that create Assignment unsuccessful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 19, description = "Check that create Assignment unsuccessful with not choose any student", dataProvider = "getAssignmentJourney_Data_SC_019", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_019(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithPopUp(data);

    }





    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not fill point
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 20, description = "Create Assignment Static Resource  - Not fill point when choose scoring option: Point", dataProvider = "getAssignmentJourney_Data_SC_020", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_020(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);

    }

     */
    /*
    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not fill percent
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 20, description = "Create Assignment Static Resource  - Not fill percent when choose scoring option: Percent", dataProvider = "getAssignmentJourney_Data_SC_020", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_020(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentUnSuccessWithPoint(data);

    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) - not show default option "Require submission of annotations."
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 21, description = "Create Assignment Static Resource  - 1 resource (game, video, Virtual Manipulatives) - scoring option: Status", dataProvider = "getAssignmentJourney_Data_SC_021", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_021(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByAssignInLibrary(data);
        assignmentJourneyPageSC.createAssignmentSuccessAndCheckOption(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }


    // [CP]_Check that create Assignment (Assessment resource) successful with single grading resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 22, description = "Create Assignment Assessment Resource (single grading)  - 1 resource - show all choices", dataProvider = "getAssignmentJourney_Data_SC_022", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_022(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful when choosing "limits to 2 choices" option
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 23, description = "Create Assignment Assessment Resource (single grading)  - 1 resource - Limits to 2 choices", dataProvider = "getAssignmentJourney_Data_SC_023", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_023(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful when choosing "scramble questions" option
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 24, description = "Create Assignment Assessment Resource (single grading)  - 1 resource - Scramble Questions", dataProvider = "getAssignmentJourney_Data_SC_024", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_024(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful when choose "Exclude assignment data from reports and alerts" option
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 25, description = "Create Assignment Assessment Resource (single grading)  - 1 resource - Exclude assignment data from reports and alerts", dataProvider = "getAssignmentJourney_Data_SC_025", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_025(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful with more resources
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 26, description = "Create Assignment Assessment Resource (single grading)  - more resources (assessment)", dataProvider = "getAssignmentJourney_Data_SC_026", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_026(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment successful with assessment and static resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 27, description = "Create Assignment Assessment Resource (single grading)  - more resources (assessment + static resource)", dataProvider = "getAssignmentJourney_Data_SC_027", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_027(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment successful with more resources and using parent assignment
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 28, description = "Create Assignment Assessment Resource  - more resources (assessment + static resource) - choose parent assignment", dataProvider = "getAssignmentJourney_Data_SC_028", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_028(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful  with bulk grading resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 29, description = "Create Assignment Assessment Resource (bulk grading) - 1 resource (assessment)", dataProvider = "getAssignmentJourney_Data_SC_029", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_029(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }
    // [CP]_Check that create Assignment (Assessment resource) successful  with bulk grading resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 30, description = "Create Assignment Assessment Resource (bulk grading) - 1 resource (assessment)", dataProvider = "getAssignmentJourney_Data_SC_030", dataProviderClass = DataProviderSCAssignmentJourney.class)
    public void TC_Assignment_Journey_030(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        assignmentJourneyPageSC.createAssignmentSuccess(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInTeacherRole(data);
        assignmentJourneyPageSC.verifyCreateAssignmentInStudentRole(data);
    }

*/

}
