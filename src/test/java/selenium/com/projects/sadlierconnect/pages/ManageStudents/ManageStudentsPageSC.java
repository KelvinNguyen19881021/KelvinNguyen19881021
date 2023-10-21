package selenium.com.projects.sadlierconnect.pages.ManageStudents;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.models.ManageStudentModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.LogUtils;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ManageStudentsPageSC extends CommonPageSC {
  private final LoginPageSC loginPageSC = new LoginPageSC();
  private static final ExcelHelpers excelHelpers = new ExcelHelpers();
  private final String filterClass = "class", filterGrade = "grade", filterLastName = "lastname", filterFull = "full", filterClassGrade = "classAndGrade";
  private final String actionEdit = "Edit Account", actionDelete = "Delete Account", actionDisable = "Disable Account", actionEnable = "Enable Account", actionManagerLincense = "Manage Licenses";
  private final String printStudent = "Print Student Letter", printParent = "Print Parent Letter";
  private final String btnOk = "OK", btnSave = "Save", btnCancel = "Cancel", btnDelete = "Delete student", btnYes = "Yes", btnNo = "No", btnSend = "Send", btnX = "X";
  private final String btnPencil = "pencil", btnMail = "mail", btnPrint = "print";

  private By convertStringToXpath(String name) {
    return By.xpath(name);
  }

  private By dataNeedClick(String name) {
    return convertStringToXpath("(//span[contains(text(),'" + name + "')])[1]");
  }

  private final static ManageStudentModel managerStudentModel = new ManageStudentModel();

  public ManageStudentsPageSC() {
    super();
   excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH, "ManageStudent");
  }

  final By dropdownMangeSchool = convertStringToXpath("//a[@class='ant-dropdown-trigger ant-dropdown-link sc-dsQDmV kBkfyy sc-cZwWEu dmLaeR']");
  final By manageSchool = convertStringToXpath("//a[normalize-space()='Manage Schools']");
  final By inputPID = convertStringToXpath("//input[@name='pid']");
  final By eyeView = convertStringToXpath("//div[@class='cursor-pointer']//*[name()='svg']");
  final By dropdownFilterLicense = convertStringToXpath("(//div[@class='ant-select-selector'])[3]");
  final By allLicense = convertStringToXpath("//div[@class='ant-select-item-option-content']//span[contains(text(),'All License Types')]");
  final By seaTLicense = convertStringToXpath("//span[normalize-space()='Seat Licenses']");
  final By siteLicense = convertStringToXpath("//span[normalize-space()='Site Licenses']");
  final By totalLicense = convertStringToXpath("(//div[@class='pageLinks undefined'])[1]");
  final By totalLicenseOfPage = convertStringToXpath("//div[@class='pagination-content']");

  public void updateFileExcel(boolean isUpdate){
    if (Boolean.TRUE.equals(isUpdate)) {
      DriverManager.setDriver(DriverManager.optionsHiddenDriver());
      loginPageSC.logInWithSystemAdminRole();
      WebUI.clickElement(dropdownMangeSchool);
      WebUI.clickElement(manageSchool);
      WebUI.clickElement(inputPID);
      int size = FrameworkConstants.URL_SADLIERCONNECT_USER.length();
      // if index at @ after index + 1
      WebUI.setText(inputPID, FrameworkConstants.URL_SADLIERCONNECT_USER.substring(FrameworkConstants.URL_SADLIERCONNECT_USER.indexOf("@") + 1, size));
      WebUI.clickElement(btnFilter);
      WebUI.clickElement(eyeView);
      //
      WebUI.clickElement(dropdownFilterLicense);
      WebUI.clickElement(allLicense);
      WebUI.clickElement(btnFilter);
      WebUI.sleep(5);
      WebUI.waitForPageLoaded();
      WebUI.waitForJQueryLoad();
      String txtAll = "";
      if (WebUI.verifyElementExists(totalLicense)){
        WebUI.scrollToElementToBottom(totalLicense);
        txtAll = WebUI.getTextElement(totalLicense);
      }else {
        WebUI.scrollToElementToBottom(totalLicenseOfPage);
        txtAll = WebUI.getTextElement(totalLicenseOfPage);
      }
      excelHelpers.setCellDataUsingBorder(txtAll, 23, 23);
      excelHelpers.setCellDataUsingBorder(txtAll, 24, 23);
      excelHelpers.setCellDataUsingBorder(txtAll, 48, 23);
      excelHelpers.setCellDataUsingBorder(txtAll, 49, 23);
      //
      WebUI.clickElement(dropdownFilterLicense);
      WebUI.clickElement(seaTLicense);
      WebUI.clickElement(btnFilter);
      WebUI.sleep(5);
      WebUI.waitForPageLoaded();
      WebUI.waitForJQueryLoad();
      String txtSeat = "";
      if (WebUI.verifyElementExists(totalLicense)){
        txtSeat = WebUI.getTextElement(totalLicense);
      }else {
        WebUI.scrollToElementToBottom(totalLicenseOfPage);
        txtSeat = WebUI.getTextElement(totalLicenseOfPage);
      }
      excelHelpers.setCellDataUsingBorder(txtSeat, 23, 24);
      excelHelpers.setCellDataUsingBorder(txtSeat, 24, 24);
      excelHelpers.setCellDataUsingBorder(txtSeat, 48, 24);
      excelHelpers.setCellDataUsingBorder(txtSeat, 49, 24);
      //
      WebUI.clickElement(dropdownFilterLicense);
      WebUI.clickElement(siteLicense);
      WebUI.clickElement(btnFilter);
      WebUI.sleep(5);
      WebUI.waitForPageLoaded();
      WebUI.waitForJQueryLoad();
      String txtSite = "";
      if (WebUI.verifyElementExists(totalLicense)){
        WebUI.scrollToElementToBottom(totalLicense);
        txtSite = WebUI.getTextElement(totalLicense);
      }else {
        WebUI.scrollToElementToBottom(totalLicenseOfPage);
        txtSite = WebUI.getTextElement(totalLicenseOfPage);
      }
      excelHelpers.setCellDataUsingBorder(txtSite, 23, 25);
      excelHelpers.setCellDataUsingBorder(txtSite, 24, 25);
      excelHelpers.setCellDataUsingBorder(txtSite, 48, 25);
      excelHelpers.setCellDataUsingBorder(txtSite, 49, 25);
      DriverManager.quit();
    }
  }

  public String pageText = "Total clients";
  public String pageUrl = "/clients";

  private final String pageMessage = "/messages/listMessage.html";
  private final String pageCurrent = "/teacher/student/list.html";
  private final String pageUserStudent = "/users/student/list.html";
  private final String dashboard = "/dashboard";

  // visit page
  public final By menuManageSettings = By.xpath("(//*[name()='svg'])[2]");
  public final By manageStudents = By.xpath("//a[normalize-space()='Manage Students']");

  //search global
  private final By inputSearchGlobal = convertStringToXpath("(//input[@placeholder='Search for Student'])[1]");
  private final By inputSearchGlobalMessage = convertStringToXpath("//input[@placeholder='Search for Messages']");

  //filter
  private final By dropdownClass = convertStringToXpath("(//div[@class='ant-select-selector'])[1]");
  private final By inputSearchClass = convertStringToXpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
  private final By dropdownGrade = convertStringToXpath("(//div[@class='ant-select-selector'])[2]");
  private final By inputSearchGrade = convertStringToXpath("//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')]");
  private final By inputSearchGrade2 = convertStringToXpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[2]");
  private final By inputSearchLastName = convertStringToXpath("(//input[@name='lastname'])[1]");
  private final By btnFilterSearch = convertStringToXpath("(//b[normalize-space()='Apply Filter'])[1]");

  // btn
  private final By btnAdd = convertStringToXpath("(//span[normalize-space()='+ Add Student'])[1]");
  private final By btnImport = convertStringToXpath("(//span[normalize-space()='Import Roster'])[1]");
  private final By btnExport = convertStringToXpath("(//span[normalize-space()='Export Roster'])[1]");

  // input data
  private final By inputStudentId = convertInputByName("studentId");
  private final By inputFistName = convertInputByName("firstName");
  private final By inputMiddleName = convertInputByName("middleName");
  private final By inputLastName = convertInputByName("lastName");
  private final By inputUserName = convertInputByName("username");
  private final By inputPassword = convertInputByName("password");
  private final By dropdownGradeLevel = convertStringToXpath("(//div[@class='ant-select ant-select-lg ant-select-single ant-select-show-arrow'])[2]");
  private final By inputGradeLevel = convertStringToXpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");

  private By convertInputByName(String inputName) {
    return convertStringToXpath("//input[@id='"+inputName+"']");
  }

  // check box add new
  private final By checkBoxAddLicense = convertStringToXpath("(//span[@class='ant-checkbox'])[1]");
  //btn close X
  private final By btnCloseX = convertStringToXpath("(//span[@class='ant-modal-close-x'])[1]");
  // manger license
  //tab
  private final By tabLicense = convertStringToXpath("//div[@class='tab-pane']");
  private final By tabLicenseActive = convertStringToXpath("//div[@class='tab-pane active']");
  //search
  private final By dropdownProduct = convertStringToXpath("(//div[@class='ant-select-selector'])[3]");
  private final By inputSearchProduct = convertStringToXpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
  //btn
  private final By btnFilter = convertStringToXpath("(//span[normalize-space()='Apply Filter'])[1]");

  // verify required field
  private final String requireField = "This field is required.";

  //mail
  private final By btnSendMail = convertStringToXpath("(//span[normalize-space()='Send'])[1]");
  private final By btnSendMailCancel = convertStringToXpath("(//button[normalize-space()='Cancel'])[1]");
  private final By btnCloseSendTo = convertStringToXpath("(//span[@aria-label='close'])[1]");
  private final By sendTo = convertStringToXpath("(//span[@class='ant-select-selection-item-content'])[1]");
  private final By inputTo = convertInputByName("rc_select_26");
  private final By inputSubject = convertStringToXpath("(//input[@name='subject'])[1]");
  private final By btnSendMessage = convertStringToXpath("//li[2]//div[1]//*[name()='svg']");
  //  private final By textareaContent = convertStringToXpath("(//textarea[@class='note-codable'])[1]");
  private final By textareaContent = convertStringToXpath("(//div[@role='textbox'])[1]");
  private final By btnSaveMail = convertStringToXpath("//span[normalize-space()='Send']");
  private final By labelError= convertStringToXpath("//div[@class='text-left']");
  //import
  private final String fileExcelError = "\\src\\test\\resources\\testdataSC\\SC_Manage_Student.xlsx";
  private final By backBackStep = convertStringToXpath("(//button[normalize-space()='Back to Step 1'])[1]");
  private final By dropdown = convertStringToXpath("(//div[@class='ant-select ant-select-lg ant-select-single ant-select-show-arrow'])[2]");
  private final By returnManagerStudent = convertStringToXpath("(//span[normalize-space()='Return to Manage Students'])[1]");
  private final By alertMessage = convertStringToXpath("(//div[@class='ant-alert-message'])[1]");
  private final By dropdownFilterImport = convertStringToXpath("(//div[contains(@class,'ant-select ant-select-lg ant-select-single ant-select-show-arrow')])[2]");
  private final By inputSearchImport = convertStringToXpath("(//input[contains(@type,'text')])[3]");
  private final By summaryImport = By.className("summary");
  private final By btnChoseFile = convertStringToXpath("(//span[normalize-space()='Choose File'])[1]");
  private final By btnContinue = convertStringToXpath("(//span[normalize-space()='Continue'])[1]");
  private final By btnImportRoster = convertStringToXpath("(//span[contains(text(),'Import Roster')])[2]");
  //message
  private final By alertMessageSuccess = convertStringToXpath("(//div[@class='ant-alert-message'])[1]");
  private final By alertMessageError = convertStringToXpath("(//div[@class='ant-alert-message'])[1]");
  private final String msgFormatFile = "The file you have selected appears be an invalid format. Please make sure the file format matches the provided template.";


  public void excelToCSV(){
    String fileExcel = "";
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("mac")) {
      fileExcel = "/src/test/resources/testdataSC/SC_Manage_Student.xlsx";
    }else if (osName.toLowerCase().contains("win")){
      fileExcel = fileExcelError;
    } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")){
      fileExcel = "/src/test/resources/testdataSC/SC_Manage_Student.xlsx";
    }
    String path = System.getProperty("user.dir") + fileExcel;
    if (!path.isEmpty()) {
      String outPath17 = getPathFileCSV("017");
      String outPath18 = getPathFileCSV("018");
      String outPath19 = getPathFileCSV("019");
      String outPath20 = getPathFileCSV("020");
      excelToCSVConvert(path, outPath17, ",", "StudentImportTemplate_017");
      excelToCSVConvert(path, outPath18, ",", "StudentImportTemplate_018");
      excelToCSVConvert(path, outPath19, ",", "StudentImportTemplate_019");
      excelToCSVConvert(path, outPath20, ",", "StudentImportTemplate_020");
    }
  }

  private String getPathFileCSV(String path) {
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("mac")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/import/StudentImportTemplate_" + path + ".csv";
    }else if (osName.toLowerCase().contains("win")){
      return System.getProperty("user.dir") +"\\src\\test\\resources\\testdataSC\\import\\StudentImportTemplate_"+path+".csv";
    }else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/import/StudentImportTemplate_" + path + ".csv";
    }
    return null;
  }

  public void TC_Manage_Student_001(Hashtable<String, String> data) throws IOException {
    //4. Click dropdown at "CLASS" item
    //5. Choose any class
    //6.Click "Apply Filter" button
    filterData(data, filterClass);
    WebUI.sleep(5);
    //[CP]_Display - Displays all students in the selected class
    //- If the class has no students - show message " No records found." on table
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_001");
  }

  public void TC_Manage_Student_002(Hashtable<String, String> data) throws IOException {
    //4. Click dropdown at "CLASS" item
    //5. Choose "All" class
    //6.Click "Apply Filter" button
    filterData(data, filterClass);
    //[CP]_Display - Display all student records in the component results
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_002");
  }


  public void TC_Manage_Student_003(Hashtable<String, String> data) throws IOException {
    //4. Click dropdown at "Grade" item
    //5. Choose "any" grade
    //6. Click "Apply Filter" button
    filterData(data, filterGrade);
    //[CP]_Display - displays all students with the selected grade level
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_003");
  }

  public void TC_Manage_Student_004(Hashtable<String, String> data) {
    //4. Click dropdown at "Grade" item
    //5. Choose "any" grade
    //6. Click "Apply Filter" button
    filterData(data, filterGrade);
    //[CP]_Display - Display message "No record found"
    WebUI.verifyElementText(labelError,"No records found.");
  }

  public void TC_Manage_Student_005(Hashtable<String, String> data) throws IOException {
    //4. Click dropdown at "Grade" item
    //5. Choose "All" grade
    //6. Click "Apply Filter" button
    filterData(data, filterGrade);
    //[CP]_Display - Display all student records in the component results
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_005");
  }


  public void TC_Manage_Student_006(Hashtable<String, String> data) throws IOException {
    // 4. Click on TextBox at "LAST NAME" item
    // 5. Input last name has exists
    // 6. Click "Apply Filter" button
    filterData(data, filterLastName);
    //[CP]_Display - Display all student records have last name with input the same at step 5 in the component results
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_006");
  }

  public void TC_Manage_Student_007(Hashtable<String, String> data) {
    // 4. Click on TextBox at "LAST NAME" item
    // 5. Input last name has exists
    // 6. Click "Apply Filter" button
    filterData(data, filterLastName);
    //[CP]_Display - Display message "No record found"
    WebUI.verifyElementText(labelError,"No records found.");
  }

  public void TC_Manage_Student_008(Hashtable<String, String> data) throws IOException {
    // 4. Click dropdown at "CLASS" item
    // 5. Choose any class
    // 6. Click dropdown at "GRADE" item
    // 7. Choose any grade
    // 8. Click "Apply Filter" button
    filterData(data, filterClassGrade);
    //[CP]_Display - Display all student records have class and grade mapping with input at step 5,7 in the component results
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_008");
  }

  public void TC_Manage_Student_009(Hashtable<String, String> data) throws IOException {
    // 4. Click dropdown at "CLASS" item
    // 5. Choose any class
    // 6. Click dropdown at "GRADE" item
    // 7. Choose any grade
    // 8. Click on textbox at "LAST NAME" item
    // 9. Input last name invalid
    // 10. Click "Apply Filter" button
    filterData(data, filterFull);
    //[CP]_Display - Display all student records have class, grade and last name mapping with input at step 5,7,9 in the component results
    WebUI.verifyTestData(FrameworkConstants.EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH,"TestData_TC_Manage_Student_009");
  }

  // add
  public void TC_Manage_Student_010(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input Student Id
    // 6. Input First name
    // 7. Input Middle name
    // 8. Input Last name
    // 9. Click on "USER NAME" textbox
    // 10. Delete all character
    // 11. Input User name
    // 12. Input Password
    // 13. Input Grade level
    dataNeededForAllSoNotAdded(data);
    if (filterExistOrDelete(1, data)) {
      deleteStudent(data, true);
      dataNeededForAllSoNotAdded(data);
      WebUI.sleep(2);
    }
    addNewStudent(data, true);
    // 14. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_verify - Add student successfully with message "Student account for Student 002 was successfully added to the system"
    verifyMessageSuccess("Student account for " + data.get(managerStudentModel.getFirstName()).trim() + " " + data.get(managerStudentModel.getLastName()).trim() + " was successfully added to the system");
    // [CP]_message - Display record with student Id is "Stu001" at result component
    WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getStudentID()).trim());
  }

  public void TC_Manage_Student_011(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input Student Id
    // 6. Input First name
    // 7. Input Last name
    // 8. Click on "USER NAME" textbox
    // 9. Delete all character
    // 10. Input User name
    // 11. Input Password
    // 12. Input Grade level
    dataNeededForAllSoNotAdded(data);
    if (filterExistOrDelete(1, data)) {
      deleteStudent(data, true);
      dataNeededForAllSoNotAdded(data);
      WebUI.sleep(2);
//      if (WebUI.verifyElementPresent(convertStringToXpath("//button[@class='ant-alert-close-icon'])"), 10)) {
//        WebUI.clickElement(convertStringToXpath("//button[@class='ant-alert-close-icon']"));
//      }
    }
    addNewStudent(data, false);
    // 13. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_verify - Add student successfully with message "Student account for Student 001 was successfully added to the system"
    verifyMessageSuccess("Student account for " + data.get(managerStudentModel.getFirstName()).trim() + " " + data.get(managerStudentModel.getLastName()).trim() + " was successfully added to the system");
    // [CP]_message - Display record with Username is "S002"at result component
    WebUI.checkContainsValueOnTableByColumn(2, data.get(managerStudentModel.getLastName()).trim());
  }

  public void TC_Manage_Student_012(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input UserName less than 3 characters and more than 50 characters
    addNewStudent(data, false);
    // 6. Click Save button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Add student unsuccessfully with warning "Username length must be from 3 to 50 characters." below Username field
    verifyFieldRequest("Username length must be from 3 to 50 characters.");
  }

  public void TC_Manage_Student_013(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
//    addNewStudent(data, false);
    WebUI.clickElement(btnAdd);
    // 5. Click "Save" button
//    WebUI.clickElement(dataNeedClick(btnSave));
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Add student unsuccessfully
    //- Display message "This field is required" at FIRST NAME, LAST NAME, USER NAME, PASSWORD items
    verifyFieldRequest(requireField);
  }

  public void TC_Manage_Student_014(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input UserName with special character
    addNewStudent(data, false);
    // 6. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Add student unsuccessfully
    // - Display message "Value contains illegal characters." at "USER NAME" item
    verifyFieldRequest("Value contains illegal characters.");
  }


  public void TC_Manage_Student_015(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input Student Id already exists
    addNewStudent(data, false);
    // 6. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Display message "User ID is duplicated." at "STUDENT ID" item
    verifyFieldRequest("User ID is duplicated.");
  }

  public void TC_Manage_Student_016(Hashtable<String, String> data) {
    // 4. Click "Add Student" button
    // 5. Input Student Id already exists
    addNewStudent(data, false);
    // 6. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Display message "User Name is duplicated." at "USER NAME" item
    verifyFieldRequest("User Name is duplicated.");
  }

  //import
  public void TC_Manage_Student_017(Hashtable<String, String> data) {
    // 4. Click "Import Roster" button
    // 5. Click "How do I create a student import file" link in Import Roster popup
    // 6. Click " Download Student Roster Imort Template" link in Import roster popup
    // 7. Click "Choose File" button
    // 8. Choose file valid from folder
    // 9. Click "Continue" button
    // 10. Click "Import Roster" button
    // 11. Click "X" icon/ "Return to Manage Students" button
    importCSVDataSuccess(data, true,"017");
    // [CP]_popup - Display "Import Roster: Summary" popup with {number} rows:
                    //Number of records in Import file:
                    //Number of student account created:
                    //Number of records not added due to errors: 0
                    //and Return to Manage Student button
    // [CP]_display - Display all record of file import at list result component
    WebUI.checkContainsAllValueOnTableByText(1, data.get(managerStudentModel.getStudentID()).trim());
  }

  public void TC_Manage_Student_018(Hashtable<String, String> data) {
    // 4. Click "Import Roster" button
    // 5. Click "Choose File" button
    // 6. Choose file have data invalid from folder
    // 7. Click "Continue" button
    // 8. Click "Import Roster" button
    // 9. Click "X" icon/ "Return to Manage Students" button
    // [CP]_popup Display "Import Roster: Summary" popup with {number} rows:
    //Number of records in Import file:
    //Number of records not added due to errors:
    importCSVDataTableError(data, "018");
    // [CP]_display - List record at result component not change
    WebUI.checkContainsAllValueOnTableByText(1,  data.get(managerStudentModel.getStudentID()).trim());
  }

  public void TC_Manage_Student_019(Hashtable<String, String> data) {
    // 4. Click "Import Roster" button
    // 5. Click "Choose File" button
    // 6. Choose file not correct format
    // 7. Click "Continue" button
    // [CP]_display - Display message "The file you have selected appears be an invalid format.
    // Please make sure the file format matches the provided template."
    importCSVDataError(data, "019");
  }

  public void TC_Manage_Student_020(Hashtable<String, String> data) {
    // 4. Click "Import Roster" button
    // 5. Click "Choose File" button
    // 6. Choose file not correct format
    // 7. Click "Continue" button
    importCSVDataErrorMsg(data, true,"020");
    // [CP]_display Display message "The file you have selected appears be an invalid format.
    // Please make sure the file format matches the provided template."
  }

  public void TC_Manage_Student_021(Hashtable<String, String> data)  {
  // 4. Click "Export Roster" button
    exportData(data);
    // [CP]_display - Export file successfully with file name "student_export_{xxxxxxxxxxxxx}"
    //- Display all record correctly and fully
  }

  public void TC_Manage_Student_022(Hashtable<String, String> data) {
    // 4. Select filter for no record found
    //ex: input 12345 into Lastname field
    // 5. Click "Apply Filter" button
    filterData(data, filterLastName);
    WebUI.sleep(5);
    WebUI.verifyElementNotPresent(btnExport, 10);
    // [CP]_display - Export button hided
  }

  //edit
  public void TC_Manage_Student_023(Hashtable<String, String> data) {
    // 4. Click on pencil icon
    // 5. Click on "Edit Account" item
    // 5. Edit data
    // 6. Click Save button
    editStudent(data, false, false);
    // [CP]_message - Edit student Account successfully
    verifyMessageSuccess("Student account for " + data.get(managerStudentModel.getFirstNameEdit()).trim() + " " + data.get(managerStudentModel.getLastNameEdit()).trim() + " was successfully updated to the system");
    // [CP]_display- Display message "Student account for {Firstname} {LastName} was successfully updated to the system"
    //Updated student info in table
    WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getStudentIDEdit()).trim());
  }

  public void TC_Manage_Student_024(Hashtable<String, String> data) {
    // 4. Click on pencil icon
    // 5. Click on "Edit Account" item
    // 5. Edit data
    // 6. Click Checkbox Add licenses in popup
    // 7. Click on "Seat Licenses" tab
    // 8. Click on "Site Licenses" tab
    // 9. Click "Save" button
    editStudent(data, true, false);
    // [CP]_message - Edit student Account successfully
    //- Display message "Student account for Firstname LastName was successfully updated to the system"
    //Updated student info in table
    verifyMessageSuccess("Student account for " + data.get(managerStudentModel.getFirstNameEdit()).trim() + " " + data.get(managerStudentModel.getLastNameEdit()).trim() + " was successfully updated to the system");
    WebUI.clickElement(inputSearchGlobal);
    WebUI.clearTextCtrlA(inputSearchGlobal);
    WebUI.setText(inputSearchGlobal, "", Keys.ENTER);
    WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getStudentIDEdit()).trim());
  }

  public void TC_Manage_Student_025(Hashtable<String, String> data) {
    //file data
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    // 5. Click on "Edit Account" item
    dropdownActionPencil(actionEdit);
    // 6. Delete data in Firstname, Lastname, UserName, Password or do not input all 4 required fields
    WebUI.clickElement(inputFistName);
    WebUI.clearTextCtrlA(inputFistName);
    WebUI.clickElement(inputLastName);
    WebUI.clearTextCtrlA(inputLastName);
    WebUI.clickElement(inputUserName);
    WebUI.clearTextCtrlA(inputUserName);
    WebUI.clickElement(inputPassword);
    WebUI.clearTextCtrlA(inputPassword);
    // 7. Click Save button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Add student unsuccessfully with warning "This field is required." below required fields not input
    verifyFieldRequest(requireField);
  }

  public void TC_Manage_Student_026(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    //5. Click on "Edit Account" item
    dropdownActionPencil(actionEdit);
    // 6. Click on "User name" textbox
    WebUI.clickElement(inputUserName);
    // 7. Delete all character
    WebUI.clearTextCtrlA(inputUserName);
    // 8. Input value already exists
    WebUI.setText(inputUserName, data.get(managerStudentModel.getUserName()).trim());
    // 9. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Display message "Value contains illegal characters." at "USER NAME" item
    verifyFieldRequest("Value contains illegal characters.");
  }

  public void TC_Manage_Student_027(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    // 5. Click on "Edit Account" item
    dropdownActionPencil(actionEdit);
    // 6. Click on "Student Id" textbox
    WebUI.clickElement(inputStudentId);
    // 7. Delete all character
    WebUI.clearTextCtrlA(inputStudentId);
    // 8. Input value already exists
    WebUI.setText(inputStudentId, data.get(managerStudentModel.getStudentIDEdit()).trim());
    // 9. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Display message "User IDis duplicated." at "USER NAME" item
    verifyFieldRequest("User ID is duplicated.");
  }

  public void TC_Manage_Student_028(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    // 5. Click on "Edit Account" item
    dropdownActionPencil(actionEdit);
    // 6. Click on "USER NAME" textbox
    WebUI.clickElement(inputUserName);
    // 7. Delete all character
    WebUI.clearTextCtrlA(inputUserName);
    // 8. Input value already exists
    WebUI.setText(inputUserName, data.get(managerStudentModel.getUserName()).trim());
    // 9. Click "Save" button
    popupConfirmActionPencil(true, btnSave);
    // [CP]_message - Display message "User Name is duplicated." at "USER NAME" item
    verifyFieldRequest("User Name is duplicated.");
  }

  // disable and enable
  public void TC_Manage_Student_029(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon"
    clickDropdown(btnPencil);
    // 5. Click on "Disable Account" item
    dropdownActionPencil(actionDisable);
    verifyCurrentPage();
    // 6. Click "Cancel" button at Confirm disable popup
    popupConfirmActionPencil(false, btnCancel);
    // [CP}_display - At column "Status" of record display is "Enabled"
    WebUI.checkContainsValueOnTableByColumn(5, data.get(managerStudentModel.getStatus()).trim());
  }

  public void TC_Manage_Student_030(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon"
    clickDropdown(btnPencil);
    // 5. Click on "Disable Account" item
    dropdownActionPencil(actionDisable);
    // 6. Click "OK" button at Confirm disable popup
    WebUI.sleep(2);
    popupConfirmActionPencil(true, btnOk);
    dataNeededForAllSoNotAdded(data);
    WebUI.checkContainsValueOnTableByColumn(5, data.get(managerStudentModel.getStatus()).trim());
    WebUI.sleep(5);
    // 7. Login as student account disabled
    loginDisableOrEnable(data);
    // [CP]_message - Display message "Your account has been disabled. Please contact your teacher."
    final By messageDisable = convertStringToXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/p");
    if (WebUI.verifyElementPresent(messageDisable, 10)) {
      WebUI.verifyElementTextContains(messageDisable, "Your account has been disabled. Please contact your teacher.");
      WebUI.sleep(5);
    }
  }

  public void TC_Manage_Student_031(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    // 5. Click on "Enable Account" item
    dropdownActionPencil(actionEnable);
    // 6. Click "Cancel" button at Confirm activation popup
//    popupConfirmActionPencil(false, btnCancel);
    WebUI.sleep(2);
    WebUI.clickElement(dataNeedClick(btnCancel));
    verifyCurrentPage();
    dataNeededForAllSoNotAdded(data);
    // [CP]_display - At column "Status" of record display is "Disabled"
    WebUI.checkContainsValueOnTableByColumn(5, data.get(managerStudentModel.getStatus()).trim());
  }

  public void TC_Manage_Student_032(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click on pencil icon
    clickDropdown(btnPencil);
    // 5. Click on "Enable Account" item
    dropdownActionPencil(actionEnable);
    // 6. Click "OK" button at Confirm activation popup
    WebUI.sleep(2);
    popupConfirmActionPencil(true, btnOk);
    dataNeededForAllSoNotAdded(data);
    // [CP]_display - Display message "The user account for Firstname Lastname has been enabled."
    //- Status of this student is "Enabled"
    WebUI.checkContainsValueOnTableByColumn(5, data.get(managerStudentModel.getStatus()).trim());
    WebUI.sleep(5);
    // 7. Login as student account enabled
    loginDisableOrEnable(data);
    verifyCurrentPage();
    WebUI.sleep(5);
  }

  private void loginDisableOrEnable(Hashtable<String, String> data){
    final By userAvatar = convertStringToXpath("//span[@class='user-avatar']");
    final By btnLogout = convertStringToXpath("//a[normalize-space()='Logout']");
    final By inputPassCode = By.xpath("//input[@id='passcode']");
    final By inputPassWord = By.xpath("//input[@id='password']");
    final By inputUserName = By.xpath("//input[@id='username']");
    final By buttonLogin = By.xpath("//button[@type='button']");
    final String pageTitle = "Sadlier Connect™ - Log In";
    WebUI.clickElement(userAvatar);
    WebUI.clickElement(btnLogout);
    WebUI.getURL(FrameworkConstants.URL_SADLIERCONNECT_USER);
    WebUI.verifyEquals(WebUI.getPageTitle(), pageTitle, "The title of sign in page not match.");
    WebUI.setText(inputPassCode, data.get(managerStudentModel.getPassCode()));
    WebUI.setText(inputUserName, data.get(managerStudentModel.getUserName()));
    WebUI.setText(inputPassWord, data.get(managerStudentModel.getPassWord()));
    WebUI.clickElement(buttonLogin);
    WebUI.waitForPageLoaded();
    WebUI.sleep(5);
  }

  // delete
  public void TC_Manage_Student_033(Hashtable<String, String> data) {
    // 4. Click on pencil icon
    // 5. Click on "Delete Account" item
    // 6. Click on "Cancel" button at Warning popup
    deleteStudent(data, false);
    // [CP]_display - Record of student still exists
    dataNeededForAllSoNotAdded(data);
    WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getStudentID()).trim());
  }

  public void TC_Manage_Student_034(Hashtable<String, String> data) {
    // 4. Click on pencil icon
    // 5. Click on "Delete Account" item
    // 6. Click on "Delete student" button at Warning popup
    deleteStudent(data, true);
    verifyMessageSuccess("The user account for " + data.get(managerStudentModel.getFirstName()).trim() + " " + data.get(managerStudentModel.getLastName()).trim() + " has been deleted.");
    // [CP]_display - Display message "The user account for Firstname Lastname has been deleted."
    WebUI.checkDataIsNotExistedOnTableByColumn(1, data.get(managerStudentModel.getStudentID()).trim());
  }


  // send mail
  public void TC_Manage_Student_035(Hashtable<String, String> data) {
    // 4. Click Message icon
    // 5. Click on textbox SUBJECT
    // 6. Input subject
    // 7. Click on textarea content
    // 8. Input data
    // 9. Click on "Send" button
    sendMail(data, false, true);
    // [CP]_display - At "Sent" item of Messages component the display record with the column "To" is "{last name},
    // {first name}" and subject is "WORK"
  }

  public void TC_Manage_Student_036(Hashtable<String, String> data) {
    // 4. Click Message icon
    // 5. Click on textbox SUBJECT
    // 6. Input subject
    // 9. Click on "Send" button
    sendMail(data, false, true);
    // [CP]_message - At "Sent" item of Messages component the display record with the column "To" is "{last name},
    // {first name}" and subject is "LISTEN"
  }

  public void TC_Manage_Student_037(Hashtable<String, String> data) {
    // 4. Click Message icon
    // 5. Click on textbox SUBJECT
    // 6. Input subject
    // 7. Click on textarea content
    // 8. Click on textarea content
    // 9. Input data
    // 10. Click on "Send" button
    sendMail(data, false, true);
    // [CP]_display - At "Sent" item of Messages component the display record with the column "To" is "{last name},
    // {first name}" and subject is "WRITE"
  }

  public void TC_Manage_Student_038(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    // 4. Click Message icon
    clickDropdown(btnMail);
    WebUI.waitForPageLoaded();
    WebUI.waitForJQueryLoad();
    // 5. Click on textarea content
    WebUI.clickElement(textareaContent);
    // 6. Input data
    WebUI.setText(textareaContent, data.get(managerStudentModel.getContent()).trim());
    // 7. Click on "Send" button
    popupConfirmActionSendMail(false, btnSend);
    // [CP]_message - Display message "This field is required." at SUBJECT item
    verifyFieldRequest(requireField);
  }

  public void TC_Manage_Student_039(Hashtable<String, String> data) {
    // 4. Click on message icon
    // 5. Click on textbox SUBJECT
    // 6. Input subject
    // 7. Click on textarea content
    // 8. Input data
    // 9. Click on "Cancel" button
    sendMail(data, false, false);
    // [CP]_display At "Sent" item of Messages component the not display record with subject is "READ"
  }

  public void TC_Manage_Student_040(Hashtable<String, String> data) {
    // 4. Click on message icon
    // 5. Click on "Send Offline eBook Instructions" item
    // 6. Click on "Send" button
    sendMail(data, false, true);
    // [CP]_verify - At "Sent" item of Messages component the display record with the column "To" is "{last name},
    // {first name}" and subject is "How to Use Your Offline eBooks"
  }

  public void TC_Manage_Student_041(Hashtable<String, String> data) {
    // 4. Click on message icon
    // 5. Click on "Send Offline eBook Instructions" item
    // 6. Click on "Cancel" button
    sendMail(data, false, false);
    // [CP]_verify - At "Sent" item of Messages component the not display record with the column "To" is "{last name},
    // {first name}" and subject is "How to Use Your Offline eBooks"
  }


  // print
  public void TC_Manage_Student_042(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnPrint);
    dropdownActionPencil(printStudent);
    WebUI.clickElement(convertStringToXpath("//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[2]"));
  }

  public void TC_Manage_Student_043(Hashtable<String, String> data) {

  }

  public void TC_Manage_Student_044(Hashtable<String, String> data) {

  }

  public void TC_Manage_Student_045(Hashtable<String, String> data) {

  }

  public void TC_Manage_Student_046(Hashtable<String, String> data) {

  }

  public void TC_Manage_Student_047(Hashtable<String, String> data) {

  }

  // manage license
  public void TC_Manage_Student_048(Hashtable<String, String> data) {
    // 5. Click on "Manage Licenses" item
    // 6. Select any product at Product pulldown
    // 7. Click "Apply Filter" button
    managerLicense(data, false, false);
    // [CP]_display - Display Site Licenses tab and list product of site licenses
    // [CP]_verify - Display record has description the same as selected at step 6
  }

  public void TC_Manage_Student_049(Hashtable<String, String> data) {
    // 5. Click on "Manage Licenses" item
    // 6. Click on "Site Licenses" tab
    // 7. Select any product at Product pulldown
    // 8. Click "Apply Filter" button
    managerLicense(data, true,false);
    // [CP]_display - Display Seat Licenses tab and list product of seat licenses
    // [CP]_display - Display list product of site licenses
    // [CP]_verify - Display record has description the same as selected at step 7
  }

