package selenium.com.projects.sadlierconnect.models;

import lombok.*;

@Data
@Getter
@Setter
public class ClassAssessmentReportModel {
  private int row;
  private String testCaseName = "TestCaseName";
//  private String testCaseID = "TestCaseID";
  private String clazz = "Class";
  private String student = "Student";
  private String subject = "Subject";
  private String resource = "Resource";
  private String product = "Product";
  private String grade = "Grade";
}
