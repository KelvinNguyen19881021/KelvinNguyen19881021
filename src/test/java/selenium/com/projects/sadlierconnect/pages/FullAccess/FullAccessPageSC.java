package selenium.com.projects.sadlierconnect.pages.FullAccess;

import java.io.File;
import java.time.Duration;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.com.driver.DriverManager;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.FullAccessModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.report.ExtentTestManager;
import selenium.com.utils.DateUtils;
import selenium.com.utils.LogUtils;
import selenium.com.utils.ObjectUtils;

public class FullAccessPageSC extends CommonPageSC {

    private final ExcelHelpers excelHelpers = new ExcelHelpers();
    private final LoginPageSC loginPageSC = new LoginPageSC();
    private final FullAccessModel fullAccessModel = new FullAccessModel();

    private final By inputPassCode = By.xpath("//input[@id='passcode']");
    private final By inputPassWord = By.xpath("//input[@id='password']");
    private final By inputUserName = By.xpath("//input[@id='username']");
    private final By buttonLogin = By.xpath("//button[@type='button']");

    public final By dropdownImport = By.xpath("//span[normalize-space()='Import']");
    public final By labelImportLicense = By.xpath("//a[normalize-space()='Import Licenses']");
    public final By buttonChooseFile = By.xpath("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    public final By buttonContinue = By.xpath("//span[normalize-space()='Continue']");
    public final By buttonImportLicenses = By.xpath("//span[normalize-space()='Import Licenses']");

    public final By dropdownManage = By.xpath("//a[@class='ant-dropdown-trigger ant-dropdown-link sc-dsQDmV kBkfyy sc-cZwWEu dmLaeR']");
    public final By manageSchool = By.xpath("//a[normalize-space()='Manage Schools']");
    public final By filterPid = By.xpath("//input[@name='pid']");
    public final By applyButton = By.xpath("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    public final By buttonDeleteAll = By.xpath("//span[normalize-space()='Delete']");
    public final By checkboxAll = By.xpath("//thead//tr//th//div//input[@type='checkbox']");

    public final By remindDialog = By.xpath("//div[normalize-space()='Remind']");
    public final By closeDialog = By.xpath("//span[@class='ant-modal-close-x']");

    public final By dropdownReport = By.xpath("//span[normalize-space()='Reports']");
    public final By labelFullAccess = By.xpath("//span[normalize-space()='Full Access']");

    public final By menuMyLibrary = By.xpath("//span[normalize-space()='My Library']");
    public final By menuFAReport = By.cssSelector("a[href='/report/v2/fa-report.html']");

    public final By buttonAccept = By.xpath("//span[normalize-space()='Accept']");
    public final By buttonClose = By.xpath("//span[normalize-space()='Close']");
    public final By titleContent = By.xpath("//span[@class='ant-menu-title-content']//span[contains(text(),'Assessment')]");
    public final By labelFA = By.xpath("//div[@class='fullaccess-legend']");
    public static final String pageUrl = "/report/v2/fa-report.html";
    public final By dropDownProgramSeriesName = By.xpath("//span[@title='Select Program Series']");
    public FullAccessPageSC() {
        super();
    }

    public void clickButtonAccept()
    {
        boolean res = checkExistElement(buttonAccept, 5);
        if(res) {
            WebUI.clickElement(buttonAccept, 5);
            WebUI.sleep(5);
            clickButtonContinue();
        }
    }

    public void clickButtonContinue()
    {
        if(checkExistElement(buttonContinue, 5)) {
            WebUI.scrollToElementToBottom(buttonContinue);
            WebUI.sleep(5);
            WebUI.clickElement(buttonContinue, 5);
            WebUI.sleep(5);
        }
    }


    public void logInWithCredential(String url, String passcode, String username, String password) {
        WebUI.getURL(url);
        WebUI.setText(inputPassCode, passcode);
        WebUI.setText(inputUserName, username);
        WebUI.setText(inputPassWord, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        clickButtonAccept();
    }

    private void deleteAllLicense(String pid) {
        WebUI.clickElement(dropdownManage);
        WebUI.clickElement(manageSchool);
        WebUI.setText(filterPid, pid);
        WebUI.clickElement(applyButton);
        WebUI.sleep(5);
        //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
        List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
        WebUI.sleep(1);
        LogUtils.info("Number of results for keywords (" + pid + "): " + totalRows.size());

        if (totalRows.size() < 1) {
            LogUtils.info("Not found value: " + pid);
        } else {
            WebElement title = WebUI.waitForElementVisible(By.xpath("//tbody/tr[" + 1 + "]/td[" + 6 + "]"));
            assert title != null;
            boolean res = title.getText().toUpperCase().contains(pid.toUpperCase());
            if (!res) {
                LogUtils.info("Row " + 1 + ": " + res + " - " + title.getText());
            } else {
                WebElement iconViewLicense = WebUI.waitForElementClickable(By.xpath("//div[@class='cursor-pointer']//*[name()='svg']"));
                assert iconViewLicense != null;
                iconViewLicense.click();
                WebUI.sleep(5);
                while(checkExistElement(checkboxAll, 10) && verifyClickable(checkboxAll, 10)) {
                    WebElement checkboxElement = WebUI.waitForElementVisible(checkboxAll);
                    assert checkboxElement != null;
                    checkboxElement.click();
                    WebUI.scrollToElementToBottom(buttonDeleteAll);
                    WebUI.sleep(5);
                    WebUI.clickElement(buttonDeleteAll);
                    WebUI.sleep(5);
                    WebElement confirmDeleteElement = WebUI.waitForElementVisible(By.xpath("//span[contains(text(),'OK')]"), 10);
                    WebUI.sleep(5);
                    assert confirmDeleteElement != null;
                    confirmDeleteElement.click();
                    WebUI.reloadPage();
                    WebUI.sleep(3);
                }
            }
        }
    }

    private void importLicense(String fileLicense) {
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + fileLicense);
        WebUI.clickElement(dropdownImport);
        WebUI.clickElement(labelImportLicense);
        WebUI.sleep(2);
        WebUI.uploadFileWithLocalForm(buttonChooseFile, importFile.toString());
        WebUI.sleep(5);
        if(WebUI.checkExistElement(buttonContinue, 5)) {
            WebUI.clickElement(buttonContinue);
            WebUI.sleep(5);
            WebUI.scrollToElementToBottom(buttonImportLicenses);
            WebUI.sleep(5);
            WebUI.clickElement(buttonImportLicenses, 5);
            WebUI.sleep(7);
        }
    }

    private void navigateToSchoolViewLicense(String pid) {
        WebUI.clickElement(dropdownManage);
        WebUI.clickElement(manageSchool);
        WebUI.setText(filterPid, pid);
        WebUI.clickElement(applyButton);
        WebUI.sleep(5);
        //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
        List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
        WebUI.sleep(1);
        LogUtils.info("Number of results for keywords (" + pid + "): " + totalRows.size());

        if (totalRows.size() < 1) {
            LogUtils.info("Not found value: " + pid);
        } else {
            WebElement title = WebUI.waitForElementVisible(By.xpath("//tbody/tr[" + 1 + "]/td[" + 6 + "]"));
            assert title != null;
            boolean res = title.getText().toUpperCase().contains(pid.toUpperCase());
            if (!res) {
                LogUtils.info("Row " + 1 + ": " + res + " - " + title.getText());
            } else {
                WebElement iconViewLicense = WebUI.waitForElementClickable(By.xpath("//div[@class='cursor-pointer']//*[name()='svg']"));
                assert iconViewLicense != null;
                iconViewLicense.click();
                WebUI.sleep(5);
                }
            }
    }

    private void verifyFullAccessInToc(String programSeriesName, String toc) {
        WebUI.clickElement(menuMyLibrary);
        WebElement tocElement = WebUI.getWebElement(By.xpath(Objects.requireNonNull(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", programSeriesName)).concat("//following::div[@class='program-grades'][1]//span[contains(text(),'" + toc +"')]")));
        if (tocElement==null) {
            Assert.fail("There aren't products in this school");
            LogUtils.error("Not found any product in this school");
            ExtentReportManager.fail("Not found value: ");
        } else {
            tocElement.click();
            WebUI.sleep(3);
            WebUI.checkElementPresent(By.xpath("//i[@class='sc-icon-fa-report']"));
            WebUI.clickElement(titleContent);
            WebUI.sleep(2);
            WebUI.scrollToElementToBottom(labelFA);
            WebUI.sleep(2);
            WebUI.verifyElementText(labelFA,"* Full Access reporting is available for this assessment.");
        }
    }

    private void navigateToReportFAViaGrade(String programSeriesName, String toc) {
        WebUI.clickElement(menuMyLibrary);
        WebUI.clickElement(By.xpath(Objects.requireNonNull(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", programSeriesName)).
                concat("//following::div[@class='program-grades'][1]//span[contains(text(),'" + toc +"')]")));
//        WebElement tocElement = WebUI.getWebElement(By.xpath(Objects.requireNonNull(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", programSeriesName)).concat("//following::div[@class='program-grades'][1]//span[contains(text(),'" + toc +"')]")));
//        tocElement.click();
        WebUI.sleep(3);
        WebUI.clickElement(By.xpath("//i[@class='sc-icon-fa-report']"));
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }

    private void verifyNotFullAccessInToc(String toc) {
        WebUI.clickElement(menuMyLibrary);
        List<WebElement> totalSeriesContent = WebUI.getWebElements(By.xpath("//div[@class='program-grades']"));
        if (totalSeriesContent.size() < 1) {
            Assert.fail("There aren't products in this school");
            LogUtils.error("Not found any product in this school");
            ExtentReportManager.fail("Not found value: ");
        } else {
            WebElement tocElement = totalSeriesContent.get(0).findElement(By.xpath("//span[contains(text(),'" + toc +"')]"));
            tocElement.click();
            WebUI.sleep(1);
            WebUI.verifyElementNotPresent(By.xpath("//i[@class='sc-icon-fa-report']"));
        }
    }

    public static void checkEqualsValueOnTableByColumn(int column, String value) {
        WebUI.smartWait();
        WebUI.sleep(1);
        List<WebElement> totalRows = WebUI.getWebElements(By.xpath("//tbody/tr"));
        LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

        if (totalRows.size() < 1) {
            LogUtils.error("Not found value: " + value);
            ExtentReportManager.fail("Not found value: " + value);
        } else {
            for (int i = 1; true; i++) {
                boolean res = false;
                WebElement title = WebUI.waitForElementVisible(By.xpath("//tbody/tr["+i+"]/td[" + column + "]"));
                assert title != null;
                res = title.getText().toUpperCase().contains(value.toUpperCase());
                if (!res) {
                    LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
                    Assert.fail("Row " + i + ": " + res + " - " + title.getText());
                    ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
                } else {
                    LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
                    Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
                    ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
                    break;
                }
            }
        }
    }

    public static void checkEqualsValueOnTableByColumnAndRow(int row, int column, String value) {
        WebUI.smartWait();
        WebUI.sleep(1);
        List<WebElement> totalRows = WebUI.getWebElements(By.xpath("//tbody/tr"));
        LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

        if (totalRows.size() < 1) {
            LogUtils.error("Not found value: " + value);
            ExtentReportManager.fail("Not found value: " + value);
        } else {
            for (int i = row; i <= totalRows.size(); i++) {
                boolean res = false;
                WebElement title = WebUI.waitForElementVisible(By.xpath("//tbody/tr["+i+"]/td[" + column + "]"));
                assert title != null;
                res = title.getText().toUpperCase().contains(value.toUpperCase());
                if (!res) {
                    LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
                    Assert.fail("Row " + i + ": " + res + " - " + title.getText());
                    ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
                } else {
                    LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
                    Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
                    ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
                    break;
                }
            }
        }
    }

    private void verifyFAReport(Hashtable<String, String> data) {
        WebUI.clickElement(dropdownReport);
        WebUI.checkElementPresent(labelFullAccess);
        WebUI.clickElement(labelFullAccess);
        WebUI.sleep(2);
        List<WebElement> totalDropDowns = WebUI.getWebElements(By.xpath("//div[@class='sc-gicCDI fqBODh']"));

        if (totalDropDowns.size() < 1) {
            LogUtils.error("Not found any search dropdown");
            ExtentReportManager.fail("Not found any search dropdown");
        } else {
            for (int i = 0; i < 3; i++) {

                WebElement dropdownSearch = totalDropDowns.get(i);
                dropdownSearch.click();
                WebUI.sleep(1);
                By elementDropDown = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + (i == 0 ? data.get(fullAccessModel.getProgramSeries()).trim() :
                    (i == 1 ? data.get(fullAccessModel.getResourceTitle()).trim() : data.get(fullAccessModel.getClazzName()).trim())) + "')]");
                WebUI.checkElementPresent(elementDropDown);
                WebUI.clickElement(elementDropDown, 5);
            }

            WebUI.smartWait();
            WebUI.sleep(1);
            List<WebElement> totalRows = WebUI.getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']"));
            LogUtils.info("Number of results : " + totalRows.size());
            if (totalRows.size() < 1) {
                LogUtils.error("Not found value");
                ExtentReportManager.fail("Not found value");
            }
        }
    }

    private List<String> splitByCharracter(String source, String charracter) {
        String[] results = source.split(charracter);
        return Arrays.asList(results);
    }

    public void verifyDropdownFAReport(Hashtable<String, String> data) {
        List<WebElement> totalDropDowns = WebUI.getWebElements(By.xpath("//div[@class='sc-gicCDI fqBODh']"));

        if (totalDropDowns.size() < 1) {
            LogUtils.error("Not found any search dropdown");
            ExtentReportManager.fail("Not found any search dropdown");
            Assert.fail("Not found any search dropdown");
        } else {

            By elementDropDownSelectProgramSeries = By.xpath("//span[contains(text(),'Select Program Series')]");
            if(WebUI.checkExistElement(elementDropDownSelectProgramSeries, 5)) {
                WebUI.clickElement(elementDropDownSelectProgramSeries);
            } else {
                WebElement dropdownSearch = totalDropDowns.get(0);
                dropdownSearch.click();
            }
            WebUI.sleep(1);

            // verify programSeries v1
            if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("1")) {
                By elementDropDownSeries = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getProgramSeries()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownSeries);
                WebUI.clickElement(elementDropDownSeries);
                WebUI.sleep(1);

                By elementDropDownSelectAssessment = By.xpath("//span[contains(text(),'Select Assessment')]");
                if(WebUI.checkExistElement(elementDropDownSelectAssessment, 5)) {
                    WebUI.clickElement(elementDropDownSelectAssessment);
                }
                WebUI.sleep(1);

                By elementDropDownAssessment = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getResourceTitle()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownAssessment);
                WebUI.clickElement(elementDropDownAssessment);
                WebUI.sleep(1);

                By elementDropDownSelectClass = By.xpath("//span[contains(text(),'Select Class')]");
                if(WebUI.checkExistElement(elementDropDownSelectClass, 5)) {
                    WebUI.clickElement(elementDropDownSelectClass);
                }
                WebUI.sleep(1);

                By elementDropDownClassName = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getClazzName()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownClassName);
                WebUI.clickElement(elementDropDownClassName);
                WebUI.sleep(1);

            } else if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("2")) {
                // Verify programseries V2
                By elementDropDownSeries = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getProgramSeries()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownSeries);
                WebUI.clickElement(elementDropDownSeries);
                WebUI.sleep(1);

                By elementDropDownSelectAssessment = By.xpath("//span[contains(text(),'Select Assessment')]");
                if(WebUI.checkExistElement(elementDropDownSelectAssessment, 5)) {
                    WebUI.clickElement(elementDropDownSelectAssessment);
                }
                WebUI.sleep(1);

                By elementDropDownAssessment = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getResourceTitle()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownAssessment);
                WebUI.clickElement(elementDropDownAssessment);
                WebUI.sleep(1);

                By elementDropDownSelectClass = By.xpath("//span[contains(text(),'Select Class')]");
                if(WebUI.checkExistElement(elementDropDownSelectClass, 5)) {
                    WebUI.clickElement(elementDropDownSelectClass);
                }
                WebUI.sleep(1);

                By elementDropDownClassName = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getClazzName()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownClassName);
                WebUI.clickElement(elementDropDownClassName);
                WebUI.sleep(1);