//  private static void openDownloadedFile(String filePath) {
//    File file = new File(filePath);
//    if (file.exists()) {
//      try {
//        Desktop.getDesktop().open(file);
//      } catch (Exception e) {
//        System.out.println("Error opening the file: " + e.getMessage());
//      }
//    } else {
//      System.out.println("File does not exist: " + filePath);
//    }
//  }

  // filter data by [ class | grade | lastname | unknown]
  private void filterData(Hashtable<String, String> data, String action) {
    switch (action) {
      case filterClass:
        WebUI.clickElement(dropdownClass);
        WebUI.clickElement(inputSearchClass);
        WebUI.clearTextCtrlA(inputSearchClass);
        WebUI.setText(inputSearchClass, data.get(managerStudentModel.getClazz()).trim());
        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getClazz()).trim()));
        WebUI.clickElement(btnFilterSearch);
        return;
      case filterGrade:
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputSearchGrade);
        WebUI.clearTextCtrlA(inputSearchGrade);
        WebUI.setText(inputSearchGrade, data.get(managerStudentModel.getGrade()).trim(),Keys.ENTER);
      //  WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getGrade()).trim()));
        WebUI.clickElement(btnFilterSearch);
        return;
      case filterLastName:
        WebUI.clickElement(inputSearchLastName);
        WebUI.clearTextCtrlA(inputSearchLastName);
        WebUI.setText(inputSearchLastName, data.get(managerStudentModel.getLastName()).trim(), Keys.ENTER);
        WebUI.clickElement(btnFilterSearch);
        return;
      case filterClassGrade:
        WebUI.clickElement(dropdownClass);
        WebUI.clickElement(inputSearchClass);
        WebUI.clearTextCtrlA(inputSearchClass);
        WebUI.setText(inputSearchClass, data.get(managerStudentModel.getClazz()).trim());
        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getClazz()).trim()));
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputSearchGrade2);
        WebUI.clearTextCtrlA(inputSearchGrade2);
        WebUI.setText(inputSearchGrade2, data.get(managerStudentModel.getGrade()).trim(), Keys.ENTER);
