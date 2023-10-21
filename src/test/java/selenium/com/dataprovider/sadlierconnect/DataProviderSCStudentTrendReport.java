
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;


public final class DataProviderSCStudentTrendReport {

    private DataProviderSCStudentTrendReport() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getStudentTrendReportDataHashTable04")
    public static Object[][] getStudentTrackingReportDataHashTable04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 1, 1);
        System.out.println("getStudentTrendReportDataHashTable04: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getStudentTrendReportDataHashTable05")
    public static Object[][] getStudentTrendReportDataHashTable05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 2, 2);
        System.out.println("getStudentTrendReportDataHashTable05: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getStudentTrendReportDataHashTable06")
    public static Object[][] getStudentTrendReportDataHashTable06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 3, 3);
        System.out.println("getStudentTrendReportDataHashTable06: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getStudentTrendReportDataHashTable07")
    public static Object[][] getStudentTrendReportDataHashTable07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 4, 4);
        System.out.println("getStudentTrendReportDataHashTable07: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getStudentTrendReportDataHashTable08")
    public static Object[][] getStudentTrendReportDataHashTable08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 5, 5);
        System.out.println("getStudentTrendReportDataHashTable08: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getStudentTrendReportDataHashTable09")
    public static Object[][] getStudentTrendReportDataHashTable09() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_TREND_REPORT_SC_PATH, "StudentTrendReport", 6, 6);        System.out.println("getStudentTrendReportDataHashTable09: " + Arrays.deepToString(data));
        System.out.println("getStudentTrendReportDataHashTable09: " + Arrays.deepToString(data));
        return data;
    }

}