                By elementDropDownSelectReport = By.xpath("//span[contains(text(),'Class Proficiency Report')]");
                if(WebUI.checkExistElement(elementDropDownSelectReport, 5)) {
                    WebUI.clickElement(elementDropDownSelectReport);
                }
                WebUI.sleep(1);

                By elementDropDownReport = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getReportType()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownReport);
                WebUI.clickElement(elementDropDownReport);
                WebUI.sleep(1);

            } else if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("3")) {
                // Verify programseries V3
                By elementDropDownSeries = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getProgramSeries()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownSeries);
                WebUI.clickElement(elementDropDownSeries, 5);
                WebUI.sleep(1);

                By elementDropDownSelectStandard = By.xpath("//span[contains(text(),'Select Standard Set')]");
                if(WebUI.checkExistElement(elementDropDownSelectStandard, 5)) {
                    WebUI.clickElement(elementDropDownSelectStandard);
                }
                WebUI.sleep(1);

                By elementDropDownStandardSet = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getStandardSet()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownStandardSet);
                WebUI.clickElement(elementDropDownStandardSet);
                WebUI.sleep(1);

                By elementDropDownSelectAssessment = By.xpath("//span[contains(text(),'Select Assessment')]");
                if(WebUI.checkExistElement(elementDropDownSelectAssessment, 5)) {
                    WebUI.clickElement(elementDropDownSelectAssessment, 5);
                }
                WebUI.sleep(1);

                By elementDropDownAssessment = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getResourceTitle()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownAssessment);
                WebUI.clickElement(elementDropDownAssessment);
                WebUI.sleep(1);

                By elementDropDownSelectClass = By.xpath("//span[contains(text(),'Select Class')]");
                if(WebUI.checkExistElement(elementDropDownSelectClass, 5)) {
                    WebUI.clickElement(elementDropDownSelectClass, 5);
                }
                WebUI.sleep(1);

                By elementDropDownClassName = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getClazzName()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownClassName);
                WebUI.clickElement(elementDropDownClassName);
                WebUI.sleep(1);

                By elementDropDownSelectReport = By.xpath("//span[contains(text(),'Class Proficiency Report')]");
                if(WebUI.checkExistElement(elementDropDownSelectReport, 5)) {
                    WebUI.clickElement(elementDropDownSelectReport);
                }
                WebUI.sleep(1);

                By elementDropDownReport = By.xpath("//div[@class='ant-select-item-option-content']/span[contains(text(),'"
                    + data.get(fullAccessModel.getReportType()).trim() + "')]");
                WebUI.checkElementPresent(elementDropDownReport);
                WebUI.clickElement(elementDropDownReport);
                WebUI.sleep(1);
            }
        }
    }

    private void verifySearchChose(Hashtable<String, String> data, int tagType) {
        List<WebElement> totalDropdowns = WebUI.getWebElements(By.xpath("//span[@class='ant-select-selection-item']"));
        if(totalDropdowns != null && totalDropdowns.size() > 0) {
            if(data.get(fullAccessModel.getProgramSeriesVersion()) != null) {
                if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("1")) {
                    for(int j=0; j< 3; j++) {
                        WebElement dropdown = totalDropdowns.get(j);
                        String section = (j == 0) ? data.get(fullAccessModel.getProgramSeries()).trim() :
                            (j == 1 ? data.get(fullAccessModel.getResourceTitle()).trim() : data.get(fullAccessModel.getClazzName()).trim());

                        if(!dropdown.getText().toLowerCase().contains(section.toLowerCase())) {
                            LogUtils.error("Dropdown " + j + ":" + dropdown.getText());
                            Assert.fail("Dropdown " + j + ":" + dropdown.getText());
                        }
                    }
                } else if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("2")) {
                    for(int j=0; j< 4; j++) {
                        WebElement dropdown = totalDropdowns.get(j);
                        String section = (j == 0) ? data.get(fullAccessModel.getProgramSeries()).trim() :
                            (j == 1 ? data.get(fullAccessModel.getResourceTitle()).trim() :
                                (j == 2 ? data.get(fullAccessModel.getClazzName()).trim() :
                                    (tagType == 1 ? data.get(fullAccessModel.getReportType()).trim() : data.get(fullAccessModel.getStudentName()).trim())));

                        if(!dropdown.getText().toLowerCase().contains(section.toLowerCase())) {
                            LogUtils.error("Dropdown " + j + ": " + dropdown.getText());
                            Assert.fail("Dropdown " + j + ": " + dropdown.getText());
                        }
                    }
                } else if(data.get(fullAccessModel.getProgramSeriesVersion()).trim().equalsIgnoreCase("3")) {
                    for (int j = 0; j < 5; j++) {
                        WebElement dropdown = totalDropdowns.get(j);
                        String section =
                            (j == 0) ? data.get(fullAccessModel.getProgramSeries()).trim() :
                                (j == 1 ? data.get(fullAccessModel.getStandardSet()).trim() :
                                    (j == 2 ? data.get(fullAccessModel.getResourceTitle()).trim() :
                                        (j == 3 ? data.get(fullAccessModel.getClazzName()).trim()
                                            : (tagType == 1 ? data.get(fullAccessModel.getReportType()).trim() : data.get(fullAccessModel.getStudentName()).trim()))));

                        if (!dropdown.getText().toLowerCase().contains(section.toLowerCase())) {
                            LogUtils.error("Dropdown " + j + ":" + dropdown.getText());
                            Assert.fail("Dropdown " + j + ":" + dropdown.getText());
                        }
                    }
                }
            }
        }
    }

    private void verifyHeadTitleFAReport() {
        List<WebElement> headTexts = WebUI.getWebElements(By.xpath("//thead/tr/th"));

        if (headTexts != null && headTexts.size() > 0) {
            if(headTexts.size() != 6) {
                LogUtils.error("Report missed column");
                Assert.fail("Report missed column");
            }
            for(int i=1; i <= headTexts.size(); i++) {
                WebElement headerEle = WebUI.waitForElementVisible(By.xpath("//thead/tr/th[" + i +"]"));
                String header = headerEle.getText();

                String  headerCorrect = (i==1) ? "All Classes" :
                    (i == 2 ? "All Students" :
                        (i == 3) ? "Categories/Levels" :
                            (i == 4) ? "Score (%)" :
                                (i == 5) ? "Test Date" : "Recommended Resources");
                if(header == null && header.equalsIgnoreCase(headerCorrect)) {
                    LogUtils.error("Column name " + i + ":" + header + " not correct");
                    Assert.fail("Column name " + i + ":" + header + " not correct");
                }
            }
        }
    }

    private void verifyRowFAReport(List<WebElement> elements) {
        for(int i = 1 ; i<= elements.size(); i++) {
            WebElement scoreEle = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[4]"));
            WebElement colorEle = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[3]/div"));
            WebElement titleEle = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[2]"));
            Integer score = (scoreEle.getText() != null && StringUtils.isNotBlank(scoreEle.getText())) ?  Integer.valueOf(scoreEle.getText()) : -1;

            String color = colorEle.getCssValue("background-color");
            color = color.replaceAll("\\s", "");
            if(score >= 0 && score <= 49) {
                if(!(color.equalsIgnoreCase("rgba(232,148,171,1)") || color.equalsIgnoreCase("rgb(232,148,171)"))) {
                    LogUtils.error("Color not correct for: " + titleEle.getText());
                    Assert.fail("Color not correct for: " + titleEle.getText());
                }
            } else if(score >= 50 && score <= 79) {
                if(!(color.equalsIgnoreCase("rgba(253,186,107,1)") || color.equalsIgnoreCase("rgb(253,186,107)"))) {
                    LogUtils.error("Color not correct for: " + titleEle.getText());
                    Assert.fail("Color not correct for: " + titleEle.getText());
                }
            } else if(score >= 80 && score <= 100) {
                if(!(color.equalsIgnoreCase("rgba(154,211,168,1)") || color.equalsIgnoreCase("rgb(154,211,168)"))) {
                    LogUtils.error("Color not correct for: " + titleEle.getText());
                    Assert.fail("Color not correct for: " + titleEle.getText());
                }
            }
        }

        List<WebElement> scoreTexts = WebUI.getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']/td[4]"));
        List<Integer> scores = new ArrayList<>();
        if(scoreTexts != null && scoreTexts.size() > 0) {
            for(WebElement scoreText : scoreTexts) {
                scores.add(Integer.valueOf(scoreText.getText().trim()));
            }
            boolean z = false;
            for(int i = 0 ; i < scores.size() - 1 ; i++) {
                if(scores.get(i) > scores.get(i+1)) {
                    z = true;
                }
            }

            if(z) {
                LogUtils.error("Score are sorted increase");
                Assert.fail("Score are sorted increase");
            }
        }
    }

    public void TC_License_01(Hashtable<String, String> data) {
        // Delete all license before import
        deleteAllLicense(data.get(fullAccessModel.getSchoolPid()).trim());
        /*
            1. Need a valid Account system admin to do login.  TC_License_01.csv
        */
        importLicense(data.get(fullAccessModel.getLicenseImportFull()).trim());
        /*
                1. Login to school with account teacher
                2. Select Report tab
        */
        loginUsersViaExcelFile(data);
        //[CP]_1. Should be not show FullAccess report at report dropdown
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkNotExistElement(menuFAReport,5),"Should be not show FullAccess report at report dropdown");
    }

