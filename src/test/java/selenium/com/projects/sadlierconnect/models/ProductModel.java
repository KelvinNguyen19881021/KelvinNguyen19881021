package selenium.com.projects.sadlierconnect.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductModel {
  public String getTestCaseName() {
    return testCaseName;
  }

  public void setTestCaseName(String testCaseName) {
    this.testCaseName = testCaseName;
  }

  public String getInputCode() {
    return inputCode;
  }

  public void setInputCode(String inputCode) {
    this.inputCode = inputCode;
  }

  public String getTestCase() {
    return testCase;
  }

  public void setTestCase(String testCase) {
    this.testCase = testCase;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getpID() {
    return pID;
  }

  public void setpID(String pID) {
    this.pID = pID;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  private String testCaseName = "TESTCASENAME";
  private String inputCode = "INPUTCODE";
  private String testCase = "TESTCASE";
  private String productCode = "PRODUCTCODE";
  private String name = "NAME";
  private String pID = "PID";
  private String program = "PROGRAM";

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  private String grade = "GRADE";
}