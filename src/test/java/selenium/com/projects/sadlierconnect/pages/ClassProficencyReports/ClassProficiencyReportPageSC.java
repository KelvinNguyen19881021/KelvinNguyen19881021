package selenium.com.projects.sadlierconnect.pages.ClassProficencyReports;

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
import selenium.com.projects.sadlierconnect.models.ClassProficiencyReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.LogUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;

public class ClassProficiencyReportPageSC extends CommonPageSC {
  private static final ExcelHelpers excelHelpers = new ExcelHelpers();
  private static final ClassProficiencyReportModel classProficiencyReportModel = new ClassProficiencyReportModel();

  public ClassProficiencyReportPageSC() {
    super();
    excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_CLASS_PROFICIENCY_REPORT_SC_PATH, "ClassProficiencyReport");
  }

  private By convertStringToXpath(String name) {
    return By.xpath(name);
  }

  private By dataNeedClick(String name) {
    return convertStringToXpath("(//span[contains(text(),'" + name + "')])[1]");
  }

  // visit page
  private final By pageReport = convertStringToXpath("//span[normalize-space()='Reports']");
  private final By visitPageClassProficiency = convertStringToXpath("//a[@href='/report/standardReport.html']");

  // filter
  private final By btnFilter = convertStringToXpath("//span[normalize-space()='Apply Filters']");
  // filter class
  private final By dropdownClass = convertStringToXpath("(//div[@class='ant-select-selector'])[1]");
  private final By inputSearchClass = convertStringToXpath("(//input[contains(@type,'text')])[2]");
  // filter student
  private final By dropdownStudent = convertStringToXpath("(//div[@class='ant-select-selector'])[2]");
  private final By inputSearchStudent = convertStringToXpath("(//input[contains(@type,'text')])[3]");
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
  private final By viewAssessment = convertStringToXpath("//a[@class='sc-icon-view-assessment']");
  private final By reportAssessment = convertStringToXpath("//a[@class='sc-icon-report-assessment']");

  // alert
  private final By alertMessage = convertStringToXpath("//div[@class='ant-alert-message']");

  private final By breadcrumb = convertStringToXpath("//span[@class='current']");


  public void openPageReport() {
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    WebUI.sleep(2);
    WebUI.clickElement(visitPageClassProficiency);
    WebUI.sleep(2);
    WebUI.waitForPageLoaded();
  }

  public void TC_ClassProficiency_01(Hashtable<String, String> data) {
    // 4. Click on Reports dropdown
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    // 3. On dropdown [Reports] click text "Class Proficiency"
    // [CP]_verify 1. Login successful, open dashboard
    //2. On dropdown of Report not have [Class Proficiency]
    WebUI.verifyElementNotPresent(visitPageClassProficiency, 10);
  }

  public void TC_ClassProficiency_02(Hashtable<String, String> data) {
    // 2. Click on Reports dropdown
    WebUI.sleep(2);
    WebUI.clickElement(pageReport);
    // 3. On dropdown [Reports] click text "Class Proficiency"
    if (WebUI.verifyElementPresent(visitPageClassProficiency, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(visitPageClassProficiency);
      WebUI.sleep(2);
      verifyCurrentPage();
    }
  }

  public void TC_ClassProficiency_03(Hashtable<String, String> data) {
    // 4. Not choose class
    // 5. At report click [Apply Filters] button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(2);
    // [CP]_display 'Message "You must select a class to run this report."
    verifyMessage("You must select a class to run this report.");
    WebUI.sleep(5);
  }

  public void TC_ClassProficiency_04(Hashtable<String, String> data) {
    // 4. click dropdown Class and select class
    WebUI.sleep(2);
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    WebUI.sleep(2);
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    WebUI.sleep(2);
    // [CP]_message - Message: "No graded assessments matching the selected criteria."
    final By notCriter = convertStringToXpath("//div[@class='empty-data']");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criteria.");
    WebUI.sleep(2);
    // [CP]_display - Screen not display [Print] and [Export] button- Screen not display [Print] and [Export] button
    WebUI.verifyElementNotVisible(btnPrint, 10);
    WebUI.verifyElementNotVisible(btnExport, 10);
    WebUI.sleep(2);
  }

  public void TC_ClassProficiency_05(Hashtable<String, String> data) {
    // 4. click dropdown Class and select class
    WebUI.sleep(2);
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
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
    // 6. At report Click Apply Filters button
    WebUI.sleep(2);
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();

    WebUI.expandRowsInTableReport(data.get(classProficiencyReportModel.getGrade()).trim());
    WebUI.sleep(5);
    // [CP]_display - - Show all report of class "Class 1" is correct:
    //    + English Language Arts
    //    + Mathematics
//    WebUI.expandAllRowsInTableReport();
//    WebUI.checkContainsRowValueOnTableByText(1, "English Language Arts");
    String path = getPathFileCSV("05");
    List<List<String>> result = readFileCSV(path);
    filterExistDataExport(result);
  }

  public void TC_ClassProficiency_06(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    // 4.  Choose student
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));

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
          - Language
          - Reading Informational
          - Reading Literature
       - Benchmark 2 - Section A
     + Mathematics
      - Grade 1
       - Operations And Algebraic Thinking
    */
    WebUI.expandRowsInTableReportEndData(data.get(classProficiencyReportModel.getSubGrade()).trim());
    String path = getPathFileCSV("06");
    List<List<String>> result = readFileCSV(path);
    filterExistDataExport(result);
  }

  public void TC_ClassProficiency_07(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    //4.  Choose student
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));

    //WebUI.sleep(2);
