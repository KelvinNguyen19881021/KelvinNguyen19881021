package selenium.com.projects.sadlierconnect.pages.ManageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.ManageClassModel;
import selenium.com.projects.sadlierconnect.models.MyAccountModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.LogUtils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;



public class ManageClassesPageSC extends CommonPageSC {

    public ManageClassesPageSC() {
        super();
    }
    private  final By labelManageClass = By.xpath("(//h1[normalize-space()='Manage Classes'])[1]");

    private  final By labelAddClass = By.xpath("//div[@id='rc_unique_1']");
    private  final By buttonAddClass = By.xpath("//span[normalize-space()='+ Add Class']");
    private  final By inputClassName = By.xpath("//input[@placeholder='Enter class name']");
    private static final By dropdownSubject = By.xpath("(//div[contains(@class,'ant-select-selector')])[1]");
    private  final By inputDropdownSubject = By.xpath("//input[@class='ant-input sc-ezWOiH hmYkqp']");
    private  final By dropdownGrade = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[2]");
    private  final By inputDropdownGrade = By.xpath("(//input[contains(@type,'text')])[4]");
    private  final By inputSearch=By.xpath("//input[@placeholder='Search for Class']");


    private  final By inputClassCode = By.xpath("(//input[@placeholder='Enter class code'])[1]");
    private  final By buttonClosePopup = By.xpath("//span[@class='ant-modal-close-x']//*[name()='svg']");
    private  final By buttonSaveAndUpdateStudent = By.xpath("(//button[@type='button'])[3]");
    private  final By buttonSave = By.xpath("//span[normalize-space()='Save']");
    private  final By buttonCancel = By.xpath("//span[normalize-space()='Cancel']");
    private  final By messageErrorDupClassName = By.xpath("(//span[normalize-space()='Class Name is duplicated.'])[1]");
    private  final By messageErrorRequiredClassName = By.xpath("(//span[normalize-space()='This field is required.'])[1]");

    private  final By messageSuccessAddClassName = By.xpath("(//div[@class='ant-alert-message'])[1]");
    private  final By messageSuccessDeleteClassName = By.xpath("(//div[@class='ant-alert-message'])[1]");


    private  final By buttonUpdateStudentInClass = By.xpath("//span[normalize-space()='Update Students in Class']");
    private  final By iconEditClass = By.xpath("(//*[name()='svg'])[95]");
    private  final By dropdownGradeInFilter = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[1]");
    private  final By dropdownShowInFilter = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[2]");
    private  final By inputDropdownGradeInFilter = By.xpath("(//input[contains(@type,'text')])[2]");
    private  final By inputDropdownShowInFilter = By.xpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
    private  final By inputLastNameShowInFilter = By.xpath("(//input[@name='lastName'])[1]");
    private  final By buttonApplyFilter = By.xpath("//span[normalize-space()='Apply Filter']");
    private  final By checkboxChooseStudent = By.xpath("(//input[contains(@type,'checkbox')])[1]");
    private  final By buttonOkConfirm = By.xpath("(//span[normalize-space()='OK'])[1]");
    private  final By buttonCancelConfirm = By.xpath("(//span[normalize-space()='Cancel'])[1]");
    private  final By iconPencil = By.xpath("(//*[name()='svg'])[20]");
    private  final By iconEditClassInManageClass = By.xpath("(//span[normalize-space()='Edit Class'])[1]");

    //Delete class
    private  final By iconDeleteClassInManageClass = By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-disabled ant-dropdown-menu-item-only-child action-group__drop-down-item']");
    private  final By buttonDeleteClass = By.xpath("(//span[normalize-space()='Delete the Class'])[1]");
    private  final By labelDeleteClass = By.xpath("//span[contains(text(),'Delete Class')]");
    private  final By buttonCancelDeleteClass = By.xpath("//button[@class='ant-btn ant-btn-default']");
    private  final By buttonDelete = By.xpath("(//span[normalize-space()='Delete'])[1]");
    private  final By buttonCancelConfirmDelete = By.xpath("(//span[normalize-space()='Cancel'])[1]");