//        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getGrade()).trim()));
        WebUI.clickElement(btnFilterSearch);
        return;
      case filterFull:
        WebUI.clickElement(dropdownClass);
        WebUI.clickElement(inputSearchClass);
        WebUI.clearTextCtrlA(inputSearchClass);
        WebUI.setText(inputSearchClass, data.get(managerStudentModel.getClazz()).trim());
        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getClazz()).trim()));
        WebUI.clickElement(dropdownGrade);
        WebUI.clickElement(inputSearchGrade2);
        WebUI.clearTextCtrlA(inputSearchGrade2);
        WebUI.setText(inputSearchGrade2, data.get(managerStudentModel.getGrade()).trim(), Keys.ENTER);
//        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getGrade()).trim()));
        WebUI.clickElement(inputSearchLastName);
        WebUI.clearTextCtrlA(inputSearchLastName);
        WebUI.setText(inputSearchLastName, data.get(managerStudentModel.getLastName()).trim(), Keys.ENTER);
        WebUI.clickElement(btnFilterSearch);
        return;
      default:
        throw new NotFoundException("Your filter condition does not exist!");
    }
  }


  private void addNewStudent(Hashtable<String, String> data, boolean isGradeLevel) {
    WebUI.clickElement(btnAdd);
    // 5. Input Student Id
    if (!data.get(managerStudentModel.getStudentID()).trim().isEmpty()) {
      WebUI.clickElement(inputStudentId);
      WebUI.setText(inputStudentId, data.get(managerStudentModel.getStudentID()).trim());
    }
    // 6. Input First name
    if (!data.get(managerStudentModel.getFirstName()).trim().isEmpty()) {
      WebUI.clickElement(inputFistName);
      WebUI.setText(inputFistName, data.get(managerStudentModel.getFirstName()).trim());
    }
    // 7. Input Middle name
    if (!data.get(managerStudentModel.getMiddleName()).trim().isEmpty()) {
      WebUI.clickElement(inputMiddleName);
      WebUI.setText(inputMiddleName, data.get(managerStudentModel.getMiddleName()).trim());
    }
    // 8. Input Last name
    if (!data.get(managerStudentModel.getLastName()).trim().isEmpty()) {
      WebUI.clickElement(inputLastName);
      WebUI.setText(inputLastName, data.get(managerStudentModel.getLastName()).trim());
    }
    // 9. Click on "USER NAME" textbox
    // 10. Delete all character
    // 11. Input User name
    if (!data.get(managerStudentModel.getUserName()).trim().isEmpty()) {
      WebUI.clickElement(inputUserName);
      WebUI.clearTextCtrlA(inputUserName);
      WebUI.setText(inputUserName, data.get(managerStudentModel.getUserName()).trim());
    }
    // 12. Input Password
    if (!data.get(managerStudentModel.getPassWord()).trim().isEmpty()) {
      WebUI.clickElement(inputPassword);
      WebUI.setText(inputPassword, data.get(managerStudentModel.getPassWord()).trim());
    }
    // 13. Input Grade level
    if (!data.get(managerStudentModel.getGradeLevel()).trim().isEmpty()) {
      if (Boolean.TRUE.equals(isGradeLevel)) {
        WebUI.clickElement(dropdownGradeLevel);
        WebUI.clickElement(inputGradeLevel);
        WebUI.setText(inputGradeLevel, data.get(managerStudentModel.getGradeLevel()).trim());
        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getGradeLevel()).trim()));
      }
    }
  }

  private void editStudent(Hashtable<String, String> data, boolean isAddLicense, boolean isFilter) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnPencil);
    dropdownActionPencil(actionEdit);
    if (!data.get(managerStudentModel.getStudentIDEdit()).trim().isEmpty()) {
      WebUI.clickElement(inputStudentId);
      WebUI.clearTextCtrlA(inputStudentId);
      WebUI.setText(inputStudentId, data.get(managerStudentModel.getStudentIDEdit()).trim());
    }
    if (!data.get(managerStudentModel.getFirstNameEdit()).trim().isEmpty()) {
      WebUI.clickElement(inputFistName);
      WebUI.clearTextCtrlA(inputFistName);
      WebUI.setText(inputFistName, data.get(managerStudentModel.getFirstNameEdit()).trim());
    }
    if (!data.get(managerStudentModel.getMiddleName()).trim().isEmpty()) {
      WebUI.clickElement(inputMiddleName);
      WebUI.clearTextCtrlA(inputMiddleName);
      WebUI.setText(inputMiddleName, data.get(managerStudentModel.getMiddleName()).trim());
    }
    if (!data.get(managerStudentModel.getLastNameEdit()).trim().isEmpty()) {
      WebUI.clickElement(inputLastName);
      WebUI.clearTextCtrlA(inputLastName);
      WebUI.setText(inputLastName, data.get(managerStudentModel.getLastNameEdit()).trim());
    }
    if (!data.get(managerStudentModel.getUserNameEdit()).trim().isEmpty()) {
      WebUI.clickElement(inputUserName);
      WebUI.clearTextCtrlA(inputUserName);
      WebUI.setText(inputUserName, data.get(managerStudentModel.getUserNameEdit()).trim());
    }
    if (!data.get(managerStudentModel.getPassWord()).trim().isEmpty()) {
      WebUI.clickElement(inputPassword);
      WebUI.clearTextCtrlA(inputPassword);
      WebUI.setText(inputPassword, data.get(managerStudentModel.getPassWord()).trim());
    }
    if (!data.get(managerStudentModel.getGradeLevel()).trim().isEmpty()) {
      WebUI.clickElement(dropdownGradeLevel);
      WebUI.clickElement(inputGradeLevel);
      WebUI.clearTextCtrlA(inputGradeLevel);
      WebUI.setText(inputGradeLevel, data.get(managerStudentModel.getGradeLevel()).trim());
      WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getGradeLevel()).trim()));
    }
    if (Boolean.TRUE.equals(isAddLicense)) {
      WebUI.clickElement(checkBoxAddLicense);
      // check license
      WebUI.sleep(5);
      if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Seat Licenses") && WebUI.getTextElement(tabLicense).equalsIgnoreCase("Site Licenses")) {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2,  data.get(managerStudentModel.getProductCodeSeat()));
        if (WebUI.getTextElement(tabLicense).equalsIgnoreCase("Site Licenses")) {
          WebUI.clickElement(tabLicense);
          WebUI.sleep(5);
          WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
          WebUI.sleep(5);
        }
      }else if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Seat Licenses")){
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSeat()));
        WebUI.sleep(5);
      } else if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Site Licenses")){
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      } else {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      }
      if (isFilter) {
        WebUI.clickElement(dropdownProduct);
        WebUI.clickElement(inputSearchProduct);
        WebUI.clearTextCtrlA(inputSearchProduct);
        WebUI.setText(inputSearchProduct, data.get(managerStudentModel.getProduct()).trim());
        WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getProduct()).trim()));
        WebUI.clickElement(btnFilter);
      }
    }
    popupConfirmActionPencil(true, btnSave);
  }

  private void clearTextWhenEditStudent(Hashtable<String, String> data) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnPencil);
    dropdownActionPencil(actionEdit);
    WebUI.clickElement(inputFistName);
    WebUI.clearTextCtrlA(inputFistName);
    WebUI.clickElement(inputMiddleName);
    WebUI.clearTextCtrlA(inputMiddleName);
    WebUI.clickElement(inputLastName);
    WebUI.clearTextCtrlA(inputLastName);
    WebUI.clickElement(inputUserName);
    WebUI.clearTextCtrlA(inputUserName);
    WebUI.clickElement(inputPassword);
    WebUI.clearTextCtrlA(inputPassword);
    WebUI.clickElement(checkBoxAddLicense);
    popupConfirmActionPencil(true, btnSave);
  }

  /*
   * if isDelete = true -> Yes | Ok
   * else -> Cancel | No
   * */
  private void deleteStudent(Hashtable<String, String> data, boolean isDelete) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnPencil);
    dropdownActionPencil(actionDelete);
    if (Boolean.FALSE.equals(isDelete)) {
//      popupConfirmActionPencil(false, btnCancel);
      WebUI.clickElement(dataNeedClick(btnCancel));
    } else {
//      popupConfirmActionPencil(true, btnDelete);
      WebUI.clickElement(dataNeedClick(btnDelete));
      String msg = "The user account for " + data.get(managerStudentModel.getFirstName()).trim() + " " + data.get(managerStudentModel.getLastName()).trim() + " has been deleted.";
      verifyMessageSuccess(msg);
    }
  }


  // manager license
  private void managerLicense(Hashtable<String, String> data, boolean isSeat, boolean isFilter) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnPencil);
    dropdownActionPencil(actionManagerLincense);
    WebUI.sleep(5);
    if (Boolean.TRUE.equals(isSeat)) {
      if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Seat Licenses") && WebUI.getTextElement(tabLicense).equalsIgnoreCase("Site Licenses")) {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSeat()));
        WebUI.sleep(5);
        if (WebUI.getTextElement(tabLicense).equalsIgnoreCase("Site Licenses")) {
          WebUI.clickElement(tabLicense);
          WebUI.sleep(5);
          WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
          WebUI.sleep(5);
        }
      } else if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Seat Licenses")) {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSeat()));
        WebUI.sleep(5);
      } else if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Site Licenses")) {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      } else {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      }
    }else {
      if (WebUI.getTextElement(tabLicenseActive).equalsIgnoreCase("Site Licenses")) {
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      }else if (WebUI.getTextElement(tabLicense).equalsIgnoreCase("Site Licenses")) {
        WebUI.clickElement(tabLicense);
        WebUI.sleep(5);
        WebUI.checkContainsAllValueOnTableByText(2, data.get(managerStudentModel.getProductCodeSite()));
        WebUI.sleep(5);
      }
    }

    if (isFilter) {
      WebUI.clickElement(dropdownProduct);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(managerStudentModel.getProduct()).trim());
      WebUI.clickElement(dataNeedClick(data.get(managerStudentModel.getProduct()).trim()));
      WebUI.clickElement(btnFilter);
    }
  }

  // send mail isSaveMail -> if true save mail to daft else using action notCancel -> if true action send mail else false action cancel
  private void sendMail(Hashtable<String, String> data, boolean isSaveMail, boolean sendMail) {
    dataNeededForAllSoNotAdded(data);
    clickDropdown(btnMail);
    WebUI.waitForPageLoaded();
    WebUI.waitForJQueryLoad();
//    addNewSendTo(data, false);
    if(!data.get(managerStudentModel.getSubject()).isEmpty()) {
      WebUI.clickElement(inputSubject);
      WebUI.setText(inputSubject, data.get(managerStudentModel.getSubject()).trim());
    }
    if (!data.get(managerStudentModel.getContent()).isEmpty()) {
      WebUI.setText(textareaContent, data.get(managerStudentModel.getContent()).trim());
    }
    WebUI.scrollToElementToBottom(convertStringToXpath("//div[@class='flex gap-6']"));
    WebUI.sleep(5);
    if (Boolean.TRUE.equals(isSaveMail)) {
      WebUI.clickElement(btnSaveMail);
      WebUI.sleep(5);
      WebUI.waitForPageLoaded();
      verifyCurrentPage();
      if (WebUI.verifyElementPresent(convertStringToXpath("(//div[@class='readInbox'][normalize-space()='"+data.get(managerStudentModel.getSendTo())+"'])[1]"), 10)) {
        WebUI.sleep(5);
        WebUI.verifyElementPresent(convertStringToXpath("(//div[normalize-space()='"+data.get(managerStudentModel.getSubject()).trim()+"'])[1]"), 10);
        WebUI.sleep(5);
      }
    } else {
      if (Boolean.TRUE.equals(sendMail)) {
        popupConfirmActionSendMail(false, btnSend);
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
//        WebUI.verifyElementTextContains(convertStringToXpath())
        WebUI.clickElement(inputSearchGlobalMessage);
        WebUI.clearTextCtrlA(inputSearchGlobalMessage);
        WebUI.setText(inputSearchGlobalMessage, (data.get(managerStudentModel.getStudentID()).isEmpty() || data.get(managerStudentModel.getStudentID()).isBlank()) ? data.get(managerStudentModel.getLastName()).trim() : data.get(managerStudentModel.getStudentID()).trim(), Keys.ENTER);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getLastName()).trim() + ", " + data.get(managerStudentModel.getFirstName()).trim());
        WebUI.checkContainsValueOnTableByColumn(1, data.get(managerStudentModel.getSubject()));
        WebUI.sleep(5);
      } else {
        popupConfirmActionSendMail(true, btnCancel);
        WebUI.sleep(5);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(btnSendMessage);
        WebUI.clickElement(inputSearchGlobalMessage);
        WebUI.clearTextCtrlA(inputSearchGlobalMessage);
        WebUI.setText(inputSearchGlobalMessage, (data.get(managerStudentModel.getStudentID()).isEmpty() || data.get(managerStudentModel.getStudentID()).isBlank()) ? data.get(managerStudentModel.getLastName()).trim() : data.get(managerStudentModel.getStudentID()).trim(), Keys.ENTER);
        WebUI.checkDataIsNotExistedOnTableByColumn(1, data.get(managerStudentModel.getLastName()).trim() + ", " + data.get(managerStudentModel.getFirstName()).trim());
        WebUI.checkDataIsNotExistedOnTableByColumn(1, data.get(managerStudentModel.getSubject()));
        WebUI.sleep(5);
        verifyCurrentPage();
      }
    }
  }

  // clearPerson if true implement delete person current else implement update person send to
