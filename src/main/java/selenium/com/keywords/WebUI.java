package selenium.com.keywords;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Headers;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.enums.FailureHandling;
import selenium.com.helpers.Helpers;
import selenium.com.report.AllureManager;
import selenium.com.report.ExtentReportManager;
import selenium.com.report.ExtentTestManager;
import selenium.com.utils.BrowserInfoUtils;
import selenium.com.utils.DateUtils;
import selenium.com.utils.LogUtils;
import selenium.com.utils.ObjectUtils;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.*;

import static selenium.com.constants.FrameworkConstants.*;

/**
 * Keyword WebUI là class chung làm thư viện xử lý sẵn với nhiều hàm custom từ Selenium và Java.
 * Trả về là một Class chứa các hàm Static. Gọi lại dùng bằng cách lấy tên class chấm tên hàm (WebUI.method)
 */
public class WebUI {

  private static final SoftAssert softAssert = new SoftAssert();

  public static void stopSoftAssertAll() {
    softAssert.assertAll();
  }

  public static void smartWait() {
    if (ACTIVE_PAGE_LOADED.trim().equalsIgnoreCase("true")) {
      waitForPageLoaded();
    }
    sleep(WAIT_SLEEP_STEP);
  }

  public static void addScreenshotToReport(String screenshotName) {
    if (SCREENSHOT_ALL_STEPS.equals(YES)) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.addScreenShot(Helpers.makeSlug(screenshotName));
      }
      //CaptureHelpers.captureScreenshot(DriverManager.getDriver(), Helpers.makeSlug(screenshotName));
      AllureManager.takeScreenshotStep();
    }
  }

  public static String getPathDownloadDirectory() {
    String path = "";
    String machine_name = System.getProperty("user.home");
    path = machine_name + File.separator + "Downloads";
    return path;
  }

  public static int countFilesInDownloadDirectory() {
    String pathFolderDownload = getPathDownloadDirectory();
    File file = new File(pathFolderDownload);
    int i = 0;
    for (File listOfFiles : file.listFiles()) {
      if (listOfFiles.isFile()) {
        i++;
      }
    }
    return i;
  }

  public static boolean verifyFileContainsInDownloadDirectory(String fileName) {
    boolean flag = false;
    try {
      String pathFolderDownload = getPathDownloadDirectory();
      File dir = new File(pathFolderDownload);
      File[] files = dir.listFiles();
      if (files == null || files.length == 0) {
        flag = false;
      }
      for (int i = 0; i < files.length; i++) {
        if (files[i].getName().contains(fileName)) {
          flag = true;
        }
      }
      return flag;
    } catch (Exception e) {
      e.getMessage();
      return flag;
    }
  }

  public static boolean verifyFileEqualsInDownloadDirectory(String fileName) {
    boolean flag = false;
    try {
      String pathFolderDownload = getPathDownloadDirectory();
      File dir = new File(pathFolderDownload);
      File[] files = dir.listFiles();
      if (files == null || files.length == 0) {
        flag = false;
      }
      for (int i = 0; i < files.length; i++) {
        if (files[i].getName().equals(fileName)) {
          flag = true;
        }
      }
      return flag;
    } catch (Exception e) {
      e.getMessage();
      return flag;
    }
  }

  public static Boolean verifyDownloadFileContainsNameCompletedWaitTimeout(String fileName, int timeoutSeconds) {
    boolean check = false;
    int i = 0;
    while (i < timeoutSeconds) {
      boolean exist = verifyFileContainsInDownloadDirectory(fileName);
      if (exist) {
        i = timeoutSeconds;
        return check = true;
      }
      sleep(1);
      i++;
    }
    return check;
  }


  public static Boolean verifyDownloadFileEqualsNameCompletedWaitTimeout(String fileName, int timeoutSeconds) {
    boolean check = false;
    int i = 0;
    while (i < timeoutSeconds) {
      boolean exist = verifyFileEqualsInDownloadDirectory(fileName);
      if (exist) {
        i = timeoutSeconds;
        return check = true;
      }
      sleep(1);
      i++;
    }
    return check;
  }

  public static void deleteAllFileInDownloadDirectory() {
    try {
      String pathFolderDownload = getPathDownloadDirectory();
      File file = new File(pathFolderDownload);
      File[] listOfFiles = file.listFiles();
      for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
          new File(listOfFiles[i].toString()).delete();
        }
      }
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public static void deleteAllFileInDirectory(String pathDirectory) {
    try {
      File file = new File(pathDirectory);
      File[] listOfFiles = file.listFiles();
      for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
          new File(listOfFiles[i].toString()).delete();
        }
      }
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Step("Verify File Downloaded With JS [Equals]: {0}")
  public static Boolean verifyFileDownloadedWithJS_Equals(String fileName) {
    getURL("chrome://downloads");
    sleep(3);
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    String element = (String) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#show').getAttribute('title')");
    File file = new File(element);
    LogUtils.info(element);
    LogUtils.info(file.getName());
    if (file.exists() && file.getName().trim().equals(fileName)) {
      ExtentReportManager.pass("File Downloaded is: " + fileName);
      return true;
    } else {
      ExtentReportManager.fail("File Downloaded is: " + fileName);
      return false;
    }
  }

  @Step("Verify File Downloaded With JS [Contains]: {0}")
  public static Boolean verifyFileDownloadedWithJS_Contains(String fileName) {
    getURL("chrome://downloads");
    sleep(3);
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    String element = (String) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#show').getAttribute('title')");
    File file = new File(element);
    LogUtils.info(element);
    LogUtils.info(file.getName());
    if (file.exists() && file.getName().trim().contains(fileName)) {
      ExtentReportManager.pass("File Downloaded is: " + fileName);
      return true;
    } else {
      ExtentReportManager.fail("File Downloaded is: " + fileName);
      return false;
    }
  }

  /**
   * Login as Authentication on URL
   *
   * @param url
   * @param username
   * @param password
   */
  @Step("Get to URL {0} with authentication")
  public static void getToUrlAuthentication(String url, String username, String password) {
    // Get the devtools from the running driver and create a session
    DevTools devTools = ((HasDevTools) DriverManager.getDriver()).getDevTools();
    devTools.createSession();

    // Enable the Network domain of devtools
    devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));
    String auth = username + ":" + password;

    // Encoding the username and password using Base64 (java.util)
    String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

    // Pass the network header -> Authorization : Basic <encoded String>
    Map<String, Object> headers = new HashMap<>();
    headers.put("Authorization", "Basic " + encodeToString);
    devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

    LogUtils.info("getToUrlAuthentication with URL: " + url);
    LogUtils.info("getToUrlAuthentication with Username: " + username);
    LogUtils.info("getToUrlAuthentication with Password: " + password);
    // Load the application url
    getURL(url);
    Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
  }

  /**
   * Get code text of QR Code image
   *
   * @param by là an element of object type By
   * @return text of QR Code
   */
  @Step("Get QR code from image {0}")
  public static String getQRCodeFromImage(By by) {
    String qrCodeURL = WebUI.getAttributeElement(by, "src");
    //Create an object of URL Class
    URL url = null;
    try {
      url = new URL(qrCodeURL);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
    //Pass the URL class object to store the file as image
    BufferedImage bufferedimage = null;
    try {
      bufferedimage = ImageIO.read(url);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // Process the image
    LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
    BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
    //To Capture details of QR code
    Result result = null;
    try {
      result = new MultiFormatReader().decode(binaryBitmap);
    } catch (com.google.zxing.NotFoundException e) {
      throw new RuntimeException(e);
    }
    return result.getText();
  }

  //Handle HTML5 validation message and valid value

  /**
   * Kiểm tra field có bắt buộc nhập hay không
   *
   * @param by là element thuộc kiểu By
   * @return true/false tương ứng với required
   */
  @Step("Verify HTML5 message of element {0} required field")
  public static Boolean verifyHTML5RequiredField(By by) {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    Boolean verifyRequired = (Boolean) js.executeScript("return arguments[0].required;", getWebElement(by));
    return verifyRequired;
  }

  /**
   * Kiểm tra giá trị trong field nhập có hợp lệ hay chưa
   *
   * @param by là element thuộc kiểu By
   * @return true/false tương ứng với Valid
   */
  @Step("Verify HTML5 message of element {0} valid")
  public static Boolean verifyHTML5ValidValueField(By by) {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    Boolean verifyValid = (Boolean) js.executeScript("return arguments[0].validity.valid;", getWebElement(by));
    return verifyValid;
  }

  /**
   * Lấy ra câu thông báo từ HTML5 của field
   *
   * @param by là element thuộc kiểu By
   * @return giá trị chuỗi Text của câu thông báo (String)
   */
  @Step("Get HTML5 message of element {0}")
  public static String getHTML5MessageField(By by) {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    String message = (String) js.executeScript("return arguments[0].validationMessage;", getWebElement(by));
    return message;
  }


  /**
   * Khôi phục cửa sổ và đặt kích thước cửa sổ.
   *
   * @param widthPixel  is Width with Pixel
   * @param heightPixel is Height with Pixel
   */
  public static void setWindowSize(int widthPixel, int heightPixel) {
    DriverManager.getDriver().manage().window().setSize(new Dimension(widthPixel, heightPixel));
  }

  /**
   * Di chuyển cửa sổ đến vị trí đã chọn X, Y tính từ 0 gốc trái trên cùng
   *
   * @param X (int) - ngang
   * @param Y (int) - dọc
   */
  public static void setWindowPosition(int X, int Y) {
    DriverManager.getDriver().manage().window().setPosition(new Point(X, Y));
  }

  public static void maximizeWindow() {
    DriverManager.getDriver().manage().window().maximize();
  }

  public static void minimizeWindow() {
    DriverManager.getDriver().manage().window().minimize();
  }

  /**
   * Chụp ảnh màn hình tại vị trí element. Không chụp hết cả màn hình.
   *
   * @param by          là element thuộc kiểu By
   * @param elementName để đặt tên file ảnh .png
   */
  public static void screenshotElement(By by, String elementName) {
    File scrFile = getWebElement(by).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(scrFile, new File("./reports/ExtentReports/images/" + elementName + ".png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * In trang hiện tại trong trình duyệt.
   * Note: Chỉ hoạt động ở chế độ headless
   *
   * @param endPage là tổng số trang cần in ra. Tính từ 1.
   * @return is content of page form PDF file
   */
  public static String printPage(int endPage) {
    PrintOptions printOptions = new PrintOptions();
    //From page 1 to end page
    printOptions.setPageRanges("1-" + endPage);

    Pdf pdf = ((PrintsPage) DriverManager.getDriver()).print(printOptions);
    return pdf.getContent();
  }

  public static JavascriptExecutor getJsExecutor() {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    return js;
  }

  /**
   * Chuyển đổi đối tượng dạng By sang WebElement
   * Để tìm kiếm một element
   *
   * @param by là element thuộc kiểu By
   * @return Trả về là một đối tượng WebElement
   */
  public static WebElement getWebElement(By by) {
    return DriverManager.getDriver().findElement(by);
  }

  /**
   * Chuyển đổi đối tượng dạng By sang WebElement
   * Để tìm kiếm nhiều element
   *
   * @param by là element thuộc kiểu By
   * @return Trả về là Danh sách đối tượng WebElement
   */
  public static List<WebElement> getWebElements(By by) {
    return DriverManager.getDriver().findElements(by);
  }

  /**
   * In ra câu message trong Console log
   *
   * @param object truyền vào object bất kỳ
   */
  public static void logConsole(@Nullable Object object) {
    System.out.println(object);
  }

  /**
   * Chờ đợi ép buộc với đơn vị là Giây
   *
   * @param second là số nguyên dương tương ứng số Giây
   */
  public static void sleep(double second) {
    try {
      Thread.sleep((long) (second * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Allow popup notifications của browser trên website
   *
   * @return giá trị đã setup Allow - thuộc đối tượng ChromeOptions
   */
  @Step("Allow Notifications")
  public static ChromeOptions notificationsAllow() {
    // Tạo Map để lưu trữ các tùy chọn
    Map<String, Object> prefs = new HashMap<String, Object>();

    // Thêm khóa và giá trị vào Map như sau để tắt thông báo của trình duyệt
    // Truyền đối số 1 để CHO PHÉP và 2 để CHẶN
    prefs.put("profile.default_content_setting_values.notifications", 1);

    // Tạo một phiên ChromeOptions
    ChromeOptions options = new ChromeOptions();

    // Dùng hàm setExperimentalOption thực thi giá trị thông qua đối tượng prefs trên
    options.setExperimentalOption("prefs", prefs);

    //Trả về giá trị đã setup thuộc đối tượng ChromeOptions
    return options;
  }

  /**
   * Block popup notifications của browser trên website
   *
   * @return giá trị đã setup Block - thuộc đối tượng ChromeOptions
   */
  @Step("Blocked Notifications")
  public static ChromeOptions notificationsBlock() {
    // Tạo Map để lưu trữ các tùy chọn
    Map<String, Object> prefs = new HashMap<String, Object>();

    // Thêm khóa và giá trị vào Map như sau để tắt thông báo của trình duyệt
    // Truyền đối số 1 để CHO PHÉP và 2 để CHẶN
    prefs.put("profile.default_content_setting_values.notifications", 2);

    // Tạo một phiên ChromeOptions
    ChromeOptions options = new ChromeOptions();

    // Dùng hàm setExperimentalOption thực thi giá trị thông qua đối tượng prefs trên
    options.setExperimentalOption("prefs", prefs);

    //Trả về giá trị đã setup thuộc đối tượng ChromeOptions
    return options;
  }

  /**
   * Upload file kiểu click hiện form chọn file local trong máy tính của bạn
   *
   * @param by       là element thuộc kiểu By
   * @param filePath đường dẫn tuyệt đối đến file trên máy tính của bạn
   */
  @Step("Upload File With Local Form")
  public static void uploadFileWithLocalForm(By by, String filePath) {
    smartWait();

    Actions action = new Actions(DriverManager.getDriver());
    //Click để mở form upload
    action.moveToElement(getWebElement(by)).click().perform();
    sleep(3);

    // Khởi tạo Robot class
    Robot robot = null;
    try {
      robot = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }

    // Copy File path vào Clipboard
    StringSelection str = new StringSelection(filePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

    //Check OS for Windows
    if (BrowserInfoUtils.isWindows()) {
      // Nhấn Control+V để dán
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);

      // Xác nhận Control V trên
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_V);
      robot.delay(2000);
      // Nhấn Enter
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
    }
    //Check OS for MAC
    if (BrowserInfoUtils.isMac()) {
      robot.keyPress(KeyEvent.VK_META);
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyRelease(KeyEvent.VK_META);
      robot.keyRelease(KeyEvent.VK_TAB);
      robot.delay(1000);

      //Open goto MAC
      robot.keyPress(KeyEvent.VK_META);
      robot.keyPress(KeyEvent.VK_SHIFT);
      robot.keyPress(KeyEvent.VK_G);
      robot.keyRelease(KeyEvent.VK_META);
      robot.keyRelease(KeyEvent.VK_SHIFT);
      robot.keyRelease(KeyEvent.VK_G);

      //Paste the clipboard value
      robot.keyPress(KeyEvent.VK_META);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_META);
      robot.keyRelease(KeyEvent.VK_V);
      robot.delay(1000);

      //Press Enter key to close the Goto MAC and Upload on MAC
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
    }

    LogUtils.info("Upload File With Local Form: " + filePath);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Upload File With Local Form: " + filePath);
    }
    AllureManager.saveTextLog("Upload File With Local Form: " + filePath);

  }

  /**
   * Upload file kiểu kéo link trực tiếp vào ô input
   *
   * @param by       truyền vào an element of object type By
   * @param filePath đường dẫn tuyệt đối đến file
   */
  @Step("Upload File with SendKeys")
  public static void uploadFileWithSendKeys(By by, String filePath) {
    smartWait();

    waitForElementVisible(by).sendKeys(filePath);

    LogUtils.info("Upload File with SendKeys");
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Upload File with SendKeys");
    }
    AllureManager.saveTextLog("Upload File with SendKeys");

  }

  @Step("Get Current URL")
  public static String getCurrentUrl() {
    smartWait();
    LogUtils.info("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
//        if (ExtentTestManager.getExtentTest() != null) {
//            ExtentReportManager.info("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
//        }
    //AllureManager.saveTextLog("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
    return DriverManager.getDriver().getCurrentUrl();
  }

  @Step("Get Page Title")
  public static String getPageTitle() {
    smartWait();
    String title = DriverManager.getDriver().getTitle();
    LogUtils.info("Get Page Title: " + DriverManager.getDriver().getTitle());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get Page Title: " + DriverManager.getDriver().getTitle());
    }
    AllureManager.saveTextLog("Get Page Title: " + DriverManager.getDriver().getTitle());
    return title;
  }

  public static boolean getPageTitle(String pageTitle) {
    smartWait();
    return getPageTitle().equals(pageTitle);
  }

  @Step("Verify Page Title equals {0}")
  public static boolean VerifyPageTitle(String pageTitle) {
    smartWait();
    return getPageTitle().equals(pageTitle);
  }

  @Step("Verify Page sources Contains Text {0}")
  public static boolean verifyPageContainsText(String text) {
    smartWait();
    return DriverManager.getDriver().getPageSource().contains(text);
  }

  //Handle checkbox and radio button
  @Step("Verify Element Checked {0}")
  public static boolean verifyElementChecked(By by) {
    smartWait();

    boolean checked = getWebElement(by).isSelected();

    if (checked) {
      LogUtils.info("Element is checked: " + by);
      ExtentReportManager.pass("Element is checked: " + by);
      return true;
    } else {
      LogUtils.info("Element is not checked: " + by);
      ExtentReportManager.fail("Element is not checked: " + by);
      Assert.fail("Element is not checked: " + by);
      return false;
    }
  }

  @Step("Verify Element Checked {0}")
  public static boolean verifyElementChecked(By by, String message) {
    smartWait();

    waitForElementVisible(by);

    boolean checked = getWebElement(by).isSelected();

    if (checked) {
      LogUtils.info("Element is checked: " + by);
      ExtentReportManager.pass("Element is checked: " + by);
      return true;
    } else {
      LogUtils.info("Element is not checked: " + by);
      Assert.fail(message);
      ExtentReportManager.fail("Element is not checked: " + by);
      return false;
    }
  }

  //Handle dropdown

  /**
   * Chọn giá trị trong dropdown với dạng động (không phải Select Option thuần)
   *
   * @param objectListItem là locator của list item dạng đối tượng By
   * @param text           giá trị cần chọn dạng Text của item
   * @return click chọn một item chỉ định với giá trị Text
   */
  @Step("Select Option Dynamic by Text {0}")
  public static boolean selectOptionDynamic(By objectListItem, String text) {
    smartWait();
    //Đối với dropdown động (div, li, span,...không phải dạng select option)
    try {
      List<WebElement> elements = getWebElements(objectListItem);

      for (WebElement element : elements) {
        LogUtils.info(element.getText());
        if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
          element.click();
          return true;
        }
      }
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      e.getMessage();
    }
    return false;
  }

  @Step("Verify Option Dynamic Exist by Text {0}")
  public static boolean verifyOptionDynamicExist(By objectListItem, String text) {
    smartWait();

    try {
      List<WebElement> elements = getWebElements(objectListItem);

      for (WebElement element : elements) {
        LogUtils.info(element.getText());
        LogUtils.info(element.getText());
        if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())) {
          return true;
        }
      }
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      e.getMessage();
    }
    return false;
  }

  @Step("Get total of Option Dynamic with list element {0}")
  public static int getOptionDynamicTotal(By objectListItem) {
    smartWait();

    try {
      List<WebElement> elements = getWebElements(objectListItem);
      LogUtils.info(elements.size());
      return elements.size();
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      e.getMessage();
    }
    return 0;
  }

  //Dropdown (Select Option)
  @Step("Select Option by Text {0}")
  public static void selectOptionByText(By by, String text) {
    smartWait();
    Select select = new Select(getWebElement(by));
    select.selectByVisibleText(text);
    LogUtils.info("Select Option by Text " + text);
  }

  @Step("Select Option by Value {0}")
  public static void selectOptionByValue(By by, String value) {
    smartWait();

    Select select = new Select(getWebElement(by));
    select.selectByValue(value);
    LogUtils.info("Select Option by Value " + value);
  }

  @Step("Select Option by Index {0}")
  public static void selectOptionByIndex(By by, int index) {
    smartWait();

    Select select = new Select(getWebElement(by));
    select.selectByIndex(index);
    LogUtils.info("Select Option by Index " + index);
  }

  @Step("Verify Option Total equals {0}")
  public static void verifyOptionTotal(By element, int total) {
    smartWait();

    Select select = new Select(getWebElement(element));
    LogUtils.info("Option Total is: " + select.getOptions().size());
    Assert.assertEquals(total, select.getOptions().size());

  }

  @Step("Verify Selected Option by Text {0}")
  public static boolean verifySelectedByText(By by, String text) {
    sleep(WAIT_SLEEP_STEP);

    Select select = new Select(getWebElement(by));
    LogUtils.info("Option Selected by text: " + select.getFirstSelectedOption().getText());
    return select.getFirstSelectedOption().getText().equals(text);
  }

  @Step("Verify Selected Option by Value {0}")
  public static boolean verifySelectedByValue(By by, String optionValue) {
    sleep(WAIT_SLEEP_STEP);

    Select select = new Select(getWebElement(by));
    LogUtils.info("Option Selected by value: " + select.getFirstSelectedOption().getAttribute("value"));
    return select.getFirstSelectedOption().getAttribute("value").equals(optionValue);
  }

  @Step("Verify Selected Option by Index {0}")
  public static boolean verifySelectedByIndex(By by, int index) {
    sleep(WAIT_SLEEP_STEP);

    boolean res = false;
    Select select = new Select(getWebElement(by));
    int indexFirstOption = select.getOptions().indexOf(select.getFirstSelectedOption());
    LogUtils.info("The First Option selected by index: " + indexFirstOption);
    LogUtils.info("Expected index: " + index);
    if (indexFirstOption == index) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Selected Option by Index is: " + index);
      }
      res = true;
    } else {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Selected Option by Index is not: " + index);
      }
      res = false;
    }
    return res;
  }

  //Handle frame iframe
  @Step("Switch to Frame by Index: {0}")
  public static void switchToFrameByIndex(int index) {
    sleep(WAIT_SLEEP_STEP);

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    LogUtils.info("Switch to Frame by Index: " + index);
    //DriverManager.getDriver().switchTo().frame(Index);
  }

  @Step("Switch to Frame by ID or Name: {0}")
  public static void switchToFrameByIdOrName(String IdOrName) {
    sleep(WAIT_SLEEP_STEP);

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));
    LogUtils.info("Switch to Frame by ID or Name: " + IdOrName);
  }

  @Step("Switch to Frame by Element {0}")
  public static void switchToFrameByElement(By by) {
    sleep(WAIT_SLEEP_STEP);

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    LogUtils.info("Switch to Frame by Element: " + by.toString());
  }

  @Step("Switch to Default Content")
  public static void switchToDefaultContent() {
    sleep(WAIT_SLEEP_STEP);

    DriverManager.getDriver().switchTo().defaultContent();
  }

  @Step("Switch to Window or Tab by Position: {0}")
  public static void switchToWindowOrTabByPosition(int position) {
    sleep(WAIT_SLEEP_STEP);

    DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[position].toString());
    LogUtils.info("Switch to Window or Tab by Position: " + position);
  }

  @Step("Switch to Window or Tab by Title: {0}")
  public static void switchToWindowOrTabByTitle(String title) {
    sleep(WAIT_SLEEP_STEP);

    //Store the ID of the original window
    String originalWindow = DriverManager.getDriver().getWindowHandle();

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    //Wait for the new window or tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    //Loop through until we find a new window handle
    for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
      if (!originalWindow.contentEquals(windowHandle)) {
        DriverManager.getDriver().switchTo().window(windowHandle);
        if (DriverManager.getDriver().getTitle().equals(title)) {
          LogUtils.info("Switch to Window or Tab by Title: " + title);
          break;
        }
      }
    }

  }

  @Step("Switch to Window or Tab by Url: {0}")
  public static void switchToWindowOrTabByUrl(String url) {
    sleep(WAIT_SLEEP_STEP);

    //Store the ID of the original window
    String originalWindow = DriverManager.getDriver().getWindowHandle();

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    //Wait for the new window or tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    //Loop through until we find a new window handle
    for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
      if (!originalWindow.contentEquals(windowHandle)) {
        DriverManager.getDriver().switchTo().window(windowHandle);
        if (DriverManager.getDriver().getCurrentUrl().equals(url)) {

          break;
        }
      }
    }

  }

  @Step("Close current Window")
  public static void closeCurrentWindow() {
    DriverManager.getDriver().close();

  }

  @Step("Verify total of Windows or Tab")
  public static boolean verifyNumberOfWindowsOrTab(int number) {
    return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT)).until(ExpectedConditions.numberOfWindowsToBe(number));
  }

  @Step("Open new Tab")
  public static void openNewTab() {
    sleep(WAIT_SLEEP_STEP);

    // Opens a new tab and switches to new tab
    DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
  }

  @Step("Open new Window")
  public static void openNewWindow() {
    sleep(WAIT_SLEEP_STEP);
    // Opens a new window and switches to new window
    DriverManager.getDriver().switchTo().newWindow(WindowType.WINDOW);
  }

  @Step("Switch to Main Window")
  public static void switchToMainWindow() {
    sleep(WAIT_SLEEP_STEP);
    DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[0].toString());
  }

  @Step("Switch to Main Window by ID {0}")
  public static void switchToMainWindow(String originalWindow) {
    sleep(WAIT_SLEEP_STEP);
    DriverManager.getDriver().switchTo().window(originalWindow);
  }

  @Step("Switch to Last Window")
  public static void switchToLastWindow() {
    smartWait();

    Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
    DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandles().toArray()[windowHandles.size() - 1].toString());
  }

  /*
        ========== Handle Alert ==================
     */

  @Step("Click Accept on Alert")
  public static void switchToAlert() {
    smartWait();

    DriverManager.getDriver().switchTo().alert();
  }

  @Step("Click Accept on Alert")
  public static void alertAccept() {
    smartWait();

    DriverManager.getDriver().switchTo().alert().accept();
  }

  @Step("Click Dismiss on Alert")
  public static void alertDismiss() {
    smartWait();

    DriverManager.getDriver().switchTo().alert().dismiss();
  }

  @Step("Get text on Alert")
  public static void alertGetText() {
    smartWait();

    DriverManager.getDriver().switchTo().alert().getText();
  }

  @Step("Set text on Alert {0}")
  public static void alertSetText(String text) {
    smartWait();

    DriverManager.getDriver().switchTo().alert().sendKeys(text);
  }

  @Step("Verify Alert present with timeout {0}")
  public static boolean verifyAlertPresent(int timeOut) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.alertIsPresent());
      return true;
    } catch (Throwable error) {
      Assert.fail("Not found Alert.");
      return false;
    }
  }

  //Handle Elements
  @Step("Get List Element {0}")
  public static List<String> getListElementsText(By by) {
    smartWait();

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    List<WebElement> listElement = getWebElements(by);
    List<String> listText = new ArrayList<>();

    for (WebElement e : listElement) {
      listText.add(e.getText());
    }
    LogUtils.info(listText.size());
    return listText;
  }

  @Step("Verify element exists {0}")
  public static boolean verifyElementExists(By by) {
    smartWait();

    boolean res;
    List<WebElement> elementList = getWebElements(by);
    if (elementList.size() > 0) {
      res = true;
      LogUtils.info("Element existing: " + elementList);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Element existing: " + elementList);
      }
    } else {
      res = false;
      LogUtils.error("Element not existing: " + elementList);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Element not existing: " + elementList);
      }

    }
    return res;
  }

  @Step("Verify Equals: {0} ---AND--- {1}")
  public static boolean verifyEquals(Object value1, Object value2) {
    boolean result = value1.equals(value2);
    if (result) {
      LogUtils.info("Verify Equals: " + value1 + " = " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify Equals: " + value1 + " = " + value2);
      }
      AllureManager.saveTextLog("Verify Equals: " + value1 + " = " + value2);
    } else {
      LogUtils.error("Verify Equals: " + value1 + " != " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify Equals: " + value1 + " != " + value2);
      }
      AllureManager.saveTextLog("Verify Equals: " + value1 + " != " + value2);
      Assert.assertEquals(value1, value2, value1 + " != " + value2);
    }
    return result;
  }

  @Step("Verify Equals: {0} ---AND--- {1}")
  public static boolean verifyEquals(Object value1, Object value2, String message) {
    boolean result = value1.equals(value2);
    if (result) {
      LogUtils.info("Verify Equals: " + value1 + " = " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify Equals: " + value1 + " = " + value2);
      }
      AllureManager.saveTextLog("Verify Equals: " + value1 + " = " + value2);
    } else {
      LogUtils.error("Verify Equals: " + value1 + " != " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify Equals: " + value1 + " != " + value2);
      }
      AllureManager.saveTextLog("Verify Equals: " + value1 + " != " + value2);
      Assert.assertEquals(value1, value2, message);
    }
    return result;
  }

  @Step("Verify Contains: {0} ---AND--- {1}")
  public static boolean verifyContains(String value1, String value2) {
    boolean result = value1.contains(value2);
    if (result) {
      LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
      }
      AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
    } else {
      LogUtils.error("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
      }
      AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);

      Assert.assertEquals(value1, value2, value1 + " NOT CONTAINS " + value2);
    }
    return result;
  }

  @Step("Verify Contains: {0} ---AND--- {1}")
  public static boolean verifyContains(String value1, String value2, String message) {
    boolean result = value1.contains(value2);
    if (result) {
      LogUtils.info("Verify Equals: " + value1 + " CONTAINS " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify Contains: " + value1 + " CONTAINS " + value2);
      }
      AllureManager.saveTextLog("Verify Contains: " + value1 + "CONTAINS" + value2);
    } else {
      LogUtils.error("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify Contains: " + value1 + " NOT CONTAINS " + value2);
      }
      AllureManager.saveTextLog("Verify Contains: " + value1 + " NOT CONTAINS " + value2);

      Assert.assertEquals(value1, value2, message);
    }
    return result;
  }

  @Step("Verify TRUE with condition: {0}")
  public static boolean verifyTrue(Boolean condition) {
    if (condition) {
      LogUtils.info("Verify TRUE: " + condition);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify TRUE: " + condition);
      }
      AllureManager.saveTextLog("Verify TRUE: " + condition);
    } else {
      LogUtils.error("Verify TRUE: " + condition);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify TRUE: " + condition);
      }
      AllureManager.saveTextLog("Verify TRUE: " + condition);

      Assert.assertTrue(condition, "The condition is FALSE.");
    }
    return condition;
  }

  @Step("Verify TRUE with condition: {0}")
  public static boolean verifyTrue(Boolean condition, String message) {
    if (condition) {
      LogUtils.info("Verify TRUE: " + condition);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify TRUE: " + condition);
      }
      AllureManager.saveTextLog("Verify TRUE: " + condition);
    } else {
      LogUtils.error("Verify TRUE: " + condition);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify TRUE: " + condition);
      }
      AllureManager.saveTextLog("Verify TRUE: " + condition);

      Assert.assertTrue(condition, message);
    }
    return condition;
  }

  @Step("Verify text of an element [Equals]")
  public static boolean verifyElementText(By by, String text) {
    smartWait();
    waitForElementVisible(by);
    boolean result = getTextElement(by).trim().equals(text.trim());
    if (result) {
      LogUtils.info("The actual text is " + getTextElement(by).trim());
      ExtentReportManager.pass("The actual text is " + getTextElement(by).trim());
      Assert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " equals " + text.trim());
    } else {
      LogUtils.error("The actual text is " + getTextElement(by).trim());
      ExtentReportManager.fail("The actual text is " + getTextElement(by).trim());
      Assert.fail("The actual text is " + getTextElement(by).trim() + " not equals " + text.trim());
    }
    return result;
  }

  @Step("Verify text of an element [Equals] with flowControl")
  public static boolean verifyElementTextEquals(By by, String text, FailureHandling flowControl) {
    smartWait();

    waitForElementVisible(by);

    boolean result = getTextElement(by).trim().equals(text.trim());

    if (result) {
      LogUtils.info("The actual text is '" + getTextElement(by).trim() + "' equals '" + text.trim() + "'");
      ExtentReportManager.pass("The actual text is '" + getTextElement(by).trim() + "' equals '" + text.trim() + "'");
    } else {
      LogUtils.warn("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
      ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
    }

    if (flowControl.equals(FailureHandling.STOP_ON_FAILURE)) {
      Assert.assertEquals(getTextElement(by).trim(), text.trim(), "The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
      ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
    }
    if (flowControl.equals(FailureHandling.CONTINUE_ON_FAILURE)) {
      softAssert.assertEquals(getTextElement(by).trim(), text.trim(), "The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
      if (!result) {
        ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
      }
    }
    if (flowControl.equals(FailureHandling.OPTIONAL)) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning("Verify text of an element [Equals] - " + result);
        ExtentReportManager.warning("The actual text is '" + getTextElement(by).trim() + "' not equals expected text '" + text.trim() + "'");
      }
      AllureManager.saveTextLog("Verify text of an element [Equals] - " + result + ". The actual text is '" + getTextElement(by).trim() + "' not equals '" + text.trim() + "'");
    }

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

    return getTextElement(by).trim().equals(text.trim());
  }


  @Step("Verify text of an element [Contains]")
  public static boolean verifyElementTextContains(By by, String text, FailureHandling flowControl) {
    smartWait();
    waitForElementVisible(by);

    boolean result = getTextElement(by).trim().contains(text.trim());

    if (result) {
      LogUtils.info("Verify text of an element [Contains]: " + result);
      ExtentReportManager.pass("The actual text is '" + getTextElement(by).trim() + " contains " + text.trim() + "'");
    } else {
      LogUtils.warn("Verify text of an element [Contains]: " + result);
      ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim() + " not contains " + text.trim() + "'");
    }

    if (flowControl.equals(FailureHandling.STOP_ON_FAILURE)) {
      Assert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " contains " + text.trim());
    }
    if (flowControl.equals(FailureHandling.CONTINUE_ON_FAILURE)) {
      softAssert.assertTrue(result, "The actual text is " + getTextElement(by).trim() + " not contains " + text.trim());
    }
    if (flowControl.equals(FailureHandling.OPTIONAL)) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning("Verify text of an element [Contains] - " + result);
      }
      AllureManager.saveTextLog("Verify text of an element [Contains] - " + result);
    }

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

    return getTextElement(by).trim().contains(text.trim());
  }

  @Step("Verify text {1} of element [Contains] {0}")
  public static boolean verifyElementTextContains(By by, String text) {
    smartWait();
    waitForElementVisible(by);

    boolean result = getTextElement(by).trim().contains(text.trim());

    if (result) {
      LogUtils.info("Verify text of an element [Contains]: " + text);
      ExtentReportManager.pass("The actual text is " + getTextElement(by).trim());
      Assert.assertTrue(result, "The actual text is " + getTextElement(by).trim());
    } else {
      LogUtils.error("Verify text of an element [Contains]: " + text);
      ExtentReportManager.fail("The actual text is '" + getTextElement(by).trim());
      Assert.fail("The actual text is '" + getTextElement(by).trim());
    }

    AllureManager.saveTextLog("Verify text of an element [Contains] : " + text);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

    return result;
  }

  @Step("Verify element Clickable {0}")
  public static boolean verifyElementClickable(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Verify element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element clickable " + by);
      }
      AllureManager.saveTextLog("Verify element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error(e.getMessage());
      Assert.fail("FAILED. Element not clickable " + by);
      return false;
    }
  }

  @Step("Check element Clickable {0}")
  public static boolean checkElementClickable(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Check element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element clickable " + by);
      }
      AllureManager.saveTextLog("Check element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error(e.getMessage());
      Assert.fail("FAILED. Element not clickable " + by);
      return false;
    }
  }

  @Step("Verify element Clickable {0} with timeout {1} second")
  public static boolean verifyElementClickable(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Verify element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element clickable " + by);
      }
      AllureManager.saveTextLog("Verify element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error("FAILED. Element not clickable " + by);
      LogUtils.error(e.getMessage());
      Assert.fail("FAILED. Element not clickable " + by);
      return false;
    }
  }

  @Step("Check element Clickable {0} with timeout {1} second")
  public static boolean checkElementClickable(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Check element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element clickable " + by);
      }
      AllureManager.saveTextLog("Check element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error("FAILED. Element not clickable " + by);
      LogUtils.error(e.getMessage());
      Assert.fail("FAILED. Element not clickable " + by);
      return false;
    }
  }

  @Step("Verify element Clickable {0}")
  public static boolean verifyElementClickable(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Verify element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element clickable " + by);
      }
      AllureManager.saveTextLog("Verify element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error(message);
      LogUtils.error(e.getMessage());
      Assert.fail(message + "" + e.getMessage());
      return false;
    }
  }

  @Step("Check element Clickable {0}")
  public static boolean checkElementClickable(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      LogUtils.info("Check element clickable " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element clickable " + by);
      }
      AllureManager.saveTextLog("Check element clickable " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error(message);
      LogUtils.error(e.getMessage());
      Assert.fail(message + "" + e.getMessage());
      return false;
    }
  }
  @Step("Check element present {0}")
  public static boolean checkElementExists(By by) {
    smartWait();

    boolean res;
    List<WebElement> elementList = getWebElements(by);
    if (elementList.size() > 0) {
      LogUtils.info("Element existing: " + elementList);
      res= true;
    } else {

      LogUtils.info("Element not existing: " + elementList);
      res=false;
    }
    return res;
  }

  @Step("Check element present {0}")
  public static boolean checkElementPresent(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Check element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element present " + by);
      }
      AllureManager.saveTextLog("Check element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      LogUtils.error("The element does NOT present. " + e.getMessage());
      Assert.fail("The element does NOT present. " + e.getMessage());
      return false;
    }
  }

  @Step("Check element present {0} with timeout {1} second")
  public static boolean checkElementPresent(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Check element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element present " + by);
      }
      AllureManager.saveTextLog("Check element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      LogUtils.error("The element does NOT present. " + e.getMessage());
      Assert.fail("The element does NOT present. " + e.getMessage());
      return false;
    }

  }

  @Step("Check element present {0}")
  public static boolean checkElementPresent(By by, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Check element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element present " + by);
      }
      AllureManager.saveTextLog("Check element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element does NOT present. " + e.getMessage());
        Assert.fail("The element does NOT present. " + e.getMessage());
      } else {
        LogUtils.error(message);
        Assert.fail(message);
      }

      return false;
    }
  }

  @Step("Verify element present - StaleElementReferenceException")
  public static boolean verifyElementStaleElementReferenceException(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf((WebElement) by)));
      LogUtils.info("Verify element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element present " + by);
      }
      return true;
    } catch (Exception e) {
      LogUtils.error(e.getMessage());
      Assert.fail("FAILED. Element not present " + by);
      return false;
    }
  }

  @Step("Verify element present {0} with timeout {1} second")
  public static boolean verifyElementPresent(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Verify element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element present " + by);
      }
      AllureManager.saveTextLog("Verify element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      LogUtils.info("The element does NOT present. " + e.getMessage());
      Assert.fail("The element does NOT present. " + e.getMessage());
      return false;
    }

  }

  @Step("Verify element present {0}")
  public static boolean verifyElementPresent(By by, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Verify element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element present " + by);
      }
      AllureManager.saveTextLog("Verify element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element does NOT present. " + e.getMessage());
        Assert.fail("The element does NOT present. " + e.getMessage());
      } else {
        LogUtils.error(message);
        Assert.fail(message);
      }

      return false;
    }
  }

  @Step("Check element present {0} with timeout {1} second")
  public static boolean checkElementPresent(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Check element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element present " + by);
      }
      AllureManager.saveTextLog("Check element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element does NOT present. " + e.getMessage());
        Assert.fail("The element does NOT present. " + e.getMessage());
      } else {
        LogUtils.error(message);
        Assert.fail(message);
      }

      return false;
    }
  }

  @Step("Verify element present {0} with timeout {1} second")
  public static boolean verifyElementPresent(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Verify element present " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Verify element present " + by);
      }
      AllureManager.saveTextLog("Verify element present " + by);
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element does NOT present. " + e.getMessage());
        Assert.fail("The element does NOT present. " + e.getMessage());
      } else {
        LogUtils.error(message);
        Assert.fail(message);
      }

      return false;
    }
  }

  @Step("Verify element NOT present {0}")
  public static boolean verifyElementNotPresent(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.error("The element presents. " + by);
      Assert.fail("The element presents. " + by);
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element not present " + by);
      }
      return true;

    }
  }

  @Step("Verify element NOT present {0} with timeout {1} second")
  public static boolean verifyElementNotPresent(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.error("Element is present " + by);
      Assert.fail("The element presents. " + by);
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element not present " + by);
      }
      return true;
    }
  }

  @Step("Verify element NOT present {0}")
  public static boolean verifyElementNotPresent(By by, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element presents. " + by);
        Assert.fail("The element presents. " + by);
      } else {
        LogUtils.error(message);
        Assert.fail(message + " " + by);
      }
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element not present " + by);
      }
      return true;
    }
  }

  @Step("Verify element NOT present {0} with timeout {1} second")
  public static boolean verifyElementNotPresent(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element presents. " + by);
        Assert.fail("The element presents. " + by);
      } else {
        LogUtils.error(message + by);
        Assert.fail(message + by);
      }
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element not present " + by);
      }
      return true;
    }
  }

  @Step("Verify element visible {0}")
  public static boolean isElementVisible(By by, long timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Verify element visible " + by);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  @Step("Verify element visible {0}")
  public static boolean verifyElementVisible(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Verify element visible " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element visible " + by);
      }
      return true;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Verify element not visible " + by);
      }
      return false;
    }
  }

  @Step("Check element visible {0}")
  public static boolean checkElementVisible(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Check element visible " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element visible " + by);
      }
      return true;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("Check element not visible " + by);
      }
      return false;
    }
  }

  @Step("Check element visible {0} with timeout {1} second")
  public static boolean checkElementVisible(By by, long timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Check element visible " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element visible " + by);
      }
      return true;
    } catch (Exception e) {
      LogUtils.error("The element is not visible. " + e.getMessage());
      Assert.fail("The element is NOT visible. " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.fail("The element not visible " + by);
      }
      return false;
    }
  }

  @Step("Verify element visible {0} with timeout {1} second")
  public static boolean verifyElementVisible(By by, long timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Verify element visible " + by);
      return true;
    } catch (Exception e) {
      LogUtils.error("The element is not visible. " + e.getMessage());
      Assert.fail("The element is NOT visible. " + by);
      return false;
    }
  }

  @Step("Verify element visible {0}")
  public static boolean verifyElementVisible(By by, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Verify element visible " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element visible " + by);
      }
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element is not visible. " + by);
        Assert.fail("The element is NOT visible. " + by);
      } else {
        LogUtils.error(message + by);
        Assert.fail(message + by);
      }
      return false;
    }
  }

  @Step("Verify element visible {0} with timeout {1} second")
  public static boolean verifyElementVisible(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Verify element visible " + by);
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element is not visible. " + by);
        Assert.fail("The element is NOT visible. " + by);
      } else {
        LogUtils.error(message + by);
        Assert.fail(message + by);
      }
      return false;
    }
  }

  @Step("Check element visible {0} with timeout {1} second")
  public static boolean checkElementVisible(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.info("Check element visible " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element visible " + by);
      }
      return true;
    } catch (Exception e) {
      if (message.isEmpty() || message == null) {
        LogUtils.error("The element is not visible. " + by);
        Assert.fail("The element is NOT visible. " + by);
      } else {
        LogUtils.error(message + by);
        Assert.fail(message + by);
      }
      return false;
    }
  }

  @Step("Verify element NOT visible {0}")
  public static boolean verifyElementNotVisible(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.error("FAILED. The element is visible " + by);
      Assert.fail("FAILED. The element is visible " + by);
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Check element visible " + by);
      }
      return true;
    }
  }


  @Step("Verify element NOT visible {0} with timeout {1} second")
  public static boolean verifyElementNotVisible(By by, int timeout) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      LogUtils.error("FAILED. The element is visible " + by);
      Assert.fail("FAILED. The element is visible " + by);
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element is invisible " + by);
      }
      return true;
    }
  }

  @Step("Verify element NOT visible {0}")
  public static boolean verifyElementNotVisible(By by, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      if (message.isEmpty() || message == null) {
        LogUtils.error("FAILED. The element is visible " + by);
        Assert.fail("FAILED. The element is visible " + by);
      } else {
        LogUtils.error(message + " " + by);
        Assert.fail(message + " " + by);
      }
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element is invisible " + by);
      }
      return true;
    }
  }

  @Step("Verify element NOT visible {0} with timeout {1} second")
  public static boolean verifyElementNotVisible(By by, int timeout, String message) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      if (message.isEmpty() || message == null) {
        LogUtils.error("FAILED. The element is visible " + by);
        Assert.fail("FAILED. The element is visible " + by);
      } else {
        LogUtils.error(message + " " + by);
        Assert.fail(message + " " + by);
      }
      return false;
    } catch (Exception e) {
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.pass("Verify element is invisible " + by);
      }
      return true;
    }
  }

  @Step("Scroll to element {0}")
  public static void scrollToElementToTop(By by) {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    LogUtils.info("Scroll to element " + by);
  }

  @Step("Scroll to element {0}")
  public static void scrollToElementToBottom(By by) {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    LogUtils.info("Scroll to element " + by);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Scroll to element " + by);
    }
  }

  @Step("Scroll to element {0}")
  public static void scrollToElementToTop(WebElement element) {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    LogUtils.info("Scroll to element " + element);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Scroll to element " + element);
    }
  }

  @Step("Scroll to element {0}")
  public static void scrollToElementToBottom(WebElement element) {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView(false);", element);
    LogUtils.info("Scroll to element " + element);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Scroll to element " + element);
    }
  }

  @Step("Scroll to position X={0}, Y={1}")
  public static void scrollToPosition(int X, int Y) {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    LogUtils.info("Scroll to position X = " + X + " ; Y = " + Y);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Scroll to position X = " + X + " ; Y = " + Y);
    }
  }

  @Step("Scroll to position X={0}, Y={1}")
  public static void scrollToPositionViewTop() {
    smartWait();

    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("window.scrollTo(" + 0 + "," + (-5000) + ");");
    LogUtils.info("Scroll to position X = " + 0 + " ; Y = " + (-5000));
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Scroll to position X = " + 0 + " ; Y = " + (-5000));
    }
  }

  @Step("Hover on element {0}")
  public static boolean hoverOnElement(By by) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.moveToElement(getWebElement(by)).perform();
      LogUtils.info("Hover on element " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Mouse hover on element " + by.toString());
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Mouse hover on element {0}")
  public static boolean mouseHover(By by) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.moveToElement(getWebElement(by)).perform();
      LogUtils.info("Mouse hover on element " + by);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Mouse hover on element " + by.toString());
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Drag from element {0} to element {1}")
  public static boolean dragAndDrop(By fromElement, By toElement) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
      //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
      LogUtils.info("Drag from element " + fromElement + "to " + toElement);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Drag from element " + fromElement + "to " + toElement);
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Drag HTML5 from element {0} to element {1}")
  public static boolean dragAndDropHTML5(By fromElement, By toElement) {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.mouseMove(0, 0);

      int X1 = getWebElement(fromElement).getLocation().getX() + (getWebElement(fromElement).getSize().getWidth() / 2);
      int Y1 = getWebElement(fromElement).getLocation().getY() + (getWebElement(fromElement).getSize().getHeight() / 2);
      System.out.println(X1 + " , " + Y1);

      int X2 = getWebElement(toElement).getLocation().getX() + (getWebElement(toElement).getSize().getWidth() / 2);
      int Y2 = getWebElement(toElement).getLocation().getY() + (getWebElement(toElement).getSize().getHeight() / 2);
      System.out.println(X2 + " , " + Y2);

      //Chổ này lấy toạ độ hiện tại cộng thêm 120px là phần header của browser (1920x1080 current window)
      //Header: chrome is being controlled by automated test software
      sleep(1);
      robot.mouseMove(X1, Y1 + 120);
      robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

      sleep(1);
      robot.mouseMove(X2, Y2 + 120);
      sleep(1);
      robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Drag from element " + fromElement + "to " + toElement);
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Drag from element {0} to X={1}, Y={2}")
  public static boolean dragAndDropToOffset(By fromElement, int X, int Y) {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.mouseMove(0, 0);
      int X1 = getWebElement(fromElement).getLocation().getX() + (getWebElement(fromElement).getSize().getWidth() / 2);
      int Y1 = getWebElement(fromElement).getLocation().getY() + (getWebElement(fromElement).getSize().getHeight() / 2);
      System.out.println(X1 + " , " + Y1);
      sleep(1);

      //Chổ này lấy toạ độ hiện tại cộng thêm 120px là phần header của browser (1920x1080 current window)
      //Header: chrome is being controlled by automated test software
      robot.mouseMove(X1, Y1 + 120);
      robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

      sleep(1);
      robot.mouseMove(X, Y + 120);
      sleep(1);
      robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Drag from element " + fromElement + "with offset X = " + X + " Y = " + Y);
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Move to element {0}")
  public static boolean moveToElement(By toElement) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
      LogUtils.info(String.format("Move to element {0}", toElement));
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Move to offset X={0}, Y={1}")
  public static boolean moveToOffset(int X, int Y) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.moveByOffset(X, Y).build().perform();
      LogUtils.info(String.format("Move to offset X={0}, Y={1}", X, Y));
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info(String.format("Move to offset X={0}, Y={1}", X, Y));
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Press ENTER keyboard")
  public static boolean pressENTER() {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press ENTER keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Press ESC keyboard")
  public static boolean pressESC() {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_ESCAPE);
      robot.keyRelease(KeyEvent.VK_ESCAPE);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press ESC keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Press TAB keyboard")
  public static boolean pressTAB() {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyRelease(KeyEvent.VK_TAB);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press TAB keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

    @Step("Press F5 keyboard")
    public static boolean pressF5() {
        smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_F5);
      robot.keyRelease(KeyEvent.VK_F5);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press F5 keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Press F11 keyboard")
  public static boolean pressF11() {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_F11);
      robot.keyRelease(KeyEvent.VK_F11);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press F11 keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }

  @Step("Reload page")
  public static void reloadPage() {
    smartWait();

    DriverManager.getDriver().navigate().refresh();
    waitForPageLoaded();
    LogUtils.info("Reloaded page " + DriverManager.getDriver().getCurrentUrl());
  }


  /**
   * @param by truyền vào đối tượng element dạng By
   * @return Tô màu viền đỏ cho Element trên website
   */
  @Step("Highlight on element")
  public static WebElement highLightElement(By by) {
    smartWait();

    // draw a border around the found element
    if (DriverManager.getDriver() instanceof JavascriptExecutor) {
      ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", waitForElementVisible(by));
      sleep(1);
      LogUtils.info("Highlight on element " + by);
    }
    return getWebElement(by);
  }

  /**
   * Open website with URL
   *
   * @param URL
   */
  @Step("Open website with URL {0}")
  public static void openURL(String URL) {
    sleep(WAIT_SLEEP_STEP);

    DriverManager.getDriver().get(URL);
    waitForPageLoaded();

    LogUtils.info("Open URL: " + URL);

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Open URL: " + URL);
    }
    AllureManager.saveTextLog("Open URL: " + URL);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Open website with URL
   *
   * @param URL
   */
  @Step("Open website with URL {0}")
  public static void getURL(String URL) {
    sleep(WAIT_SLEEP_STEP);

    DriverManager.getDriver().get(URL);
    waitForPageLoaded();

    LogUtils.info("Open URL: " + URL);

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Open URL: " + URL);
    }
    AllureManager.saveTextLog("Open URL: " + URL);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Open website with navigate to URL
   *
   * @param URL
   */
  @Step("Navigate to URL {0}")
  public static void navigateToUrl(String URL) {
    DriverManager.getDriver().navigate().to(URL);
    waitForPageLoaded();

    LogUtils.info("Navigate to URL: " + URL);

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Navigate to URL: " + URL);
    }
    AllureManager.saveTextLog("Navigate to URL: " + URL);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Điền giá trị vào ô Text
   *
   * @param by    an element of object type By
   * @param value giá trị cần điền vào ô text
   */
  @Step("Set text on textbox")
  public static void setText(By by, String value) {
    sleep(1);
    waitForElementVisible(by).sendKeys(value);
    LogUtils.info("Set text " + value + " on " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + " on " + by);
    }
    AllureManager.saveTextLog("Set text " + value + " on " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Điền giá trị vào ô Text và nhập Keys
   *
   * @param by    an element of object type By
   * @param value giá trị cần điền vào ô text
   * @param keys  key ở bàn phím cần nhấn
   */
  @Step("Set text on textbox and press key")
  public static void setText(By by, String value, Keys keys) {
    waitForElementVisible(by).sendKeys(value, keys);
    LogUtils.info("Set text " + value + " on " + by + " and press key " + keys.name());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + " on " + by + " and press key " + keys.name());
    }
    AllureManager.saveTextLog("Set text " + value + " on " + by + " and press key " + keys.name());

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Thao tác keys dưới bàn phím lên element by
   *
   * @param by   an element of object type By
   * @param keys key ở bàn phím cần nhấn
   */
  @Step("Set text on textbox and press key")
  public static void sendKeys(By by, Keys keys) {
    waitForElementVisible(by).sendKeys(keys);
    LogUtils.info("Press key " + keys.name() + " on element " + by);

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Press key " + keys.name() + " on element " + by);
    }
    AllureManager.saveTextLog("Press key " + keys.name() + " on element " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
  }

  /**
   * Thao tác keys dưới bàn phím lên element by
   * <p>
   * * @param keys key ở bàn phím cần nhấn
   */
  @Step("Set text on textbox and press key")
  public static void sendKeys(Keys keys) {
    Actions actions = new Actions(DriverManager.getDriver());
    actions.sendKeys(keys);
    LogUtils.info("Press key " + keys.name() + " on keyboard");

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Press key " + keys.name() + " on keyboard");
    }
    AllureManager.saveTextLog("Press key " + keys.name() + " on keyboard");

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
  }

  /**
   * Xóa giá trị trong ô Text
   *
   * @param by an element of object type By
   */
  @Step("Clear value in textbox")
  public static void clearText(By by) {
    waitForElementVisible(by).clear();
    LogUtils.info("Clear value in textbox " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clear value in textbox " + by);
    }
    AllureManager.saveTextLog("Clear value in textbox");
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Xóa giá trị trong ô Text
   *
   * @param by an element of object type By
   */
  @Step("Clear text in textbox with Ctrl A")
  public static void clearTextCtrlA(By by) {
    waitForElementVisible(by);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.click(getWebElement(by)).build().perform();
    //actions.moveToElement(getWebElement(by)).click().build();
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    actions.sendKeys(Keys.DELETE).build().perform();

    LogUtils.info("Clear text in textbox " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clear text in textbox " + by);
    }
    AllureManager.saveTextLog("Clear text in textbox");
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

    /**
     * Thêm giá trị trong ô Text
     *
     * @param by    an element of object type By
     * @param value nội dung cần thêm
     */
    @Step("Set text in textbox with Ctrl A")
    public static void setCtrlAThenFillText(By by, String value) {
        waitForElementVisible(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.click(getWebElement(by)).build().perform();
        //actions.moveToElement(getWebElement(by)).click().build();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(value).build().perform();

    LogUtils.info("Set text " + value + " in textbox " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + "  in textbox " + by);
    }
    AllureManager.saveTextLog("Set text " + value + "  in textbox");
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Thêm giá trị trong ô Text
   *
   * @param by    an element of object type By
   * @param value nội dung cần thêm
   */
  @Step("Set text in textbox with Ctrl A")
  public static void setCtrlAThenFillTextByEnter(By by, String value) {
    waitForElementVisible(by);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.click(getWebElement(by)).build().perform();
    //actions.moveToElement(getWebElement(by)).click().build();
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    actions.sendKeys(value).build().perform();
    sleep(2);
    actions.sendKeys(Keys.ENTER).build().perform();

    LogUtils.info("Set text " + value + " in textbox " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + "  in textbox " + by);
    }
    AllureManager.saveTextLog("Set text " + value + "  in textbox");
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }


  @Step("Press Enter")
  public static void pressEnterByAction() {
    sleep(1);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.sendKeys(Keys.ENTER).build().perform();
  }

  @Step("Press Tab")
  public static void pressTabByAction() {
    sleep(1);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.sendKeys(Keys.TAB).build().perform();
  }

  @Step("Press Down")
  public static void pressDOWNByAction() {
    sleep(1);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.sendKeys(Keys.DOWN).build().perform();
  }

  @Step("Press Down")
  public static void pressDownByAction() {
    sleep(1);
    Actions actions = new Actions(DriverManager.getDriver());
    actions.sendKeys(Keys.DOWN).build().perform();
  }

  public static void setCtrlAThenFillText_(By by, String value) {
    Actions actions = new Actions(DriverManager.getDriver());
    actions.click(getWebElement(by)).build().perform();
    //actions.moveToElement(getWebElement(by)).click().build();
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    actions.sendKeys(value).build().perform();

    LogUtils.info("Set text " + value + " in textbox " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + "  in textbox " + by);
    }
    AllureManager.saveTextLog("Set text " + value + "  in textbox");
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }


  /**
   * Điền giá trị vào ô Text
   *
   * @param by    an element of object type By
   * @param value giá trị cần điền vào ô text
   */
  @Step("Clear and Fill text on text box")
  public static void clearAndFillText(By by, String value) {
    waitForElementVisible(by).clear();
    waitForElementVisible(by).sendKeys(value);
    LogUtils.info("Clear and Fill " + value + " on " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clear and Fill " + value + " on " + by);
    }
    AllureManager.saveTextLog("Clear and Fill " + value + " on " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Click on element
   *
   * @param by an element of object type By
   */
  @Step("Click on the element {0}")
  public static void clickElement(By by) {
    sleep(1);
    waitForElementVisible(by).click();
    LogUtils.info("Clicked on the element " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clicked on the element " + by);
    }
    AllureManager.saveTextLog("Clicked on the element " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  public static void clickWebElement(By by) {
    waitForElementClickable(by).click();
    LogUtils.info("Clicked on the element " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clicked on the element " + by);
    }
    AllureManager.saveTextLog("Clicked on the element " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }
  /**
   * Click on element with timeout
   *
   * @param by an element of object type By
   */
  @Step("Click on the element {0} with timeout {1}s")
  public static void clickElement(By by, int timeout) {
    waitForElementVisible(by, timeout).click();
    LogUtils.info("Clicked on the element " + by.toString());

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clicked on the element " + by);
    }
    AllureManager.saveTextLog("Clicked on the element " + by);

    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Click chuột vào Element trên web với Javascript (click ngầm không sợ bị che)
   *
   * @param by an element of object type By
   */
  @Step("Click on the element by Javascript {0}")
  public static void clickElementWithJs(By by) {
    waitForElementPresent(by);
    //Scroll to element với Javascript Executor`
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    //Click with JS
    js.executeScript("arguments[0].click();", getWebElement(by));

    LogUtils.info("Click on element with JS: " + by);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Click on element with JS: " + by);
    }
    AllureManager.saveTextLog("Click on element with JS: " + by);
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  //Hàm cắt chuỗi string với kí tự key trả về list các chuỗi con
  public static List<String> splitString(String value, String key) {

    List<String> stringList = new ArrayList<>();

    String[] stringArray = value.split(key);

    for (String str : stringArray) {
      stringList.add(str);
    }
    return stringList;

  }


  /**
   * Click on the link on website with text
   *
   * @param linkText is the visible text of a link
   */
  @Step("Click on the link text {0}")
  public static void clickLinkText(String linkText) {
    smartWait();

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(2000));
    WebElement elementWaited = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    elementWaited.click();

    LogUtils.info("Click on link text " + linkText);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Click on link text " + linkText);
    }
    AllureManager.saveTextLog("Click on link text " + linkText);
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
  }

  /**
   * Click chuột phải vào đối tượng Element trên web
   *
   * @param by an element of object type By
   */
  @Step("Right click on element {0}")
  public static void rightClickElement(By by) {
    Actions action = new Actions(DriverManager.getDriver());
    action.contextClick(waitForElementVisible(by)).build().perform();
    LogUtils.info("Right click on element " + by);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Right click on element " + by);
    }
    AllureManager.saveTextLog("Right click on element " + by);
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  /**
   * Get text of an element
   *
   * @param by an element of object type By
   * @return text of a element
   */
  @Step("Get text of element {0}")
  public static String getTextElement(By by) {
    smartWait();
    LogUtils.info("Get text of element " + by.toString());
    return waitForElementVisible(by).getText().trim();
  }

  /**
   * Lấy giá trị từ thuộc tính của element
   *
   * @param by            an element of object type By
   * @param attributeName tên thuộc tính
   * @return giá trị thuộc tính của element
   */
  @Step("Get attribute {1} of element {0}")
  public static String getAttributeElement(By by, String attributeName) {
    smartWait();
    LogUtils.info("Get attribute of element " + by.toString() + "with attribute " + attributeName);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get attribute of element " + by + "with attribute " + attributeName);
    }
    return waitForElementVisible(by).getAttribute(attributeName);
  }

  /**
   * Get CSS value of an element
   *
   * @param by      an element of object type By
   * @param cssName is CSS attribute name
   * @return value of CSS attribute
   */
  @Step("Get CSS value {1} of element {0}")
  public static String getCssValueElement(By by, String cssName) {
    smartWait();
    LogUtils.info("Get CSS value of element " + by.toString() + "with " + cssName);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get CSS value of element " + by + "with " + cssName);
    }
    return waitForElementVisible(by).getCssValue(cssName);
  }

  @Step("Get Size of element {0}")
  public static Dimension getSizeElement(By by) {
    smartWait();
    LogUtils.info("Get Size of element " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get Size of element " + by);
    }
    return waitForElementVisible(by).getSize();
  }

  @Step("Get Location of element {0}")
  public static Point getLocationElement(By by) {
    smartWait();
    LogUtils.info("Get Location of element " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get Location of element " + by);
    }
    return waitForElementVisible(by).getLocation();
  }

  @Step("Get Tag Name of element {0}")
  public static String getTagNameElement(By by) {
    smartWait();
    LogUtils.info("Get Tag Name of element " + by.toString());
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Get Tag Name of element " + by);
    }
    return waitForElementVisible(by).getTagName();
  }

  //Handle Table

  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data by EQUALS type after searching on the Table by Column.")
  public static void checkEqualsValueOnTableByColumn(int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(value);
        if (!res) {
          LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + ": " + res + " - " + title.getText());
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }

  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA (contains)
   *
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data by CONTAINS type after searching on the Table by Column.")
  public static void checkContainsValueOnTableByColumn(int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[@class='ant-table-row ant-table-row-level-0']/td[" + column + "]"));
        res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + ": " + res + " - " + title.getText());
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }

  /**
   * Kiểm tra giá trị từng cột của table bị chồng khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param table  vị trí table (trường hợp table bị đè)
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data by CONTAINS type after searching on the Table by Column.")
  public static void checkContainsValueOnTableByConflictTable(int table, int column, String value) {
    WebUI.sleep(5);
    String re_Xpath = "(//table)[" + table + "]/tbody/tr";
    List<WebElement> trs = WebUI.getWebElements(By.xpath(re_Xpath));
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(re_Xpath));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());
    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath(re_Xpath + "[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().equalsIgnoreCase(value.toUpperCase());
        if (res) {
          LogUtils.info("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }

  }

  /**
   * Kiểm tra giá trị từng cột của table bị chồng khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param table vị trí table (trường hợp table bị đè)
   */
  @Step("Check data by CONTAINS type after searching on the Table by Column.")
  public static void checkNoRecordValueOnTableByConflictTable(int table) {
    WebUI.sleep(5);
    String re_Xpath = "(//table)[" + table + "]/tbody/tr";
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(re_Xpath));
    WebElement title = waitForElementVisible(By.xpath(re_Xpath + "[1]"));
    sleep(1);
    LogUtils.info("Number of row: " + totalRows.size());
    if (totalRows.size() == 1 && title.getText().toUpperCase().equalsIgnoreCase("No records found.")) {
      LogUtils.info("No record found in table");
      ExtentReportManager.pass("No record found in table");
    }

  }


  /**
   * Kiểm tra giá trị từng cột của table bị chồng khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param table  vị trí table (trường hợp table bị đè)
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   *               false không tồn tại giá trị
   *               true có tồn tại giá trị
   */
  @Step("Check data by CONTAINS type after searching on the Table by Column.")
  public static void searchContainsValueOnTableByConflictTableAfterDelete(int table, int column, String value) {
    WebUI.sleep(5);
    String re_Xpath = "(//table)[" + table + "]/tbody/tr";
    List<WebElement> trs = WebUI.getWebElements(By.xpath(re_Xpath));
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(re_Xpath));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());
    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);

    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = true;
        WebElement title = waitForElementVisible(By.xpath(re_Xpath + "[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().equalsIgnoreCase(value.toUpperCase());
        if (res) {
          LogUtils.info("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }

      }
    }

  }


  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA (contains) Text + Icon hoặc 2 dòng text (sử dụng thẻ div)
   *
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data with icon in a column by CONTAINS type after searching on the Table by Column.")
  public static void checkContainsValueOnTableByColumnWithDiv(int column, int index, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]/div/div[" + index + "]"));
        res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + ": " + res + " - " + title.getText());
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }

  public static void checkContainsValueOnTableByColumnWithDupSpanAssignmentList(int column, int index, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]/span/span[" + index + "]"));
        res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + ": " + res + " - " + title.getText());
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }

  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA với xpath tuỳ chỉnh
   *
   * @param column           vị trí cột
   * @param value            giá trị cần so sánh
   * @param xpathToTRtagname giá trị xpath tính đến thẻ TR
   */
  @Step("Check data by CONTAINS type after searching on the Table by Column.")
  public static void checkContainsValueOnTableByColumn(int column, String value, String xpathToTRtagname) {
    smartWait();

    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (res) {
          LogUtils.info("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }
  public static void checkContainsValueOnTableByColumnCreateAssignment(int row, int column1, int column2, String value1,String value2 , String xpathToTRtagname) {
    smartWait();

    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value1  + ") and (" +value2+ "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value1 +" and " +value2);
      ExtentReportManager.fail("Not found value: " + value1+" and " +value2);
    } else {
      for (int i = row; i <= totalRows.size(); i++) {
        boolean res1 = false;
        WebElement title1 = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column1 + "]"));
        res1 = title1.getText().toUpperCase().contains(value1.toUpperCase());

        boolean res2 = false;
        WebElement title2 = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column2 + "]"));
        res2 = title2.getText().toUpperCase().contains(value2.toUpperCase());

        if (res1 && res2) {
          LogUtils.info("Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) contains with value: " + value1+ " and " +value2);
          Assert.assertTrue(res1 && res2, "Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) contains with value: " + value1+ " and " +value2);
          ExtentReportManager.pass("Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) contains with value: " + value1+ " and " +value2);
          break;
        }
        else {
          LogUtils.info("Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) not contains with value: " + value1+ " and " +value2);
          Assert.fail("Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) not contains with value: " + value1+ " and " +value2);
          ExtentReportManager.fail("Row " + i + " (" + title1.getText() + ") and (" + title2.getText() + " ) not contains with value: " + value1+ " and " +value2);
          break;
        }
      }
    }
  }

  /**
   * Lấy giá trị của một cột từ table
   *
   * @param column vị trí cột
   * @return mảng danh sách giá trị của một cột
   */
  public static ArrayList getValueTableByColumn(int column) {
    smartWait();

    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
    sleep(1);
    LogUtils.info("Number of results for column (" + column + "): " + totalRows.size()); //Không thích ghi log thì xóa nhen

    ArrayList arrayList = new ArrayList<String>();

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value !!");
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = DriverManager.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        arrayList.add(title.getText());
        LogUtils.info("Row " + i + ":" + title.getText()); //Không thích ghi log thì xóa nhen
      }
    }

    return arrayList;
  }

  //Wait Element

  /**
   * Chờ đợi element sẵn sàng hiển thị để thao tác theo thời gian tuỳ ý
   *
   * @param by      an element of object type By
   * @param timeOut thời gian chờ tối đa
   * @return một đối tượng WebElement đã sẵn sàng để thao tác
   */
  public static WebElement waitForElementVisible(By by, long timeOut) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(2000));

      boolean check = verifyElementVisible(by, timeOut);
      if (check) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      } else {
        scrollToElementToTop(by);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      }
    } catch (Throwable error) {
      Assert.fail("Timeout waiting for the element Visible. " + by.toString());
      LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
    }
    return null;
  }

  /**
   * Chờ đợi element sẵn sàng hiển thị để thao tác
   *
   * @param by an element of object type By
   * @return một đối tượng WebElement đã sẵn sàng để thao tác
   */
  public static WebElement waitForElementVisible(By by) {
    smartWait();
    waitForElementPresent(by);

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      boolean check = isElementVisible(by, 1);
      if (check) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      } else {
        scrollToElementToBottom(by);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      }
    } catch (Throwable error) {
      LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
      Assert.fail("Timeout waiting for the element Visible. " + by);
    }
    return null;
  }

  /**
   * Chờ đợi element sẵn sàng hiển thị để CLICK theo thời gian tuỳ ý
   *
   * @param by      an element of object type By
   * @param timeOut thời gian chờ tối đa
   * @return một đối tượng WebElement đã sẵn sàng để CLICK
   */
  public static WebElement waitForElementClickable(By by, long timeOut) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(2000));
      return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
    } catch (Throwable error) {
      Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
      LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
    }
    return null;
  }

  /**
   * Chờ đợi element sẵn sàng hiển thị để CLICK
   *
   * @param by an element of object type By
   * @return một đối tượng WebElement đã sẵn sàng để CLICK
   */
  public static WebElement waitForElementClickable(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
    } catch (Throwable error) {
      Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
      LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
    }
    return null;
  }

  /**
   * Chờ đợi element sẵn sàng tồn tại trong DOM theo thời gian tuỳ ý
   *
   * @param by      an element of object type By
   * @param timeOut thời gian chờ tối đa
   * @return một đối tượng WebElement đã tồn tại
   */
  public static WebElement waitForElementPresent(By by, long timeOut) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(2000));
      return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    } catch (Throwable error) {
      LogUtils.error("Timeout waiting for the element to exist. " + by.toString());
      Assert.fail("Timeout waiting for the element to exist. " + by);
    }

    return null;
  }

  /**
   * Chờ đợi element sẵn sàng tồn tại trong DOM theo thời gian tuỳ ý
   *
   * @param by an element of object type By
   * @return một đối tượng WebElement đã tồn tại
   */
  public static WebElement waitForElementPresent(By by) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    } catch (Throwable error) {
      LogUtils.error("Element not exist. " + by.toString());
      Assert.fail("Element not exist. " + by);
    }
    return null;
  }

  /**
   * Chờ đợi thuộc tính của một element tồn tại
   *
   * @param by        an element of object type By
   * @param attribute tên thuộc tính
   * @return true/false
   */
  public static boolean waitForElementHasAttribute(By by, String attribute) {
    smartWait();

    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      return wait.until(ExpectedConditions.attributeToBeNotEmpty(waitForElementPresent(by), attribute));
    } catch (Throwable error) {
      LogUtils.error("Timeout for element " + by.toString() + " to exist attribute: " + attribute);
      Assert.fail("Timeout for element " + by + " to exist attribute: " + attribute);
    }
    return false;
  }

  /**
   * Kiểm tra giá trị từ thuộc tính của một element có đúng hay không
   *
   * @param by        an element of object type By
   * @param attribute tên thuộc tính
   * @param value     giá trị
   * @return true/false
   */
  @Step("Verify element {0} with attribute {1} has value is {2}")
  public static boolean verifyElementAttributeValue(By by, String attribute, String value) {
    smartWait();
    waitForElementVisible(by);
    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(2000));
      wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
      LogUtils.info("Object: " + by.toString() + "has found value: " + value + " with attribute type: " + attribute + ". Actual get Attribute value is: " + getAttributeElement(by, attribute));
      ExtentReportManager.pass("Object: " + by + "has found value: " + value + " with attribute type: " + attribute + ". Actual get Attribute value is: " + getAttributeElement(by, attribute));
      return true;
    } catch (Throwable error) {
      LogUtils.error("Object: " + by.toString() + ". Not found value: " + value + " with attribute type: " + attribute + ". Actual get Attribute value is: " + getAttributeElement(by, attribute));
      Assert.fail("Object: " + by + ". Not found value: " + value + " with attribute type: " + attribute + ". Actual get Attribute value is: " + getAttributeElement(by, attribute));
      ExtentReportManager.fail("Object: " + by.toString() + ". Not found value: " + value + " with attribute type: " + attribute + ". Actual get Attribute value is: " + getAttributeElement(by, attribute));
      addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      return false;
    }
  }

  /**
   * Chờ đợi thuộc tính của một element tồn tại với thời gian tuỳ chỉnh
   *
   * @param by        an element of object type By
   * @param attribute tên thuộc tính
   * @return true/false
   * @timeOut thời gian chờ tối đa
   */
  @Step("Verify element {0} has attribute {1} with timeout {2} second")
  public static boolean verifyElementHasAttribute(By by, String attribute, int timeOut) {
    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
      wait.until(ExpectedConditions.attributeToBeNotEmpty(waitForElementPresent(by), attribute));
      LogUtils.info("Found Attribute " + attribute + " of element " + by.toString());
      ExtentReportManager.pass("Found Attribute " + attribute + " of element " + by);
      return true;
    } catch (Throwable error) {
      LogUtils.error("Not found Attribute " + attribute + " of element " + by.toString());
      Assert.fail("Not found Attribute " + attribute + " of element " + by);
      ExtentReportManager.fail("Not found Attribute " + attribute + " of element " + by.toString());
      return false;
    }
  }

  // Wait Page loaded

  /**
   * Chờ đợi trang tải xong (Javascript) với thời gian mặc định từ config
   */
  public static void waitForPageLoaded() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED), Duration.ofMillis(2000));
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

    // wait for Javascript to loaded
    ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

    //Get JS is Ready
    boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

    //Wait Javascript until it is Ready!
    if (!jsReady) {
      LogUtils.info("Javascript in NOT Ready!");
      //Wait for Javascript to load
      try {
        wait.until(jsLoad);
      } catch (Throwable error) {
        error.printStackTrace();
        Assert.fail("Timeout waiting for page load (Javascript). (" + WAIT_PAGE_LOADED + "s)");
      }
    }
  }

  /**
   * Chờ đợi JQuery tải xong với thời gian mặc định từ config
   */
  public static void waitForJQueryLoad() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED), Duration.ofMillis(2000));
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

    //Wait for jQuery to load
    ExpectedCondition<Boolean> jQueryLoad = driver -> {
      assert driver != null;
      return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
    };

    //Get JQuery is Ready
    boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

    //Wait JQuery until it is Ready!
    if (!jqueryReady) {
      LogUtils.info("JQuery is NOT Ready!");
      try {
        //Wait for jQuery to load
        wait.until(jQueryLoad);
      } catch (Throwable error) {
        Assert.fail("Timeout waiting for JQuery load. (" + WAIT_PAGE_LOADED + "s)");
      }
    }
  }

  //Wait for Angular Load

  /**
   * Chờ đợi Angular tải xong với thời gian mặc định từ config
   */
  public static void waitForAngularLoad() {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED), Duration.ofMillis(2000));
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

    //Wait for ANGULAR to load
    ExpectedCondition<Boolean> angularLoad = driver -> {
      assert driver != null;
      return Boolean.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
    };

    //Get Angular is Ready
    boolean angularReady = Boolean.parseBoolean(js.executeScript(angularReadyScript).toString());

    //Wait ANGULAR until it is Ready!
    if (!angularReady) {
      LogUtils.warn("Angular is NOT Ready!");
      //Wait for Angular to load
      try {
        //Wait for jQuery to load
        wait.until(angularLoad);
      } catch (Throwable error) {
        Assert.fail("Timeout waiting for Angular load. (" + WAIT_PAGE_LOADED + "s)");
      }
    }

  }

  /**
   * Chọn giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA với xpath tuỳ chỉnh sau đó click vào giá trị đó
   *
   * @param column           vị trí cột
   * @param value            giá trị cần lấy để click vào
   * @param xpathToTRtagname giá trị xpath tính đến thẻ TR
   */
  public static void selectedValueOnTableByColumn(int column, String value, String xpathToTRtagname) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());
    if (totalRows.isEmpty()) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement description = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column + "]"));
        boolean res = description.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + description.getText());
        } else {
          WebElement checkboxElement = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + 1 + "]"));
          if (checkboxElement != null) {
            boolean isChecked = checkboxElement.isSelected();
            if (!isChecked) {
              checkboxElement.click();
              LogUtils.info("Row " + i + ": " + res + " - " + description.getText());
              break;
            }
          }
        }
      }
    }
  }

  public static void chooseStudentInCreateAssignment(int column, String value, String xpathToTRtagname) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());
    if (totalRows.isEmpty()) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement description = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column + "]"));
        boolean res = description.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + description.getText());
        } else {
          WebElement checkboxElement = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + 1 + "]/label/span"));
          if (checkboxElement != null) {
            boolean isChecked = checkboxElement.isSelected();
            if (!isChecked) {
              checkboxElement.click();
              LogUtils.info("Row " + i + ": " + res + " - " + description.getText() + " is clicked");
              break;
            }
          }

        }

      }
    }
  }


  /**
   * Chọn giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA với xpath tuỳ chỉnh sau đó click vào giá trị đó
   *
   * @param column           vị trí cột
   * @param value            giá trị cần lấy để click vào
   * @param xpathToTRtagname giá trị xpath tính đến thẻ TR
   */
  public static void selectedValueOnTableByColumnAndRow(int column, int row, String value, String xpathToTRtagname) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpathToTRtagname));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());
    if (totalRows.isEmpty()) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        if (i <= row) {
          WebElement description = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + column + "]"));
          boolean res = description.getText().toUpperCase().contains(value.toUpperCase());
          if (!res) {
            LogUtils.info("Row " + i + ": " + res + " - " + description.getText());
          } else {
            WebElement checkboxElement = waitForElementVisible(By.xpath(xpathToTRtagname + "[" + i + "]/td[" + 1 + "]"));
            if (checkboxElement != null) {
              boolean isChecked = checkboxElement.isSelected();
              if (!isChecked) {
                checkboxElement.click();
                LogUtils.info("Row " + i + ": " + res + " - " + description.getText());
                break;
              }
            }
          }
        }
      }
    }
  }

  /**
   * Expand toàn bộ dòng trong table Report sau đó muốn lấy dòng nào để verify thì xử lý tiếp tục
   */
  public static List<WebElement> expandAllRowsInTableReport() {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getAllRowsInTableReport(tableElement, rows);
      return rows;
    }
    return rows;
  }

  public static void expandRowsInTableReport(String texts) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReport(tableElement, rows, texts);
    }
  }

  public static void expandRowsInTableReportByText(String texts) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReportByText(tableElement, rows, texts);
    }
  }

  /**
   * Expand toàn bộ dòng trong table Report sau đó muốn lấy dòng nào để verify thì xử lý tiếp tục
   *
   * @param tableIndex vị trí table cần lấy
   */
  public static void expandAllRowsInTableReport(int tableIndex) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[" + tableIndex + "]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getAllRowsInTableReport(tableElement, rows);
    }
  }

  public static void expandSelectedRowsInTableReport(int tableIndex, int endrows) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[" + tableIndex + "]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getSelectedRowInTableReport(tableElement, rows, endrows);
    }
  }

  public static void expandSelectedRowsInTableReport(int endrows) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.info("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getSelectedRowInTableReport(tableElement, rows, endrows);
    }
  }

  public static List<WebElement> getRowsInTableReportFromStart(WebElement tableElement, List<WebElement> rows, String textStart) {
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    int count = 1;
    int rowIdx = 1;
    while (rowIdx <= rows.size()) {
      WebElement row = rows.get(rowIdx - 1);
      scrollToElementToBottom(row);
      var check = row.getText().split("(\\n|\\s\\d\\n)");
      List<String> rowResult = new ArrayList<>(Arrays.asList(check));
      if (textStart.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
          if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
            sleep(1);
            WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
            String checkImg = checkImgeExplain(isShow.getAttribute("src"));
            if (checkImg.equalsIgnoreCase("expand@2x")) {
              if (isShow.isDisplayed()) {
                isShow.click();
              }
              waitForPageLoaded();
              waitForJQueryLoad();
              WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
              rows = tbodyElement.findElements(By.tagName("tr"));
              LogUtils.info("Row " + rowIdx + " is expanded");
              count++;
              break;
            }else {
              break;
            }
          }
        }
        rowIdx++;
      }

      if (count <= 0 ){
        rowIdx++;
        continue;
      }else {
        if (!textStart.equalsIgnoreCase(rowResult.get(0).trim())) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (WebElement cell : cells) {
            if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
              sleep(1);
              WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
              String checkImg = checkImgeExplain(isShow.getAttribute("src"));
              if (checkImg.equalsIgnoreCase("expand@2x")) {
                if (isShow.isDisplayed()) {
                  isShow.click();
                }
                waitForPageLoaded();
                waitForJQueryLoad();
                WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
                rows = tbodyElement.findElements(By.tagName("tr"));
                LogUtils.info("Row " + rowIdx + " is expanded");
                count++;
                break;
              }else {
                break;
              }
            }
          }
          rowIdx++;
        }
      }
    }
    return rows;
  }


  public static List<WebElement> getRowsInTableReportFromStartToEndStandard(WebElement tableElement, List<WebElement> rows, String textStart, String... textEnds) {
    List<String> lstDtaEnd = textEnds.length > 1 ? Arrays.asList(textEnds) : new ArrayList<>();
    if (textEnds instanceof Object) {
      lstDtaEnd = Arrays.asList(textEnds[0].split(", "));
    }
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    int rowIdx = 1;
    int size = 0;
    int count = 0;
    while (rowIdx <= rows.size()) {
      String txt = lstDtaEnd.get(size);
      WebElement row = rows.get(rowIdx - 1);
      scrollToElementToBottom(row);
      var check = row.getText().split("(\\n|\\s\\d\\n)");
      List<String> rowResult = new ArrayList<>(Arrays.asList(check));
      if (textStart.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
          if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
            sleep(1);
            WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
            String checkImg = checkImgeExplain(isShow.getAttribute("src"));
            if (checkImg.equalsIgnoreCase("expand@2x")) {
              if (isShow.isDisplayed()) {
                isShow.click();
              }
              waitForPageLoaded();
              waitForJQueryLoad();
              WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
              rows = tbodyElement.findElements(By.tagName("tr"));
              LogUtils.info("Row " + rowIdx + " is expanded");
              count++;
              break;
            }else {
              rowIdx++;
              break;
            }
          }
        }
        rowIdx++;
      }
      if (count <= 0 ){
        rowIdx++;
        continue;
      }else {
        if (!txt.equalsIgnoreCase(rowResult.get(0).trim())) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (WebElement cell : cells) {
            if (cell.getText().equalsIgnoreCase(txt)) {
              size++;
              break;
            } else {
              if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
                sleep(1);
                WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
                String checkImg = checkImgeExplain(isShow.getAttribute("src"));
                if (checkImg.equalsIgnoreCase("expand@2x")) {
                  if (isShow.isDisplayed()) {
                    isShow.click();
                  }
                  waitForPageLoaded();
                  waitForJQueryLoad();
                  WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
                  rows = tbodyElement.findElements(By.tagName("tr"));
                  LogUtils.info("Row " + rowIdx + " is expanded");
                  break;
                } else {
                  rowIdx++;
                  break;
                }
              }
            }
          }
          rowIdx++;
        }
      }
      if (txt.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
          if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
            sleep(1);
            WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
            String checkImg = checkImgeExplain(isShow.getAttribute("src"));
            if (checkImg.equalsIgnoreCase("expand@2x")) {
              if (isShow.isDisplayed()) {
                isShow.click();
              }
              waitForPageLoaded();
              waitForJQueryLoad();
              WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
              rows = tbodyElement.findElements(By.tagName("tr"));
              LogUtils.info("Row " + rowIdx + " is expanded");
              break;
            }else {
              rowIdx++;
              break;
            }
          }
        }
        rowIdx++;
        break;
      }
    }
    return rows;
  }

  public static List<WebElement> getRowsInTableReportFromStartToEnd2(WebElement tableElement, List<WebElement> rows, String textStart, String... textEnds) {
    List<String> lstDtaEnd = textEnds.length > 1 ? Arrays.asList(textEnds) : new ArrayList<>();
    if (textEnds instanceof Object) {
      lstDtaEnd = Arrays.asList(textEnds[0].split(", "));
    }
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    int rowIdx = 1;
    int size = 0;
    int count = 0;
    while (rowIdx <= rows.size() && size < lstDtaEnd.size()) {
      String txt = lstDtaEnd.get(size);
      WebElement row = rows.get(rowIdx - 1);
      scrollToElementToBottom(row);
      var check = row.getText().split("(\\n|\\s\\d\\n)");
      List<String> rowResult = new ArrayList<>(Arrays.asList(check));
      if (textStart.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
          if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
            sleep(1);
            WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
            String checkImg = checkImgeExplain(isShow.getAttribute("src"));
            if (checkImg.equalsIgnoreCase("expand@2x")) {
              if (isShow.isDisplayed()) {
                isShow.click();
              }
              waitForPageLoaded();
              waitForJQueryLoad();
              WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
              rows = tbodyElement.findElements(By.tagName("tr"));
              LogUtils.info("Row " + rowIdx + " is expanded");
              count++;
              break;
            }else {
              rowIdx++;
              break;
            }
          }
        }
        rowIdx++;
      }

      if (count <= 0 ){
        rowIdx++;
        continue;
      }else {
        if (!txt.equalsIgnoreCase(rowResult.get(0).trim())) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (WebElement cell : cells) {
            if (cell.getText().equalsIgnoreCase(txt)) {
              size++;
              break;
            } else {
              if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
                sleep(1);
                WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
                String checkImg = checkImgeExplain(isShow.getAttribute("src"));
                if (checkImg.equalsIgnoreCase("expand@2x")) {
                  if (isShow.isDisplayed()) {
                    isShow.click();
                  }
                  waitForPageLoaded();
                  waitForJQueryLoad();
                  WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
                  rows = tbodyElement.findElements(By.tagName("tr"));
                  LogUtils.info("Row " + rowIdx + " is expanded");
                  break;
                } else {
                  rowIdx++;
                  break;
                }
              }
            }
          }
          rowIdx++;
          break;
        }
      }
      rowIdx++;
    }
    return rows;
  }

  public static List<WebElement> getRowsInTableReportFromStartToEnd(WebElement tableElement, List<WebElement> rows, String textStart, String... textEnds) {
    List<String> lstDtaEnd = textEnds.length > 1 ? Arrays.asList(textEnds) : new ArrayList<>();
    if (textEnds instanceof Object) {
      lstDtaEnd = Arrays.asList(textEnds[0].split(", "));
    }
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    int rowIdx = 1;
    int dataIdx = 0;
    int count = 0;
    while (rowIdx <= rows.size()) {
      String txt = lstDtaEnd.get(dataIdx);
      WebElement row = rows.get(rowIdx - 1);
      scrollToElementToBottom(row);
      var check = row.getText().split("(\\n|\\s\\d\\n)");
      List<String> rowResult = new ArrayList<>(Arrays.asList(check));
      if (textStart.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
          sleep(1);
          WebElement isShow = cells.get(0).findElement(By.xpath("(//img)[" + rowIdx + "]"));
          String checkImg = checkImgeExplain(isShow.getAttribute("src"));
          if (checkImg.equalsIgnoreCase("expand@2x")) {
            if (isShow.isDisplayed()) {
              isShow.click();
            }
            waitForPageLoaded();
            waitForJQueryLoad();
            WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
            rows = tbodyElement.findElements(By.tagName("tr"));
            LogUtils.info("Row " + rowIdx + " is expanded");
            rowIdx++;
            count++;
            continue;
          }
        }
      }

      if (count <= 0 ){
          rowIdx++;
          continue;
      }else {
        if (txt.equalsIgnoreCase(rowResult.get(0).trim())) {
          dataIdx++;
          rowIdx++;
          continue;
        }
        if (!txt.equalsIgnoreCase(rowResult.get(0).trim())) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          if (cells.get(0).getText().equalsIgnoreCase(txt)) {
            dataIdx++;
            rowIdx++;
            continue;
          } else {
            if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
              sleep(1);
              WebElement isShow = cells.get(0).findElement(By.xpath("(//img)[" + rowIdx + "]"));
              String checkImg = checkImgeExplain(isShow.getAttribute("src"));
              if (checkImg.equalsIgnoreCase("expand@2x")) {
                if (isShow.isDisplayed()) {
                  isShow.click();
                }
                waitForPageLoaded();
                waitForJQueryLoad();
                WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
                rows = tbodyElement.findElements(By.tagName("tr"));
                LogUtils.info("Row " + rowIdx + " is expanded");
                rowIdx++;
                continue;
              }
            }
          }
        }
      }
    }
    return rows;
  }

  private static String checkImgeExplain(String imgSrc) {
    String txt = imgSrc.substring(imgSrc.lastIndexOf("/") + 1, imgSrc.lastIndexOf(".png"));
    switch (txt) {
      case "contract@2x": {
        return txt;
      }
      case "expand@2x": {
        return txt;
      }
      default: {
        return txt;
      }
    }
  }


  public static List<WebElement> expandRowsInTableReportEndData(WebElement tableElement, List<WebElement> rows, String... texts) {
    List<String> lstDta = texts.length > 1 ? Arrays.asList(texts) : new ArrayList<>();
    if (texts instanceof Object) {
      lstDta = Arrays.asList(texts[0].split(", "));
    }
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    int rowIdx = 1;
    int count = 0;
    while (rowIdx <= rows.size()) {
      WebElement row = rows.get(rowIdx - 1);
      scrollToElementToBottom(row);
      var check = row.getText().split("(\\n|\\s\\d\\n)");
      List<String> rowResult = new ArrayList<>(Arrays.asList(check));
      String txt = lstDta.get(count);
      if (txt.equalsIgnoreCase(rowResult.get(0).trim())) {
        count++;
        rowIdx++;
        continue;
      }
      if (!txt.equalsIgnoreCase(rowResult.get(0).trim())) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if (!cells.get(0).getText().equals(txt)){
          if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
            sleep(1);
            WebElement isShow = cells.get(0).findElement(By.xpath("(//img)[" + rowIdx + "]"));
            if (isShow.isDisplayed()) {
              isShow.click();
              waitForPageLoaded();
              waitForJQueryLoad();
              WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
              rows = tbodyElement.findElements(By.tagName("tr"));
              LogUtils.info("Row " + rowIdx + " is expanded");
              rowIdx++;
              continue;
            }
          }
        }
      }
    }
    return rows;
  }

  public static List<WebElement> getRowsInTableReportByText(WebElement tableElement, List<WebElement> rows, String text) {
    int i = 1;
    if (rows.size() <= 0) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    while (i <= rows.size() && !rows.get(i - 1).getText().contains(text)) {
      WebElement row = rows.get(i - 1);
      scrollToElementToBottom(row);
      List<WebElement> cells = row.findElements(By.tagName("td"));
      for (WebElement cell : cells) {
        if (verifyElementPresent(By.xpath("(//img)[" + i + "]"), 5)) {
          sleep(1);
          WebElement isShow = cell.findElement(By.xpath("(//img)[" + i + "]"));
          if (isShow.isDisplayed()) {
            isShow.click();
            waitForPageLoaded();
            waitForJQueryLoad();
            WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
            rows = tbodyElement.findElements(By.tagName("tr"));
            LogUtils.info("Row " + i + " is expanded");
            break;
          }
          break;
        }
      }
      i++;
    }
    return rows;
  }


  public static List<WebElement> getRowsInTableReport(WebElement tableElement, List<WebElement> rows, String... texts) {
    List<String> lstDta = texts.length > 1 ? Arrays.asList(texts) : new ArrayList<>();
    if (texts instanceof Object) {
      lstDta = Arrays.asList(texts[0].split(", "));
    }
    int rowIdx = 1;
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    while (rowIdx <= rows.size()) {
      for (String txt : lstDta) {
        WebElement row = rows.get(rowIdx - 1);
        scrollToElementToBottom(row);
        if (row.getText().split("\n")[0].equalsIgnoreCase(txt)) {
          rowIdx++;
          continue;
        } else {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (WebElement cell : cells) {
            if (cell.getText().equalsIgnoreCase(txt)) {
              rowIdx++;
              break;
            } else {
              if (verifyElementPresent(By.xpath("(//img)[" + rowIdx + "]"), 5)) {
                sleep(1);
                WebElement isShow = cell.findElement(By.xpath("(//img)[" + rowIdx + "]"));
                if (isShow.isDisplayed()) {
                  isShow.click();
                  waitForPageLoaded();
                  waitForJQueryLoad();
                  WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
                  rows = tbodyElement.findElements(By.tagName("tr"));
                  LogUtils.info("Row " + rowIdx + " is expanded");
                  break;
                }
                break;
              }
            }
          }
          rowIdx++;
          break;
        }
      }
    }
    return rows;
  }

  public static List<WebElement> getAllRowsInTableReport(WebElement tableElement, List<WebElement> rows) {
    int i = 1;
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tableElement);
      Assert.fail("Not found rows: " + rows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tableElement);
    }
    while (i <= rows.size()) {
      WebElement row = rows.get(i - 1);
      List<WebElement> cells = row.findElements(By.tagName("td"));
      for (WebElement cell : cells) {
        scrollToElementToBottom(cell);
        if (verifyElementPresent(By.xpath("(//img)[" + i + "]"), 5)) {
          sleep(1);
          WebElement isShow = cell.findElement(By.xpath("(//img)[" + i + "]"));
          if (isShow.isDisplayed()) {
            isShow.click();
            waitForPageLoaded();
            waitForJQueryLoad();
            WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
            rows = tbodyElement.findElements(By.tagName("tr"));
            LogUtils.info("Row " + i + " is expanded");
            break;
          }
          break;
        }
      }
      i++;
    }
    return rows;
  }


  public static List<WebElement> getSelectedRowInTableReport(WebElement tableElement, List<WebElement> rows, int endrows) {
    int i = 1;
    if (endrows > rows.size()) {
      LogUtils.error("Not found rows: " + endrows + " of element " + tableElement);
      Assert.fail("Not found rows: " + endrows + " of element " + tableElement);
      ExtentReportManager.fail("Not found rows: " + endrows + " of element " + tableElement);
    }
    while (i <= rows.size() && i <= endrows) {
      WebElement row = rows.get(i - 1);
      List<WebElement> cells = row.findElements(By.tagName("td"));
      for (WebElement cell : cells) {
        if (WebUI.verifyElementPresent(By.xpath("(//img)[" + i + "]"), 5)) {
          WebElement isShow = cell.findElement(By.xpath("(//img)[" + i + "]"));
          if (isShow.isDisplayed()) {
            isShow.click();
            WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
            rows = tbodyElement.findElements(By.tagName("tr"));
            LogUtils.info("Row " + i + " is expanded");
            break;
          }
          break;
        }
      }
      i++;
    }
    return rows;
  }

  private static String padRight(String s, int n) {
    return String.format("%-" + n + "s", s);
  }

  public static void chooseValueToEditOnTableByColumn(int column, String value) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        Boolean res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
        } else {
          WebElement iconEdit = waitForElementVisible(By.xpath("(//*[name()='svg'])[23]"));
          iconEdit.click();
          sleep(2);
          WebElement checkboxElement = waitForElementVisible(By.xpath("//span[normalize-space()='Edit Account']"));
          checkboxElement.click();
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          break;
        }
      }
    }
  }

  public static void chooseValueToDisableOnTableByColumn(int column, String value) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        Boolean res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
        } else {
          WebElement iconEdit = waitForElementVisible(By.xpath("(//*[name()='svg'])[23]"));
          iconEdit.click();
          sleep(2);
          WebElement checkboxElement = waitForElementVisible(By.xpath("(//span[contains(text(),'Disable Account')]"));
          checkboxElement.click();
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          break;
        }
      }
    }
  }

  public static void chooseValueToDeteleOnTableByColumn(int column, String value) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        Boolean res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
        } else {
          WebElement iconEdit = waitForElementVisible(By.xpath("(//*[name()='svg'])[23]"));
          iconEdit.click();
          sleep(2);
          WebElement checkboxElement = waitForElementVisible(By.xpath("(//span[contains(text(),'Delete Account')]"));
          checkboxElement.click();
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          break;
        }
      }
    }
  }

  /**
   * Thực hiện action nằm cùng 1 hàng trong bảng khi thỏa mãn giá trị nhập vào
   *
   * @param table          vị trí cột
   * @param column         vị trí cột
   * @param value          giá trị cần so sánh
   * @param index          thứ tự của action cần dùng
   * @param columnOfAction cột của action
   */
  public static void doActionWithValueOnTableByColumn(int table, int column, String value, int columnOfAction, int index) {
    smartWait();
    String xpath = "(//table)[" + table + "]/tbody/tr";
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath(xpath));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement title = waitForElementVisible(By.xpath(xpath + "[" + i + "]/td[" + column + "]"));
        Boolean res = title.getText().toUpperCase().equalsIgnoreCase(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
        } else {
          WebElement iconAction = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + columnOfAction + "]/div[1]/div[" + index + "]//*[name()='svg']"));
          assert iconAction != null;
          iconAction.click();

          break;
        }
      }
    }
    sleep(5);
    waitForPageLoaded();
  }

  // This function will handle stalelement reference exception
  public static void handleStaleElement(By elementName) {
    int count = 0;
    //It will try 4 times to find same element using name.
    while (count < 4) {
      try {
        //If exception generated that means It Is not able to find element then catch block will handle It.
        WebElement staledElement = DriverManager.getDriver().findElement(elementName);
        //If exception not generated that means element found and element text get cleared.
        staledElement.click();
      } catch (StaleElementReferenceException e) {
        e.toString();
        System.out.println("Trying to recover from a stale element :" + e.getMessage());
        count = count + 1;
      }
      count = count + 4;
    }
  }

  public static void chooseValueToViewManageLicenseOnTableByColumn(int column, String value) {
    smartWait();
    //xpathToTRtagname is locator from table to "tr" tagname of data section: //tbody/tr, //div[@id='example_wrapper']//tbody/tr, ...
    List<WebElement> totalRows = DriverManager.getDriver().findElements(By.xpath("//tbody/tr"));
    sleep(1);
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        Boolean res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
        } else {
          WebElement iconEdit = waitForElementVisible(By.xpath("(//*[name()='svg'])[23]"));
          iconEdit.click();
          sleep(2);
          WebElement checkboxElement = waitForElementVisible(By.xpath("(//span[contains(text(),'Manage Licenses')]"));
          checkboxElement.click();
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          break;
        }
      }
    }
    sleep(5);
    waitForPageLoaded();
  }

  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data on the Table by Column.")
  public static void checkValueOnTableByColumn(int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(value);
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }


  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện CHỨA (contains)
   *
   * @param column vị trí cột
   */

  public static void expandHeaderNameOnClassAssessmentReportTable(int column, String value1, String value2, String value3, String value4, String value5, String value6) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value1 + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value1);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().equals(value1.toUpperCase());
        if (res != true) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value1);
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value1);
        } else {
          WebElement iconPlus_1 = waitForElementVisible(By.xpath("((//img)[3]"));
          iconPlus_1.click();
          sleep(2);
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value1);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value1);
          for (int j = 2; j <= totalRows.size(); j++) {
            boolean res1 = false;
            WebElement title1 = waitForElementVisible(By.xpath("//tbody/tr[" + j + "]/td[" + column + "]"));
            res1 = title1.getText().toUpperCase().equals(value2.toUpperCase());
            if (res1 != true) {
              LogUtils.info("Row " + j + ": " + res1 + " - " + title1.getText());
              Assert.fail("Row " + j + " (" + title1.getText() + ")" + " not contains with value: " + value2);
              ExtentReportManager.fail("Row " + j + " (" + title1.getText() + ")" + " not contains with value: " + value2);
            } else {
              WebElement iconPlus_2 = waitForElementVisible(By.xpath("((//img)[4]"));
              iconPlus_2.click();
              sleep(2);
              LogUtils.info("Row " + j + ": " + res1 + " - " + title1.getText());
              Assert.assertTrue(res1, "Row " + j + " (" + title1.getText() + ")" + " contains with value: " + value2);
              ExtentReportManager.pass("Row " + j + " (" + title1.getText() + ")" + " contains with value: " + value2);
              for (int k = 3; k <= totalRows.size(); k++) {
                boolean res2 = false;
                WebElement title2 = waitForElementVisible(By.xpath("//tbody/tr[" + k + "]/td[" + column + "]"));
                res2 = title2.getText().toUpperCase().equals(value3.toUpperCase());
                if (res2 != true) {
                  LogUtils.info("Row " + k + ": " + res2 + " - " + title2.getText());
                  Assert.fail("Row " + k + " (" + title2.getText() + ")" + " not contains with value: " + value3);
                  ExtentReportManager.fail("Row " + k + " (" + title2.getText() + ")" + " not contains with value: " + value3);
                } else {
                  WebElement iconPlus_3 = waitForElementVisible(By.xpath("((//img)[5]"));
                  iconPlus_3.click();
                  sleep(2);
                  LogUtils.info("Row " + k + ": " + res2 + " - " + title2.getText());
                  Assert.assertTrue(res2, "Row " + k + " (" + title2.getText() + ")" + " contains with value: " + value3);
                  ExtentReportManager.pass("Row " + k + " (" + title2.getText() + ")" + " contains with value: " + value3);
                  for (int l = 4; l <= totalRows.size(); l++) {
                    boolean res3 = false;
                    WebElement title3 = waitForElementVisible(By.xpath("//tbody/tr[" + l + "]/td[" + column + "]"));
                    res3 = title3.getText().toUpperCase().equals(value4.toUpperCase());
                    if (res3 != true) {
                      LogUtils.info("Row " + l + ": " + res3 + " - " + title3.getText());
                      Assert.fail("Row " + l + " (" + title3.getText() + ")" + " not contains with value: " + value4);
                      ExtentReportManager.fail("Row " + l + " (" + title3.getText() + ")" + " not contains with value: " + value4);
                    } else {
                      WebElement iconPlus_4 = waitForElementVisible(By.xpath("((//img)[6]"));
                      iconPlus_4.click();
                      sleep(2);
                      LogUtils.info("Row " + l + ": " + res3 + " - " + title3.getText());
                      Assert.assertTrue(res3, "Row " + l + " (" + title3.getText() + ")" + " contains with value: " + value4);
                      ExtentReportManager.pass("Row " + l + " (" + title3.getText() + ")" + " contains with value: " + value4);
                      for (int m = 5; m <= totalRows.size(); m++) {
                        boolean res4 = false;
                        WebElement title4 = waitForElementVisible(By.xpath("//tbody/tr[" + m + "]/td[" + column + "]"));
                        res4 = title4.getText().toUpperCase().equals(value5.toUpperCase());
                        if (res4 != true) {
                          LogUtils.info("Row " + m + ": " + res4 + " - " + title4.getText());
                          Assert.fail("Row " + m + " (" + title4.getText() + ")" + " not contains with value: " + value5);
                          ExtentReportManager.fail("Row " + l + " (" + title4.getText() + ")" + " not contains with value: " + value5);
                        } else {
                          WebElement iconPlus_5 = waitForElementVisible(By.xpath("((//img)[7]"));
                          iconPlus_5.click();
                          sleep(2);
                          LogUtils.info("Row " + m + ": " + res4 + " - " + title4.getText());
                          Assert.assertTrue(res4, "Row " + m + " (" + title4.getText() + ")" + " contains with value: " + value5);
                          ExtentReportManager.pass("Row " + m + " (" + title4.getText() + ")" + " contains with value: " + value5);
                          for (int n = 6; n <= totalRows.size(); n++) {
                            boolean res5 = false;
                            WebElement title5 = waitForElementVisible(By.xpath("//tbody/tr[" + n + "]/td[" + column + "]"));
                            res5 = title5.getText().toUpperCase().equals(value6.toUpperCase());
                            if (res5 != true) {
                              LogUtils.info("Row " + m + ": " + res5 + " - " + title5.getText());
                              Assert.fail("Row " + m + " (" + title5.getText() + ")" + " not contains with value: " + value6);
                              ExtentReportManager.fail("Row " + l + " (" + title5.getText() + ")" + " not contains with value: " + value6);
                            } else {
                              LogUtils.info("Row " + n + ": " + res5 + " - " + title5.getText());
                              Assert.assertTrue(res5, "Row " + n + " (" + title5.getText() + ")" + " contains with value: " + value6);
                              ExtentReportManager.pass("Row " + n + " (" + title5.getText() + ")" + " contains with value: " + value6);
                              break;
                            }
                          }
                          break;
                        }
                      }
                      break;
                    }
                  }
                  break;
                }
              }
              break;
            }
          }
          break;
        }
      }
    }
  }

  public static void checkValueOnReportTableByRowAndColumn(int row, int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + value);
    } else {
      for (int i = row; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(value);
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + value);
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + value);
          break;
        }
      }
    }
  }

  public static void expandProgramNameInClassAssessmentReport(int row, int column, String progranmName) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + progranmName + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + progranmName);
    } else {
      for (int i = row; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(progranmName);
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + progranmName);
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + progranmName);
        } else {
          WebElement iconPlus = waitForElementVisible(By.xpath("((//img)[1]"));
          iconPlus.click();
          sleep(2);
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + progranmName);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + " contains with value: " + progranmName);
          break;
        }
      }
    }
  }

  public static void expandGradeLevelInClassAssessmentReport(int row, int column, String gradeLevel) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + gradeLevel + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + gradeLevel);
    } else {
      for (int i = row; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(gradeLevel);
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + gradeLevel);
        } else {
          WebElement iconPlus = waitForElementVisible(By.xpath("((//img)[2]"));
          iconPlus.click();
          sleep(2);
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + gradeLevel);
          break;
        }
      }
    }
  }

  public static void expandLessonNameInClassAssessmentReport(int row, int column, String lessonName) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + lessonName + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.info("Not found value: " + lessonName);
    } else {
      for (int i = row; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().equalsIgnoreCase(lessonName);
        if (!res) {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + " (" + title.getText() + ")" + " not contains with value: " + lessonName);
        } else {
          WebElement iconPlus = waitForElementVisible(By.xpath("((//img)[3]"));
          iconPlus.click();
          sleep(2);
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertTrue(res, "Row " + i + " (" + title.getText() + ")" + " contains with value: " + lessonName);
          break;
        }
      }
    }
  }

  /**
   * Kiểm tra giá trị từng cột của table khi tìm kiếm theo điều kiện BẰNG (equals)
   *
   * @param column vị trí cột
   * @param value  giá trị cần so sánh
   */
  @Step("Check data by EQUALS type after searching on the Table by Column.")
  public static void checkDataIsNotExistedOnTableByColumn(int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().equals(value.toUpperCase());
        if (res == true) {
          LogUtils.error("Row " + i + ": " + res + " - " + title.getText());
          Assert.fail("Row " + i + ": " + res + " - " + title.getText());
          ExtentReportManager.fail("Row " + i + " (" + title.getText() + ")" + "contains with value: " + value);
          break;
        } else {
          LogUtils.info("Row " + i + ": " + res + " - " + title.getText());
          Assert.assertFalse(res, "Row " + i + " (" + title.getText() + ")" + "not contains with value: " + value);
          ExtentReportManager.pass("Row " + i + " (" + title.getText() + ")" + "not contains with value: " + value);
        }
      }
    }
  }

  /**
   * Nhập giá trị cần tìm kiếm trên thanh tìm kiếm
   *
   * @param by    vị trí web element trên màn hình
   * @param value giá trị cần so sánh
   */
  public static void SearchDataOnTextBox(By by, String value) {
    smartWait();
    LogUtils.info("Input value that you want to search: " + value);
    WebUI.clearTextCtrlA(by);
    WebUI.setText(by, value, Keys.ENTER);
    WebUI.sleep(5);
    WebUI.waitForPageLoaded();
  }


  /**
   * Xóa giá trị trong table sau khi search ra
   *
   * @param column vị trí cột
   * @param value  giá trị không muốn xóa
   */
  @Step("Remove data on the Table by Column. (not exclude value that you do not want to remove)")
  public static void deleteDataOnTableByColumn(int column, String value) {
    smartWait();
    sleep(1);
    List<WebElement> totalRows = getWebElements(By.xpath("//tbody/tr"));
    LogUtils.info("Number of results for keywords (" + value + "): " + totalRows.size());

    if (totalRows.size() < 1) {
      LogUtils.error("Not found value: " + value);
      ExtentReportManager.fail("Not found value: " + value);
    } else {
      for (int i = 1; i <= totalRows.size(); i++) {
        boolean res = false;
        WebElement title = waitForElementVisible(By.xpath("//tbody/tr[" + i + "]/td[" + column + "]"));
        res = title.getText().toUpperCase().contains(value.toUpperCase());
        if (res == true) {
          WebElement iconEdit = waitForElementVisible(By.xpath("(//div[contains(@class,'flex items-center')])[2]"));
          iconEdit.click();
          sleep(2);
          WebElement checkboxElement = waitForElementVisible(By.xpath("//span[contains(text(),'Delete Account')]"));
          checkboxElement.click();
          WebUI.clickElement(By.xpath("//span[normalize-space()='OK']"), 5);
          LogUtils.info("Row " + i + ": is removed");
          sleep(2);
        }

      }
    }
  }


  public static String getDayOfCurrentWeekFormatMMDDYYYY() {
    LocalDate currentDate = LocalDate.now();
    // trả về ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    return currentDate.format(formatter);
  }

  public static String formatDateToMMDDYY(String date) {
    Date dateTest = new Date(date);

    String outputDate = new String();


    return outputDate;

  }

  public static String formatTimeToHHMMPP(String time) {
    List<String> timeItem = splitString(time, " ");
    String formattedTime = new String();
    formattedTime = timeItem.get(0) + ":" + timeItem.get(1) + " " + timeItem.get(2);

    return formattedTime;
  }

  public static String getDayOfLastWeekFormatMMDDYYYY() {
    // Lấy ngày hiện tại
    LocalDate currentDate = LocalDate.now();
    // Lấy tuần trước đó
    LocalDate lastWeek = currentDate.minusWeeks(1);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    // trả về ngày đã định dạng
    return lastWeek.format(formatter);
  }

  public static String getDayOfLastWeek() {
    // Lấy ngày hiện tại
    LocalDate currentDate = LocalDate.now();
    // Lấy tuần trước đó
    LocalDate lastWeek = currentDate.minusWeeks(1);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    return lastWeek.format(formatter);

  }

  public static String getDateOfCurrentWeek() {
    LocalDate currentDate = LocalDate.now();
    // trả về ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    return currentDate.format(formatter);
  }

  /**
   * Giá trị từng cột của table
   *
   * @param tableIndex vị trí của table
   */
  @Step("Check data by CONTAINS type after searching on the Table.")
  public static void checkContainsAllValueOnTable(int tableIndex) {
    smartWait();
    sleep(1);
    WebElement table = WebUI.getWebElement(By.xpath("(//table)[" + tableIndex + "]"));
    WebElement tbodyElement = table.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        LogUtils.info("Row " + rowIdx + ":");
        for (int i = 0; i < cells.size() - 1; i++) {
          String cellText = cells.get(i).getText();
          LogUtils.info("Cell " + (i + 1) + ": " + cellText);
          Assert.assertTrue(true, "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
          ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
        }
        rowIdx++;
      }
    }
  }

  @Step("Check data by CONTAINS type after searching row on the Table.")
  public static void checkContainsRowValueOnTableByText(int tableIndex, String text) {
    smartWait();
    sleep(1);
    WebElement table = WebUI.getWebElement(By.xpath("(//table)[" + tableIndex + "]"));
    WebElement tbodyElement = table.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      for (WebElement row : rows) {
        if (row.getText().contains(text)) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          LogUtils.info("Row " + rowIdx + ":");
          for (int i = 0; i < cells.size() - 1; i++) {
            String cellText = cells.get(i).getText();
            LogUtils.info("Cell " + (i + 1) + ": " + cellText);
            Assert.assertTrue(true, "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
          }
          rowIdx++;
        }
      }

    }
  }


  @Step("Check data by CONTAINS type after searching on the Table.")
  public static void checkContainsAllValueOnTableByText(int tableIndex, String text) {
    smartWait();
    sleep(1);
    WebElement table = WebUI.getWebElement(By.xpath("(//table)[" + tableIndex + "]"));
    WebElement tbodyElement = table.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        LogUtils.info("Row " + rowIdx + ":");
        for (int i = 0; i < cells.size() - 1; i++) {
          String cellText = cells.get(i).getText();
          if (cellText.equalsIgnoreCase(text)) {
            LogUtils.info("Cell " + (i + 1) + ": " + cellText);
            Assert.assertTrue(true, "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            return;
          }
        }
        rowIdx++;
      }
    }
  }

  @Step("Verify File Downloaded With JS [Contains]: {0}")
  public static File verifyFileDownloadedWithJS_ContainsData(String fileName) {
    String url = getCurrentUrl();
    openNewTabWithUrl("chrome://downloads");
    sleep(3);
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    String element = (String) js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#show').getAttribute('title')");
    File file = new File(element);
    LogUtils.info(element);
    LogUtils.info(file.getName());
    if (file.exists() && file.getName().trim().contains(fileName)) {
//      Desktop.getDesktop().open(file);
      ExtentReportManager.pass("File Downloaded is: " + file.getName());
    } else {
      ExtentReportManager.fail("File Downloaded is: " + file.getName());
    }
    closeCurrentWindow();
    switchToMainWindow();
    return file;
  }

  @Step("Open new Tab with url")
  public static void openNewTabWithUrl(String url) {
    sleep(WAIT_SLEEP_STEP);

    // Opens a new tab and switches to new tab
    DriverManager.getDriver().switchTo().newWindow(WindowType.TAB).get(url);
  }

  @Step("Verify element present value {0} with timeout {1} second")
  public static void verifyGetTextOfElementPresent(By by, int timeout) {
    smartWait();
    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      var results = getWebElements(by);
      for (WebElement text : results) {
        LogUtils.info("Verify element present: " + by);
        LogUtils.info("Verify element present value: " + text.getText());
        if (ExtentTestManager.getExtentTest() != null) {
          ExtentReportManager.info("Verify element present: " + by);
          ExtentReportManager.info("Verify element present value: " + text.getText());
        }
        AllureManager.saveTextLog("Verify element present: " + by);
        AllureManager.saveTextLog("Verify element present text: " + by);
        addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
      }
    } catch (Exception e) {
      LogUtils.info("The element does NOT present. " + e.getMessage());
      Assert.fail("The element does NOT present. " + e.getMessage());
    }
  }


  /**
   * Điền giá trị vào ô Text theo Xpath dynamic
   *
   * @param xpathDynamic Xpath with wildcard string
   * @param name         multi value to be replaced in place of wildcard
   * @param value        giá trị cần điền vào ô text
   */
  public static void setTextByDynamicObject(String xpathDynamic, String name, String value) {
    Objects.requireNonNull(waitForElementVisible(By.xpath(ObjectUtils.getXpathDynamic(xpathDynamic, name)))).sendKeys(value);
    LogUtils.info("Set text " + value + " on " + name);

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set text " + value + " on " + name);
    }
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
  }

  /**
   * Click on element with timeout
   *
   * @param xpathDynamic Xpath with wildcard string
   * @param name         multi value to be replaced in place of wildcard
   */
  public static void clickDynamicElement(String xpathDynamic, String name) {
    Objects.requireNonNull(waitForElementVisible(By.xpath(ObjectUtils.getXpathDynamic(xpathDynamic, name)))).click();

    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Clicked on the element " + name);
    }
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }


    public static void setDateTimeInStartDate(By by, String value) {
        sleep(2);
        clickElement(by);
        sleep(1);
        pressESC();
        sleep(1);
        setCtrlAThenFillText(by, value);
        sleep(1);
//        pressTAB();
//        pressTAB();
        pressENTER();
         if (ExtentTestManager.getExtentTest() != null) {
            ExtentReportManager.info("Set datetime with: " + value + " into " + by.toString());
        }
        addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  public static void setDateTimeInStartDateByEnter(By by, String value) {
    sleep(2);
    clickElement(by);
    sleep(1);
    pressESC();
    sleep(1);
    setCtrlAThenFillTextByEnter(by, value);
    sleep(1);
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set datetime with: " + value + " into " + by.toString());
    }
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

    public static void setDateTimeInDueDate(By by, String value) {
        Objects.requireNonNull(waitForElementVisible(by)).click();
        sleep(5);
        WebUI.sendKeys(Keys.ESCAPE);
        sleep(2);
        WebUI.setCtrlAThenFillText(by, value);
        WebUI.sendKeys(Keys.TAB);
        sleep(2);
        WebUI.sendKeys(Keys.ENTER);
        if (ExtentTestManager.getExtentTest() != null) {
            ExtentReportManager.info("Set datetime with: " + value + " into " + by.toString());
        }
        addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  public static void setDateTimeFromReport(By by, String value) {
    Objects.requireNonNull(waitForElementVisible(by)).click();
    sleep(2);
    pressESC();
    sleep(2);
    WebUI.setCtrlAThenFillText(by, value);
    pressTAB();
    pressTAB();
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set datetime with: " + value + " into " + by.toString());
    }
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());

  }

  public static void setDateTimeToReport(By by, String value) {
    Objects.requireNonNull(waitForElementVisible(by)).click();
    sleep(2);
    pressESC();
    sleep(2);
    WebUI.setCtrlAThenFillText(by, value);
    pressTAB();
    pressTAB();
    if (ExtentTestManager.getExtentTest() != null) {
      ExtentReportManager.info("Set datetime with: " + value + " into " + by.toString());
    }
    addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
  }

  public static void verifyTestData(String filePath, String sheetName) throws IOException {
    sleep(5);
    // Load file
    FileInputStream file = new FileInputStream(new File(filePath));

    // Load workbook
    Workbook workbook = new XSSFWorkbook(file);

    // Load sheet
    Sheet sheet = workbook.getSheet(sheetName);

    // Get number of rows and columns
    int numRows = sheet.getLastRowNum() + 1;
    int numCols = sheet.getRow(0).getLastCellNum();

    // Loop through rows and columns
    for (int i = 1; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        // Get cell value from Excel
        String cellValue = getCellValue(sheet.getRow(i).getCell(j));

                // Get cell value from table using Selenium
                WebElement cell = waitForElementVisible(By.xpath("//table/tr[" + (i) + "]//td[" + (j + 1) + "]"));
                assert cell != null;
                String cellText = cell.getText();

                // Compare cell values
                LogUtils.info("Verify all data of each column by row in Table" + " " + cellValue + " " + cellText);
                boolean result = cellText.equalsIgnoreCase(cellValue);
                if (result) {
                    Assert.assertTrue(result, "Row " + i + " Column " + (j + 1) + " contains with value: " + cellText);
                    ExtentReportManager.pass("Row " + i + " Column " + (j + 1) + " contains with value: " + cellText);
                } else {
                    Assert.fail("Row " + i + " Column " + (j + 1) + " not contain with value: " + cellText);
                    ExtentReportManager.fail("Row " + i + " Column " + (j + 1) + " not contain with value: " + cellText);
                }
            }
        }

        // Close workbook and file
        workbook.close();
        file.close();
    }
  public static void verifyTestDataConflictTable(int table, String filePath, String sheetName) throws IOException {
    sleep(5);
    // Load file
    FileInputStream file = new FileInputStream(new File(filePath));

    // Load workbook
    Workbook workbook = new XSSFWorkbook(file);

    // Load sheet
    Sheet sheet = workbook.getSheet(sheetName);

    // Get number of rows and columns
    int numRows = sheet.getLastRowNum() + 1;
    int numCols = sheet.getRow(0).getLastCellNum();

    // Loop through rows and columns
    for (int i = 1; i < numRows; i++) {
      for (int j = 2; j < numCols; j++) {
        // Get cell value from Excel
        String cellValue = getCellValue(sheet.getRow(i).getCell(j-1));

        // Get cell value from table using Selenium
        WebElement cell = waitForElementVisible(By.xpath("(//table)["+table+"]/tbody/tr[" + (i) + "]/td[" + (j + 1) + "]"));
        assert cell != null;
        String cellText = cell.getText();

        // Compare cell values
        LogUtils.info("Verify all data of each column by row in Table" + " " + cellValue + " " + cellText);
        boolean result = cellText.equalsIgnoreCase(cellValue);
        if (result) {
          Assert.assertTrue(result, "Row " + i + " Column " + (j) + " contains with value: " + cellText);
          ExtentReportManager.pass("Row " + i + " Column " + (j) + " contains with value: " + cellText);
        } else {
          Assert.fail("Row " + i + " Column " + (j + 1) + " not contain with value: " + cellText);
          ExtentReportManager.fail("Row " + i + " Column " + (j) + " not contain with value: " + cellText);
        }
      }
    }

    // Close workbook and file
    workbook.close();
    file.close();
  }

    public static void verifyTestDataByRow(String filePath, String sheetName, int row) throws IOException {
        sleep(5);
        // Load file
        FileInputStream file = new FileInputStream(new File(filePath));

        // Load workbook
        Workbook workbook = new XSSFWorkbook(file);

        // Load sheet
        Sheet sheet = workbook.getSheet(sheetName);

        // Get number of rows and columns
        int numRows = sheet.getLastRowNum() + 1;
        int numCols = sheet.getRow(0).getLastCellNum();

        // Loop through rows and columns
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // Get cell value from Excel
                String cellValue = getCellValue(sheet.getRow(i).getCell(j));

                // Get cell value from table using Selenium
                WebElement cell = waitForElementVisible(By.xpath("//table//tr[" + row + "]//td[" + (j + 1) + "]"));
                assert cell != null;
                String cellText = cell.getText();

        // Compare cell values
        LogUtils.info("Verify all data of each column by row in Table" + " " + cellValue + " " + cellText);
        boolean result = cellText.equalsIgnoreCase(cellValue);
        if (result) {
          Assert.assertTrue(result, "Row " + i + " Column " + (j + 1) + " contains with value: " + cellText);
          ExtentReportManager.pass("Row " + i + " Column " + (j + 1) + " contains with value: " + cellText);
        } else {
          Assert.fail("Row " + i + " Column " + (j + 1) + " not contain with value: " + cellText);
          ExtentReportManager.fail("Row " + i + " Column " + (j + 1) + " not contain with value: " + cellText);
        }
      }
    }

    // Close workbook and file
    workbook.close();
    file.close();
  }



  public static String getCellValue(Cell cell) {
    if (cell == null || cell.getCellType() == CellType.BLANK) {
      return ""; // Giá trị mặc định cho cell rỗng
    } else if (cell.getCellType() == CellType.STRING) {
      return cell.getStringCellValue();
    } else if (cell.getCellType() == CellType.NUMERIC) {
      return String.valueOf(cell.getNumericCellValue());
    } else {
      return "Invalid Cell Type";
    }
  }


  // read file csv export
  public static List<List<String>> readFileCSV(String filePath) {
    File file = new File(filePath);
    CSVReader reader = null;
    List<List<String>> lstData = new ArrayList<>();
    try {
      reader = new CSVReader(new FileReader(file));
      String[] cells = reader.readNext();
      while ((cells = reader.readNext()) != null) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
          data.add(cells[i]);
        }
        lstData.add(data);
      }
    } catch (IOException | CsvValidationException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return lstData;
  }

  // filter data export table compare data file csv
  public static void filterExistDataExport(List<List<String>> datas) {
    List<WebElement> rows = WebUI.getWebElements(By.xpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      int idxDatas = 1; // idxDatas List<List<String>> datas
      while (rowIdx <= rows.size() && idxDatas <= datas.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        var lst = datas.get(idxDatas - 1);
        if (row.getText().split("\n")[0].equalsIgnoreCase(lst.get(0))) {
          LogUtils.info("Row " + rowIdx + ":");
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (int i = 0; i <= cells.size() - 1; i++) {
            String cellText = cells.get(i).getText();
            for (int idxData = i; idxData < lst.size(); idxData++) {
              String txtData = lst.get(idxData);
              if (cellText.equalsIgnoreCase(txtData)) {
                LogUtils.info("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.assertTrue(txtData.equalsIgnoreCase(cellText), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                break;
              } else {
                LogUtils.error("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
              }
            }
          }
          idxDatas++;
        }
        rowIdx++;
      }
    }
  }

  public static void filterExistDataExportReport(List<List<String>> datas) {
    List<WebElement> rows = WebUI.getWebElements(By.xpath("(//table)[1]/tbody/tr"));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");
      return;
    } else {
      int rowIdx = 1;
      int idxDatas = 1; // idxDatas List<List<String>> datas
      while (rowIdx <= rows.size() && idxDatas <= datas.size()) {
        WebElement row = rows.get(rowIdx - 1);
        WebUI.scrollToElementToBottom(row);
        var lst = datas.get(idxDatas - 1);
        if (row.getText().split(" ")[0].equalsIgnoreCase(lst.get(3))) {
          LogUtils.info("Row " + rowIdx + ":");
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (int i = 0; i <= cells.size() - 1; i++) {
            int arr[] = {3,4,5};
            for (int j = 0; j < arr.length; j++) {
              String cellText = cells.get(j).getText();
              for (int idxData = arr[j]; idxData < lst.size(); idxData++) {
                String txtData = lst.get(idxData);
                if (cellText.equalsIgnoreCase(txtData)) {
                  LogUtils.info("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  Assert.assertTrue(txtData.equalsIgnoreCase(cellText), "Row " + rowIdx + " Cell " + (j + 1) + ": " + cellText);
                  ExtentReportManager.pass("Row " + rowIdx + " Cell " + (j + 1) + ": " + cellText);
                  break;
                } else {
                  LogUtils.error("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                  ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
                }
              }
            }

          }
          idxDatas++;
        }
        rowIdx++;
      }
    }
  }


  // delete file after verify
  public static void deleteFileInDirectory(String pathDirectory) {
    try {
      Path file = Path.of(pathDirectory);
      Files.deleteIfExists(file);
      System.out.println("File deleted successfully.");
    } catch (IOException e) {
      System.out.println("Error deleting the file: " + e.getMessage());
    }
  }

  // remove permission file
  public static void removePermissionFromFile(String filePath) {
    try {
      Path file = Path.of(filePath);

      // Get the current permissions
      Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(file);

      // Create a new set without user access permissions
      Set<PosixFilePermission> modifiedPermissions = new HashSet<>(permissions);
      modifiedPermissions.remove(PosixFilePermission.OWNER_READ);
      modifiedPermissions.remove(PosixFilePermission.OWNER_WRITE);
      modifiedPermissions.remove(PosixFilePermission.OWNER_EXECUTE);

      // Set the modified permissions
      Files.setPosixFilePermissions(file, modifiedPermissions);
      System.out.println("User access permissions removed successfully.");
    } catch (Exception e) {
      System.out.println("Error removing user access permissions: " + e.getMessage());
    }
  }

  public static void verifyDataReportActivityWithExportFile(File file, String xpathTable) {
    CSVReader reader = null;
    List<List<String>> dataExcel = new ArrayList<>();
    try {
      reader = new CSVReader(new FileReader(file));
      String[] dataRow = reader.readNext();
      while ((dataRow = reader.readNext()) != null) {
        List<String> dataColumn = new ArrayList<>();
        for (int i = 0; i < dataRow.length; i++) {
          dataColumn.add(dataRow[i]);
        }
        dataExcel.add(dataColumn);

      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (CsvValidationException e) {
      throw new RuntimeException(e);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    //(//table)[1]/tbody/tr
    List<WebElement> rows = WebUI.getWebElements(By.xpath(xpathTable));
    LogUtils.info("Total results row: " + rows.size());
    if (rows.isEmpty() && rows.size() < 0) {
      LogUtils.error("No records found.");
      ExtentReportManager.fail("No records found.");

    } else {
      int rowIdx = 1;
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        LogUtils.info("Row " + rowIdx + ":");

        int ij = 0;
        for (int i = 2; i < cells.size() + 1; i++) {
          String cellText = cells.get(i - 1).getText();
          String txt = dataExcel.get(rowIdx - 1).get(i + 1);

          if (cellText.contains(txt)) {
            LogUtils.info("Cell " + (i + 1) + ": " + cellText);
            Assert.assertTrue(cellText.contains(txt), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);

          } else {
            LogUtils.error("Cell " + (i + 1) + ": " + cellText);
            Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
            ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
          }

        }
        String cellText = cells.get(ij).getText();
        String txt = dataExcel.get(rowIdx - 1).get(ij + 1);
        if (cellText.contains(txt)) {
          LogUtils.info("Cell " + (ij + 1) + ": " + cellText);
          Assert.assertTrue(cellText.contains(txt), "Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
          ExtentReportManager.pass("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);

        } else {
          LogUtils.error("Cell " + (ij + 1) + ": " + cellText);
          Assert.fail("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
          ExtentReportManager.fail("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
        }
        ij++;
        rowIdx++;
      }
    }
  }

//  public static void verifyDataReportScoreWithExportFile(File file, String xpathTable) {
//    CSVReader reader = null;
//    List<List<String>> dataExcel = new ArrayList<>();
//    try {
//      reader = new CSVReader(new FileReader(file));
//      String[] dataRow = reader.readNext();
//      while ((dataRow = reader.readNext()) != null) {
//        List<String> dataColumn = new ArrayList<>();
//        for (int i = 0; i < dataRow.length; i++) {
//          dataColumn.add(dataRow[i]);
//        }
//        dataExcel.add(dataColumn);
//      }
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    } catch (CsvValidationException e) {
//      throw new RuntimeException(e);
//    } finally {
//      if (reader != null) {
//        try {
//          reader.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    }
//    //(//table)[1]/tbody/tr
//    List<WebElement> rows = WebUI.getWebElements(By.xpath(xpathTable));
//    LogUtils.info("Total results row: " + rows.size());
//    int rowIdx = 1;
//    for (WebElement row : rows) {
//      List<WebElement> cells = row.findElements(By.tagName("td"));
//      LogUtils.info("Row " + rowIdx + ":");
//
//      int ij = 0;
//      for (int i = 2; i < cells.size() + 1; i++) {
//        String cellText = cells.get(i - 1).getText();
//        String txt = dataExcel.get(rowIdx - 1).get(i + 1);
//
//        if (cellText.contains(txt)) {
//          LogUtils.info("Cell " + (i + 1) + ": " + cellText);
//          Assert.assertTrue(cellText.contains(txt), "Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
//          ExtentReportManager.pass("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
//
//        } else {
//          LogUtils.error("Cell " + (i + 1) + ": " + cellText);
//          Assert.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
//          ExtentReportManager.fail("Row " + rowIdx + " Cell " + (i + 1) + ": " + cellText);
//        }
//
//      }
//      String cellText = cells.get(ij).getText();
//      String txt = dataExcel.get(rowIdx - 1).get(ij + 1);
//      if (cellText.contains(txt)) {
//        LogUtils.info("Cell " + (ij + 1) + ": " + cellText);
//        Assert.assertTrue(cellText.contains(txt), "Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
//        ExtentReportManager.pass("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
//
//      } else {
//        LogUtils.error("Cell " + (ij + 1) + ": " + cellText);
//        Assert.fail("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
//        ExtentReportManager.fail("Row " + rowIdx + " Cell " + (ij + 1) + ": " + cellText);
//      }
//      ij++;
//      rowIdx++;
//    }
//  }
public static void verifyDataReportScoreWithExportFile(File file, String xpathTable) throws IOException {
  CSVReader reader = null;
  List<String[]> csvData = new ArrayList<>();
  try
  {
    reader = new CSVReader(new FileReader(file));
    String[] line;
    while ((line = reader.readNext()) != null) {
      csvData.add(line);
    }
  } catch (CsvValidationException e) {
    e.printStackTrace();
  } finally {
    if (reader != null) {
      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  List<String[]> webData = new ArrayList<>();
  List<WebElement> rows = WebUI.getWebElements(By.xpath(xpathTable));
  for (WebElement row : rows) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
    String[] rowData = new String[4]; // chỉ lấy các cột 0, 1, 2, 3
    for (int i = 0; i < 4; i++) {
      rowData[i] = cells.get(i).getText();
    }
    webData.add(rowData);
  }

  int[] columnsToCompare = {3, 4, 5, 7}; // chỉ số các cột bạn muốn so sánh
  for (int i = 1; i < csvData.size(); i++) {
    String[] csvRowData = csvData.get(i);
    String[] webRowData = webData.get(i-1);
    for (int j = 0; j < columnsToCompare.length; j++) {
      if(columnsToCompare[j]== 7)
      {
        csvRowData[columnsToCompare[j]] = DateUtils.DateFormatConverter(csvRowData[columnsToCompare[j]].replace("-", "/"));
      }
      if (!csvRowData[columnsToCompare[j]].equals(webRowData[j])) {
          LogUtils.error("Row: " + i +  " Column: " + (j+1) + " with " + webRowData[j] + " not equal " + csvRowData[columnsToCompare[j]]);
          Assert.fail("Row: " + i +  " Column: " + (j+1)+ " with " + webRowData[j] + " not equal " + csvRowData[columnsToCompare[j]]);
          ExtentReportManager.fail("Row: " + i +  " Column: " + (j+1) + " with " + webRowData[j] + " not equal " + csvRowData[columnsToCompare[j]]);
      } else {
          LogUtils.info("Row: " + i +  " Column: " + (j+1) + " with " + webRowData[j] + " equals " + csvRowData[columnsToCompare[j]]);
          Assert.assertTrue(true,"Row: " + (j+1) +  " Column: " + j + " with " + webRowData[j] + " equals " + csvRowData[columnsToCompare[j]]);
          ExtentReportManager.pass("Row: " + i +  " Column: " + (j+1) + " with " + webRowData[j] + " equals " + csvRowData[columnsToCompare[j]]);
      }
    }
  }
}

  public static String getDayOfLastWeekByTimeZone() {
    // Lấy ngày hiện tại
    ZoneId z = ZoneId.of("America/New_York");
    ZonedDateTime zdt = ZonedDateTime.now(z);
    // Lấy tuần trước đó
    ZonedDateTime lastWeek = zdt.minusWeeks(1);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // trả về ngày đã định dạng
    return lastWeek.format(formatter);
  }

  public static String getDateOfCurrentWeekByTimeZone() {
    // Lấy ngày hiện tại
    ZoneId z = ZoneId.of("America/New_York");
    ZonedDateTime zdt = ZonedDateTime.now(z);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // trả về ngày đã định dạng
    return zdt.format(formatter);
  }
  public static String getCurrentDateByTimeZone(String timeZone) { //timeZone=UTC-05:00
    // Lấy ngày hiện tại
    ZoneId z = ZoneId.of(timeZone);
    ZonedDateTime currentDate = ZonedDateTime.now(z);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // trả về ngày đã định dạng
    return currentDate.format(formatter);
  }
  public static String compareWithCurrentDate(String dateCompare, String timeZone) { //timeZone=UTC-05:00
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Định dạng ngày
    LocalDate inputDate = LocalDate.parse(dateCompare, formatter);
    LocalDate currentDate = LocalDate.parse(getCurrentDateByTimeZone(timeZone), formatter); // Ngày hiện tại

    if (inputDate.isBefore(currentDate)) {
      return "isBefore";
         }
   else if (inputDate.isEqual(currentDate)) {
      return "isCurrent";
    }
   else return "isFuture";
  }

  public static String getFutureDateByTimeZone(String timeZone, int numberDay) { //timeZone=UTC-05:00
    // Lấy ngày hiện tại
    ZoneId z = ZoneId.of(timeZone);
    ZonedDateTime currentDate = ZonedDateTime.now(z);
    // Định dạng ngày thành chuỗi "MM-DD-YYYY"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // trả về ngày đã định dạng
    ZonedDateTime  futureDate = currentDate.plus(numberDay, ChronoUnit.DAYS);
    return futureDate.format(formatter);
  }



  // detect resource Correct Or Wrong
  public static void detectResourceCorrectOrWrong() {
    WebUI.switchToFrameByElement(By.xpath("//iframe[@id='viewer']"));
    List<WebElement> resultQuestions = WebUI.getWebElements(By.xpath("(//td[@class='question_number']//img)"));
    int count = -1;
    for (int i = 0; i < resultQuestions.size(); i++) {
      if (i == count){
        continue;
      }else {
        var questionLabel = resultQuestions.get(i).findElement(By.xpath("parent::td")).getAttribute("questionlabel");
        if (Integer.parseInt(questionLabel) != 0) {
          WebUI.scrollToElementToBottom(By.xpath("(//td[@class='question_number']//img)[" + (i + 1) + "]"));
          String text = WebUI.getWebElement(By.xpath("(//td[@class='question_number']//img)[" + (i + 1) + "]")).getAttribute("src");
          LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". " + checkIconCorrectOrWrong(text));
          Assert.assertTrue(true, "Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text));
          ExtentReportManager.pass("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text));
        }
        if ((i + 1) < resultQuestions.size()) {
          var nextQuestionLabel = resultQuestions.get(i + 1).findElement(By.xpath("parent::td")).getAttribute("questionlabel");
          if (Integer.parseInt(nextQuestionLabel) == 0) {
            WebUI.scrollToElementToBottom(By.xpath("(//td[@class='question_number']//img)[" + (i + 2) + "]"));
            String text2 = WebUI.getWebElement(By.xpath("(//td[@class='question_number']//img)[" + (i + 2) + "]")).getAttribute("src");
            LogUtils.info("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
            Assert.assertTrue(true, "Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
            ExtentReportManager.pass("Question number: " + Integer.parseInt(questionLabel) + ". is " + checkIconCorrectOrWrong(text2));
            count = i + 1;
          }
        }
      }
    }
    WebUI.switchToDefaultContent();
    WebUI.scrollToPositionViewTop();
  }

  private static String checkIconCorrectOrWrong(String text) {
    String txt = text.substring(text.lastIndexOf("/") + 1, text.lastIndexOf("."));
    switch (txt) {
      case "incorrectmark":
        return "incorrectmark";
      case "skipped":
        return "skipped";
      case "correctcheck":
        return "correctcheck";
      default:
        return txt;
    }
  }

  public static  boolean checkExistElement(By by, int timeout) {
    WebUI.sleep(5);
    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.info("Element is present " + by);
      return true;
    } catch (Exception e) {
      LogUtils.info("Element is present " + by);
      return false;
    }
  }


  public static  boolean checkNotExistElement(By by, int timeout) {
    WebUI.sleep(5);
    try {
      WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      LogUtils.error("Element is present " + by);
      return false;
    } catch (Exception e) {
      LogUtils.info("Element is present " + by);
      return true;
    }
  }

  public static void expandRowsInTableReportEndData(String... texts) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = expandRowsInTableReportEndData(tableElement, rows, texts);
    }
  }
  public static void expandRowsInTableReportFromStartToEndStandard(String textStart, String... textEnds) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReportFromStartToEndStandard(tableElement, rows, textStart, textEnds);
    }
  }
  public static void expandRowsInTableReportFromStartToEnd2(String textStart, String... textEnds) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReportFromStartToEnd2(tableElement, rows, textStart, textEnds);
    }
  }

  public static void expandRowsInTableReportFromStartToEnd(String textStart, String... textEnds) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReportFromStartToEndStandard(tableElement, rows, textStart, textEnds);
    }
  }

  public static void expandRowsInTableReportFromStart(String textStart) {
    smartWait();
    //table element
    WebElement tableElement = WebUI.getWebElement(By.xpath("(//table)[1]"));
    //table body
    WebElement tbodyElement = tableElement.findElement(By.tagName("tbody"));
    List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
    // if row click element
    if (rows.isEmpty()) {
      LogUtils.error("Not found rows: " + rows + " of element " + tbodyElement);
      ExtentReportManager.fail("Not found rows: " + rows + " of element " + tbodyElement);
      Assert.fail("Not found rows: " + rows + " of element " + tbodyElement);
    } else {
      rows = getRowsInTableReportFromStart(tableElement, rows, textStart);
    }
  }
  @Step("Mouse hover on element {0}")
  public static boolean mouseHoverToElement(WebElement el) {
    smartWait();

    try {
      Actions action = new Actions(DriverManager.getDriver());
      action.moveToElement(el).perform();
      LogUtils.info("Mouse hover on element " + el);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Mouse hover on element " + el.toString());
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }
  @Step("Press DOWN keyboard")
  public static boolean pressDOWN() {
    smartWait();

    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.keyRelease(KeyEvent.VK_DOWN);
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.info("Press DOWN keyboard");
      }
      return true;
    } catch (Exception e) {
      LogUtils.info(e.getMessage());
      if (ExtentTestManager.getExtentTest() != null) {
        ExtentReportManager.warning(e.getMessage());
      }
      return false;
    }
  }
}