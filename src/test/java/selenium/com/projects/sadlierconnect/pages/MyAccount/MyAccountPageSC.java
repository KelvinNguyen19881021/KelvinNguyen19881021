package selenium.com.projects.sadlierconnect.pages.MyAccount;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.MyAccountModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;


import java.util.Hashtable;

public class MyAccountPageSC extends CommonPageSC {

    public MyAccountPageSC() {
        super();
    }


    private  final By labelMyAccount = By.xpath("//a[normalize-space()='My Account']");
    private  final By inputFirstName = By.xpath("//input[@name='firstName']");
    private  final By inputMiddleName = By.xpath("//input[@name='middleName']");
    private  final By inputLastName = By.xpath("//input[@name='lastName']");
    private  final By inputEmail = By.xpath("//input[@name='email']");
    private  final By inputUserName = By.xpath("//input[@name='userName']");
    private  final By inputPassword = By.xpath("//input[@name='password']");
    private  final By radioYesOpt = By.xpath("//input[@value='1']");
    private  final By radioNoOpt = By.xpath("//input[@value='0']");
    private  final SoftAssert softAssert = new SoftAssert();
    private  final By textYesOpt = By.xpath("//p[contains(text(),'Yes, I want to opt out of receiving invitations an')]");
    private  final By textNoOpt = By.xpath("//p[contains(text(),'No, I want to continue receiving invitations and m')]");

    private  final By buttonSaveMyAccount = By.xpath("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    private  final By buttonCancelMyAccount = By.xpath("//button[@class='ant-btn ant-btn-secondary sc-gsnTZi fbVUE ml-5']");
    private  final By messageSuccess = By.xpath("//div[@class='ant-alert-message']");
    private  final By messageErrorFirstName = By.xpath("(//span[contains(text(),'This field is required.')])[1]");
    private  final By messageErrorLastName = By.xpath("(//span[contains(text(),'This field is required.')])[2]");
    private  final By messageErrorEmail = By.xpath("(//span[contains(text(),'This field is required.')])[3]");
    private  final By messageErrorUserName = By.xpath("(//span[contains(text(),'This field is required.')])[4]");
    private  final By messageErrorPassWord = By.xpath("(//span[contains(text(),'This field is required.')])[5]");
    private  final By messageErrorPassWordStudent = By.xpath("(//span[contains(text(),'This field is required.')])[4]");
    private  final By messageErrorFormatEmail = By.xpath("(//span[normalize-space()='Please enter a valid email address.'])[1]");
    private  final By messageErrorUsedEmail = By.xpath("//span[contains(.,'This email address is being used by another user.')]");
    private  final By messageErrorFormatUserName = By.xpath("(//span[normalize-space()='Value contains illegal characters.'])[1]");
    private  final By messageErrorUsedUserName = By.xpath("(//span[contains(text(),'This username')])[1]");

    public void openMyAccountPageSC() {
        WebUI.sleep(5);
        WebUI.clickElement(CommonPageSC.iconMyProfiles);
        WebUI.clickElement(labelMyAccount);
        WebUI.waitForPageLoaded();

    }
    //[CP]_Check data in field with account in Manage Teacher of Teacher role
    public void checkMyAccountDataDetailSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementAttributeValue(inputFirstName, "value",MyAccountData.get(MyAccountModel.getFirstName()));
        WebUI.verifyElementAttributeValue(inputMiddleName, "value",MyAccountData.get(MyAccountModel.getMiddleName()));
        WebUI.verifyElementAttributeValue(inputLastName, "value",MyAccountData.get(MyAccountModel.getLastName()));
        WebUI.verifyElementAttributeValue(inputEmail, "value",MyAccountData.get(MyAccountModel.getEmail()));
        WebUI.verifyElementAttributeValue(inputUserName, "value",MyAccountData.get(MyAccountModel.getUserName()));
        WebUI.verifyElementAttributeValue(inputPassword, "value",MyAccountData.get(MyAccountModel.getPassWord()));
        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.sleep(3);

        if(MyAccountData.get(MyAccountModel.getOpt()).equals("Yes")) {
            WebUI.verifyElementChecked(radioYesOpt);
        }
        else if(MyAccountData.get(MyAccountModel.getOpt()).equals("No")) {
            WebUI.verifyElementChecked(radioNoOpt);
        }

    }
    //[CP]_Check data in field with account in Manage Student of student role
    public void checkMyAccountDataDetailStudentSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementAttributeValue(inputFirstName, "value",MyAccountData.get(MyAccountModel.getFirstName()));
        WebUI.verifyElementAttributeValue(inputMiddleName, "value",MyAccountData.get(MyAccountModel.getMiddleName()));
        WebUI.verifyElementAttributeValue(inputLastName, "value",MyAccountData.get(MyAccountModel.getLastName()));

