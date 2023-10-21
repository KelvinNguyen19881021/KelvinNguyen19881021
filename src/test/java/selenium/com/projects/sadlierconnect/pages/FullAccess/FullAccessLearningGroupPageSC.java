package selenium.com.projects.sadlierconnect.pages.FullAccess;

import org.openqa.selenium.By;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.FullAccessReportLGModel;
import selenium.com.projects.sadlierconnect.models.FullAccessReportRRModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;

import java.util.Hashtable;

public class FullAccessLearningGroupPageSC extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    private final FullAccessReportLGModel fullAccessReportModel = new FullAccessReportLGModel();
    public FullAccessLearningGroupPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH, "FALearningGroup");
    }
    public static final String pageUrl_FAreportPage = "/report/v2/fa-report.html";
    public By dropdownReport = By.xpath("//span[normalize-space()='Reports']");
    public By labelFullAccess = By.xpath("//span[normalize-space()='Full Access']");
    public By tabLG = By.xpath("//div[normalize-space()='Learning Groups']");
    public By dropdownPS = By.xpath("//span[@title='Select Program Series']");
    public By labelPM = By.xpath("//span[normalize-space()='Progress Mathematics']");
    public By labelPIM = By.xpath("//span[normalize-space()='Progress in Mathematics']");
    public By labelSM = By.xpath("//span[normalize-space()='Sadlier Math']");
    public By labelWB = By.xpath("//span[normalize-space()='We Believe Catholic Identity School']");
    public By dropdownStandardSet = By.xpath("//span[@title='Select Standard Set']");
    public By labelChicago = By.xpath("//span[normalize-space()='Chicago']");
    public By dropdownSelectAssessment = By.xpath("//span[@title='Select Assessment']");
    public By dropdownPIMBOY1Growth = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'Grade 1: Beginning-of-Year Test (Growth)')]");
    public By dropdownWBMid3Growth = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'Grade 3: Mid-Year Test (Growth)')]");
    public By labelG1Mid = By.xpath("//span[normalize-space()='Grade 1: Mid-Year Test (Growth)']");
    public By labelG3Mid = By.xpath("//span[normalize-space()='Grade 3: Mid-Year Test (Growth)']");
    public By labelG1BoyPre = By.xpath("//span[contains(text(),'Grade 1: Beginning-of-Year Test (Prerequisite Skil')]");
    public By labelG4BoyPre = By.xpath("//span[contains(text(),'Grade 4: Beginning-of-Year Test (Prerequisite Skil')]");
    public By labelG1BoyGrowth = By.xpath("//span[contains(text(),'Grade 1: Beginning-of-Year Test (Growth')]");
    public By labelG3BoyGrowth = By.xpath("//span[contains(text(),'Grade 3: Beginning-of-Year Test (Growth')]");
    public By labelG3Eoy = By.xpath("//span[contains(text(),'Grade 3: End-of-Year Test')]");
    public By domainNumberinBaseTen = By.xpath("//span[normalize-space()='Numbers in Base Ten']");
    public By dropdownClass = By.xpath("//span[@title='Select Class']");
    public By labelDclass = By.xpath("//span[normalize-space()='DClass']");
    public By labelLGCLass = By.xpath("//span[normalize-space()='LGCLass']");
    public By dropdownStudent = By.xpath("//span[@title='All Students']");
    public By labelStudent1 = By.xpath("//span[normalize-space()='Student 1']");
    public By dropdownDomain = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'All Domains')]");
    public By dropdownOverall = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'Overall Proficiency Score')]");
    public By checkboxPriority = By.xpath("//input[@type='checkbox']");
    public By dropdownSort = By.xpath("//div[@class='sc-jIAOiI input-text']");
    public By labelSortbySequence = By.xpath("//div[@class='sc-jIAOiI dhzHKh'][normalize-space()='Developmental Sequence']");
    public By labelSortbyLowtoHigh = By.xpath("//div[normalize-space()='Low Proficiency to High Proficiency']");
    public By labelSortbyHightoLow = By.xpath("//div[normalize-space()='High Proficiency to Low Proficiency']");
    public By messageTableAboveProficiency = By.xpath("//div[@class='sc-jIAOiI cUgBeQ']");
    public By skillSortProficiency = By.xpath("(//div[@role='tab'])[1]");
    public By tableSkill = By.xpath("//div[@role='tablist']");
    public By iconPlusonSkill = By.xpath("(//div[contains(text(),'+')])[1]");
    public By iconPlusGroupStudentonSkill = By.xpath("//div[@class='ant-collapse-content ant-collapse-content-active']//div[@class='ant-col resource-action flex items-center justify-center self-start cursor-pointer hover:underline font-bold'][normalize-space()='+']");
    public By checkboxAllGroupStudentinSkill = By.xpath("//div[@class='ant-collapse-content ant-collapse-content-active']//input[@id='check-all']");
    public By checkboxProficiencyGroupinSkill = By.xpath("(//input[@type='checkbox'])[4]");
    public By checkboxAllinSkill = By.xpath("(//input[contains(@type,'checkbox')])[6]");
    public By checkboxResourceinSkill = By.xpath("(//input[@type='checkbox'])[6]");
    public By btnCreateAssignment = By.xpath("//button[contains(@class,'create-assignment-button')]");
    public By btnViewResource = By.xpath("(//button[normalize-space()='View'])[1]");
    public By btnBacktoFA = By.xpath("//span[normalize-space()='Back']");
    public By checkboxParentAssignment = By.xpath("//input[@name='isbulk']");
    public By btnSaveInCreatePopup = By.xpath("//span[normalize-space()='Save']");
    public By btnCancelInCreatePopup = By.xpath("//button[@class='ant-btn ant-btn-secondary sc-gsnTZi fbVUE']//span[contains(text(),'Cancel')]");
    public By tableResourcesofSkill = By.xpath("//div[@class='ant-collapse-content-box']");
    public By popupCreateAssignment = By.xpath("//div[@class='ant-modal-body']");
    public By inputTextboxAssignmentName = By.xpath("//textarea[@name='name']");
    public By timeStartDateOption = By.xpath("//input[@value='08:00 AM']");
    public By timeStartdate = By.xpath("//input[@value='08']");
    public By flashMessage = By.xpath("//div[@class='ant-alert-message']");
    public By btnManageGroupdisable = By.xpath("//div[@class='sc-jIAOiI ksvRSC cursor-not-allowed']");
    public By btnManageGroupenable = By.xpath("//div[@class='sc-jIAOiI dcCzaq cursor-pointer']");
    public By popupGroupManagement = By.xpath("//div[@class='ant-modal-content']");
    public By btnSaveGroup = By.xpath("//button[normalize-space()='Save']");
    public By btnAddGroup = By.xpath("//span[@id='addGroupBtn']");
    public By btnRestoreGroup = By.xpath("//a[@class='reset']");
    public By popupRestore = By.xpath("(//div[@class='ant-modal-content'])[2]");
    public By btnConfirmRestore = By.xpath("//button[normalize-space()='Restore']");
    public By iconChangeColorGroup = By.xpath("//span[@class='sc-jIAOiI dowXST ant-dropdown-trigger cursor-pointer']");
    public By textboxGroupName = By.xpath("//textarea[@name='groups[0].groupName']");
    public By labelChangeColortoProficient = By.xpath("//div[@display='flex'][normalize-space()='Proficient']");
    public By labelChangeColortoPartiallyProficient = By.xpath("//div[@display='flex'][normalize-space()='Partially Proficient']");
    public By groupChanged = By.xpath("//h5[normalize-space()='D Group']");
    public By groupDefault = By.xpath("//h5[normalize-space()='Group 1']");
    public By btnUpdateDomain = By.xpath("//div[@class='sc-jIAOiI btQhcU cursor-pointer']");
    public By popupUpdateDomain = By.xpath("//div[@class='ant-modal-content']");
    public By btnConfirmUpdateDomain = By.xpath("//button[normalize-space()='Update Groups']");
    public By nodeAssignment = By.xpath("//span[@class='badge-group']");
    public By inputTextboxSearchAssignment = By.xpath("//input[@placeholder='Search Assignment List']");
    public By iconSearch = By.xpath("//div[@class='submit-search']//*[name()='svg']");
    public By iconPen = By.xpath("(//*[name()='svg'][@title=' '])");
    public By optionDeleteAssignment = By.xpath("//span[contains(text(),'Delete Assignment')]");
    public By btnOK = By.xpath("(//span[contains(text(),'OK')])[1]");
    public By iconChart = By.xpath("//div[@class='sc-jIAOiI eUrSnj flex justify-between filter-chart ']//div[2]//*[name()='svg']");
    public By chartBar = By.xpath("//div[@class='sc-etyysw kTedzw chart-wrapper ']//*[name()='svg']//*[name()='rect'][1]");
    public By RRlink = By.xpath("//p[@class='sc-dBUBXv iHnJog']");
    public By popupProficiency = By.xpath("//p[@class='sc-dBUBXv iHnJog']");



    public void checkDisableManageGroupbutton() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelSM, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG4BoyPre, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.sleep(2);
        //[CP]_Check Disable Manage Group button
        WebUI.verifyElementAttributeValue(btnManageGroupdisable,"cursor", "not-allowed");
        WebUI.sleep(3);
    }

    public void checkViewSkillandViewResource() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelWB, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(2);
        WebUI.clickElement(labelChicago, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3Mid, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //[CP]_Check Enable Manage Group button
        WebUI.verifyElementAttributeValue(btnManageGroupenable,"cursor", "pointer");
        WebUI.sleep(2);
        WebUI.verifyElementText(messageTableAboveProficiency,"Students who scored at or above proficiency would benefit from:\n" +
                "Ongoing practice to retain mastery\n" +
                "On-level instruction according to curricular sequence\n" +
                "Enrichment");
        WebUI.sleep(3);
        WebUI.clickElement(dropdownWBMid3Growth);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconPlusonSkill);
        WebUI.sleep(3);
        WebUI.clickElement(iconPlusGroupStudentonSkill);
        WebUI.sleep(1);
        WebUI.clickElement(checkboxAllGroupStudentinSkill);
        WebUI.sleep(1);
        WebUI.clickElement(checkboxProficiencyGroupinSkill);
        WebUI.sleep(1);
        WebUI.clickElement(checkboxAllGroupStudentinSkill);
        WebUI.sleep(1);
        WebUI.clickElement(checkboxAllinSkill);
        WebUI.sleep(2);
        WebUI.clickElement(btnCreateAssignment);
        WebUI.sleep(2);
        //[CP]_Check Show popup Create Assignment
        WebUI.verifyElementVisible(popupCreateAssignment);
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(popupCreateAssignment);
        WebUI.sleep(2);
        WebUI.clickElement(btnCancelInCreatePopup);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(btnViewResource);
        WebUI.sleep(5);
        WebUI.clickElement(btnBacktoFA);
        WebUI.sleep(5);
        //[CP]_Check Back to FA report after Select Back button from View Resource
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessRecommendedResourcePageSC.pageUrl_FAreportPage);
        WebUI.sleep(5);
    }

    public void checkManageGroup(Hashtable<String, String> data) {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelWB, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(2);
        WebUI.clickElement(labelChicago, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(btnManageGroupenable);
        WebUI.sleep(2);
        //[CP]_Check show popup Group Management
        WebUI.verifyElementVisible(popupGroupManagement);
        WebUI.sleep(2);
        WebUI.clickElement(btnAddGroup);
        WebUI.sleep(1);
        WebUI.clickElement(btnRestoreGroup);
        WebUI.sleep(2);
        //[CP]_Check show popup Restore to Original Group
        WebUI.verifyElementVisible(popupRestore);
        WebUI.sleep(2);
        WebUI.clickElement(btnConfirmRestore);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconChangeColorGroup);
        WebUI.sleep(2);
        WebUI.clickElement(labelChangeColortoProficient, 2);
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(textboxGroupName, data.get(fullAccessReportModel.getGroupName()));
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveGroup);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //[CP]_Check Group changed
        WebUI.verifyElementText(groupChanged,"D Group");
        WebUI.sleep(3);

    }

    public void checkUpdateDomainScore(Hashtable<String, String> data) {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelWB, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(2);
        WebUI.clickElement(labelChicago, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(btnManageGroupenable);
        WebUI.sleep(2);
        WebUI.clickElement(iconChangeColorGroup);
        WebUI.sleep(2);
        WebUI.clickElement(labelChangeColortoProficient, 2);
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(textboxGroupName, data.get(fullAccessReportModel.getGroupName()));
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveGroup);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        WebUI.clickElement(btnUpdateDomain);
        WebUI.sleep(2);
        //[CP]_Check Show Popup Update Domain Score
        WebUI.verifyElementVisible(popupUpdateDomain);
        WebUI.sleep(2);
        WebUI.clickElement(btnConfirmUpdateDomain);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //[CP]_Check Group information returns to default
        WebUI.verifyElementText(groupDefault,"Group 1");
        WebUI.sleep(3);
    }

    public void checkCreateAssignment(Hashtable<String, String> data) {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelWB, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(2);
        WebUI.clickElement(labelChicago, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconPlusonSkill);
        WebUI.sleep(1);
        WebUI.clickElement(btnCreateAssignment);
        WebUI.sleep(2);
        //[CP]_Check Message when Create Assignment Without Resource
        WebUI.verifyElementText(flashMessage, "Warning! You must select at least one resource.");
        WebUI.clickElement(checkboxAllGroupStudentinSkill);
        WebUI.sleep(1);
        WebUI.clickElement(btnCreateAssignment);
        WebUI.sleep(2);
        //[CP]_Check Message when Create Assignment Without Student
        WebUI.verifyElementText(flashMessage, "Warning! You must select at least one student.");
        WebUI.sleep(2);
        WebUI.clickElement(checkboxAllGroupStudentinSkill);
        WebUI.sleep(2);
        WebUI.clickElement(checkboxResourceinSkill);
        WebUI.sleep(2);
        WebUI.clickElement(btnCreateAssignment);
        WebUI.sleep(2);
        WebUI.setText(inputTextboxAssignmentName, data.get(fullAccessReportModel.getAssignmentname()));
        WebUI.sleep(2);
        WebUI.clickElement(timeStartDateOption);
        WebUI.sleep(1);
        WebUI.setCtrlAThenFillText(timeStartdate, data.get(fullAccessReportModel.getTimestartdate()));
        WebUI.sleep(1);
        WebUI.scrollToElementToBottom(popupCreateAssignment);
        WebUI.sleep(2);
        WebUI.clickElement(btnSaveInCreatePopup);
        WebUI.sleep(3);
        //[CP]_Check Create Assignment Successfully
        WebUI.verifyElementText(flashMessage, "The assignment has been created successfully.");
        WebUI.sleep(3);
        //Reset data
        WebUI.clickElement(nodeAssignment);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.setText(inputTextboxSearchAssignment, data.get(fullAccessReportModel.getContentSearch()));
        WebUI.sleep(2);
        WebUI.clickElement(iconSearch);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconPen);
        WebUI.sleep(2);
        WebUI.clickElement(optionDeleteAssignment, 1);
        WebUI.sleep(2);
        WebUI.clickElement(btnOK);
        WebUI.sleep(2);
    }

    public void checkViewChart() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabLG);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(iconChart);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.sleep(2);
        WebUI.clickElement(labelWB, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(2);
        WebUI.clickElement(labelChicago, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG3BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelLGCLass, 2);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(chartBar);
        WebUI.sleep(2);
        //[CP]_Check show Popup Proficiency
        WebUI.verifyElementVisible(popupProficiency);
        WebUI.sleep(2);
        WebUI.clickElement(RRlink, 1);
        WebUI.sleep(2);
        //[CP]_Check move to RR page when select RR link in Popup
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessRecommendedResourcePageSC.pageUrl_FAreportPage);
        WebUI.sleep(3);
    }
}
