package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;

public final class DataProviderSCMessageTeacher {
    private DataProviderSCMessageTeacher() {
        super();
        PropertiesHelpers.loadAllFiles();
    }
    @DataProvider(name = "getTO_CCfieldDataHashTable")
    public static Object[][] getTO_CCfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataTO_CC = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 1, 1);
        System.out.println("getTOfieldDataHashTable: " + dataTO_CC);
        return dataTO_CC;
    }
    @DataProvider(name = "getSubjectfieldDataHashTable")
    public static Object[][] getSubjectfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataSubject = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 2, 2);
        System.out.println("getSubjectfieldDataHashTable: " + dataSubject);
        return dataSubject;
    }
    @DataProvider(name = "getcontentBfieldDataHashTable")
    public static Object[][] getcontentBfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataContentB = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 3, 3);
        System.out.println("getSubjectfieldDataHashTable: " + dataContentB);
        return dataContentB;
    }
    @DataProvider(name = "getcontentIfieldDataHashTable")
    public static Object[][] getcontentIfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataContentI = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 4, 4);
        System.out.println("getSubjectfieldDataHashTable: " + dataContentI);
        return dataContentI;
    }
    @DataProvider(name = "getcontentUfieldDataHashTable")
    public static Object[][] getcontentUfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataContentU = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 5, 5);
        System.out.println("getSubjectfieldDataHashTable: " + dataContentU);
        return dataContentU;
    }
    @DataProvider(name = "getcontentfieldDataHashTable")
    public static Object[][] getcontentfieldDataHashTable() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] dataContent = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_MESSAGE_TEACHER_FILE_PATH, "MessageTeacher", 6, 6);
        System.out.println("getSubjectfieldDataHashTable: " + dataContent);
        return dataContent;
    }
}
