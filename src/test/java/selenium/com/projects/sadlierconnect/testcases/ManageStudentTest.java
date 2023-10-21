package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.constants.FrameworkConstants;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCManageStudent;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;

import java.io.IOException;
import java.util.Hashtable;

public class ManageStudentTest extends BaseTest {

    private final LoginPageSC loginPageSC;
    private final DashboardPageSC dashboardPageSC;
    private ManageStudentsPageSC manageStudentsPageSC;

    public ManageStudentTest() {
        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        if (manageStudentsPageSC == null) {
            manageStudentsPageSC = new ManageStudentsPageSC();
            manageStudentsPageSC.excelToCSV();
//            manageStudentsPageSC.updateFileExcel(true);
        }
    }

    //filter
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 1, description = "Verify data class and result response when apply filter with any record class", dataProvider = "getManagerStudentDataHashTable001", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_001(Hashtable<String, String> data) throws IOException {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_001(data);
    }

//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
//    @Test(priority = 2, description = "Verify data class and result response when apply filter with ALL record class", dataProvider = "getManagerStudentDataHashTable002", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_002(Hashtable<String, String> data) throws IOException {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_002(data);
//    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 3, description = "Verify data grade and result response when apply filter with grade level has student", dataProvider = "getManagerStudentDataHashTable003", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_003(Hashtable<String, String> data) throws IOException {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_003(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 4, description = "Verify result response when apply filter with grade level has no student", dataProvider = "getManagerStudentDataHashTable004", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_004(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_004(data);
    }

