package selenium.com.projects.sadlierconnect.pages.Assignments;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.PropertiesHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.models.ManageClassModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentListPageSC;
import selenium.com.utils.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class AssignmentJourneyPageSC extends CommonPageSC {

    public AssignmentJourneyPageSC() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";
    AssignmentListPageSC assignmentListPageSC = new AssignmentListPageSC();




    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    //public By dropdownClass = By.xpath("(//div[@class='sc-kgflAQ gjYPlz field-container'])[1]");
    public By dropdownClass = By.xpath("(//div[contains(@class,'box-select-tags__input')])[1]");
    public By inputDropdownClass = By.xpath("(//input[@class='sc-fLlhyt imdpDE'])[1]");

    public By dropdownClassGroup = By.xpath("(//span[contains(text(),'- Select -')])[1]");
    public By inputDropDownClassGroup = By.xpath("(//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')])[1]");
    public By inputStartDate = By.xpath("(//input[contains(@placeholder,'Select Date')])[1]");
    public By inputDropDownStartDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[1]");
    public By inputStartHour = By.xpath("(//input[@value='08'])[1]");
    public By inputStartMinute = By.xpath("(//input[@value='00'])[1]");
    public By inputStartPeriod = By.xpath("(//input[@value='AM'])[1]");
    public By inputDueDate = By.xpath("(//input[@placeholder='Select Date'])[2]");
    public By inputDropDownDueDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[2]");
    public By inputDueHour = By.xpath("(//input[@name='hour'])[2]");
    public By inputDueMinute = By.xpath("(//input[@name='minute'])[2]");
    public By inputDuePeriod = By.xpath("(//input[@name='period'])[2]");
    public By checkboxGracePeriod = By.xpath("//b[normalize-space()='Grace Period']");
    public By inputEndDate = By.xpath("(//input[@placeholder='Select Date'])[3]");
    public By inputDropDownEndDate = By.xpath("(//*[name()='svg'][@id='Layer_1'])[3]");
    public By inputEndHour = By.xpath("(//input[@name='hour'])[3]");
    public By inputEndMinute = By.xpath("(//input[@name='minute'])[3]");
    public By inputEndPeriod = By.xpath("(//input[@name='period'])[3]");
    public By dropdownSection = By.xpath("//div[@class='section-secondary']//span[@class='ant-select-selection-item']");
    public By inputDropDownSection = By.xpath("(//input[contains(@type,'text')])[6]");
    public By inputDropDownSection2 = By.xpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
    public By buttonAddResources = By.xpath("//span[normalize-space()='+ Add Resources']");
    public By checkboxSelectAllResource = By.xpath("//input[contains(@aria-checked,'mixed')]");
    public By unCheckboxSelectAllResource = By.xpath("(//input[@type='checkbox'])[11]");
    public By buttonAdd = By.xpath("//span[normalize-space()='Add']");
    public By buttonCancelAddResource = By.xpath("//div[contains(@class,'modal-footer')]//span[contains(text(),'Cancel')]");
    public By labelStudentList = By.xpath("//h3[normalize-space()='Student List']");
    public By checkboxPoint = By.xpath("//span[normalize-space()='Points']");
    public By checkboxPercent = By.xpath("//span[normalize-space()='Percent']");
    public By checkboxStatus = By.xpath("//span[normalize-space()='Complete/Incomplete']");
    public By inputPoint = By.xpath("//input[@name='scoreOptions.maxPoint']");
    public By inputPercent = By.xpath("//input[@name='scoreOptions.maxPercent']");
    public By inputDirection = By.xpath("//textarea[@name='direction']");
    public By checkboxSubmissionAnnotation = By.xpath("//span[normalize-space()='Require submission of annotations.']");
    public By checkboxUploadStudent = By.xpath("//span[normalize-space()='Require student upload.']");
    public By buttonSaveCreateAssignment = By.xpath("//span[normalize-space()='Save']");
    public By buttonCancelCreateAssignment = By.xpath("//span[normalize-space()='Cancel']");
    public By checkboxAllStudent = By.xpath("//div[@class='ant-table-selection']//input[@type='checkbox']");
    public By labelGradeChapter = By.xpath("//span[@class='toc-title-data']");
    public By labelGradeOfProduct = By.xpath("//div[@class='sc-iXxrte bOIzVL product-grade']");
    public By labelAvailableAnswer = By.xpath("(//label[normalize-space()='AVAILABLE ANSWERS'])[1]");
    public By labelScoringOption = By.xpath("(//span[normalize-space()='SCORING OPTIONS'])[1]");
    public By dropdownNumberChoice = By.xpath("(//span[contains(text(),'Show All Choices')])[1]");
    public By checkboxScrambleQuestion = By.xpath("//span[normalize-space()='Scramble Questions']");
    public By checkboxExcludeData = By.xpath("//span[normalize-space()='Exclude assignment data from reports and alerts']");
    public By checkboxParentAssignment = By.xpath("//p[@class='checkbox-text']");
    public By inputSearch = By.xpath("//input[contains(@placeholder,'Search Assignment List')]");
    private final By inputPassCode = By.xpath("//input[@id='passcode']");
    private final By inputPassWord = By.xpath("//input[@id='password']");
    private final By inputUserName = By.xpath("//input[@id='username']");
    private final By buttonLogin = By.xpath("//button[@type='button']");
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    public By labelStudent = By.xpath("//h1[normalize-space()='Hi stu! Welcome back.']");
    public By labelAssignmentListOfStudent = By.xpath("//a[@href='/assignments']//span[@class='badge-group']");
    public By noRecordMessage = By.xpath("//div[@class='text-left']");
    public By notFillClassMessage = By.xpath("(//span[normalize-space()='This field is required.'])[1]");
    public By messageInvalidTime = By.xpath("//div[@class='ant-modal-confirm-content']");
    public By messagePoint = By.xpath("//span[@class='error-message']");
    public By messagePercent = By.xpath("//span[@class='error-message']");
    public By messageFutureTime = By.xpath("//div[@class='ant-modal-confirm-content']");
    public By buttonSubmitFutureTime = By.xpath("//span[normalize-space()='Submit']");
    public By iconAssignInResource = By.xpath("//span[@title='Assign']");
    public static final String TIMEZONE_AUTOMATION_TEST = PropertiesHelpers.getValue("TIMEZONE_AUTOMATION_TEST");







    public void openAssignmentList(){

        WebUI.sleep(3);
        WebUI.clickElement(menuAssignment);
        WebUI.sleep(5);

    }
    public void createAssignment(Hashtable<String,String>myData){
        //Assignment Name
        WebUI.clearTextCtrlA(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.setText(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))),myData.get(AssignmentJourneyModel.getAssignmentName()));
        //Add class
        WebUI.sleep(3);
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
        if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getStartDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")||myData.get(AssignmentJourneyModel.getStartDate()).equals("")){
            WebUI.setCtrlAThenFillText(inputStartDate,WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST));
            WebUI.pressEnterByAction();
        }
        else {
            WebUI.setCtrlAThenFillText(inputStartDate, myData.get(AssignmentJourneyModel.getStartDate()));
            WebUI.pressEnterByAction();
        }

        WebUI.clickElement(inputDropDownStartDate);
        List<String> timeStart = WebUI.splitString(myData.get(AssignmentJourneyModel.getStartTime())," ");

        WebUI.setCtrlAThenFillText(inputStartHour,timeStart.get(0));
        WebUI.setCtrlAThenFillText(inputStartMinute,timeStart.get(1));
        WebUI.setCtrlAThenFillText(inputStartPeriod,timeStart.get(2));


        //Add due date and time
        WebUI.clickElement(inputDueDate);
        if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getDueDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")||myData.get(AssignmentJourneyModel.getDueDate()).equals("")){
            WebUI.setCtrlAThenFillText(inputDueDate,WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST));
            WebUI.pressEnterByAction();
        }
        else{
            WebUI.setCtrlAThenFillText(inputDueDate, myData.get(AssignmentJourneyModel.getDueDate()));
            WebUI.pressEnterByAction();
        }
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
            if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getEndDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")){
                WebUI.setCtrlAThenFillText(inputEndDate,WebUI.getFutureDateByTimeZone(TIMEZONE_AUTOMATION_TEST,1));
                WebUI.pressEnterByAction();
            }
            else {
                WebUI.setCtrlAThenFillText(inputEndDate, myData.get(AssignmentJourneyModel.getEndDate()));
                WebUI.pressEnterByAction();
            }
           // WebUI.sleep(2);
          //  WebUI.scrollToElementToBottom(inputDropDownEndDate);
            WebUI.clickElement(inputDropDownEndDate);

            List<String> timesEnd = WebUI.splitString(myData.get(AssignmentJourneyModel.getEndTime())," ");
            WebUI.sleep(3);
           WebUI.scrollToElementToBottom(inputEndHour);
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
        List<String> listResources = WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()), "; ");
        if (!myData.get(AssignmentJourneyModel.getResourceName()).equals(myData.get(AssignmentJourneyModel.getAddResource()))) {
            WebUI.clickElement(buttonAddResources);
            WebUI.sleep(5);
            WebUI.clickElement(checkboxSelectAllResource);
            WebUI.sleep(5);
            WebUI.clickElement(unCheckboxSelectAllResource);



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


            if (myData.get(AssignmentJourneyModel.getAddResource()).equalsIgnoreCase("")) {
                WebUI.scrollToElementToBottom(buttonCancelAddResource);
                WebUI.clickElement(buttonCancelAddResource);
            } else {
                WebUI.scrollToElementToBottom(buttonAdd);
                WebUI.sleep(3);
                WebUI.clickElement(buttonAdd);
            }
        }
        //Assessment Resource
        WebUI.sleep(5);

        if (WebUI.checkElementExists(labelAvailableAnswer) ) {
            //WebUI.sleep(1);
            WebUI.scrollToElementToTop(checkboxGracePeriod);
            WebUI.clickElement(dropdownNumberChoice);
            WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//span[contains(text(),'%s')])[1]", myData.get(AssignmentJourneyModel.getNumberChoice()))));
        }

        if (WebUI.checkElementExists(checkboxScrambleQuestion)) {
           // WebUI.scrollToElementToTop(checkboxScrambleQuestion);
            if (myData.get(AssignmentJourneyModel.getScrambleQuestion()).equalsIgnoreCase("Yes")) {
                    WebUI.clickElement(checkboxScrambleQuestion);
            }
        }

        if (WebUI.checkElementExists(checkboxExcludeData)) {
          //  WebUI.scrollToElementToTop(checkboxExcludeData);
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
        WebUI.scrollToElementToTop(buttonSaveCreateAssignment);
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
            WebUI.scrollToElementToBottom(buttonSaveCreateAssignment);
            WebUI.sleep(3);
        }
        WebUI.sleep(5);
        WebUI.scrollToElementToTop(buttonSaveCreateAssignment);


    }
    public void createAssignmentSuccess(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSaveCreateAssignment);
    }

    public void createAssignmentSuccessAndCheckOption(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.sleep(3);
        WebUI.verifyElementNotVisible(checkboxSubmissionAnnotation);

        WebUI.sleep(3);
        WebUI.clickElement(buttonSaveCreateAssignment);
    }

    public void cancelCreateAssignmentSuccess(Hashtable<String,String> myData) {
        createAssignment(myData);
        WebUI.clickElement(buttonCancelCreateAssignment);
    }

    public void createAssignmentUnSuccessWithNotFillData(Hashtable<String,String> myData) {
        //Assignment Name
        WebUI.clearTextCtrlA(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.setText(By.xpath(ObjectUtils.getXpathDynamic("//textarea[@placeholder='%s']",myData.get(AssignmentJourneyModel.getResourceName()))),myData.get(AssignmentJourneyModel.getAssignmentName()));
        WebUI.scrollToElementToBottom(buttonSaveCreateAssignment);
        WebUI.sleep(3);
        WebUI.clickElement(buttonSaveCreateAssignment);
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
        WebUI.clickElement(buttonSaveCreateAssignment);

        if (WebUI.verifyElementTextContains(messageFutureTime,myData.get(AssignmentJourneyModel.getSuccessMessage()))){
            WebUI.clickElement(buttonSubmitFutureTime);
            WebUI.sleep(5);
        }

    }

    public void createAssignmentWithMoreTime(Hashtable<String,String> myData) {
        createAssignment(myData);
        int indexNumberOfStudent1 = Integer.parseInt(myData.get(AssignmentJourneyModel.getTotalNumberOfStudentInAssignment()));

        List<String> listStudent1 = new ArrayList<>();
        listStudent1.add(myData.get(ManageClassModel.getLastNameStudent1()));
        listStudent1.add(myData.get(ManageClassModel.getLastNameStudent2()));
        listStudent1.add(myData.get(ManageClassModel.getLastNameStudent3()));
        listStudent1.add(myData.get(ManageClassModel.getLastNameStudent4()));
        listStudent1.add(myData.get(ManageClassModel.getLastNameStudent5()));

        int row=1;
        for (int i=0;i<indexNumberOfStudent1;i++) {
            WebUI.checkContainsValueOnTableByColumnCreateAssignment(row,3,5,listStudent1.get(i), "Assigned", "(//table)[4]/tbody/tr");
            row++;
        }
        WebUI.clickElement(buttonSaveCreateAssignment);

        if (WebUI.verifyElementTextContains(messageFutureTime,myData.get(AssignmentJourneyModel.getSuccessMessage()))){
            WebUI.clickElement(buttonSubmitFutureTime);
            WebUI.sleep(5);
        }

    }

    public void createAssignmentWithGroup(Hashtable<String,String> myData) throws IOException {
        createAssignment(myData);
        WebUI.verifyTestDataConflictTable(4,FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH,"GroupOfAssignment");
        WebUI.clickElement(buttonSaveCreateAssignment);
    }

    public void verifyCreateAssignmentInTeacherRole(Hashtable<String,String> myData){
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        //Verify return my library
        WebUI.verifyElementTextContains(labelGradeOfProduct, myData.get(AssignmentJourneyModel.getGradeProduct()));
        if (myData.get(AssignmentJourneyModel.getMenuTitle()).equalsIgnoreCase(myData.get(AssignmentJourneyModel.getSection())) && !myData.get(AssignmentJourneyModel.getAddResource()).equals("")){
            WebUI.verifyElementTextContains(labelGradeChapter, myData.get(AssignmentJourneyModel.getMenuTitle()));
        }else{
            WebUI.verifyElementTextContains(labelGradeChapter, myData.get(AssignmentJourneyModel.getSection()));
        }

        //Open Assignment List
        openAssignmentList();
        //Search assignment in Assignment List
        searchAssignmentList(myData);
        List <String> listClass = WebUI.splitString(myData.get(AssignmentJourneyModel.getClassName()),", ");
        for (String classItem: listClass) {
            //Verify assignment name
            WebUI.checkContainsValueOnTableByColumn(1, myData.get(AssignmentJourneyModel.getAssignmentName()));

            //Verify start date and time
            if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getStartDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")||myData.get(AssignmentJourneyModel.getStartDate()).equals("")){
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 1, WebUI.formatDateToMMDDYY(WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST)));
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 2, WebUI.formatDateToMMDDYY(WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST)));
            }else {
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 1, WebUI.formatDateToMMDDYY(myData.get(AssignmentJourneyModel.getStartDate())));
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(2, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getStartTime())));
            }
            //Verify due date and time
            if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getDueDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")||myData.get(AssignmentJourneyModel.getDueDate()).equals("")){
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 1, WebUI.formatDateToMMDDYY(WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST)));
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 2, WebUI.formatDateToMMDDYY(WebUI.getCurrentDateByTimeZone(TIMEZONE_AUTOMATION_TEST)));
            }else{
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 1, WebUI.formatDateToMMDDYY(myData.get(AssignmentJourneyModel.getDueDate())));
                WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(3, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getDueTime())));
            }
            //Verify end date and time
            if (!myData.get(AssignmentJourneyModel.getEndDate()).equalsIgnoreCase("")) {
                if (WebUI.compareWithCurrentDate(myData.get(AssignmentJourneyModel.getEndDate()),TIMEZONE_AUTOMATION_TEST).equals("isBefore")) {
                    WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 1, WebUI.formatDateToMMDDYY(WebUI.getFutureDateByTimeZone(TIMEZONE_AUTOMATION_TEST,1)));
                    WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 2, WebUI.formatDateToMMDDYY(WebUI.getFutureDateByTimeZone(TIMEZONE_AUTOMATION_TEST,1)));
                }else {
                    WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 1, WebUI.formatDateToMMDDYY(myData.get(AssignmentJourneyModel.getEndDate())));
                    WebUI.checkContainsValueOnTableByColumnWithDupSpanAssignmentList(4, 2, WebUI.formatTimeToHHMMPP(myData.get(AssignmentJourneyModel.getEndTime())));
                }
            }

            List<String> listResources = WebUI.splitString(myData.get(AssignmentJourneyModel.getAddResource()), "; ");
            if (listResources.size() < 2) {
                //Verify status
                WebUI.checkContainsValueOnTableByConflictTable(1, 5, myData.get(AssignmentJourneyModel.getStatusOfAssignment()));
                //Verify class name
                WebUI.checkContainsValueOnTableByConflictTable(1, 6, classItem);
            } else {
                //Verify class name
                WebUI.checkContainsValueOnTableByConflictTable(1, 6, classItem);
            }
        }

    }







}
