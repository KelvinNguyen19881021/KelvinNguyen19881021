package selenium.com.projects.sadlierconnect.models;

import lombok.Data;

@Data
public class LoginModel {

    public static int row;

    public static String testCaseName = "TESTCASENAME";

    public static String passCode = "PASSCODE";

    public static String userRole = "USERROLE";

    public static String passWord = "PASSWORD";

    public static String userName = "USERNAME";

    public static int getRow() {
        return row;
    }

    public static String getTestCaseName() {
        return testCaseName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassCode() {
        return passCode;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getUserRole() {
        return userRole;
    }

}
