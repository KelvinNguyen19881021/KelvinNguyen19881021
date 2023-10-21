package selenium.com.projects.sadlierconnect.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class MyLibraryModel {

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        MyLibraryModel.row = row;
    }

    public static String getTestCaseName() {
        return testCaseName;
    }

    public static void setTestCaseName(String testCaseName) {
        MyLibraryModel.testCaseName = testCaseName;
    }

    public static String getProgramSeriesName() {
        return programSeriesName;
    }

    public static void setProgramSeriesName(String programSeriesName) {
        MyLibraryModel.programSeriesName = programSeriesName;
    }

    public static String getProductGrade() {
        return productGrade;
    }

    public static void setProductGrade(String productGrade) {
        MyLibraryModel.productGrade = productGrade;
    }

    public static int row;

    public static String testCaseName = "TESTCASENAME";

    public static String programSeriesName = "ProgramSeriesName";

    public static String productGrade = "ProductGrade";




}
