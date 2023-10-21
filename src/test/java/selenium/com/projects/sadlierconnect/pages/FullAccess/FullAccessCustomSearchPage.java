package selenium.com.projects.sadlierconnect.pages.FullAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.FullAccessSearchModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import java.util.Hashtable;
import java.util.Objects;

public class FullAccessCustomSearchPage extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();

    public FullAccessCustomSearchPage() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public static final String url_searchpage = "report/v2/fa-report.html";
    public static final String url_viewresource = "/full-access/view/resource?resourceId=35806&hash=MTUxMjcxMA==";
    public static final String url_viewresource_game = "/full-access/view/resource?resourceId=317537&hash=MTUxMjcxMA==";
    public static final String url_viewresource_video = "/full-access/view/resource?resourceId=357020&hash=MTUxMjcxMA==";
    private final By dropdownReport = By.xpath("(//ul[@class='dropdown-menu dropdown-menu-right'])[1]//div[1]//a[1]//span[1]//span[1]");
    private final By breadcrumb = By.xpath("(//div[@class='content-wrapper not-full-screen'])[1]");
    private final By iconFA = By.xpath("(//li[@role='menuitem'])[7]");
    private final By dropdownProgram = By.xpath("(//div[@class='ant-select-selector'])[1]");
    private final By programWBAtDropdown = By.xpath("((//div[contains(@class,'rc-virtual-list')])[1]//div[contains(@class,'ant-select-item-option-content')])[5]"); //WB
    private final By dropdownStandard = By.xpath("(//div[@class='ant-select-selector'])[2]"); //WB
    private final By labelChicago = By.xpath("//span[normalize-space()='Chicago']"); //chicago
    private final By iconSearchFA = By.xpath("(//div[@class='content-wrapper'])[2]//img[@src='/full-access/icons/fullAccess_toc_icn.svg']");
    private final By dropdownProgramSearch = By.xpath("(//button[contains(@type,'button')])[1]");
    private final By programAtDropdownSearchV3 = By.xpath("((//div[contains(@class,'ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight ')])[1]//span[contains(@class,'ant-dropdown-menu-title-content')])[6]");//WB
    private final By programWLAtDropdownSearchV3 = By.xpath("((//div[contains(@class,'ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight ')])[1]//span[contains(@class,'ant-dropdown-menu-title-content')])[7]");//WL
    private final By programAtDropdownSearchV2 = By.xpath("((//div[contains(@class,'ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomRight ')])[1]//span[contains(@class,'ant-dropdown-menu-title-content')])[2]");//SM
    private final By dropdownStandardSet = By.xpath("(//button[contains(@type,'button')])[2]");  //div[contains(text(),'Standard Set')])[1]
    private final By boxStandardSet = By.xpath("(//div[contains(text(),'Standard Set')])[1]");  //div[contains(text(),'Standard Set')])[1]
    private final By standardSetAtDropdown = By.xpath("(//ul[contains(@role,'menu')])[2]//li[2]"); //cincinnati
    private final By dropdownGradeV2 = By.xpath("(//button[@type='button'])[2]");
    private final By dropdownGradeV3 = By.xpath("(//button[@type='button'])[3]");
    private final By gradeAtDropdown1 = By.xpath("((//div[contains(@class,'ant-popover ant-popover-placement-bottomRight')])[1]//input[@type='checkbox'])[2]");//g3
    private final By gradeAtDropdown2 = By.xpath("((//div[contains(@class,'ant-popover ant-popover-placement-bottomRight')])[1]//input[@type='checkbox'])[4]");//g5
    private final By specificDomainAtDropdown1 = By.xpath("(//div[normalize-space()='Creed'])[1]");//creed
    private final By specificDomainAtDropdown5 = By.xpath("(//div[normalize-space()='Discipleship and Virtues'])[1]");//DISCIPLESHIP AND VIRTUES
    private final By dropdownDomainV2 = By.xpath("(//button[@type='button'])[3]");
    private final By dropdownDomainV3 = By.xpath("(//button[@type='button'])[4]");
    private final By popupDomain = By.xpath("(//div[@role='tooltip'])[2]");
    private final By popupStandard = By.xpath("(//div[@role='tooltip'])[3]");
    private final By specificStandardsSearchAtDropdown301A = By.xpath("(//div[normalize-space()='3.01.A'])[1]"); //3.01.A
    private final By specificStandardsSearchAtDropdown305A = By.xpath("(//div[normalize-space()='3.05.A'])[1]"); //3.05.A
    private final By specificStandardsSearchAtDropdown5 = By.xpath("(//div[normalize-space()='3.06.A'])[1]"); //3.06.A
    private final By dropdownStandardsSearchV3 = By.xpath("(//button[@type='button'])[5]");
    private final By dropdownTypeV3 = By.xpath("(//button[@type='button'])[6]");
    private final By instructionTypeAtDropdown = By.xpath("(//div[normalize-space()='Instruction'])[1]");//Instruction
    private final By instructionTypeAtDropdown2 = By.xpath("(//div[normalize-space()='Teacher Resource'])[1]");//Teacher Resource'
    private final By instructionTypeAtDropdown3 = By.xpath("(//div[normalize-space()='Student Resource'])[1]");//student Resource'
    private final By buttonCleanAll = By.xpath("(//button[normalize-space()='Clear All'])[1]");
    private final By spaceGrade1 = By.xpath("(//div[@class='sc-jIAOiI gFxwUK'])[1]"); //chọn 1 grade
    private final By spaceGrade2 = By.xpath("((//div[@class='sc-jIAOiI gFxwUK'])[1])//div[2]"); //chọn 2 grade
    private final By spaceDomain1 = By.xpath("(//div[@class='sc-jIAOiI gFxwUK'])[2]"); //chọn 1 grade và 1 domain hoặc 2 domain thì là element domain 2
    private final By spaceStandard1 = By.xpath("(//div[@class='sc-jIAOiI gFxwUK'])[3]"); //1grade, 1 domaim, 1 stand
    private final By spaceResourceType = By.xpath("(//div[@class='sc-ecnDPt jpIJsj'])[1]");
    private final By textBox = By.xpath("(//div[@class='w-full flex justify-center'])[1]//div[1]//input");
    private final By buttonSearch = By.xpath("(//button[normalize-space()='Search'])[1]");
    private final By buttonXGrade = By.xpath("(//div[contains(@class,'ant-col ant-col-3')])[1]//span[@class='sc-eIOwyE eAbCNk'][1]"); //grade
    private final By buttonXAtDomainCreed = By.xpath("(//span[@class='sc-eIOwyE eAbCNk'][normalize-space()='x'])[2]"); //domainCreed
    private final By tableObject = By.xpath("(//div[contains(@role,'tablist')])[1]");
    private final By tableObjectNoResult = By.xpath("(//div[@class='sc-jIAOiI YIHxL flex justify-center items-center'])[1]");
    private final By iconPlus = By.xpath("(//div[contains(text(),'+')])[1]");
    private final By checkboxResource1 = By.xpath("(//div[@class='ant-row ant-row-middle'])[3]//span[1]//input[@type='checkbox']"); // check box của line thứ 1
    private final By checkboxResource2 = By.xpath("(//div[@class='ant-row ant-row-middle'])[4]//span[1]//input[@type='checkbox']"); // check box của line thứ 2
    private final By buttonCreateAssignment = By.xpath("(//button[contains(@class,'create-assignment-button')][normalize-space()='Create Assignment'])[1]"); //button line đầu tiên
    private final By boxClass = By.xpath("(//div[contains(@class,'box-select-tags__input')])[1]");
    private final By class1 = By.xpath("((//div[contains(@class,'box-select-tags__option')])[1]//div[contains(@class,'items-center')])[1]");
    private final By buttonSave = By.xpath("(//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn'])[1]");
    private final By boxAssignmentName = By.xpath("(//textarea[@class='ant-input text-area ant-input-lg'])[1]");
    private final By boxResourcesInPopup1 = By.xpath("(//div[@class='sc-bBrHrO joNcfi sc-tag-item'])[1]");
    private final By boxResourcesInPopup2 = By.xpath("(//div[@class='sc-bBrHrO joNcfi sc-tag-item'])[2]");
    private final By boxTime = By.xpath("(//div[@class='sc-ehmTmK hgWiDn'])[1]");
    private final By timeStart = By.xpath("(//input[@value='08'])[1]");
    private final By alertMessage = By.xpath("(//div[@class='ant-alert-message'])[1]");
    private final By buttonView = By.xpath("(//button[contains(text(),'View')])[1]"); //button line đầu tiên
    private final By buttonViewGame = By.xpath("(//button[contains(text(),'View')])[5]");
    private final By buttonViewVideo = By.xpath("(//button[contains(text(),'View')])[5]");
    private final By buttonBack = By.xpath("(//span[normalize-space()='Back'])[1]");
    private final By buttonFullAccess = By.xpath("(//span[contains(text(),'Full Access')])[1]");
    private final By menuAssignment = By.xpath("(//span[@class='badge-group'])[1]");
    private final By boxSearchAssignment = By.xpath("(//input[@placeholder='Search Assignment List'])[1]");
    private final By iconGlass = By.xpath("(//div[@class='submit-search'])[1]");
    private final By noAssignment = By.xpath("(//td[@class='ant-table-cell'])[1]");
    private final By groupAssignment = By.xpath("(//span[@class='name'])[1]");
    private final By iconEdit = By.xpath("(//*[name()='svg'][@title=' '])[1]");
    private final By deleteAssignment = By.xpath("(//span[contains(text(),'Delete Assignment')])[1]");
    private final By buttonOK = By.xpath("(//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn'])[1]");

    public void goToFAPage() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(5);
        WebUI.clickElement(iconFA);
        WebUI.sleep(5);
    }

    public void goToSearchPage() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(5);
        WebUI.clickElement(iconFA);
        WebUI.sleep(5);
        WebUI.clickElement(iconSearchFA);
        WebUI.sleep(5);
    }

    public void selectProgram() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownProgram);
        WebUI.sleep(5);
        WebUI.clickElement(programWBAtDropdown);
        WebUI.sleep(5);
    }

    public void selectProgramInsearch() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownProgramSearch);
        WebUI.sleep(5);
        WebUI.clickElement(programAtDropdownSearchV3);
        WebUI.sleep(5);
    }

    public void selectStandardSetInAssessmentReport() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownStandard);
        WebUI.sleep(5);
        WebUI.clickElement(labelChicago);
        WebUI.sleep(5);
    }

    public void selectStandardSet() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownStandardSet);
        WebUI.sleep(5);
        WebUI.clickElement(labelChicago);
        WebUI.sleep(5);
    }

    public void selectGrade() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownGradeV3);
        WebUI.sleep(5);
        WebUI.clickElement(gradeAtDropdown1);//Grade3
        WebUI.sleep(5);
    }

    public void selectDomain() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownDomainV3);
        WebUI.sleep(5);
        WebUI.clickElement(specificDomainAtDropdown1);
        WebUI.sleep(5);
    }

    public void selectStandard301A() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownStandardsSearchV3);
        WebUI.sleep(5);
        WebUI.clickElement(specificStandardsSearchAtDropdown301A);
        WebUI.sleep(5);
    }

    public void selectStandard305A() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownStandardsSearchV3);
        WebUI.sleep(5);
        WebUI.clickElement(specificStandardsSearchAtDropdown305A);
        WebUI.sleep(5);
    }

    public void selectTypeIntruction() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownTypeV3);
        WebUI.sleep(5);
        WebUI.clickElement(instructionTypeAtDropdown);
        WebUI.sleep(5);
    }

    public void selectTypeTeacher() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownTypeV3);
        WebUI.sleep(5);
        WebUI.clickElement(instructionTypeAtDropdown2);
        WebUI.sleep(5);
    }

    public void selectTypeStudent() {
        WebUI.sleep(5);
        WebUI.clickElement(dropdownTypeV3);
        WebUI.sleep(5);
        WebUI.clickElement(instructionTypeAtDropdown3);
        WebUI.sleep(5);
    }

    public void viewResource() {
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(iconPlus);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonView);
        WebUI.clickElement(buttonView);
        WebUI.sleep(5);
    }

    public void viewGame() {
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(iconPlus);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonViewGame);
        WebUI.clickElement(buttonViewGame);
        WebUI.sleep(5);
    }

    public void viewVideo() {
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(iconPlus);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonViewVideo);
        WebUI.clickElement(buttonViewVideo);
        WebUI.sleep(5);
    }

    public void saveWithNameAndClass() {
        WebUI.sleep(5);
        WebUI.clickElement(boxAssignmentName);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Assignment");
        WebUI.setText(boxAssignmentName, excelHelpers.getCellData(1, FullAccessSearchModel.getAssignmentFA()), Keys.ENTER);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(boxClass);
        WebUI.clickElement(boxClass);
        WebUI.sleep(5);
        WebUI.clickElement(class1);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(timeStart);
        WebUI.clickElement(boxTime);
        WebUI.sleep(5);
        WebUI.setCtrlAThenFillText(timeStart, "12");
        WebUI.sleep(5);
        // 11. click Save button
        WebUI.scrollToElementToBottom(buttonSave);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(6);
    }

    public void createAssignmentSingle() {
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(checkboxResource1);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCreateAssignment);
        WebUI.sleep(5);
    }

    public void createAssignmentMulti() {
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(checkboxResource1);
        WebUI.sleep(5);
        WebUI.clickElement(checkboxResource2);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCreateAssignment);
        WebUI.sleep(5);
    }

    public void resetDataMulti() {
        WebUI.sleep(5);
        WebUI.clickElement(menuAssignment);
        WebUI.clickElement(boxSearchAssignment);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Assignment");
        WebUI.setText(boxSearchAssignment, excelHelpers.getCellData(1, FullAccessSearchModel.getAssignmentFA()));
        WebUI.sleep(5);
        WebUI.clickElement(iconGlass);
        WebUI.sleep(5);
        String tableAssignment2 = WebUI.getTextElement(noAssignment);
        if (Objects.equals(tableAssignment2, "No records found.")) {
            return;
        } else {
            WebUI.clickElement(groupAssignment);
            WebUI.scrollToElementToBottom(iconEdit);
            WebUI.clickElement(iconEdit);
            WebUI.sleep(5);
            WebUI.clickElement(deleteAssignment);
            WebUI.sleep(5);
            WebUI.clickElement(buttonOK);
            WebUI.sleep(5);
            WebUI.scrollToElementToBottom(iconEdit);
            WebUI.clickElement(iconEdit);
            WebUI.sleep(5);
            WebUI.clickElement(deleteAssignment);
            WebUI.sleep(5);
            WebUI.clickElement(buttonOK);
            WebUI.sleep(5);
        }
    }

    public void resetDataSingle() {
        WebUI.sleep(5);
        WebUI.clickElement(menuAssignment);
        WebUI.clickElement(boxSearchAssignment);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Assignment");
        WebUI.setText(boxSearchAssignment, excelHelpers.getCellData(1, FullAccessSearchModel.getAssignmentFA()));
        WebUI.sleep(5);
        WebUI.clickElement(iconGlass);
        WebUI.sleep(5);
        String tableAssignment1 = WebUI.getTextElement(noAssignment);
        if (Objects.equals(tableAssignment1, "No records found.")) {
            return;
        } else {
            WebUI.scrollToElementToBottom(iconEdit);
            WebUI.clickElement(iconEdit);
            WebUI.sleep(5);
            WebUI.clickElement(deleteAssignment);
            WebUI.sleep(5);
            WebUI.clickElement(buttonOK);
            WebUI.sleep(5);

        }
    }

    public void checkKeepDropdownProgram() {
      /*  1. Login Teacher
        2. Go to FA report
        3. Select Program, StandardSet (for WB3-8)
        4. Click Search icon*/
        goToFAPage();
        selectProgram();
        selectStandardSetInAssessmentReport();
        WebUI.clickElement(iconSearchFA);
        WebUI.sleep(5);
        /*- Keep Program/StandardSet selected at Report*/
        WebUI.verifyElementText(dropdownProgramSearch, "We Believe Catholic Identity School");
        WebUI.verifyElementText(dropdownStandardSet, "Chicago");
    }

    public void checkEnableDropdownProgram(Hashtable<String, String> data) {
        /*1. Login Teacher
          2. Go to FA report
          3. Click Search icon*/
        goToSearchPage();
//        "- Enable only Program Series dropdown
        WebUI.verifyElementAttributeValue(dropdownProgramSearch, "disable", "");
    }

    public void checkEnableDropdownStandardSet(Hashtable<String, String> data) {
        /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA */
        goToSearchPage();
//        4. Select Program Series
        selectProgramInsearch();
        //Enable StandardSet filter
        WebUI.verifyElementAttributeValue(dropdownStandardSet, "disable", "");
        WebUI.verifyElementAttributeValue(dropdownTypeV3, "disabled", "");
    }

    public void checkEnableDropdownGradeAndDomain(Hashtable<String, String> data) {
        /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
//        Enable Grade, Domain dropdown
        WebUI.verifyElementAttributeValue(dropdownGradeV3, "disabled", "");
        WebUI.verifyElementAttributeValue(dropdownDomainV3, "disabled", "");
        WebUI.verifyElementAttributeValue(dropdownStandardsSearchV3, "disabled", "true");

    }

    public void checkEnableDropdownStandards(Hashtable<String, String> data) {
        /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
//
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
//        "- Grade appear bellow to Grade dropdown
//        Enable Standard dropdown
        String grade3 = WebUI.getTextElement(spaceGrade1);
        WebUI.verifyContains(grade3, "Grade 3");
        WebUI.verifyElementAttributeValue(dropdownStandardsSearchV3, "disabled", "");
        WebUI.verifyElementAttributeValue(buttonCleanAll, "disabled", "");
    }

    public void checkDomainFilter(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        WebUI.clickElement(dropdownDomainV3);
        WebUI.sleep(5);
        // should be shown Domain of state selected
        String domain1 = WebUI.getTextElement(popupDomain);
        WebUI.verifyContains(domain1, "CREED");
        WebUI.verifyContains(domain1, "SACRAMENTS");
        WebUI.verifyContains(domain1, "LIFE IN CHRIST");
        WebUI.verifyContains(domain1, "PRAYER");
        WebUI.verifyContains(domain1, "DISCIPLESHIP AND VIRTUES");
    }

    public void checkStandardsFilter(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        //7. Select Domain
        selectDomain();
        WebUI.clickElement(dropdownStandardsSearchV3);
        // Should be shown standards of domain selected
        String standards = WebUI.getTextElement(popupStandard);
        WebUI.verifyContains(standards, "3.01.A");
        WebUI.verifyContains(standards, "3.01.B");
        WebUI.verifyContains(standards, "3.02.A");
    }

    public void checkStandardsFilterWhenRemoveDomain(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        //7. Select domain
        selectDomain();
        // 8. Select Standards
        selectStandard301A();
        // 9. Click X button of Creed domain
        WebUI.clickElement(buttonXAtDomainCreed);
        WebUI.sleep(5);
        // Remove domain and Standard bellow filter
        WebUI.verifyElementNotVisible(spaceStandard1);
        WebUI.verifyElementNotVisible(spaceDomain1);
    }

    public void checkDomainFilterWhenRemoveGrade(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        //7. Select domain
        selectDomain();
        // 8. Select Standards
        selectStandard301A();
        // 9. Click X button of Grade 3
        WebUI.clickElement(buttonXGrade);
        WebUI.sleep(5);
        // Remove domain and Grade bellow filter, Standards filter should be disabled
        WebUI.verifyElementNotVisible(spaceGrade1);
        WebUI.verifyElementNotVisible(spaceDomain1);
        WebUI.verifyElementAttributeValue(dropdownStandardsSearchV3, "disabled", "true");
    }

    public void checkAllFilterWhenChangeGrade(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        //7. Select domain
        selectDomain();
        // 8. Select Standards
        selectStandard301A();
        // 9. Select another Grade
        WebUI.clickElement(dropdownGradeV3);
        WebUI.sleep(5);
        WebUI.clickElement(gradeAtDropdown2);
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        // Remove domain and Grade bellow filter
        String grade5 = WebUI.getTextElement(spaceGrade2);
        WebUI.verifyContains(grade5, "Grade 5");
        WebUI.verifyElementNotVisible(spaceDomain1);
        WebUI.verifyElementNotVisible(spaceStandard1);
    }

    public void checkAllFilterWhenChangeProgram(Hashtable<String, String> data) {
         /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
           4. Select program */
        goToSearchPage();
        selectProgramInsearch();
//        5. Select StandardSet ( for WB3-8)
        selectStandardSet();
        // 6. Select Grade
        selectGrade();
        //7. Select domain
        selectDomain();
        // 8. Select Standards
        selectStandard301A();
        // 9. select another grade
        WebUI.clickElement(dropdownGradeV3);
        WebUI.sleep(5);
        WebUI.clickElement(gradeAtDropdown2);
        WebUI.sleep(5);
        // 10. Select another Program
        WebUI.clickElement(dropdownProgramSearch);
        WebUI.scrollToElementToBottom(programWLAtDropdownSearchV3);
        WebUI.clickElement(programWLAtDropdownSearchV3);
        // Remove Grade bellow filter.  Grade, Domain, Standards filter should be disabled
        WebUI.verifyElementNotVisible(spaceGrade1);
        WebUI.verifyElementNotVisible(spaceGrade2);
        WebUI.verifyElementAttributeValue(dropdownGradeV3, "disabled", "true");
        WebUI.verifyElementAttributeValue(dropdownDomainV3, "disabled", "true");
        WebUI.verifyElementAttributeValue(dropdownStandardsSearchV3, "disabled", "true");
    }

    public void checkSearchValidContent(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button */

        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        /* - Show all results contain Character entered */
        String tableText = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableText, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableText, "Creed");
        WebUI.verifyContains(tableText, "Sacraments");
        WebUI.verifyContains(tableText, "Discipleship and Virtues");
        WebUI.verifyContains(tableText, "Life in Christ");

    }

    public void checkSearchValidContentWithStandardSet(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        // 7. Select specific standard set
        selectStandardSet();
        // 8. click Search button
        WebUI.clickElement(buttonSearch);
        /* - Show all results contain Character entered */
        String tableText = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableText, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableText, "Discipleship and Virtues");
    }

    public void checkSearchValidContentWithSpecialOption(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        // 7. Select specific standard set
        selectStandardSet();
        // 8. Select grade
        selectGrade();
        // 9. Select Domain
        WebUI.clickElement(dropdownDomainV3);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(specificDomainAtDropdown5);
        WebUI.clickElement(specificDomainAtDropdown5); //Discipleship and Virtues
        // 10. Select standards 3.06.A
        WebUI.clickElement(dropdownStandardsSearchV3);
        WebUI.sleep(5);
        WebUI.clickElement(specificStandardsSearchAtDropdown5);
        WebUI.sleep(5);
        // 11. Click Search button
        WebUI.clickElement(buttonSearch);
        /* - Show all results contain Character entered */
        String tableText = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableText, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableText, "Discipleship and Virtues");
        WebUI.verifyContains(tableText, "3.06.A");
    }

    public void checkSearchSpecificResource(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        // 7. Select specific standard set
        selectStandardSet();
        WebUI.sleep(5);
        // 8. Select Resource <Instruction>
        selectTypeIntruction();
        WebUI.sleep(5);
        // 9. Click Search button
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(iconPlus);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        /* - Show Object Character entered and Resource of Instruction Resource type */
        String tableText = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableText, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableText, "Instruction");
    }

    public void checkSearchSpecificResourceStudent(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        // 7. Select specific standard set
        selectStandardSet();
        WebUI.sleep(5);
        // 8. Select Resource <Student Resource>
        selectTypeStudent();
        WebUI.sleep(5);
        // 9. Click Search button
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        /* - Show Object Character entered and Resource of Student Resource type*/
        String tableText = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableText, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableText, "Printable Activity");
    }

    public void checkSearchSpecificResourceTeacher(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        // 7. Select specific standard set
        selectStandardSet();
        // 8. Select Resource <Student Resource>
        selectTypeTeacher();
        // 9. Click Search button
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        /* - Show Object Character entered and Resource of Student Resource type*/
        WebUI.verifyElementText(tableObjectNoResult, "The search criteria did not yield any results.");
    }

    public void checkEnableClearAll(Hashtable<String, String> data) {
        /*1. Login Teacher
          2. Go to FA report
          3. Click Icon Search FA
          4. Select program
          5. Select StandardSet ( for WB3-8)
          6. Select Grade*/
        goToSearchPage();
        selectProgramInsearch();
        selectStandardSet();
        selectGrade();
        // Enable Clear ALl button
        WebUI.verifyElementAttributeValue(buttonCleanAll, "disabled", "");
    }

    public void checkClearAllButton(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Select specific standard set
        8. Select Resource <Student Resource>
        9. Select Grade
        10. Select Clear All*/
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        selectStandardSet();
        selectTypeIntruction();
        selectGrade();
        WebUI.clickElement(buttonCleanAll);
//    Expected:
//      1. All data of content in box , Grade, Resource Type should be Removed
//      2. Search Button should be disable'
//      3. Remove Standard Set fiter
//      4. Enable Program filter
//      5. Disable Grade filter'
        WebUI.verifyElementTextContains(textBox, "");
        WebUI.verifyElementNotVisible(spaceResourceType);
        WebUI.verifyElementNotVisible(spaceGrade1);
        WebUI.verifyElementAttributeValue(buttonSearch, "disabled", "true");
        WebUI.verifyElementAttributeValue(dropdownGradeV2, "disabled", "true");
        WebUI.verifyElementAttributeValue(dropdownProgramSearch, "disabled", "");
        WebUI.verifyElementNotVisible(boxStandardSet);
    }

    public void checkSearchInValid(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Select Standard Set
        8. Select Grade
        9. Select Domain
        10. Select invalid Standards
        11. Click Search button
         */
        goToSearchPage();
        selectProgramInsearch();
        selectStandardSet();
        WebUI.clickElement(dropdownDomainV3);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(specificDomainAtDropdown5);
        WebUI.clickElement(specificDomainAtDropdown5);
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, "3.06.A");
        selectStandard305A();
        WebUI.clickElement(buttonSearch);
        // Should be shown Message "The search criteria did not yield any results."
        WebUI.verifyElementTextContains(tableObjectNoResult, "The search criteria did not yield any results.");
    }

    public void checkViewResource(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button
        8. Click icon +
        9. Click View button */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        viewResource();
        // Should be moved to Resource page and breadcrumb is FullAccess> Resource
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessCustomSearchPage.url_viewresource);
        WebUI.verifyElementTextContains(breadcrumb, "Full Access>Chapter 1: God Sends Us His Own Son");

    }

    public void checkViewResourceGame(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button
        8. Click icon +
        9. Click View button */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Content");
        WebUI.setText(textBox, excelHelpers.getCellData(2, FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        viewGame();
        // Should be moved to Resource page and breadcrumb is FullAccess> Resource
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessCustomSearchPage.url_viewresource_game);
        WebUI.verifyElementTextContains(breadcrumb, "Chapter 3: Matching/Concentration");

    }

    public void checkViewResourceVideo(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button
        8. Click icon +
        9. Click View button */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Content");
        WebUI.setText(textBox, excelHelpers.getCellData(3, FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        viewVideo();
        // Should be moved to Resource page and breadcrumb is FullAccess> Resource
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessCustomSearchPage.url_viewresource_video);
        WebUI.verifyElementTextContains(breadcrumb, "Did You Know? Video: The early Christians baptized by immersion.");
    }

    public void checkBackbutton(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button
        8. Click icon +
        9. Click View button
        10. Click Back button*/
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        viewResource();
        WebUI.sleep(5);
        WebUI.clickElement(buttonBack);
        WebUI.sleep(5);
        //1. Back to Search page and keep  dropdown resource selected
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessCustomSearchPage.url_searchpage);
        String tableResource = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableResource, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableResource, "Chapter 1: God Sends Us His Own Son");

    }

    public void checkFullAccessbutton(Hashtable<String, String> data) {
        /*1. Login Teacher
        2. Go to FA report
        4. Click Search icon
        5. Select Program Series
        6. Input Valid search content
        7. Click Search button
        8. Click icon +
        9. Click View button
        10. Click Back button*/
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        viewResource();
        WebUI.clickElement(buttonFullAccess);
        WebUI.sleep(5);
        //1. Back to Search page and keep  dropdown resource selected
        WebUI.verifyContains(WebUI.getCurrentUrl(), FullAccessCustomSearchPage.url_searchpage);
        String tableResource = WebUI.getTextElement(tableObject);
        WebUI.verifyContains(tableResource, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.verifyContains(tableResource, "Chapter 1: God Sends Us His Own Son");

    }

    public void checkMessageWarning(Hashtable<String, String> data) {
        /*1. Login teacher
        2. Click Report dropdown then select icon FA
        3. Click icon Search FA
        4. Select Program at dropdown
        5. Input object at text box
        6. Click Search button
        7. Click icon +
        9. Click Create Assignment button
        * */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSearch);
        WebUI.sleep(5);
        // 7. Click icon + or skill
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        // 8. Click Create assignment button
        WebUI.scrollToElementToBottom(buttonCreateAssignment);
        WebUI.clickElement(buttonCreateAssignment);
        WebUI.sleep(5);
        // Show message " Warning! You must select at least one resource."
        WebUI.verifyElementText(alertMessage, "Warning! You must select at least one resource.");
    }

    public void checkCreateAssignment1Resource(Hashtable<String, String> data) {
        /*1. Login teacher
        2. Click Report dropdown then select icon FA
        3. Click icon Search FA
        4. Select Program at dropdown
        5. Input object at text box
        6. Click Search button
        7. Click icon +
        8. Select Resource
        9. Click Create Assignment button
        10. Select Class
        * */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(FullAccessSearchModel.getContentfa()));
        createAssignmentSingle();
        // Should be shown resource selected at box
        WebUI.verifyElementTextContains(boxResourcesInPopup1, "Chapter 1: God Sends Us His Own Son");
        saveWithNameAndClass();
        // Show message "The assignment has been created successfully."
        WebUI.verifyElementText(alertMessage, "The assignment has been created successfully.");
        // Reset data
        resetDataSingle();
    }

    public void checkCreateAssignmentMultiResource(Hashtable<String, String> data) {
        /*1. Login teacher
        2. Click Report dropdown then select icon FA
        3. Click icon Search FA
        4. Select Program at dropdown
        5. Input object at text box
        6. Click Search button
        7. Click icon +
        8. Select > 1 Resource
        9. Click Create Assignment button
        10. Select Class
        * */
        goToSearchPage();
        selectProgramInsearch();
        WebUI.clickElement(textBox);
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Content");
        WebUI.setText(textBox, excelHelpers.getCellData(2, FullAccessSearchModel.getContentfa()));
        createAssignmentMulti();
        // Should be shown resource selected at box
        WebUI.verifyElementTextContains(boxResourcesInPopup1, "Chapter 3: Christ Will Come Again");
        WebUI.verifyElementTextContains(boxResourcesInPopup2, "Chapter 3: Project Disciple");
        saveWithNameAndClass();
        // Show message "The assignment has been created successfully."
        WebUI.verifyElementText(alertMessage, "The assignment has been created successfully.");
        // Reset data
        resetDataMulti();
    }
}