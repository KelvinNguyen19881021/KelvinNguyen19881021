package selenium.com.projects.sadlierconnect.pages.MyPrivacy;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageDistricts.ManageDistrictPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;
import selenium.com.projects.sadlierconnect.models.LoginModel;

import java.util.Hashtable;

public class MyPrivacyPageSC extends CommonPageSC {

    public MyPrivacyPageSC() {
        super();
    }


     public static final By titleMyPrivacy = By.xpath("//h1[normalize-space()='Privacy Policy']");
     public static final By buttonBack = By.xpath("//span[normalize-space()='Back']");
     public static final By LinkSadlierconnect = By.xpath("//a[normalize-space()='http://www.sadlierconnect.com']");

    public static final By LinkTermandCondition = By.xpath("//p[contains(text(),'An Administrator or a Teacher may register a Stude')]//a");

    public static final By checkLinkPartners  = By.xpath("//a[normalize-space()='https://www.google.com/policies/privacy/partners/']");

    public static final By checkLinkGaout  = By.xpath("//a[normalize-space()='https://tools.google.com/dlpage/gaoptout']");

    public static final By checkLinkTermsandCondition  = By.xpath("//a[normalize-space()='Terms & Conditions']");



    public String url_TC_PRIVACY_POLICY_02_SC = "/dashboard";
    public String url_TC_PRIVACY_POLICY_03_SC = "/termsandconditions.html";
    public String url_TC_PRIVACY_POLICY_04_SC = "https://policies.google.com/technologies/partner-sites";
    public String url_TC_PRIVACY_POLICY_05_SC = "https://tools.google.com/dlpage/gaoptout";
    public String url_TC_PRIVACY_POLICY_08_SC = "/termsandconditions.html";
    public String url_TC_PRIVACY_POLICY_07_SC = "/dashboard";


    private static SoftAssert softAssert = new SoftAssert();
    ///h1[@class='sc-caXVBt cXJcbY']
    //[CP]_Access to Privacy Policy Page
     public void verifyMyPrivacyPageIsOpened() {
         WebUI.sleep(5);
         WebUI.waitForPageLoaded();
         WebUI.sleep(5);
         WebUI.verifyElementText(titleMyPrivacy,"Privacy Policy");
     }
    //[CP2]_Check Click link "http://www.sadlierconnect.com" is opened Successfully
    public void verifyLinkSadlierConnectIsOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.scrollToElementToBottom(LinkSadlierconnect);
        WebUI.clickElement(LinkSadlierconnect);
        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_02_SC, "Move to Dashboard Page.");
    }

    //[CP3]_Check Click link "www.sadlierconnect.com/termsandconditions" is opened Successfully
    public void verifyLinkTermsandConditionIsOpened() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
        WebUI.scrollToElementToBottom(LinkTermandCondition);
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(LinkTermandCondition,5)) {
            WebUI.clickElement(LinkTermandCondition, 5);
        }

        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_03_SC, "Move to Terms and condition Page.");
    }

    //[CP4]_Check Click link " https://www.google.com/policies/privacy/partners/" is opened Successfully

    public void verifyLinkGooglePrivacyandTermIsOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.scrollToElementToBottom(checkLinkPartners);
        WebUI.sleep(10);
        if(WebUI.verifyElementPresent(checkLinkPartners, 10)) {
            WebUI.clickElement(checkLinkPartners);
        }
        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_04_SC, "Move to  Google Privacy and term page.");
    }

    //[CP5]_Check Click link "https://tools.google.com/dlpage/gaoptout."  is opened Successfully

    public void verifyLinkGoogleAnalyticsIsOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(checkLinkGaout);
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(checkLinkGaout, 10)) {
            WebUI.clickElement(checkLinkGaout);
        }
        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_05_SC, "Move to  Google Analytics Opt-out Browser Add-on page");
    }

    //[CP7]_Check Click "Back" button to nevigate Dashboard page

    public void verifyDashBoardIsOpened() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonBack);
        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_07_SC, "Move to Dashboard");
    }

    //[CP8]_Verify that the [Access Term and Conditions] page is opened

    public void checkBackTermsandCondition() {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(checkLinkTermsandCondition);;
        WebUI.clickElement(checkLinkTermsandCondition);
        WebUI.verifyContains(WebUI.getCurrentUrl(), url_TC_PRIVACY_POLICY_08_SC, "Move to Terms and Condition page");
    }








    //[CP]_Role Teacher: Navigate to My Dashboard
    //[CP]_Role Teacher: Navigate to My Dashboard
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
