package selenium.com.projects.sadlierconnect.pages.Dashboard;

import org.openqa.selenium.By;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;
import selenium.com.projects.sadlierconnect.pages.LessonPlanner.LessonPlannerPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageClasses.ManageClassesPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageParents.ManageParentsPageSC;
import selenium.com.projects.sadlierconnect.pages.Message.MessagePageSC;
import selenium.com.projects.sadlierconnect.pages.MyPrivacy.MyPrivacyPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.AccountSettingPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.MyAccountPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.ProductPrefencesPageSC;
import selenium.com.projects.sadlierconnect.pages.Profiles.RegisterProductPageSC;
import selenium.com.projects.sadlierconnect.pages.Report.ActivityReportPageSC;
import selenium.com.projects.sadlierconnect.pages.StudentTrackingReportSC.StudentTrackingReportPageSC;


public class DashboardPageSC extends CommonPageSC {

    public DashboardPageSC() {
        super();
    }

    public  final String pageText = "Dashboard";
    public static final String pageUrl = "/dashboard";

    public  final By labelMyPrivacy = By.xpath("//a[normalize-space()='Privacy Policy']");
    public  static final By menuDashboard = By.xpath("//a[normalize-space()='Dashboard']");
    public  final By menuMyLibrary = By.xpath("//span[normalize-space()='My Library']");
    public  final By menuLessonPlanner = By.xpath("//a[normalize-space()='Lesson Planner']");
    public  final By menuAssignments = By.xpath("//span[@class='badge-group']");
    public  final By menuReports = By.xpath("//span[normalize-space()='Reports']");
    public  final By menuManageSettings = By.xpath("(//span[@class='dropdown-icon'])[1]");
    public  final By manageStudents = By.xpath("//a[normalize-space()='Manage Students']");
    public  final By manageClasses = By.xpath("//a[normalize-space()='Manage Classes']");
    public  final By manageParents = By.xpath("//a[normalize-space()='Manage Parents']");
    public  final By manageMessage =  By.xpath("//a[@class='ant-dropdown-trigger ant-dropdown-link']//*[name()='svg']");
    public  final By menuProfile = By.xpath("(//span[@class='user-avatar']");
    public  final By manageMyAccount = By.xpath("//a[normalize-space()='My Account']");
    public  final By registerProduct = By.xpath("//a[normalize-space()='Register a Product']");
    public  final By productReferences = By.xpath("//a[normalize-space()='Product Preferences']");
    public  final By accountSetting = By.xpath("//a[normalize-space()='Account Setting']");

    public final By iconSearchProducts = By.xpath("//input[@placeholder='Search All Products']");

    public final By rightArrowButtonLessonPlanner = By.xpath("//a[@href='/lesson-planner']//*[name()='svg']//*[name()='circle' and contains(@cx,'10')]");
    public final By rightArrowButtonMyLibrary = By.xpath("//a[@href='/library']//*[name()='svg']//*[name()='circle' and contains(@cx,'10')]");
    public final By dropDownListAllClasses = By.xpath("//span[@class='dropdown-label'][normalize-space()='All Classes']");
    public final By iconAddPlanLessonPlanner = By.xpath("//*[name()='circle' and contains(@cx,'19')]");

    public final By dropDownSortByMyLibrary = By.xpath("//div[@class='filter-group filter-dashboard']//div[@class='sc-arrow sc-arrow-down']");
    public final By optionSubject = By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Subject')]");
    public final By optionLastUsed = By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Last Used')]");
    public final By optionFavorite = By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Favorite')]");

    public final By dropDownStudent = By.xpath("//div[contains(@class,'input-filter')]//div[contains(@class,'sc-arrow sc-arrow-down')]");
    public final By optionStudent = By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Student')]");
    public final By optionClass = By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Class')]");

    public final By tabMissedAssignments = By.xpath("//div[@id='rc-tabs-7-tab-1']");
    public final By tabClassAlerts = By.xpath("//div[@id='rc-tabs-7-tab-2']");
    public final By tabStudentAlerts = By.xpath("//div[@id='rc-tabs-7-tab-3']");

    public static final By labelAssignment = By.xpath("//div[@class='sc-iBkjds bHVNtc'][normalize-space()='Assignments']");

    public final By rightArrowButtonAssignments = By.xpath("//a[@href='/assignments']//*[name()='svg']//*[name()='circle' and contains(@cx,'10')]");
    public final By tabCurrentAssignment = By.xpath("(//div[@id='rc-tabs-10-tab-1'])[1]");
    public final By tabReadyToGradeAssignment = By.xpath("(//div[@id='rc-tabs-10-tab-2'])[1]");

    public final By navigateToSites = By.xpath("(//img[@class='cursor-pointer'])[1]");
    private final By menuActivityReport = By.xpath("//a[@href='/report/activity-report']");

    public DashboardPageSC openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }

    public MyLibraryPageSC openMyLibraryPage() {
        WebUI.clickElement(menuMyLibrary);
        return new MyLibraryPageSC();
    }


    public LessonPlannerPageSC openLessonPlannerPage() {
        WebUI.clickElement(menuLessonPlanner);
        return new LessonPlannerPageSC();
    }

    public StudentTrackingReportPageSC openReportPageSC() {
        WebUI.clickElement(menuReports);
        return new StudentTrackingReportPageSC();
    }

//    public AssignmentListPageSC openAssignmentPage() {
//        WebUI.clickElement(menuAssignments);
//        return new AssignmentListPageSC();
//    }

    public ManageStudentsPageSC openManageStudentPage() {
        WebUI.clickElement(menuManageSettings);
        WebUI.clickElement(manageStudents);
        return new ManageStudentsPageSC();
    }

    public ManageClassesPageSC openManageClassesPage() {
        WebUI.clickElement(menuManageSettings);
        WebUI.clickElement(manageClasses);
        return new ManageClassesPageSC();
    }


    public ManageParentsPageSC openManageParentsPage() {
        WebUI.clickElement(menuManageSettings);
        WebUI.clickElement(manageParents);
        return new ManageParentsPageSC();
    }

    public MessagePageSC openManageMessage() {
        WebUI.clickElement(manageMessage);
        return new MessagePageSC();
    }

    public MyAccountPageSC openMyAccountPage() {
        WebUI.clickElement(menuProfile);
        WebUI.clickElement(manageMyAccount);
        return new MyAccountPageSC();
    }

    public AccountSettingPageSC openAccountSetting() {
        WebUI.clickElement(menuProfile);
        WebUI.clickElement(accountSetting);
        return new AccountSettingPageSC();
    }

    public RegisterProductPageSC openRegisterProduct() {
        WebUI.clickElement(menuProfile);
        WebUI.clickElement(registerProduct);
        return new RegisterProductPageSC();
    }

    public ProductPrefencesPageSC openProductPreferences() {
        WebUI.clickElement(menuProfile);
        WebUI.clickElement(productReferences);
        return new ProductPrefencesPageSC();
    }

    public MyPrivacyPageSC openMyPrivacy() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
        WebUI.scrollToElementToBottom(labelMyPrivacy);
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(labelMyPrivacy, 10))
        {
            WebUI.clickElement(labelMyPrivacy);
        }


        return new MyPrivacyPageSC();
    }

    public ActivityReportPageSC openActivityReportPageSC() {
        WebUI.clickElement(menuReports);
        WebUI.clickElement(menuActivityReport);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        return new ActivityReportPageSC();
    }


}
