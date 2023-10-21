
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

import java.util.Arrays;

public final class DataProviderSCLogin {

    private DataProviderSCLogin() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "getStudentLoginDataHashTable")
    public static Object[][] getStudentLoginInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] studentUserData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 1, 1);
        System.out.println("getStudentLoginDataHashTable: " + Arrays.deepToString(studentUserData));
        return studentUserData;
    }

    @DataProvider(name = "getTeacherLoginDataHashTable")
    public static Object[][] getTeachertLoginInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] teacherUserData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 2, 2);
        System.out.println("getTeacherLoginDataHashTable: " + Arrays.deepToString(teacherUserData));
        return teacherUserData;
    }


    @DataProvider(name = "getSignInDataHashTable", parallel = true)
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn", 1, 2);
        System.out.println("getSignInData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getClientDataHashTable", parallel = true)
    public static Object[][] getClientData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Client", 1, 2);
        System.out.println("getClientData: " + Arrays.deepToString(data));
        return data;
    }

    @DataProvider(name = "getUsersLoginDataHashTable")
    public static Object[][] getUsersLoginDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] studentUserData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 2, 2);
        System.out.println("getUsersLoginDataHashTable: " + Arrays.deepToString(studentUserData));
        return studentUserData;
    }
    @DataProvider(name = "getUsersFALoginDataHashTable")
    public static Object[][] getUsersFALoginDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] studentUserData = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "LoginFA", 1, 1);
        System.out.println("getUsersLoginDataHashTable: " + Arrays.deepToString(studentUserData));
        return studentUserData;
    }

}
