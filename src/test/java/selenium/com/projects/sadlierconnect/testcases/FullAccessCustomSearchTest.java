package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccessSearch;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.FullAccess.FullAccessCustomSearchPage;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.util.Hashtable;

public class FullAccessCustomSearchTest extends BaseTest {
    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    FullAccessCustomSearchPage fullAccessCustomSearchPage;

    public FullAccessCustomSearchTest() {
        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        fullAccessCustomSearchPage = new FullAccessCustomSearchPage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 1, description = "Check keep dropdown Program/Standard Set", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH01(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkKeepDropdownProgram();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 2, description = "Check Enable Program filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH02(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkEnableDropdownProgram(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 3, description = "Check Enable Standard Set filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH03(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkEnableDropdownStandardSet(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 4, description = "Check Enable Grade & Domain filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH04(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkEnableDropdownGradeAndDomain(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 5, description = "Check Enable Standards filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH05(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkEnableDropdownStandards(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 6, description = "Check Domain filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH06(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkDomainFilter(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 7, description = "Check Standards filter", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH07(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkStandardsFilter(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 8, description = "Check Standards filter when remove Domain", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH08(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkStandardsFilterWhenRemoveDomain(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 9, description = "Check Domain filter when remove Grade", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH09(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkDomainFilterWhenRemoveGrade(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 10, description = "Check all filter when change Grade", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH10(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkAllFilterWhenChangeGrade(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 11, description = "Check all filter when change Program", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH11(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkAllFilterWhenChangeProgram(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 12, description = "Check search Valid Content with All Standard Set", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH12(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchValidContent(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 13, description = "Check search Valid Content with specific Standard Set and All options", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH13(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchValidContentWithStandardSet(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 14, description = "Check search Valid with specific options", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH14(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchValidContentWithSpecialOption(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 15, description = "Check search Specific Resource Type < Instruction>", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH15(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchSpecificResource(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 16, description = "Check search Specific Resource Type < Student Resource>", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH16(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchSpecificResourceStudent(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 17, description = "Check search Specific Resource Type <Teacher Resource>", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH17(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchSpecificResourceTeacher(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 18, description = "Check Enable Clear All button", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH18(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkEnableClearAll(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 19, description = "Check Clear All button", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH19(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkClearAllButton(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 20, description = "Search Invalid", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH20(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkSearchInValid(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 21, description = "Check view Resource", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH21(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkViewResource(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 22, description = "Check view resource Game", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH22(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkViewResourceGame(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 23, description = "Check view resource video", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH23(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkViewResourceVideo(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 24, description = "Check Back button", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH24(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkBackbutton(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 25, description = "Check FullAccess button", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH25(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkFullAccessbutton(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 26, description = "Check Warning Message when not select resource ", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH26(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkMessageWarning(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 27, description = "Check Create Assignment with 1 Resource ", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH27(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkCreateAssignment1Resource(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_FullAccess})
    @Test(priority = 28, description = "Check Create Assignment with multi Resource ", dataProvider = "getContentDataHashTable", dataProviderClass = DataProviderSCFullAccessSearch.class)
    public void TC_Search_TCH28(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherFARole();
        fullAccessCustomSearchPage.checkCreateAssignmentMultiResource(data);
    }
}
