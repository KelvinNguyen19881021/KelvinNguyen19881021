package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCClassProficiencyReport;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.ClassProficencyReports.ClassProficiencyReportPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.util.Hashtable;

public class ClassProficiencyReportTest extends BaseTest {
  private LoginPageSC loginPageSC;
  private ClassProficiencyReportPageSC classProficiencyReportPageSC;

  public ClassProficiencyReportTest() {
    this.loginPageSC = new LoginPageSC();
    this.classProficiencyReportPageSC = new ClassProficiencyReportPageSC();
    this.classProficiencyReportPageSC.excelToCSV();
  }



  //filter
  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 1, description = "Check login successful", dataProvider = "getClassProficiencyReportDataHashTable001", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_01(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestNoReport();
    // 2. Open page Class Proficiency Report
    //3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_01(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 2, description = "Check display [Class Proficiency Report] successful", dataProvider = "getClassProficiencyReportDataHashTable002", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_02(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_02(data);
  }


  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 3, description = "Check Show Report when not select class filter", dataProvider = "getClassProficiencyReportDataHashTable003", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_03(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_03(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 4, description = "Check Apply Filter for specific class, specific student, specific product", dataProvider = "getClassProficiencyReportDataHashTable004", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_04(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_04(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 5, description = "Check show report of class", dataProvider = "getClassProficiencyReportDataHashTable005", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_05(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_05(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 6, description = "Check show report of all students in class", dataProvider = "getClassProficiencyReportDataHashTable006", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_06(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_06(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 7, description = "Check filter with class and student but not choose any assessment type", dataProvider = "getClassProficiencyReportDataHashTable007", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_07(Hashtable<String, String> data){
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_07(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 8, description = "Check show report correct with assessment type is \"Formative\"", dataProvider = "getClassProficiencyReportDataHashTable008", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_08(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_08(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 9, description = "Check show report correct with assessment type is \"Assessment\"", dataProvider = "getClassProficiencyReportDataHashTable009", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_09(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_09(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 10, description = "Check show report correct with assessment type is \"Program\"", dataProvider = "getClassProficiencyReportDataHashTable010", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_10(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_10(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 11, description = "Check show report correct with assessment type is \"Custom\"", dataProvider = "getClassProficiencyReportDataHashTable011", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_11(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_11(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 12, description = "Check show report correct with assessment type is \"Custom\"", dataProvider = "getClassProficiencyReportDataHashTable012", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_12(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_12(data);
  }

  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 13, description = "Check display name domain and content of standard is correct", dataProvider = "getClassProficiencyReportDataHashTable013", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_13(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_13(data);
  }



  @FrameworkAnnotation(author = { AuthorType.AutomationTeam }, category = { CategoryType.SC_Classproficiency_Report })
  @Test(priority = 15, description = "Check export data with filter selected", dataProvider = "getClassProficiencyReportDataHashTable015", dataProviderClass = DataProviderSCClassProficiencyReport.class)
  private void TC_ClassProficiency_15(Hashtable<String, String> data) {
    // 1. Login with teacher role
    loginPageSC.logInWithTeacherRoleTestReport();
    // 2. Open page Class Proficiency Report
    classProficiencyReportPageSC.openPageReport();
    // 3. Verify and execute that test case
    classProficiencyReportPageSC.TC_ClassProficiency_15(data);
  }


}