//    public void TC_SC_FULL_ACCESS_01(Hashtable<String, String> data) {
//        // Delete all license before import
//        deleteAllLicense(data.get(fullAccessModel.getSchoolPid()).trim());
//        /*
//        1. Create import licenses file .csv
//        2. Login as system admin
//        3. Select Import licenses at Import dropdown
//        4. Choose file and import licenses
//        */
//        importLicense(data.get(fullAccessModel.getLicenseImportFull()).trim());
//
//        //  5. Login school by teacher
//        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim(),
//                data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
//        if(checkExistElement(remindDialog, 5)) {
//            WebUI.clickElement(closeDialog, 5);
//        }
//        //[CP]_License imported successful to school
//        //[CP]_Not show FA report at Report dropdown
//        verifyNotFullAccessInToc(data.get(fullAccessModel.getGrade()).trim());
//    }

    public void TC_License_02(Hashtable<String, String> data) {
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + data.get(fullAccessModel.getLicenseImportNotFullList()).trim());
        // Import license FA
        WebUI.clickElement(dropdownImport);
        WebUI.clickElement(labelImportLicense);
        WebUI.sleep(2);
        WebUI.uploadFileWithLocalForm(buttonChooseFile, importFile.toString());
        WebUI.sleep(5);
        if(WebUI.checkExistElement(buttonContinue, 5)) {
            WebUI.clickElement(buttonContinue);
            WebUI.sleep(5);

            // check error when import license don't have enough list product codes required.
            checkEqualsValueOnTableByColumnAndRow( 2, 1, data.get(fullAccessModel.getErrorMessage()).trim());

            //Import License
            WebUI.scrollToElementToBottom(buttonImportLicenses);
            WebUI.sleep(2);
            WebUI.clickElement(buttonImportLicenses, 5);
            WebUI.sleep(3);
        }
    }

    public void TC_License_03(Hashtable<String, String> data) {
        // Delete all license
        deleteAllLicense(data.get(fullAccessModel.getSchoolPid()).trim());

        // Import License FA for school
        importLicense(data.get(fullAccessModel.getLicenseImportFull()).trim());
        /*  1. Login to school with account teacher
            2. Select Report tab
                TC_License_03 */
        loginUsersViaExcelFile(data);

        // 1. Should be not show FullAccess report at report dropdown.
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkNotExistElement(menuFAReport,5),"Should be not show FullAccess report at report dropdown.");


    }

    public void TC_License_04(Hashtable<String, String> data) {
        // Delete all license
        deleteAllLicense(data.get(fullAccessModel.getSchoolPid()).trim());

        // 1. Import file license with parent codes and full product code required for PIM7-9 and WB3-8.
        importLicense(data.get(fullAccessModel.getLicenseImportFull()).trim());

        // 1. Login to school with account teacher
        //2. Select Report tab
        //TC_License_04
        loginUsersViaExcelFile(data);

        // 1. Should be show FullAccess report at report dropdown.
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkExistElement(menuFAReport,5),"Should be show FullAccess report at report dropdown.");
    }

    public void TC_License_05(Hashtable<String, String> data) {
        // Import License FA with blank Bundle code for school
        String localDir = System.getProperty("user.dir");
        File importFile = new File(localDir + data.get(fullAccessModel.getLicenseImportBlankBundle()).trim());
        // Import license FA
        WebUI.clickElement(dropdownImport);
        WebUI.clickElement(labelImportLicense);
        WebUI.sleep(2);
        WebUI.uploadFileWithLocalForm(buttonChooseFile, importFile.toString());
        WebUI.sleep(5);
        if(WebUI.checkExistElement(buttonContinue, 5)) {
            WebUI.clickElement(buttonContinue);
            WebUI.sleep(5);

            // check error when import license don't have enough list product codes required.
            checkEqualsValueOnTableByColumnAndRow( 4, 1, data.get(fullAccessModel.getErrorMessage()).trim());
        }

    }

    public void TC_License_06(Hashtable<String, String> data) {
        //import file TC_License_06
        importLicense(data.get(fullAccessModel.getLicenseImportBlankBundle()).trim());

        navigateToSchoolViewLicense(data.get(fullAccessModel.getSchoolPid()).trim());

        checkEqualsValueOnTableByColumnAndRow( 1, 7, DateUtils.getCurrentDateTimeByZone("MM/dd/YYYY"));

        checkEqualsValueOnTableByColumnAndRow( 1, 8, data.get(fullAccessModel.getEndDate()).trim());

        // 1. Login to school with account teacher
        loginUsersViaExcelFile(data);

        // 1. Should be show FullAccess report at report dropdown.
        WebUI.clickElement(dropdownReport);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkExistElement(menuFAReport,5),"Should be show FullAccess report at report dropdown.");

    }

    public void TC_License_09(Hashtable<String, String> data) {
//        1. Login to school with account teacher
        loginUsersViaExcelFile(data);
 //        2. Select My Library
//        3. Select PIM - Grade 7
//        4. Select the TOC "Assessment"
        verifyFullAccessInToc(data.get(fullAccessModel.getProgramSeries().trim()),data.get(fullAccessModel.getGrade().trim()));
    }

    public void TC_License_10(Hashtable<String, String> data) {
//        1. Login to school with account teacher
        loginUsersViaExcelFile(data);
        //1. Select FA icon
        navigateToReportFAViaGrade(data.get(fullAccessModel.getProgramSeries().trim()),data.get(fullAccessModel.getGrade().trim()));
//        1. Should be move to the page FA report.
//        2. Dropdown Program is Select Program Series.
        WebUI.verifyContains(WebUI.getCurrentUrl(), pageUrl, "Move to the page FA report. ");
        WebUI.sleep(1);
        WebUI.verifyElementText(dropDownProgramSeriesName,"Select Program Series");
    }

    public void TC_SC_FA_REPORT_01(Hashtable<String, String> data) {
        // Login As teacher
        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim()
            , data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
        if(WebUI.checkExistElement(remindDialog, 5)) {
            WebUI.clickElement(closeDialog, 5);
        }

        // Access FA report
        WebUI.clickElement(dropdownReport);
        WebUI.checkElementPresent(labelFullAccess);
        WebUI.clickElement(labelFullAccess);
        WebUI.sleep(2);

        // verify Dropdown
        verifyDropdownFAReport(data);
    }

    public void TC_SC_FA_REPORT_02(Hashtable<String, String> data) {
        // Login As teacher
        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim()
            , data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
        if(WebUI.checkExistElement(remindDialog, 5)) {
            WebUI.clickElement(closeDialog, 5);
        }

        // Access FA report
        WebUI.clickElement(dropdownReport);
        WebUI.checkElementPresent(labelFullAccess);
        WebUI.clickElement(labelFullAccess);
        WebUI.sleep(2);

        // verify Dropdown
        verifyDropdownFAReport(data);

        // verify list results
        WebUI.smartWait();
        WebUI.sleep(1);
        List<WebElement> totalRows = WebUI.getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']"));
        LogUtils.info("Number of results : " + totalRows.size());
        if (totalRows.size() < 1) {
            LogUtils.error("Not found value");
            ExtentReportManager.fail("Not found value");
            Assert.fail("Not found value");
        } else {

            // verify header
            verifyHeadTitleFAReport();

            // verify color, score of result.
            verifyRowFAReport(totalRows);

            // verify Recommended Resources link and foundational skills link
            boolean studentExist = false;
            for (int i = 1; i <= totalRows.size(); i++) {
                boolean res = false;
                WebElement title = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[2]"));
                res = title.getText().equalsIgnoreCase(data.get(fullAccessModel.getStudentName()).trim());
                if (res != true) {
                    LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
                    ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + data.get(fullAccessModel.getStudentName()).trim());
                } else {
                    studentExist = true;
                    LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
                    Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + data.get(fullAccessModel.getStudentName()).trim());
                    ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + data.get(fullAccessModel.getStudentName()).trim());

                    title.click();
                    WebUI.waitForPageLoaded();
                    WebUI.sleep(1);

                    WebUI.clickElement(By.xpath("//div[@class='snapshot-resources']"));
                    WebUI.waitForPageLoaded();
                    WebUI.sleep(2);

                    // Back to Assessment Report

                    if(WebUI.checkExistElement(By.xpath("//div[normalize-space()='Assessment Report']"), 5)) {
                        WebUI.clickElement(By.xpath("//div[normalize-space()='Assessment Report']"));
                        WebUI.waitForPageLoaded();
                        WebUI.sleep(2);
                    }

                    if(WebUI.checkExistElement(By.xpath("//div[normalize-space()='Proficiency Report']"), 5)) {
                        WebUI.clickElement(By.xpath("//div[normalize-space()='Proficiency Report']"));
                        WebUI.waitForPageLoaded();
                        WebUI.sleep(2);
                    }

                    // Verify dropdowns have choose
                    verifySearchChose(data, 1);

                    // click foundational skills link
                    if(WebUI.checkExistElement(By.xpath("//div[@class='sc-jIAOiI hHkUnF']/span[@class='link']"), 5)) {
                        WebUI.clickElement(By.xpath("//div[@class='sc-jIAOiI hHkUnF']/span[@class='link']"));
                        WebUI.waitForPageLoaded();
                        WebUI.sleep(5);

                        // back to Assessment Report
                        WebUI.clickElement(dropdownReport);
                        WebUI.checkElementPresent(labelFullAccess);
                        WebUI.clickElement(labelFullAccess);
                        WebUI.sleep(2);

                        // Verify dropdowns have choose
                        verifySearchChose(data, 1);
                    }

                    break;
                }
            }

            if(!studentExist) {
                LogUtils.error("Can no find student with name " + data.get(fullAccessModel.getStudentName()).trim());
                Assert.fail("Can no find student with name " + data.get(fullAccessModel.getStudentName()).trim());
                ExtentReportManager.fail("Can no find student with name " + data.get(fullAccessModel.getStudentName()).trim());
            }
        }
    }

    public void TC_SC_FA_REPORT_03(Hashtable<String, String> data) {
        // Login As teacher
        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim()
            , data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
        if(WebUI.checkExistElement(remindDialog, 5)) {
            WebUI.clickElement(closeDialog, 5);
        }

        // Access FA report
        WebUI.clickElement(dropdownReport);
        WebUI.checkElementPresent(labelFullAccess);
        WebUI.clickElement(labelFullAccess);
        WebUI.sleep(2);

        // verify Dropdown
        verifyDropdownFAReport(data);

        // get list scores
        /*
        List<WebElement> resultRows = WebUI.getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']"));
        Map<String, Integer> scoreMap = new HashMap<>();
        List<Integer> scores = new ArrayList<>();
        if(resultRows != null && resultRows.size() > 0) {
            for(int i=1 ; i <= resultRows.size() ; i++) {
                WebElement scoreEle = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[4]"));
                WebElement titleEle = WebUI.waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0'][" + i +"]/td[2]"));

                if(StringUtils.isNotBlank(scoreEle.getText()) && StringUtils.isNotBlank(titleEle.getText())) {
                    Integer score = Integer.valueOf(scoreEle.getText().trim());
                    scoreMap.put(titleEle.getText(), score);
                    scores.add(score);
                }
            }
        } */

        // Access Chart
        WebElement chartElement = WebUI.waitForElementVisible(By.xpath("(//*[name()='svg'][@id='Layer_1'])[3]"));
        chartElement.click();

        if(!"1".equalsIgnoreCase(data.get(fullAccessModel.getProgramSeriesVersion()).trim())) {
            // verify 2 tab test score and show growth
            WebUI.checkElementPresent(By.xpath("//div[normalize-space()='Test Score']"));
            WebUI.checkElementPresent(By.xpath("//div[normalize-space()='Show Growth']"));

            // verify default tag is test score
            String background = WebUI.getWebElement(By.xpath("//div[normalize-space()='Test Score']")).getCssValue("background-color");
            if("rgba(255, 255, 255, 1)".equalsIgnoreCase(background.trim()) || "rgb(255, 255, 255)".equalsIgnoreCase(background.trim())) {
                LogUtils.error("Default tag is not Test Score");
                Assert.fail("Default tag is not Test Score");
                ExtentReportManager.fail("Default tag is not Test Score");
            }
        }

        WebUI.checkElementPresent(By.xpath("(//*[name()='rect'])[3]"));
        WebUI.clickElement(By.xpath("(//*[name()='rect'])[3]"));

        WebUI.sleep(2);

        // Verify
        WebElement rrLinkElement = WebUI.getWebElement(By.xpath("//p[normalize-space()='Recommended Resources']"));
        rrLinkElement.click();
        WebUI.sleep(2);

        //verify dropdowns have chose
        verifySearchChose(data, 2);
    }

    public void TC_SC_FA_REPORT_04(Hashtable<String, String> data) {
        // Login As teacher
        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim()
            , data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
        if(WebUI.checkExistElement(remindDialog, 5)) {
            WebUI.clickElement(closeDialog, 5);
        }

        // Access FA report
        WebUI.clickElement(dropdownReport);
        WebUI.checkElementPresent(labelFullAccess);
        WebUI.clickElement(labelFullAccess);
        WebUI.sleep(2);

        // verify Dropdown
        verifyDropdownFAReport(data);

        // Access Chart
        WebElement chartElement = WebUI.waitForElementVisible(By.xpath("(//*[name()='svg'][@id='Layer_1'])[3]"));
        chartElement.click();

        if(!"1".equalsIgnoreCase(data.get(fullAccessModel.getProgramSeriesVersion()).trim())) {
            // verify 2 tab test score and show growth
            WebUI.checkElementPresent(By.xpath("//div[normalize-space()='Test Score']"));
            WebUI.checkElementPresent(By.xpath("//div[normalize-space()='Show Growth']"));

            // verify Show Growth tag is disabled
            if(WebUI.getWebElement(By.xpath("//div[normalize-space()='Show Growth']")).isEnabled()){
                LogUtils.error("Button Show Growth is enabled");
                Assert.fail("Button Show Growth is enabled");
                ExtentReportManager.fail("Button Show Growth is enabled");
            }
            WebUI.sleep(2);
        }
    }

    private  boolean checkExistElement(By by, int timeout) {
        WebUI.sleep(5);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.info("Element is present " + by);
            return true;
        } catch (Exception e) {
            LogUtils.info("Element is present " + by);
            return false;
        }
    }


    private  boolean checkNotExistElement(By by, int timeout) {
        WebUI.sleep(5);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.error("Element is present " + by);
            return false;
        } catch (Exception e) {
            LogUtils.info("Element is present " + by);
            return true;
        }
    }

    private  boolean verifyClickable(By by, int timeout) {
        WebUI.smartWait();
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            LogUtils.info("Verify element clickable " + by);
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public void loginUsersViaExcelFile(Hashtable<String, String> data)
    {
        logInWithCredential(data.get(fullAccessModel.getSchoolUrl()).trim(), data.get(fullAccessModel.getPassCode()).trim()
                , data.get(fullAccessModel.getUsername()).trim(), data.get(fullAccessModel.getPassword()).trim());
        if(WebUI.checkExistElement(remindDialog, 2)) {
            WebUI.clickElement(closeDialog, 5);
        }
    }

}
