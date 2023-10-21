
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public final class DataProviderSCAssignmentJourneyFilterStatus {

    private DataProviderSCAssignmentJourneyFilterStatus() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getAssignmentFilterStatusHashTable01")
    public static Object[][] getAssignmentFilterStatusHashTable01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_ASSIGNMENT_FILTER_STATUS_SC_PATH, "Filter_Status", 1, 1);
        System.out.println("getAssignmentFilterStatusHashTable01: " + data);
        return data;
    }
}