        WebUI.verifyElementAttributeValue(inputUserName, "value",MyAccountData.get(MyAccountModel.getUserName()));
        WebUI.verifyElementAttributeValue(inputPassword, "value",MyAccountData.get(MyAccountModel.getPassWord()));
        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.sleep(3);

    }

    public void updateMyAccountDataSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputFirstName);
        WebUI.setText(inputFirstName, MyAccountData.get(MyAccountModel.getFirstName()));

        WebUI.clearTextCtrlA(inputMiddleName);
        WebUI.setText(inputMiddleName,MyAccountData.get(MyAccountModel.getMiddleName()));

        WebUI.clearTextCtrlA(inputLastName);
        WebUI.setText(inputLastName, MyAccountData.get(MyAccountModel.getLastName()));

        WebUI.clearTextCtrlA(inputEmail);
        WebUI.setText(inputEmail, MyAccountData.get(MyAccountModel.getEmail()));

        WebUI.clearTextCtrlA(inputUserName);
        WebUI.setText(inputUserName, MyAccountData.get(MyAccountModel.getUserName()));

        WebUI.clearTextCtrlA(inputPassword);
        WebUI.setText(inputPassword, MyAccountData.get(MyAccountModel.getPassWord()));
        if(WebUI.verifyElementPresent(buttonSaveMyAccount,10))
        {
            WebUI.scrollToElementToBottom(buttonSaveMyAccount);
            WebUI.sleep(5);
        }

        if(MyAccountData.get(MyAccountModel.getOpt()).equals("Yes")) {
            WebUI.clickElement(textYesOpt);
        }
        else if(MyAccountData.get(MyAccountModel.getOpt()).equals("No")) {
            WebUI.clickElement(textNoOpt);
        }
        WebUI.clickElement(buttonSaveMyAccount);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);


    }
    public void updateDefaultMyAccountDataSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputUserName);
        WebUI.setText(inputUserName, MyAccountData.get(MyAccountModel.getDefaultUserName()));

        WebUI.clearTextCtrlA(inputPassword);
        WebUI.setText(inputPassword, MyAccountData.get(MyAccountModel.getDefaultPassWord()));

        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSaveMyAccount);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);


    }
    public void updateMyAccountDataStudentSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputFirstName);
        WebUI.setText(inputFirstName, MyAccountData.get(MyAccountModel.getFirstName()));

        WebUI.clearTextCtrlA(inputMiddleName);
        WebUI.setText(inputMiddleName,MyAccountData.get(MyAccountModel.getMiddleName()));

        WebUI.clearTextCtrlA(inputLastName);
        WebUI.setText(inputLastName, MyAccountData.get(MyAccountModel.getLastName()));

        WebUI.clearTextCtrlA(inputUserName);
        WebUI.setText(inputUserName, MyAccountData.get(MyAccountModel.getUserName()));

        WebUI.clearTextCtrlA(inputPassword);
        WebUI.setText(inputPassword, MyAccountData.get(MyAccountModel.getPassWord()));

        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.clickElement(buttonSaveMyAccount);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);


    }
    public void cancelMyAccountDataSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputFirstName);
        WebUI.setText(inputFirstName, MyAccountData.get(MyAccountModel.getFirstName()));

        WebUI.clearTextCtrlA(inputMiddleName);
        WebUI.setText(inputMiddleName,MyAccountData.get(MyAccountModel.getMiddleName()));

        WebUI.clearTextCtrlA(inputLastName);
        WebUI.setText(inputLastName, MyAccountData.get(MyAccountModel.getLastName()));

        WebUI.clearTextCtrlA(inputEmail);
        WebUI.setText(inputEmail, MyAccountData.get(MyAccountModel.getEmail()));

        WebUI.clearTextCtrlA(inputUserName);
        WebUI.setText(inputUserName, MyAccountData.get(MyAccountModel.getUserName()));

        WebUI.clearTextCtrlA(inputPassword);
        WebUI.setText(inputPassword, MyAccountData.get(MyAccountModel.getPassWord()));

        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.sleep(5);
        if(MyAccountData.get(MyAccountModel.getOpt()).equals(FrameworkConstants.YES_OPTION)) {
            WebUI.clickElement(textYesOpt);
        }
        else if(MyAccountData.get(MyAccountModel.getOpt()).equals(FrameworkConstants.NO_OPTION)) {
            WebUI.clickElement(textNoOpt);
        }
        WebUI.clickElement(buttonCancelMyAccount,5);

    }
    public void cancelMyAccountDataStudentSC(Hashtable<String, String> MyAccountData) {
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputFirstName);
        WebUI.setText(inputFirstName, MyAccountData.get(MyAccountModel.getFirstName()));

        WebUI.clearTextCtrlA(inputMiddleName);
        WebUI.setText(inputMiddleName,MyAccountData.get(MyAccountModel.getMiddleName()));

        WebUI.clearTextCtrlA(inputLastName);
        WebUI.setText(inputLastName, MyAccountData.get(MyAccountModel.getLastName()));

        WebUI.clearTextCtrlA(inputUserName);
        WebUI.setText(inputUserName, MyAccountData.get(MyAccountModel.getUserName()));

        WebUI.clearTextCtrlA(inputPassword);
        WebUI.setText(inputPassword, MyAccountData.get(MyAccountModel.getPassWord()));

        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.clickElement(buttonCancelMyAccount);

    }
    //[CP]_Display message " Your account information has been updated successfully"
    public void verifySuccessMessageSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(messageSuccess);
        WebUI.verifyElementText(messageSuccess,MyAccountData.get(MyAccountModel.getMessageSuccess()));

    }
    //[CP]_Back to Dashboard Page.
    public void verifyCancelMyAccountSC(Hashtable<String, String> MyAccountData) {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementExists(DashboardPageSC.labelAssignment);

    }
    //[CP]_"Yes" checkbox is checked or not checked
    public void verifyChangeOptMyAccountSC(Hashtable<String, String> MyAccountData) {
        WebUI.waitForPageLoaded();
        WebUI.scrollToElementToBottom(buttonSaveMyAccount);
        WebUI.sleep(3);

        if(MyAccountData.get(MyAccountModel.getOpt()).equals(FrameworkConstants.YES_OPTION)) {
            WebUI.verifyElementChecked(radioNoOpt);
        }
        else if(MyAccountData.get(MyAccountModel.getOpt()).equals(FrameworkConstants.NO_OPTION)) {
            WebUI.verifyElementChecked(radioNoOpt);
        }

    }
    //[CP]_Display message " This field is required"  under First Name, Last Name, Email, UserName, Password.
    public void verifyNotFillAllFieldMyAccountSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(inputFirstName);
        //WebUI.verifyElementText(messageErrorFirstName,"This field is required.");
        WebUI.verifyElementText(messageErrorFirstName,MyAccountData.get(MyAccountModel.getErrorMessage()));
       // WebUI.verifyElementText(messageErrorLastName,"This field is required.");
        WebUI.verifyElementText(messageErrorLastName,MyAccountData.get(MyAccountModel.getErrorMessage()));

        WebUI.verifyElementText(messageErrorEmail,MyAccountData.get(MyAccountModel.getErrorMessage()));

        WebUI.verifyElementText(messageErrorUserName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        WebUI.verifyElementText(messageErrorPassWord,MyAccountData.get(MyAccountModel.getErrorMessage()));

    }
    //[CP]_Display message " This field is required"  under First Name, Last Name, Email, UserName, Password.
    public void verifyNotFillAllFieldMyAccountStudentSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(inputFirstName);
        WebUI.verifyElementText(messageErrorFirstName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        WebUI.verifyElementText(messageErrorLastName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        WebUI.verifyElementText(messageErrorUserName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        WebUI.verifyElementText(messageErrorPassWordStudent,MyAccountData.get(MyAccountModel.getErrorMessage()));
    }
    //[CP]_Display message " Please enter a Valid email address" under email
    //[CP]_Display message " This email address is being used by another user. Please try again.
    public void verifyMessageEmailMyAccountSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(inputFirstName);
        if (MyAccountData.get(MyAccountModel.getErrorMessage()).equals(FrameworkConstants.FORMAT_EMAIL))
            WebUI.verifyElementText(messageErrorFormatEmail,MyAccountData.get(MyAccountModel.getErrorMessage()));
        else if(MyAccountData.get(MyAccountModel.getErrorMessage()).contains(FrameworkConstants.USED_EMAIL)){
            WebUI.verifyElementTextContains(messageErrorUsedEmail,FrameworkConstants.COMPARE_USED_EMAIL );
        }

    }
    //[CP]_Display message " Value contains illegal characters" under UserName
    //[CP]_Display message " This username is being used by another user. Please try again." under UserName
    public void verifyMessageUserNameMyAccountSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(inputFirstName);
        if (MyAccountData.get(MyAccountModel.getErrorMessage()).equals(FrameworkConstants.FORMAT_USER_NAME))
            WebUI.verifyElementText(messageErrorFormatUserName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        else if(MyAccountData.get(MyAccountModel.getErrorMessage()).equals(FrameworkConstants.USED_USER_NAME)){
            WebUI.verifyElementTextContains(messageErrorUsedUserName,FrameworkConstants.COMPARE_USED_USER_NAME );
        }

    }
    //[CP]_Display message " Value contains illegal characters" under UserName
    //[CP]_Display message " This username is being used by another user. Please try again." under UserName
    public void verifyMessageUserNameMyAccountStudentSC(Hashtable<String, String> MyAccountData) {
        WebUI.scrollToElementToTop(inputFirstName);
        if (MyAccountData.get(MyAccountModel.getErrorMessage()).equals(FrameworkConstants.FORMAT_USER_NAME))
            WebUI.verifyElementText(messageErrorFormatUserName,MyAccountData.get(MyAccountModel.getErrorMessage()));
        else if(MyAccountData.get(MyAccountModel.getErrorMessage()).equals(FrameworkConstants.USED_USER_NAME)){
            WebUI.verifyElementTextContains(messageErrorUsedUserName,FrameworkConstants.COMPARE_USED_USER_NAME);
        }

    }

}
