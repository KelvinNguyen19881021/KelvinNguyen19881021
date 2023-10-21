package selenium.com.projects.sadlierconnect.models;

import lombok.*;

@Data
@Getter
@Setter
public class ManageStudentModel {

    private int row;

    private String testCaseName = "TESTCASENAME";

    private String testCaseID = "TestCaseID";

    private String studentID = "StudentID";

    private String studentIDEdit = "StudentIDEdit";

    private String firstName = "FirstName";

    private String firstNameEdit = "FirstNameEdit";

    private String middleName = "MiddleName";

    private String lastName = "LastName";

    private String lastNameEdit = "LastNameEdit";

    private String userName = "UserName";

    private String userNameEdit = "UserName";

    private String passWord = "PassWord";

    private String passCode = "PassCode";

    private String gradeLevel = "GradeLevel";

    private String clazz = "Class";

    private String grade = "Grade";

    private String sendTo = "SendTo";

    private String status = "Status";

    private String subject = "Subject";

    private String content = "Content";

    private String fileNamePrint = "FileNamePrint";

    private String product = "Product";

    private String allLicense = "AllLicense";

    private String seatLicense = "SeatLicense";

    private String siteLicense = "SiteLicense";

    private String productCodeSeat = "ProductCodeSeat";

    private String productCodeSite = "ProductCodeSite";

}