//    WebUI.clickElement(dropdownProduct);
//    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
//        WebUI.sleep(2);
//      WebUI.clickElement(inputSearchProduct);
//      WebUI.setText(inputSearchProduct, "Sadlier Math, Grade 6");
//      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Sadlier Math, Grade 6')]"));
//    }
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
    final By notCriter = convertStringToXpath("//div[@class='empty-data']");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criteria.");
  }

  public void TC_ClassProficiency_08(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classProficiencyReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classProficiencyReportModel.getProduct()).trim() + "')]"));
    }
    // 6. Checked checkbox "Formative".
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
    WebUI.expandRowsInTableReportFromStartToEnd(data.get(classProficiencyReportModel.getSubject()).trim(), data.get(classProficiencyReportModel.getStandard()).trim());
    WebUI.sleep(5);
    // [CP]_verify - - Show Report of "Formative" type is correct:
    //   - Mathematics
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 1
    //   - Display standards of resource mapping with score is correct:
    //     +  1.OA.1 have 1 student score is 90+
    //     + 1.OA.8 have 1 student score is 90+
    //- Hover on standard display information correct
    filterExistDataExport(result);
    detectHoverReport(data.get(classProficiencyReportModel.getStandardHover()));
  }

  public void TC_ClassProficiency_09(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classProficiencyReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classProficiencyReportModel.getProduct()).trim() + "')]"));
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
    WebUI.expandRowsInTableReportFromStart(data.get(classProficiencyReportModel.getSubject()).trim());
    String path = getPathFileCSV("09");
    List<List<String>> result = readFileCSV(path);
    WebUI.sleep(5);
    // [CP]_verify - - Show Report of "Assessment" type is correct:
    //   - English Language Arts
    //     + Grade 8:
    //        - Language
    //        - Reading Informational
    //        - Reading Literature
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 1
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 0
    //   - Display standards of resource mapping with score is correct
    //   - Hover on standard display information correct
    filterExistDataExport(result);
    detectHoverReport(null);
  }

  public void TC_ClassProficiency_10(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    // 5. Choose Students
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    // 6. Products choose All
    WebUI.sleep(2);
    WebUI.clickElement(dropdownProduct);
    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
      WebUI.sleep(2);
      WebUI.clickElement(inputSearchProduct);
      WebUI.setText(inputSearchProduct, data.get(classProficiencyReportModel.getProduct()).trim());
      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + data.get(classProficiencyReportModel.getProduct()).trim() + "')]"));
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
    // [CP]_display - Screen display text "No graded assessments matching the selected criteria."
    final By notCriter = convertStringToXpath("//div[@class='empty-data']");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criteria.");
  }

  public void TC_ClassProficiency_11(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));

    //WebUI.sleep(2);
