package selenium.com.projects.sadlierconnect.models;
import lombok.Data;

@Data
public class MessageTeacherModel {
    public static int row;
    public static String testCaseName = "TESTCASENAME";
    public static String To = "To";
    public static String Cc = "Cc";
    public static String Subject = "Subject";
    public static String Content = "Content";
    public static int getRow() {
        return row;
    }
    public static String getTestCaseName() {
        return testCaseName;
    }

    public static String getTo() {
        return To;
    }
    public static String getCc() {
        return Cc;
    }
    public static String getSubject() {
        return Subject;
    }
    public static String getContent(){
        return Content;
    }

}
