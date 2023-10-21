package selenium.com.common;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import selenium.com.driver.DriverManager;
import selenium.com.driver.TargetFactory;
import selenium.com.helpers.PropertiesHelpers;
import selenium.com.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.report.ExtentReportManager;
import selenium.com.report.ExtentTestManager;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageSC {

    @Parameters("BROWSER")
    @BeforeMethod(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverManager.quit();
    }

    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void removeResultFromReport(ITestResult result) {
        ExtentTest test = ExtentTestManager.getExtentTest();
        if (!result.getMethod().getMethodName().contains("TC_")) {
            test.getExtent().removeTest(test); // Xóa kết quả của test script ra khỏi report
        }
    }

}
