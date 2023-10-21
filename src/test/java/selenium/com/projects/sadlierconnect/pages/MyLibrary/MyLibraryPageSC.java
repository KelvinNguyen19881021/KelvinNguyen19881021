package selenium.com.projects.sadlierconnect.pages.MyLibrary;

import io.netty.util.internal.ObjectUtil;
import com.mysql.cj.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.models.MyLibraryModel;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Projects.ProjectPageSC;
import selenium.com.utils.ObjectUtils;

import java.util.Hashtable;
import java.util.List;
import selenium.com.report.ExtentReportManager;
import selenium.com.utils.LogUtils;
import selenium.com.utils.ObjectUtils;

import java.util.Hashtable;
import java.util.List;


public class MyLibraryPageSC extends CommonPageSC {

    public MyLibraryPageSC() {
        super();
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_MY_LIBRARY_SC_PATH, "Resource");
    }

    public static final String pageText = "My Library";
    public static final String pageUrl = "/library";

    public final By menuMyLibrary = By.xpath("//span[normalize-space()='My Library']");
    public final By listProgramSeriesName  =  By.xpath("//span[normalize-space()='Progress in Mathematics']");
    public final By listProduct =   By.xpath("//div[text()='Progress in Mathematics']/following-sibling::div");
    public final By menuSeeAllProgram = By.xpath("//a[@class='see-all-program-label']");
    public final By smGrade5 = By.xpath("//a[@class='grade-item grade-item-954 ']//span[@class='grade-label'][normalize-space()='5']");
    public final By iconAssignInResource = By.xpath("//span[@title='Assign']");


    public void openLibraryPage() {
        WebUI.clickElement(menuMyLibrary);
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
    }

    public void chooseProgramNameToView(Hashtable<String, String> data)
    {       WebUI.waitForPageLoaded();
            WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[normalize-space()='%s']", data.get(AssignmentJourneyModel.getProductName()))));
            WebUI.sleep(5);
            List<WebElement> listProductGrade = WebUI.getWebElements(By.xpath(ObjectUtils.getXpathDynamic("//div[text()='%s']/following-sibling::div", data.get(AssignmentJourneyModel.getProductName()))));
            for (WebElement productGrade : listProductGrade) {
                if (productGrade.getText().equalsIgnoreCase(data.get(AssignmentJourneyModel.getGradeProduct()))) {
                    productGrade.click();
                    LogUtils.info("Choose a ProgramName " + data.get(AssignmentJourneyModel.getGradeProduct()));
                    ExtentReportManager.info("Choose a ProgramName " + data.get(AssignmentJourneyModel.getGradeProduct()));
                    break;
                }
            }
            WebUI.sleep(10);
    }


    ////span[contains(text(),'Instruction & Practice')]//following::span[contains(text(),'Lesson 5-1: Factors, Primes and Composite Numbers')]
    public void openResource (Hashtable < String, String > myData){
        int index;
        if (myData.get(AssignmentJourneyModel.getResourceType()).equalsIgnoreCase("Assessment")){
            index=2;
        }
        else if(myData.get(AssignmentJourneyModel.getResourceType()).equalsIgnoreCase("Static")){
            index=1;
        }
        else index=0;
        WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getMenuTitle()))));
        WebUI.sleep(5);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getMenuTitle()))));
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
      //  WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')][%d]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()),index)));

        WebUI.sleep(5);


       // WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()))));


        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')][%d]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()),index)));
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
    }
    public void clickAssignIconInLibrary (Hashtable < String, String > myData){
        WebUI.scrollToElementToBottom((By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getMenuTitle())))));
        WebUI.sleep(5);
        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getMenuTitle()))));
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
        WebUI.scrollToElementToBottom(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.sleep(5);

        WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("//span[contains(text(),'%s')]//following::span[contains(text(),'%s')]/following::button[contains(@title,'Assign')][1]", myData.get(AssignmentJourneyModel.getTocHeader()),myData.get(AssignmentJourneyModel.getResourceName()))));
        // WebUI.clickElement(By.xpath(ObjectUtils.getXpathDynamic("(//div[@class='resource-title']//span[contains(text(),'%s')])["+index+"]", myData.get(AssignmentJourneyModel.getResourceName()))));
        WebUI.waitForPageLoaded();
        WebUI.sleep(10);
    }
    public void clickCreateAssignmentIcon() {
            WebUI.clickElement(iconAssignInResource);
            WebUI.sleep(5);
    }
    public void openMyLibrary() {
            WebUI.clickElement(menuSeeAllProgram);
    }

    public void openCreateAssignmentOfResourceByOpenResource(Hashtable < String, String > myData){
        openLibraryPage();
        chooseProgramNameToView(myData);
        openResource(myData);
        clickCreateAssignmentIcon();
    }
    public void openCreateAssignmentOfResourceByAssignInLibrary(Hashtable < String, String > myData){
        openLibraryPage();
        chooseProgramNameToView(myData);
        clickAssignIconInLibrary(myData);
    }



}