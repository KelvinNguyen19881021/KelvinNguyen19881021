package selenium.com.projects.sadlierconnect.pages.TermConditions;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageDistricts.ManageDistrictPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;

import java.util.Hashtable;

public class TermConditionsPageSC extends CommonPageSC {

    public TermConditionsPageSC() {
        super();
    }

     public static final By labelTermConditions = By.xpath("//a[normalize-space()='Terms & Conditions']");
     public static final By titleTermConditions = By.xpath("//h1[normalize-space()='Terms and Conditions']");
     public static final By backButton = By.xpath("//span[normalize-space()='Back']");


    public static final By linkPrivacyPolicy = By.xpath("//a[normalize-space()='http://www.sadlierconnect.com/privacypolicy.html']");
    public String url_TC_TERM_CONDITION_09_SC = "/privacypolicy.html";
    public String url_TC_TERM_CONDITION_11_SC = "/dashboard";



    private static SoftAssert softAssert = new SoftAssert();


    public void openTermConditions() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(labelTermConditions);
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(labelTermConditions, 10))
        {
            WebUI.clickElement(labelTermConditions);
        }
        WebUI.waitForPageLoaded();

    }
    //[CP8]_Access to Terms and Conditions Page
    public void verifyTermConditionsPageIsOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.verifyElementText(titleTermConditions,"Terms and Conditions");
    }

    //[CP9]_Check Click link "http://www.sadlierconnect.com/privacypolicy.html." is opened Successfully
    public void verifyLinkPrivacyPolicyOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.scrollToElementToBottom(labelTermConditions);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(linkPrivacyPolicy);
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(linkPrivacyPolicy, 10))
        {
            WebUI.scrollToElementToBottom(linkPrivacyPolicy);
        }
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(linkPrivacyPolicy, 10))
        {
            WebUI.clickElement(linkPrivacyPolicy);
        }
        WebUI.verifyContains(WebUI.getCurrentUrl(),url_TC_TERM_CONDITION_09_SC);
    }

    //[CP11]_Check Click "Back" button to navigate Dashboard page
    public void verifyTermsandconditionBackDashboard() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(backButton);
        WebUI.verifyContains(WebUI.getCurrentUrl(),url_TC_TERM_CONDITION_11_SC);
    }



    /*
       [CP]_Role Teacher: Navigate to My Dashboard
       [CP]_Role Student: Navigate to My Dashboard
     */
    public void checkUserClickBackButton(Hashtable<String, String> data) {
        switch (data.get(LoginModel.getUserRole())) {
            case "Teacher":
            case "Student":
            case "Parent":
                WebUI.clickElement(buttonBack);
                WebUI.verifyContains(WebUI.getCurrentUrl(),DashboardPageSC.pageUrl);
                break;
            case "School Admin":
                WebUI.clickElement(buttonBack);
                WebUI.verifyContains(WebUI.getCurrentUrl(),MyLibraryPageSC.pageUrl);
                //WebUI.verifyElementText(MyLibraryPageSC.menuMyLibrary,"My Library");
                break;
            case "System Admin":
                WebUI.clickElement(buttonBack);
                WebUI.verifyContains(WebUI.getCurrentUrl(),ManageDistrictPageSC.pageUrl);
                //WebUI.verifyElementText(ManageDistrictPageSC.labelManageDistrict,"Manage Districts");
                break;
            default:
                softAssert.fail("Not a valid user role");

        }

    }

}
