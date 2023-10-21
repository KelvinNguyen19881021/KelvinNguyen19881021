package selenium.com.projects.sadlierconnect.pages.ManageDistricts;

import org.openqa.selenium.By;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;


public class ManageDistrictPageSC extends CommonPageSC {

    public ManageDistrictPageSC() {
        super();
    }

    public static final String pageText = "Manage Districts";
    public static final String pageUrl = "/setting/district-management.html";

    public static final By labelManageDistrict = By.xpath("//h1[normalize-space()='Manage Districts']");







}
