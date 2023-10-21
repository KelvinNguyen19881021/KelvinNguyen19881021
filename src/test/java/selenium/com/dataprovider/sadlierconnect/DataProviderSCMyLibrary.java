
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;

public final class DataProviderSCMyLibrary {

    private DataProviderSCMyLibrary() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getResourcesDataHashTable")
    public static Object[][] getStudentLoginInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] resourceMyLibraryData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MY_LIBRARY_SC_PATH, "Resource", 1, 1);
        System.out.println("getResourcesDataHashTable: " + Arrays.deepToString(resourceMyLibraryData));
        return resourceMyLibraryData;
    }



}
