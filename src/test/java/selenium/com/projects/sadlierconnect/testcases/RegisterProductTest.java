package selenium.com.projects.sadlierconnect.testcases;

import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCRegisterProduct;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.Products.RegisterProductPage;

import java.util.Hashtable;

public class RegisterProductTest extends BaseTest {
  private final static String title = "TC_REGISTER_A_PRODUCT";
  private final LoginPageSC loginPage;


  private final RegisterProductPage registerProductPage;
  public RegisterProductTest() {
    loginPage = new LoginPageSC();
    registerProductPage = new RegisterProductPage();

  }


   //Login with teach school
  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Register_A_Product})
  @Test(priority = 1, description = "Verify input valid code", dataProvider = "getRegisterAProduct01", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_01(Hashtable<String, String> data) {
    //Pre-condition: Remove access code before run test case
    loginPage.logInWithSystemAdminRole();
    registerProductPage.removeResource(data);
    /*1. Log in Teacher Account */
    loginPage.logInWithTeacherRole();
    /*2. Click Avatar teacher*/
    registerProductPage.getRegisterProductPageCU();
    /*3. Click Register a Product*/
    /*4. Input Valid Code */
    registerProductPage.TC_REGISTERAPRODUCT_01(data);
    /*5. Click Save*/
    //[CP]_Back to My library, Check resource Common Core Progress ELA Digital Resources, Grade 1 has displayed
    registerProductPage.checkExistedProgramNameInLibrary(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Register_A_Product})
  @Test(priority = 2, description = "Verify input valid code after clicked Cancel", dataProvider = "getRegisterAProduct02", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_02(Hashtable<String, String> data) {
    /*1. Log in Teacher Account*/
    loginPage.logInWithTeacherRole();
    /*2. Click Avatar teacher*/
    /*3. Click Register a Product*/
    registerProductPage.getRegisterProductPageCU();
    /*4. Input Valid Code*/
    registerProductPage.TC_REGISTERAPRODUCT_02(data);
    /*5. Click Cancel*/
    //[CP]_Back to Dashboard, Check resource Common Core Progress ELA Digital Resources, Grade 2 is not displayed
    registerProductPage.checkNotExistedProgramNameInLibrary(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Register_A_Product})
  @Test(priority = 3, description = "Verify not input code", dataProvider = "getRegisterAProduct03", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_03(Hashtable<String, String> data) {
    //1. Log in Teacher Account
    loginPage.logInWithTeacherRole();
    /*2. Click Avatar teacher
    3. Click Register a Product  */
    registerProductPage.getRegisterProductPageCU();
    /*4. Not Input Code
    5. Click Save */
    //[CP]_Display message "This field is required" under Access Code
    registerProductPage.TC_REGISTERAPRODUCT_03(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Register_A_Product})
  @Test(priority = 4, description = "Verify input invalid code", dataProvider = "getRegisterAProduct04", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_04(Hashtable<String, String> data) {
    //1. Log in Teacher Account
    loginPage.logInWithTeacherRole();
   /*
      2. Click Avatar teacher
      3. Click Register a Product
   */
    registerProductPage.getRegisterProductPageCU();

   /* 4. Input Invalid Code
      5. Click Save
      [CP]_Display message  "You have entered an invalid product access code. Please verify the access code and retry."
    */
    registerProductPage.TC_REGISTERAPRODUCT_04(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Register_A_Product})
  @Test(priority = 5, description = "Verify input existed code", dataProvider = "getRegisterAProduct05", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_05(Hashtable<String, String> data) {
    //1. Log in Teacher Account
    loginPage.logInWithTeacherRole();
    /*
      2. Click Avatar teacher
      3. Click Register a Product
    */
    registerProductPage.getRegisterProductPageCU();
   /* 4. Input exist code
      5. Click Save
      [CP]_Display message "You are attempting to activate a product that is already available for viewing on your bookshelf. Browse to your bookshelf to access the product."
   */
    registerProductPage.TC_REGISTERAPRODUCT_05(data);
  }


   //Login with admin school
  /*
  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
  @Test(priority = 6, description = "TC_REGISTER_A_PRODUCT_01", dataProvider = "getRegisterAProduct01", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_01_ADMIN(Hashtable<String, String> data) {
    loginPage.logInWithSystemAdminRoleWithoutPassCode();
    registerProductPage.removeResource(data);
    loginPage.logInWithAdminRoleWithoutPassCode();
    registerProductPage.getRegisterProductPageCU();
    registerProductPage.TC_REGISTERAPRODUCT_01(data);
    registerProductPage.checkExistedProgramNameInLibrary(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
  @Test(priority = 7, description = "TC_REGISTER_A_PRODUCT_02", dataProvider = "getRegisterAProduct02", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_02_ADMIN(Hashtable<String, String> data) {
    loginPage.logInWithAdminRoleWithoutPassCode();
    registerProductPage.getRegisterProductPageCU();
    registerProductPage.TC_REGISTERAPRODUCT_02(data);
    registerProductPage.checkExistedProgramNameInLibrary(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
  @Test(priority = 8, description = "TC_REGISTER_A_PRODUCT_03", dataProvider = "getRegisterAProduct03", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_03_ADMIN(Hashtable<String, String> data) {
    loginPage.logInWithAdminRoleWithoutPassCode();
    registerProductPage.getRegisterProductPageCU();
    registerProductPage.TC_REGISTERAPRODUCT_03(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
  @Test(priority = 9, description = "TC_REGISTER_A_PRODUCT_04", dataProvider = "getRegisterAProduct04", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_04_ADMIN(Hashtable<String, String> data) {
    loginPage.logInWithAdminRoleWithoutPassCode();
    registerProductPage.getRegisterProductPageCU();
    registerProductPage.TC_REGISTERAPRODUCT_04(data);
  }

  @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
  @Test(priority = 10, description = "TC_REGISTER_A_PRODUCT_05", dataProvider = "getRegisterAProduct05", dataProviderClass = DataProviderSCRegisterProduct.class)
  public void TC_REGISTER_A_PRODUCT_05_ADMIN(Hashtable<String, String> data) {
    loginPage.logInWithAdminRoleWithoutPassCode();
    registerProductPage.getRegisterProductPageCU();
    registerProductPage.TC_REGISTERAPRODUCT_05(data);
  }
  */

}
