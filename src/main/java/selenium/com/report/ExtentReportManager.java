package selenium.com.report;

import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.helpers.CaptureHelpers;
import selenium.com.utils.BrowserInfoUtils;
import selenium.com.utils.DateUtils;
import selenium.com.utils.IconUtils;
import selenium.com.utils.ReportUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tech.grasshopper.reporter.ExtentPDFReporter;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static selenium.com.constants.FrameworkConstants.*;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static String link = "";

    public static void initReports() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();

            if (OVERRIDE_REPORTS.trim().equals(NO)) {
                System.out.println("OVERRIDE EXTENT REPORTS = " + OVERRIDE_REPORTS);
                link = EXTENT_REPORT_FOLDER_PATH + File.separator + DateUtils.getCurrentDateTimeCustom("_") + "_" + EXTENT_REPORT_FILE_NAME;
                System.out.println("Link Extent Report: " + link);
            } else {
                System.out.println("OVERRIDE EXTENT REPORTS = " + OVERRIDE_REPORTS);
                link = EXTENT_REPORT_FILE_PATH;
                System.out.println("Link Extent Report: " + link);
            }

            /*ExtentPDFReporter pdf = new ExtentPDFReporter("reports/ExtentReports/PdfReport.pdf");
            try {
                pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            extentReports.attachReporter(pdf);*/

            ExtentSparkReporter spark = new ExtentSparkReporter(link);
            extentReports.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle(FrameworkConstants.REPORT_TITLE);
            spark.config().setReportName(FrameworkConstants.REPORT_TITLE);
            spark.config().setTimelineEnabled(false);
            extentReports.setSystemInfo("Framework Name", FrameworkConstants.REPORT_TITLE);
            extentReports.setSystemInfo("Project Name", FrameworkConstants.PROJECT_NAME);
            extentReports.setSystemInfo("Author", FrameworkConstants.AUTHOR);

            System.out.println("Extent Reports is installed.");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentTestManager.unload();
        ReportUtils.openReports(link);
    }

    public static void createTest(String testCaseName) {
        // ExtentManager.setExtentTest(extent.createTest(testCaseName));
        ExtentTestManager.setExtentTest(extentReports.createTest(IconUtils.getBrowserIcon() + " : " + testCaseName));

    }

    public static void createTest(String testCaseName, String description) {
        // ExtentManager.setExtentTest(extent.createTest(testCaseName));
        ExtentTestManager.setExtentTest(extentReports.createTest(testCaseName, description));
    }

    public static void removeTest(String testCaseName, CategoryType [] categories) {
        // ExtentManager.setExtentTest(extent.createTest(testCaseName));
        for (CategoryType category : categories) {
            if (category.toString().equals(CategoryType.RESET_DATA.toString())) {
                extentReports.removeTest(testCaseName);
            }
        }
    }

    public static void removeTestBySuite(String testSuite, CategoryType [] categories) {
        // ExtentManager.setExtentTest(extent.createTest(testCaseName));
        for (CategoryType category : categories) {
            if (category.toString().equals(CategoryType.RESET_DATA.toString())) {
                extentReports.removeTest(testSuite);
            }
        }
    }

    /**
     * Adds the screenshot.
     *
     * @param message the message
     */
    public static void addScreenShot(String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        //Base64 from Screenshot of Selenium
        //ExtentTestManager.getExtentTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

        //File Path from Screenshot of Java
        ExtentTestManager.getExtentTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(String.valueOf(CaptureHelpers.getScreenshotFile(message))).build());

    }

    /**
     * Adds the screenshot.
     *
     * @param status  the status
     * @param message the message
     */
    public static void addScreenShot(Status status, String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        //Base64 from Screenshot of Selenium
        //ExtentTestManager.getExtentTest().log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

        //File Path from Screenshot of Java
        ExtentTestManager.getExtentTest().log(status, MediaEntityBuilder.createScreenCaptureFromPath(CaptureHelpers.getScreenshotAbsolutePath(message)).build());

    }

    public static synchronized void addAuthors(AuthorType[] authors) {
        if (authors == null) {
            ExtentTestManager.getExtentTest().assignAuthor("BV");
        } else {
            for (AuthorType author : authors) {
                ExtentTestManager.getExtentTest().assignAuthor(author.toString());
            }
        }
    }

    // public static void addCategories(String[] categories) {
    public static synchronized void addCategories(CategoryType[] categories) {
        if (categories == null) {
            ExtentTestManager.getExtentTest().assignCategory("REGRESSION");
        } else {
            // for (String category : categories) {
            for (CategoryType category : categories) {
                if(!category.toString().equals(CategoryType.RESET_DATA.toString())) {
                    ExtentTestManager.getExtentTest().assignCategory(category.toString());
                }
            }
        }
    }
    public static synchronized void addDevices(CategoryType[] categories) {
        for (CategoryType category : categories) {
            if(!category.toString().equals(CategoryType.RESET_DATA.toString())) {
                ExtentTestManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
            }
        }

//		ExtentReportManager.getExtentTest()
//				.assignDevice(BrowserIconUtils.getBrowserIcon() + " : " + BrowserInfoUtils.getBrowserInfo());
    }

    public static synchronized void addDevices() {
        ExtentTestManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
//		ExtentReportManager.getExtentTest()
//				.assignDevice(BrowserIconUtils.getBrowserIcon() + " : " + BrowserInfoUtils.getBrowserInfo());
    }

    public static void logMessage(String message) {
        ExtentTestManager.getExtentTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        ExtentTestManager.getExtentTest().log(status, message);
    }

    public static void logMessage(Status status, Object message) {
        ExtentTestManager.getExtentTest().log(status, (Throwable) message);
    }

    public static void pass(String message) {
        //System.out.println("ExtentReportManager class: " + ExtentTestManager.getExtentTest());
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void pass(Markup message) {
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void fail(Object message) {
        ExtentTestManager.getExtentTest().fail((String) message);
    }

    public static void fail(Markup message) {
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void skip(Markup message) {
        ExtentTestManager.getExtentTest().skip(message);
    }

    public static void info(Markup message) {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void info(String message) {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void warning(String message) {
        ExtentTestManager.getExtentTest().log(Status.WARNING, message);
    }

}
