package selenium.com.projects.sadlierconnect.pages.Assignments;

import org.openqa.selenium.By;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;


public class AssignmentSettingPageSC extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    public AssignmentSettingPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_SETTING_SC_PATH, "Setting");
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By labelAssignmentList = By.xpath("//span[@class='badge-group']");
    public By dropdownClass = By.xpath("//div[@class='ant-select ant-select-lg select ant-select-single ant-select-show-arrow']//div[@class='ant-select-selector']");
    public By dropdownSetting = By.xpath("(//*[name()='svg'])[2]");
    public By labelManageSetting = By.xpath("//a[normalize-space()='Manage Settings']");
    public By checkboxYesUploadContent = By.xpath("(//p[contains(text(),'Yes')])[11]");
    public By checkboxNoUploadContent = By.xpath("(//p[contains(text(),'No')])[11]");
    public By tableOptions = By.xpath("//div[@class='main-content bg-white']//div[@class='content-wrapper']");
    public By btnSaveinManageSetting = By.xpath("//span[normalize-space()='Save']");
    public By flashMessage = By.xpath("//div[@role='alert']");
    public By dropdownMyLibrary = By.xpath("//span[normalize-space()='My Library']");
    public By labelG4PIM = By.xpath("//a[contains(@class,'grade-item grade-item-63')]//span[@class='grade-label'][normalize-space()='4']");
    public By nodeAssessment = By.xpath("(//span[contains(text(),'Assessment')])[1]");
    public By resourcePDFBOYT = By.xpath("//span[normalize-space()='Beginning-of-Year Test']");
    public By btnAssign = By.xpath("//span[@title='Assign']//*[name()='svg']");
    public By createAssignmentPage = By.xpath("//div[@class='content-wrapper']");
    public By checkboxRequirestudentuploadinCreateAssignment = By.xpath("//input[@name='allowUploadStudentWorks']");
    public By iconAvatar = By.xpath("//span[@class='user-avatar']");
    public By labelAccountSetting = By.xpath("//a[normalize-space()='Account Setting']");
    public By dropdownScoreofReports = By.xpath("(//div[@class='ant-select-selector'])[1]");
    public By labelDispalyPercentage = By.xpath("//span[normalize-space()='Display Percentage on reports']");
    public By labelDisplayPoint = By.xpath("//span[normalize-space()='Display Points on reports']");
    public By tableAccountSetting = By.xpath("//div[@class='content-wrapper single-header']");
    public By btnSaveinAccountSetting = By.xpath("//span[normalize-space()='Save']");
    //public By dropdownClass = By.xpath("//div[@class='ant-select ant-select-lg select ant-select-single ant-select-show-arrow']//div[@class='ant-select-selector']");
    public By labelClassSetting = By.xpath("//span[normalize-space()='Class Setting']");
    public By dropdownStatus = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[2]");
    public By labelGraded = By.xpath("//span[normalize-space()='Graded']");
    public By btnApplyFilter = By.xpath("//span[normalize-space()='Apply Filter']");
    public By iconReport = By.xpath("//div[@class='cursor-pointer']//*[name()='svg']");
    public By iconScoreinTableReport = By.xpath("//th[@aria-label='[object Object] sortable']//span[@class='ant-table-column-title']");



    public void checkOptionStudentUploadInManageSetting() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownSetting);
        WebUI.sleep(2);
        WebUI.clickElement(labelManageSetting, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(checkboxYesUploadContent);
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(tableOptions);
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveinManageSetting);
        WebUI.sleep(3);
        //[CP]_Should show message " The changes to your settings have been saved."
        WebUI.verifyElementText(flashMessage,"The changes to your settings have been saved.");
        WebUI.sleep(2);
        WebUI.clickElement(dropdownMyLibrary);
        WebUI.sleep(2);
        WebUI.clickElement(labelG4PIM);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(nodeAssessment);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(resourcePDFBOYT, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(btnAssign);
        WebUI.sleep(3);
        WebUI.scrollToElementToBottom(createAssignmentPage);
        WebUI.sleep(2);
        //[CP]_Should show option "Required student upload" in Create Assignment page of static resource
        WebUI.verifyElementVisible(checkboxRequirestudentuploadinCreateAssignment);
        WebUI.sleep(3);
        //Reset Enable uploads of student content for assignments? Option to NO
        WebUI.clickElement(dropdownSetting);
        WebUI.sleep(2);
        WebUI.clickElement(labelManageSetting);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(checkboxNoUploadContent);
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(tableOptions);
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveinManageSetting);
        WebUI.sleep(2);
    }

    public void checkShowPointinAssignmentReport() {
        WebUI.sleep(5);
        WebUI.clickElement(iconAvatar);
        WebUI.sleep(2);
        WebUI.clickElement(labelAccountSetting,2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownScoreofReports);
        WebUI.sleep(2);
        WebUI.clickElement(labelDisplayPoint, 2);
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(tableAccountSetting);
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveinAccountSetting);
        WebUI.sleep(3);
        //[CP]_Should show message " Your alert preferences has been updated."
        WebUI.verifyElementText(flashMessage,"Your alert preferences has been updated.");
        WebUI.sleep(3);
        WebUI.clickElement(labelAssignmentList);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelClassSetting, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(2);
        WebUI.clickElement(labelGraded, 2);
        WebUI.sleep(2);
        WebUI.clickElement(btnApplyFilter);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconReport);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //[CP]_Should show point in assignment report of assessment resource
        WebUI.verifyElementVisible(iconScoreinTableReport, "#");
        WebUI.sleep(3);
    }

    public void checkShowPerceninAssignmentReport() {
        WebUI.sleep(5);
        WebUI.clickElement(iconAvatar);
        WebUI.sleep(2);
        WebUI.clickElement(labelAccountSetting,2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownScoreofReports);
        WebUI.sleep(2);
        WebUI.clickElement(labelDispalyPercentage, 2);
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(tableAccountSetting);
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveinAccountSetting);
        WebUI.sleep(3);
        //[CP]_Should show message " Your alert preferences has been updated."
        WebUI.verifyElementText(flashMessage,"Your alert preferences has been updated.");
        WebUI.sleep(3);
        WebUI.clickElement(labelAssignmentList);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelClassSetting, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(2);
        WebUI.clickElement(labelGraded, 2);
        WebUI.sleep(2);
        WebUI.clickElement(btnApplyFilter);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconReport);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //[CP]_Should show percen in assignment report of assessment resource
        WebUI.verifyElementVisible(iconScoreinTableReport, "%");
        WebUI.sleep(3);
    }

}
