/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccessReportLG;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccessReportRR;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.models.FullAccessReportLGModel;
import selenium.com.projects.sadlierconnect.pages.FullAccess.FullAccessLearningGroupPageSC;
import selenium.com.projects.sadlierconnect.pages.FullAccess.FullAccessRecommendedResourcePageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.util.Hashtable;


public class FullAccessLearningGroupTest extends BaseTest {
    LoginPageSC loginPageSC;
    FullAccessLearningGroupPageSC FullAccessLearningGroupTest;
    public FullAccessLearningGroupTest() {
        loginPageSC = new LoginPageSC();
        FullAccessLearningGroupTest = new FullAccessLearningGroupPageSC();

    }

    //Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "Disable Manage Group Button", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_31() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//        4. Select Program, Standard Set (for WB), Assessment, Class
        FullAccessLearningGroupTest.checkDisableManageGroupbutton();
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 2, description = "View Skill and View Resource", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_32() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//        4. Select Program, Standard Set (for WB), Assessment, Class
        FullAccessLearningGroupTest.checkViewSkillandViewResource();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 3, description = "Manage Group", dataProvider = "getFullAccessReportLGDataHashTable03", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_33(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//4. Select Program, Standard Set (for WB), Assessment, Class
//5. Click Manage Group
//6. Click + icon
//7. Click Restore to Original Group button
//8. Click Confirm Restore button
//9. Click Group Name and Edit Group Name to Group Test
//10. drag and drop student1 into Group Test
//11. Click --- and select pink color
//12. Click Save button
        FullAccessLearningGroupTest.checkManageGroup(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 4, description = "Update Domain Score", dataProvider = "getFullAccessReportLGDataHashTable04", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_34(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//        4. Select Program, Standard Set (for WB), Assessment, Class
//        5. Click Manage Group
//        6. Change Color and Group Name
//        7. Save group
//        8. Click Update Domain Score button
//        9. Click update groups Button
        FullAccessLearningGroupTest.checkUpdateDomainScore(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 5, description = "Create Assign", dataProvider = "getFullAccessReportLGDataHashTable05", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_35(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//        4. Select Program, Standard Set (for WB), Assessment, Class
//        5. Click Manage Group
//        6. Change Color and Group Name
//        7. Save group
//        8. Click Update Domain Score button
//        9. Click update groups Button
        FullAccessLearningGroupTest.checkCreateAssignment(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 6, description = "View Chart", dataProviderClass = DataProviderSCFullAccessReportLG.class)
    public void TC_REPORT_37() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
//        2. Go to FA report
//        3. Click Learning Groups Tab
//        4. Select Program, Standard Set (for WB), Assessment, Class
        FullAccessLearningGroupTest.checkViewChart();
    }
}












