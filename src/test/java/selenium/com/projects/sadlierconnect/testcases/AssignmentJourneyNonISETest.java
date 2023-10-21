
package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourney;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCAssignmentJourneyNonISE;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.Assignments.AssignmentJourneyNonISEPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;

import java.util.Hashtable;


public class AssignmentJourneyNonISETest extends BaseTest {

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    MyLibraryPageSC myLibraryPageSC;
    AssignmentJourneyNonISEPageSC assignmentJourneyPageNonISESC;



    public AssignmentJourneyNonISETest() {

        loginPageSC = new LoginPageSC();
        dashboardPageSC = new DashboardPageSC();
        myLibraryPageSC =new MyLibraryPageSC();
        assignmentJourneyPageNonISESC= new AssignmentJourneyNonISEPageSC();

    }

    // Assessment non ISE
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 1, description = "Check that create Assignment successful with default value",
            dataProvider = "getAssignmentJourney_Data_SC_073",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_073(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Not choose Grace Period - End Date and time
//        9. Enter "Direction" field
//        10. Choose student to assign
//        11. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//      [CP]_1. Return to my Library of Grade 3 and Unit 2
//           2. In Assignment List of teacher, assignment is created and shown assignment with status Active:
//        "assignment 73 - assessment nonise"
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);

    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 2, description = "Check that create Assignment successful - With class has group",
            dataProvider = "getAssignmentJourney_Data_SC_074",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_074(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class group
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Not choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//   [CP]_1. Should show student in group when create assignment
//        2. Return to my Library of Grade 3 and Unit 2
//        3. In Assignment List of teacher, assignment is created and shown assignment with status Active:
//        "assignment 74 - assessment nonise - group"
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }



    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 3,
            description = "Check that create Assignment successful - With using end date",
            dataProvider = "getAssignmentJourney_Data_SC_075",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_075(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class group
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//   [CP]_1. Should show student in group when create assignment
//        2. Return to my Library of Grade 3 and Unit 11
//        3. In Assignment List of teacher, assignment is created and shown assignment with status Active:
//        "assignment 75 - assessment ise - end date" and had end date
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }



    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 4, description = "Check that create Assignment successful - With multiple class",
            dataProvider = "getAssignmentJourney_Data_SC_076",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_076(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByAssignInLibrary(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class again
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//   [CP]_1. In Assignment List of teacher, 2 assignments are created and shown with status Active and 2 classes:
//    assignment 76 - assessment nonise - multiple class
//        2. Number of assignment = number of class = 2
//        3. In table student of create assignment, should show class name of student:
//        stu1, stu6 should show 1 asignment; stu5, should show 2 assignment
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful with multiple classes
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 5, description = "Check that create Assignment successful - With using assign icon in library",
            dataProvider = "getAssignmentJourney_Data_SC_077",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_077(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" in library
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class again
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//       [CP]_1. Return to my Library of Grade 3 and Unit 2
//        2. In Assignment List of teacher, assignment is created and shown assignment with status Active:
//        "assignment 77 - assessment nonise - assign in library" and had end date
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful when changing section
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 6, description = "Check that create Assignment successful - With changing section",
            dataProvider = "getAssignmentJourney_Data_SC_078",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_078(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Choose new Section
//        11. Choose new resource to assign by click "add Resources"
//        12. Enter "Direction" field
//        13. Choose student to assign
//        14. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//        1. Return to my Library of Grade 3 and Unit 3
//        2. In Assignment List of teacher, assignment is created and shown assignment with status Active:
//        "assignment 78 - assessment nonise - change section" and had end date
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful when unchecking option "Require submission of annotations."
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 7, description = "Check that create Assignment successful - With future time",
            dataProvider = "getAssignmentJourney_Data_SC_079",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_079(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
//        1. Should show Warning pop-up with content
//        "The selected start time is in the future. Your student will not see the assignment until this time. Do you want to continue?"
//        2. Create new assignment "assignment 79 - assessment nonise - future time" in Assignment list of teacher with status pending

        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }
  // [CP]_Check that create Assignment Static Resource (Scoring Option) successful when unchecking
  // option  "Require student upload."
  @FrameworkAnnotation(
      author = {AuthorType.AutomationTeam},
      category = {CategoryType.SC_Assignment_Journey})
  @Test(priority = 8, description = "Check that create Assignment successful - With choosing limits to 2 choices option",
      dataProvider = "getAssignmentJourney_Data_SC_080",
      dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
  public void TC_Assignment_Journey_080(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Choose option in AVAILABLE ANSWERS
//        11. Enter "Direction" field
//        12. Choose student to assign
//        13. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }

  // [CP]_Check that create Assignment Static Resource (Scoring Option) successful with more
  // resources
  @FrameworkAnnotation(
      author = {AuthorType.AutomationTeam},
      category = {CategoryType.SC_Assignment_Journey})
  @Test(
      priority = 9,
      description =
          "Check that create Assignment successful - With choosing scramble questions option",
      dataProvider = "getAssignmentJourney_Data_SC_081",
      dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
  public void TC_Assignment_Journey_081(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assignment" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Enter "Direction" field
//        10. Choose option in AVAILABLE ANSWERS
//        11. Choose option "Scramble Questions"
//        12. Choose student to assign
//        13. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful when choose option multi-part assignment
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 10,
            description = "Check that create Assignment successful - With choosing [Exclude assignment data from reports and alerts] option",
            dataProvider = "getAssignmentJourney_Data_SC_082",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_082(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assignment" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Enter "Direction" field
//        10. Choose option in AVAILABLE ANSWERS
//        11. Not choose option "Scramble Questions"
//        12. Choose option "Exclude assignment data from reports and alerts"
//        13. Choose student to assign
//        14. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful with future time
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 11, description = "Check that create Assignment successful - With more assessment resource",
            dataProvider = "getAssignmentJourney_Data_SC_083",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_083(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assignment" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Choose more resources assessment by Add resources
//        10. Enter "Direction" field
//        11. Choose option in AVAILABLE ANSWERS
//        12. Not choose option "Scramble Questions"
//        13. Not choose option "Exclude assignment data from reports and alerts"
//        14. Choose student to assign
//        15. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) successful multiple time with one resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 12, description = "Check that create Assignment successful - Assign multiple time with one resource",
            dataProvider = "getAssignmentJourney_Data_SC_084",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_084(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Not choose Grace Period - End Date and time
//        9. Enter "Direction" field
//        10. Choose student to assign
//        11. Click "Save" button
//        12. Click "Submit" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful with Cancel button
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 13,
            description = "Check that create Assignment successful - With Multi-Part Assignment (all assessment resource)",
            dataProvider = "getAssignmentJourney_Data_SC_085",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_085(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assignment" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Choose more resources assessment by Add resources
//        10. Enter "Direction" field
//        11. Choose option in AVAILABLE ANSWERS
//        12. Not choose option "Scramble Questions"
//        13. Not choose option "Exclude assignment data from reports and alerts"
//        14. Check option Create as a Multi-Part Assignment
//        15. Choose student to assign
//        16. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);

    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not filling data
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 14, description = "Check that create Assignment unsuccessful - Click Cancel button",
            dataProvider = "getAssignmentJourney_Data_SC_086",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_086(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class group
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Cancel" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);

    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful with invalid time
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 15,
            description = "Check that create Assignment unsuccessful - Not filling data",
            dataProvider = "getAssignmentJourney_Data_SC_087",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_087(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Not choose class
//        6. Click "Save " button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful with invalid time
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 16,
            description = "Check that create Assignment successful - Input invalid time(due date > end date)",
            dataProvider = "getAssignmentJourney_Data_SC_088",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_088(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class group
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);

    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not choose resource
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 17, description = "Check that create Assignment successful - Input invalid time(due date < current time)",
            dataProvider = "getAssignmentJourney_Data_SC_089",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_089(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
        //        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose class group
//        7. Choose Start Date and time
//        8. Choose Due Date and time
//        9. Choose Grace Period - End Date and time
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
    }


    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not choose any student
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 18, description = "Check that create Assignment successful - Not choose resource",
            dataProvider = "getAssignmentJourney_Data_SC_090",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_090(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Change section but not choose resource
//        10. Enter "Direction" field
//        11. Choose student to assign
//        12. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);

    }
    // [CP]_Check that create Assignment Static Resource (Scoring Option) unsuccessful when not fill point
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Assignment_Journey})
    @Test(priority = 19,
            description = "Check that create Assignment successful - Not choose any student",
            dataProvider = "getAssignmentJourney_Data_SC_091",
            dataProviderClass = DataProviderSCAssignmentJourneyNonISE.class)
    public void TC_Assignment_Journey_091(Hashtable<String, String> data) {
//        1. Log in as teacher
        loginPageSC.logInWithTeacherRole();
//        2. Navigate to resource need to create assignment
//        3. Click "assign" icon when open resource
        myLibraryPageSC.openCreateAssignmentOfResourceByOpenResource(data);
//        4. Enter "Assignment Name"
//        5. Choose class
//        6. Choose Start Date and time
//        7. Choose Due Date and time
//        8. Choose Grace Period - End Date and time
//        9. Enter "Direction" field
//        10. Not choose student to assign
//        11. Click "Save" button
        assignmentJourneyPageNonISESC.createAssignmentNonISESuccessByDefault(data);
        assignmentJourneyPageNonISESC.verifyCreateAssignmentNonISEInTeacherRoleWithDefault(data);
   }



}
