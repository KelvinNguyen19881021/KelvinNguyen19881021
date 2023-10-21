package selenium.com.projects.sadlierconnect.pages.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;

import selenium.com.projects.sadlierconnect.pages.CommonPageSC;


import java.util.Hashtable;
import java.util.List;


public class AssignmentFilterStatusPageSC extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    public AssignmentFilterStatusPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_FILTER_STATUS_SC_PATH, "Filter_Status");
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By labelAssignmentList = By.xpath("//span[@class='badge-group']");
    public By dropdownClass = By.xpath("//div[@class='ant-select ant-select-lg select ant-select-single ant-select-show-arrow']//div[@class='ant-select-selector']");
    public By labelDclass = By.xpath("//span[normalize-space()='Dclass']");
    public By dropdownStatus = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[2]");
    public By labelGraded = By.xpath("//span[normalize-space()='Graded']");
    public By labelNeedsGrading = By.xpath("//span[normalize-space()='Needs Grading']");
    public By labelActive = By.xpath("//span[normalize-space()='Active']");
    public By labelPending = By.xpath("//span[normalize-space()='Pending']");
    public By labelClosedExpired = By.xpath("//span[normalize-space()='Closed / Expired']");
    public By btnApplyFilter = By.xpath("//span[normalize-space()='Apply Filter']");
    public By tableShowAssessment = By.xpath("//div[contains(@class,'ant-table-content')]//table");
    public By messageStatus = By.xpath("(//td[contains(@class,'ant-table-cell')])[5]");
    public By sortStatus = By.xpath("//span[normalize-space()='Status']");
    public By labelClassStatus = By.xpath("//span[normalize-space()='Class Status']");

    public void checkFilterWithStatusGraded() {

        WebUI.sleep(5);

        WebUI.clickElement(labelAssignmentList);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(dropdownClass);

        WebUI.sleep(2);

        WebUI.clickElement(labelClassStatus, 2);

        WebUI.sleep(2);

        WebUI.clickElement(dropdownStatus);

        WebUI.sleep(2);

        WebUI.clickElement(labelGraded, 2);

        WebUI.sleep(2);

        WebUI.clickElement(btnApplyFilter);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        //[CP]_Should show all assignments with status graded

        WebUI.verifyElementVisible(tableShowAssessment);

        WebUI.sleep(3);

        WebUI.checkValueOnReportTableByRowAndColumn(1, 5,  "Graded");

        WebUI.sleep(3);

        //[CP]_Should show assignment with expired and least a student in assignment was graded (Status : Expired)

        WebUI.checkValueOnReportTableByRowAndColumn(4, 5, "Expired");

        WebUI.sleep(3);

    }

    public void checkFilterWithStatusPending() {

        WebUI.sleep(5);

        WebUI.clickElement(labelAssignmentList);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(dropdownClass);

        WebUI.sleep(2);

        WebUI.clickElement(labelClassStatus, 2);

        WebUI.sleep(2);

        WebUI.clickElement(dropdownStatus);

        WebUI.sleep(2);

        WebUI.clickElement(labelPending, 2);

        WebUI.sleep(2);

        WebUI.clickElement(btnApplyFilter);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        //[CP]_Should show all assignments with status pending

        WebUI.verifyElementVisible(tableShowAssessment);

        WebUI.sleep(3);

        WebUI.checkValueOnReportTableByRowAndColumn(1,5,"Pending");

        WebUI.sleep(3);

    }

    public void checkFilterWithStatusNeedsGrading() {

        WebUI.sleep(5);

        WebUI.clickElement(labelAssignmentList);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(dropdownClass);

        WebUI.sleep(2);

        WebUI.clickElement(labelClassStatus, 2);

        WebUI.sleep(2);

        WebUI.clickElement(dropdownStatus);

        WebUI.sleep(2);

        WebUI.clickElement(labelNeedsGrading, 2);

        WebUI.sleep(2);

        WebUI.clickElement(btnApplyFilter);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        //[CP]_Should show all assignments with status need grading (expired + active)

        WebUI.verifyElementVisible(tableShowAssessment);

        WebUI.sleep(3);

        WebUI.checkValueOnReportTableByRowAndColumn(1,5, "Needs Grading");

        WebUI.sleep(3);

    }

    public void checkFilterWithStatusActive() {

        WebUI.sleep(5);

        WebUI.clickElement(labelAssignmentList);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(dropdownClass);

        WebUI.sleep(2);

        WebUI.clickElement(labelClassStatus, 2);

        WebUI.sleep(2);

        WebUI.clickElement(dropdownStatus);

        WebUI.sleep(2);

        WebUI.clickElement(labelActive, 2);

        WebUI.sleep(2);

        WebUI.clickElement(btnApplyFilter);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(sortStatus);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        //[CP]_Should show all assignments with status active

        WebUI.verifyElementVisible(tableShowAssessment);

        WebUI.sleep(3);

        WebUI.checkValueOnReportTableByRowAndColumn(1, 5, "Active");

        WebUI.sleep(3);

        //[CP]_Should show assignment has status need grading but assignment is not expired

        WebUI.checkValueOnReportTableByRowAndColumn(4, 5, "Needs Grading");

        WebUI.sleep(3);

        //[CP]_Should show assignment has status graded but assignment is not expired

        WebUI.checkValueOnReportTableByRowAndColumn(2,5, "Graded");

        WebUI.sleep(3);

    }

    public void checkFilterWithStatusClosedExpired() {

        WebUI.sleep(5);

        WebUI.clickElement(labelAssignmentList);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(dropdownClass);

        WebUI.sleep(2);

        WebUI.clickElement(labelClassStatus, 2);

        WebUI.sleep(2);

        WebUI.clickElement(dropdownStatus);

        WebUI.sleep(2);

        WebUI.clickElement(labelClosedExpired, 2);

        WebUI.sleep(2);

        WebUI.clickElement(btnApplyFilter);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        WebUI.clickElement(sortStatus);

        WebUI.waitForPageLoaded();

        WebUI.sleep(2);

        //[CP]_Should show all assignments with status expired

        WebUI.verifyElementVisible(tableShowAssessment);

        WebUI.sleep(3);

        WebUI.checkValueOnReportTableByRowAndColumn(1,5, "Expired");

        WebUI.sleep(3);

        //[CP]_Should show assignment has status need grading but assignment is expired

        WebUI.checkValueOnReportTableByRowAndColumn(5,5, "Needs Grading");

        WebUI.sleep(3);

        //[CP]_Should show assignment has status graded but assignment is  expired

        WebUI.checkValueOnReportTableByRowAndColumn(4,5, "Graded");

        WebUI.sleep(3);

    }

}
