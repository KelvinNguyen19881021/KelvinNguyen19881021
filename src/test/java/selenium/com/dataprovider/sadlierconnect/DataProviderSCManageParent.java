
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;

public final class DataProviderSCManageParent {

    private DataProviderSCManageParent() {
        super();
        PropertiesHelpers.loadAllFiles();
    }



    @DataProvider(name = "getParentDataHashTable01")
    public static Object[][] getClientData01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 1, 1);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getParentDataHashTable02")
    public static Object[][] getClientData02() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 2, 2);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getParentDataHashTable03")
    public static Object[][] getClientData03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 3, 3);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable04")
    public static Object[][] getClientData04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 4, 4);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable05")
    public static Object[][] getClientData05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 5, 5);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable06")
    public static Object[][] getClientData06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 6, 6);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable07")
    public static Object[][] getClientData07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 7, 7);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable08")
    public static Object[][] getClientData08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 8, 8);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable09")
    public static Object[][] getClientData09() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 9, 9);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable10")
    public static Object[][] getClientData10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 10, 10);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable11")
    public static Object[][] getClientData11() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 11, 11);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable12")
    public static Object[][] getClientData12() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 12, 12);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable13")
    public static Object[][] getClientData13() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 13, 13);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }  @DataProvider(name = "getParentDataHashTable14")
    public static Object[][] getClientData14() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 14, 14);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable15")
    public static Object[][] getClientData15() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 15, 15);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable16")
    public static Object[][] getClientData16() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 16, 16);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable17")
    public static Object[][] getClientData17() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 17, 17);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }  @DataProvider(name = "getParentDataHashTable18")
    public static Object[][] getClientData18() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 18, 18);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable19")
    public static Object[][] getClientData19() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 19, 19);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable20")
    public static Object[][] getClientData20() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 20, 20);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable21")
    public static Object[][] getClientData21() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 21, 21);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable22")
    public static Object[][] getClientData22() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 22, 22);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable23")
    public static Object[][] getClientData23() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 23, 23);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable24")
    public static Object[][] getClientData24() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 24, 24);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable25")
    public static Object[][] getClientData25() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 25, 25);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable26")
    public static Object[][] getClientData26() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 26, 26);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable27")
    public static Object[][] getClientData27() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 27, 27);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable28")
    public static Object[][] getClientData28() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 28, 28);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable29")
    public static Object[][] getClientData29() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 29, 29);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable30")
    public static Object[][] getClientData30() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 30, 30);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable31")
    public static Object[][] getClientData31() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 31, 31);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable32")
    public static Object[][] getClientData32() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 32, 32);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }
    @DataProvider(name = "getParentDataHashTable33")
    public static Object[][] getClientData33() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 33, 33);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }


    @DataProvider(name = "getParentDataHashTable34")
    public static Object[][] getClientData34() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MANAGER_PARENT_SC_PATH, "ManageParent", 34, 34);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

}
