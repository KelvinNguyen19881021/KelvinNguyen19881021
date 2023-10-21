
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCManageClass;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageClasses.ManageClassesPageSC;

import java.util.Hashtable;


public class ManageClassTest extends BaseTest {

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    ManageClassesPageSC manageClassesPageSC;


    public ManageClassTest() {

        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        manageClassesPageSC = new ManageClassesPageSC();
    }


    // [CP]_Check add class successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 1, description = "Open Manage Class successful", dataProvider = "getMyClassData_SC_001", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_01(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        manageClassesPageSC.openManageClassPageSC();
        manageClassesPageSC.verifyOpenManageClassSuccessSC(data);


    }


    // [CP]_Check add class successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 2, description = "Add new class with not have students in class", dataProvider = "getMyClassData_SC_003", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_02(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Add class
        manageClassesPageSC.addNewClassSC(data);
        //Verify
        manageClassesPageSC.verifySuccessMessageAddClassSC(data);
        manageClassesPageSC.checkMyClassDataValueSC(data, 1);
        manageClassesPageSC.checkMyClassDataValueSC(data, 4);

    }


    // [CP]_Check add class successful
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 3, description = "Add new class with have students in class", dataProvider = "getMyClassData_SC_004", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_03(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Add class and student
        manageClassesPageSC.addNewClassAndStudentSC(data);
        manageClassesPageSC.addStudentInClassSC(data);
        //Verify
        manageClassesPageSC.verifySuccessMessageAddClassSC(data);
        manageClassesPageSC.checkMyClassDataValueSC(data, 1);
        manageClassesPageSC.checkMyClassDataValueSC(data, 4);
    }

    // [CP]_Check cancel add class
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 4, description = "Cancel class when input all fields", dataProvider = "getMyClassData_SC_005", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_04(Hashtable<String, String> data) {
            loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Cancel add class
        manageClassesPageSC.cancelAddNewClassSC(data);
        //Verify
        manageClassesPageSC.verifyCancelAddNewClassSC(data);

    }



    // [CP]_Check add class unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 5, description = "Add class with blank field in Class Name", dataProvider = "getMyClassData_SC_006", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_05(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Add class with blank field in Class Name
        manageClassesPageSC.addNewClassSC(data);
        //Verify
        manageClassesPageSC.verifyErrorMessageAddClassSC(data);

    }


    // [CP]_Check add class unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 6, description = "Add class duplicate name with button [Save]", dataProvider = "getMyClassData_SC_007", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_06(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Add class with duplicate name in Class Name and Save button
        manageClassesPageSC.addNewClassSC(data);
        //Verify
        manageClassesPageSC.verifyErrorMessageAddClassSC(data);

    }


    // [CP]_Check add class unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 7, description = "Add class duplicate name with button [Save and Add Students]", dataProvider = "getMyClassData_SC_008", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_07(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Click pencil icon to open pop-up in Manage Class
        manageClassesPageSC.openAddClassPopupSC();
        //Add class with duplicate name in Class Name and Save And Add Students button
        manageClassesPageSC.addNewClassAndStudentSC(data);
        //Verify
        manageClassesPageSC.verifyErrorMessageAddClassSC(data);

    }


    // [CP]_Check edit class success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 8, description = "Check edit class success with button [Save]", dataProvider = "getMyClassData_SC_009", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_08(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Edit class with button [Save]
        manageClassesPageSC.editChosenClassSC(data);
        //Verify
        manageClassesPageSC.verifySuccessMessageAddClassSC(data);
    }






    // [CP]_Check edit class success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 9, description = "Check edit class success with button [Save and Edit Students]", dataProvider = "getMyClassData_SC_010", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_09(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Edit class with button [Save and Edit Students]
        manageClassesPageSC.editChosenClassAndStudentSC(data);
        //Verify
        manageClassesPageSC.verifySuccessMessageAddClassSC(data);
        manageClassesPageSC.checkMyClassDataValueSC(data,4);
    }


    // [CP]_Check cancel edit class
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 10, description = "Check cancel edit class", dataProvider = "getMyClassData_SC_011", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_10(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Cancel edit class
        manageClassesPageSC.cancelEditChosenClassSC(data);
        //Verify
        manageClassesPageSC.verifyCancelAddNewClassSC(data);
    }



    // [CP]_Check add class groups success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 11, description = "Create groups with have student in group", dataProvider = "getMyClassData_SC_012", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_11(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Add group
        manageClassesPageSC.addGroupAndStudentSC(data);
        //Add student into group
        manageClassesPageSC.addStudentIntoGroupSC(data);
        //Verify
        manageClassesPageSC.verifyAddGroupSuccess(data);
    }


    // [CP]_Check add class groups success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 12, description = "Create groups with not have student in group", dataProvider = "getMyClassData_SC_013", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_12(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Add group
        manageClassesPageSC.addGroupSC(data);
        //Verify
        manageClassesPageSC.verifyAddGroupSuccess(data);
    }





    // [CP]_Check edit class groups success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 13, description = "Check edit class groups success", dataProvider = "getMyClassData_SC_014", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_13(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Edit group
        manageClassesPageSC.editGroupSC(data);
        //Verify
        manageClassesPageSC.verifyUpdatedGroupSuccess(data);
    }




    // [CP]_Check delete Class Groups
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 14, description = "Check delete Class Groups when group does not exist students", dataProvider = "getMyClassData_SC_015", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_14(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Delete group
        manageClassesPageSC.deleteGroup(data);
        //Verify
        manageClassesPageSC.verifyDeleteGroupSuccess(data);
    }


    // [CP]_Check delete Class Groups unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 15, description = "Check delete Class Groups unsuccess", dataProvider = "getMyClassData_SC_016", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_15(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Cancel delete group
        manageClassesPageSC.cancelDeleteGroup(data);
        //Verify
        manageClassesPageSC.verifyCancelDeleteGroupSuccess(data);
    }


    // [CP]_Check add group unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 16, description = "Create groups with field [Group] is blank", dataProvider = "getMyClassData_SC_017", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_16(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Add group with blank in field [Group]
        manageClassesPageSC.addGroupSC(data);
        //Verify
        manageClassesPageSC.verifyRequiredErrorMessageAddGroupSC(data);
    }


    // [CP]_Check add group unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 17, description = "Input all fields and click button [Cancel]", dataProvider = "getMyClassData_SC_018", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_17(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Cancel add group
        manageClassesPageSC.cancelAddGroupSC(data);
        ///Verify
        manageClassesPageSC.verifyCancelAddGroupSC(data);
    }
    // [CP]_Check add group unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 18, description = "Create groups with field [Group] is duplicated", dataProvider = "getMyClassData_SC_019", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_18(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage group of class
        manageClassesPageSC.openManageGroupOfClassSC(data);
        //Add group with duplicate name
        manageClassesPageSC.addGroupSC(data);
        //Verify
        manageClassesPageSC.verifyDupErrorMessageAddGroupSC(data);
    }


    // [CP]_Check display Site licenses correct
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 19, description = "When filter a product in Site License", dataProvider = "getMyClassData_SC_020", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_20(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage License of class
        manageClassesPageSC.openManageLicensesOfClassSC(data);
        //Filter a product in Site License
        manageClassesPageSC.openSiteLicensesOfClassSC();
        //Verify
        manageClassesPageSC.verifyOneSiteLicense(data);

    }
    // [CP]_Check display Seat licenses correct
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 20, description = "When filter a product in Site License", dataProvider = "getMyClassData_SC_021", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_21(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage License of class
        manageClassesPageSC.openManageLicensesOfClassSC(data);
        //Verify
        manageClassesPageSC.verifyOneSeatLicense(data);
    }
    


    // [CP]_Check display Seat licenses correct
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 21, description = "Class not add seat licenses by school admin", dataProvider = "getMyClassData_SC_022", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_22(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open Manage License of class and class has not seat license
        manageClassesPageSC.openManageLicensesOfClassSC(data);
        //Verify
        manageClassesPageSC.verifyNoSeatLicense();
    }


    // [CP]_Check view class roster of class
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 22, description = "Exists class valid, class has not student", dataProvider = "getMyClassData_SC_023", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_23(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //View class roster of class and class has not student
        manageClassesPageSC.viewClassRosterSC(data);
        //Verify
        manageClassesPageSC.verifyViewClassRosterNoStudentSC(data);

    }
    // [CP]_Check view class roster of class
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 23, description = "Exists class valid, class has student", dataProvider = "getMyClassData_SC_024", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_24(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //View class roster of class and class has student
        manageClassesPageSC.viewClassRosterSC(data);
        //Verify
        manageClassesPageSC.verifyViewClassRosterFiveStudentsSC(data);

    }


    // [CP]_Check direct to Compose Message and send mail success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 24, description = "Check direct to Compose Message and send mail success", dataProvider = "getMyClassData_SC_032", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_31(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open send message form
        manageClassesPageSC.openMessageInClassSC(data);
        //Fill data to send
        manageClassesPageSC.sendMessageToClassSC(data);
        //Verify
        manageClassesPageSC.verifySendMessageToClassSuccessSC(data);
    }
    // [CP]_Check direct to Compose Message and send mail unsuccess
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 25, description = "Check direct to Compose Message and send mail unsuccess", dataProvider = "getMyClassData_SC_033", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_32(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        //Open Manage Class
        manageClassesPageSC.openManageClassPageSC();
        //Open send message form
        manageClassesPageSC.openMessageInClassSC(data);
        //Send message with blank field in Subject
        manageClassesPageSC.sendMessageToClassSC(data);
        //Verify
        manageClassesPageSC.verifyErrorSendMessageToClassSC(data);
    }




    // [CP]_Check can't delete class
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 26, description = "Check can't delete class", dataProvider = "getMyClassData_SC_034", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_33(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        manageClassesPageSC.openManageClassPageSC();
        //Verify class and class can not delete
        manageClassesPageSC.verifyCanNotDeleteClassSC(data);
    }



    // [CP]_Check cancel delete class success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 27, description = "Check cancel delete class success", dataProvider = "getMyClassData_SC_035", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_34(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        manageClassesPageSC.openManageClassPageSC();
        manageClassesPageSC.cancelDeleteClassSC(data);
        manageClassesPageSC.verifyCancelDeleteClassSC(data);

    }
    // [CP]_Check delete class success
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Classes})
    @Test(priority = 28, description = "Check delete class success", dataProvider = "getMyClassData_SC_036", dataProviderClass = DataProviderSCManageClass.class)
    public void TC_MANAGE_CLASS_SC_35(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        manageClassesPageSC.openManageClassPageSC();
        manageClassesPageSC.deleteClassSCSuccess(data);
        manageClassesPageSC.verifyDeleteClassSCSuccess(data);

    }
    //Remove data testing
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.RESET_DATA})
    @Test(priority = 29, description = "Check delete class success", dataProvider = "getMyClassData_SC_035", dataProviderClass = DataProviderSCManageClass.class)
    public void RemoveDataTesting(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        manageClassesPageSC.openManageClassPageSC();
        manageClassesPageSC.deleteClassSCSuccess(data);

    }




}
