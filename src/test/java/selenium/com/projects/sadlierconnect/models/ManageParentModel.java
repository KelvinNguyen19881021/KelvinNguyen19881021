package selenium.com.projects.sadlierconnect.models;


import lombok.*;


@Data
@Setter
@Getter
public class ManageParentModel {
  public String getTestCaseName() {
    return testCaseName;
  }

  public void setTestCaseName(String testCaseName) {
    this.testCaseName = testCaseName;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsernameEdit() {
    return usernameEdit;
  }

  public void setUsernameEdit(String usernameEdit) {
    this.usernameEdit = usernameEdit;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getParentChild() {
    return parentChild;
  }

  public void setParentChild(String parentChild) {
    this.parentChild = parentChild;
  }

  public String getParentChildDelete() {
    return parentChildDelete;
  }

  public void setParentChildDelete(String parentChildDelete) {
    this.parentChildDelete = parentChildDelete;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  private String testCaseName = "TESTCASENAME";
  private String firstName = "FIRSTNAME";
  private String middleName = "MIDDLENAME";
  private String lastName = "LASTNAME";
  private String email = "EMAIL";
  private String username = "USERNAME";
  private String usernameEdit = "USERNAMEEDIT";
  private String password = "PASSWORD";
  private String parentChild = "PARENTCHILD";
  private String parentChildDelete = "PARENTCHILDDELETE";
  private String status = "STATUS";
  private String clazz = "CLASS";
  private String grade = "GRADE";
}
