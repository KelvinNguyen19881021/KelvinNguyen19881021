package selenium.com.projects.sadlierconnect.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentTrackingReportModel {

    public String eventClass = "EVENTCLASS";

    public String student = "STUDENT";
    public String eventAction = "EVENTACTION";
    public String from1 = "FROM1";
    public String to1 = "TO1";
    public String from2 = "FROM2";
    public String to2 = "TO2";
    public String evenTime = "EVENTTIME" ;

    public String action= "ACTION";
    public String action2= "ACTION2";

    public String action3= "ACTION3";

    public String assignmentName = "ASSIGNMENTNAME";

    public void setAction3(String action3) {
        this.action3 = action3;
    }

    public String getAction3() {
        return action3;
    }

    public void setAction2(String action2) {
        this.action2 = action2;
    }

    public String getAction2() {
        return action2;
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

    public String getTo2() {
        return to2;
    }

    public String ipAddress = "IPADDRESS";

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getEvenTime() {
        return evenTime;
    }

    public void setEvenTime(String evenTime) {
        this.evenTime = evenTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String alertMessage = "ALERTMESSAGE";

}
