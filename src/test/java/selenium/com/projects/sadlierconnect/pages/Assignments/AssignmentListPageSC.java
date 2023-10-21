package selenium.com.projects.sadlierconnect.pages.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.AssignmentJourneyModel;

import selenium.com.projects.sadlierconnect.pages.CommonPageSC;


import java.util.Hashtable;
import java.util.List;


public class AssignmentListPageSC extends CommonPageSC {

    public AssignmentListPageSC() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    public By labelAssignmentList = By.xpath("(//h1[normalize-space()='Assignment List'])[1]");
    public By dropdownClass = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[1]");
    public By inputClass = By.xpath("(//input[@class='ant-input sc-ezWOiH hmYkqp'])[1]");
    public By dropdownStatus = By.xpath("(//span[contains(@class,'ant-select-selection-item')])[2]");
    public By inputStatus = By.xpath("(//input[contains(@type,'text')])[3]");
    public By dropdownProgram = By.xpath("(//span[contains(text(),'All Programs')])[1]");
    public By inputProgram = By.xpath("(//input[contains(@type,'text')])[4]");
    public By dropdownUnitChapter = By.xpath("(//span[contains(text(),'All Units')])[1]");
    public By inputUnitChapter = By.xpath("(//input[contains(@type,'text')])[5]");
    public By checkboxMe = By.xpath("//span[normalize-space()='Me']");
    public By checkboxAdministrator = By.xpath("//span[normalize-space()='Administrators']");
    public By buttonApplyFilter = By.xpath("//span[normalize-space()='Apply Filter']");










    public AssignmentListPageSC openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }


    public void filterAssignment(Hashtable<String,String> myData){
        List<String> listClass = WebUI.splitString(myData.get(AssignmentJourneyModel.getClassName()),", ");
        for (String classItem: listClass){
        WebUI.clickElement(dropdownClass);
        WebUI.sleep(3);
        WebUI.setText(inputClass,classItem, Keys.ENTER);
        WebUI.sleep(3);

        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(3);
        WebUI.setText(inputStatus,"Status", Keys.ENTER);
        WebUI.sleep(3);

        WebUI.clickElement(dropdownProgram);
        WebUI.sleep(3);
        WebUI.setText(inputProgram,"Program", Keys.ENTER);
        WebUI.sleep(3);

        WebUI.clickElement(dropdownUnitChapter);
        WebUI.sleep(3);
        WebUI.setText(inputUnitChapter,"", Keys.ENTER);
        WebUI.sleep(3);

        if (myData.get(AssignmentJourneyModel.getPartAssignment()).equalsIgnoreCase("No")){
            WebUI.clickElement(checkboxMe);
        }
        if (myData.get(AssignmentJourneyModel.getPartAssignment()).equalsIgnoreCase("No")){
                WebUI.clickElement(checkboxAdministrator);
            }

        WebUI.clickElement(buttonApplyFilter);

        }

    }








}