//    WebUI.clickElement(dropdownProduct);
//    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
//        WebUI.sleep(2);
//      WebUI.clickElement(inputSearchProduct);
//      WebUI.setText(inputSearchProduct, "Sadlier Math, Grade 6");
//      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Sadlier Math, Grade 6')]"));
//    }
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
    WebUI.expandRowsInTableReportFromStartToEnd(data.get(classProficiencyReportModel.getSubject()).trim(), data.get(classProficiencyReportModel.getStandard()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Show Report of "Custom" type is correct:
    //   - Mathematics
    //     + Grade 1:
    //        - Operations And Algebraic Thinking
    //   - Display number of Students is 1
    //   - Display range score of student is correct:
    //       + <65 is 0
    //       + 65-79 is 0
    //       + 80-89 is 0
    //       + 90+ is 1
    //   - Display standards of resource mapping with score is correct
    //   - Hover on standard display information correct
    filterExistDataExport(result);
    detectHoverReport(null);
  }

  public void TC_ClassProficiency_12(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));

    //WebUI.sleep(2);
//    WebUI.clickElement(dropdownProduct);
//    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
//        WebUI.sleep(2);
//      WebUI.clickElement(inputSearchProduct);
//      WebUI.setText(inputSearchProduct, "Sadlier Math, Grade 6");
//      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Sadlier Math, Grade 6')]"));
//    }
    // 5.  Checked checkbox "Custom".
    //Uncheck "Formative", "Assessment", "Program"
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
    // [CP]_display - Screen display text "No graded assessments matching the selected criteria."
    final By notCriter = convertStringToXpath("//div[@class='empty-data']");
    WebUI.verifyElementTextContains(notCriter, "No graded assessments matching the selected criteria.");
  }

  public void TC_ClassProficiency_13(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    //
    WebUI.sleep(2);
    WebUI.clickElement(dropdownStudent);
    WebUI.clickElement(inputSearchStudent);
    WebUI.setText(inputSearchStudent, data.get(classProficiencyReportModel.getStudent()).trim());
    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));
    WebUI.sleep(1);
    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='" + data.get(classProficiencyReportModel.getStudent()).trim() + ", " + data.get(classProficiencyReportModel.getStudent()).trim() + "']"));

    //WebUI.sleep(2);
