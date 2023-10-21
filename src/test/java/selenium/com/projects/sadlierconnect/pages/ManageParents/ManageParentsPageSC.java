package selenium.com.projects.sadlierconnect.pages.ManageParents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;

import selenium.com.projects.sadlierconnect.models.ManageParentImportModel;
import selenium.com.projects.sadlierconnect.models.ManageParentModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class ManageParentsPageSC extends CommonPageSC {
    private static By dataWhenClickIndex(String xpathName, int index) {
        return convertStringToXpath("(//span[contains(text(),'" + xpathName + "')])[" + index + "]");
    }

    private static By dataContains(String xpathName) {
        return convertStringToXpath("(//span[contains(text(),'" + xpathName + "')])[1]");
    }


    private static By dropdownClick(int index) {
        return convertStringToXpath("(//div[@class='ant-select-selector'])[" + index + "]");
    }

    private static By dataDropdown(String name){
        return convertStringToXpath("(//span[normalize-space()='"+name+"'])[1]");
    }


    public static By inputSetName(String name) {
        return convertStringToXpath("(//input[@id='" + name + "'])[1]");
    }

    private static By convertStringToXpath(String name) {
        return By.xpath(name);
    }

    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    private static final ManageParentModel manageParentModel = new ManageParentModel();

    private static final ManageParentImportModel manageParentImportModel = new ManageParentImportModel();

    private final  By alertMessageSuccess = convertStringToXpath("(//div[@class='ant-alert-message'])[1]");
    private final  By alertMessageError = convertStringToXpath("(//div[@class='ant-alert-message'])[1]");
    private final  By alertRequire = convertStringToXpath("(//span[contains(text(),'This field is required.')])[1]");
    private final  By modalMessage = convertStringToXpath("(//div[@class='ant-modal-confirm-content'])[1]");

    private  final By clickDropDown  =  convertStringToXpath("(//span[@class='dropdown-label'])[1]");
    private  final By pageClick = convertStringToXpath("(//a[normalize-space()='Manage Parents'])[1]");
    //index dropdown
    private  final By dropdownClass = dropdownClick(1);
    private  final By inputSearchClass = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH')]");
    //index dropdown
    private  final By dropdownGrade = dropdownClick(2);
    private  final By inputSearchGrade = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH')]");
    private  final By inputCombinedGrade = convertStringToXpath("(//input[contains(@class,'ant-input sc-ezWOiH')])[2]");
    private  final By inputLastName = convertStringToXpath("(//input[@name='lastname'])[1]");
    private  final By buttonFilter = convertStringToXpath("(//b[normalize-space()='Apply Filter'])[1]");
    private  final By btnAddParent = convertStringToXpath("(//span[normalize-space()='+ Add Parent'])[1]");
    private  final By dropdownParentChild = convertStringToXpath("(//div[contains(@class,'ant-select-selector')])[3]");
    private  final By inputSearchParentChild = convertStringToXpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
    private  final By btnLinkThisStudent = convertStringToXpath("(//span[normalize-space()='Link this Student'])[1]");
    private  final By btnSave = convertStringToXpath("(//span[normalize-space()='Save'])[1]");
    private  final By btnCancel = convertStringToXpath("(//span[normalize-space()='Cancel'])[1]");
    private  final By inputSearch = convertStringToXpath("(//input[@placeholder='Search for Parent'])[1]");
    private  final By btnClickEdit = convertStringToXpath("(//div[@class='ant-dropdown-trigger flex items-center cursor-pointer'])[1]");
    private  final By btnSendMail = convertStringToXpath("(//div[@class='ant-dropdown-trigger flex items-center cursor-pointer'])[2]");
    private  final By popupTitle = convertStringToXpath("(//span[@class='ant-modal-confirm-title'])[1]");
    private  final By popupMessage = convertStringToXpath("(//div[@class='ant-modal-confirm-content'])[1]");
    private  final By btnSendEmail = convertStringToXpath("(//span[normalize-space()='Send Email'])[1]");
    private  final By btnYes = convertStringToXpath("(//span[normalize-space()='Yes'])[1]");
    private  final By btnOk = convertStringToXpath("(//span[normalize-space()='OK'])[1]");
    private  final By btnNo = convertStringToXpath("(//span[normalize-space()='No'])[1]");
    private  final By inputSearchForParent = convertStringToXpath("//input[@placeholder='Search for Parent']");

    private  final By buttonImport = convertStringToXpath ("//div[@class='ant-col ant-col-18 sc-WCkqM kfwYVc filter-action-second']//div[2]//button[1]");
    private  final By buttonChooseFile = convertStringToXpath ("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    private  final By buttonContinue = convertStringToXpath ("//body//div//button[2]");

    private  final By buttonImportParents = convertStringToXpath ("//span[normalize-space()='Import Parents']");
    private  final By buttonCancel = convertStringToXpath ("//span[normalize-space()='Cancel']");
    private  final By buttonReturntoParentManagement= convertStringToXpath ("//span[normalize-space()='Return to Parent Management']");

    private  final By buttonExportRoster= convertStringToXpath ("//span[normalize-space()='Export Roster']");





    private  final String existUsername = "You are trying to add a user with a user name that already exists.";
    private  final String notInput = "Please select at least one child";
    private  final String usernameNotRequire = "Username must contain only alphanumeric character.";
    private  final String fieldRequire = "This field is required.";
    private  final String sizeInput = "Username length must be from 3 to 50 characters.";
    private  final String emailFormat = "Email is in invalid format.";
    private  final String existEmail = "You have specified an email address that has already been used.";
    private  final String selectStudent = "Please select a student.";
    private  final String formatUsername = "Username must contain only alphanumeric characters.";
    private  final String emailSendSuccess = "Welcome email sent successfully.";
    public  final String urlMail = "https://yopmail.com/en/";
    public  final By inputTypeEmail =  convertStringToXpath("(//input[@id='login'])[1]");
    public  final By btnLoginEmail =  convertStringToXpath("(//i[@class='material-icons-outlined f36'])[1]");
    public  final By iframeEmail =  convertStringToXpath("//iframe[@id='ifmail']");
    public  final By lblTitleEmail =  convertStringToXpath("//div[text()='Welcome to Sadlier Connect']");
    public  final By iconDeleteEmail=  convertStringToXpath("(//button[@onclick='w.suppr_mail();'])[1]");
    public  final By verifymessageTCs35=  convertStringToXpath("//td[normalize-space()='No error found.']");

    public  final By verifymessageTCs36=  convertStringToXpath("//td[contains(text(),'You must provide a user name for the parent account')]");

    public  final By verifymessageTCs37=  convertStringToXpath("//td[normalize-space()='You are trying to add a user name that already exists.']");



    public ManageParentsPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent");
    }


    private void resetData(String removedData) {
            WebUI.clearTextCtrlA(inputSearch);
            WebUI.setText(inputSearch, removedData, Keys.ENTER);
            WebUI.sleep(5);
            WebUI.waitForPageLoaded();
            WebUI.sleep(5);
            WebUI.deleteDataOnTableByColumn(3, removedData);
        }


        public void visitPage() {
        WebUI.sleep(5);
        WebUI.clickElement(clickDropDown);
        WebUI.sleep(2);
        WebUI.clickElement(pageClick);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }

    // filter
    public void TC_MANAGE_PARENT_01(Hashtable<String, String> data) throws IOException {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_01")) {
            WebUI.clickElement(dropdownClass);
            WebUI.clickElement(inputSearchClass);
            WebUI.setText(inputSearchClass, data.get(manageParentModel.getClazz()).trim());
            WebUI.clickElement(dataWhenClickIndex(data.get(manageParentModel.getClazz()).trim(),1));
            WebUI.clickElement(buttonFilter);
            //[CP]_Display Show Par_1 in Class 1.
            WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH,"TestData_TC_MANAGE_PARENT_01");
        }

    }

    public void TC_MANAGE_PARENT_02(Hashtable<String, String> data) throws IOException {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_02")) {
            WebUI.clickElement(dropdownGrade);
            WebUI.clickElement(inputSearchGrade);
            WebUI.setText(inputSearchGrade, data.get(manageParentModel.getGrade()).trim(), Keys.ENTER);
            WebUI.clickElement(buttonFilter);
            //[CP]_Show all record parent with grade 1
            WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH,"TestData_TC_MANAGE_PARENT_02");
        }
    }

    public void TC_MANAGE_PARENT_03(Hashtable<String, String> data) throws IOException {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_03")) {
            WebUI.setText(inputLastName, data.get(manageParentModel.getLastName()), Keys.ENTER);
            //[CP]_Display Show Account Parent
            WebUI.clickElement(buttonFilter);
            WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH,"TestData_TC_MANAGE_PARENT_03");
        }
    }

    public void TC_MANAGE_PARENT_04(Hashtable<String, String> data) throws IOException {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_04")) {
            WebUI.clickElement(dropdownClass);
            WebUI.clickElement(inputSearchClass);
            WebUI.setText(inputSearchClass, data.get(manageParentModel.getClazz()).trim());
            WebUI.clickElement(dataContains(data.get(manageParentModel.getClazz()).trim()));
            WebUI.clickElement(dropdownGrade);
            WebUI.clickElement(inputCombinedGrade);
            WebUI.setText(inputCombinedGrade, data.get(manageParentModel.getGrade()).trim(),Keys.ENTER);
            WebUI.setText(inputLastName, data.get(manageParentModel.getLastName()), Keys.ENTER);
            WebUI.clickElement(buttonFilter);
            //[CP]_Display Show Account Parent
            WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH,"TestData_TC_MANAGE_PARENT_04");
        }
    }


    public void TC_MANAGE_PARENT_05(Hashtable<String, String> data){
       if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_05")) {
            boolean existData = filterExistOrDelete(1, data);
            // delete if user exist
            if (existData) {
                String action = "Delete Account";
                dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
                action = dropdownActionClick(action);
                confirmModalWhenDataChange(true, "OK");
                verifyMessageSuccess("The user account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " has been deleted.");
            }
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Par_2 was added successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()) + " " + data.get(manageParentModel.getLastName()) + " was added successfully.");
            //[CP]_- Show record with user name "par_2"
            WebUI.SearchDataOnTextBox(inputSearch, data.get(manageParentModel.getUsername()));
            WebUI.checkContainsValueOnTableByColumn(3, data.get(manageParentModel.getUsername()).trim());
            WebUI.sleep(2);
            CommonPageSC.logOutPage();
       }
    }

    public void TC_MANAGE_PARENT_06(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_06")) {
            boolean existData = filterExistOrDelete(1, data);
            // delete if user exist
            if (existData) {
                String action = "Delete Account";
                dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
                action = dropdownActionClick(action);
                confirmModalWhenDataChange(true, "OK");
                verifyMessageSuccess("The user account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " has been deleted.");
            }
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message  "The parent account for Par_3 was created successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()) + " " + data.get(manageParentModel.getLastName()) + " was added successfully.");
            //[CP]_Display message  "The parent account for Par_3 was created successfully"
            WebUI.setText(inputSearchForParent,data.get(manageParentModel.getUsername()), Keys.ENTER);
            WebUI.checkContainsValueOnTableByColumn(3, data.get(manageParentModel.getUsername()).trim());
        }
    }

    public void TC_MANAGE_PARENT_07(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_07")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            //[CP]_back Back to Manage Parents page
            WebUI.clickElement(btnCancel);
        }
    }

    public void TC_MANAGE_PARENT_08(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_08")) {
            WebUI.clickElement(btnAddParent);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "This field is required."
            verifyMessageRequire(fieldRequire, fieldRequire);
        }
    }

    public void TC_MANAGE_PARENT_09(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_09")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "You have specified an email address that has already been used."
            verifyMessageRequire(existEmail, existEmail);
        }
    }

    public void TC_MANAGE_PARENT_10(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_10")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "You are trying to add a user with a user name that already exists."
            verifyMessageRequire(existUsername, existUsername);
        }
    }

    public void TC_MANAGE_PARENT_11(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_11")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), false);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "Please select at least one child."
            verifyMessageError(notInput);
        }
    }

    public void TC_MANAGE_PARENT_12(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_12")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "Username must contain only alphanumeric character."
            verifyMessageRequire(formatUsername, formatUsername);
        }
    }

    public void TC_MANAGE_PARENT_13(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_13")) {
            WebUI.clickElement(btnAddParent);
            setDataInput(data, data.get(manageParentModel.getTestCaseName()).trim(), true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "Email is in invalid format"
            verifyMessageRequire(emailFormat, emailFormat);
        }
    }

    // update
    public void TC_MANAGE_PARENT_14(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_14")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("firstName"));
            WebUI.setText(inputSetName("firstName"), data.get(manageParentModel.getFirstName()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Parent123 Hung456 was updated successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " was updated successfully.");
        }
    }

    public void TC_MANAGE_PARENT_15(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_15")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("lastName"));
            WebUI.setText(inputSetName("lastName"), data.get(manageParentModel.getLastName()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Parent123 Hung456 was updated successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " was updated successfully.");
        }
    }

    public void TC_MANAGE_PARENT_16(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_16")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("email"));
            WebUI.setText(inputSetName("email"), data.get(manageParentModel.getEmail()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Parent123 Hung456 was updated successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " was updated successfully.");
        }
    }

    public void TC_MANAGE_PARENT_17(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_17")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.setText(inputSetName("username"), data.get(manageParentModel.getUsernameEdit()).trim());
            WebUI.clearTextCtrlA(inputSetName("password"));
            WebUI.setText(inputSetName("password"), data.get(manageParentModel.getPassword()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Parent123 Hung456 was updated successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " was updated successfully.");
        }
       }

    public void TC_MANAGE_PARENT_18(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_18")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            filterExistOrDelete(2, data);
            setDataInputParentChild(data, 1, true);
            WebUI.clickElement(btnSave);
            //[CP]_Display message "The parent account for Parent123 Hung456 was updated successfully"
            verifyMessageSuccess("The parent account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " was updated successfully.");
        }
       }

    public void TC_MANAGE_PARENT_19(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_19")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("firstName"));
            WebUI.setText(inputSetName("firstName"), data.get(manageParentModel.getFirstName()).trim());
            WebUI.clearTextCtrlA(inputSetName("middleName"));
            WebUI.setText(inputSetName("middleName"), data.get(manageParentModel.getMiddleName()).trim());
            WebUI.clearTextCtrlA(inputSetName("lastName"));
            WebUI.setText(inputSetName("lastName"), data.get(manageParentModel.getLastName()).trim());
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.setText(inputSetName("username"), data.get(manageParentModel.getUsernameEdit()).trim());
            WebUI.clearTextCtrlA(inputSetName("password"));
            WebUI.setText(inputSetName("password"), data.get(manageParentModel.getPassword()).trim());
            //[CP]_Back Back to my Library Page
            WebUI.clickElement(btnCancel);
           // WebUI.getCurrentUrl().equalsIgnoreCase();
        }
    }

    public void TC_MANAGE_PARENT_20(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_20")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("firstName"));
            WebUI.clearTextCtrlA(inputSetName("middleName"));
            WebUI.clearTextCtrlA(inputSetName("lastName"));
            WebUI.clearTextCtrlA(inputSetName("email"));
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.clearTextCtrlA(inputSetName("password"));
            WebUI.clickElement(btnSave);
            //[CP]_Display message "This field is required."
            verifyMessageRequire(fieldRequire,fieldRequire);
        }
    }

    public void TC_MANAGE_PARENT_21(Hashtable<String, String> data){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_21")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.setText(inputSetName("username"), data.get(manageParentModel.getUsernameEdit()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "Username must contain only alphanumeric characters."
            verifyMessageRequire(formatUsername, formatUsername);
        }
    }

    public void TC_MANAGE_PARENT_22(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_22")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("email"));
            WebUI.setText(inputSetName("email"), data.get(manageParentModel.getEmail()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "Email is in invalid format."
            verifyMessageRequire(emailFormat, emailFormat);
        }
    }

    public void TC_MANAGE_PARENT_23(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_23")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.setText(inputSetName("username"), data.get(manageParentModel.getUsernameEdit()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "You are trying to add a user with a username that already exists."
            verifyMessageRequire(existUsername, existUsername);
        }
    }

    public void TC_MANAGE_PARENT_24(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_24")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            WebUI.clearTextCtrlA(inputSetName("email"));
            WebUI.setText(inputSetName("email"), data.get(manageParentModel.getEmail()).trim());
            WebUI.clickElement(btnSave);
            //[CP]_Display message "You have specified an email address that has already been used."
            verifyMessageRequire(existEmail, existEmail);
        }
    }

    public void TC_MANAGE_PARENT_25(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_25")) {
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), "Edit Account");
            dropdownActionClick("Edit Account");
            filterExistOrDelete(2, data);
            WebUI.clickElement(btnSave);
            //[CP]_Display message Please select at least one child.
            verifyMessageError(notInput);
        }
    }

    //
    public void TC_MANAGE_PARENT_26(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_26")) {
            WebUI.clickElement(btnAddParent);
            WebUI.clickElement(dropdownParentChild);
            WebUI.setText(inputSearchParentChild, data.get(manageParentModel.getParentChild()).trim());
            WebUI.clickElement(btnLinkThisStudent);
            //[CP]_Display message "Please select a student."
            WebUI.verifyElementTextContains(modalMessage, selectStudent);
        }
    }

    // disable

    public void TC_MANAGE_PARENT_27(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_27")) {
            String action = "Disable Account";
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            action = dropdownActionClick(action);
            confirmModalWhenDataChange(true, "No");
            WebUI.sleep(5);
            // [CP]_1. Status is Enabled
            WebUI.checkEqualsValueOnTableByColumn(5, data.get(manageParentModel.getStatus()).trim());
        }
    }
    public void TC_MANAGE_PARENT_28(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_28")) {
            String action = "Disable Account";
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            action = dropdownActionClick(action);
            confirmModalWhenDataChange(true, "Yes");
            verifyMessageSuccess("The user account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " has been " + (action.equalsIgnoreCase("Disable Account") ? "disabled." : "enabled."));
            if (action.equalsIgnoreCase("Enable Account")) {
                action = "Disable Account";
                WebUI.clearText(inputSearch);
                dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
                action = dropdownActionClick(action);
                confirmModalWhenDataChange(true, "Yes");
                verifyMessageSuccess("The user account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " has been " + (action.equalsIgnoreCase("Disable Account") ? "disabled." : "enabled."));
            }
            // [CP]_1. Status is Disabled
            WebUI.checkEqualsValueOnTableByColumn(5, data.get(manageParentModel.getStatus()).trim());
        }
    }

    //delete
    public void TC_MANAGE_PARENT_29(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_29")){
            String action = "Delete Account";
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionClick(action);
            confirmModalWhenDataChange(false, "Cancel");
            //[CP]_at step 6:- Record parent "Par_22" exists
            WebUI.checkEqualsValueOnTableByColumn(3, data.get(manageParentModel.getUsername()).trim());

        }
    }

    public void TC_MANAGE_PARENT_30(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_30")){
            String action = "Delete Account";
            dataNeedUpdateOrDelete(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionClick(action);
            confirmModalWhenDataChange(true, "OK");
            //[CP]_Display message 1. Display message "The user account for Parent hung2 has been deleted"
            verifyMessageSuccess("The user account for " + data.get(manageParentModel.getFirstName()).trim() + " " + data.get(manageParentModel.getLastName()).trim() + " has been deleted.");
           // 2. Record parent "Par_22" not exists
            WebUI.SearchDataOnTextBox(inputSearchForParent, data.get(manageParentModel.getUsername()).trim());
            WebUI.checkDataIsNotExistedOnTableByColumn(3,data.get(manageParentModel.getUsername()).trim());
        }
        resetData(excelHelpers.getCellData(29, manageParentModel.getUsername().trim()));
    }


    public void TC_MANAGE_PARENT_31(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_31")) {
            String action = "Send Parent Welcome";
            dataNeedSendMail(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionSendMailClick(action);
            confirmModalSendEmail(false, "Cancel");
            WebUI.sleep(2);
            verifyNoReceivedEMail(data);

        }
    }

    // send mail
    public void TC_MANAGE_PARENT_32(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_32")) {
            String action = "Send Parent Welcome";
            dataNeedSendMail(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionSendMailClick(action);
            confirmModalSendEmail(true, "Send Email");
            verifyMessageSuccess(emailSendSuccess);

            //[CP]_Display message "Welcome email sent successfully."
            verifyReceivedEMail(data);

        }
    }

    public void TC_MANAGE_PARENT_33(Hashtable<String, String> data) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_33")) {
            String action = "Send Student Welcome";
            dataNeedSendMail(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionSendMailClick(action);
            //[CP]_Close_PopUp "Send Student Welcome Letter"
            confirmModalSendEmail(false, "Cancel");
            verifyNoReceivedEMail(data);
        }
    }
    public void TC_MANAGE_PARENT_34(Hashtable<String, String> data) {

        //WebUI.deleteDataOnTableByColumn(3,excelHelpers.getCellData(29, LoginModel.getUserName()));
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase("TC_MANAGE_PARENT_34")) {
            String action = "Send Student Welcome";
            dataNeedSendMail(data, data.get(manageParentModel.getTestCaseName()).trim(), action);
            dropdownActionSendMailClick(action);
            confirmModalSendEmail(true, "Send Email");
            //[CP]_Display message "Welcome email sent successfully."
            verifyMessageSuccess(emailSendSuccess);

            verifyReceivedEMail(data);
        }
    }



    //
    private void setDataInput(Hashtable<String, String> data, String testCaseName, boolean inputParentChild){
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase(testCaseName)) {
            WebUI.setText(inputSetName("firstName"), data.get(manageParentModel.getFirstName()).trim());
            WebUI.setText(inputSetName("middleName"), data.get(manageParentModel.getMiddleName()).trim());
            WebUI.setText(inputSetName("lastName"), data.get(manageParentModel.getLastName()).trim());
            WebUI.setText(inputSetName("email"), data.get(manageParentModel.getEmail()).trim());
            WebUI.clearTextCtrlA(inputSetName("username"));
            WebUI.setText(inputSetName("username"), data.get(manageParentModel.getUsername()).trim());
            WebUI.setText(inputSetName("password"), data.get(manageParentModel.getPassword()).trim());
            //show password
            WebUI.clickElement(convertStringToXpath("(//span[@class='toggle-show-hide-pw'])[1]"));
            if (Boolean.TRUE.equals(inputParentChild)) {
                setDataInputParentChild(data, 1, false);
            }
        }
    }

    public void TC_MANAGE_PARENT_35(Hashtable<String, String> data) {
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + "/src/test/resources/testdataSC/importManageParent_TC_MANAGEPARENT_35.csv");
        WebUI.clickElement(buttonImport);
        WebUI.sleep(3);
        WebUI.uploadFileWithLocalForm(buttonChooseFile,importFile.toString());
        WebUI.clickElement(buttonContinue);
        WebUI.verifyElementText(verifymessageTCs35,"No error found.");
        WebUI.sleep(3);
        WebUI.clickElement(buttonImportParents);
        WebUI.sleep(3);
        WebUI.clickElement(buttonReturntoParentManagement);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        //[CP]_Display all record of file import at list result component
        WebUI.checkValueOnTableByColumn(1,data.get(manageParentImportModel.getLastName().trim()));
    }

    public void TC_MANAGE_PARENT_36(Hashtable<String, String> data) {
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + "/src/test/resources/testdataSC/importManageParent_TC_MANAGEPARENT_36.csv");
        WebUI.clickElement(buttonImport);
        WebUI.sleep(3);
        WebUI.uploadFileWithLocalForm(buttonChooseFile,importFile.toString());
        WebUI.clickElement(buttonContinue);
        WebUI.sleep(3);
        WebUI.verifyElementText(verifymessageTCs36,"You must provide a user name for the parent account.");
        WebUI.clickElement(buttonImportParents);
        WebUI.sleep(3);
        WebUI.clickElement(buttonReturntoParentManagement);
        //[CP]_List record at result component not change
        WebUI.checkDataIsNotExistedOnTableByColumn(1, data.get(manageParentImportModel.getLastName().trim()) );
        }

    public void TC_MANAGE_PARENT_37(Hashtable<String, String> data) {
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + "/src/test/resources/testdataSC/importManageParent_TC_MANAGEPARENT_37.csv");
        WebUI.clickElement(buttonImport);
        WebUI.sleep(3);
        WebUI.uploadFileWithLocalForm(buttonChooseFile,importFile.toString());
        WebUI.clickElement(buttonContinue);
        WebUI.sleep(3);
        WebUI.verifyElementText(verifymessageTCs37,"You are trying to add a user name that already exists.");
        WebUI.clickElement(buttonImportParents);
        WebUI.sleep(3);
        WebUI.clickElement(buttonReturntoParentManagement);
        WebUI.sleep(5);
        //CP_List record at result component not change
        WebUI.checkValueOnTableByColumn(1, data.get(manageParentImportModel.getLastName().trim()));
        WebUI.sleep(5);
        WebUI.SearchDataOnTextBox(By.xpath("//input[@placeholder='Search for Parent']"),data.get(manageParentImportModel.getLastName()));
        WebUI.sleep(5);
        WebUI.deleteDataOnTableByColumn(1,data.get(manageParentImportModel.getLastName()));

    }

    private void setDataInputParentChild(Hashtable<String, String> data, int index, boolean isDelete){
        WebUI.clickElement(dropdownParentChild);
        if (WebUI.verifyElementPresent(inputSearchParentChild, 10)){
            if (isDelete){
                WebUI.setText(inputSearchParentChild, data.get(manageParentModel.getParentChildDelete()).trim().substring(data.get(manageParentModel.getParentChildDelete()).indexOf(" "),
                        data.get(manageParentModel.getParentChildDelete()).length()).trim());
                WebUI.sleep(5);
                WebUI.waitForPageLoaded();
                WebUI.clickElement(dataWhenClickIndex(data.get(manageParentModel.getParentChildDelete()).trim(), index));
            }else {
                WebUI.setText(inputSearchParentChild, data.get(manageParentModel.getParentChild()).trim().substring(data.get(manageParentModel.getParentChild()).indexOf(" "),
                        data.get(manageParentModel.getParentChild()).length()).trim());
                WebUI.sleep(5);
                WebUI.waitForPageLoaded();
                WebUI.clickElement(dataWhenClickIndex(data.get(manageParentModel.getParentChild()).trim(), index));
            }
            WebUI.sleep(2);
            WebUI.clickElement(btnLinkThisStudent);
        }else {
            WebUI.clickElement(dropdownParentChild);
        }
    }

    private boolean filterExistOrDelete(int index, Hashtable<String, String> data) {
        WebUI.sleep(5);
        List<WebElement> trs = WebUI.getWebElements(convertStringToXpath("(//table)["+index+"]/tbody/tr"));
        for (WebElement tr : trs){
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for (WebElement td : tds){
                if (index == 1) {
                    if (td.getText().equalsIgnoreCase(data.get(manageParentModel.getUsername()))) {
                        return true;
                    }
                }else {
                    if (td.getText().equalsIgnoreCase("")) {
                        //find button delete
                        WebElement isDeleteShow = td.findElement(convertStringToXpath("(//div[@class='flex'])[1]"));
                        if (isDeleteShow.isDisplayed()){
                            WebUI.clickElement(convertStringToXpath("(//div[@class='flex'])[1]"),5);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void confirmModalSendEmail(boolean isChange, String action) {
        if (Boolean.TRUE.equals(isChange) && action.equalsIgnoreCase("Send Email")){
            if (WebUI.checkElementPresent(btnSendEmail, 10)) {
                WebUI.clickElement(btnSendEmail);
            }
        }else {
            if (action.equalsIgnoreCase("Cancel")){
                WebUI.clickElement(btnCancel);
            }
            if (action.equalsIgnoreCase("OK")) {
                WebUI.clickElement(btnNo);
            }
        }
    }
    private void confirmModalWhenDataChange(boolean isChange, String action){
        // popup confirm action
        if (Boolean.TRUE.equals(isChange)){
            if (action.equalsIgnoreCase("Yes")) {
                WebUI.clickElement(btnYes);
            }
            if (action.equalsIgnoreCase("OK")) {
                WebUI.clickElement(btnOk);
            }
        }else {
            if (action.equalsIgnoreCase("Cancel")){
                WebUI.clickElement(btnCancel);
            }
            if (action.equalsIgnoreCase("No")) {
                WebUI.clickElement(btnNo);
            }
        }
    }



    // data search global after update or delete
    private void dataNeedUpdateOrDelete(Hashtable<String, String> data, String testCaseName, String action) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase(testCaseName)) {
            WebUI.clearTextCtrlA(inputSearch);
            WebUI.setText(inputSearch, data.get(manageParentModel.getUsername()).trim(), Keys.ENTER);
            WebUI.sleep(5);
            WebUI.waitForPageLoaded();
            WebUI.clickElement(btnClickEdit);
            WebUI.sleep(2);
        }
    }


    // dropdown action
    private String dropdownActionClick(String action) {
        switch (action){
            case "Edit Account":{
                if(WebUI.checkElementPresent(dataContains("Edit Account"))) {
                    WebUI.clickElement(dataContains("Edit Account"));
                    action = "Edit Account";
                }
                return action;
            }
            case "Disable Account":{
                if(WebUI.checkElementPresent(dataContains("Disable Account"))) {
                    WebUI.clickElement(dataContains("Disable Account"));
                    action = "Disable Account";
                }else {
                    WebUI.clickElement(dataContains("Enable Account"));
                    action = "Enable Account";
                }
                return action;
            }
            case "Delete Account":{
                if(WebUI.checkElementPresent(dataContains("Delete Account"))) {
                    WebUI.clickElement(dataContains("Delete Account"));
                    action = "Delete Account";
                }
                return action;
            }
            default:{
                if(WebUI.checkElementPresent(dataContains(action))) {
                    WebUI.clickElement(dataContains(action));
                }
                return action;
            }
        }
    }

    private void dataNeedSendMail(Hashtable<String, String> data, String testCaseName, String action) {
        if (data.get(manageParentModel.getTestCaseName()).equalsIgnoreCase(testCaseName)) {
            WebUI.setText(inputSearch, data.get(manageParentModel.getUsername()).trim(), Keys.ENTER);
            WebUI.sleep(5);
            WebUI.waitForPageLoaded();
            WebUI.clickElement(btnSendMail);
            WebUI.sleep(2);
        }
    }

    private void dropdownActionSendMailClick(String action) {
        if (action.equalsIgnoreCase("Send Student Welcome")){
            WebUI.clickElement(dataContains(action));
        }else {
            WebUI.clickElement(dataContains(action));
        }
    }

    private void verifyMessageRequire(String xpathMessage,String message) {
        WebUI.verifyElementTextContains(dataContains(xpathMessage), message);
    }

    private void verifyMessageSuccess(String message){
        WebUI.verifyElementTextContains(alertMessageSuccess, message);
    }

    private void verifyMessageError(String message){
        WebUI.verifyElementTextContains(alertMessageError, message);
    }


    public void verifyNoReceivedEMail(Hashtable<String, String> data) {
        WebUI.getURL(urlMail);
        WebUI.setText(inputTypeEmail, data.get(manageParentModel.getEmail()));
        WebUI.clickElement(btnLoginEmail);
        WebUI.sleep(4);
        WebUI.switchToFrameByElement(iframeEmail);
        WebUI.verifyElementNotPresent(lblTitleEmail);
    }

    public void verifyReceivedEMail(Hashtable<String, String> data) {
        WebUI.sleep(15);
        WebUI.getURL(urlMail);
        WebUI.setText(inputTypeEmail, data.get(manageParentModel.getEmail()));
        WebUI.clickElement(btnLoginEmail);
        WebUI.sleep(5);
        WebUI.switchToFrameByElement(iframeEmail);
        WebUI.checkElementPresent(lblTitleEmail);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        if(WebUI.verifyElementPresent(iconDeleteEmail,10)){
            WebUI.hoverOnElement(iconDeleteEmail);
            WebUI.clickElement(iconDeleteEmail);
            WebUI.sleep(5);
        }
    }




}
