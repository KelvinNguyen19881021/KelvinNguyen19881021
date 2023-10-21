package selenium.com.projects.sadlierconnect.testcases;

import java.util.Hashtable;
import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccess;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.FullAccess.FullAccessPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

/**
 * @author : tien.vo-ngoc
 * @created : Sep, 14 2023
 **/
public class FullAccessTest  extends BaseTest {

    private final LoginPageSC loginPageSC;
    private final FullAccessPageSC fullAccessPageSC;

    public FullAccessTest() {
        this.loginPageSC = new LoginPageSC();
        this.fullAccessPageSC = new FullAccessPageSC();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 1, description = "Check FullAccess Report in school when import license without parent code.",
        dataProvider = "getSCFullAccessDataHashTable01", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_01(Hashtable<String, String> data) {
        loginPageSC.logInWithSystemAdminRole();
        fullAccessPageSC.TC_License_01(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 2, description = "Check warning message when import license with parent code but do not have the full product code required",
        dataProvider = "getSCFullAccessDataHashTable02", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_02(Hashtable<String, String> data) {
        /*1. Login to system with account system admin  */
        loginPageSC.logInWithSystemAdminRole();
        /*2. Select dropdown Import
        3. Select item Import License
        4. Add file selected then select button Continue
        5. Import License
        TC_license_02 */
        fullAccessPageSC.TC_License_02(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 3, description = "Check FullAccess Report in school when import license with parent code but do not have the full product code required.",
        dataProvider = "getSCFullAccessDataHashTable03", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_03(Hashtable<String, String> data) {
        /*. Login to system with account system admin  */
        loginPageSC.logInWithSystemAdminRole();
          /*
            1. Login to school with account teacher
            2. Select Report tab
            TC_License_03
          */
        fullAccessPageSC.TC_License_03(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 4, description = "Check FullAccess Report in school when import license with bundle code.",
        dataProvider = "getSCFullAccessDataHashTable04", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_04(Hashtable<String, String> data) {
      //1. Login to system with account system admin
        loginPageSC.logInWithSystemAdminRole();
         /*
            1. Login to school with account teacher
            2. Select Report tab
            TC_License_04
          */
        fullAccessPageSC.TC_License_04(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 5, description = "Check warning message when import license with blank bundle of We belive (803009).",
            dataProvider = "getSCFullAccessDataHashTable05", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_05(Hashtable<String, String> data) {
        // 1. Login to system with account system admin
        loginPageSC.logInWithSystemAdminRole();
        // 2. Select dropdown Import
        //3. Select item Import License
        //4. Add file selected then select button Continue
        //5. Import License
        // TC_License_05
        fullAccessPageSC.TC_License_05(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 6, description = "Check FullAccess Report in school with blank bundle.",
            dataProvider = "getSCFullAccessDataHashTable06", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_06(Hashtable<String, String> data) {
        // 1. Login to system with account system admin
        loginPageSC.logInWithSystemAdminRole();
        // 2. Select dropdown Import
        //3. Select item Import License
        //4. Add file selected then select button Continue
        //5. Import License
        // TC_License_06
        fullAccessPageSC.TC_License_06(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 7, description = "Check icon FullAccess on TOC after enable FullAccess successful in school.",
            dataProvider = "getSCFullAccessDataHashTable09", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_09(Hashtable<String, String> data) {
//        1. Login to school with account teacher
//        2. Select My Library
//        3. Select PIM - Grade 7
//        4. Select the TOC "Assessment"
        fullAccessPageSC.TC_License_09(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 8, description = "Check navigation icon FullAccess on TOC.",
            dataProvider = "getSCFullAccessDataHashTable10", dataProviderClass = DataProviderSCFullAccess.class)
    public void TC_License_10(Hashtable<String, String> data) {
//        1. Continue TC_License_09.
//        2. Need a valid Account teacher to do login.
        fullAccessPageSC.TC_License_10(data);
    }


//    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
//    @Test(priority = 6, description = "Check filters in CPR",
//        dataProvider = "getSCFAReportDataHashTable01", dataProviderClass = DataProviderSCFullAccess.class)
//    public void TC_SC_FA_REPORT_01(Hashtable<String, String> data) {
//        fullAccessPageSC.TC_SC_FA_REPORT_01(data);
//    }
//
//    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
//    @Test(priority = 7, description = "Verify components of table, Student, Recommend Resource and Foundational Skill link",
//        dataProvider = "getSCFAReportDataHashTable02", dataProviderClass = DataProviderSCFullAccess.class)
//    public void TC_SC_FA_REPORT_02(Hashtable<String, String> data) {
//        fullAccessPageSC.TC_SC_FA_REPORT_02(data);
//    }
//
//    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
//    @Test(priority = 8, description = "Verify Chart Test Score and click Recommend Resource Link at popup",
//        dataProvider = "getSCFAReportDataHashTable03", dataProviderClass = DataProviderSCFullAccess.class)
//    public void TC_SC_FA_REPORT_03(Hashtable<String, String> data) {
//        fullAccessPageSC.TC_SC_FA_REPORT_03(data);
//    }
//
//    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
//    @Test(priority = 9, description = "Verify Chart Test Score and click Recommend Resource Link at popup",
//        dataProvider = "getSCFAReportDataHashTable04", dataProviderClass = DataProviderSCFullAccess.class)
//    public void TC_SC_FA_REPORT_04(Hashtable<String, String> data) {
//        fullAccessPageSC.TC_SC_FA_REPORT_04(data);
//    }
}
