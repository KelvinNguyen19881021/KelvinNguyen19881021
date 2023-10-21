package selenium.com.projects.sadlierconnect.pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.LoginModel;
import selenium.com.projects.sadlierconnect.models.ProductModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.report.ExtentTestManager;
import selenium.com.utils.LogUtils;
import selenium.com.utils.ObjectUtils;

import java.util.Hashtable;
import java.util.List;

public class RegisterProductPage extends CommonPageSC {
  private static final ExcelHelpers excelHelpers = new ExcelHelpers();
  private final  By titlePage = convertToXpath("(//h1[normalize-space()='Register A Product'])[1]");
  private final  By inputCode = convertToXpath("(//input[@placeholder='Enter access code'])[1]");
  private final  By inputSave = convertToXpath("(//span[normalize-space()='Save'])[1]");
  private final  By inputCancel = convertToXpath("(//span[normalize-space()='Cancel'])[1]");
  private final  By alertMessageError = convertToXpath("(//div[@class='ant-alert ant-alert-danger sc-eKszNL gffgDt sc-alert-danger not-full-screen'])[1]");
  private final  By alertMessageSuccess = convertToXpath("(//div[@class='ant-alert ant-alert-success sc-alert-success not-full-screen'])[1]");
  private final  By alertMessage = convertToXpath("(//div[@role='alert'])[1]");
  private final ProductModel productModel = new ProductModel();
  private final String myLibraryPage = "/library";
  private final String myDashboardPage = "/dashboard";
  private final By inputSchoolPID = convertToXpath("(//input[@name='pid'])[1]");
  private final By buttonApplyFilter = convertToXpath("(//span[normalize-space()='Apply Filter'])[1]");
  private final By iconEye = convertToXpath("(//div[@class='cursor-pointer'])[1]");
  private final By dropDownProgram = convertToXpath("//span[@class='ant-select-selection-item']//span[contains(text(),'All Programs')]");
  private final By inputProgram = convertToXpath("//input[contains(@class,'ant-input sc-ezWOiH hmYkqp')]");
  private final By buttonApplyFilterLicense = convertToXpath("//span[normalize-space()='Apply Filter']");
  private final By buttonDelete = convertToXpath("(//span[normalize-space()='Delete'])[1]");
  private final By buttonPopUpOK = convertToXpath("(//span[normalize-space()='OK'])[1]");
  private final String rowLicenses = "//div[@class='ant-table-content']//tbody/tr";
  private final String cardSadlierTable = "(//div[@class='sadlier-table-item'])[1]";
  private final String cardSaliderData = "(//div[@class='sc-fmrZth hCQuFx product-wrapper'])/a";
  private final By inputSearchProduct = convertToXpath("(//input[@placeholder='Search All Products']"); //Common Core Progress ELA



  public RegisterProductPage() {
    excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT");
  }
  //[CP]_Access to Register A Product Page
  public void getRegisterProductPageCU() {
    WebUI.sleep(5);
    attackPage();
    assert titlePage != null;
    String title = !WebUI.getTextElement(titlePage).isEmpty() ? "Sadlier Connect™ - " + WebUI.getTextElement(titlePage) : "Sadlier Connect™ - Register A Product";
    WebUI.verifyEquals(WebUI.getPageTitle(), title, "The title of sign in page not match.");
  }

  //[CP]_Check resource Common Core Progress ELA Digital Resources, Grade 1 has displayed in the page
  public void checkExistedProgramNameInLibrary(Hashtable<String, String> data) {
    By programName = By.xpath(ObjectUtils.getXpathDynamic("//div[text()='%s']/following-sibling::div", data.get(productModel.getProgram()).trim()));
    WebUI.sleep(5);
    WebUI.verifyElementText(programName,data.get(productModel.getGrade()));
  }


  public void TC_REGISTERAPRODUCT_01(Hashtable<String, String> data) {
    setInputCodeSuccess(data, "TC_REGISTER_A_PRODUCT_01");
    WebUI.sleep(2);
    WebUI.clickElement(inputSave);
    WebUI.sleep(5);
    //[CP]_Navigate to My Library
    if (WebUI.getCurrentUrl().contains(myLibraryPage)) {
      getRedirectURL(myLibraryPage);
    } else {
      getRedirectURL(myDashboardPage);
    }

  }

  public void TC_REGISTERAPRODUCT_02(Hashtable<String, String> data) {
    setInputCodeSuccess(data, "TC_REGISTER_A_PRODUCT_02");
    WebUI.sleep(2);
    WebUI.clickElement(inputCancel);
    //[CP]_Navigate to My Library
    if (WebUI.getCurrentUrl().contains(myLibraryPage)) {
      getRedirectURL(myLibraryPage);
    } else {
      getRedirectURL(myDashboardPage);
    }
  }

  public void TC_REGISTERAPRODUCT_03(Hashtable<String, String> data) {
    WebUI.clickElement(inputSave);
    WebUI.sleep(5);
    //[CP]_This field is required
    WebUI.verifyElementTextContains(By.xpath("(//span[normalize-space()='This field is required.'])[1]"),"This field is required");
  }

