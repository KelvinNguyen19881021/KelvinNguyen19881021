
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

public final class DataProviderSCMyAccount {

    private DataProviderSCMyAccount() {
        super();
        PropertiesHelpers.loadAllFiles();
    }


    @DataProvider(name = "getMyAccountData_SC_001")
    public static Object[][] getMyAccountData_SC_001() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 1, 1);
        System.out.println("getMyAccountData_SC_001: " + dataMyAccount);
        return dataMyAccount;
    }

    @DataProvider(name = "getMyAccountData_SC_002")
    public static Object[][] getMyAccountData_SC_002() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 2, 2);
        System.out.println("getMyAccountData_SC_002: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_003")
    public static Object[][] getMyAccountData_SC_003() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 3, 3);
        System.out.println("getMyAccountData_SC_003: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_004")
    public static Object[][] getMyAccountData_SC_004() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 4, 4);
        System.out.println("getMyAccountData_SC_004: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_005")
    public static Object[][] getMyAccountData_SC_005() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 5, 5);
        System.out.println("getMyAccountData_SC_005: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_006")
    public static Object[][] getMyAccountData_SC_006() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 6, 6);
        System.out.println("getMyAccountData_SC_006: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_007")
    public static Object[][] getMyAccountData_SC_007() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 7, 7);
        System.out.println("getMyAccountData_SC_007: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_008")
    public static Object[][] getMyAccountData_SC_008() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 8, 8);
        System.out.println("getMyAccountData_SC_008: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_009")
    public static Object[][] getMyAccountData_SC_009() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 9, 9);
        System.out.println("getMyAccountData_SC_009: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_010")
    public static Object[][] getMyAccountData_SC_010() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 10, 10);
        System.out.println("getMyAccountData_SC_010: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_011")
    public static Object[][] getMyAccountData_SC_011() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 11, 11);
        System.out.println("getMyAccountData_SC_011: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_012")
    public static Object[][] getMyAccountData_SC_012() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 12, 12);
        System.out.println("getMyAccountData_SC_012: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_013")
    public static Object[][] getMyAccountData_SC_013() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 13, 13);
        System.out.println("getMyAccountData_SC_013: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_014")
    public static Object[][] getMyAccountData_SC_014() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 14, 14);
        System.out.println("getMyAccountData_SC_014: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getMyAccountData_SC_015")
    public static Object[][] getMyAccountData_SC_015() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_ACCOUNT_SC_PATH, "MyAccountSC", 15, 15);
        System.out.println("getMyAccountData_SC_015: " + dataMyAccount);
        return dataMyAccount;
    }

}
