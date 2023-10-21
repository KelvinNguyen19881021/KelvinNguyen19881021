package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;
public class DataProviderSCStudentScoreReport {

    private DataProviderSCStudentScoreReport() {
        super();
        PropertiesHelpers.loadAllFiles();

    }

    @DataProvider(name = "getStudentScoreReportDataHashTable01")
    public static Object[][] getStudentScoreReportDataHashTable01() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 1, 1);
        System.out.println("getStudentScoreReportDataHashTable01: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable02")
    public static Object[][] getStudentScoreReportDataHashTable02() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 2, 2);
        System.out.println("getStudentScoreReportDataHashTable02: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable03")
    public static Object[][] getStudentScoreReportDataHashTable03() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 3, 3);
        System.out.println("getStudentScoreReportDataHashTable03: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable04")
    public static Object[][] getStudentScoreReportDataHashTable04() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 4, 4);
        System.out.println("getStudentScoreReportDataHashTable04: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable05")
    public static Object[][] getStudentScoreReportDataHashTable05() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 5, 5);
        System.out.println("getStudentScoreReportDataHashTable05: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable06")
    public static Object[][] getStudentScoreReportDataHashTable06() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 6, 6);
        System.out.println("getStudentScoreReportDataHashTable06: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable07")
    public static Object[][] getStudentScoreReportDataHashTable07() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 7, 7);
        System.out.println("getStudentScoreReportDataHashTable07: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable08")
    public static Object[][] getStudentScoreReportDataHashTable08() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 8, 8);
        System.out.println("getStudentScoreReportDataHashTable08: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable09")
    public static Object[][] getStudentScoreReportDataHashTable09() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 9, 9);
        System.out.println("getStudentScoreReportDataHashTable09: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable10")
    public static Object[][] getStudentScoreReportDataHashTable10() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 10, 10);
        System.out.println("getStudentScoreReportDataHashTable10: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable11")
    public static Object[][] getStudentScoreReportDataHashTable11() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 11, 11);
        System.out.println("getStudentScoreReportDataHashTable11: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable12")
    public static Object[][] getStudentScoreReportDataHashTable12() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 12, 12);
        System.out.println("getStudentScoreReportDataHashTable12: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable13")
    public static Object[][] getStudentScoreReportDataHashTable13() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 13, 13);
        System.out.println("getStudentScoreReportDataHashTable13: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable14")
    public static Object[][] getStudentScoreReportDataHashTable14() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 14, 14);
        System.out.println("getStudentScoreReportDataHashTable14: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable15")
    public static Object[][] getStudentScoreReportDataHashTable15() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 15, 15);
        System.out.println("getStudentScoreReportDataHashTable15: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable16")
    public static Object[][] getStudentScoreReportDataHashTable16() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 16, 16);
        System.out.println("getStudentScoreReportDataHashTable16: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable17")
    public static Object[][] getStudentScoreReportDataHashTable17() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 17, 17);
        System.out.println("getStudentScoreReportDataHashTable17: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable18")
    public static Object[][] getStudentScoreReportDataHashTable18() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 18, 18);
        System.out.println("getStudentScoreReportDataHashTable18: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable19")
    public static Object[][] getStudentScoreReportDataHashTable19() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 19, 19);
        System.out.println("getStudentScoreReportDataHashTable19: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable20")
    public static Object[][] getStudentScoreReportDataHashTable20() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 20, 20);
        System.out.println("getStudentScoreReportDataHashTable20: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable21")
    public static Object[][] getStudentScoreReportDataHashTable21() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 21, 21);
        System.out.println("getStudentScoreReportDataHashTable21: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable22")
    public static Object[][] getStudentScoreReportDataHashTable22() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 22, 22);
        System.out.println("getStudentScoreReportDataHashTable22: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable23")
    public static Object[][] getStudentScoreReportDataHashTable23() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 23, 23);
        System.out.println("getStudentScoreReportDataHashTable23: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable24")
    public static Object[][] getStudentScoreReportDataHashTable24() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 24, 24);
        System.out.println("getStudentScoreReportDataHashTable24: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable25")
    public static Object[][] getStudentScoreReportDataHashTable25() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 25, 25);
        System.out.println("getStudentScoreReportDataHashTable25: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable26")
    public static Object[][] getStudentScoreReportDataHashTable26() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 26, 26);
        System.out.println("getStudentScoreReportDataHashTable26: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable27")
    public static Object[][] getStudentScoreReportDataHashTable27() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 27, 27);
        System.out.println("getStudentScoreReportDataHashTable27: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable28")
    public static Object[][] getStudentScoreReportDataHashTable28() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 28, 28);
        System.out.println("getStudentScoreReportDataHashTable28: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable29")
    public static Object[][] getStudentScoreReportDataHashTable29() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 29, 29);
        System.out.println("getStudentScoreReportDataHashTable29: " + data);
        return data;
    }

    @DataProvider(name = "getStudentScoreReportDataHashTable31")
    public static Object[][] getStudentScoreReportDataHashTable31() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_STUDENT_SCORE_REPORT_SC_PATH, "studentScoreReport", 31, 31);
        System.out.println("getStudentScoreReportDataHashTable31: " + data);
        return data;
    }


}