//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
//    @Test(priority = 5, description = "Verify result response when apply filter with \"ALL\" grade level ", dataProvider = "getManagerStudentDataHashTable005", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_005(Hashtable<String, String> data) throws IOException {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_005(data);
//    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 6, description = "Verify result response when apply filter with last name has exists", dataProvider = "getManagerStudentDataHashTable006", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_006(Hashtable<String, String> data) throws IOException {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_006(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 7, description = "Verify result response when apply filter with last name has not exists", dataProvider = "getManagerStudentDataHashTable007", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_007(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_007(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 8, description = "Verify result response when apply filter with class and grade", dataProvider = "getManagerStudentDataHashTable008", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_008(Hashtable<String, String> data) throws IOException {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_008(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 9, description = "Verify result response when apply filter with class, grade and last name", dataProvider = "getManagerStudentDataHashTable009", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_009(Hashtable<String, String> data) throws IOException {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_009(data);
    }

    // add
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 10, description = "Verify add student when input all fields (Student Id, First name, Middle name, Last name, User name, Password, Grade level)", dataProvider = "getManagerStudentDataHashTable010", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_010(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_010(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 11, description = "Verify add student when only input all required fields *(Firtname, Lastname, Username, Password)", dataProvider = "getManagerStudentDataHashTable011", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_011(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_011(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 12, description = "Verify add student when input UserName less than 3 characters and more than 50 characters", dataProvider = "getManagerStudentDataHashTable012", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_012(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_012(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 13, description = "Verify add student when do not input any item", dataProvider = "getManagerStudentDataHashTable013", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_013(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_013(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 14, description = "Verify add student when input User name with special character", dataProvider = "getManagerStudentDataHashTable014", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_014(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_014(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 15, description = "Verify add student when input \"student id\" already exists", dataProvider = "getManagerStudentDataHashTable015", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_015(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_015(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 16, description = "Verify add student when input \"User name\" already exists", dataProvider = "getManagerStudentDataHashTable016", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_016(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_016(data);
    }

    // export
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 17, description = "Verify import roster when data valid", dataProvider = "getManagerStudentDataHashTable017", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_017(Hashtable<String, String> data) {
        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_017(data);
            DriverManager.quit();
        }
        else
        {
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_017(data);
        }
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 18, description = "Verify import roster when data invalid", dataProvider = "getManagerStudentDataHashTable018", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_018(Hashtable<String, String> data) {
        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_018(data);
            DriverManager.quit();
        }
        else
        {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_018(data);
        }
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 19, description = "Verify import roster with file not correct format", dataProvider = "getManagerStudentDataHashTable019", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_019(Hashtable<String, String> data) {
        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_019(data);
            DriverManager.quit();
        }
        else
        {
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_019(data);
        }
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 20, description = "Verify import roster when data valid and invalid", dataProvider = "getManagerStudentDataHashTable020", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_020(Hashtable<String, String> data) {
        if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
            DriverManager.setDriver(DriverManager.optionsDislayedDriver());
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_020(data);
            DriverManager.quit();
        }
        else
        {
            //1. Login with teacher role
            loginPageSC.logInWithTeacherRole();
            //2. Open page manager student
            manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
            //3. Verify and execute that test case
            manageStudentsPageSC.TC_Manage_Student_020(data);
        }
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 21, description = "Verify export roster  when have student on table", dataProvider = "getManagerStudentDataHashTable021", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_021(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_021(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 22, description = "Verify export roster when no students on table", dataProvider = "getManagerStudentDataHashTable022", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_022(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_022(data);
    }

    //edit

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 23, description = "Verify edit student account when update all item with data valid", dataProvider = "getManagerStudentDataHashTable023", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_023(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_023(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 24, description = "Verify add licenses in edit account student", dataProvider = "getManagerStudentDataHashTable024", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_024(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_024(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 25, description = "Verify edit student when not input all or delete data in required fields *(Firtname, Lastname, Username, Password)", dataProvider = "getManagerStudentDataHashTable025", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_025(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_025(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 26, description = "Verify edit student account when update \"User name\" with special character", dataProvider = "getManagerStudentDataHashTable026", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_026(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_026(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 27, description = "Verify edit student account when update \"Student Id\" already exists", dataProvider = "getManagerStudentDataHashTable027", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_027(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_027(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 28, description = "Verify edit student account when update \"User name\" already exists", dataProvider = "getManagerStudentDataHashTable028", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_028(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_028(data);
    }

    // enable and disable
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 29, description = "Verify not change status when disable account unsuccessfully", dataProvider = "getManagerStudentDataHashTable029", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_029(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_029(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 30, description = "Verify change status when disable account and can not login with disabled account", dataProvider = "getManagerStudentDataHashTable030", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_030(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_030(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 31, description = "Verify not change status when enable account unsuccessfully", dataProvider = "getManagerStudentDataHashTable031", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_031(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_031(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 32, description = "Verify change status when enable account and can  login with enabled account", dataProvider = "getManagerStudentDataHashTable032", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_032(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_032(data);
    }

    //delete
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 33, description = "Verify delete account unsuccessfully", dataProvider = "getManagerStudentDataHashTable033", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_033(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_033(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 34, description = "Verify delete account successfully", dataProvider = "getManagerStudentDataHashTable034", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_034(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_034(data);
    }

    //send mail
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 35, description = "Verify send compose message with subject and content", dataProvider = "getManagerStudentDataHashTable035", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_035(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_035(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 36, description = "Verify send compose message with subject and not content", dataProvider = "getManagerStudentDataHashTable036", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_036(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_036(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 37, description = "Verify send compose message with subject and content", dataProvider = "getManagerStudentDataHashTable037", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_037(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_037(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 38, description = "Verify send compose message with not subject", dataProvider = "getManagerStudentDataHashTable038", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_038(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_038(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 39, description = "Verify not send compose message when click Cancel", dataProvider = "getManagerStudentDataHashTable039", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_039(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_039(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 40, description = "Verify Send Offline eBook Instructions when click Send", dataProvider = "getManagerStudentDataHashTable040", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_040(Hashtable<String, String> data) {
        //1. Login with teacher roleD:\lms-automation-test\src\test\resources\testdataSC\import\StudentImportTemplate_017.csvD:\lms-automation-test\src\test\resources\testdataSC\import\StudentImportTemplate_018.csv

        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_040(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 41, description = "Verify Send Offline eBook Instructions when click Cancel", dataProvider = "getManagerStudentDataHashTable041", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_041(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_041(data);
    }

    //print
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 42, description = "Verify Print Student Letter when click Print", dataProvider = "getManagerStudentDataHashTable042", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_042(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_042(data);
//    }
//
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 43, description = "Verify Print Parent Letter when click Print", dataProvider = "getManagerStudentDataHashTable043", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_043(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_043(data);
//    }
//
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 44, description = "Verify Print Offline eBook Letters when click Print", dataProvider = "getManagerStudentDataHashTable044", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_044(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_044(data);
//    }
//
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 45, description = "Verify Print Student Letter when click Cancel", dataProvider = "getManagerStudentDataHashTable045", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_045(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_045(data);
//    }
//
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 46, description = "Verify Print Parent Letter when click Cancel", dataProvider = "getManagerStudentDataHashTable046", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_046(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_046(data);
//    }
//
//    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.REGRESSION })
//    @Test(priority = 47, description = "Verify Print Offline eBook Letters when click Cancel", dataProvider = "getManagerStudentDataHashTable047", dataProviderClass = DataProviderSCManageStudent.class)
//    public void TC_Manage_Student_047(Hashtable<String, String> data) {
//        //1. Login with teacher role
//        loginPageSC.logInWithTeacherRole();
//        //2. Open page manager student
//        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
//        //3. Verify and execute that test case
//        manageStudentsPageSC.TC_Manage_Student_047(data);
//    }

    //manage license
    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 48, description = "Verify manage licenses", dataProvider = "getManagerStudentDataHashTable048", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_048(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_048(data);
    }

    @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Manage_Student })
    @Test(priority = 49, description = "Verify manage licenses", dataProvider = "getManagerStudentDataHashTable049", dataProviderClass = DataProviderSCManageStudent.class)
    public void TC_Manage_Student_049(Hashtable<String, String> data) {
        //1. Login with teacher role
        loginPageSC.logInWithTeacherRole();
        //2. Open page manager student
        manageStudentsPageSC = dashboardPageSC.openManageStudentPage();
        //3. Verify and execute that test case
        manageStudentsPageSC.TC_Manage_Student_049(data);
    }

}