    // Manage Group
    private  final By iconManageGroupInManageClass = By.xpath("(//span[contains(text(),'Manage Groups')])[1]");
    private  final By buttonAddGroup = By.xpath("//span[normalize-space()='Add Group']");
    private  final By iconPencilEditGroup = By.xpath("(//*[name()='svg'])[108]");
    private  final By iconPencilDeleteGroup = By.xpath("(//*[name()='svg'])[109]");
    private  final By iconPencilEditGroupName = By.xpath("//div[@class='name-dp']//div//*[name()='svg']");
    private  final By inputEditGroupName = By.xpath("//input[@name='groupName']");
    private  final By buttonSaveEditGroupName = By.xpath("(//button[contains(@type,'button')])[3]");
    private  final By unCheckboxAllStudentEditGroup = By.xpath("//input[contains(@aria-checked,'mixed')]");
    private  final By checkboxAllStudentEditGroup = By.xpath("(//input[contains(@type,'checkbox')])[1]");




    private  final By inputGroupName = By.xpath("(//input[@name='groupName'])[1]");

    private  final By buttonSaveGroup = By.xpath("(//span[normalize-space()='Save'])[1]");
    private  final By buttonSaveAndAddStudentGroup = By.xpath("(//span[normalize-space()='Save and Add Students to Group'])[1]");
    private  final By buttonCancelAddGroup = By.xpath("(//button[@class='ant-btn ant-btn-secondary sc-gsnTZi fbVUE'])[1]");
    private  final By buttonUpdateStudentInGroup = By.xpath("(//span[normalize-space()='Update Students in Group'])[1]");
    private  final By buttonCancelUpdateStudentInGroup = By.xpath("(//span[normalize-space()='Cancel'])[1]");
    private final By buttonSubmitUpdateStudentInGroup = By.xpath("(//span[normalize-space()='Submit'])[1]");
    private  final By buttonOkConfirmDeleteGroup = By.xpath("//button[@class='ant-btn ant-btn-primary']");
    private  final By buttonCancelConfirmDeleteGroup = By.xpath("//button[@class='ant-btn ant-btn-default']");
    private  final By messageErrorDupGroupName = By.xpath("(//span[normalize-space()='Group Name is duplicated.'])[1]");
    private final By messageErrorRequiredGroupName = By.xpath("(//span[normalize-space()='This field is required.'])[1]");


//Manage Licenses
    private final By iconManageLicenseInManageClass = By.xpath("(//span[contains(text(),'Manage Licenses')])[1]");
    private final By tabSeatLicense = By.xpath("//div[@class='tab-pane active']");
    private final By tabSiteLicense = By.xpath("//div[@class='tab-pane']");
    private final By dropdownSiteLicense = By.xpath("//span[@class='ant-select-selection-item']");
    private final By inputDropdownSiteLicense = By.xpath("//input[@class='ant-input sc-ezWOiH hmYkqp']");
    private final By buttonApplyFilterManageLicense = By.xpath("//span[normalize-space()='Apply Filter']");


