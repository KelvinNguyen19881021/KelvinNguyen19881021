package selenium.com.projects.sadlierconnect.pages.Projects;

import org.openqa.selenium.By;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;

public class ProjectPageSC extends CommonPageSC {

    public ProjectPageSC() {
    }

    private String pageText = "Projects";

    //Project Page Element
    private By projectMenu = By.xpath("//span[normalize-space()='Projects']");
    private By searchInput = By.xpath("//input[@type='search']");

    public void searchByValue(String value) {
        WebUI.clearText(searchInput);
        WebUI.setText(searchInput, value);
        WebUI.sleep(1);
    }

}
