package selenium.com.projects.sadlierconnect.pages.Profiles;

import org.openqa.selenium.By;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.pages.Projects.ProjectPageSC;


public class AccountSettingPageSC extends CommonPageSC {

    public AccountSettingPageSC() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuClients = By.xpath("//span[normalize-space()='Clients']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public AccountSettingPageSC openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }

    public ManageStudentsPageSC openClientPage() {
        WebUI.clickElement(menuClients);
        return new ManageStudentsPageSC();
    }

    public ProjectPageSC openProjectPage() {
        WebUI.clickElement(menuProjects);
        return new ProjectPageSC();
    }

}
