
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCStudentTrackingReport {

    private DataProviderSCStudentTrackingReport() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable01")
    public static Object[][] getStudentTrackingReportDataHashTable01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 1, 1);
        System.out.println("getStudentTrackingReportDataHashTable01: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable02")
    public static Object[][] getStudentTrackingReportDataHashTable02() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 2, 2);
        System.out.println("getStudentTrackingReportDataHashTable02: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable03")
    public static Object[][] getStudentTrackingReportDataHashTable03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 3, 3);
        System.out.println("getStudentTrackingReportDataHashTable03: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable04")
    public static Object[][] getStudentTrackingReportDataHashTable04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 4, 4);
        System.out.println("getStudentTrackingReportDataHashTable04: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable05")
    public static Object[][] getStudentTrackingReportDataHashTable05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 5, 5);
        System.out.println("getStudentTrackingReportDataHashTable05: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable06")
    public static Object[][] getStudentTrackingReportDataHashTable06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 6, 6);
        System.out.println("getStudentTrackingReportDataHashTable06: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable07")
    public static Object[][] getStudentTrackingReportDataHashTable07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 7, 7);
        System.out.println("getStudentTrackingReportDataHashTable07: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable08")
    public static Object[][] getStudentTrackingReportDataHashTable08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 8, 8);
        System.out.println("getStudentTrackingReportDataHashTable08: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable09")
    public static Object[][] getStudentTrackingReportDataHashTable09() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 9, 9);
        System.out.println("getStudentTrackingReportDataHashTable09: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable10")
    public static Object[][] getStudentTrackingReportDataHashTable10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 10, 10);
        System.out.println("getStudentTrackingReportDataHashTable10: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable11")
    public static Object[][] getStudentTrackingReportDataHashTable11() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 11, 11);
        System.out.println("getStudentTrackingReportDataHashTable11: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable12")
    public static Object[][] getStudentTrackingReportDataHashTable12() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 12, 12);
        System.out.println("getStudentTrackingReportDataHashTable12: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable13")
    public static Object[][] getStudentTrackingReportDataHashTable13() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 13, 13);
        System.out.println("getStudentTrackingReportDataHashTable13: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable14")
    public static Object[][] getStudentTrackingReportDataHashTable14() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 14, 14);
        System.out.println("getStudentTrackingReportDataHashTable14: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable15")
    public static Object[][] getStudentTrackingReportDataHashTable15() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 15, 15);
        System.out.println("getStudentTrackingReportDataHashTable15: " + data);
        return data;
    }

    @DataProvider(name = "getStudentTrackingReportDataHashTable16")
    public static Object[][] getStudentTrackingReportDataHashTable16() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TRACKING_REPORT_SC_PATH, "studentTrackingReport", 16, 16);
        System.out.println("getStudentTrackingReportDataHashTable16: " + data);
        return data;
    }

}