    private  final By iconViewRoster = By.xpath("(//*[name()='svg'])[22]");
    private  final By iconMessage = By.xpath("(//*[name()='svg'])[25]");
    private  final By inputSubject = By.xpath("//input[@name='subject']");
    private  final By inputContent = By.xpath("//div[@role='textbox']");
    private  final By buttonSendMessage = By.xpath("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    private  final By buttonCancelMessage = By.xpath("//button[normalize-space()='Cancel']");
    private  final By errorSubjectMessage = By.xpath("//span[normalize-space()='This field is required.']");








    //Open Manage Clas
    public void openManageClassPageSC() {
        WebUI.sleep(5);
        WebUI.clickElement(CommonPageSC.iconManagement);
        WebUI.clickElement(CommonPageSC.labelManageClass);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }
    //Open Add Class
    public void openAddClassPopupSC() {
        WebUI.clickElement(buttonAddClass);
        WebUI.sleep(5);
    }

    //Open Send Message to Class
    public void openMessageInClassSC(Hashtable<String, String> data) {
        searchClassSC(data);
        WebUI.sleep(5);
        WebUI.clickElement(iconMessage);
        WebUI.sleep(3);
    }

    public void openEditClassPopupSC() {
        WebUI.clickElement(iconPencil);
        WebUI.clickElement(iconEditClassInManageClass);
        WebUI.sleep(5);
    }
    public void openDeleteClassPopupSC() {
        WebUI.clickElement(iconPencil);
        WebUI.clickElement(labelDeleteClass);
        WebUI.sleep(5);
    }
    public void openManageGroupOfClassPopupSC() {
        WebUI.clickElement(iconPencil);
        WebUI.clickElement(iconManageGroupInManageClass);
        WebUI.sleep(5);
    }
    public void openManageLicenseOfClassPopupSC() {
        WebUI.clickElement(iconPencil);
        WebUI.clickElement(iconManageLicenseInManageClass);
        WebUI.sleep(5);
    }
    public void closeAddClassPopupSC() {
        WebUI.clickElement(buttonClosePopup);
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
    }
    public void searchClassSC(Hashtable<String, String> MyData) {
        WebUI.clickElement(inputSearch);
        WebUI.clearTextCtrlA(inputSearch);
        WebUI.setText(inputSearch, MyData.get(ManageClassModel.getClassName()),Keys.ENTER);
        WebUI.sleep(5);
    }
    public void openManageGroupOfClassSC(Hashtable<String,String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openManageGroupOfClassPopupSC();
    }

    public void openManageLicensesOfClassSC(Hashtable<String,String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openManageLicenseOfClassPopupSC();
    }
    public void openSiteLicensesOfClassSC(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(tabSiteLicense);
    }

    public void viewClassRosterSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        WebUI.clickElement(iconViewRoster);
    }
    public void verifyViewClassRosterNoStudentSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        WebUI.checkNoRecordValueOnTableByConflictTable(4);
    }
    public void verifyViewClassRosterFiveStudentsSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        int indexNumberOfStudent = Integer.parseInt(MyData.get(ManageClassModel.getNumberOfStudentInClass()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent1InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent2InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent3InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent4InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent5InClass()));
        //Check each student in class with username
        for (int i=0;i<indexNumberOfStudent;i++){
            WebUI.checkContainsValueOnTableByConflictTable(4,4,listStudent.get(i));
        }
    }





    public void deleteClassSCSuccess(Hashtable<String,String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openDeleteClassPopupSC();
        WebUI.clickElement(buttonDeleteClass);
        WebUI.clickElement(buttonDelete);
        WebUI.sleep(5);
    }
    public void cancelDeleteClassSC(Hashtable<String,String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openDeleteClassPopupSC();
        WebUI.clickElement(buttonCancelDeleteClass);
    }
    public void verifyDeleteClassSCSuccess(Hashtable<String,String> MyData){
       WebUI.waitForPageLoaded();
       WebUI.verifyElementText(messageSuccessDeleteClassName,MyData.get(ManageClassModel.getMessageSuccess()));
    }
    public void verifyCanNotDeleteClassSC(Hashtable<String,String> MyData){
        searchClassSC(MyData);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.clickElement(iconPencil);
        ///Check disable delete class
        if (WebUI.getWebElement(iconDeleteClassInManageClass).getAttribute("aria-disabled").equals("true")){
            LogUtils.info("Delete Class is disable");
            ExtentReportManager.pass("Delete Class is disable");

        }else {
            LogUtils.info("Delete Class is enable");
            ExtentReportManager.fail("Delete Class is enable");
        }



        WebUI.checkContainsValueOnTableByColumnWithDiv(1,2,MyData.get(ManageClassModel.getClassName()));
    }
    public void verifyCancelDeleteClassSC(Hashtable<String,String> MyData){
        WebUI.checkContainsValueOnTableByColumnWithDiv(1,2,MyData.get(ManageClassModel.getClassName()));
    }

    public void editChosenClassSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openEditClassPopupSC();
        addNewClassSC(MyData);
    }
    public void editChosenClassAndStudentSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openEditClassPopupSC();
        addNewClassAndStudentSC(MyData);
        addStudentInClassSC(MyData);
    }
    public void cancelEditChosenClassSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        searchClassSC(MyData);
        openEditClassPopupSC();
        cancelAddNewClassSC(MyData);
    }
    public void sendMessageToClassSC(Hashtable<String, String> MyData){
        //send message to class
        WebUI.setText(inputSubject,MyData.get(ManageClassModel.getSubject()));
        WebUI.setText(inputContent,MyData.get(ManageClassModel.getContent()));
        WebUI.scrollToElementToBottom(buttonSendMessage);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSendMessage);
    }
    public void verifySendMessageToClassSuccessSC(Hashtable<String, String> MyData){
        WebUI.waitForPageLoaded();
        //check class name and subject of message
        WebUI.checkContainsValueOnTableByColumnWithDiv(1,1,MyData.get(ManageClassModel.getClassName()));
        WebUI.checkContainsValueOnTableByColumnWithDiv(1,2,MyData.get(ManageClassModel.getSubject()));
    }
    public void verifyErrorSendMessageToClassSC(Hashtable<String, String> MyData){
        WebUI.sleep(3);
        //Check that user does not fill subject
        WebUI.verifyElementText(errorSubjectMessage,MyData.get(ManageClassModel.getErrorMessage()));

    }





    public void addNewClassSC(Hashtable<String, String> MyData) {
        WebUI.sleep(5);
        //Check that user updates name of class
        if (MyData.get(ManageClassModel.getUpdateClassName())=="")
        {
            WebUI.setText(inputClassName, MyData.get(ManageClassModel.getClassName()));
        }
        else if (MyData.get(ManageClassModel.getUpdateClassName())!=""){
        WebUI.clearTextCtrlA(inputClassName);
        WebUI.setText(inputClassName, MyData.get(ManageClassModel.getUpdateClassName()));
        }

        //Add subject
        WebUI.sleep(5);
        WebUI.clickElement(dropdownSubject);
        WebUI.clickElement(inputDropdownSubject);
        WebUI.setText(inputDropdownSubject, MyData.get(ManageClassModel.getSubjectClass()), Keys.ENTER);

        //Add Grade
        WebUI.sleep(5);
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputDropdownGrade);
        WebUI.setText(inputDropdownGrade, MyData.get(ManageClassModel.getGradeClass()), Keys.ENTER);

        //Add class code
        WebUI.sleep(5);
        WebUI.clearTextCtrlA(inputClassCode);
        WebUI.setText(inputClassCode, MyData.get(ManageClassModel.getClassCode()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSave);
    }
    public void addNewClassAndStudentSC(Hashtable<String, String> MyData) {
        WebUI.sleep(5);

        //Check that user updates name of class
        if (MyData.get(ManageClassModel.getUpdateClassName())=="")
        {
            WebUI.setText(inputClassName, MyData.get(ManageClassModel.getClassName()));
        }
        else if (MyData.get(ManageClassModel.getUpdateClassName())!=""){
            WebUI.clearTextCtrlA(inputClassName);
            WebUI.setText(inputClassName, MyData.get(ManageClassModel.getUpdateClassName()));
        }

        //Add subject
        WebUI.sleep(5);
        WebUI.clickElement(dropdownSubject);
        WebUI.clickElement(inputDropdownSubject);
        WebUI.setText(inputDropdownSubject, MyData.get(ManageClassModel.getSubjectClass()), Keys.ENTER);

        //Add Grade
        WebUI.sleep(5);
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputDropdownGrade);
        WebUI.setText(inputDropdownGrade, MyData.get(ManageClassModel.getGradeClass()), Keys.ENTER);

        //Add Class Code
        WebUI.sleep(5);
        WebUI.clearTextCtrlA(inputClassCode);
        WebUI.setText(inputClassCode, MyData.get(ManageClassModel.getClassCode()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSaveAndUpdateStudent);
    }
    public void cancelAddNewClassSC(Hashtable<String, String> MyData) {

        //Check that user updates name of class
        if (MyData.get(ManageClassModel.getUpdateClassName())=="")
        {
            WebUI.setText(inputClassName, MyData.get(ManageClassModel.getClassName()));
        }
        else if (MyData.get(ManageClassModel.getUpdateClassName())!=""){
            WebUI.clearTextCtrlA(inputClassName);
            WebUI.setText(inputClassName, MyData.get(ManageClassModel.getUpdateClassName()));
        }

        //Add Subject
        WebUI.sleep(5);
        WebUI.clickElement(dropdownSubject);
        WebUI.clickElement(inputDropdownSubject);
        WebUI.setText(inputDropdownSubject, MyData.get(ManageClassModel.getSubjectClass()), Keys.ENTER);

        //Add Grade
        WebUI.sleep(5);
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputDropdownGrade);
        WebUI.setText(inputDropdownGrade, MyData.get(ManageClassModel.getGradeClass()), Keys.ENTER);

        //Add Class Code
        WebUI.sleep(5);
        WebUI.clearTextCtrlA(inputClassCode);
        WebUI.setText(inputClassCode, MyData.get(ManageClassModel.getClassCode()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonCancel);
    }
    public void verifyCancelAddNewClassSC(Hashtable<String, String> MyData) {
        WebUI.sleep(5);
       WebUI.verifyElementExists(labelManageClass);
    }
    public void addStudentInClassSC(Hashtable<String, String> MyData) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
       int indexNumberOfStudent = Integer.parseInt(MyData.get(ManageClassModel.getNumberOfStudentInClass()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(MyData.get(ManageClassModel.getLastNameStudent1()));
        listStudent.add(MyData.get(ManageClassModel.getLastNameStudent2()));
        listStudent.add(MyData.get(ManageClassModel.getLastNameStudent3()));
        listStudent.add(MyData.get(ManageClassModel.getLastNameStudent4()));
        listStudent.add(MyData.get(ManageClassModel.getLastNameStudent5()));

        if (!MyData.get(ManageClassModel.getUpdateClassName()).equalsIgnoreCase("")){
        WebUI.clickElement(checkboxChooseStudent);

        }

        //Filter student to add
        WebUI.clickElement(dropdownShowInFilter);
        WebUI.clearTextCtrlA(inputDropdownShowInFilter);

        WebUI.clickElement(inputDropdownShowInFilter);
        WebUI.setText(inputDropdownShowInFilter, "All students",Keys.ENTER);

        for (int i =0;i< indexNumberOfStudent;i++){
            WebUI.sleep(3);
            WebUI.clearTextCtrlA(inputLastNameShowInFilter);
            WebUI.setText(inputLastNameShowInFilter,listStudent.get(i));
            WebUI.clickElement(buttonApplyFilter);
            WebUI.sleep(3);
            WebUI.waitForPageLoaded();
            WebUI.clickElement(checkboxChooseStudent);
        }

        WebUI.scrollToElementToBottom(buttonUpdateStudentInClass);
        WebUI.clickElement(buttonUpdateStudentInClass);
        WebUI.sleep(5);
        WebUI.clickElement(buttonOkConfirm);
    }


    public void addGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.clickElement(buttonAddGroup);
        WebUI.setText(inputGroupName,MyData.get(ManageClassModel.getGroupName()));
        WebUI.clickElement(buttonSaveGroup);

    }
    public void addGroupAndStudentSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.clickElement(buttonAddGroup);
        WebUI.setText(inputGroupName,MyData.get(ManageClassModel.getGroupName()));
        WebUI.clickElement(buttonSaveAndAddStudentGroup);
    }
    public void cancelAddGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.clickElement(buttonAddGroup);
        WebUI.setText(inputGroupName,MyData.get(ManageClassModel.getGroupName()));
        WebUI.clickElement(buttonCancelAddGroup);

    }
    public void addStudentIntoGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(5);
        int indexNumberOfStudent = Integer.parseInt(MyData.get(ManageClassModel.getNumberOfStudentInGroup()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent1InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent2InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent3InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent4InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent5InClass()));

        //Add student to group
        for (int i =0;i< indexNumberOfStudent;i++){
            WebUI.selectedValueOnTableByColumn(4,listStudent.get(i),"(//table)[3]/tbody/tr");

        }
        WebUI.clickElement(buttonUpdateStudentInGroup);
        WebUI.clickElement(buttonSubmitUpdateStudentInGroup);

    }
    public void editGroupSC(Hashtable<String,String> MyData){

        WebUI.sleep(10);
        WebUI.doActionWithValueOnTableByColumn(3,1,MyData.get(ManageClassModel.getGroupName()),3,1);
        WebUI.sleep(5);
        //Edit group name
        if(WebUI.verifyElementPresent(iconPencilEditGroupName,10)) {
            WebUI.clickElement(iconPencilEditGroupName, 5);
        }
        WebUI.waitForPageLoaded();

        WebUI.clearTextCtrlA(inputEditGroupName);
        WebUI.setText(inputEditGroupName,MyData.get(ManageClassModel.getUpdateGroupName()));
        WebUI.clickElement(buttonSaveEditGroupName);
        WebUI.sleep(5);

        //Update student to group
        if (WebUI.verifyElementPresent(unCheckboxAllStudentEditGroup,"5")){
        WebUI.clickElement(unCheckboxAllStudentEditGroup);
        }
        WebUI.sleep(3);

        WebUI.clickElement(checkboxAllStudentEditGroup);


        int indexNumberOfStudent = Integer.parseInt(MyData.get(ManageClassModel.getNumberOfStudentInGroup()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent1InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent2InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent3InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent4InClass()));
        listStudent.add(MyData.get(ManageClassModel.getUserNameStudent5InClass()));

        for (int i =0;i< indexNumberOfStudent;i++){
            WebUI.selectedValueOnTableByColumn(4,listStudent.get(i),"(//table)[3]/tbody/tr");
        }

        WebUI.clickElement(buttonUpdateStudentInGroup);
        WebUI.clickElement(buttonSubmitUpdateStudentInGroup);

    }

    public void deleteGroup(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.doActionWithValueOnTableByColumn(3,1,MyData.get(ManageClassModel.getGroupName()),3,2);
        WebUI.clickElement(buttonOkConfirmDeleteGroup);

    }
    public void cancelDeleteGroup(Hashtable<String,String> MyData){
        WebUI.sleep(5);
        WebUI.doActionWithValueOnTableByColumn(3,1,MyData.get(ManageClassModel.getGroupName()),3,2);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCancelConfirmDeleteGroup);

    }
    public void verifyCancelDeleteGroupSuccess(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.checkContainsValueOnTableByConflictTable(3,1,MyData.get(ManageClassModel.getGroupName()));

    }
    public void verifyDeleteGroupSuccess(Hashtable<String,String> MyData){
        WebUI.sleep(3);
       WebUI.searchContainsValueOnTableByConflictTableAfterDelete(3,1,MyData.get(ManageClassModel.getGroupName()));

    }
    public void verifyOpenManageClassSuccessSC(Hashtable<String, String> MyData) {
        WebUI.sleep(5);
        WebUI.verifyElementExists(labelManageClass);
    }



    public void verifyAddGroupSuccess(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.checkContainsValueOnTableByConflictTable(3,1,MyData.get(ManageClassModel.getGroupName()));
        WebUI.checkContainsValueOnTableByConflictTable(3,2,MyData.get(ManageClassModel.getNumberOfStudentInGroup()));

    }
    public void verifyUpdatedGroupSuccess(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.checkContainsValueOnTableByConflictTable(3,1,MyData.get(ManageClassModel.getUpdateGroupName()));
        WebUI.checkContainsValueOnTableByConflictTable(3,2,MyData.get(ManageClassModel.getNumberOfStudentInGroup()));

    }
    public void verifyOneSiteLicense(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.clickElement(dropdownSiteLicense);
        WebUI.clickElement(inputDropdownSiteLicense);
        WebUI.setText(inputDropdownSiteLicense,MyData.get(ManageClassModel.getDescriptionSiteLicense()),Keys.ENTER);
        WebUI.clickElement(buttonApplyFilterManageLicense);
        WebUI.checkContainsValueOnTableByConflictTable(3,1,MyData.get(ManageClassModel.getSiteLicense()));

    }
    public void verifyOneSeatLicense(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.clickElement(dropdownSiteLicense);
        WebUI.clickElement(inputDropdownSiteLicense);
        WebUI.setText(inputDropdownSiteLicense,MyData.get(ManageClassModel.getDescriptionSeatLicense()),Keys.ENTER);
        WebUI.clickElement(buttonApplyFilterManageLicense);
        WebUI.checkContainsValueOnTableByConflictTable(3,1,MyData.get(ManageClassModel.getSeatLicense()));
    }
    public void verifyNoSeatLicense(){
        WebUI.sleep(2);
        WebUI.checkNoRecordValueOnTableByConflictTable(3);
    }





    public void verifyErrorMessageAddClassSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        if (MyData.get(ManageClassModel.getErrorMessage()).equalsIgnoreCase(FrameworkConstants.REQUIRED_MESSAGE)){
            WebUI.verifyElementText(messageErrorRequiredClassName, MyData.get(ManageClassModel.getErrorMessage()));
        }
        else if(MyData.get(ManageClassModel.getErrorMessage()).equalsIgnoreCase(FrameworkConstants.DUP_CLASS_NAME_MESSAGE)){
            WebUI.verifyElementText(messageErrorDupClassName, MyData.get(ManageClassModel.getErrorMessage()));
        }
    }
    public void verifyRequiredErrorMessageAddGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.verifyElementText(messageErrorRequiredGroupName, MyData.get(ManageClassModel.getErrorMessage()));
         }
    public void verifyDupErrorMessageAddGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.verifyElementText(messageErrorDupGroupName, MyData.get(ManageClassModel.getErrorMessage()));
    }
    public void verifyCancelAddGroupSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.searchContainsValueOnTableByConflictTableAfterDelete(3,1,MyData.get(ManageClassModel.getGroupName()));
    }
    public void verifySuccessMessageAddClassSC(Hashtable<String,String> MyData){
        WebUI.sleep(3);
        WebUI.scrollToElementToTop(messageSuccessAddClassName);
        WebUI.verifyElementText(messageSuccessAddClassName, MyData.get(ManageClassModel.getMessageSuccess()));
    }


    public void checkMyClassDataValueSC(Hashtable<String, String> MyData, int column) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(inputSearch);
        WebUI.clearTextCtrlA(inputSearch);
        WebUI.setText(inputSearch, MyData.get(ManageClassModel.getClassName()),Keys.ENTER);
        switch (column){
            case 1:
                WebUI.checkContainsValueOnTableByColumnWithDiv(column,2, MyData.get(ManageClassModel.getClassName()));
                break;
            case 4:
                WebUI.checkContainsValueOnTableByColumn(column,MyData.get(ManageClassModel.getNumberOfStudentInClass()));
                break;

        }

    }





}
