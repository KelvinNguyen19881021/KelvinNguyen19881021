package selenium.com.projects.sadlierconnect.pages.ClassAssessmentReport;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.ClassAssessmentReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.LogUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;

public class ClassAssessmentReportPageSC extends CommonPageSC {
  private static final ExcelHelpers excelHelpers = new ExcelHelpers();
  private static final ClassAssessmentReportModel classAssessmentReportModel = new ClassAssessmentReportModel();

  public ClassAssessmentReportPageSC() {
    super();
    excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_CLASS_ASSESSMENT_REPORT_SC_PATH, "ClassAssessmentReport");
  }

  private By convertStringToXpath(String name) {
    return By.xpath(name);
  }

  private By dataNeedClick(String name) {
    return convertStringToXpath("(//span[contains(text(),'" + name + "')])[1]");
  }

  // visit page
  private final By pageReport = convertStringToXpath("//span[normalize-space()='Reports']");
  private final By visitPageClassAssessment = convertStringToXpath("//a[@href='/report/class-assessment']");

  // filter
  private final By btnFilter = convertStringToXpath("//span[normalize-space()='Apply Filters']");
  // filter class
  private final By dropdownClass = convertStringToXpath("(//div[@class='ant-select-selector'])[1]");
  private final By inputSearchClass = convertStringToXpath("(//input[contains(@type,'text')])[2]");
  // filter student
  private final By dropdownStudent = convertStringToXpath("(//div[@class='ant-select-selector'])[2]");
  private final By inputSearchStudent = convertStringToXpath("//div[contains(@class,'ant-select-dropdown select-student-group assignment-report ant-select-dropdown-placement-bottomLeft')]//div//input[@type='text']");
  // filter product
  private final By dropdownProduct = convertStringToXpath("(//div[contains(@class,'ant-select-selector')])[3]");
  private final By inputSearchProduct = convertStringToXpath("(//input[contains(@type,'text')])[4]");
  // checkbox
  private final By checkboxProgram = convertStringToXpath("//input[@value='PROGRAM']");
  private final By checkboxFormative = convertStringToXpath("//input[@value='FORMATIVE']");
  private final By checkboxAssessment = convertStringToXpath("//input[@value='ASSESSMENT']");
  private final By checkboxCustom = convertStringToXpath("//input[@value='CUSTOM']");

  //btn
  private final By btnPrint = convertStringToXpath("//i[@class='icon-print']");
  private final By btnExport = convertStringToXpath("//div[@class='btn-default']");
  private final By btnBack = convertStringToXpath("//span[normalize-space()='Back']");

  // view
  private final By viewAssessment = convertStringToXpath("(//a[@class='sc-icon-view-assessment'])");
  private final By reportAssessment = convertStringToXpath("(//a[@class='sc-icon-report-assessment'])");

  // alert
  private final By alertMessage = convertStringToXpath("//div[@class='ant-alert-message']");

  private final By breadcrumb = convertStringToXpath("//span[@class='current']");


  public void openPageReport() {
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    WebUI.sleep(2);
    WebUI.clickElement(visitPageClassAssessment);
    WebUI.sleep(2);
    WebUI.waitForPageLoaded();
  }

  public void TC_ClassAssessment_01(Hashtable<String, String> data) {
    // 4. Click on Reports dropdown
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    // 3. On dropdown [Reports] click text "Class Assessment"
    // [CP]_verify 1. Login successful, open dashboard
    //2. On dropdown of Report not have [Class Assessment]
    WebUI.verifyElementNotPresent(visitPageClassAssessment, 10);
  }

  public void TC_ClassAssessment_02(Hashtable<String, String> data) {
    // 2. Click on Reports dropdown
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    // 3. On dropdown [Reports] click text "Class Assessment"
    if (WebUI.verifyElementPresent(visitPageClassAssessment, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(visitPageClassAssessment);
      WebUI.sleep(2);
      verifyCurrentPage();
    }
  }

  public void TC_ClassAssessment_03(Hashtable<String, String> data) {
    // 4. Not choose class
    // 5. At report click [Apply Filters] button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(2);
    // [CP]_display 'Message "You must select a class to run this report."
    verifyMessage("You must select a class to run this report.");
    WebUI.sleep(5);
  }

  public void TC_ClassAssessment_04(Hashtable<String, String> data) {
    // 4. click dropdown Class and select class
    WebUI.sleep(2);
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    WebUI.sleep(2);
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    WebUI.sleep(2);
    // [CP]_message - Message: "No graded assessments matching the selected criteria."
    final By notCriter = convertStringToXpath("//p[contains(text(),'No graded assessments matching the selected criter')]");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criter");
    WebUI.sleep(2);
    // [CP]_display - Screen not display [Print] and [Export] button- Screen not display [Print] and [Export] button
    WebUI.verifyElementNotVisible(btnPrint, 10);
    WebUI.verifyElementNotVisible(btnExport, 10);
    WebUI.sleep(2);
  }

  public void TC_ClassAssessment_05(Hashtable<String, String> data) {
    // 4. click dropdown Class and select class
    WebUI.sleep(2);
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    // 5. At report Click Apply Filters button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("05");
    List<List<String>> result = readFileCSV(path);
    WebUI.sleep(5);
    // [CP]_display - - Show all report of class "Class 1" is correct:
    //    + English Language Arts
    //    + Mathematics
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_06(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    // 4.  Choose student
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));


    // 5. Checked Formative, Assessment, Program, Custom
    if (!WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (!WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (!WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (!WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 6. Click [Apply Filters] button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    /*- Show all report of class "Class 1" is correct:
     + English Language Arts
       - Grade 8
       -  New York Progress ELA - Grade 8
       - Benchmark Assessments
       - Benchmark Assessments
       - Benchmark 2 - Section A
     + Mathematics
        - Grade 1
         - Sadlier Math - Grade 1
         - Student Practice
         - Chapter 5
         - Lesson 5-4: Mental Math
        - Grade 2
         - Progress in Mathematics - Grade 2
         - Assessments
         - Chapter 7
         - Post Test
    */
    WebUI.expandAllRowsInTableReport();
    String path = getPathFileCSV("06");
    List<List<String>> result = readFileCSV(path);
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_07(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //4.  Choose student
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));


    // 5. Uncheck Formative, Assessment, Program, Custom
    if (WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    // [CP]_display - Screen display text "No graded assessments matching the selected criteria."
    final By notCriter = convertStringToXpath("//p[contains(text(),'No graded assessments matching the selected criter')]");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criter");
  }

  public void TC_ClassAssessment_08(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classAssessmentReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classAssessmentReportModel.getProduct()).trim() + "')]"));
    }
    // 7. Checked checkbox "Formative".
    //Uncheck "Assessment", "Program", "Custom"
    if (!WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 8. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("08");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReport(data.get(classAssessmentReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Formative" type is correct:
    //  - English Language Arts
    //   - Mathematics
    //   - Display number of Students is 1
    //   - Display range score of resource "English Language Arts" is correct:
    //       + <65 is 1
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 0
    //- Display range score of resource "Mathematics" is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 1
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_09(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classAssessmentReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classAssessmentReportModel.getProduct()).trim() + "')]"));
    }
    // 7. Checked checkbox "Assessment".
    //Uncheck "Formative", "Program", "Custom"
    if (WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (!WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 8. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("09");
    List<List<String>> result = readFileCSV(path);
//    WebUI.expandAllRowsInTableReport();
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Assessment" type is correct:
    //   - English Language Arts (Grade 8)
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 1
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 0
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_10(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classAssessmentReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classAssessmentReportModel.getProduct()).trim() + "')]"));
    }
    // 7. Checked checkbox "Program".
    //Uncheck "Formative", "Assessment", "Custom"
    if (WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (!WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 8. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("10");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReport(data.get(classAssessmentReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Program" type is correct:
    //   - Mathematics (Grade 2)
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 1
    //       + 90+ is 0
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_11(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));


    // 5. Uncheck Formative, Assessment, Program, Custom
    if (WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (!WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("11");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReport(data.get(classAssessmentReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Custom" type is correct:
    //   - Mathematics (Grade 1)
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 1
    //       + 90+ is 0
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_12(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));

    // 5. Uncheck Formative, Assessment, Program, Custom
    if (!WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (!WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("12");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReport(data.get(classAssessmentReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Formative" type is correct:
    //  - English Language Arts (Grade 1)
    //   - Mathematics (Grade 1, Grade 2)
    //   - Display number of Students is 1
    //   - Display range score of resource "English Language Arts: Grade 1" is correct:
    //       + <65 is 1
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 0
    //- Display range score of resource "Mathematics: Grade 1" is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 1
    //- Display range score of resource "Mathematics: Grade 2" is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 1
    //       + 90+ is 0
    filterExistDataExport(result);
  }

  public void TC_ClassAssessment_13(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));


    // 5. Checked checkbox "Formative", "Assessment", "Program".
    //Uncheck  "Custom"
    if (!WebUI.verifyElementClickable(checkboxFormative)) {
      WebUI.clickElement(checkboxFormative);
    }
    if (!WebUI.verifyElementClickable(checkboxAssessment)) {
      WebUI.clickElement(checkboxAssessment);
    }
    if (!WebUI.verifyElementClickable(checkboxProgram)) {
      WebUI.clickElement(checkboxProgram);
    }
    if (WebUI.verifyElementClickable(checkboxCustom)) {
      WebUI.clickElement(checkboxCustom);
    }
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("13");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReport(data.get(classAssessmentReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Formative" type is correct:
    //  - English Language Arts (Grade 1)
    //   - Mathematics (Grade 1, Grade 2)
    //   - Display number of Students is 1
    //   - Display range score of resource "English Language Arts: Grade 1/Grade8" is correct:
    //       + <65 is 1
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 0
    //- Display range score of resource "Mathematics: Grade 1" is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 1
    //- Display range score of resource "Mathematics: Grade 2" is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 1
    //       + 90+ is 0
    filterExistDataExport(result);
  }


  public void TC_ClassAssessment_14(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));

    // 5. At report Click Apply Filters button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    WebUI.expandRowsInTableReportByText(data.get(classAssessmentReportModel.getResource()).trim());
    WebUI.sleep(2);
    detectClickReportOrViewAssessment(data.get(classAssessmentReportModel.getResource()).trim(), false);
    WebUI.sleep(5);
    verifyCurrentPage();
    WebUI.verifyElementTextContains(breadcrumb, data.get(classAssessmentReportModel.getResource()));
    WebUI.clickElement(btnBack);
    verifyCurrentPage();
  }

  public void TC_ClassAssessment_15(Hashtable<String, String> data) {
    WebUI.sleep(5);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classAssessmentReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classAssessmentReportModel.getStudent()).trim() + ", " + data.get(classAssessmentReportModel.getStudent()).trim() + "']"));

    // 5. At report Click Apply Filters button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
//    5. Cick view report of resource, open resource detail
    WebUI.expandRowsInTableReportByText(data.get(classAssessmentReportModel.getResource()).trim());
    WebUI.sleep(2);
    // 6. Click on icon report assessment
    detectClickReportOrViewAssessment(data.get(classAssessmentReportModel.getResource()).trim(), true);
    WebUI.sleep(5);
    verifyCurrentPage();
    WebUI.getPageTitle();
    // [CP]_verify "- Open [Class Assessment Report] screen successful
    //- Display name of resource, class is correct
    //- Display report detail question answer correct and wrong of students"
    WebUI.verifyElementTextContains(convertStringToXpath("//span[@class='ant-select-selection-item']//span[contains(text(),'" + data.get(classAssessmentReportModel.getResource()).trim() + "')]"), data.get(classAssessmentReportModel.getResource()).trim());
    WebUI.verifyElementTextContains(convertStringToXpath("//span[@class='ant-select-selection-item']//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')]"), data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.sleep(2);
    detectTable(data);
    WebUI.clickElement(convertStringToXpath("//span[@class='btn-view']"));
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("15");
    List<List<String>> result = readFileCSV(path);
    System.out.println();
    detectResourceCorrectOrWrong(result);
    WebUI.sleep(2);
    WebUI.clickElement(btnBack);
    verifyCurrentPage();
  }

  private void detectClickReportOrViewAssessment(String data, boolean isReport) {
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      while (rowIdx <= rows.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        int sizeReportAssessment = WebUI.getWebElements(reportAssessment).size();
        int reportViewAssessment = WebUI.getWebElements(viewAssessment).size();
        if (row.getText().split("\n")[0].equalsIgnoreCase(data)) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (int i = 0; i < cells.size(); i++) {
            WebElement cell = cells.get(i);
            if (cell.getText().equalsIgnoreCase("|")) {
              if (Boolean.TRUE.equals(isReport)) {
                WebElement isClick = cell.findElement(convertStringToXpath("(//a[@class='sc-icon-report-assessment'])[" + sizeReportAssessment + "]"));
                if (isClick.isDisplayed()) {
                  isClick.click();
                  return;
                }
              } else {
                WebElement isClick = cell.findElement(convertStringToXpath("(//a[@class='sc-icon-view-assessment'])[" + reportViewAssessment + "]"));
                if (isClick.isDisplayed()) {
                  isClick.click();
                  return;
                }
              }
            }
          }
        }
        rowIdx++;
      }
    }
  }

  public void TC_ClassAssessment_17(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classAssessmentReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classAssessmentReportModel.getClazz()).trim() + "')])[1]"));

    // 5. At report Click Apply Filters button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
//    5. At report Click Apply Filters button
//    6. Click Export button
    WebUI.clickElement(btnExport);
    WebUI.sleep(2);
    // [CP]_verify - Export csv successfull
    //- Check show data correct."
    File file = WebUI.verifyFileDownloadedWithJS_ContainsData("assessmentReport");
    var lstData = readFileCSVExplain(file.getPath());
    var rows = WebUI.expandAllRowsInTableReport();
    filterExistDataExportExplainAll(lstData, rows);
//    openDownloadedFile(file.getPath());
    removePermissionFromFile(file.getPath());
    deleteFileInDirectory(file.getPath());
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
  private void removePermissionFromFile(String filePath) {
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

  // detect click
  private void detectTable(Hashtable<String, String> data) {
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("//tbody/tr"));
    int rowIdx = 1;
    for (WebElement row : rows) {
      if (row.getText().split("\n")[0].equalsIgnoreCase(String.join(", ", Collections.nCopies(2, data.get(classAssessmentReportModel.getStudent()).trim())))) {
        List<WebElement> leftCells = row.findElements(convertStringToXpath("(//tr)[" + (rowIdx + 1) + "]"));
        List<WebElement> cells = row.findElements(convertStringToXpath("(//tr)[" + rowIdx + "]/following::tr[3]/following::tr[1]/td"));
        for (WebElement cell : leftCells) {
          var totalScoreReview = cell.findElement(convertStringToXpath("(//td)[" + (((rowIdx + 1) % 2 == 0) ? (rowIdx + 1) : (rowIdx + 2)) + "]/div[1]/div[1]"));
          if (totalScoreReview.isDisplayed()) {
            totalScoreReview.click();
            WebUI.sleep(1);
          }
        }
        // (//tr)[1]/following::tr[3]/following::tr[1]/td row 1
        // (//tr)[2]/following::tr[3]/following::tr[1]/td row 2
        boolean isClick = false;
        if (Boolean.TRUE.equals(isClick)) {
          for (int i = 0; i < cells.size(); i++) {
            // .findElement(By.tagName("path")).getAttribute("d")
            var svg = cells.get(i).findElement(By.tagName("span")).findElement(By.tagName("svg"));
            WebUI.scrollToElementToBottom(svg);
            if (svg.isDisplayed()) {
              svg.click();
            }
            WebUI.sleep(1);
            WebUI.getTextElement(convertStringToXpath("(//span[contains(@class,'capital')])[" + (i + 1) + "]"));
            WebUI.sleep(1);
            WebUI.clickElement(convertStringToXpath("(//span[@class='close-tooltip cursor-pointer'][normalize-space()='×'])[" + (i + 1) + "]"));
            WebUI.sleep(1);
          }
        }
      }
      rowIdx++;
    }

  }

  // detect resource Correct Or Wrong
  private void detectResourceCorrectOrWrong(List<List<String>> results) {
    WebUI.switchToFrameByElement(convertStringToXpath("//iframe[@id='viewer']"));
    List<WebElement> resultQuestions = WebUI.getWebElements(convertStringToXpath("(//td[@class='question_number']//img)"));
    int count = -1;

    for (int ii = 1; ii < results.size(); ii++) {
      int idxData = 1;
      List<String> lstData = results.get(ii);
      for (int i = 0; i < resultQuestions.size(); i++) {
        if (idxData <= lstData.size()) {
          if (i == count) {
            continue;
          } else {
            var questionLabel = resultQuestions.get(i).findElement(By.xpath("parent::td")).getAttribute("questionlabel");
            if (Integer.parseInt(questionLabel) != 0) {
              WebUI.scrollToElementToBottom(convertStringToXpath("(//td[@class='question_number']//img)[" + (i + 1) + "]"));
              String text = WebUI.getWebElement(convertStringToXpath("(//td[@class='question_number']//img)[" + (i + 1) + "]")).getAttribute("src");
              String txt = lstData.get(idxData);
              if (checkIconCorrectOrWrong(text).contains(txt)) {
                LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". " + checkIconCorrectOrWrong(text));
                Assert.assertTrue(true, "Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text));
                ExtentReportManager.pass("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text));
              } else {
                LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text));
                Assert.fail("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text));
                ExtentReportManager.fail("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text));
              }
              idxData++;
            }
            if ((i + 1) < resultQuestions.size()) {
              var nextQuestionLabel = resultQuestions.get(i + 1).findElement(By.xpath("parent::td")).getAttribute("questionlabel");
              if (Integer.parseInt(nextQuestionLabel) == 0) {
                WebUI.scrollToElementToBottom(convertStringToXpath("(//td[@class='question_number']//img)[" + (i + 2) + "]"));
                String text2 = WebUI.getWebElement(convertStringToXpath("(//td[@class='question_number']//img)[" + (i + 2) + "]")).getAttribute("src");
                String txt = lstData.get(idxData);
                if (checkIconCorrectOrWrong(text2).contains(txt)) {
                  LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
                  Assert.assertTrue(true, "Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
                  ExtentReportManager.pass("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
                  count = i + 1;
                } else {
                  LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text2));
                  Assert.fail("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text2));
                  ExtentReportManager.fail("Question number: " + Integer.parseInt(questionLabel) + ". is not " + checkIconCorrectOrWrong(text2));
                }
              }
              idxData++;
            }
          }
        }
      }
    }
    WebUI.switchToDefaultContent();
    WebUI.scrollToPositionViewTop();
  }

  private String checkIconCorrectOrWrong(String text) {
    String tex = text.substring(text.lastIndexOf("/") + 1, text.lastIndexOf("."));
    switch (tex) {
      case "incorrectmark":
        return "incorrect";
      case "skipped":
        return "skip";
      case "correctcheck":
        return "correct";
      default:
        return tex;
    }
  }

  // read file csv export
  private List<List<String>> readFileCSV(String filePath) {
    File file = new File(filePath);
    CSVReader reader = null;
    List<List<String>> lstData = new ArrayList<>();
    try {
      reader = new CSVReader(new FileReader(file));
      String[] cells = reader.readNext();
      while ((cells = reader.readNext()) != null) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
          data.add(cells[i]);
        }
        lstData.add(data);
      }
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
    return lstData;
  }

  // filter data export table compare data file csv
  private void filterExistDataExport(List<List<String>> datas) {
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      int idxDatas = 1; // idxDatas List<List<String>> datas
      while (rowIdx <= rows.size() && idxDatas <= datas.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        var lst = datas.get(idxDatas - 1);
        if (row.getText().split("\n")[0].equalsIgnoreCase(lst.get(0))) {
          LogUtils.info("Row " + rowIdx + ":");
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (int i = 0; i <= cells.size() - 1; i++) {
            String cellText = cells.get(i).getText();
            for (int idxData = i; idxData < lst.size(); idxData++) {
              String txtData = lst.get(idxData);
              if (cellText.equalsIgnoreCase(txtData)) {
                LogUtils.info("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.assertTrue(txtData.equalsIgnoreCase(cellText), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                break;
              } else {
                LogUtils.error("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
              }
            }
          }
          idxDatas++;
        }
        rowIdx++;
      }
    }
  }

  // read file csv export
  private List<List<String>> readFileCSVExplain(String filePath) {
    File file = new File(filePath);
    CSVReader reader = null;
    List<List<String>> lstData = new ArrayList<>();
    try {
      reader = new CSVReader(new FileReader(file));
      String[] cells = reader.readNext();
      while ((cells = reader.readNext()) != null) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
          data.add(cells[i]);
        }
        lstData.add(data);
      }
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
    return lstData;
  }

  private void filterExistDataExportExplainAll(List<List<String>> datas, List<WebElement> rows) {
//    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      int idxDatas = 1; // idxDatas List<List<String>> datas
      while (rowIdx <= rows.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        var lst = datas.get(rowIdx - 1);
        int idx = 0;
        while (idx < lst.size()) {
          if (row.getText().split("\n")[0].trim().equalsIgnoreCase(lst.get(idx))) {
            LogUtils.info("Row " + rowIdx + ":");
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (int i = 0; i < cells.size(); i++) {
              String cellText = cells.get(i).getText();
              for (int idxData = i; idxData < lst.size(); idxData++) {
                String txtData = lst.get(idxData);
                if (cellText.equalsIgnoreCase(txtData)) {
                  LogUtils.info("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  Assert.assertTrue(txtData.equalsIgnoreCase(cellText), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  break;
                }
              }
            }
          }
          idx++;
        }
        rowIdx++;
      }
    }
  }

  // filter data export table compare data file csv
  private void filterExistDataExportExplain(List<List<String>> datas, List<WebElement> rows) {
//    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      int idxDatas = 1; // idxDatas List<List<String>> datas
      while (rowIdx <= rows.size() && idxDatas <= datas.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        var lst = datas.get(idxDatas - 1);
        if (row.getText().split("\n")[0].equalsIgnoreCase(lst.get(0))) {
          LogUtils.info("Row " + rowIdx + ":");
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (int i = 0; i <= cells.size() - 1; i++) {
            String cellText = cells.get(i).getText();
            for (int idxData = i; idxData < lst.size(); idxData++) {
              String txtData = lst.get(idxData);
              if (cellText.equalsIgnoreCase(txtData)) {
                LogUtils.info("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.assertTrue(txtData.equalsIgnoreCase(cellText), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                break;
              } else {
                LogUtils.error("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
              }
            }
          }
          idxDatas++;
        }
        rowIdx++;
      }
    }
  }

  //convert excel to csv
  public void excelToCSV() {
    String fileExcel = "";
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("mac")) {
      fileExcel = "/src/test/resources/testdataSC/SC_Class_Assessment_Report.xlsx";
    } else if (osName.toLowerCase().contains("win")) {
      fileExcel = "\\src\\test\\resources\\testdataSC\\SC_Class_Assessment_Report.xlsx";
    } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
      fileExcel = "/src/test/resources/testdataSC/SC_Class_Assessment_Report.xlsx";
    }
    String path = System.getProperty("user.dir") + fileExcel;
    if (!path.isEmpty()) {
      String outPath05 = getPathFileCSV("05"), outPath06 = getPathFileCSV("06"), outPath08 = getPathFileCSV("08"), outPath09 = getPathFileCSV("09"), outPath10 = getPathFileCSV("10");
      String outPath11 = getPathFileCSV("11"), outPath12 = getPathFileCSV("12"), outPath13 = getPathFileCSV("13"), outPath15 = getPathFileCSV("15");
      excelToCSVConvert(path, outPath05, ",", "TC_ClassAssessment_05");
      excelToCSVConvert(path, outPath06, ",", "TC_ClassAssessment_06");
      excelToCSVConvert(path, outPath08, ",", "TC_ClassAssessment_08");
      excelToCSVConvert(path, outPath09, ",", "TC_ClassAssessment_09");
      excelToCSVConvert(path, outPath10, ",", "TC_ClassAssessment_10");
      excelToCSVConvert(path, outPath11, ",", "TC_ClassAssessment_11");
      excelToCSVConvert(path, outPath12, ",", "TC_ClassAssessment_12");
      excelToCSVConvert(path, outPath13, ",", "TC_ClassAssessment_13");
      excelToCSVConvert(path, outPath15, ",", "TC_ClassAssessment_15");
    }
  }

  private String getPathFileCSV(String path) {
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("mac")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/report/ClassAssessmentReportTemplate_" + path + ".csv";
    } else if (osName.toLowerCase().contains("win")) {
      return System.getProperty("user.dir") + "\\src\\test\\resources\\testdataSC\\report\\ClassAssessmentReportTemplate_" + path + ".csv";
    } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/report/ClassAssessmentReportTemplate_" + path + ".csv";
    }
    return null;
  }

  // convert file excel to csv
  private static void excelToCSVConvert(String inputPath, String outputPath, String delimiter, String sheetName) {
    File inputFile = new File(inputPath);
    File outputFile = new File(outputPath);
    StringBuilder data = new StringBuilder();
    try (FileOutputStream fos = new FileOutputStream(outputFile); XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(inputFile))) {
      XSSFSheet sheet = workbook.getSheet(sheetName);
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
              data.append((int) cell.getNumericCellValue());
              break;
            case STRING:
              data.append(cell.getStringCellValue());
              break;
            case BLANK:
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


  private void verifyMessage(String message) {
    if (WebUI.verifyElementPresent(alertMessage, 10)) {
      WebUI.sleep(5);
      WebUI.verifyElementTextContains(alertMessage, message.trim());
    }
  }

  private void verifyCurrentPage() {
    String pageClassAssessment = "/report/class-assessment";
    String pageClassAssessmentDetail = "/assessment/class-assessment-report/detail";
    String resourceView = "/resource/view";
    if (WebUI.getCurrentUrl().contains(pageClassAssessment)) {
      getRedirectURL(pageClassAssessment);
      WebUI.sleep(1);
      return;
    } else if (WebUI.getCurrentUrl().contains(resourceView)) {
      getRedirectURL(resourceView);
      WebUI.sleep(1);
      return;
    } else {
      getRedirectURL(pageClassAssessmentDetail);
      WebUI.sleep(1);
      return;
    }
  }

  private void getRedirectURL(String url) {
    if (url.isEmpty()) return;
    WebUI.verifyContains(WebUI.getCurrentUrl(), url, "Move to Previous Page.");
  }
}
