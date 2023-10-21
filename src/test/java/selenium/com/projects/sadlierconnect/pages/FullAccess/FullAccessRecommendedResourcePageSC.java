package selenium.com.projects.sadlierconnect.pages.FullAccess;

import org.openqa.selenium.By;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.FullAccessReportRRModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;

import java.util.Hashtable;

public class FullAccessRecommendedResourcePageSC extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    private final FullAccessReportRRModel fullAccessReportModel = new FullAccessReportRRModel();
    public FullAccessRecommendedResourcePageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_RECOMMENDED_RESOURCE_SC_PATH, "FARecommendedResource");
    }
    public static final String pageUrl_FAreportPage = "/report/v2/fa-report.html";
    public By dropdownReport = By.xpath("//span[normalize-space()='Reports']");
    public By labelFullAccess = By.xpath("//span[normalize-space()='Full Access']");
    public By tabRR = By.xpath("//div[normalize-space()='Recommended Resources']");
    public By dropdownPS = By.xpath("//span[@title='Select Program Series']");
    public By labelPM = By.xpath("//span[normalize-space()='Progress Mathematics']");
    public By labelPIM = By.xpath("//span[normalize-space()='Progress in Mathematics']");
    public By dropdownSelectAssessment = By.xpath("//span[@title='Select Assessment']");
    public By dropdownPIMBOY1Growth = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'Grade 1: Beginning-of-Year Test (Growth)')]");
    public By labelG1Mid = By.xpath("//span[normalize-space()='Grade 1: Mid-Year Test (Growth)']");
    public By labelG1BoyPre = By.xpath("//span[contains(text(),'Grade 1: Beginning-of-Year Test (Prerequisite Skil')]");
    public By labelG1BoyGrowth = By.xpath("//span[contains(text(),'Grade 1: Beginning-of-Year Test (Growth')]");
    public By domainNumberinBaseTen = By.xpath("//span[normalize-space()='Numbers in Base Ten']");
    public By dropdownClass = By.xpath("//span[@title='Select Class']");
    public By labelDclass = By.xpath("//span[normalize-space()='DClass']");
    public By dropdownStudent = By.xpath("//span[@title='All Students']");
    public By labelStudent1 = By.xpath("//span[normalize-space()='Student 1']");
    public By dropdownDomain = By.xpath("//span[@class='ant-select-selection-item']//span[contains(text(),'All Domains')]");
    public By checkboxPriority = By.xpath("//input[@type='checkbox']");
    public By dropdownSort = By.xpath("//div[@class='sc-jIAOiI input-text']");
    public By labelSortbySequence = By.xpath("//div[@class='sc-jIAOiI dhzHKh'][normalize-space()='Developmental Sequence']");
    public By labelSortbyLowtoHigh = By.xpath("//div[normalize-space()='Low Proficiency to High Proficiency']");
    public By labelSortbyHightoLow = By.xpath("//div[normalize-space()='High Proficiency to Low Proficiency']");
    public By messageTableAboveProficiency = By.xpath("//div[@class='sc-jIAOiI cUgBeQ']");
    public By skillSortLowtoHighProficiency = By.xpath("(//p[contains(text(),'To use addition and subtraction to find the missin')])[1]");
    public By skillSortHightoLowProficiency = By.xpath("//p[contains(text(),'To subtract multiples of 10, including dimes, from')]");
    public By tableSkill = By.xpath("//div[@class='sc-jIAOiI']");
    public By iconPlusonSkill = By.xpath("(//div[contains(text(),'+')])[1]");
    public By iconPlusGroupStudentonSkill = By.xpath("//div[@class='ant-collapse-content ant-collapse-content-active']//div[@class='ant-col resource-action flex items-center justify-center self-start cursor-pointer hover:underline font-bold'][normalize-space()='+']");
    public By checkboxAllGroupStudentinSkill = By.xpath("//div[@class='ant-collapse-content ant-collapse-content-active']//input[@id='check-all']");
    public By checkboxProficiencyGroupinSkill = By.xpath("(//input[@type='checkbox'])[4]");
    public By checkboxAllinSkill = By.xpath("(//input[contains(@type,'checkbox')])[6]");
    public By checkboxResourceinSkill = By.xpath("(//input[@type='checkbox'])[7]");
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
    public By nodeAssignment = By.xpath("//span[@class='badge-group']");
    public By inputTextboxSearchAssignment = By.xpath("//input[@placeholder='Search Assignment List']");
    public By iconSearch = By.xpath("//div[@class='submit-search']//*[name()='svg']");
    public By iconPen = By.xpath("//tbody/tr[1]/td[7]/div[1]/div[1]//*[name()='svg']");
    public By optionDelete = By.xpath("//span[contains(text(),'Delete Assignment')]");
    public By btnOK = By.xpath("(//span[contains(text(),'OK')])[1]");


    public void checkMessageWhenStudentAboveProficiency()
    {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabRR);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(labelPM,2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1BoyPre,2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.clickElement(dropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(labelStudent1,2);
        WebUI.sleep(2);
        //[CP]_Check Show Message When Student above Proficiency
        WebUI.verifyElementText(messageTableAboveProficiency,
                "Students who scored at or above proficiency would benefit from:\n" +
                        "Ongoing practice to retain mastery\n" +
                        "On-level instruction according to curricular sequence\n" +
                        "Enrichment");
    }

    public void checkShowSkillOnRRandViewResource() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabRR);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(labelPIM, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(labelStudent1, 2);
        WebUI.sleep(2);
        //[CP]_Check Show table Skill
        WebUI.verifyElementVisible(tableSkill);
        WebUI.sleep(2);
        WebUI.clickElement(checkboxPriority);
        WebUI.sleep(2);
        WebUI.clickElement(checkboxPriority);
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

    public void checkCreateAssignment(Hashtable<String, String> data) {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabRR);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(labelPIM, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(labelStudent1, 2);
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
        WebUI.sleep(1);
        WebUI.clickElement(checkboxResourceinSkill);
        WebUI.sleep(1);
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
        //Reset Data
        WebUI.clickElement(nodeAssignment);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        WebUI.setText(inputTextboxSearchAssignment, data.get(fullAccessReportModel.getContentSearch()));
        WebUI.sleep(2);
        WebUI.clickElement(iconSearch);
        WebUI.sleep(3);
        WebUI.clickElement(iconPen);
        WebUI.sleep(2);
        WebUI.clickElement(optionDelete);
        WebUI.sleep(2);
        WebUI.clickElement(btnOK);
        WebUI.sleep(5);


    }

    public void checkShowSkillOnRRWhenSelectSingleDomain() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabRR);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(labelPIM, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownStudent);
        WebUI.sleep(2);
        WebUI.clickElement(labelStudent1, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownDomain);
        WebUI.sleep(2);
        WebUI.clickElement(domainNumberinBaseTen, 2);
        WebUI.sleep(3);
        //[CP]_Check Show Skill when Select Single Domain
        WebUI.verifyElementText(tableSkill, "Numbers in Base Ten");
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPIMBOY1Growth);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1Mid);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.sleep(2);
        //[CP]_Check Reset Domain Dropdown
        WebUI.verifyElementText(dropdownDomain, " All Domains");
        WebUI.sleep(3);
    }

    public void checkSortProficiency() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        WebUI.clickElement(labelFullAccess);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(tabRR);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownPS);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(labelPIM, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSelectAssessment);
        WebUI.sleep(2);
        WebUI.clickElement(labelG1BoyGrowth, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(2);
        WebUI.clickElement(labelDclass, 2);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSort);
        WebUI.sleep(1);
        WebUI.clickElement(labelSortbyLowtoHigh, 2);
        WebUI.sleep(2);
        //[CP]_Check Sort by Low to High Proficiency
        WebUI.verifyElementText(skillSortLowtoHighProficiency, "To use addition and subtraction to find the missing part of a number sentence.");
        WebUI.sleep(2);
        WebUI.clickElement(dropdownSort);
        WebUI.sleep(1);
        WebUI.clickElement(labelSortbyHightoLow,2);
        WebUI.sleep(2);
        //[CP]_Check Sort by High to Low Proficiency
        WebUI.verifyElementText(skillSortHightoLowProficiency, "To subtract multiples of 10, including dimes, from 90 or less.");
        WebUI.sleep(3);
    }



}
