package selenium.com.dataprovider.sadlierconnect;

import java.util.Arrays;
import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

/**
 * @author : tien.vo-ngoc
 * @created : Sep, 14 2023
 **/
public class DataProviderSCFullAccess {

    private DataProviderSCFullAccess() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getSCFullAccessDataHashTable01")
    public static Object[][] getClientData01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 1, 1);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable02")
    public static Object[][] getClientData02() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 2, 2);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable03")
    public static Object[][] getClientData03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 3, 3);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable04")
    public static Object[][] getClientData04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 4, 4);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable05")
    public static Object[][] getClientData05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 5, 5);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable06")
    public static Object[][] getClientData06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
                Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 6, 6);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable09")
    public static Object[][] getClientData09() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
                Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 7, 7);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFullAccessDataHashTable10")
    public static Object[][] getClientData10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
                Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "LicenseImport", 8, 8);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

//    @DataProvider(name = "getSCFAReportDataHashTable01")
//    public static Object[][] getClientData06() {
//        ExcelHelpers excelHelpers = new ExcelHelpers();
//        Object[][] data = excelHelpers.getDataHashTable(
//            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "Report", 1, 3);
//        System.out.println("getClientData: " + Arrays.deepToString(data));
//        return data;
//    }

    @DataProvider(name = "getSCFAReportDataHashTable02")
    public static Object[][] getClientData07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "Report", 4, 4);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getSCFAReportDataHashTable03")
    public static Object[][] getClientData08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(
            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "Report", 5, 5);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

//    @DataProvider(name = "getSCFAReportDataHashTable04")
//    public static Object[][] getClientData09() {
//        ExcelHelpers excelHelpers = new ExcelHelpers();
//        Object[][] data = excelHelpers.getDataHashTable(
//            Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULL_ACCESS_SC_PATH, "Report", 6, 6);
//        System.out.println("getClientData: " + Arrays.deepToString(data));
//        return data;
//    }

}
