
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourneyFilterStatus;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourneySetting;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentFilterStatusPageSC;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentSettingPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;


public class AssignmentSettingTest extends BaseTest {

    LoginPageSC loginPageSC;
    AssignmentSettingPageSC AssignmentSettingTest;



    public AssignmentSettingTest() {

        loginPageSC = new LoginPageSC();
        AssignmentSettingTest= new AssignmentSettingPageSC();

    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 1, description = "Check Option Student Upload in Manage Setting", dataProviderClass = DataProviderSCAssignmentJourneySetting.class)
    public void TC_Assignment_Journey_266(){
        //1. Log in as admin school
        loginPageSC.logInWithAdminSchoolRoleAssignmentFilterSetting();
//        2. Click Setting
//        3. Choose Manage Setting
//        4. Choose option in "Enable uploads of student content for assignments?"
//        5. Click "Save"
        AssignmentSettingTest.checkOptionStudentUploadInManageSetting();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 2, description = "Check Show Point in Assignment Report", dataProviderClass = DataProviderSCAssignmentJourneySetting.class)
    public void TC_Assignment_Journey_267(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Click avatar icon
//        3. Choose Account Setting
//        4. Choose dropdown in "Score on Reports"
//        5. Click "Save"
        AssignmentSettingTest.checkShowPointinAssignmentReport();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 3, description = "Check Show Percent in Assignment Report", dataProviderClass = DataProviderSCAssignmentJourneySetting.class)
    public void TC_Assignment_Journey_268(){
        //1. Log in as teacher
        loginPageSC.logInWithTeacherRoleAssignmentFilterSetting();
//        2. Click avatar icon
//        3. Choose Account Setting
//        4. Choose dropdown in "Score on Reports"
//        5. Click "Save"
        AssignmentSettingTest.checkShowPerceninAssignmentReport();
    }
}
