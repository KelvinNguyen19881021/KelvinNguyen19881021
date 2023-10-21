package selenium.com.projects.sadlierconnect.models;

import lombok.Data;

@Data
public class StudentModel {

    public static int row;

    public static String testCaseName = "TESTCASENAME";

    public static String studentID = "StudentID";

    public static String firstName = "FirstName";

    public static String middleName = "MiddleName";

    public static String lastName = "LastName";

    public static String userName = "UserName";

    public static String passWord = "PassWord";

    public static String gradeLevel = "GradeLevel";

    public static int getRow() {
        return row;
    }

    public static String getTestCaseName() {
        return testCaseName;
    }

    public static String getStudentID() {
        return studentID;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getMiddleName() {
        return middleName;
    }

    public static String getLastName() {
        return lastName;
    }


    public static String getUserName() {
        return userName;
    }


    public static String getPassWord() {
        return passWord;
    }


    public static String getGradeLevel() {
        return gradeLevel;
    }


}
