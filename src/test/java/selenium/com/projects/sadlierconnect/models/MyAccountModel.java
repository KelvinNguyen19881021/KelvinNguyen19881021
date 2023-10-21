package selenium.com.projects.sadlierconnect.models;

import lombok.Data;

@Data
public class MyAccountModel {

    public static int row;

    public static int getRow() {
        return row;
    }

    public static String getTestCaseName() {
        return testCaseName;
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

    public static String getEmail() {
        return email;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getOpt() {
        return opt;
    }

    public static String testCaseName = "TESTCASENAME";

    public static String firstName = "FirstName";

    public static String middleName = "MiddleName";

    public static String lastName = "LastName";

    public static String email = "Email";

    public static String userName = "UserName";

    public static String passWord = "PassWord";

    public static String opt = "Opt";

    public static String getDefaultUserName() {
        return defaultUserName;
    }

    public static String defaultUserName = "DefaultUserName";

    public static String getDefaultPassWord() {
        return defaultPassWord;
    }

    public static String defaultPassWord = "DefaultPassWord";

    public static String getMessageSuccess() {
        return messageSuccess;
    }

    public static String messageSuccess = "SuccessMessage";

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static String errorMessage = "ErrorMessage";




}
