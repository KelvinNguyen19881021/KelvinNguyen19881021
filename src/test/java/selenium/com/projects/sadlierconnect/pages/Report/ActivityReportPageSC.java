package selenium.com.projects.sadlierconnect.pages.Report;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.ActivityReportModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.ObjectUtils;

import java.util.*;

import static selenium.com.keywords.WebUI.*;

public class ActivityReportPageSC extends CommonPageSC {
    public ActivityReportPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport");
    }

    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    public final static ActivityReportModel activityReportModel = new ActivityReportModel();

    // Filter
    private final By dropDownGrade = By.xpath("(//div[contains(@class,'ant-select-selector')])[1]");
    private final By dropDownClass = By.xpath("(//div[contains(@class,'ant-select-selector')])[2]");
    private final By dropDownActionType = By.xpath("(//div[contains(@class,'ant-select-selector')])[3]");
    private final By buttonApplyFilter = By.xpath("//span[normalize-space()='Apply Filters']");
    private final By inputGrade = By.xpath("//input[@class='ant-input sc-ezWOiH hmYkqp']");
    private final By inputClass = By.xpath("//input[@class='ant-input sc-ezWOiH hmYkqp']");
    private final By inputActionType = By.xpath("(//input[contains(@type,'text')])[3]");

    // Message
    private final By messageWarning = By.xpath("//div[@class='ant-alert-message']");
    private final By messageNoAssignment = By.xpath("//div[@class='text-left']");

    // Label Activity Report Page
    private final By labelGameType = By.xpath("//span[normalize-space()='Game Type']");
    private final By labelDate = By.xpath("//span[normalize-space()='Date Last Submitted']");
    private final By labelAverageClassScore = By.xpath("//th[normalize-space()='Average Class Score']");
    private final By labelCompleted = By.xpath("(//div[contains(@class,'ant-table-column-sorters')])[3]");

    // Label Assignment Report Page
    private final By labelAssignmentReport = By.xpath("//h1[normalize-space()='Assignment Report']");
    private final By labelStudent = By.xpath("//div[@class='ant-table-column-sorters']");
    private final By labelAverageScore = By.xpath("//th[@class='ant-table-cell'][normalize-space()='Average Score']");
    private final By labelAverageConfidence = By.xpath("//th[@class='ant-table-cell'][normalize-space()='Average Confidence']");
    private final By labelCompletion = By.xpath("//th[contains(@class,'ant-table-cell')][normalize-space()='Completion']");
    private final By labelTotalTime = By.xpath("//th[contains(@class,'ant-table-cell')][normalize-space()='Total Time']");
    private final By labelNumberOfAttempts = By.xpath("//th[contains(@class,'ant-table-cell')][normalize-space()='Number Of Attempts']");
    private final By valueStudent = By.xpath("//span[@class='student-name']");
    private final By buttonExport = By.xpath("//span[normalize-space()='Export']");

    // Label Activity Report Detail page
    private final By labelActivityReportDetail = By.xpath("//h4[normalize-space()='Activity Report Detail']");
    private final By labelScore = By.xpath("//th[normalize-space()='Score']");
    private final By labelConfidence = By.xpath("//th[normalize-space()='Confidence']");
    private final By labelTime = By.xpath("//th[normalize-space()='Time']");
    private final By labelCompletionDetail = By.xpath("//th[normalize-space()='Completion']");
    private final By backgroundBlue = By.xpath("//div[@class='ant-progress-bg']");
    private final By backgroundYellow = By.xpath("//div[@class='ant-progress-inner']");
    private final By modalContent = By.xpath("//div[@class='modal-content']//p");

    /* Check display message when not select filter */
    public void applyFilterNotSelect() {
        WebUI.clickElement(buttonApplyFilter);
        WebUI.verifyElementText(messageWarning, "Warning You must select a grade or a class to run this report.");
    }

    /* Check display message when select Grade without data */
    public void applyFilterSelectGrade(Hashtable<String, String> data) {
        WebUI.clickElement(dropDownGrade);
        WebUI.clickElement(inputGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.verifyElementText(messageNoAssignment, "No assignment matching the selected criteria");
    }

    /*
     * Check display message when select Class has data but select Action without
     * data
     */
    public void applyFilterSelectAction(Hashtable<String, String> data) {
        WebUI.clickElement(dropDownClass);
        WebUI.setText(inputClass, data.get((activityReportModel.getClassName())), Keys.ENTER);
        WebUI.clickElement(dropDownActionType);
        WebUI.setText(inputActionType, data.get((activityReportModel.getActionType())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.verifyElementText(messageNoAssignment, "No assignment matching the selected criteria");
    }

    /* Check display message when select Class without data */
    public void applyFilterSelectClass(Hashtable<String, String> data) {
        WebUI.clickElement(dropDownClass);
        WebUI.clickElement(inputClass);
        WebUI.setText(inputClass, data.get((activityReportModel.getClassName())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.verifyElementText(messageNoAssignment, "No assignment matching the selected criteria");
    }

    /* Check sort by Game type when click Game type title */
    public void sortByGameType(Hashtable<String, String> data)
            throws JsonProcessingException {
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.sleep(5);
        WebUI.clickElement(labelGameType);
        verifyDataTableMultipleRows(4, 8, 1, activityReportModel.getExpectedGameType().trim());
    }

    /* Check sort by Date when click Date title */
    public void sortByDate(Hashtable<String, String> data) throws JsonProcessingException {
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.sleep(5);
        WebUI.clickElement(labelDate);
        verifyDataTableMultipleRows(9, 13, 2, activityReportModel.getExpectedDate().trim());
    }

    /* Check not sort by score when click score title */
    public void sortByScore(Hashtable<String, String> data) throws JsonProcessingException {
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.sleep(5);
        WebUI.clickElement(labelAverageClassScore);
        verifyDataTableMultipleRows(14, 18, 3, activityReportModel.getExpectedAverageClassScore().trim());
    }

    /* Check sort by complete student assignment when click complete student assignment title */
    public void sortByCompleteStudentAssignment(Hashtable<String, String> data) throws JsonProcessingException {
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        WebUI.sleep(5);
        WebUI.clickElement(labelCompleted);
        verifyDataTableMultipleRows(19, 23, 4, activityReportModel.getExpectedCompleted().trim());
    }

    /* Check report assignment completed and score=0 */
    public void verifyReportCompleted(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment incomplete and score=0 */
    public void verifyReportInComplete(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundYellow, "background-color"), "rgba(255, 224, 117, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score=60 */
    public void verifyReportCompleteAndScore1(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score=65 */
    public void verifyReportCompleteAndScore2(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='65 %']"), "color"), "rgba(255, 224, 117, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='65%']"), "color"), "rgba(255, 224, 117, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score=80 */
    public void verifyReportCompleteAndScore3(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='80 %']"), "color"), "rgba(0, 128, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='80%']"), "color"), "rgba(0, 128, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score=90 */
    public void verifyReportCompleteAndScore4(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90%']"), "color"), "rgba(0, 0, 255, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score equal 2 times average score */
    public void verifyReportCompleteAndScore5(Hashtable<String, String> data) throws JsonProcessingException {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='70 %']"), "color"), "rgba(255, 224, 117, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='70%']"), "color"), "rgba(255, 224, 117, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");
//        verifyDataTableMultipleRows(30, 31, 1, activityReportModel.getExpectedScore().trim());
//        verifyDataTableMultipleRows(30, 31, 2, activityReportModel.getExpectedConfidence().trim());
//        verifyDataTableMultipleRows(30, 31, 3, activityReportModel.getExpectedTime().trim());
//        verifyDataTableMultipleRows(30, 31, 4, activityReportModel.getExpectedCompletion().trim());

    }

    /* Check report assignment completed and score equal 3 times average score */
    public void verifyReportCompleteAndScore6(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='66 %']"), "color"), "rgba(255, 224, 117, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='66%']"), "color"), "rgba(255, 224, 117, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");

    }

    /* Check report assignment completed and score equal 3 times lasted average score when have >3 report */
    public void verifyReportCompleteAndScore7(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");

    }

    /* Check report assignment InComplete and score when click Back button */
    public void verifyReportCompleteAndScore8(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundYellow, "background-color"), "rgba(255, 224, 117, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90%']"), "color"), "rgba(0, 0, 255, 1)");
        verifyDataAssignmentReportSingleRow(data);
    }

    /*
     * Check report assignment completed and score when replay game stt Incomplete
     */
    public void verifyReportCompleteAndScore9(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");

    }

    /* Check report assignment completed and score when have 2 times Incomplete */
    public void verifyReportCompleteAndScore10(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundYellow, "background-color"), "rgba(255, 224, 117, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");

    }

    /*
     * Check report assignment completed and score when click Done button while
     * playing the game
     */
    public void verifyReportCompleteAndScore11(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90%']"), "color"), "rgba(0, 0, 255, 1)");
        verifyDataAssignmentReportSingleRow(data);
    }

    /*
     * Check report assignment completed and score when replay game stt completed
     * and click exits game
     */
    public void verifyReportCompleteAndScore13(Hashtable<String, String> data) {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60%']"), "color"), "rgba(255, 0, 0, 1)");
        verifyDataAssignmentReportSingleRow(data);
        WebUI.clickElement(valueStudent);
        sleep(5);
        verifyTitleActivityReportDetail(data);
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()),
                "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()),
                "(//table)[3]/tbody/tr");

    }

    /*
     * Check report assignment completed and score when 1 student completed and 1
     * student incomplete
     */
    public void verifyReportCompleteAndScore14(Hashtable<String, String> data) throws JsonProcessingException {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='60 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundYellow, "background-color"), "rgba(255, 224, 117, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='30%']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90%']"), "color"), "rgba(0, 0, 255, 1)");
        verifyDataTableMultipleRows(47, 48, 1, activityReportModel.getExpectedStudent().trim());
        verifyDataTableMultipleRows(47, 48, 2, activityReportModel.getExpectedAverageScore().trim());
        verifyDataTableMultipleRows(47, 48, 3, activityReportModel.getExpectedAverageConfidence().trim());
        verifyDataTableMultipleRows(47, 48, 4, activityReportModel.getExpectedAverageCompletion().trim());
        verifyDataTableMultipleRows(47, 48, 5, activityReportModel.getExpectedTotalTime().trim());
        verifyDataTableMultipleRows(47, 48, 6, activityReportModel.getExpectedNumber().trim());
        WebUI.selectedValueOnTableByColumn(1, data.get(activityReportModel.getExpectedStudent().trim()), "(//table)[1]/tbody/tr");
        sleep(5);
        verifyTitleActivityReportDetail(data);
        verifyDataActivityReportDetailSingleRow(data);
        WebUI.clickElement(By.xpath("//*[name()='svg' and @height='28']"));
        WebUI.selectedValueOnTableByColumn(1, data.get(activityReportModel.getExpectedStudent().trim()), "(//table)[1]/tbody/tr");
        sleep(5);
        verifyDataActivityReportDetailSingleRow(data);
    }

    /* Check report assignment completed and score when 5 student completed */
    public void verifyReportCompleteAndScore15(Hashtable<String, String> data) throws JsonProcessingException {
        filterGradeAndClass(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='38 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(2);
        verifyTitleAssignmentReportSingleRow(data);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='30%']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0%']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='40%']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90%']"), "color"), "rgba(0, 0, 255, 1)");
        verifyDataTableMultipleRows(49, 53, 1, activityReportModel.getExpectedStudent().trim());
        verifyDataTableMultipleRows(49, 53, 2, activityReportModel.getExpectedAverageScore().trim());
        verifyDataTableMultipleRows(49, 53, 3, activityReportModel.getExpectedAverageConfidence().trim());
        verifyDataTableMultipleRows(49, 53, 4, activityReportModel.getExpectedAverageCompletion().trim());
        verifyDataTableMultipleRows(49, 53, 5, activityReportModel.getExpectedTotalTime().trim());
        verifyDataTableMultipleRows(49, 53, 6, activityReportModel.getExpectedNumber().trim());
    }

    /* Check display report assignment when filter grade and class */
    public void verifyReportCompleteAndScore16(Hashtable<String, String> data) throws JsonProcessingException {
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
        sleep(5);
        verifyDataTableMultipleRows(54, 55, 1, activityReportModel.getExpectedGameType().trim());
        verifyDataTableMultipleRows(54, 55, 2, activityReportModel.getExpectedDate().trim());
        verifyDataTableMultipleRows(54, 55, 3, activityReportModel.getExpectedAverageClassScore().trim());
        verifyDataTableMultipleRows(54, 55, 4, activityReportModel.getExpectedCompleted().trim());
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='0 %']"), "color"), "rgba(255, 0, 0, 1)");
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        WebUI.clickElement(dropDownClass);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", data.get(activityReportModel.getClassName().trim()))));
        WebUI.clickElement(buttonApplyFilter);
        sleep(5);
        verifyDataTableMultipleRows(55, 55, 1, activityReportModel.getExpectedGameType().trim());
        verifyDataTableMultipleRows(55, 55, 2, activityReportModel.getExpectedDate().trim());
        verifyDataTableMultipleRows(55, 55, 3, activityReportModel.getExpectedAverageClassScore().trim());
        verifyDataTableMultipleRows(55, 55, 4, activityReportModel.getExpectedCompleted().trim());
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
    }

    /* Check display report assignment when filter grade and action type */
    public void verifyReportCompleteAndScore17(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.verifyContains(getCssValueElement(By.xpath("//span[normalize-space()='90 %']"), "color"), "rgba(0, 0, 255, 1)");
        WebUI.verifyContains(getCssValueElement(backgroundBlue, "background-color"), "rgba(24, 144, 255, 1)");
        verifyDataActivityReportSingleRow(data);
    }

    /* Check export report */
    public void verifyExportReport(Hashtable<String, String> data) {
        filterGradeAndAction(data);
        sleep(5);
        WebUI.clickLinkText(data.get(activityReportModel.getExpectedGameType().trim()));
        sleep(5);
        WebUI.clickElement(buttonExport);
        sleep(5);
        var file = WebUI.verifyFileDownloadedWithJS_ContainsData("activity-assignment-report");
        WebUI.verifyDataReportActivityWithExportFile(file, "(//table)[1]/tbody/tr");
    }

    private void filterGradeAndClass(Hashtable<String, String> data){
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(dropDownClass);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", data.get(activityReportModel.getClassName().trim()))));
        WebUI.clickElement(buttonApplyFilter);
    }

    private void filterGradeAndAction(Hashtable<String, String> data){
        WebUI.clickElement(dropDownGrade);
        WebUI.setText(inputGrade, data.get((activityReportModel.getGrade())), Keys.ENTER);
        WebUI.clickElement(dropDownActionType);
        WebUI.setText(inputActionType, data.get((activityReportModel.getActionType())), Keys.ENTER);
        WebUI.clickElement(buttonApplyFilter);
    }

    private void verifyDataActivityReportSingleRow(Hashtable<String, String> data){
        WebUI.checkEqualsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedGameType().trim()));
        WebUI.checkEqualsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedDate().trim()));
        WebUI.checkEqualsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedAverageClassScore().trim()));
        WebUI.checkEqualsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompleted().trim()) + "\n" + data.get(activityReportModel.getExpectedStudentAssignment().trim()));
    }

    private void verifyTitleAssignmentReportSingleRow(Hashtable<String, String> data){
        WebUI.verifyElementText(labelAssignmentReport, "Assignment Report");
        WebUI.verifyElementExists(labelStudent);
        WebUI.verifyElementExists(labelAverageScore);
        WebUI.verifyElementExists(labelAverageConfidence);
        WebUI.verifyElementExists(labelCompletion);
        WebUI.verifyElementExists(labelTotalTime);
        WebUI.verifyElementExists(labelNumberOfAttempts);
    }
    private void verifyDataAssignmentReportSingleRow(Hashtable<String, String> data){
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedStudent().trim()));
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedAverageScore().trim()));
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedAverageConfidence().trim()));
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedAverageCompletion().trim()));
        WebUI.checkContainsValueOnTableByColumn(5, data.get(activityReportModel.getExpectedTotalTime().trim()));
        WebUI.checkContainsValueOnTableByColumn(6, data.get(activityReportModel.getExpectedNumber().trim()));
    }
    private void verifyTitleActivityReportDetail(Hashtable<String, String> data){
        WebUI.verifyElementText(labelActivityReportDetail, "Activity Report Detail");
        WebUI.verifyElementText(modalContent, "Student: " + data.get(activityReportModel.getExpectedStudent().trim()) + " | Assignment: " + data.get(activityReportModel.getExpectedGameType().trim()));
        WebUI.verifyElementExists(labelScore);
        WebUI.verifyElementExists(labelConfidence);
        WebUI.verifyElementExists(labelTime);
        WebUI.verifyElementExists(labelCompletionDetail);
    }
    private void verifyDataActivityReportDetailSingleRow(Hashtable<String, String> data){
        WebUI.checkContainsValueOnTableByColumn(1, data.get(activityReportModel.getExpectedScore().trim()), "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(2, data.get(activityReportModel.getExpectedConfidence().trim()), "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(3, data.get(activityReportModel.getExpectedTime().trim()), "(//table)[3]/tbody/tr");
        WebUI.checkContainsValueOnTableByColumn(4, data.get(activityReportModel.getExpectedCompletion().trim()), "(//table)[3]/tbody/tr");
    }

    private void verifyDataTableMultipleRows(int beginRow, int endRow, int column, String expectedString)
            throws JsonProcessingException {
        // Get expected data from file data
        Object[][] dataTable = excelHelpers.getDataHashTable(
                Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport",
                beginRow, endRow);
        ArrayList<String> expectedArr = new ArrayList<String>();
        for (int i = 0; i < dataTable.length; i++) {
            for (int j = 0; j < dataTable[i].length; j++) {
                Object element = dataTable[i][j];
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(element);
                JsonNode jsonNote = objectMapper.readTree(json);
                expectedArr.add(jsonNote.get(expectedString).toString());
            }
        }
        var actualArr = WebUI.getValueTableByColumn(column);
        String[] actualData = new String[actualArr.size()];
        String[] expectedData = new String[expectedArr.size()];
        actualArr.toArray(actualData);
        expectedArr.toArray(expectedData);

        // compare array actual data with expected data
        boolean checkSort = true;
        for (int index = 0; index < actualData.length; index++) {
            String elementActual = actualData[index].replaceAll("\n", " ");
            String elementExpected = expectedData[index].replaceAll("\"", "");
            if (!elementActual.equals(elementExpected)) {
                checkSort = false;
            }
        }
        if (checkSort) {
            Assert.assertTrue(true, "The list actual: " + String.join(",", actualData) + " equals list expected: "
                    + String.join(",", expectedData));
            ExtentReportManager.pass("Data correctly: " + String.join(",", expectedData));
        } else {
            Assert.fail("The list actual: " + String.join(",", actualData) + " not equals list expected: "
                    + String.join(",", expectedData));
            ExtentReportManager.fail("Data not equals : " + String.join(",", expectedData));
        }
    }
}