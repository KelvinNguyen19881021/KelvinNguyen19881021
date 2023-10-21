package selenium.com.projects.sadlierconnect.pages.Login;

import org.openqa.selenium.By;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;

import java.util.Hashtable;

public class LoginPageSC extends CommonPageSC {

    private final String pageTitle = "Sadlier Connect™ - Log In";
    private final String pageSystemAdminTitle = "Sadlier Connect";

    private final By inputPassCode = By.xpath("//input[@id='passcode']");
    private final By inputPassWord = By.xpath("//input[@id='password']");
    private final By inputUserName = By.xpath("//input[@id='username']");
    private final By buttonLogin = By.xpath("//button[@type='button']");
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    private final By buttonLoginX = By.xpath("//span[normalize-space()='Log In']");
    private final DashboardPageSC dashboardPageSC;



    public LoginPageSC() {
        this.dashboardPageSC =  new DashboardPageSC();

    }


    public void loginUsers (Hashtable<String, String> data) {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode,  data.get(LoginModel.getPassCode()));
        WebUI.setText(inputUserName, data.get(LoginModel.getUserName()));
        WebUI.setText(inputPassWord, data.get(LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }
    public void loginUsersWithoutPassCode (Hashtable<String, String> data) {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, data.get(LoginModel.getUserName()));
        WebUI.setText(inputPassWord, data.get(LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }


    public void logInWithTeacherRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(2, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(2, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(2, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }
    public void logInWithTeacherRoleAssignmentJourney() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "LoginAssignment");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(2, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(2, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(2, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

    public void logInWithTeacherRoleWithNoReport() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginNo_Report");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_NO_REPORT);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }

    public void logInWithTeacherRoleWithReport() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginReport");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_REPORT);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);


    }
    public void logInWithTeacherFARole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginFA");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_FA);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

    public void logInWithTeacherRoleWithoutPassCode() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, excelHelpers.getCellData(2, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(2, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithStudentRoleWithoutPassCode() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithStudentRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode,  excelHelpers.getCellData(1,LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithAdminRoleWithoutPassCode() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, excelHelpers.getCellData(4, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(4, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }
    public void logInWithAdminRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode,  excelHelpers.getCellData(4,LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(4, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(4, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithSchoolAdminRoleWithoutPassCode() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, excelHelpers.getCellData(4, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(4, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void loginAdministrator (Hashtable<String, String> data) {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_ADMIN);
        // WebUI.verifyEquals(WebUI.getPageTitle(), pageSystemAdminTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode,  data.get(LoginModel.getPassCode()));
        WebUI.setText(inputUserName, data.get(LoginModel.getUserName()));
        WebUI.setText(inputPassWord, data.get(LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void loginAdministratorWithoutPassCode (Hashtable<String, String> data) {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_ADMIN);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageSystemAdminTitle, "The title of sign in page not match.");
        WebUI.setText(inputUserName, data.get(LoginModel.getUserName()));
        WebUI.setText(inputPassWord, data.get(LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithSystemAdminRoleWithoutPassCode() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_ADMIN );
        WebUI.setText(inputUserName, excelHelpers.getCellData(5, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(5, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

    public void logInWithSystemAdminRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_ADMIN );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(5, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(5, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(5, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }


    public void logInWithTeacherManageParent() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(6, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(6, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(6, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }
    public void logInWithTeacherRoleFullAccess() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginFA");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_FA);
        WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        //return new DashboardPageSC();
    }

    public void logInWithStudentMessage() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(8, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(8, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(8, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }
    public void logInWithTeacherMessageRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(7, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(7, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(7, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }
    public void logInWithTeacherMessageTestRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        //WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
        WebUI.setText(inputPassCode, excelHelpers.getCellData(10, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(10, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(10, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

    public void logInWithTeacherActivityReport() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_REPORT);
        WebUI.setText(inputPassCode, excelHelpers.getCellData(9, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(9, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(9, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }

    public void logInWithStudentforDeleteMessage() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
        WebUI.setText(inputPassCode, excelHelpers.getCellData(10, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(10, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(10, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }


    public void logInWithTeacherRoleTestReport() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_REPORT );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(2, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(2, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(2, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

    public void logInWithTeacherRoleTestNoReport() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginReport");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER_NO_REPORT );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }
    public void logInWithTeacherRoleAssignmentFilterSetting() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Assignment_Filter_Setting");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_FILTER_SETTING );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(1, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(1, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(1, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }
    public void logInWithAdminSchoolRoleAssignmentFilterSetting() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Assignment_Filter_Setting");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_FILTER_SETTING );
        WebUI.setText(inputPassCode, excelHelpers.getCellData(2, LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(2, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(2, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();

    }

}
