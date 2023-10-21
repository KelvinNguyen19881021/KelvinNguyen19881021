package selenium.com.projects.sadlierconnect.models;


import lombok.*;

@Data
@Setter
@Getter
public class ManageParentImportModel {

    public String action = "Action (Required)";
    public String userName = "Username (Required)";
    public String passWord = "Password (Required)";
    public String firstName = "First Name (Required)";
    public String middleName = "Middle Name (Optional)";
    public String lastName = "Last Name (Required)";
    public String email = "Email Address (Required)";
    public String status = "Status (Required)";
    public String studentUserName1 = "Student User Name 1";
    public String studentUserName2 = "Student User Name 2";
    public String studentUserName3 = "Student User Name 3";

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentUserName1() {
        return studentUserName1;
    }

    public void setStudentUserName1(String studentUserName1) {
        this.studentUserName1 = studentUserName1;
    }

    public String getStudentUserName2() {
        return studentUserName2;
    }

    public void setStudentUserName2(String studentUserName2) {
        this.studentUserName2 = studentUserName2;
    }

    public String getStudentUserName3() {
        return studentUserName3;
    }

    public void setStudentUserName3(String studentUserName3) {
        this.studentUserName3 = studentUserName3;
    }

    public String getStudentUserName4() {
        return studentUserName4;
    }

    public void setStudentUserName4(String studentUserName4) {
        this.studentUserName4 = studentUserName4;
    }

    public String studentUserName4 = "Student User Name 4";

}
