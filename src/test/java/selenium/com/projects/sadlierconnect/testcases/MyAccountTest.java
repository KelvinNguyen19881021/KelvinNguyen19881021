
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCMyAccount;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyAccount.MyAccountPageSC;

import java.util.Hashtable;


public class MyAccountTest extends BaseTest {

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    MyAccountPageSC myAccountPageSC;


    public MyAccountTest() {

        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        myAccountPageSC = new MyAccountPageSC();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 3, description = "Check data of account teacher", dataProvider = "getMyAccountData_SC_001", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_01(Hashtable<String, String> data) {

        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2.Click dropdown button
        //3.Click My Account
        myAccountPageSC.openMyAccountPageSC();
        //[CP]_At Step 3: Check data in field with account in Manage Teacher of Teacher role
        myAccountPageSC.checkMyAccountDataDetailSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 4, description = "Edit data account teacher successful", dataProvider = "getMyAccountData_SC_002", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_02(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2.Change First Name, Middile Name, Last Name, Email, UserName, Password
        // 3.Click Save button
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3: Display message " Your account information has been updated successfully"
        myAccountPageSC.verifySuccessMessageSC(data);
        // restore default value after verified data
        myAccountPageSC.updateDefaultMyAccountDataSC(data);

    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 5, description = "Click Cancel edit data account teacher successful", dataProvider = "getMyAccountData_SC_003", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_03(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2. Change First Name, Middle Name, Last Name, Email, UserName, Password
        //3. Click Cancel button
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.cancelMyAccountDataSC(data);
        //[CP]_At Step 3: Back to Dashboard Page.
        myAccountPageSC.verifyCancelMyAccountSC(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 6 , description = "Edit data account teacher successful - change opt", dataProvider = "getMyAccountData_SC_004", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_04(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        /* "2. Check box ""Yes, I want to opt out of receiving invitations and messages regarding
        updates  to my products and services. Please do not contact me about these matters.""" */
        //3. Click Save button
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_'At Step 3: Display message "Your account information has been updated successfully"
        //- "Yes" checkbox is checked
        myAccountPageSC.verifySuccessMessageSC(data);
        myAccountPageSC.verifyChangeOptMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 7 , description = "Edit data account teacher unsuccessful- not fill data all fields", dataProvider = "getMyAccountData_SC_005", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_05(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2. No data in field
        //3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3: Display message " This field is required"  under First Name, Last Name, Email, UserName, Password.
        myAccountPageSC.verifyNotFillAllFieldMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 8 , description = "Edit data account teacher unsuccessful - invalid email", dataProvider = "getMyAccountData_SC_006", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_06(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2. Type Invalid Email
        //3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3: Display message " Please enter a Valid email address" under email
        myAccountPageSC.verifyMessageEmailMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 9 , description = "Edit data account teacher unsuccessful - used email", dataProvider = "getMyAccountData_SC_007", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_07(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
       //2. Type Exist Email
        // 3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3: Display message " Please enter a Valid email address" under email
        myAccountPageSC.verifyMessageEmailMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 10 , description = "Edit data account teacher unsuccessful - invalid username", dataProvider = "getMyAccountData_SC_008", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_08(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2. Type UserName
        //3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3:   Display message " Value contains illegal characters" under UserName
        myAccountPageSC.verifyMessageUserNameMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Teacher})
    @Test(priority = 11 , description = "Edit data account teacher unsuccessful - used username", dataProvider = "getMyAccountData_SC_009", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_09(Hashtable<String, String> data) {
        //1. Log in Teacher account
        loginPageSC.logInWithTeacherRole();
        //2. Type UserName
        //3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        //[CP]_At Step 3: Display message " This username is being used by another user. Please try again." under UserName
        myAccountPageSC.verifyMessageUserNameMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 12, description = "Check data of account student", dataProvider = "getMyAccountData_SC_010", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_10(Hashtable<String, String> data) {
        //1. Log in as Student account
        loginPageSC.logInWithStudentRole();
       //2.Click dropdown button
       //3.Click My Account
        myAccountPageSC.openMyAccountPageSC();
        //[CP]_At Step 3: Check data in field with account in Manage Student of student role
        myAccountPageSC.checkMyAccountDataDetailStudentSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 13, description = "Edit data account student successful", dataProvider = "getMyAccountData_SC_011", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_11(Hashtable<String, String> data) {
        //1. Log in as Student account
        loginPageSC.logInWithStudentRole();
        //2.Change First Name, Middile Name, Last Name, Email, UserName, Password
        //3.Click Save button
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataStudentSC(data);
        //[CP]_At Step 3: Display message " Your account information has been updated successfully"
        myAccountPageSC.verifySuccessMessageSC(data);
        // update default data
        myAccountPageSC.updateDefaultMyAccountDataSC(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 14, description = "Click Cancel edit data account student successful", dataProvider = "getMyAccountData_SC_012", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_12(Hashtable<String, String> data) {
       // 1. Log in as student account
        loginPageSC.logInWithStudentRole();
        //2. Change First Name, Middle Name, Last Name, Email, UserName, Password
        myAccountPageSC.openMyAccountPageSC();
        // 3. Click Cancel button
        myAccountPageSC.cancelMyAccountDataStudentSC(data);
        //[CP]_At Step 3: Back to My Library Page.
        myAccountPageSC.verifyCancelMyAccountSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 15 , description = "Edit data account student unsuccessful - not fill all fields", dataProvider = "getMyAccountData_SC_013", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_13(Hashtable<String, String> data) {
       // 1. Log in as Student account
        loginPageSC.logInWithStudentRole();
       // 2. No data in field
       // 3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataStudentSC(data);
        //[CP]_At Step 3: Display message " This field is required"  under First Name, Last Name, UserName, Password.
        myAccountPageSC.verifyNotFillAllFieldMyAccountStudentSC(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 16 , description = "Edit data account student unsuccessful - invalid username", dataProvider = "getMyAccountData_SC_014", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_14(Hashtable<String, String> data) {
       // 1. Log in as Student account
        loginPageSC.logInWithStudentRole();
        // 2. Type UserName
       // 3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataStudentSC(data);
        //[CP]_At Step 3: Display message " Value contains illegal characters" under UserName
        myAccountPageSC.verifyMessageUserNameMyAccountStudentSC(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_My_Account_Student})
    @Test(priority = 17 , description = "Edit data account student unsuccessful - used username", dataProvider = "getMyAccountData_SC_015", dataProviderClass = DataProviderSCMyAccount.class)
    public void TC_MY_ACCOUNT_SC_15(Hashtable<String, String> data) {
        //1. Log in as Student account
        loginPageSC.logInWithStudentRole();
        //2. Type UserName
        //3. Click Save
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataStudentSC(data);
        //[CP]_At Step 3: Display message " This username is being used by another user. Please try again." under UserName
        myAccountPageSC.verifyMessageUserNameMyAccountStudentSC(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.RESET_DATA})
    @Test(priority = 1 , description = "Update default value of teacher", dataProvider = "getMyAccountData_SC_001", dataProviderClass = DataProviderSCMyAccount.class)
    public void updateDefaultValueTeacher(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherRole();
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataSC(data);
        myAccountPageSC.verifySuccessMessageSC(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.RESET_DATA})
    @Test(priority = 2 , description = "Update default value of student", dataProvider = "getMyAccountData_SC_010", dataProviderClass = DataProviderSCMyAccount.class)
    public void updateDefaultValueStudent(Hashtable<String, String> data) {
        loginPageSC.logInWithStudentRole();
        myAccountPageSC.openMyAccountPageSC();
        myAccountPageSC.updateMyAccountDataStudentSC(data);
        myAccountPageSC.verifySuccessMessageSC(data);

  }


}
