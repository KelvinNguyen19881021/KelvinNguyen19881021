package selenium.com.projects.sadlierconnect.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : tien.vo-ngoc
 * @created : Sep, 20 2023
 **/
@Data
@Setter
@Getter
public class FullAccessModel {
    private String testCaseName = "TESTCASENAME";
    private String schoolPid = "SchoolPid";
    private String licenseImportFull = "LicenseImportFull";
    private String licenseImportNotParent = "LicenseImportNotParent";
    private String licenseImportBlankBundle = "LicenseImportBlankBundle";
    private String licenseImportNotFullList = "LicenseImportNotFullList";
    private String schoolUrl = "SchoolUrl";
    private String passCode = "PassCode";
    private String username = "Username";
    private String password = "Password";
    private String errorMessage = "ErrorMessage";
    private String grade = "Grade";
    private String programSeries = "ProgramSeries";
    private String resourceTitle = "ResourceTitle";
    private String clazzName = "ClassName";
    private String programSeriesVersion = "ProgramSeriesVersion";
    private String standardSet = "StandardSet";
    private String reportType = "ReportType";
    private String studentName = "StudentName";
    private String startDate = "StartDate";
    private String endDate = "EndDate";
}
