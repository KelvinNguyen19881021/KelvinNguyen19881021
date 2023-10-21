package selenium.com.projects.sadlierconnect.pages.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.models.ManageClassModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class AssignmentJourneyNonISEPageSC extends CommonPageSC {

    public AssignmentJourneyNonISEPageSC() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";
    AssignmentListPageSC assignmentListPageSC = new AssignmentListPageSC();




    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By dropdownClass = By.xpath("(//div[contains(@class,'box-select-tags__input')])[1]");
    private By inputDropdownClass = By.xpath("(//input[@class='sc-fLlhyt imdpDE'])[1]");

    private By dropdownClassGroup = By.xpath("(//span[contains(text(),'- Select -')])[1]");
    private By inputDropDownClassGroup = By.xpath("(//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')])[1]");
    private By inputStartDate = By.xpath("(//input[contains(@placeholder,'Select Date')])[1]");
    private By inputDropDownStartDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[1]");
    private By inputStartHour = By.xpath("(//input[@value='08'])[1]");
    private By inputStartMinute = By.xpath("(//input[@value='00'])[1]");
    private By inputStartPeriod = By.xpath("(//input[@value='AM'])[1]");
    private By inputDueDate = By.xpath("(//input[@placeholder='Select Date'])[2]");
    private By inputDropDownDueDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[2]");
    private By inputDueHour = By.xpath("(//input[@name='hour'])[2]");
    private By inputDueMinute = By.xpath("(//input[@name='minute'])[2]");
    private By inputDuePeriod = By.xpath("(//input[@name='period'])[2]");
    private By checkboxGracePeriod = By.xpath("//b[normalize-space()='Grace Period']");
    private By inputEndDate = By.xpath("(//input[@placeholder='Select Date'])[3]");
    private By inputDropDownEndDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[3]");
    private By inputEndHour = By.xpath("(//input[@name='hour'])[3]");
    private By inputEndMinute = By.xpath("(//input[@name='minute'])[3]");
    private By inputEndPeriod = By.xpath("(//input[@name='period'])[3]");
    private By dropdownSection = By.xpath("//div[@class='section-secondary']//span[@class='ant-select-selection-item']");
    private By inputDropDownSection = By.xpath("(//input[contains(@type,'text')])[6]");
    private By inputDropDownSection2 = By.xpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
    private By buttonAddResources = By.xpath("//span[normalize-space()='+ Add Resources']");
    private By checkboxSelectAllResource = By.xpath("(//label[@class='ant-checkbox-wrapper'])[1]");
    private By unCheckboxSelectAllResource = By.xpath("(//thead[contains(@class,'ant-table-thead')]//span[contains(@class,'ant-checkbox ant-checkbox-checked')])[2]");
    private By buttonAdd = By.xpath("//span[normalize-space()='Add']");
    private By buttonCancelAddResource = By.xpath("//div[contains(@class,'modal-footer')]//span[contains(text(),'Cancel')]");
    private By labelStudentList = By.xpath("//h3[normalize-space()='Student List']");
    private By checkboxPoint = By.xpath("//span[normalize-space()='Points']");
    private By checkboxPercent = By.xpath("//span[normalize-space()='Percent']");
    private By checkboxStatus = By.xpath("//span[normalize-space()='Complete/Incomplete']");
    private By inputPoint = By.xpath("//input[@name='scoreOptions.maxPoint']");
    private By inputPercent = By.xpath("//input[@name='scoreOptions.maxPercent']");
    private By inputDirection = By.xpath("//textarea[@name='direction']");
    private By checkboxSubmissionAnnotation = By.xpath("//span[normalize-space()='Require submission of annotations.']");
    private By checkboxUploadStudent = By.xpath("//span[normalize-space()='Require student upload.']");
    private By buttonSave = By.xpath("//span[normalize-space()='Save']");
    private By buttonCancel = By.xpath("//span[normalize-space()='Cancel']");
    private By checkboxAllStudent = By.xpath("//div[@class='ant-table-selection']//input[@type='checkbox']");
    private By labelGradeChapter = By.xpath("//span[@class='toc-title-data']");
    private By labelAvailableAnswer = By.xpath("(//label[normalize-space()='AVAILABLE ANSWERS'])[1]");
    private By labelScoringOption = By.xpath("(//span[normalize-space()='SCORING OPTIONS'])[1]");
    private By dropdownNumberChoice = By.xpath("(//span[contains(text(),'Show All Choices')])[1]");
    private By checkboxScrambleQuestion = By.xpath("//span[normalize-space()='Scramble Questions']");
    private By checkboxExcludeData = By.xpath("//span[normalize-space()='Exclude assignment data from reports and alerts']");
    private By checkboxParentAssignment = By.xpath("//p[@class='checkbox-text']");
    private By inputSearch = By.xpath("//input[contains(@placeholder,'Search Assignment List')]");
    private final By inputPassCode = By.xpath("//input[@id='passcode']");
    private final By inputPassWord = By.xpath("//input[@id='password']");
    private final By inputUserName = By.xpath("//input[@id='username']");
    private final By buttonLogin = By.xpath("//button[@type='button']");
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    private By labelStudent = By.xpath("//h1[normalize-space()='Hi stu! Welcome back.']");
    private By labelAssignmentListOfStudent = By.xpath("//a[@href='/assignments']//span[@class='badge-group']");
    private By noRecordMessage = By.xpath("//div[@class='text-left']");
    private By notFillClassMessage = By.xpath("//div[@class='sc-idiyUo BfNuV']");
    private By messageInvalidTime = By.xpath("//div[@class='ant-modal-confirm-content']");
    private By messagePoint = By.xpath("//span[@class='error-message']");
    private By messagePercent = By.xpath("//span[@class='error-message']");
    private By messageFutureTime = By.xpath("//div[@class='ant-modal-confirm-content']");
    private By buttonSubmitFutureTime = By.xpath("//span[normalize-space()='Submit']");
    private By iconAssignInResource = By.xpath("//span[@title='Assign']");












    public void openAssignmentList(Hashtable<String,String> data){
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        WebUI.verifyElementTextContains(labelGradeChapter, data.get(AssignmentJourneyModel.getMenuTitle()));
        WebUI.sleep(3);
        WebUI.clickElement(menuAssignment);
        WebUI.sleep(5);

    }
    public void createAssignmentByDefault(Hashtable<String,String>myData){
        //Assignment Name
        WebUI.clearTextCtrlA(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.setText(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))),myData.get(AssignmentJourneyModel.getAssignmentName()));
        //Add class
        List <String> listClass = WebUI.splitString(myData.get(AssignmentJourneyModel.getClassName()),", ");
        for (String classItem: listClass){
            WebUI.clickElement(dropdownClass);
            WebUI.sleep(3);
            WebUI.setText(inputDropdownClass,classItem, Keys.ENTER);
            WebUI.sleep(3);
        }

        //Add group
        if (listClass.size()<2){
            if (!myData.get(AssignmentJourneyModel.getClassGroup()).equalsIgnoreCase("")){
                WebUI.clickElement(dropdownClassGroup);
                WebUI.clickElement(inputDropDownClassGroup);
                WebUI.sleep(3);
                By value =By.xpath(ObjectUtils.getXpathDynamic("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'%s')]",myData.get(AssignmentJourneyModel.getClassGroup())));
                if (WebUI.verifyElementPresent(value,10)){
                    WebUI.setText(inputDropDownClassGroup,myData.get(AssignmentJourneyModel.getClassGroup()));
                    WebUI.sleep(3);
                    WebUI.pressENTER();
                }
            }
        }

        //Add start date and time
        WebUI.clickElement(inputStartDate);
        WebUI.setCtrlAThenFillText(inputStartDate,WebUI.getDateOfCurrentWeekByTimeZone());
        WebUI.pressENTER();
        WebUI.clickElement(inputDropDownStartDate);

        List<String> timeStart = WebUI.splitString(myData.get(AssignmentJourneyModel.getStartTime())," ");

        WebUI.setCtrlAThenFillText(inputStartHour,timeStart.get(0));
        WebUI.setCtrlAThenFillText(inputStartMinute,timeStart.get(1));
        WebUI.setCtrlAThenFillText(inputStartPeriod,timeStart.get(2));


        //Add due date and time
        WebUI.clickElement(inputDueDate);
        WebUI.setCtrlAThenFillText(inputDueDate,WebUI.getDateOfCurrentWeekByTimeZone());
        WebUI.pressEnterByAction();
        WebUI.clickElement(inputDropDownDueDate);

        List<String> timeDue = WebUI.splitString(myData.get(AssignmentJourneyModel.getDueTime())," ");

        WebUI.setCtrlAThenFillText(inputDueHour,timeDue.get(0));
        WebUI.setCtrlAThenFillText(inputDueMinute,timeDue.get(1));
        WebUI.setCtrlAThenFillText(inputDuePeriod,timeDue.get(2));



        if (!myData.get(AssignmentJourneyModel.getEndDate()).equalsIgnoreCase("")){
            WebUI.clickElement(checkboxGracePeriod);
            WebUI.scrollToElementToBottom(inputEndDate);
            //Add end date and time
            WebUI.clickElement(inputEndDate);
            WebUI.setCtrlAThenFillText(inputEndDate,myData.get(AssignmentJourneyModel.getEndDate()));
            WebUI.sleep(2);
            WebUI.pressEnterByAction();

            WebUI.scrollToElementToBottom(labelStudentList);

            WebUI.sleep(2);
            WebUI.clickElement(inputDropDownEndDate);

            List<String> timesEnd = WebUI.splitString(myData.get(AssignmentJourneyModel.getEndTime())," ");
            WebUI.sleep(2);


            WebUI.setCtrlAThenFillText(inputEndHour,timesEnd.get(0));
            WebUI.setCtrlAThenFillText(inputEndMinute,timesEnd.get(1));
            WebUI.setCtrlAThenFillText(inputEndPeriod,timesEnd.get(2));

        }
        //Choose section
        WebUI.clickElement(dropdownSection);
        if (listClass.size()>=2|| myData.get(AssignmentJourneyModel.getClassGroup()).equalsIgnoreCase("")){
            WebUI.clickElement(inputDropDownSection2);
            WebUI.setText(inputDropDownSection2,myData.get(AssignmentJourneyModel.getSection()),Keys.ENTER);
            WebUI.sleep(3);
        }else {
            WebUI.clickElement(inputDropDownSection);
            WebUI.setText(inputDropDownSection,myData.get(AssignmentJourneyModel.getSection()),Keys.ENTER);
            WebUI.sleep(3);
        }

        //Choose Resource
        WebUI.clickElement(buttonAddResources);
        WebUI.sleep(5);
        WebUI.clickElement(checkboxSelectAllResource);
        WebUI.sleep(5);
        WebUI.clickElement(unCheckboxSelectAllResource);


        List<String> listResources = WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()), "; ");
        if (!myData.get(AssignmentJourneyModel.getAddResource()).equalsIgnoreCase("")) {
            for (String resourceItem : listResources) {
                if (myData.get(AssignmentJourneyModel.getEndDate()) != "") {
                    WebUI.selectedValueOnTableByColumn(2, resourceItem, "(//table)[8]/tbody/tr");
                    WebUI.sleep(5);
                } else {
                    WebUI.selectedValueOnTableByColumn(2, resourceItem, "(//table)[7]/tbody/tr");
                    WebUI.sleep(5);
                }
            }
        }


        if (myData.get(AssignmentJourneyModel.getAddResource()).equalsIgnoreCase("")){
            WebUI.scrollToElementToBottom(buttonCancelAddResource);
            WebUI.clickElement(buttonCancelAddResource);
        }else {
            WebUI.scrollToElementToBottom(buttonAdd);
            WebUI.sleep(3);
            WebUI.clickElement(buttonAdd);

        }
        //Assessment Resource
        WebUI.sleep(5);

        if (WebUI.checkElementExists(dropdownNumberChoice) ) {
            WebUI.scrollToElementToBottom(dropdownNumberChoice);
            WebUI.clickElement(dropdownNumberChoice);
            WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]", myData.get(AssignmentJourneyModel.getNumberChoice()))));
        }

        if (WebUI.checkElementExists(checkboxScrambleQuestion)) {
            WebUI.scrollToElementToBottom(checkboxScrambleQuestion);
            if (myData.get(AssignmentJourneyModel.getScrambleQuestion()).equalsIgnoreCase("Yes")) {
                WebUI.clickElement(checkboxScrambleQuestion);
            }
        }

        if (WebUI.checkElementExists(checkboxExcludeData)) {
            WebUI.scrollToElementToBottom(checkboxExcludeData);
            if (myData.get(AssignmentJourneyModel.getExcludeData()).equalsIgnoreCase("Yes")) {
                WebUI.clickElement(checkboxExcludeData);
            }
        }


        WebUI.sleep(5);

        //Static Resource
        if (WebUI.checkElementExists(labelScoringOption)){
            //Choose scoring option
            if (!myData.get(AssignmentJourneyModel.getScoringOption()).equalsIgnoreCase("")){
                WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",myData.get(AssignmentJourneyModel.getScoringOption()))));
                WebUI.sleep(2);
                WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",myData.get(AssignmentJourneyModel.getScoringOption()))));
                switch (myData.get(AssignmentJourneyModel.getScoringOption())){
                    case "Points":
                        WebUI.setText(inputPoint,myData.get(AssignmentJourneyModel.getPoint()));
                        break;

                    case "Percent":
                        WebUI.setText(inputPercent,myData.get(AssignmentJourneyModel.getPoint()));
                        break;
                }
            }
        }



        //Enter Direction
        WebUI.scrollToElementToBottom(labelStudentList);
        WebUI.sleep(2);

        WebUI.setText(inputDirection,myData.get(AssignmentJourneyModel.getDirection()));

        WebUI.sleep(5);
        if (listResources.size() >=2){
            WebUI.scrollToElementToBottom(checkboxParentAssignment);
            if (myData.get(AssignmentJourneyModel.getPartAssignment()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxParentAssignment);
            }
        }

        //Choose option
        WebUI.scrollToElementToBottom(labelStudentList);
        WebUI.sleep(2);
        if (WebUI.isElementVisible(checkboxSubmissionAnnotation,3)){
            WebUI.scrollToElementToBottom(checkboxSubmissionAnnotation);

            if (myData.get(AssignmentJourneyModel.getSubmissionAnnotations()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxSubmissionAnnotation);
                WebUI.sleep(3);
            }
        }
        if (WebUI.isElementVisible(checkboxUploadStudent,3)){
            WebUI.scrollToElementToBottom(checkboxUploadStudent);

            if (myData.get(AssignmentJourneyModel.getStudentUpload()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxUploadStudent);
                WebUI.sleep(3);
            }
        }

        //Choose student
        WebUI.scrollToElementToBottom(checkboxAllStudent);
        WebUI.sleep(3);
        WebUI.scrollToElementToTop(buttonSave);
        WebUI.clickElement(checkboxAllStudent);
        WebUI.sleep(3);

        int indexNumberOfStudent = Integer.parseInt(myData.get(AssignmentJourneyModel.getTotalNumberOfStudentInAssignment()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent1()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent2()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent3()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent4()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent5()));

        for (int i =0;i< indexNumberOfStudent;i++){
            WebUI.chooseStudentInCreateAssignment(3,listStudent.get(i),"(//table)[4]/tbody/tr");
            WebUI.scrollToElementToBottom(buttonSave);
            WebUI.sleep(3);
        }
        WebUI.sleep(5);
        WebUI.scrollToElementToTop(buttonSave);


    }
    public void createAssignment(Hashtable<String,String>myData){
        //Assignment Name
        WebUI.clearTextCtrlA(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.setText(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))),myData.get(AssignmentJourneyModel.getAssignmentName()));
        //Add class
        List <String> listClass = WebUI.splitString(myData.get(AssignmentJourneyModel.getClassName()),", ");
        for (String classItem: listClass){
            WebUI.clickElement(dropdownClass);
            WebUI.sleep(3);
            WebUI.setText(inputDropdownClass,classItem, Keys.ENTER);
            WebUI.sleep(3);
        }



        //Add group
        if (listClass.size()<2){
            if (!myData.get(AssignmentJourneyModel.getClassGroup()).equalsIgnoreCase("")){
                WebUI.clickElement(dropdownClassGroup);
                WebUI.clickElement(inputDropDownClassGroup);
                WebUI.sleep(3);
                By value =By.xpath(ObjectUtils.getXpathDynamic("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'%s')]",myData.get(AssignmentJourneyModel.getClassGroup())));
                if (WebUI.verifyElementPresent(value,10)){
                    WebUI.setText(inputDropDownClassGroup,myData.get(AssignmentJourneyModel.getClassGroup()));
                    WebUI.sleep(3);
                    WebUI.pressENTER();
                }
            }
        }

        //Add start date and time
        WebUI.clickElement(inputStartDate);
        WebUI.setCtrlAThenFillText(inputStartDate,myData.get(AssignmentJourneyModel.getStartDate()));
        WebUI.pressENTER();
        WebUI.clickElement(inputDropDownStartDate);

        List<String> timeStart = WebUI.splitString(myData.get(AssignmentJourneyModel.getStartTime())," ");

        WebUI.setCtrlAThenFillText(inputStartHour,timeStart.get(0));
        WebUI.setCtrlAThenFillText(inputStartMinute,timeStart.get(1));
        WebUI.setCtrlAThenFillText(inputStartPeriod,timeStart.get(2));


        //Add due date and time
        WebUI.clickElement(inputDueDate);
        WebUI.setCtrlAThenFillText(inputDueDate,myData.get(AssignmentJourneyModel.getDueDate()));
        WebUI.pressEnterByAction();
        WebUI.clickElement(inputDropDownDueDate);

        List<String> timeDue = WebUI.splitString(myData.get(AssignmentJourneyModel.getDueTime())," ");

        WebUI.setCtrlAThenFillText(inputDueHour,timeDue.get(0));
        WebUI.setCtrlAThenFillText(inputDueMinute,timeDue.get(1));
        WebUI.setCtrlAThenFillText(inputDuePeriod,timeDue.get(2));



        if (!myData.get(AssignmentJourneyModel.getEndDate()).equalsIgnoreCase("")){
            WebUI.clickElement(checkboxGracePeriod);
            WebUI.scrollToElementToBottom(inputEndDate);
            //Add end date and time
            WebUI.clickElement(inputEndDate);
            WebUI.setCtrlAThenFillText(inputEndDate,myData.get(AssignmentJourneyModel.getEndDate()));
            WebUI.sleep(2);
            WebUI.pressEnterByAction();

            WebUI.sleep(2);
            WebUI.clickElement(inputDropDownEndDate);

            List<String> timesEnd = WebUI.splitString(myData.get(AssignmentJourneyModel.getEndTime())," ");
            WebUI.sleep(2);

            WebUI.scrollToElementToBottom(inputEndHour);
            WebUI.setCtrlAThenFillText(inputEndHour,timesEnd.get(0));
            WebUI.setCtrlAThenFillText(inputEndMinute,timesEnd.get(1));
            WebUI.setCtrlAThenFillText(inputEndPeriod,timesEnd.get(2));

        }
        //Choose section
        WebUI.clickElement(dropdownSection);
        if (listClass.size()>=2|| myData.get(AssignmentJourneyModel.getClassGroup()).equalsIgnoreCase("")){
            WebUI.clickElement(inputDropDownSection2);
            WebUI.setText(inputDropDownSection2,myData.get(AssignmentJourneyModel.getSection()),Keys.ENTER);
            WebUI.sleep(3);
        }else {
            WebUI.clickElement(inputDropDownSection);
            WebUI.setText(inputDropDownSection,myData.get(AssignmentJourneyModel.getSection()),Keys.ENTER);
            WebUI.sleep(3);
        }

        //Choose Resource
        WebUI.clickElement(buttonAddResources);
        WebUI.sleep(5);
        WebUI.clickElement(checkboxSelectAllResource);
        WebUI.sleep(5);
        WebUI.clickElement(unCheckboxSelectAllResource);


        List<String> listResources = WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()), "; ");
        if (!myData.get(AssignmentJourneyModel.getAddResource()).equalsIgnoreCase("")) {
            for (String resourceItem : listResources) {
                if (myData.get(AssignmentJourneyModel.getEndDate()) != "") {
                    WebUI.selectedValueOnTableByColumn(2, resourceItem, "(//table)[8]/tbody/tr");
                    WebUI.sleep(5);
                } else {
                    WebUI.selectedValueOnTableByColumn(2, resourceItem, "(//table)[7]/tbody/tr");
                    WebUI.sleep(5);
                }
            }
        }


        if (myData.get(AssignmentJourneyModel.getAddResource()).equalsIgnoreCase("")){
            WebUI.scrollToElementToBottom(buttonCancelAddResource);
            WebUI.clickElement(buttonCancelAddResource);
        }else {
            WebUI.scrollToElementToBottom(buttonAdd);
            WebUI.sleep(3);
            WebUI.clickElement(buttonAdd);

        }
        //Assessment Resource
        WebUI.sleep(5);

        if (WebUI.checkElementExists(labelAvailableAnswer) ) {
            WebUI.scrollToElementToTop(labelAvailableAnswer);
            WebUI.clickElement(dropdownNumberChoice);
            WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]", myData.get(AssignmentJourneyModel.getNumberChoice()))));
        }

        if (WebUI.checkElementExists(checkboxScrambleQuestion)) {
            WebUI.scrollToElementToTop(checkboxScrambleQuestion);
            if (myData.get(AssignmentJourneyModel.getScrambleQuestion()).equalsIgnoreCase("Yes")) {
                WebUI.clickElement(checkboxScrambleQuestion);
            }
        }

        if (WebUI.checkElementExists(checkboxExcludeData)) {
            WebUI.scrollToElementToTop(checkboxExcludeData);
            if (myData.get(AssignmentJourneyModel.getExcludeData()).equalsIgnoreCase("Yes")) {
                WebUI.clickElement(checkboxExcludeData);
            }
        }


        WebUI.sleep(5);

        //Static Resource
        if (WebUI.checkElementExists(labelScoringOption)){
            //Choose scoring option
            if (!myData.get(AssignmentJourneyModel.getScoringOption()).equalsIgnoreCase("")){
                WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",myData.get(AssignmentJourneyModel.getScoringOption()))));
                WebUI.sleep(2);
                WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']",myData.get(AssignmentJourneyModel.getScoringOption()))));
                switch (myData.get(AssignmentJourneyModel.getScoringOption())){
                    case "Points":
                        WebUI.setText(inputPoint,myData.get(AssignmentJourneyModel.getPoint()));
                        break;

                    case "Percent":
                        WebUI.setText(inputPercent,myData.get(AssignmentJourneyModel.getPoint()));
                        break;
                }
            }
        }



        //Enter Direction
        WebUI.scrollToElementToBottom(labelStudentList);
        WebUI.sleep(2);

        WebUI.setText(inputDirection,myData.get(AssignmentJourneyModel.getDirection()));

        WebUI.sleep(5);
        if (listResources.size() >=2){
            WebUI.scrollToElementToBottom(checkboxParentAssignment);
            if (myData.get(AssignmentJourneyModel.getPartAssignment()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxParentAssignment);
            }
        }

        //Choose option
        WebUI.scrollToElementToBottom(labelStudentList);
        WebUI.sleep(2);
        if (WebUI.isElementVisible(checkboxSubmissionAnnotation,3)){
            WebUI.scrollToElementToBottom(checkboxSubmissionAnnotation);

            if (myData.get(AssignmentJourneyModel.getSubmissionAnnotations()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxSubmissionAnnotation);
                WebUI.sleep(3);
            }
        }
        if (WebUI.isElementVisible(checkboxUploadStudent,3)){
            WebUI.scrollToElementToBottom(checkboxUploadStudent);

            if (myData.get(AssignmentJourneyModel.getStudentUpload()).equalsIgnoreCase("Yes")){
                WebUI.clickElement(checkboxUploadStudent);
                WebUI.sleep(3);
            }
        }

        //Choose student
        WebUI.scrollToElementToBottom(checkboxAllStudent);
        WebUI.sleep(3);
        WebUI.scrollToElementToTop(buttonSave);
        WebUI.clickElement(checkboxAllStudent);
        WebUI.sleep(3);

        int indexNumberOfStudent = Integer.parseInt(myData.get(AssignmentJourneyModel.getTotalNumberOfStudentInAssignment()));
        List<String> listStudent = new ArrayList<>();
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent1()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent2()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent3()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent4()));
        listStudent.add(myData.get(ManageClassModel.getLastNameStudent5()));

        for (int i =0;i< indexNumberOfStudent;i++){
            WebUI.chooseStudentInCreateAssignment(3,listStudent.get(i),"(//table)[4]/tbody/tr");
            WebUI.scrollToElementToBottom(buttonSave);
            WebUI.sleep(3);
        }
        WebUI.sleep(5);
        WebUI.scrollToElementToTop(buttonSave);


    }
    public void createAssignmentNonISESuccessByDefault(Hashtable<String, String> myData) {
        createAssignmentByDefault(myData);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSave);
    }
    public void createAssignmentNonISESuccess(Hashtable<String, String> myData) {
        createAssignment(myData);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSave);
    }
    public void createAssignmentSuccessAndCheckOption(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.sleep(3);
        WebUI.verifyElementNotVisible(checkboxSubmissionAnnotation);

        WebUI.sleep(3);
        WebUI.clickElement(buttonSave);
    }

    public void cancelCreateAssignmentSuccess(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.clickElement(buttonSave);
    }

    public void createAssignmentUnSuccessWithNotFillData(Hashtable<String,String> myData) {
        //Assignment Name
        WebUI.clearTextCtrlA(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.setText(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))),myData.get(AssignmentJourneyModel.getAssignmentName()));
        WebUI.scrollToElementToBottom(buttonSave);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSave);
    }

    public void searchAssignmentList(Hashtable<String,String> myData){
        WebUI.sleep(5);
        WebUI.clearTextCtrlA(inputSearch);
        WebUI.setText(inputSearch,myData.get(AssignmentJourneyModel.getAssignmentName()),Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);

    }
    public void verifyCancelCreateAssignmentInTeacherRole(Hashtable<String,String> myData) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        WebUI.verifyElementExists(iconAssignInResource);

        WebUI.clickElement(menuAssignment);
        WebUI.sleep(5);

        searchAssignmentList(myData);
        WebUI.verifyElementTextContains(noRecordMessage, myData.get(AssignmentJourneyModel.getErrorMessage()));

    }
    public void verifyCreateAssignmentUnSuccessWithNotFillData(Hashtable<String,String> myData) {
        WebUI.verifyElementText(notFillClassMessage, myData.get(AssignmentJourneyModel.getErrorMessage()));

    }
    public void verifyCreateAssignmentUnSuccessWithPopUp(Hashtable<String,String> myData) {
        WebUI.verifyElementText(messageInvalidTime, myData.get(AssignmentJourneyModel.getErrorMessage()));
    }
    public void verifyCreateAssignmentUnSuccessWithPoint(Hashtable<String,String> myData) {
        WebUI.verifyElementText(messagePoint, myData.get(AssignmentJourneyModel.getErrorMessage()));
    }

    public void createAssignmentWithFutureTime(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.clickElement(buttonSave);

        if (WebUI.verifyElementTextContains(messageFutureTime,myData.get(AssignmentJourneyModel.getSuccessMessage()))){
            WebUI.clickElement(buttonSubmitFutureTime);
            WebUI.sleep(5);
        }

    }
    public void verifyCreateAssignmentWithFutureTimeInStudentRole(Hashtable<String,String> myData) {
        //login student by excel file
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "LoginAssignment");
        WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);

        WebUI.setText(inputPassCode,  excelHelpers.getCellData(6,LoginModel.getPassCode()));
        WebUI.setText(inputUserName, excelHelpers.getCellData(6, LoginModel.getUserName()));
        WebUI.setText(inputPassWord, excelHelpers.getCellData(6, LoginModel.getPassWord()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        WebUI.verifyElementTextContains(labelStudent,"Welcome back");
        WebUI.sleep(5);
        List<String > listResources= WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()),"; ");
        for (String resourceItem : listResources) {

/*
            //verify assignment in tab "Assignments"
            WebUI.checkContainsValueOnTableByColumnWithDivAndSpanAssignmentList(1, 2, resourceItem, "(//table)[1]/tbody/tr");
            WebUI.checkContainsValueOnTableByColumn(2, dateTime, "(//table)[1]/tbody/tr");
            WebUI.checkContainsValueOnTableByColumnWithDivAndSpanAssignmentList(3, 1, "Not Started", "(//table)[1]/tbody/tr");
*/
            String resourceTitle=new String();
            resourceTitle= myData.get(AssignmentJourneyModel.getSection())+": "+ resourceItem;

            //verify assignment in assignment list tab
            WebUI.clickElement(labelAssignmentListOfStudent);

            WebUI.sleep(5);
            WebUI.clearTextCtrlA(inputSearch);
            WebUI.setText(inputSearch,resourceTitle,Keys.ENTER);
            WebUI.waitForPageLoaded();
            WebUI.sleep(3);

            WebUI.verifyElementTextContains(noRecordMessage,myData.get(AssignmentJourneyModel.getErrorMessage()));
            break;

        }
    }
    public void createAssignmentWithMoreTime(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.clickElement(buttonSave);
        WebUI.checkContainsValueOnTableByColumn(5,"Assigned","(//table)[4]/tbody/tr" );

        if (WebUI.verifyElementTextContains(messageFutureTime,myData.get(AssignmentJourneyModel.getSuccessMessage()))){
            WebUI.clickElement(buttonSubmitFutureTime);
            WebUI.sleep(5);
        }

    }



    public void verifyCreateAssignmentNonISEInTeacherRoleWithDefault(Hashtable<String, String> myData){
        openAssignmentList(myData);
        searchAssignmentList(myData);
        List <String> listClass = WebUI.splitString(myData.get(AssignmentJourneyModel.getClassName()),", ");
        for (String classItem: listClass) {
            WebUI.checkContainsValueOnTableByColumn(1, myData.get(AssignmentJourneyModel.getAssignmentName()));
            WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 1, WebUI.formatDateToMMDDYY(WebUI.getDateOfCurrentWeekByTimeZone()));
            WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getStartTime())));

            WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 1, WebUI.formatDateToMMDDYY(WebUI.getDateOfCurrentWeekByTimeZone()));
            WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getDueTime())));

            if (!myData.get(AssignmentJourneyModel.getEndDate()).equalsIgnoreCase("")) {
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 1, WebUI.formatDateToMMDDYY(myData.get(AssignmentJourneyModel.getEndDate())));
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getEndTime())));

            }

            List<String> listResources = WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()), "; ");

            if (listResources.size() < 2) {
                WebUI.checkContainsValueOnTableByConflictTable(1, 5, myData.get(AssignmentJourneyModel.getStatusOfAssignment()));
                WebUI.checkContainsValueOnTableByConflictTable(1, 6, classItem);
            }
            else {
                WebUI.checkContainsValueOnTableByConflictTable(1, 6, classItem);
            }
        }

    }


}
