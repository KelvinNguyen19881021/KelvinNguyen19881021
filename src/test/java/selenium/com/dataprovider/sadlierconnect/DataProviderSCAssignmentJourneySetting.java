
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCAssignmentJourneySetting {

    private DataProviderSCAssignmentJourneySetting() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getAssignmentSettingHashTable01")
    public static Object[][] getAssignmentSettingHashTable01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_SETTING_SC_PATH, "Setting", 1, 1);
        System.out.println("getAssignmentSettingHashTable01: " + data);
        return data;
    }
}
