package selenium.com.projects.sadlierconnect.models;

import lombok.Data;


@Data

public class FullAccessSearchModel {
    public static int row;
    public static String contentfa = "CONTENTFA";
    public static String assignmentFA = "AssignmentFA";
    public static String getContentfa() {
        return contentfa;
    }
    public static String getAssignmentFA() {
        return assignmentFA;
    }

}
