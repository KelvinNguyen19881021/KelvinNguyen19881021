package selenium.com.projects.sadlierconnect.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassProficiencyReportModel {
  private int row;
  private String testCaseName = "TestCaseName";
//  private String testCaseID = "TestCaseID";
  private String clazz = "Class";
  private String student = "Student";
  private String subject = "Subject";
  private String resource = "Resource";
  private String product = "Product";
  private String grade = "Grade";
  private String subGrade = "SubGrade";
  private String standard = "Standard";
  private String standardHover = "StandardHover";
}
