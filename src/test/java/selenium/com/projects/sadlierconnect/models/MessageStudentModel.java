package selenium.com.projects.sadlierconnect.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
public class MessageStudentModel {
  private String testCaseName = "TESTCASENAME";
  private String testScenario = "TEST SCENARIO";
  private String to = "To";
  private String cc = "Cc";
  private String subject = "Subject";
  private String content = "Content";
  private String search = "Search";

}
