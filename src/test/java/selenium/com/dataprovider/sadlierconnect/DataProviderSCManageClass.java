
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCManageClass {

    private DataProviderSCManageClass() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getMyClassData_SC_001")
    public static Object[][] getMyClassData_SC_001() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 1, 1);
        System.out.println("getMyClassData_SC_001: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_003")
    public static Object[][] getMyClassData_SC_003() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 3, 3);
        System.out.println("getMyClassData_SC_003: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_004")
    public static Object[][] getMyClassData_SC_004() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 4, 4);
        System.out.println("getMyClassData_SC_004: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_005")
    public static Object[][] getMyClassData_SC_005() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 5, 5);
        System.out.println("getMyClassData_SC_005: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_006")
    public static Object[][] getMyClassData_SC_006() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 6, 6);
        System.out.println("getMyClassData_SC_006: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_007")
    public static Object[][] getMyClassData_SC_007() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 7, 7);
        System.out.println("getMyClassData_SC_007: " + dataMyAccount);
        return dataMyAccount;
    }

    @DataProvider(name = "getMyClassData_SC_008")
    public static Object[][] getMyClassData_SC_008() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 8, 8);
        System.out.println("getMyClassData_SC_008: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_009")
    public static Object[][] getMyClassData_SC_009() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 9, 9);
        System.out.println("getMyClassData_SC_009: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_010")
    public static Object[][] getMyClassData_SC_010() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 10, 10);
        System.out.println("getMyClassData_SC_010: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_011")
    public static Object[][] getMyClassData_SC_011() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 11, 11);
        System.out.println("getMyClassData_SC_011: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_012")
    public static Object[][] getMyClassData_SC_012() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 1, 1);
        System.out.println("getMyClassData_SC_012: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_013")
    public static Object[][] getMyClassData_SC_013() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 2, 2);
        System.out.println("getMyClassData_SC_013: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_014")
    public static Object[][] getMyClassData_SC_014() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 3, 3);
        System.out.println("getMyClassData_SC_014: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_015")
    public static Object[][] getMyClassData_SC_015() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 4, 4);
        System.out.println("getMyClassData_SC_015: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_016")
    public static Object[][] getMyClassData_SC_016() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 5, 5);
        System.out.println("getMyClassData_SC_016: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_017")
    public static Object[][] getMyClassData_SC_017() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 6, 6);
        System.out.println("getMyClassData_SC_017: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_018")
    public static Object[][] getMyClassData_SC_018() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 7, 7);
        System.out.println("getMyClassData_SC_018: " + dataMyAccount);
        return dataMyAccount;
    }

    @DataProvider(name = "getMyClassData_SC_019")
    public static Object[][] getMyClassData_SC_019() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyGroupInClassSC", 8, 8);
        System.out.println("getMyClassData_SC_019: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_020")
    public static Object[][] getMyClassData_SC_020() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "ManageLicense", 1, 1);
        System.out.println("getMyClassData_SC_020: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_021")
    public static Object[][] getMyClassData_SC_021() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "ManageLicense", 2, 2);
        System.out.println("getMyClassData_SC_021: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_022")
    public static Object[][] getMyClassData_SC_022() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "ManageLicense", 3, 3);
        System.out.println("getMyClassData_SC_022: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_023")
    public static Object[][] getMyClassData_SC_023() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 12, 12);
        System.out.println("getMyClassData_SC_023: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_024")
    public static Object[][] getMyClassData_SC_024() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 13, 13);
        System.out.println("getMyClassData_SC_024: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_025")
    public static Object[][] getMyClassData_SC_025() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 13, 13);
        System.out.println("getMyClassData_SC_025: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_032")
    public static Object[][] getMyClassData_SC_032() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "SendMessage", 1, 1);
        System.out.println("getMyClassData_SC_032: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_033")
    public static Object[][] getMyClassData_SC_033() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "SendMessage", 2, 2);
        System.out.println("getMyClassData_SC_033: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_034")
    public static Object[][] getMyClassData_SC_034() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 14, 14);
        System.out.println("getMyClassData_SC_034: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_035")
    public static Object[][] getMyClassData_SC_035() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 15, 15);
        System.out.println("getMyClassData_SC_035: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyClassData_SC_036")
    public static Object[][] getMyClassData_SC_036() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_CLASS_SC_PATH, "MyClassSC", 16, 16);
        System.out.println("getMyClassData_SC_036: " + dataMyAccount);
        return dataMyAccount;
    }




}
