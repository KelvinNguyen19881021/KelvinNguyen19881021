
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;

public final class DataProviderSCClassAssessmentReport {
    private final static ExcelHelpers excelHelpers = new ExcelHelpers();
    private DataProviderSCClassAssessmentReport() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable001")
    public static Object[][] getClassAssessmentReportDataHashTable001() {
        Object[][] getClassAssessmentReportData = getDataExcel(1, 1);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable002")
    public static Object[][] getClassAssessmentReportDataHashTable002() {
        Object[][] getClassAssessmentReportData = getDataExcel(2, 2);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable003")
    public static Object[][] getClassAssessmentReportDataHashTable003() {
        Object[][] getClassAssessmentReportData = getDataExcel(3, 3);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable004")
    public static Object[][] getClassAssessmentReportDataHashTable004() {
        Object[][] getClassAssessmentReportData = getDataExcel(4, 4);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable005")
    public static Object[][] getClassAssessmentReportDataHashTable005() {
        Object[][] getClassAssessmentReportData = getDataExcel(5, 5);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable006")
    public static Object[][] getClassAssessmentReportDataHashTable006() {
        Object[][] getClassAssessmentReportData = getDataExcel(6, 6);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable007")
    public static Object[][] getClassAssessmentReportDataHashTable007() {
        Object[][] getClassAssessmentReportData = getDataExcel(7, 7);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable008")
    public static Object[][] getClassAssessmentReportDataHashTable008() {
        Object[][] getClassAssessmentReportData = getDataExcel(8, 8);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable009")
    public static Object[][] getClassAssessmentReportDataHashTable009() {
        Object[][] getClassAssessmentReportData = getDataExcel(9, 9);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable010")
    public static Object[][] getClassAssessmentReportDataHashTable010() {
        Object[][] getClassAssessmentReportData = getDataExcel(10, 10);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable011")
    public static Object[][] getClassAssessmentReportDataHashTable011() {
        Object[][] getClassAssessmentReportData = getDataExcel(11, 11);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable012")
    public static Object[][] getClassAssessmentReportDataHashTable012() {
        Object[][] getClassAssessmentReportData = getDataExcel(12, 12);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable013")
    public static Object[][] getClassAssessmentReportDataHashTable013() {
        Object[][] getClassAssessmentReportData = getDataExcel(13, 13);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable014")
    public static Object[][] getClassAssessmentReportDataHashTable014() {
        Object[][] getClassAssessmentReportData = getDataExcel(14, 14);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable015")
    public static Object[][] getClassAssessmentReportDataHashTable015() {
        Object[][] getClassAssessmentReportData = getDataExcel(15, 15);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable016")
    public static Object[][] getClassAssessmentReportDataHashTable016() {
        Object[][] getClassAssessmentReportData = getDataExcel(16, 16);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }

    @DataProvider(name = "getClassAssessmentReportDataHashTable017")
    public static Object[][] getClassAssessmentReportDataHashTable017() {
        Object[][] getClassAssessmentReportData = getDataExcel(17, 17);
        System.out.println("getClassAssessmentReportData: " + Arrays.deepToString(getClassAssessmentReportData));
        return getClassAssessmentReportData;
    }




    private static Object[][] getDataExcel(int startRow, int endRow){
        return excelHelpers.getDataHashTable(Helpers.getCurrentDir() + PropertiesHelpers.getValue("EXCEL_DATA_FILE_CLASS_ASSESSMENT_REPORT_SC_PATH"),"ClassAssessmentReport", startRow, endRow);
    }

}
