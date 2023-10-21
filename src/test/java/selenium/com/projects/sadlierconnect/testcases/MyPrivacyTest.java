
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCLogin;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyPrivacy.MyPrivacyPageSC;
import selenium.com.projects.sadlierconnect.pages.TermConditions.TermConditionsPageSC;

import java.util.Hashtable;


public class MyPrivacyTest extends BaseTest {

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    MyPrivacyPageSC myPrivacyPageSC;
    TermConditionsPageSC termConditionsPageSC;

    public MyPrivacyTest() {

        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        myPrivacyPageSC = new MyPrivacyPageSC();
        termConditionsPageSC = new TermConditionsPageSC();
    }



    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 1, description = "Verify that the [Access Privacy Policy] page is opened successfully", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_01_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Click Privacy Policy
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //[CP]_2. Access to Privacy Policy Page Successfully
        myPrivacyPageSC.verifyMyPrivacyPageIsOpened();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 2, description = "Verify Click link [http://www.sadlierconnect.com] is opened Successfully", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_02_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //1.Scroll down and Click Privacy Policy page
        //[CP]_Access to Privacy Policy Page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //2. Click link "http://www.sadlierconnect.com"
        myPrivacyPageSC.verifyLinkSadlierConnectIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 3, description = "Verify Click link [www.sadlierconnect.com/termsandconditions] is opened Successfully", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_03_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link "www.sadlierconnect.com/termsandconditions"
        myPrivacyPageSC.verifyLinkTermsandConditionIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 4, description = "Check Click link [ https://www.google.com/policies/privacy/partners/] is opened Successfully", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_04_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link " https://www.google.com/policies/privacy/partners/"
        myPrivacyPageSC.verifyLinkGooglePrivacyandTermIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 5, description = "Check Click link [https://tools.google.com/dlpage/gaoptout.]  is opened Successfully", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_05_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link " https://tools.google.com/dlpage/gaoptout."
        myPrivacyPageSC.verifyLinkGoogleAnalyticsIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 7, description = "Check Click [Back] button to navigate Dashboard page", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_07_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click back button & [CP]_Role Teacher: Navigate to Dashboard
        myPrivacyPageSC.verifyDashBoardIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 8, description = "Check that the [Access Term and Conditions] page is opened ", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_08_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Click Term and Conditions
        termConditionsPageSC.openTermConditions();
        //[CP]_Role Teacher: Access to Term and Condition page success
        termConditionsPageSC.verifyTermConditionsPageIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 9, description = "Check Click link [http://www.sadlierconnect.com/privacypolicy.html.] is opened Successfully ", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_09_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in as Teacher, input passcode and username, password
        loginPageSC.loginUsers(data);
        //2. Click Term and Conditions
        termConditionsPageSC.openTermConditions();
        //3. Click link "http://www.sadlierconnect.com/privacypolicy.html."
        //[CP]_Role Teacher: Navigate to Privacy Policy
        termConditionsPageSC.verifyLinkPrivacyPolicyOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 11, description = "Check Click [Back] button to navigate Dashboard page ", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_11_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1.  Log in Teacher
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Term and Conditions
        termConditionsPageSC.openTermConditions();
        //3. Click back button
        //[CP]_Role Teacher: Navigate to Dashboard
        termConditionsPageSC.verifyTermsandconditionBackDashboard();

    }


    //_Role Student.

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 12, description = "Verify that the [Access Privacy Policy] page is opened successfully", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_12_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student, input passcode and username, password
        //[CP]_1. Login student role successfully
        loginPageSC.loginUsers(data);
        //2. Click Privacy Policy
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //[CP]_2. Access to Privacy Policy Page Successfully
        myPrivacyPageSC.verifyMyPrivacyPageIsOpened();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 13, description = "Verify Click link [http://www.sadlierconnect.com] is opened Successfully", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_13_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link "http://www.sadlierconnect.com"
        //[CP]_Role Student: Navigate to My Dashboard
        myPrivacyPageSC.verifyLinkSadlierConnectIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 14, description = "Verify Click link [www.sadlierconnect.com/termsandconditions] is opened Successfully", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_14_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link "www.sadlierconnect.com/termsandconditions"
        //[CP]_Role Student: Navigate Terms and Conditions
        myPrivacyPageSC.verifyLinkTermsandConditionIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 15, description = "Check Click link [ https://www.google.com/policies/privacy/partners/] is opened Successfully", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_15_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link " https://www.google.com/policies/privacy/partners/"
        //[CP]_Role Student: Navigate Google Privacy and term page
        myPrivacyPageSC.verifyLinkGooglePrivacyandTermIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 16, description = "Check Click link [https://tools.google.com/dlpage/gaoptout.]  is opened Successfully", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_16_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click link " https://tools.google.com/dlpage/gaoptout."
        //[CP]_Role Student: Navigate Google Analytics Opt-out Browser Add-on page
        myPrivacyPageSC.verifyLinkGoogleAnalyticsIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 18, description = "Check Click [Back] button to navigate Dashboard page", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_18_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Privacy Policy page
        myPrivacyPageSC = dashboardPageSC.openMyPrivacy();
        //3. Click back button
        //[CP]_Role Student: Navigate to Dashboard
        myPrivacyPageSC.verifyDashBoardIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 19, description = "Check that the [Access Term and Conditions] page is opened ", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_19_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Click [Term & Conditions]
        termConditionsPageSC.openTermConditions();
        //[CP]_Role Student: Access to Term and Condition page success
        termConditionsPageSC.verifyTermConditionsPageIsOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 20, description = "Check Click link [http://www.sadlierconnect.com/privacypolicy.html.] is opened Successfully ", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_20_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Term and Conditions
        termConditionsPageSC.openTermConditions();
        //3. Click link "http://www.sadlierconnect.com/privacypolicy.html." & [CP]_Role Student: Navigate to Privacy Policy
        termConditionsPageSC.verifyLinkPrivacyPolicyOpened();

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Privacy_Policy})
    @Test(priority = 22, description = "Check Click [Back] button to navigate Dashboard page ", dataProvider = "getStudentLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_PRIVACY_POLICY_22_SC(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Log in Student
        loginPageSC.loginUsers(data);
        //2. Scroll down and Click Term and Conditions
        termConditionsPageSC.openTermConditions();
        //  3. Click [Back] button & [CP]_Role Student: Navigate to Dashboard
        termConditionsPageSC.verifyTermsandconditionBackDashboard();

    }


    /*@FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 3, description = "Verify that the [Access Term and Conditions] page is opened successfully", dataProvider = "getUsersLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_TERM_CONDITION_0******_SC(Hashtable<String, String> data) throws IllegalAccessException {
        if(data.get(LoginModel.getUserRole()).equals("System Admin")){
            loginPageSC.loginAdministrator(data);
        }
        else {
            loginPageSC.loginUsers(data);
        }
        termConditionsPageSC.openTermConditions();
        termConditionsPageSC.checkTermConditionsPage();
        termConditionsPageSC.checkUserClickBackButton(data);
    }
    */

}
