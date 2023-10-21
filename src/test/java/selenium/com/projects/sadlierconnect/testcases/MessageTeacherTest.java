/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCLogin;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCMessageTeacher;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.Message.MessagePageSC;

import java.util.Hashtable;


public class MessageTeacherTest extends BaseTest{

    LoginPageSC loginPageSC;
    DashboardPageSC dashboardPageSC;
    MessagePageSC messageTeacherPageSC;

    public MessageTeacherTest() {
        loginPageSC = new LoginPageSC();
        dashboardPageSC= new DashboardPageSC();
        messageTeacherPageSC = new MessagePageSC();
    }

    //Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 1, description = "Add user into To/Cc fields", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH01(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkAddUserIntoField(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 2, description = "Add user into To/Cc fields with listUser", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH02(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkAddUserinListUser(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 3, description = "Save with Subject", dataProvider = "getSubjectfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH03(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkSaveMessage(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 4, description = "Can not Save without Subject", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH04(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkCannotSaveMessage();
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 5, description = "use toolbar", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH05(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkUseToolbar();
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 6, description = "send Message", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH06(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkSendMessage();
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 7, description = "can not send Message", dataProvider = "getcontentfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH07(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkCanNotSendMessage(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 8, description = "can not send Message without TO", dataProvider = "getcontentfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH08(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkCanNotSendMessagewithoutuser(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 9, description = "View message_Reply", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH09(Hashtable<String, String> data) throws IllegalAccessException{
        loginPageSC.logInWithAdminRole();
        messageTeacherPageSC.adminsendmessage(data);
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkViewMesssage_Reply(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 10, description = "View message_Reply_all", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH10(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkViewMesssage_Replyall(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 11, description = "View message_Forward", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH11(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkViewIboxMesssage_Forward(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 12, description = "Delete Message in Inbox", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH12(Hashtable<String, String> data) {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteMessageinInbox(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 13, description = "Delete Messaeg in Inbox", dataProvider = "getTeacherLoginDataHashTable", dataProviderClass = DataProviderSCLogin.class)
    public void TC_Message_TCH13(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithAdminRole();
        messageTeacherPageSC.adminsendmessage(data);
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.CheckDeleteMessagebySelectTrashbuttononmessageOpenMessageandselectTrashicon(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 14, description = "View message_Forward", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH14(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkViewSendMesssage_Forward(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 15, description = "Delete Message in Send", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH15(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteMessageinSend(data);
    }


    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 16, description = "Delete Message in Send", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH16(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteMessageinSendopenMail(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 17, description = "Edit Message in Draft", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH17(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkEditmessage(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 18, description = "Send Message in Draft unsuccessful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH18(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkCannotSendmessageInDraft(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 19, description = "Send Message in Draft successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH19(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkSendmessageInDraft(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 20, description = "Delete Message in Draft successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH20(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteSendmessageInDraft(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 21, description = "delete Message in Draft when open mail successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH21(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteSendmessageInDraftwhenopenmail(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 22, description = "undelete Message in trash successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH22(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkUnDeleteSendmessage(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 23, description = "Delete Message in trash successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH23(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteSendMessageinTrash(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 24, description = "Delete Message in trash when open mail successful", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH24(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkDeleteSendMessageInTrashOpenMail(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 25, description = "Previous message", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH25(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageRole();
        messageTeacherPageSC.checkNextPreviousButtonsMessage(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 26, description = "Sort message", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH26(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageRole();
        messageTeacherPageSC.checkSortMessageWithFrom_To(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 27, description = "Search message invalid", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH27(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkSearchMessageValid(data);
    }
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Teacher})
    @Test(priority = 28, description = "Search message valid", dataProvider = "getTO_CCfieldDataHashTable", dataProviderClass = DataProviderSCMessageTeacher.class)
    public void TC_Message_TCH28(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherMessageTestRole();
        messageTeacherPageSC.checkSearchMessageInvalid(data);
    }
    }
