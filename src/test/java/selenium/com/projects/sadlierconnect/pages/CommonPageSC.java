package selenium.com.projects.sadlierconnect.pages;

import org.openqa.selenium.By;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyPrivacy.MyPrivacyPageSC;
import selenium.com.projects.sadlierconnect.pages.LessonPlanner.LessonPlannerPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageClasses.ManageClassesPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageParents.ManageParentsPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;
import selenium.com.projects.sadlierconnect.pages.Message.MessagePageSC;
import selenium.com.projects.sadlierconnect.pages.Helps.HelpCenter;
import selenium.com.projects.sadlierconnect.pages.Helps.GettingStarted;
import selenium.com.projects.sadlierconnect.pages.Profiles.RegisterProductPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.LogoutPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.AccountSettingPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.ProductPrefencesPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.MyAccountPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageDistricts.ManageDistrictPageSC;
import selenium.com.projects.sadlierconnect.pages.StudentTrackingReportSC.StudentTrackingReportPageSC;
import selenium.com.projects.sadlierconnect.pages.TermConditions.TermConditionsPageSC;

public class CommonPageSC {

    public LoginPageSC loginInPage;
    public DashboardPageSC dashboardPage;
    public ManageStudentsPageSC manageStudentsPage;
    public LessonPlannerPageSC lessonPlannerPage;
    public StudentTrackingReportPageSC reportPage;
    public ManageClassesPageSC manageClassPage;
    public ManageParentsPageSC manageParentsPage;
    public MyLibraryPageSC myLibraryPage;
    public MessagePageSC messagePage;
    public HelpCenter helpCenter;
    public GettingStarted gettingStarted;
    public RegisterProductPageSC registerProductPage;
    public LogoutPageSC logoutPage;
    public AccountSettingPageSC accountSettingPage;
    public ProductPrefencesPageSC ProductPreferencePage;
    public MyAccountPageSC myAccountPage;
    public MyPrivacyPageSC myPrivacyPageSC;
    public ManageDistrictPageSC manageDistrictPage;
    public TermConditionsPageSC termConditionsPage;

    public static By iconProfiles = By.xpath("//span[@class='user-avatar']");
    public static final By buttonSignOut = By.xpath("//a[normalize-space()='Logout']");
    public static By iconHelp = By.xpath("(//*[name()='svg'])[5]");
    public static By dropdownHelpCenter = By.xpath("//a[@id='help-center']");
    public static By dropdownGettingStarted = By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']//li[3]//span[1]//a[1]");
    public static final By buttonBack = By.xpath("//span[normalize-space()='Back']");
    public static final By iconMyProfiles = By.xpath("//span[@class='user-avatar']");
    public static final By iconSetting = By.xpath("(//*[name()='svg'])[2]");
    public static final By iconManageSchool = By.xpath("//a[normalize-space()='Manage Schools']");

    public static final By iconManagement = By.xpath("(//*[name()='svg'])[2]");
    public static final By labelManageClass = By.xpath("//a[normalize-space()='Manage Classes']");
    public static final By inputSearch = By.xpath("//input[@placeholder='Search All Products']");
    public static final By menuDashBoard = By.xpath("//a[normalize-space()='Dashboard']");
    public static final By menuLibrary = By.xpath("//span[normalize-space()='My Library']");
    public static final By menuAssignment = By.xpath("//span[@class='badge-group']");
    public static final By menuLessonPlanner = By.xpath("//a[normalize-space()='Lesson Planner']");
    public static final By menuReport = By.xpath("//span[normalize-space()='Reports']");


    public static void logOutPage() {
        WebUI.clickElement(iconProfiles);
        WebUI.clickElement(buttonSignOut);

    }

    public MyPrivacyPageSC myPrivacyPageSC() {
        if (myPrivacyPageSC == null) {
            myPrivacyPageSC = new MyPrivacyPageSC();
        }
        return myPrivacyPageSC;
    }

    public HelpCenter helpCenterPage() {
        WebUI.clickElement(iconHelp);
        WebUI.clickElement(dropdownHelpCenter);
        return new HelpCenter();
    }

    public GettingStarted gettingStartedPage() {
        WebUI.clickElement(iconHelp);
        WebUI.clickElement(dropdownGettingStarted);
        return new GettingStarted();
    }

    public DashboardPageSC getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPageSC();
        }
        return dashboardPage;
    }

    public ManageStudentsPageSC getManageStudentPage() {
        if (manageStudentsPage == null) {
            manageStudentsPage = new ManageStudentsPageSC();
        }
        return manageStudentsPage;
    }

//    public AssignmentListPageSC getAssignmentsPage() {
//        if (assignmentsPage == null) {
//            assignmentsPage = new AssignmentListPageSC();
//        }
//        return assignmentsPage;
//    }

    public LessonPlannerPageSC getLessonPlannerPage() {
        if (lessonPlannerPage == null) {
            lessonPlannerPage = new LessonPlannerPageSC();
        }
        return lessonPlannerPage;
    }

    public StudentTrackingReportPageSC getReportPage() {
        if (reportPage == null) {
            reportPage = new StudentTrackingReportPageSC();
        }
        return reportPage;
    }

    public ManageClassesPageSC  getManageClass() {
        if (manageClassPage == null) {
            manageClassPage = new ManageClassesPageSC();
        }
        return manageClassPage;
    }

    public ManageParentsPageSC  getManageParents() {
        if (manageParentsPage == null) {
            manageParentsPage = new ManageParentsPageSC();
        }
        return manageParentsPage;
    }

    public MyLibraryPageSC  getMyLibraryPage() {
        if (myLibraryPage == null) {
            myLibraryPage = new MyLibraryPageSC();
        }
        return myLibraryPage;
    }

    public MessagePageSC  getMessagePage() {
        if (messagePage == null) {
            messagePage = new MessagePageSC();
        }
        return messagePage;
    }

    public HelpCenter  getHelpCenter() {
        if (helpCenter == null) {
            helpCenter = new HelpCenter();
        }
        return helpCenter;
    }

    public RegisterProductPageSC  getRegisterProductPage() {
        if (registerProductPage == null) {
            registerProductPage = new RegisterProductPageSC();
        }
        return registerProductPage;
    }

    public LogoutPageSC  getLogoutPage() {
        if (logoutPage == null) {
            logoutPage = new LogoutPageSC();
        }
        return logoutPage;
    }

    public AccountSettingPageSC  getAccountSettingPage() {
        if (accountSettingPage == null) {
            accountSettingPage = new AccountSettingPageSC();
        }
        return accountSettingPage;
    }

    public ProductPrefencesPageSC  getProductPreferencePage() {
        if (ProductPreferencePage == null) {
            ProductPreferencePage = new ProductPrefencesPageSC();
        }
        return ProductPreferencePage;
    }

    public MyAccountPageSC  getMyAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPageSC();
        }
        return myAccountPage;
    }

    public GettingStarted  gettingStarted() {
        if (gettingStarted == null) {
            gettingStarted = new GettingStarted();
        }
        return gettingStarted;
    }

    public ManageDistrictPageSC getManageDistrictPage() {
        if (manageDistrictPage == null) {
            manageDistrictPage = new ManageDistrictPageSC();
        }
        return manageDistrictPage;
    }

    public TermConditionsPageSC getTermConditionsPage() {
        if (termConditionsPage== null) {
            termConditionsPage = new TermConditionsPageSC();
        }
        return termConditionsPage;
    }




}
