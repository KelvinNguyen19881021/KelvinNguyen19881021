package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.constants.FrameworkConstants;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCManageParent;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCManageParentImport;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageParents.ManageParentsPageSC;


import java.io.IOException;
import java.util.Hashtable;

public class ManageParentTest extends BaseTest {
  private final static String title = "SC_Manage_Parent";
  public final LoginPageSC loginPageSC;
  public final ManageParentsPageSC manageParentsPageSC;

  public ManageParentTest() {
    loginPageSC = new LoginPageSC();
    DashboardPageSC dashboardPageSC = new DashboardPageSC();
    manageParentsPageSC = new ManageParentsPageSC();
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 1, description = "Verify click filter class successfully",
          dataProvider = "getParentDataHashTable01", dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_01(Hashtable<String, String> data) throws IOException {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Filter Class
    5. Choose Class 1
    6. Click Apply Filter
    */
    manageParentsPageSC.TC_MANAGE_PARENT_01(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 2, description = "Verify click filter Grade successfully",
          dataProvider = "getParentDataHashTable02",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_02(Hashtable<String, String> data) throws IOException {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
      /*3. Click Manage Parents
      4. Click Filter Grade
      5. Choose Grade 1
      6. Click Apply Filter
    */
    manageParentsPageSC.TC_MANAGE_PARENT_02(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 3, description = "Verify input Last Name of Parent successfully",
          dataProvider = "getParentDataHashTable03",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_03(Hashtable<String, String> data) throws IOException {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Input Last Name
    5. Click Apply Filter */
    manageParentsPageSC.TC_MANAGE_PARENT_03(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 4, description = "Verify input Last Name of Parent successfulVerify apply filter with Class, grade and last name",
          dataProvider = "getParentDataHashTable04",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_04(Hashtable<String, String> data) throws IOException {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Filter Class
    5. Choose Class 1
    6. Click Filter Grade
    7. Choose Grade 1
    8. Input Last Name
    9. Click Apply Filter */
    manageParentsPageSC.TC_MANAGE_PARENT_04(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 5, description = "Verify Create parents Successful - Input valid all required fields",
          dataProvider = "getParentDataHashTable05",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_05(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input Valid Email
    8. Input UserName
    9. Input Password
    10. Input Parent's Child and Click Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_05(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 6, description = "Verify Create Parents Successful - Input valid all fields ",
          dataProvider = "getParentDataHashTable06",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_06(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Middle Name
    7. Input Valid Last Name
    8. Input Valid Email
    9  Input UserName
    10. Input Password
    11. Input Parent's Child and Click Link to Student
    12. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_06(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 7, description = "Verify Create Parents Unsuccessful - Input valid all fields and Click Cancel button",
          dataProvider = "getParentDataHashTable07",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_07(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Middle Name
    7. Input Valid Last Name
    8. Input Valid Email
    9  Input UserName
    10. Input Password
    11. Input Parent's Child and Click Link to Student
    12. Click Cancel */
    manageParentsPageSC.TC_MANAGE_PARENT_07(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 8, description = "Verify Create Parents Unsuccessful - Do not input all required fields and Click Save button",
          dataProvider = "getParentDataHashTable08",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_08(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Do not input data First Name, Last Name, Email, UserName, Password
    5. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_08(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 9, description = "Verify Create Parents Unsuccessful - Input Email already exists and click Save",
          dataProvider = "getParentDataHashTable09",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_09(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input Exist Email
    8. Input UserName
    9. Input Password
    10. Input Parent's Child and Click
    Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_09(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 10, description = "Verify Create Parents Unsuccessful - Input UserName already exists and Click Save",
          dataProvider = "getParentDataHashTable10",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_10(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input valid Email
    8. Input UserName already exists
    9. Input Password
    10. Input Parent's Child and Click
    Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_10(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 11, description = "Verify Create Parents Unsuccessful - Do not input Parent's Child and click Save",
          dataProvider = "getParentDataHashTable11",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_11(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input valid Email
    8. Input valid UserName
    9. Input Password
    10. Do not input Parent's Child
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_11(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 12, description = "Verify Create Parents Unsuccessful - Input Invalid UserName  and click Save",
          dataProvider = "getParentDataHashTable12",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_12(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input valid Email
    8. Input invalid UserName
    9. Input Password
    10. Input Parent's Child and Click
    Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_12(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 13, description = "Verify Create Parents Unsuccessful - Input Invalid Email and click Save",
          dataProvider = "getParentDataHashTable13",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_13(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*
    3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input invalid Email
    8. Input valid UserName
    9. Input Password
    10. Input Parent's Child and Click
    Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_13(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 14, description = "Verify Edit Parent Successful - Change First Name of User Parent and Click Save",
          dataProvider = "getParentDataHashTable14",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_14(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Change First Name of Parent
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_14(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 15, description = "Verify Edit Parent Successful - Change Last Name of User Parent and Click Save",
          dataProvider = "getParentDataHashTable15",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_15(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Change Last Name of Parent
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_15(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 16, description = "Verify Edit Parent Successful - Change Email of User Parent and Click Save",
          dataProvider = "getParentDataHashTable16",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_16(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
   // 2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Change Email of User Parent
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_16(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 17, description = "Verify Edit Parent Successful - Change UserName and Password of User Parent and Click Save",
          dataProvider = "getParentDataHashTable17",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_17(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Change UserName and Password
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_17(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 18, description = "Verify Edit Parent Successful - Change Parent's Child of User Parent and Click Save ",
          dataProvider = "getParentDataHashTable18",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_18(Hashtable<String, String> data) {
   // 1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Delete Students Associated to Parent.
    7. Add New Parent's Child
    8. Click Link this Student
    9. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_18(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 19, description = "Verify Edit Parent Unsuccessful - Verify Change all fields and Click Cancel",
          dataProvider = "getParentDataHashTable19",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_19(Hashtable<String, String> data) {
   // 1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_2"
    5. Click Edit Account
    6. Change First Name of Parent
    7. Change Last Name of Parent
    8. Change Middle Name of Parent
    9. Change Email of Parent
    10. Change User Name of Parent
    11. Change Password of Parent
    12. Change New Parent's Child
    13. Click Cancel */
    manageParentsPageSC.TC_MANAGE_PARENT_19(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 20, description = "Verify Edit Parent Unsuccessful - Verify Delete Data First Name, LastName, Email, UserName, Password, and Click Save",
          dataProvider = "getParentDataHashTable20",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_20(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Delete Data (First Name, LastName, Email, UserName, Password)
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_20(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 21, description = "Verify Edit Parent Unsuccessful - Verify update field UserName with data invalid and Click Save ",
          dataProvider = "getParentDataHashTable21",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_21(Hashtable<String, String> data) {
   // 1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
   // 2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Change UserName with data invalid
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_21(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 22, description = "Verify Edit Parent Unsuccessful - Verify update field Email with data invalid and Click Save ",
          dataProvider = "getParentDataHashTable22",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_22(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Change UserName with data invalid
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_22(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 23, description = "Verify Edit Parent Unsuccessful - Verify update field UserName with data already exists and Click Save ",
          dataProvider = "getParentDataHashTable23",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_23(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
   // 2. Click Gear icon
    manageParentsPageSC.visitPage();
   /* 3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Change UserName with data already exists
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_23(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 24, description = "Verify Edit Parent Unsuccessful - Verify update field Email with data already exists and Click Save ",
          dataProvider = "getParentDataHashTable24",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_24(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
   // 2. Click Gear icon
    manageParentsPageSC.visitPage();
   /* 3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Change Email with data already exists
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_24(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 25, description = "Verify Edit Parent Unsuccessfully - Verify Delete Current Parent's Child and click Save",
          dataProvider = "getParentDataHashTable25",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_25(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
   // 2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Edit Account
    6. Delete Current Parent' Child
    7. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_25(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 26, description = "Verify Input Parent's Child not exists and Click Link this Student",
          dataProvider = "getParentDataHashTable26",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_26(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click Add Parent
    5. Input Valid First Name
    6. Input Valid Last Name
    7. Input Valid Email
    8. Input UserName
    9. Input Password
    10. Input Parent's Child not exists and Click Link to Student
    11. Click Save */
    manageParentsPageSC.TC_MANAGE_PARENT_26(data);
  }


  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 27, description = "Verify Click Disable User Parent and Choose No",
          dataProvider = "getParentDataHashTable27",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_27(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Disable account
    6. Click No */
    manageParentsPageSC.TC_MANAGE_PARENT_27(data);
  }


  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 28, description = "Verify Click Disable User Parent and Choose Yes",
          dataProvider = "getParentDataHashTable28",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_28(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Disable account
    6. Click Yes */
    manageParentsPageSC.TC_MANAGE_PARENT_28(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 29, description = "Verify Delete User Parent Unsuccessful - Verify Click Delete User Parent and Choose Cancel",
          dataProvider = "getParentDataHashTable29",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_29(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Delete account
    6. Click Cancel */
    manageParentsPageSC.TC_MANAGE_PARENT_29(data);
  }


  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 30, description = "Verify Click Delete User Parent and Choose Yes",
          dataProvider = "getParentDataHashTable30",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_30(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click pencil icon at record with user name "Par_22"
    5. Click Delete account
    6. Click OK */
    manageParentsPageSC.TC_MANAGE_PARENT_30(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 31, description = "Verify Send Parent Welcome Unsuccessfully - Verify Click Send Parent Welcome, and Choose Cancel",
          dataProvider = "getParentDataHashTable31",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_31(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click message icon at record with user name "Par_3"
    5. Click Send Parent Welcome
    6. Click Cancel button at popup
    7. Go to yopmail.com */
    manageParentsPageSC.TC_MANAGE_PARENT_31(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 33, description = "Verify Send Student Welcome Successful - Verify Click Send Parent Welcome, and Choose Send Email",
          dataProvider = "getParentDataHashTable32",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_32(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click message icon at record with user name "Par_3"
    5. Click Send Parent Welcome
    6. Click Send Email button at popup
    7. Go to yopmail.com */
    manageParentsPageSC.TC_MANAGE_PARENT_32(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 32, description = "Verify Send Student Welcome Unsuccessful",
          dataProvider = "getParentDataHashTable33",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_33(Hashtable<String, String> data) {
    //1. Log in Teacher account
    loginPageSC.logInWithTeacherManageParent();
    //2. Click Gear icon
    manageParentsPageSC.visitPage();
    /*3. Click Manage Parents
    4. Click message icon at record with user name "Par_3"
    5. Click Send Student Welcome
    6. Click Cancel button at popup
    7. Go to yopmail.com */
    manageParentsPageSC.TC_MANAGE_PARENT_33(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 35, description = "Verify Import Parent Successful", dataProvider = "getParentDataHashTable35", dataProviderClass = DataProviderSCManageParentImport.class)
  public void TC_MANAGE_PARENT_35(Hashtable<String, String> data) {
    if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
      DriverManager.setDriver(DriverManager.optionsDislayedDriver());
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      // 2. Click Gear icon
      manageParentsPageSC.visitPage();
   /* 3. Click "Manage Parents" item
    4. Click "Import Parents" button
    5. Click "Choose File" button
    6. Choose file valid from folder
    7. Click "Continue" button
    8. Click "Import Parents" button
    9. Click "X" icon/ "Return to Parent Management" button */
      manageParentsPageSC.TC_MANAGE_PARENT_35(data);
      DriverManager.quit();
    }
    else
    {
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      // 2. Click Gear icon
      manageParentsPageSC.visitPage();
   /* 3. Click "Manage Parents" item
    4. Click "Import Parents" button
    5. Click "Choose File" button
    6. Choose file valid from folder
    7. Click "Continue" button
    8. Click "Import Parents" button
    9. Click "X" icon/ "Return to Parent Management" button */
      manageParentsPageSC.TC_MANAGE_PARENT_35(data);
    }
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 36, description = "Verify Import Parent UnSuccessful, Import Parents when data invalid", dataProvider = "getParentDataHashTable36", dataProviderClass = DataProviderSCManageParentImport.class)
  public void TC_MANAGE_PARENT_36(Hashtable<String, String> data) {
    if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
      DriverManager.setDriver(DriverManager.optionsDislayedDriver());
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      //2. Click Gear icon
      manageParentsPageSC.visitPage();
    /*3. Click "Manage Parents" item
    4. Click "Import Parents" button
    5. Click "Choose File" button
    6. Choose file have data invalid from folder
    7. Click "Continue" button
    8. Click "Import Parents" button
    9. Click "X" icon/ "Return to Manage Students" button */
      manageParentsPageSC.TC_MANAGE_PARENT_36(data);
      DriverManager.quit();
    }
    else
    {
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      //2. Click Gear icon
      manageParentsPageSC.visitPage();
    /*3. Click "Manage Parents" item
    4. Click "Import Parents" button
    5. Click "Choose File" button
    6. Choose file have data invalid from folder
    7. Click "Continue" button
    8. Click "Import Parents" button
    9. Click "X" icon/ "Return to Manage Students" button */
      manageParentsPageSC.TC_MANAGE_PARENT_36(data);
    }
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 37, description = "Verify Import Parent UnSuccessful, import Parents when data that already exists", dataProvider = "getParentDataHashTable37", dataProviderClass = DataProviderSCManageParentImport.class)
  public void TC_MANAGE_PARENT_37(Hashtable<String, String> data) {
    if (Boolean.parseBoolean(FrameworkConstants.HEADLESS)) {
      DriverManager.setDriver(DriverManager.optionsDislayedDriver());
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      //2. Click Gear icon
      manageParentsPageSC.visitPage();
      //3. Click "Manage Parents" item
      //4. Click "Import Parents" button
      //5. Click "Choose file" button
      //6. Choose file has data that already exists from folder
      //7. Click "Continue" button
      //8. Click "Import Parents" button
      //9. Click "X" icon/ "Return to Manage Students" button
      manageParentsPageSC.TC_MANAGE_PARENT_37(data);
      DriverManager.quit();
    }
    else {
      //1. Login account teacher
      loginPageSC.logInWithTeacherRole();
      //2. Click Gear icon
      manageParentsPageSC.visitPage();
      //3. Click "Manage Parents" item
      //4. Click "Import Parents" button
      //5. Click "Choose file" button
      //6. Choose file has data that already exists from folder
      //7. Click "Continue" button
      //8. Click "Import Parents" button
      //9. Click "X" icon/ "Return to Manage Students" button
      manageParentsPageSC.TC_MANAGE_PARENT_37(data);
    }

  }




  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Manage_Parent})
  @Test(priority = 34, description = "Verify Send Student Welcome successful",
          dataProvider = "getParentDataHashTable34",
          dataProviderClass = DataProviderSCManageParent.class)
  public void TC_MANAGE_PARENT_34(Hashtable<String, String> data) {
    loginPageSC.logInWithTeacherManageParent();
    manageParentsPageSC.visitPage();
    manageParentsPageSC.TC_MANAGE_PARENT_34(data);
  }
}