//    WebUI.clickElement(dropdownProduct);
//    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
//        WebUI.sleep(2);
//      WebUI.clickElement(inputSearchProduct);
//      WebUI.setText(inputSearchProduct, "Sadlier Math, Grade 6");
//      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Sadlier Math, Grade 6')]"));
//    }
    // 5. Checked checkbox "Custom", "Formative", "Assessment", "Program"
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
    // 5. At report Click Apply Filters button
    WebUI.clickElement(btnFilter);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
    String path = getPathFileCSV("13");
    List<List<String>> result = readFileCSV(path);
    WebUI.expandRowsInTableReportFromStartToEndStandard(data.get(classProficiencyReportModel.getSubject()).trim(), data.get(classProficiencyReportModel.getStandard()).trim());
    WebUI.sleep(5);
    // [CP]_verify - Display name of domain of resource "English Language Arts/Grade 8"
    //- Language
    //- Reading Informational
    //- Reading Literature
    //- Display content of standard "8.L.6" correct:
    filterExistDataExport(result);
    detectHoverReport(data.get(classProficiencyReportModel.getStandard()));
  }

  public void TC_ClassProficiency_15(Hashtable<String, String> data) {
    WebUI.sleep(2);
    // 4. click dropdown Class and select class
    WebUI.clickElement(dropdownClass);
    WebUI.clickElement(inputSearchClass);
    WebUI.setText(inputSearchClass, data.get(classProficiencyReportModel.getClazz()).trim());
    WebUI.clickElement(convertStringToXpath("(//span[contains(text(),'" + data.get(classProficiencyReportModel.getClazz()).trim() + "')])[1]"));
    //
//    WebUI.clickElement(dropdownStudent);
//    WebUI.clickElement(inputSearchStudent);
//    WebUI.setText(inputSearchStudent, "1");
//    WebUI.scrollToElementToBottom(convertStringToXpath("//span[normalize-space()='1, stu']"));
//    WebUI.clickElement(convertStringToXpath("//span[normalize-space()='1, stu']"));
    //WebUI.sleep(2);
//    WebUI.clickElement(dropdownProduct);
//    if (WebUI.verifyElementPresent(inputSearchProduct, 10)) {
//      WebUI.sleep(2);
//      WebUI.clickElement(inputSearchProduct);
//      WebUI.setText(inputSearchProduct, "Sadlier Math, Grade 6");
//      WebUI.clickElement(convertStringToXpath("//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'Sadlier Math, Grade 6')]"));
//    }

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
    File file = WebUI.verifyFileDownloadedWithJS_ContainsData("classProficiencyReport");
    var lstData = readFileCSVExplain(file.getPath());
    var rows = WebUI.expandAllRowsInTableReport();
    filterExistDataExportExplainAll(lstData, rows);
    detectHoverReport(null);
//    openDownloadedFile(file.getPath());
    removePermissionFromFile(file.getPath());
    deleteFileInDirectory(file.getPath());
  }


  private void detectHoverReport(String data) {
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
    } else {
      int idxPopup = 1;
      for (int i = 0; i < rows.size(); i++) {
        WebElement row = rows.get(i);
        WebUI.scrollToElementToBottom(row);
        var check = row.getText().split("(\\n|\\s\\d\\n)");
        List<String> rowResult = new ArrayList<>(Arrays.asList(check));
        String[] lstData = null;
        if (data != null) {
          lstData = data.split(", ");
        }
        if (lstData == null ) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          List<WebElement> spans = cells.get(0).findElements(By.tagName("span"));
          for (WebElement span : spans) {
            if (Objects.equals(span.getAttribute("class"), "")) {
              LogUtils.info("Row : " + (i + 1) + " and standards : " + cells.get(0).getText());
              WebUI.sleep(1);
              WebUI.mouseHoverToElement(span);
              WebUI.sleep(1);
              if (WebUI.verifyElementVisible(convertStringToXpath("(//p[@id='popover-content'])["+idxPopup+"]"), 10)) {WebUI.sleep(1);
                WebUI.sleep(1);
                WebUI.verifyGetTextOfElementPresent(convertStringToXpath("(//p[@id='popover-content'])["+idxPopup+"]"), 10);
                WebUI.sleep(1);
                idxPopup++;
              }
              WebUI.sleep(2);
              WebUI.moveToOffset(-100, 0);
              WebUI.sleep(1);
              break;
            }
          }
        }else {
          for (String txt : lstData) {
            if (rowResult.get(0).trim().equalsIgnoreCase(txt)) {
              LogUtils.info("Row " + (i + 1) + ":");
              WebUI.mouseHover(convertStringToXpath("//span[normalize-space()='" + txt + "']"));
              WebUI.sleep(2);
              if (WebUI.verifyElementVisible(convertStringToXpath("(//p[@id='popover-content'])["+idxPopup+"]"), 6)) {
                WebUI.sleep(1);
                WebUI.verifyGetTextOfElementPresent(convertStringToXpath("(//p[@id='popover-content'])["+idxPopup+"]"), 10);
                WebUI.sleep(1);
                idxPopup++;
              }
              WebUI.sleep(2);
              WebUI.moveToOffset(-100, 0);
              continue;
            }
          }
        }
      }
    }
  }


