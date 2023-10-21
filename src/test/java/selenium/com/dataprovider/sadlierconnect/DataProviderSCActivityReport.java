package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;

public final class DataProviderSCActivityReport {
    private DataProviderSCActivityReport() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getReportDataHashTable1")
    public static Object[][] getActivityReportData1() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 1, 1);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable2")
    public static Object[][] getActivityReportData2() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 2, 2);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable3")
    public static Object[][] getActivityReportData3() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 3, 3);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable4")
    public static Object[][] getActivityReportData4() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 4, 4);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable5")
    public static Object[][] getActivityReportData5() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 9, 9);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable6")
    public static Object[][] getActivityReportData6() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 14, 14);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable7")
    public static Object[][] getActivityReportData7() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 19, 19);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable8")
    public static Object[][] getActivityReportData8() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 24, 24);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable9")
    public static Object[][] getActivityReportData9() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 25, 25);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable10")
    public static Object[][] getActivityReportData10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 26, 26);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable11")
    public static Object[][] getActivityReportData11() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 27, 27);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable12")
    public static Object[][] getActivityReportData12() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 28, 28);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable13")
    public static Object[][] getActivityReportData13() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 29, 29);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable14")
    public static Object[][] getActivityReportData14() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 30, 30);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable15")
    public static Object[][] getActivityReportData15() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 32, 32);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable16")
    public static Object[][] getActivityReportData16() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 35, 35);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable17")
    public static Object[][] getActivityReportData17() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 38, 38);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable18")
    public static Object[][] getActivityReportData18() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 39, 39);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable19")
    public static Object[][] getActivityReportData19() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 41, 41);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable20")
    public static Object[][] getActivityReportData20() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 43, 43);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable21")
    public static Object[][] getActivityReportData21() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 44, 44);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable22")
    public static Object[][] getActivityReportData22() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 45, 45);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable23")
    public static Object[][] getActivityReportData23() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 47, 47);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable24")
    public static Object[][] getActivityReportData24() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 49, 49);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable25")
    public static Object[][] getActivityReportData25() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 54, 54);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable26")
    public static Object[][] getActivityReportData26() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 56, 56);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable27")
    public static Object[][] getActivityReportData27() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 57, 57);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }

    @DataProvider(name = "getReportDataHashTable28")
    public static Object[][] getActivityReportData28() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] activityReportData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ACTIVITY_REPORT_SC_PATH, "ActivityReport", 58, 58);
        System.out.println("getActivityReportData: " + Arrays.deepToString(activityReportData));
        return activityReportData;
    }
}
