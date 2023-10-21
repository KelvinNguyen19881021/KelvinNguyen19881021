
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCAssignmentJourney {

    private DataProviderSCAssignmentJourney() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getAssignmentJourney_Data_SC_001")
    public static Object[][] getAssignmentJourney_Data_SC_001() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 1, 1);
        System.out.println("getAssignmentJourney_Data_SC_001: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_002")
    public static Object[][] getAssignmentJourney_Data_SC_002() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 2, 2);
        System.out.println("getAssignmentJourney_Data_SC_002: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_003")
    public static Object[][] getAssignmentJourney_Data_SC_003() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 3, 3);
        System.out.println("getAssignmentJourney_Data_SC_003: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_004")
    public static Object[][] getAssignmentJourney_Data_SC_004() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 4, 4);
        System.out.println("getAssignmentJourney_Data_SC_004: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_005")
    public static Object[][] getAssignmentJourney_Data_SC_005() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 5, 5);
        System.out.println("getAssignmentJourney_Data_SC_005: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_006")
    public static Object[][] getAssignmentJourney_Data_SC_006() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 6, 6);
        System.out.println("getAssignmentJourney_Data_SC_006: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_007")
    public static Object[][] getAssignmentJourney_Data_SC_007() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 7, 7);
        System.out.println("getAssignmentJourney_Data_SC_007: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_008")
    public static Object[][] getAssignmentJourney_Data_SC_008() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 8, 8);
        System.out.println("getAssignmentJourney_Data_SC_008: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_009")
    public static Object[][] getAssignmentJourney_Data_SC_009() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 9, 9);
        System.out.println("getAssignmentJourney_Data_SC_009: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_010")
    public static Object[][] getAssignmentJourney_Data_SC_010() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 10, 10);
        System.out.println("getAssignmentJourney_Data_SC_010: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_011")
    public static Object[][] getAssignmentJourney_Data_SC_011() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 11, 11);
        System.out.println("getAssignmentJourney_Data_SC_011: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_012")
    public static Object[][] getAssignmentJourney_Data_SC_012() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 12, 12);
        System.out.println("getAssignmentJourney_Data_SC_012: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_013")
    public static Object[][] getAssignmentJourney_Data_SC_013() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 13, 13);
        System.out.println("getAssignmentJourney_Data_SC_013: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_014")
    public static Object[][] getAssignmentJourney_Data_SC_014() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 14, 14);
        System.out.println("getAssignmentJourney_Data_SC_014: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_015")
    public static Object[][] getAssignmentJourney_Data_SC_015() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 15, 15);
        System.out.println("getAssignmentJourney_Data_SC_015: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_016")
    public static Object[][] getAssignmentJourney_Data_SC_016() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 16, 16);
        System.out.println("getAssignmentJourney_Data_SC_016: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_017")
    public static Object[][] getAssignmentJourney_Data_SC_017() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 17, 17);
        System.out.println("getAssignmentJourney_Data_SC_017: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_018")
    public static Object[][] getAssignmentJourney_Data_SC_018() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 18, 18);
        System.out.println("getAssignmentJourney_Data_SC_018: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_019")
    public static Object[][] getAssignmentJourney_Data_SC_019() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 19, 19);
        System.out.println("getAssignmentJourney_Data_SC_019: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_020")
    public static Object[][] getAssignmentJourney_Data_SC_020() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 20, 20);
        System.out.println("getAssignmentJourney_Data_SC_020: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_021")
    public static Object[][] getAssignmentJourney_Data_SC_021() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 21, 21);
        System.out.println("getAssignmentJourney_Data_SC_021: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_022")
    public static Object[][] getAssignmentJourney_Data_SC_022() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 22, 22);
        System.out.println("getAssignmentJourney_Data_SC_022: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_023")
    public static Object[][] getAssignmentJourney_Data_SC_023() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 23, 23);
        System.out.println("getAssignmentJourney_Data_SC_023: " + dataMyAccount);
        return dataMyAccount;
    }

    @DataProvider(name = "getAssignmentJourney_Data_SC_024")
    public static Object[][] getAssignmentJourney_Data_SC_024() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 24, 24);
        System.out.println("getAssignmentJourney_Data_SC_024: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_025")
    public static Object[][] getAssignmentJourney_Data_SC_025() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 25, 25);
        System.out.println("getAssignmentJourney_Data_SC_025: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_026")
    public static Object[][] getAssignmentJourney_Data_SC_026() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 26, 26);
        System.out.println("getAssignmentJourney_Data_SC_026: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_027")
    public static Object[][] getAssignmentJourney_Data_SC_027() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 27, 27);
        System.out.println("getAssignmentJourney_Data_SC_027: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_028")
    public static Object[][] getAssignmentJourney_Data_SC_028() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 28, 28);
        System.out.println("getAssignmentJourney_Data_SC_028: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_029")
    public static Object[][] getAssignmentJourney_Data_SC_029() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 29, 29);
        System.out.println("getAssignmentJourney_Data_SC_029: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_030")
    public static Object[][] getAssignmentJourney_Data_SC_030() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 30, 30);
        System.out.println("getAssignmentJourney_Data_SC_030: " + dataMyAccount);
        return dataMyAccount;
    }
    @DataProvider(name = "getAssignmentJourney_Data_SC_031")
    public static Object[][] getAssignmentJourney_Data_SC_031() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataMyAccount = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_JOURNEY_SC_PATH, "CreateAssignment", 31, 31);
        System.out.println("getAssignmentJourney_Data_SC_031: " + dataMyAccount);
        return dataMyAccount;
    }


}
