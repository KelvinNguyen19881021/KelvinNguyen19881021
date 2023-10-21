package selenium.com.projects.sadlierconnect.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentTrendReportModel {

    public String classTrendReport = "CLASS";
    public String studentTrendReport = "STUDENT";
    public String expectedResult = "EXPECTED_RESULT";

}
