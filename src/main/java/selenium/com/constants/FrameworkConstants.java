
package selenium.com.constants;

import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;
import selenium.com.utils.ReportUtils;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static final String PROJECT_PATH = Helpers.getCurrentDir();
    public static final String EXCEL_DATA_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");
    public static final String JSON_DATA_FILE_PATH = PropertiesHelpers.getValue("JSON_DATA_FILE_PATH");
    public static final String EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT = PropertiesHelpers.getValue("EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT");
    public static final String EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH");
    public static final String EXCEL_DATA_FILE_MY_CLASS_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MY_CLASS_SC_PATH");
    public static final String EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH");
    public static final String EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH");
    public static final String EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_NONISE_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_NONISE_SC_PATH");
    public static final String EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH");
    public static final String EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH");
    public static final String EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH");
    public static final String EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MANAGE_STUDENT_SC_PATH");
    public static final String EXCEL_DATA_FILE_CLASS_ASSESSMENT_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_CLASS_ASSESSMENT_REPORT_SC_PATH");
    public static final String EXCEL_DATA_FILE_CLASS_PROFICIENCY_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_CLASS_PROFICIENCY_REPORT_SC_PATH");
    public static final String EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH");
    public static final String EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH");
    public static final String EXCEL_DATA_FILE_MY_LIBRARY_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MY_LIBRARY_SC_PATH");

    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String URL_SADLIERCONNECT_ADMIN = PropertiesHelpers.getValue("URL_SADLIERCONNECT_ADMIN");
    public static final String URL_SADLIERCONNECT_USER_REPORT = PropertiesHelpers.getValue("URL_SADLIERCONNECT_USER_REPORT");
    public static final String URL_SADLIERCONNECT_USER = PropertiesHelpers.getValue("URL_SADLIERCONNECT_USER");
    public static final String URL_SADLIERCONNECT_USER_FA = PropertiesHelpers.getValue("URL_SADLIERCONNECT_USER_FA");
    public static final String URL_SADLIERCONNECT_USER_NO_REPORT = PropertiesHelpers.getValue("URL_SADLIERCONNECT_USER_NO_REPORT");
    public static final String URL_SADLIERCONNECT_FILTER_SETTING = PropertiesHelpers.getValue("URL_SADLIERCONNECT_FILTER_SETTING");
    public static final String REMOTE_URL = PropertiesHelpers.getValue("REMOTE_URL");
    public static final String REMOTE_PORT = PropertiesHelpers.getValue("REMOTE_PORT");
    public static final String PROJECT_NAME = PropertiesHelpers.getValue("PROJECT_NAME");
    public static final String REPORT_TITLE = PropertiesHelpers.getValue("REPORT_TITLE");
    public static final String EXTENT_REPORT_NAME = PropertiesHelpers.getValue("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FOLDER = PropertiesHelpers.getValue("EXTENT_REPORT_FOLDER");
    public static final String EXPORT_VIDEO_PATH = PropertiesHelpers.getValue("EXPORT_VIDEO_PATH");
    public static final String EXPORT_CAPTURE_PATH = PropertiesHelpers.getValue("EXPORT_CAPTURE_PATH");
    public static final String AUTHOR = PropertiesHelpers.getValue("AUTHOR");
    public static final String TARGET = PropertiesHelpers.getValue("TARGET");
    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
    public static final String OVERRIDE_REPORTS = PropertiesHelpers.getValue("OVERRIDE_REPORTS");
    public static final String OPEN_REPORTS_AFTER_EXECUTION = PropertiesHelpers.getValue("OPEN_REPORTS_AFTER_EXECUTION");
    public static final String SEND_EMAIL_TO_USERS = PropertiesHelpers.getValue("SEND_EMAIL_TO_USERS");
    public static final String SCREENSHOT_PASSED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_PASSED_STEPS");
    public static final String SCREENSHOT_FAILED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_FAILED_STEPS");
    public static final String SCREENSHOT_SKIPPED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_SKIPPED_STEPS");
    public static final String SCREENSHOT_ALL_STEPS = PropertiesHelpers.getValue("SCREENSHOT_ALL_STEPS");
    public static final String ZIP_FOLDER = PropertiesHelpers.getValue("ZIP_FOLDER");
    public static final String ZIP_FOLDER_PATH = PropertiesHelpers.getValue("ZIP_FOLDER_PATH");
    public static final String ZIP_FOLDER_NAME = PropertiesHelpers.getValue("ZIP_FOLDER_NAME");
    public static final String VIDEO_RECORD = PropertiesHelpers.getValue("VIDEO_RECORD");

    public static final String EXCEL_DATA_FILE_FA_RECOMMENDED_RESOURCE_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_FULLACCESS_RECOMMENDED_RESOURCE_SC_PATH");
    public static final String EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH");

    public static final String EXCEL_DATA_FILE_FULLACCESS_RECOMMENDED_RESOURCE_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_FULLACCESS_RECOMMENDED_RESOURCE_SC_PATH");

    public static final String LOCATE = PropertiesHelpers.getValue("LOCATE");
    public static final String RETRY_TEST_FAIL = PropertiesHelpers.getValue("RETRY_TEST_FAIL");

    public static final int WAIT_DEFAULT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_DEFAULT"));
    public static final int WAIT_IMPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_IMPLICIT"));
    public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
    public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
    public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
    public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");
    public static final String EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_MESSAGE_TEACHER_SC_PATH");

    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;

    //Zip file for Report folder
    public static final String ZIPPED_EXTENT_REPORTS_FOLDER = EXTENT_REPORT_FOLDER + ".zip";

    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String YES_OPTION = "Yes";
    public static final String NO_OPTION = "No";
    public static final String FORMAT_USER_NAME = "Value contains illegal characters.";
    public static final String REQUIRED_MESSAGE = "This field is required.";
    public static final String DUP_CLASS_NAME_MESSAGE = "Class Name is duplicated.";
    public static final String USED_USER_NAME = "This username is being used by another user. Please try again.";
    public static final String FORMAT_EMAIL = "Please enter a valid email address.";
    public static final String USED_EMAIL = "This email address is being used by another user. Please try again.";
    public static final String COMPARE_USED_EMAIL = "This email address is being used by another user.";
    public static final String COMPARE_USED_USER_NAME = "This username is being used by another user.";


    public static final String BOLD_START = "<b>";
    public static final String BOLD_END = "</b>";

    /* ICONS - START */

    public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
    public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
    public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";

    public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
    public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
    public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";

    public static final String ICON_BROWSER_OPERA = "<i class=\"fa fa-opera\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_EDGE = "<i class=\"fa fa-edge\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_CHROME = "<i class=\"fa fa-chrome\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_FIREFOX = "<i class=\"fa fa-firefox\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_SAFARI = "<i class=\"fa fa-safari\" aria-hidden=\"true\"></i>";

    public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
    public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
    /* style="text-align:center;" */



    public static final String ICON_CAMERA = "<i class=\"fa fa-camera\" aria-hidden=\"true\"></i>";

    public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
    public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
    /* ICONS - END */

    public static String getExtentReportFilePath() {
        if (EXTENT_REPORT_FILE_PATH.isEmpty()) {
            EXTENT_REPORT_FILE_PATH = ReportUtils.createExtentReportPath();
        }
        return EXTENT_REPORT_FILE_PATH;
    }
    public static final String EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH");
    public static final String EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH");
    public static final String EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH");





    public static final String EXCEL_DATA_FILE_ASSIGNMENT_FILTER_STATUS_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_ASSIGNMENT_FILTER_STATUS_SC_PATH");

    public static final String EXCEL_DATA_FILE_ASSIGNMENT_SETTING_SC_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_ASSIGNMENT_SETTING_SC_PATH");

}