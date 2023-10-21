package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

public class DataProviderSCFullAccessSearch {
    private DataProviderSCFullAccessSearch() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getContentDataHashTable")
    public static Object[][] getContentDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataContent = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Content", 1, 1);
        System.out.println("getContentDataHashTable02: " + dataContent);
        return dataContent;
    }


    @DataProvider(name = "getStandardSetDataHashTable")
    public static Object[][] getStandardSetDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataStandardSet = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "StandardSet", 1, 1);
        System.out.println("getContentDataHashTable: " + dataStandardSet);
        return dataStandardSet;
    }
    @DataProvider(name = "getProgramSetDataHashTable")
    public static Object[][] getProgramDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataprogram = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_SEARCH_SC_PATH, "Program", 1, 1);
        System.out.println("getContentDataHashTable: " + dataprogram);
        return dataprogram;
    }

}
