
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

public final class DataProviderSCFullAccessReportLG {

    private DataProviderSCFullAccessReportLG() {
        super();
        PropertiesHelpers.loadAllFiles();
    }


    @DataProvider(name = "getFullAccessReportLGDataHashTable03")
    public static Object[][] getFullAccessReportLGDataHashTable03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH, "FALearningGroup", 3, 3);
        System.out.println("getFullAccessReportLGDataHashTable03: " + data);
        return data;
    }

    @DataProvider(name = "getFullAccessReportLGDataHashTable04")
    public static Object[][] getFullAccessReportLGDataHashTable04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH, "FALearningGroup", 4, 4);
        System.out.println("getFullAccessReportLGDataHashTable04: " + data);
        return data;
    }

    @DataProvider(name = "getFullAccessReportLGDataHashTable05")
    public static Object[][] getFullAccessReportLGDataHashTable05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_FULLACCESS_LEARNING_GROUP_SC_PATH, "FALearningGroup", 5, 5);
        System.out.println("getFullAccessReportLGDataHashTable05: " + data);
        return data;
    }

}
