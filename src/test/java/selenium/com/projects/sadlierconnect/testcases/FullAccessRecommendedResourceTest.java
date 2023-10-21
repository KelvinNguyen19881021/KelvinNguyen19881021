/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccessReportRR;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCFullAccessReportRR;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.projects.sadlierconnect.pages.FullAccess.FullAccessRecommendedResourcePageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;

import java.util.Hashtable;


public class FullAccessRecommendedResourceTest extends BaseTest {
    LoginPageSC loginPageSC;
    FullAccessRecommendedResourcePageSC FullAccessRecommendResourceTest;
    public FullAccessRecommendedResourceTest() {
        loginPageSC = new LoginPageSC();
        FullAccessRecommendResourceTest = new FullAccessRecommendedResourcePageSC();

    }

    //Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "Message when Student above proficiency ", dataProviderClass = DataProviderSCFullAccessReportRR.class)
    public void TC_REPORT_25() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
        //2. Go to FA report
        //3. Click Recommend Resource Tab
        //4. Select Program, Standard Set (for WB), Assessment, Class
        FullAccessRecommendResourceTest.checkMessageWhenStudentAboveProficiency();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 2, description = "Show Skill On RR and View Resource", dataProviderClass = DataProviderSCFullAccessReportRR.class)
    public void TC_REPORT_26() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
        //2. Go to FA report
        //3. Click Recommend Resource Tab
        //4. Select Program, Standard Set (for WB), Assessment, Class
        //5. Select specific domain
        //6. Click Skill
        //7. Click View
        //8. Click Back/FullAcess button
        FullAccessRecommendResourceTest.checkShowSkillOnRRandViewResource();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 3, description = "Create Assignment", dataProvider = "getFullAccessReportRRDataHashTable03", dataProviderClass = DataProviderSCFullAccessReportRR.class)
    public void TC_REPORT_27(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
        //2. Go to FA report
        //3. Click Recommend Resource Tab
        //4. Select Program, Standard Set (for WB), Assessment, Class
        //5. Select specific domain
        //6. Click Skill
        //7. Not Tick resource
        //8. Click Create Assignment button
        //9. Remove all tick students
        //10. Tick student + resource
        //11. Click Create Assignment
        //12. Select class then click Save button
        FullAccessRecommendResourceTest.checkCreateAssignment(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 4, description = "Show Skill On RR When Select Single Domain", dataProviderClass = DataProviderSCFullAccessReportRR.class)
    public void TC_REPORT_29() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
        //2. Go to FA report
        //3. Click Recommend Resource Tab
        //4. Select Program, Standard Set (for WB), Assessment, Class
        //5. Select specific domain
        //6. Select another Assessment, Class
        FullAccessRecommendResourceTest.checkShowSkillOnRRWhenSelectSingleDomain();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.REGRESSION})
    @Test(priority = 5, description = "Sort Proficiency", dataProviderClass = DataProviderSCFullAccessReportRR.class)
    public void TC_REPORT_30() {
        //1. Login as Teacher
        loginPageSC.logInWithTeacherRoleFullAccess ();
        //2. Go to FA report
        //3. Click Recommend Resource Tab
        //4. Select Program, Standard Set (for WB), Assessment, Class
        //5. Select Low Proficiency to High Proficiency option
        //5. Select High Proficiency to Low Proficiency option
        FullAccessRecommendResourceTest.checkSortProficiency();
    }


}












