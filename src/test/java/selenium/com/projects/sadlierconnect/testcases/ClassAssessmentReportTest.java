package selenium.com.projects.sadlierconnect.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCClassAssessmentReport;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.ClassAssessmentReport.ClassAssessmentReportPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class ClassAssessmentReportTest extends BaseTest {
  private LoginPageSC loginPageSC;
  private ClassAssessmentReportPageSC classAssessmentReportPageSC;

  public ClassAssessmentReportTest() {
    this.loginPageSC = new LoginPageSC();
    this.classAssessmentReportPageSC = new ClassAssessmentReportPageSC();
    this.classAssessmentReportPageSC.excelToCSV();
  }



  //filter
  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 1, description = "Check login successful", dataProvider = "getClassAssessmentReportDataHashTable001", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_01(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestNoReport();
    // 2. Open page Class Assessment Report
    //3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_01(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 2, description = "Check display [Assessment Report] successful", dataProvider = "getClassAssessmentReportDataHashTable002", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_02(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_02(data);
  }


  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 3, description = "Check Show Report when not select class filter", dataProvider = "getClassAssessmentReportDataHashTable003", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_03(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_03(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 4, description = "Check Apply Filter for specific class, specific student, specific product", dataProvider = "getClassAssessmentReportDataHashTable004", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_04(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_04(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 5, description = "Check show report of class", dataProvider = "getClassAssessmentReportDataHashTable005", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_05(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_05(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 6, description = "Check show report of class", dataProvider = "getClassAssessmentReportDataHashTable006", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_06(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_06(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 7, description = "Check filter with class and student but not choose any assessment type", dataProvider = "getClassAssessmentReportDataHashTable007", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_07(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_07(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 8, description = "Check show report correct with assessment type is \"Formative\"", dataProvider = "getClassAssessmentReportDataHashTable008", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_08(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_08(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 9, description = "Check show report correct with assessment type is \"Assessment\"", dataProvider = "getClassAssessmentReportDataHashTable009", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_09(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_09(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 10, description = "Check show report correct with assessment type is \"Program\"", dataProvider = "getClassAssessmentReportDataHashTable010", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_10(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_10(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 11, description = "Check show report correct with assessment type is \"Custom\"", dataProvider = "getClassAssessmentReportDataHashTable011", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_11(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_11(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 12, description = "Check show report correct when checked between assessment types", dataProvider = "getClassAssessmentReportDataHashTable012", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_12(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_12(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 13, description = "Check show report correct when checked between assessment types", dataProvider = "getClassAssessmentReportDataHashTable013", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_13(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_13(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 14, description = "Check view resource successful", dataProvider = "getClassAssessmentReportDataHashTable014", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_14(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_14(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 15, description = "Check when click icon report assessment", dataProvider = "getClassAssessmentReportDataHashTable015", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_15(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_15(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_ClassAssessment_Report })
  @Test(priority = 17, description = "Check export data with filter selected", dataProvider = "getClassAssessmentReportDataHashTable017", dataProviderClass = DataProviderSCClassAssessmentReport.class)
  private void TC_ClassAssessment_17(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Assessment Report
    classAssessmentReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classAssessmentReportPageSC.TC_ClassAssessment_17(data);
  }

}
