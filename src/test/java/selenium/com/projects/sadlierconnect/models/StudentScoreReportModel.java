package selenium.com.projects.sadlierconnect.models;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class StudentScoreReportModel {
    public String eventClass =      "EVENTCLASS";
    public String student =         "STUDENT";
    public String eventProgram =     "PROGRAM";
    public String eventSection =     "SECTION";
    public String eventSection2 =    "SECTION2";
    public String from1 =           "FROM1";
    public String to1 =             "TO1";
    public String from2 =           "FROM2";
    public String to2 =             "TO2";
    public String evenTime =        "EVENTTIME" ;
    public String action=           "ACTION";
    public String assignmentName =  "ASSIGNMENTNAME";
    public String assessments =     "ASSESSMENTS" ;
    public String assessments2 =    "ASSESSMENTS2" ;
    public String lastName =        "LASTNAME" ;
    public String firstName =       "FIRSTNAME" ;
    public String dueDate =         "DUEDATE" ;
    public String score =           "SCORE" ;

    public String getScore() {
        return score;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAssessments2() {
        return assessments2;
    }




    public String getAssessments() {
        return assessments;
    }

    public void setEventSection2(String eventSection2) {
        this.eventSection2 = eventSection2;
    }

    public String getEventSection2() {
        return eventSection2;
    }

    public void setEventSection(String eventSection) {
        this.eventSection = eventSection;
    }

    public String getEventSection() {
        return eventSection;
    }

    public String getEventClass() {
        return eventClass;
    }

    public String getStudent() {
        return student;
    }



    public String getFrom1() {
        return from1;
    }

    public String getTo1() {
        return to1;
    }

    public String getFrom2() {
        return from2;
    }

    public String getTo2() {
        return to2;
    }

    public String getEvenTime() {
        return evenTime;
    }

    public String getAction() {
        return action;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setEventProgram(String eventProgram) {
        this.eventProgram = eventProgram;
    }

    public String getEventProgram() {
        return eventProgram;
    }

    public void setFrom1(String from1) {
        this.from1 = from1;
    }

    public void setTo1(String to1) {
        this.to1 = to1;
    }

    public void setFrom2(String from2) {
        this.from2 = from2;
    }

    public void setTo2(String to2) {
        this.to2 = to2;
    }

    public void setEvenTime(String evenTime) {
        this.evenTime = evenTime;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
}

