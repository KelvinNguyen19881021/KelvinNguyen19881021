package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.enums.AuthorType;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCLogin;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.util.Hashtable;


public class LoginTest extends BaseTest{

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;

    public LoginTest() {
        loginPageSC = new LoginPageSC();
        dashboardPageSC= new DashboardPageSC();
    }

    //Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "TC01_LogInTestDataProvider", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void logInTestDataProvider(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.loginUsers(data);
        WebUI.sleep(5);
        WebUI.verifyElementPresent(DashboardPageSC.menuDashboard, 5, "The menu Dashboard does not exist.");
    }



}