//  WebElement row = rows.get(i);
//        WebUI.scrollToElementToBottom(row);
//  var check = row.getText().split("(\\n|\\s\\d\\n)");
//  List<String> rowResult = new ArrayList<>(Arrays.asList(check));
//  String[] lstData = null;
//        if (lstData != null && lstData.length == 1) {
//    lstData = data.split(", ");
//  }
//  for (String txt : lstData) {
//    if (rowResult.get(0).trim().equalsIgnoreCase(txt)) {
//      LogUtils.info("Row " + (i + 1) + ":");
//      WebUI.mouseHover(convertStringToXpath("//span[normalize-space()='" + txt + "']"));
//      WebUI.sleep(2);
//      WebUI.scrollToElementToBottom(By.id("popover-content"));
//      WebUI.verifyGetTextOfElementPresent(By.id("popover-content"), 10);
//      WebUI.sleep(2);
//      continue;
//    }
//  }


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

  private void detectTable(Hashtable<String, String> data) {
    List<WebElement> rows = WebUI.getWebElements(convertStringToXpath("//tbody/tr"));
    int rowIdx = 1;
    int count = 0;
    for (WebElement row : rows) {
      LogUtils.info("Row " + rowIdx + ":");
      if (row.getText().contains(String.join(", ", Collections.nCopies(2, data.get(classProficiencyReportModel.getStudent()).trim())))) {
        List<WebElement> leftCells = row.findElements(convertStringToXpath("(//tr)[" + rowIdx + "]"));
        // (//tr)[1]/following::tr[3]/following::tr[1]/td row 1
        // (//tr)[2]/following::tr[3]/following::tr[1]/td row 2
        List<WebElement> cells = row.findElements(convertStringToXpath("(//tr)[" + rowIdx + "]/following::tr[3]/following::tr[1]/td"));
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
      rowIdx++;
    }
    System.out.println();
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
//        var check = (row.getText().split("(\\n|\\s\\d\\n)").length > row.getText().split("\n([0-9])").length) ? row.getText().split("(\\n|\\s\\d\\n)") : row.getText().split("\n([0-9])");
        var check = row.getText().split("(\\n|\\s\\d\\n)");
        List<String> rowResult = new ArrayList<>(Arrays.asList(check));
        if (rowResult.get(0).trim().equalsIgnoreCase(lst.get(0).trim())) {
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
          if (row.getText().split("(\\n|\\s\\d\\n)")[0].trim().equalsIgnoreCase(lst.get(idx))) {
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
        if (row.getText().split("(\\n|\\s\\d\\n)")[0].equalsIgnoreCase(lst.get(0))) {
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
      fileExcel = "/src/test/resources/testdataSC/SC_Class_Proficiency_Report.xlsx";
    } else if (osName.toLowerCase().contains("win")) {
      fileExcel = "\\src\\test\\resources\\testdataSC\\SC_Class_Proficiency_Report.xlsx";
    } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
      fileExcel = "/src/test/resources/testdataSC/SC_Class_Proficiency_Report.xlsx";
    }
    String path = System.getProperty("user.dir") + fileExcel;
    if (!path.isEmpty()) {
      String outPath05 = getPathFileCSV("05"), outPath06 = getPathFileCSV("06"), outPath08 = getPathFileCSV("08"), outPath09 = getPathFileCSV("09"), outPath10 = getPathFileCSV("10");
      String outPath11 = getPathFileCSV("11"), outPath12 = getPathFileCSV("12"), outPath13 = getPathFileCSV("13");
      excelToCSVConvert(path, outPath05, ",", "TC_ClassProficiency_05");
      excelToCSVConvert(path, outPath06, ",", "TC_ClassProficiency_06");
      excelToCSVConvert(path, outPath08, ",", "TC_ClassProficiency_08");
      excelToCSVConvert(path, outPath09, ",", "TC_ClassProficiency_09");
      excelToCSVConvert(path, outPath10, ",", "TC_ClassProficiency_10");
      excelToCSVConvert(path, outPath11, ",", "TC_ClassProficiency_11");
      excelToCSVConvert(path, outPath12, ",", "TC_ClassProficiency_12");
      excelToCSVConvert(path, outPath13, ",", "TC_ClassProficiency_13");
    }
  }

  private String getPathFileCSV(String path) {
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().contains("mac")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/report/ClassProficiencyReportTemplate_" + path + ".csv";
    } else if (osName.toLowerCase().contains("win")) {
      return System.getProperty("user.dir") + "\\src\\test\\resources\\testdataSC\\report\\ClassProficiencyReportTemplate_" + path + ".csv";
    } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
      return System.getProperty("user.dir") + "/src/test/resources/testdataSC/report/ClassProficiencyReportTemplate_" + path + ".csv";
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
    String pageClassProficiency = "/report/standardReport.html";
    String pageClassProficiencyDetail = "/assessment/class-assessment-report/detail";
    String resourceView = "/resource/view";
    if (WebUI.getCurrentUrl().contains(pageClassProficiency)) {
      getRedirectURL(pageClassProficiency);
    } else if (WebUI.getCurrentUrl().contains(resourceView)) {
      getRedirectURL(resourceView);
    } else {
      getRedirectURL(pageClassProficiencyDetail);
    }
    WebUI.sleep(2);
  }

  private void getRedirectURL(String url) {
    if (url.isEmpty()) return;
    WebUI.verifyContains(WebUI.getCurrentUrl(), url, "Move to Previous Page.");
  }
}
