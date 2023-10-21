package selenium.com.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            System.gc();
        }
    }

    public static WebDriver optionsHiddenDriver() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("mac")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            return new ChromeDriver(options);
        } else if (osName.toLowerCase().contains("win")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            return new EdgeDriver(options);
        } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless=new");
            return new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            return new ChromeDriver(options);
        }
    }

    public static WebDriver optionsDislayedDriver() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("mac")) {
            ChromeOptions optionMac = new ChromeOptions();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            optionMac.setExperimentalOption("prefs", prefs);
            optionMac.addArguments("--disable-extensions");
            optionMac.addArguments("--disable-infobars");
            optionMac.addArguments("--disable-notifications");
            optionMac.addArguments("--remote-allow-origins=*");
            optionMac.addArguments("window-size=1920,1080");
            optionMac.addArguments("--disable-component-update");
            optionMac.setPageLoadStrategy(PageLoadStrategy.NONE);
            return new ChromeDriver(optionMac);
        } else if (osName.toLowerCase().contains("win")) {
            ChromeOptions optionWin = new ChromeOptions();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            optionWin.setExperimentalOption("prefs", prefs);
            optionWin.addArguments("--disable-extensions");
            optionWin.addArguments("--disable-infobars");
            optionWin.addArguments("--disable-notifications");
            optionWin.addArguments("--remote-allow-origins=*");
            optionWin.addArguments("window-size=1920,1080");
            optionWin.addArguments("--disable-component-update");
            optionWin.setPageLoadStrategy(PageLoadStrategy.NONE);
            return new ChromeDriver(optionWin);
        } else if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux")) {
            FirefoxOptions optionFF = new FirefoxOptions();
            optionFF.setCapability("prefs", prefs);
            optionFF.addArguments("window-size=1920,1080");
            optionFF.setPageLoadStrategy(PageLoadStrategy.NONE);
            optionFF.addArguments("-disable-notifications");
            optionFF.addArguments("--disable-popup-blocking");
            optionFF.addPreference("app.update.auto", false);
            optionFF.addPreference("browser.urlbar.Suggest.searches", false);
            return new FirefoxDriver(optionFF);
        } else {
            ChromeOptions options = new ChromeOptions();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("window-size=1920,1080");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            return new ChromeDriver(options);
        }
    }


//    public static String getInfo() {
//        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//        String browserName = cap.getBrowserName();
//        String platform = cap.getPlatformName().toString();
//        String version = cap.getBrowserVersion();
//        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
//    }
}
