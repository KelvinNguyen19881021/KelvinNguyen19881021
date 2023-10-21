package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCLogin;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCManageParent;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCMessageStudent;
import selenium.com.enums.AuthorType;
import selenium.com.enums.CategoryType;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.Message.MessageStudentPageSC;

import java.util.Hashtable;


public class MessageStudentTest extends BaseTest {

    LoginPageSC loginPageSC;
    MessageStudentPageSC messageStudentTest;


    public MessageStudentTest() {
        loginPageSC = new LoginPageSC();
        messageStudentTest = new MessageStudentPageSC();

    }

    //Using library DataProvider with read Hashtable
    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 1, description = "Add user into To/Cc fields by  Keyword", dataProvider = "getMessageStudentDataHashTable01", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU01(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentMessage();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Enter keyword and select user
        messageStudentTest.checkAddUserIntoToCCFieldsByKeyword(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 2, description = "Add user into To/Cc fields by  Label To/Cc", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU02() {
        //1. Login as Student
        loginPageSC.logInWithStudentMessage();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Select To/Cc label - Add user
        messageStudentTest.checkAddUserIntoToCCFieldsByLabelToCc();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 3, description = "Save Message", dataProvider = "getMessageStudentDataHashTable03", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU03(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Enter Subject
        //5. Select Save icon
        messageStudentTest.checkSaveMessages(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 4, description = "Can not Save Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU04() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Not input Subject
        //5. Select Save icon
        messageStudentTest.checkCanNotSaveMessages();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 5, description = "Use Toolbar", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU05() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Use Toolbar
        messageStudentTest.checkUseToolbar();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 6, description = "Send Message", dataProvider = "getMessageStudentDataHashTable06", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU06(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Input User into To/Cc
        //5. Enter Message content
        //6. Select Send button on Popup
        messageStudentTest.checkSendMessage(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 7, description = "Can not Send Message without Subject", dataProvider = "getMessageStudentDataHashTable07", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU07(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Not input Subject
        //5. Select Send button
        messageStudentTest.checkCanNotSendMessageWithoutSubject(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 8, description = "Can not Send Message without To", dataProvider = "getMessageStudentDataHashTable08", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU08(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Plus icon to Compose Message
        //4. Not choose user in To field
        //5. Select Send button
        messageStudentTest.checkCanNotSendMessageWithoutTo(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 9, description = "View and Reply Message", dataProvider = "getMessageStudentDataHashTable09", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU09(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Inbox item
        //4. Open Message
        //5. Select Reply buttons
        //6. Select Send Button in Compose message
        messageStudentTest.checkViewandReplyMessage(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 10, description = "View and Forward Message in Inbox Item", dataProvider = "getMessageStudentDataHashTable10", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU10(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        // 2. Select Message icon
        // 3. Select Inbox item
        // 4. Open Message
        // 5. Select Forward button
        // 6. Input User in To/Cc
        // 7. Select Send button
        messageStudentTest.checkViewandForwardMessageInInboxItem(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 11, description = "Delete Message in Inbox Item OutSide Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU011() {
        //1. Login as Student
        loginPageSC.logInWithStudentforDeleteMessage();
        //2. Select Message icon
        //3. Select Inbox item
        //4. Select Trash button on message
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInInboxItemOutsideMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 12, description = "Delete Message in Inbox Item On Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU012() {
        //1. Login as Student
        loginPageSC.logInWithStudentforDeleteMessage();
        //2. Select Message icon
        //3. Select Inbox item
        //4.Open Message and select Trash icon"
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInInboxItemOnMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 13, description = "View and Forward Message in Sent Item", dataProvider = "getMessageStudentDataHashTable13", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU13(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Sent item
        //4. Open Message
        //5. Select Forward button
        //6. Input User in To/Cc
        //7. Select Send button
        messageStudentTest.checkViewandForwardMessageInSentItem(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 14, description = "Delete Message in Sent Item Outside Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU014() {
        //1. Login as Student
        loginPageSC.logInWithStudentforDeleteMessage();
        //2. Select Message icon
        //3. Select Sent item
        //4. Select Trash button on message
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInSentItemOutsideMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 15, description = "Delete Message in Sent Item On Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU15() {
        //1. Login as Student
        loginPageSC.logInWithStudentforDeleteMessage();
        //2. Select Message icon
        //3. Select Sent item
        //4.Open Message and select Trash icon"
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInSentItemOnMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 16, description = "Edit Message in Drafts Item", dataProvider = "getMessageStudentDataHashTable16", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU16(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Drafts item
        //4. Open Message
        //5. Select Pen icon
        //6. Input Content to Edit
        //7. Select Save button
        messageStudentTest.checkEditMessageInDraftsItem(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 17, description = "Send Message in Drafts", dataProvider = "getMessageStudentDataHashTable17", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU17(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Drafts item
        //4. Open Message
        //5. Select Send icon
        //6. Select Send button on Popup
        messageStudentTest.checkSendMessageinDraft(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 18, description = "Can Not Send Message in Drafts", dataProvider = "getMessageStudentDataHashTable18", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU18(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Drafts item
        //4. Open Message
        //5. Select Send icon
        //6. Select Send button on Popup
        //7. Select View message button
        messageStudentTest.checkCanNotSendMessageInDraftItem(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 19, description = "Delete Message in Draft Item Outside Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU19() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Drafts item
        //4. Select Trash button on message
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInDraftItemOutsideMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 20, description = "Delete Message in Draft Item On Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU20() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Drafts item
        //4.Open Message and select Trash icon"
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInDraftItemOnMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 21, description = "unDelete Message in Trash Item", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU21() {
        //1. Login as Student
        loginPageSC.logInWithStudentforDeleteMessage();
        //2. Select Message icon
        //3. Select Trash item
        //4. Open Message
        //5. Select unDelete icon
        //6. Select Un_Delete button on popup confirm
        messageStudentTest.checkunDeleteMessageInTrashItem();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 22, description = "Delete Message in Trash Item Outside Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU22() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Trash item
        //4. Select Trash button on message
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInTrashItemOutsideMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 23, description = "Delete Message in Trash Item On Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU23() {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select Trash item
        //4.Open Message and select Trash icon"
        //5. Select Delete button on popup confirm
        messageStudentTest.checkDeleteMessageInTrashItemOnMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 24, description = "Next and Previous Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU24() {
        //1. Login as Student
        loginPageSC.logInWithStudentMessage();
        //2. Select Message icon
        //3. Select items
        //4. Open Message
        //5. Select Next bụttons
        //6. Select Previous bụttons
        messageStudentTest.checkNextandPreviousMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 25, description = "Sort Message", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU25() {
        //1. Login as Student
        loginPageSC.logInWithStudentMessage();
        //2. Select Message icon
        //3. Select items
        //4. Select From/To filter
        //5. Select Date Received/Sent filter
        messageStudentTest.checkSortMessage();
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 26, description = "Search Message with Valid Keyword", dataProvider = "getMessageStudentDataHashTable26", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU26(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select item want to search
        //4. Select Search for Message textbox
        //5. Input keyword valid
        //6. Select magnifying glass icon
        messageStudentTest.checkSearchMessageWithValidKeyword(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AutomationTeam}, category = {CategoryType.SC_Message_Student})
    @Test(priority = 27, description = "Search Message with inValid Keyword", dataProvider = "getMessageStudentDataHashTable27", dataProviderClass = DataProviderSCMessageStudent.class)
    public void TC_Message_STU27(Hashtable<String, String> data) throws IllegalAccessException {
        //1. Login as Student
        loginPageSC.logInWithStudentRole();
        //2. Select Message icon
        //3. Select item want to search
        //4. Select Search for Message textbox
        //5. Input keyword invalid
        //6. Select magnifying glass icon
        messageStudentTest.checkSearchMessageWithinValidKeyword(data);
    }
}









