
package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

public final class DataProviderSCMessageStudent {

    private DataProviderSCMessageStudent() {
        super();
        PropertiesHelpers.loadAllFiles();
    }


    @DataProvider(name = "getMessageStudentDataHashTable01")
    public static Object[][] getMessageStudentDataHashTable01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 1, 1);
        System.out.println("getMessageStudentDataHashTable01: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable03")
    public static Object[][] getMessageStudentDataHashTable03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 3, 3);
        System.out.println("getMessageStudentDataHashTable03: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable05")
    public static Object[][] getMessageStudentDataHashTable05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 5, 5);
        System.out.println("getMessageStudentDataHashTable05: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable06")
    public static Object[][] getMessageStudentDataHashTable06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 6, 6);
        System.out.println("getMessageStudentDataHashTable06: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable07")
    public static Object[][] getMessageStudentDataHashTable07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 7, 7);
        System.out.println("getMessageStudentDataHashTable07: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable08")
    public static Object[][] getMessageStudentDataHashTable08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 8, 8);
        System.out.println("getMessageStudentDataHashTable08: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable09")
    public static Object[][] getMessageStudentDataHashTable9() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 9, 9);
        System.out.println("getMessageStudentDataHashTable9: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable10")
    public static Object[][] getMessageStudentDataHashTable10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 10, 10);
        System.out.println("getMessageStudentDataHashTable10: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable13")
    public static Object[][] getMessageStudentDataHashTable13() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 13, 13);
        System.out.println("getMessageStudentDataHashTable13: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable16")
    public static Object[][] getMessageStudentDataHashTable16() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 16, 16);
        System.out.println("getMessageStudentDataHashTable16: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable17")
    public static Object[][] getMessageStudentDataHashTable17() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 17, 17);
        System.out.println("getMessageStudentDataHashTable17: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable18")
    public static Object[][] getMessageStudentDataHashTable18() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 18, 18);
        System.out.println("getMessageStudentDataHashTable18: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable26")
    public static Object[][] getMessageStudentDataHashTable26() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 26, 26);
        System.out.println("getMessageStudentDataHashTable26: " + data);
        return data;
    }

    @DataProvider(name = "getMessageStudentDataHashTable27")
    public static Object[][] getMessageStudentDataHashTable27() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent", 27, 27);
        System.out.println("getMessageStudentDataHashTable27: " + data);
        return data;
    }


}
