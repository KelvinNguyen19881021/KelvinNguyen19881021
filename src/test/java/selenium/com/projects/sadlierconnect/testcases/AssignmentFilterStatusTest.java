
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourney;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourneyFilterStatus;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentFilterStatusPageSC;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentJourneyPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;

import java.util.Hashtable;


public class AssignmentFilterStatusTest extends BaseTest {

    LoginPageSC loginPageSC;
    AssignmentFilterStatusPageSC AssignmentFilterStatusTest;



    public AssignmentFilterStatusTest() {

        loginPageSC = new LoginPageSC();
        AssignmentFilterStatusTest= new AssignmentFilterStatusPageSC();

    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 1, description = "Check Filter with status Graded", dataProviderClass = DataProviderSCAssignmentJourneyFilterStatus.class)
    public void TC_Assignment_Journey_261(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Open Assignment List
//        3. Choose class
//        4. Choose assignment status
//        5. Click "Apply Filter"
        AssignmentFilterStatusTest.checkFilterWithStatusGraded();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 2, description = "Check Filter with status Pending", dataProviderClass = DataProviderSCAssignmentJourneyFilterStatus.class)
    public void TC_Assignment_Journey_262(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Open Assignment List
//        3. Choose class
//        4. Choose assignment status
//        5. Click "Apply Filter"
        AssignmentFilterStatusTest.checkFilterWithStatusPending();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 3, description = "Check Filter with status Needs Grading", dataProviderClass = DataProviderSCAssignmentJourneyFilterStatus.class)
    public void TC_Assignment_Journey_263(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Open Assignment List
//        3. Choose class
//        4. Choose assignment status
//        5. Click "Apply Filter"
        AssignmentFilterStatusTest.checkFilterWithStatusNeedsGrading();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 4, description = "Check Filter with status Active", dataProviderClass = DataProviderSCAssignmentJourneyFilterStatus.class)
    public void TC_Assignment_Journey_264(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Open Assignment List
//        3. Choose class
//        4. Choose assignment status
//        5. Click "Apply Filter"
        AssignmentFilterStatusTest.checkFilterWithStatusActive();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 5, description = "Check Filter with status Closed,Expired", dataProviderClass = DataProviderSCAssignmentJourneyFilterStatus.class)
    public void TC_Assignment_Journey_265(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Open Assignment List
//        3. Choose class
//        4. Choose assignment status
//        5. Click "Apply Filter"
        AssignmentFilterStatusTest.checkFilterWithStatusClosedExpired();
    }

}