//  private void addNewSendTo(Hashtable<String, String> data, boolean clearPerson) {
//    final By inputSearchSendTo = convertStringToXpath("(//div[@class='ant-select-selection-search'])[1]");
//    if (Boolean.TRUE.equals(clearPerson)) {
//      WebUI.clickElement(btnCloseSendTo);
//      WebUI.clickElement(inputSearchSendTo);
//      WebUI.clickElement(convertStringToXpath("(//input[@type='search'])"));
//      WebUI.setText(convertStringToXpath("(//input[@type='search'])"), data.get(managerStudentModel.getSendTo()).trim(), Keys.ENTER);
//      WebUI.clickElement(dataNeedClick("no 6, stu (Student)"));
//    } else {
//      WebUI.clickElement(inputSearchSendTo);
//      WebUI.clickElement(convertStringToXpath("(//input[@type='search'])"));
//      WebUI.setText(convertStringToXpath("(//input[@type='search'])"), data.get(managerStudentModel.getSendTo()).trim(), Keys.ENTER);
//      WebUI.clickElement(dataNeedClick("no 6, stu (Student)"));
//    }
//  }

  // export excel
  private void exportData(Hashtable<String, String> data) {
    WebUI.clickElement(btnExport);
    WebUI.sleep(5);
    File file = WebUI.verifyFileDownloadedWithJS_ContainsData("student_export_");
    readFileCSV(file);
//    openDownloadedFile(file.getPath());
    removePermissionFromFile(file.getPath());
    deleteFileInDirectory(file.getPath());
  }



  // import excel
  private void importCSVDataSuccess(Hashtable<String, String> data, boolean isDelete, String pathIndex) {
    if (Boolean.TRUE.equals(isDelete)) {
      dataNeededForAllSoNotAdded(data);
      if (filterExistOrDelete(1, data)) {
        deleteStudent(data, true);
      }
    }
    String path =  getPathFileCSV(pathIndex);
    WebUI.clickElement(btnImport);
    WebUI.sleep(5);
    WebUI.uploadFileWithLocalForm(btnChoseFile, path);
    WebUI.sleep(10);
    WebUI.clickElement(btnContinue);
//    dropdownImportFilter();
    WebUI.clickElement(btnImportRoster);
    verifySummaryImportData();
  }

  // filter table if exist data after delete data
  private boolean filterExistOrDelete(int index, Hashtable<String, String> data) {
    WebUI.sleep(5);
    List<WebElement> trs = WebUI.getWebElements(convertStringToXpath("(//table)["+index+"]/tbody/tr"));
    for (WebElement tr : trs){
      List<WebElement> tds = tr.findElements(By.tagName("td"));
      for (WebElement td : tds){
        if (index == 1) {
          if (td.getText().equalsIgnoreCase(data.get(managerStudentModel.getStudentID()).trim())) {
            return true;
          }
          if (td.getText().equalsIgnoreCase(data.get(managerStudentModel.getLastName()).trim())){
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

  // read file csv export
  private void readFileCSV(File file){
    CSVReader reader = null;
    List<String> data = new ArrayList<>();
    try {
      reader = new CSVReader(new FileReader(file));
      String[] cells = reader.readNext();
      while ((cells = reader.readNext()) != null) {
        data.addAll(Arrays.asList(cells));
      }
      filterExistDataExport(data);
    } catch (IOException | CsvValidationException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  // filter data export table compare data file csv
  private void filterExistDataExport(List<String> data) {
    data = data.stream().map(x -> x.equalsIgnoreCase("Active") ? "Enabled" : x).collect(Collectors.toList());
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        LogUtils.info("Row " + rowIdx + ":");
        for (int i = 0; i < cells.size() - 1; i++) {
          String cellText = cells.get(i).getText();
          if (data.contains(cellText)) {
            LogUtils.info("Cell " + (i + 1) + ": " + cellText);
            Assert.assertTrue(true, "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
          }
        }
        rowIdx++;
      }
    }
  }


  // delete file after verify
  private void deleteFileInDirectory(String pathDirectory) {
    try {
      Path file = Path.of(pathDirectory);
      Files.deleteIfExists(file);
      System.out.println("File deleted successfully.");
    } catch (IOException e) {
      System.out.println("Error deleting the file: " + e.getMessage());
    }
  }
  // remove permission file
  private  void removePermissionFromFile(String filePath) {
    try {
      Path file = Path.of(filePath);

      // Get the current permissions
      Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(file);

      // Create a new set without user access permissions
      Set<PosixFilePermission> modifiedPermissions = new HashSet<>(permissions);
      modifiedPermissions.remove(PosixFilePermission.OWNER_READ);
      modifiedPermissions.remove(PosixFilePermission.OWNER_WRITE);
      modifiedPermissions.remove(PosixFilePermission.OWNER_EXECUTE);

      // Set the modified permissions
      Files.setPosixFilePermissions(file, modifiedPermissions);
      System.out.println("User access permissions removed successfully.");
    } catch (Exception e) {
      System.out.println("Error removing user access permissions: " + e.getMessage());
    }
  }


  // convert file excel to csv
  private static void excelToCSVConvert(String inputPath, String outputPath, String delimiter, String sheetIndex) {
    File inputFile = new File(inputPath);
    File outputFile = new File(outputPath);
    StringBuilder data = new StringBuilder();
    try (FileOutputStream fos = new FileOutputStream(outputFile);
         XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(inputFile))) {
      XSSFSheet sheet = workbook.getSheet(sheetIndex);
      for (Row row : sheet) {
        boolean isFirstCell = true;
        for (Cell cell : row) {
          if (!isFirstCell) {
            data.append(delimiter);
          } else {
            isFirstCell = false;
          }
          switch (cell.getCellType()) {
            case BOOLEAN:
              data.append(cell.getBooleanCellValue());
              break;
            case NUMERIC:
              data.append((int)cell.getNumericCellValue());
              break;
            case STRING:
              data.append(cell.getStringCellValue());
              break;
            case BLANK:
              data.append("");
              break;
            default:
              data.append(cell);
          }
        }
        data.append("\n");
      }
      fos.write(data.toString().getBytes());
    } catch (Exception ioe) {
      ioe.printStackTrace();
    }
  }

  // import file csv data if error
  private void importCSVDataError(Hashtable<String, String> data, String pathIndex){
    String path = getPathFileCSV(pathIndex);
    WebUI.clickElement(btnImport);
    WebUI.sleep(5);
    WebUI.uploadFileWithLocalForm(btnChoseFile, path);
    WebUI.clickElement(btnContinue);
    WebUI.sleep(10);
    verifyMessageError(msgFormatFile);

  }

  // import csv with message
  private void importCSVDataErrorMsg(Hashtable<String, String> data, boolean isDelete, String pathIndex) {
    if (Boolean.TRUE.equals(isDelete)) {
      dataNeededForAllSoNotAdded(data);
      if (filterExistOrDelete(1, data)) {
        deleteStudent(data, true);
      }
    }
    String path = getPathFileCSV(pathIndex);
    WebUI.clickElement(btnImport);
    WebUI.sleep(5);
    WebUI.uploadFileWithLocalForm(btnChoseFile, path);
    WebUI.clickElement(btnContinue);
    WebUI.sleep(5);
//    dropdownImportFilter();
    WebUI.checkContainsAllValueOnTableByText(2, "You must specify a user name to add user to the system.");
    WebUI.checkContainsAllValueOnTableByText(2, "No error found.");
    WebUI.clickElement(btnImportRoster);
    WebUI.sleep(5);
    verifySummaryImportData();
  }


  // dropdown filter import action
  private void dropdownImportFilter() {
    WebUI.clickElement(dropdownFilterImport);
    WebUI.clickElement(inputSearchImport);
    String data = "Valid Records";
    WebUI.setText(inputSearchImport, data);
    switch (data) {
      case "Invalid Records":
        WebUI.clickElement(valueFilterImport("Invalid Records"));
        break;
      case "Valid Records":
        WebUI.clickElement(valueFilterImport("Valid Records"));
        break;
      default:
        WebUI.clickElement(dataNeedClick("All Records"));
        break;
    }
    WebUI.clickElement(btnFilter);
  }

  private By valueFilterImport(String name) {
    return convertStringToXpath("(//span[normalize-space()='" + name + "'])[1]");
  }

  // verify import summary
  private void verifySummaryImportData() {
    WebUI.verifyGetTextOfElementPresent(summaryImport,10);
    WebUI.sleep(5);
    WebUI.clickElement(returnManagerStudent);
    WebUI.sleep(5);
    verifyCurrentPage();
  }

  // print data


  // not using for add
  private void dataNeededForAllSoNotAdded(Hashtable<String, String> data) {
    WebUI.clickElement(inputSearchGlobal);
    WebUI.clearTextCtrlA(inputSearchGlobal);
    WebUI.setText(inputSearchGlobal, (data.get(managerStudentModel.getLastName()).isEmpty() || data.get(managerStudentModel.getLastName()).isBlank()) ? data.get(managerStudentModel.getStudentID()).trim() : data.get(managerStudentModel.getLastName()).trim(), Keys.ENTER);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
  }

  // popup send mail action
  private void popupConfirmActionSendMail(boolean cancel, String action) {
    if (Boolean.FALSE.equals(cancel)) {
      WebUI.scrollToElementToBottom(btnSendMail);
      if (WebUI.verifyElementPresent(btnSendMail, 10)) {
        WebUI.sleep(2);
        WebUI.clickElement(btnSendMail);
        WebUI.sleep(5);
      }
    } else {
      WebUI.scrollToElementToBottom(btnSendMailCancel);
      if (WebUI.verifyElementPresent(btnSendMailCancel, 10)) {
        WebUI.sleep(2);
        WebUI.clickElement(btnSendMailCancel);
      }
      verifyCurrentPage();
      WebUI.sleep(5);
    }
  }

  // popup pencil action
  private void popupConfirmActionPencil(boolean notCancel, String action) {
    if (notCancel) {
      switch (action) {
        case btnOk:
          WebUI.scrollToElementToBottom(dataNeedClick(btnOk));
          WebUI.clickElement(dataNeedClick(btnOk));
          break;
        case btnYes:
          WebUI.scrollToElementToBottom(dataNeedClick(btnYes));
          WebUI.clickElement(dataNeedClick(btnYes));
          break;
        case btnSave:
          WebUI.scrollToElementToBottom(dataNeedClick(btnSave));
          WebUI.clickElement(dataNeedClick(btnSave));
          break;
        case btnDelete:
          WebUI.scrollToElementToBottom(dataNeedClick(btnDelete));
          WebUI.clickElement(dataNeedClick(btnDelete));
          break;
        default:
          throw new NotFoundException("Button action dose not exist");
      }
    } else {
      switch (action) {
        case btnCancel:
          WebUI.scrollToElementToBottom(dataNeedClick(btnCancel));
          WebUI.clickElement(dataNeedClick(btnCancel));
          verifyCurrentPage();
          break;
        case btnNo:
          WebUI.scrollToElementToBottom(dataNeedClick(btnNo));
          WebUI.clickElement(dataNeedClick(btnNo));
          verifyCurrentPage();
          break;
        case btnX:
          WebUI.scrollToElementToTop(btnCloseX);
          WebUI.clickElement(btnCloseX);
          verifyCurrentPage();
          break;
        default:
          throw new NotFoundException("Button action dose not exist");
      }
    }
  }

  // dropdown action select
  private void clickDropdown(String action) {
    if (action.equalsIgnoreCase(btnPencil)) {
      final By actionPencil = convertStringToXpath("(//div[contains(@class,'ant-dropdown-trigger flex items-center cursor-pointer')])[1]");
      if (WebUI.verifyElementPresent(actionPencil, 10)) {
        WebUI.sleep(5);
        WebUI.clickElement(actionPencil);
      }
    } else if (action.equalsIgnoreCase(btnPrint)) {
      final By actionPrint = convertStringToXpath("(//div[contains(@class,'ant-dropdown-trigger flex items-center cursor-pointer')])[2]");
      if (WebUI.verifyElementPresent(actionPrint, 10)) {
        WebUI.sleep(5);
        WebUI.clickElement(actionPrint);
      }
    } else {
      final By actionMessage = convertStringToXpath("(//div[@title='Message'])[1]");
      if (WebUI.verifyElementPresent(actionMessage, 10)) {
        WebUI.sleep(5);
        WebUI.clickElement(actionMessage);
      }
    }
  }

  // dropdown action pencil
  private String dropdownActionPencil(String actionName) {
    WebUI.sleep(5);
    String[] arr = {"Edit Account", "Disable Account", "Enable Account", "Delete Account", "Manage Licenses", "Print Student Letter", "Print Parent Letter"};
    for (String acton : arr) {
      if (actionName.contains(acton)) {
//        if (acton.equalsIgnoreCase(actionDisable)) {
//          var disableOrEnableAccount = WebUI.getWebElement(convertStringToXpath("(//span[contains(text(),'" + acton + "')])[1]"));
//          if (disableOrEnableAccount.getText().equalsIgnoreCase(actionDisable)) {
//            WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + disableOrEnableAccount.getText() + "')])[1]"));
//            return disableOrEnableAccount.getTagName();
//          }
//          if (disableOrEnableAccount.getText().equalsIgnoreCase(actionEnable)) {
//            WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + disableOrEnableAccount.getText() + "')])[1]"));
//            return disableOrEnableAccount.getTagName();
//          }
//        }else {
//          WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + actionName + "')])[1]"));
//          return actionName;
//        }
        final By actionPencil = convertStringToXpath("(//span[contains(text(),'" + actionName + "')])[1]");
        if (WebUI.verifyElementPresent(actionPencil, 10))
        WebUI.clickElement(actionPencil);
        return actionName;
      }
    }
    return actionName;
  }

  // dropdown action send mail
  private void dropdownActionSendMail(String actionName) {
    String[] arr = {"Print Student Letter", "Print Parent Letter"};
    for (String acton : arr) {
      if (acton.contains(actionName)) {
        WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + actionName + "')])[1]"));
        return;
      }
    }
  }

  // verify message request
  private void verifyFieldRequest(String message) {
    if (WebUI.verifyElementPresent(convertStringToXpath("//span[normalize-space()='" + message + "']"), 10)) {
      WebUI.verifyElementTextContains(convertStringToXpath("//span[normalize-space()='" + message + "']"), message);
    }
  }

  // check return page
  private void verifyCurrentPage() {
    if (WebUI.getCurrentUrl().contains(pageMessage)) {
      getRedirectURL(pageMessage);
    } else if (WebUI.getCurrentUrl().contains(pageCurrent)) {
      getRedirectURL(pageCurrent);
    }else if (WebUI.getCurrentUrl().contains(dashboard)){
      getRedirectURL(dashboard);
    } else {
      getRedirectURL(pageUserStudent);
    }
    WebUI.sleep(5);
  }

  private void getRedirectURL(String url) {
    if (url.isEmpty()) return;
    WebUI.verifyContains(WebUI.getCurrentUrl(), url, "Move to Previous Page.");
  }

  private void verifyMessageSuccess(String message){
    if (WebUI.verifyElementPresent(alertMessageSuccess, 10)) {
      WebUI.verifyElementTextContains(alertMessageSuccess, message.trim());
    }
  }

  private void verifyMessageError(String message){
    if (WebUI.verifyElementPresent(alertMessageError, 10)) {
      WebUI.sleep(5);
      WebUI.verifyElementTextContains(alertMessageError, message.trim());
    }
  }

  private void importCSVDataTableError(Hashtable<String, String> data, String pathIndex){
    String path = getPathFileCSV(pathIndex);
    WebUI.clickElement(btnImport);
    WebUI.sleep(5);
    WebUI.uploadFileWithLocalForm(btnChoseFile, path);
    WebUI.clickElement(btnContinue);
    WebUI.sleep(5);
    WebUI.checkContainsAllValueOnTableByText(2, "You have already added a user with this username.");
    WebUI.clickElement(btnImportRoster);
    WebUI.sleep(5);
    verifySummaryImportData();
  }
}
