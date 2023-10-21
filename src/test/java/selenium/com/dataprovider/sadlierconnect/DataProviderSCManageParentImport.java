
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCManageParentImport {

    private DataProviderSCManageParentImport() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getParentDataHashTable35")
    public static Object[][] getParentDataHashTable35() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH, "ManageParentImport", 1, 1);
        System.out.println("getParentDataHashTable35: " + data);
        return data;
    }

    @DataProvider(name = "getParentDataHashTable36")
    public static Object[][] getParentDataHashTable36() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH, "ManageParentImport", 2, 2);
        System.out.println("getParentDataHashTable36: " + data);
        return data;
    }

    @DataProvider(name = "getParentDataHashTable37")
    public static Object[][] getParentDataHashTable37() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH, "ManageParentImport", 3, 3);
        System.out.println("getParentDataHashTable37: " + data);
        return data;
    }

    @DataProvider(name = "getParentDataHashTable38")
    public static Object[][] getParentDataHashTable38() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_IMPORT_PARENT_SC_PATH, "ManageParentImport", 4, 4);
        System.out.println("getParentDataHashTable38: " + data);
        return data;
    }



}