  public void TC_REGISTERAPRODUCT_04(Hashtable<String, String> data) {
    setInputCodeError(data, "TC_REGISTER_A_PRODUCT_04");
    WebUI.sleep(2);
    WebUI.clickElement(inputSave);
    WebUI.sleep(5);
    //[CP]_You have entered an invalid product access code. Please verify the access code and retry.
    WebUI.verifyElementTextContains(alertMessageError, "You have entered an invalid product access code. Please verify the access code and retry.");
  }

  public void TC_REGISTERAPRODUCT_05(Hashtable<String, String> data) {

    setInputCodeSuccess(data, "TC_REGISTER_A_PRODUCT_05");

    WebUI.clickElement(inputSave);

    //[CP]_You are attempting to activate a product that is already available for viewing on your bookshelf. Browse to your bookshelf to access the product.
    WebUI.verifyElementTextContains(alertMessageError, "You are attempting to activate a product that is already available for viewing on your bookshelf. Browse to your bookshelf to access the product.");
  }

  private void returnMyLibrary() {
    WebUI.clickElement(convertToXpath("(//span[normalize-space()='My Library'])[1]"));

    WebUI.clickElement(convertToXpath("(//a[normalize-space()='See all programs in My Library'])[1]"));
  }

  private void attackPage() {

    WebUI.waitForPageLoaded();
    WebUI.clickElement(By.xpath("(//span[@class='user-avatar'])[1]"));

    WebUI.clickElement(By.xpath("(//a[normalize-space()='Register a Product'])[1]"));

  }

  public void removeResource(Hashtable<String, String> data) {
    WebUI.sleep(5);
    WebUI.clickElement(iconSetting);
    WebUI.sleep(2);
    WebUI.clickElement(iconManageSchool);
    WebUI.sleep(5);
    WebUI.setText(inputSchoolPID, data.get(productModel.getpID()));
    WebUI.clickElement(buttonApplyFilter);
    WebUI.sleep(5);
    WebUI.clickElement(iconEye);
    WebUI.waitForPageLoaded();
    WebUI.clickElement(dropDownProgram);
    WebUI.sleep(2);
    WebUI.clickElement(inputProgram);
    WebUI.sleep(2);
    WebUI.setText(inputProgram, data.get(productModel.getProgram()), Keys.ENTER);
    WebUI.clickElement(buttonApplyFilterLicense);
    WebUI.sleep(10);
    WebUI.selectedValueOnTableByColumn(3, data.get(productModel.getProductCode()).trim(), rowLicenses);
    WebUI.scrollToElementToBottom(buttonDelete);
    WebUI.sleep(5);
    WebUI.clickElement(buttonDelete);
    WebUI.clickElement(buttonPopUpOK);
    logOutAdminPage();

  }

  public void logOutAdminPage() {
    WebUI.clickElement(CommonPageSC.iconMyProfiles);
    WebUI.clickElement(CommonPageSC.buttonSignOut);
  }

  private void setInputCodeSuccess(Hashtable<String, String> data, String testCaseName) {
    if (data.isEmpty() && data.size() < 0) {
      WebUI.setText(inputCode, excelHelpers.getCellData(1, productModel.getInputCode().trim()));
    } else {
      if (data.get(productModel.getTestCaseName()).equalsIgnoreCase(testCaseName)) {
        WebUI.setText(inputCode, data.get(productModel.getInputCode()));
      }
    }
  }

  private void setInputCodeError(Hashtable<String, String> data, String testCaseName) {
    if (data.isEmpty() && data.size() < 0) {
      WebUI.setText(inputCode, excelHelpers.getCellData(4, productModel.getInputCode()).trim());
    } else {
      if (data.get(productModel.getTestCaseName()).equalsIgnoreCase(testCaseName)) {
        WebUI.setText(inputCode, data.get(productModel.getInputCode()));
      }
    }
  }

  private void getRedirectURL(String url) {
    if (url.isEmpty()) return;
    WebUI.verifyContains(WebUI.getCurrentUrl(), url, "Move to Previous Page.");
  }


  private static By convertToXpath(String input) {
    if (input.isEmpty()) return null;
    return By.xpath(input);
  }

  //[CP]_Check resource Common Core Progress ELA Digital Resources, Grade 2 is not displayed in the page
  public void checkNotExistedProgramNameInLibrary(Hashtable<String, String> data) {
    if(data.get(productModel.getProgram()).trim().equalsIgnoreCase("Common Core Progress ELA")) {
      By notExistedProgramELA = By.xpath(ObjectUtils.getXpathDynamic("(//div[text()='%s'])[2]/following-sibling::div", data.get(productModel.getProgram()).trim()));
      WebUI.sleep(5);
      WebUI.verifyElementNotPresent(notExistedProgramELA);
    }
    else {
      By notExistedProgramName = By.xpath(ObjectUtils.getXpathDynamic("(//div[text()='%s'])/following-sibling::div", data.get(productModel.getProgram()).trim()));
      WebUI.sleep(5);
      WebUI.verifyElementNotPresent(notExistedProgramName);
    }

  }

}
