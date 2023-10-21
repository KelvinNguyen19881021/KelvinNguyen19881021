package selenium.com.projects.sadlierconnect.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
public class FullAccessReportLGModel {
  private String testCaseName = "TESTCASENAME";
  private String assignmentname = "AssignmentName";
  private String timestartdate = "TimeStartDate";
  private String contentSearch = "ContentSearch";
  private String groupName = "GroupName";

}
