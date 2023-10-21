package selenium.com.projects.sadlierconnect.pages.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import selenium.com.constants.FrameworkConstants;
import selenium.com.driver.DriverManager;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.MessageStudentModel;
import selenium.com.projects.sadlierconnect.models.MessageTeacherModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.pages.Projects.ProjectPageSC;

import java.util.Hashtable;

import static selenium.com.constants.FrameworkConstants.WAIT_SLEEP_STEP;


public class MessagePageSC extends CommonPageSC {

    public MessagePageSC() {
        super();
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    private static final ExcelHelpers excelHelpers = new ExcelHelpers();

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuClients = By.xpath("//span[normalize-space()='Clients']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public By iconLetter = By.xpath("//a[@class='ant-dropdown-trigger ant-dropdown-link']//*[name()='svg']");
    public By iconPlus = By.xpath("//span[@aria-label='plus-circle']//*[name()='svg']");
    public By tableMessage  = By.xpath("//div[@class='sc-iNWwEs iNVFpk scrollable-container-wrapper']");
    public By boxTo = By.xpath("(//div[@class='ant-select-selection-overflow'])[1]");
    public By inputTo = By.xpath("//input[@id='rc_select_4']");
    public By inputToAdmin = By.xpath("(//div[@class='ant-select-selection-search'])[1]//input[@type='search'][1]");
    public By clickTo = By.xpath("(//div[@class='ant-select-selection-search'])[1]");
    public By buttonTo = By.xpath("(//span[normalize-space()='TO:'])[1]");
    public By buttonAddTo = By.xpath("(//span[contains(text(),'Add')])[1]");
    public By buttonAddCC = By.xpath("(//tbody[@class='ant-table-tbody'])[2]//tr[3]//td[3]//button//span");
    public By buttonCloseTo = By.xpath("(//button[@class='sc-hKMtZM xCkZK'][normalize-space()='Close'])[1]");
    public By buttonCloseCC = By.xpath("(//button[@class='sc-hKMtZM xCkZK'][normalize-space()='Close'])[2]");

    public By boxCC = By.xpath("(//div[@class='ant-select-selection-overflow'])[2]");
    public By buttonCC = By.xpath("(//span[normalize-space()='CC:'])[1]");
    public By inputCC = By.xpath("//input[@id='rc_select_5']");
    public By sortMessage = By.xpath("//table/tbody/tr[1]/td[1]/div//div[1]");
    public By sortDate = By.xpath("(//table//div[normalize-space()])[6]");


    public By inputSubject = By.xpath("//input[@name='subject']");
    public By buttonSave = By.xpath("(//div[@class='editor relative'])[1]//button[@type='submit']");
    public By buttonSaveinDraft = By.xpath("(//div[@class='page-content bg-white '])[1]//div[@class='editor relative']//button[@type='submit']");
    public By buttonDrafts = By.xpath("(//div[@class='rowIcon false'])[2]");

    public By selectatDropdownTo = By.xpath("//span[normalize-space()='Class auto TA (Class)']");
    public By selectatDropdownToadmin = By.xpath("//span[normalize-space()='teacher, anh2 (Teacher)']");
    public By selectatDropdownCC = By.xpath("//span[normalize-space()='stu1, anh (Student)']");
    public By messageWarrningSubject = By.xpath("//span[normalize-space()='This field is required.']");
    public By toolbarB = By.xpath("(//div[@class='note-btn-group btn-group note-style'])[1]//button[@type='button'][1]//i[1]");
    public By toolbarI = By.xpath("(//div[@class='note-btn-group btn-group note-style'])[1]//button[2]");
    public By toolbarU = By.xpath("(//div[@class='note-btn-group btn-group note-style'])[1]//button[3]");
    public By textBox = By.xpath("//div[@role='textbox']");
    public By contentB = By.xpath("//b[normalize-space()='test B']");
    public By contentI = By.xpath("//i[normalize-space()='test I']");
    public By contentU = By.xpath("//u[normalize-space()='test U']");
    public By fontArial = By.xpath("//div[@class='note-editing-area']//div[@class='note-editable']//span[1]");
    public By unorderedlist = By.xpath("//i[@class='note-icon-unorderedlist']");
    public By unorderedlistintextbox = By.xpath("//u[normalize-space()='test U']");
    public By orderedlist = By.xpath("//button[@aria-label='Ordered list (CTRL+SHIFT+NUM8)']");
    public By paragraph = By.xpath("//button[@aria-label='Paragraph']");
    public By alignleft = By.xpath("(//i[@class='note-icon-align-left'])[2]");
    public By aligncenter = By.xpath("//i[@class='note-icon-align-center']");
    public By alignright = By.xpath("//i[@class='note-icon-align-right']");
    public By fontText = By.xpath("//span[@class='note-current-fontname']");
    public By specificfontTextArial = By.xpath("//span[normalize-space()='Arial']");
    public By specificfontTextTime = By.xpath("//span[normalize-space()='Times New Roman']");
    public By buttonSend = By.xpath("(//div[@class='page-content bg-white '])[1]//div[@class!='editor relative']//button[@type='submit']");
    public By sendfolder = By.xpath("(//div[@class='rowIcon false'])[1]");
    public By sendfolder2 = By.xpath("(//div[@class='rowIcon false'])[2]");
    public By alertblankTo = By.xpath("//div[@class='ant-modal-confirm-body']");
    public By messageinAlertTo = By.xpath("//div[@class='ant-modal-confirm-content']");
    public By inboxfolder = By.xpath("//div[@class='rowIcon textBold']");
    public By iconSortFrom_to = By.xpath("(//div[@class='ant-table-column-sorters'])[1]//span[@class='ant-table-column-title'][1]");
    public By iconSortDate = By.xpath("//th[@class='ant-table-cell ant-table-column-has-sorters'][1]//div[1]//span[@class='ant-table-column-title']");
    public By boxSearch = By.xpath("(//input[@placeholder='Search for Messages'])[1]");
    public By iconsearch = By.xpath("(//div[@class='submit-search'])[1]");
    public By messagesearchInvalid = By.xpath("(//tr[@class='ant-table-placeholder'])[1]//td[1]//div[1]");
    public By mailinInbox = By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]//td[@class='ant-table-cell'][1]//div[2]");
    public By mailinSend = By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]//td[@class='ant-table-cell'][1]//div[2]");
    public By iconReply = By.xpath("(//i[@class='icon-reply fs1'])[1]");
    public By iconReplyall = By.xpath("//button[3]//*[name()='svg']");
    public By textboxReply = By.xpath("(//div)[67]");
    public By buttonForward = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionLeft'][1]//button[2]");
    public By buttonForwardIbox = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionLeft'][1]//button[4]");
    public By mailafterForward = By.xpath("//tbody/tr[1]/td[1]/div[1]");
    public By iconPreviousinmail = By.xpath("(//div[@class='stepControl'])[1]//button[1]");
    public By iconNextinmail = By.xpath("(//div[@class='stepControl'])[1]//button[2]");
   // public By titleMailTestC = By.xpath("(//h4[normalize-space()='test C'])[1]");
    public By titleMail = By.xpath("//h4[normalize-space()]");
    public By iconDelete = By.xpath("(//table)[1]//tr[1]//td[3]//*[name()='svg']");
    public By iconDeleteinMail = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionLeft'][1]//button[1]");
    public By iconSendinDraft = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionRight'][1]//button[1]");
    public By messageconfirmSendDaft = By.xpath("(//div[@class='ant-modal-content'])[1]//div[@class='ant-modal-body']//p");
    public By buttonSendPopupinDraft = By.xpath("(//div[@class='ant-modal-body'])[1]//button[normalize-space()='Send'][1]");
    public By composeMessage = By.xpath("(//section[@class='sc-fmRtwQ iPHaBn'])[1]");
    public By buttonViewMessage = By.xpath("(//button[normalize-space()='View message'])[1]");
    public By mailinTrash = By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]//td[@class='ant-table-cell'][1]//div[2]");
    public By iconUnDeleteinMail = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionLeft'][1]//button[2]");
    public By buttonUnDeleteinPopup = By.xpath("(//span[normalize-space()='Un-delete'])[1]");
    public By messageUnDelete = By.xpath("(//div[@class='ant-alert-content'])[1]//div[1]");
    public By messagdelelesuccess = By.xpath("(//div[@role='alert'])[1]");
    public By buttonDeletePopup = By.xpath("(//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn'])[1]");//(//span[normalize-space()='Delete'])[1]
    public By buttonDeletePopupinmail = By.xpath("(//span[normalize-space()='Delete'])[1]");
    public By buttonDeleteinMail = By.xpath("(//button[@type='button'])[3]");
    public By subjectinDraft = By.xpath("(//div[contains(text(),'test B')])[1]");
    public By mailinDraft = By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]//td[@class='ant-table-cell'][1]//div[2]");
    public By iconXinTo = By.xpath("(//span[@aria-label='close'])[1]");
    public By buttonEdit = By.xpath("(//div[@class='buttonActions'])[1]//div[@class='actionLeft'][1]//button[2]");
    public By trashfolder = By.xpath("//li[4]//div[1]");
    public By trashfolderBold = By.xpath("//div[@class='rowIcon textBold']");
    private static final MessageStudentModel messageStudentModel = new MessageStudentModel();
    public static final String pageUrl_Draft = "/messages/listMessage.html?category=DRAFTS";
    public static final String pageUrl_Sent = "/messages/listMessage.html?category=SENT";
    public static final String pageUrl_Trash = "/messages/listMessage.html?category=TRASH";


    public MessagePageSC openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }

    public ManageStudentsPageSC openClientPage() {
        WebUI.clickElement(menuClients);
        return new ManageStudentsPageSC();
    }

    public ProjectPageSC openProjectPage() {
        WebUI.clickElement(menuProjects);
        return new ProjectPageSC();
    }
    public void checkAddUserIntoField(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Enter keyword and select user*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.setText(inputTo, data.get(MessageTeacherModel.getTo()));
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownTo); // User selected show in text box To
        WebUI.sleep(6);
        /*expected:User selected show in To/Cc fiels*/
        WebUI.verifyElementText(boxTo,"Class auto TA (Class)");
        WebUI.sleep(5);
        WebUI.clickElement(boxCC);
        WebUI.setText(inputCC, data.get(MessageTeacherModel.getCc()));
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownCC);//User selected show in text box CC
        WebUI.sleep(5);
        /*expected:User selected show in To/Cc fiels*/
        WebUI.verifyElementText(boxCC,"stu1, anh (Student)");
        WebUI.waitForPageLoaded();
    }
    public void checkAddUserinListUser(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Select To/Cc label - Add user*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(buttonTo); //Show list user to add
        WebUI.sleep(5);
        WebUI.clickElement(buttonAddTo); //User shown in text box To
        WebUI.sleep(5);
        WebUI.clickElement(buttonCloseTo);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCC);
        WebUI.sleep(5);
        WebUI.clickElement(buttonAddCC);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCloseCC);
        WebUI.sleep(5);
        /*expected:User selected show in To fiels */
        WebUI.verifyElementText(boxTo,"1, admin (Administrator)");
        WebUI.sleep(5);
        WebUI.verifyElementText(boxCC,"1a, Verify (Administrator)");
    }

    /*public void checkAddUserIntoField() {
        WebUI.clickElement(iconLetter);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        //WebUI.setText(inputTo, excelHelpers.getCellData(2, MessageTeacherModel.getTo()));
        WebUI.setText(inputTo, "Class auto TA");
        WebUI.clickElement(selectatDropdownTo);
        WebUI.verifyElementText(boxTo, "Class auto TA (Class)");
        WebUI.clickElement(boxCC);
        WebUI.setText(inputCC, "anh");
        WebUI.clickElement(selectatDropdownCC);
        WebUI.verifyElementText(boxCC, "stu1, anh (Student)");*/



    public void checkSaveMessage(Hashtable<String, String> data) {
       /* 1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Enter Subject
        5. Select Save icon*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.sleep(5);
        WebUI.setText(inputSubject, data.get(MessageTeacherModel.getSubject()));
        WebUI.sleep(5);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(5);
        /*Save and move the message to Drafts item*/
        WebUI.verifyElementText(mailinTrash,data.get(MessageTeacherModel.getSubject()));
    }
    /*public void checkSaveMessage() {
        WebUI.clickElement(iconLetter);
        WebUI.clickElement(iconPlus);
        WebUI.clickElement(inputSubject);
        WebUI.setText(inputSubject, "abc");
        WebUI.verifyElementText(inputSubject, "abc");
        WebUI.clickElement(buttonSave);
        WebUI.verifyElementPresent(buttonDrafts, "abc");
*/

    public void checkCannotSaveMessage() {
       /* 1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Not input Subject
        5. Select Save icon*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.sleep(5);
        WebUI.setText(inputSubject, "");
        WebUI.sleep(5);
        WebUI.clickElement(buttonSave);
        /* Show warning message " This field is required" (red) below Subject filed*/
        WebUI.verifyElementText(messageWarrningSubject, FrameworkConstants.REQUIRED_MESSAGE);


    }

    public void checkUseToolbar() {
      /*  1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Use Toolbar*/
        WebUI.waitForPageLoaded();
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        WebUI.sleep(5);
        WebUI.setText(textBox, "test B");
        Actions actions = new Actions(DriverManager.getDriver());
        actions.click(WebUI.getWebElement(textBox)).build().perform();
//actions.moveToElement(getWebElement(by)).click().build();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        //WebUI.scrollToPosition(0,70);
        WebUI.scrollToElementToBottom(toolbarB);
        WebUI.clickElement(toolbarB);
        /*The content must be displayed reflecting the selected functions in the toolbar*/
        WebUI.verifyElementText(contentB, "test B"); //bold text
        WebUI.clickElement(contentB);
        WebUI.clearText(contentB);
        WebUI.setText(textBox, "test I");
        actions.click(WebUI.getWebElement(textBox)).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        WebUI.clickElement(toolbarI);
        /*The content must be displayed reflecting the selected functions in the toolbar*/
        WebUI.verifyElementText(contentI, "test I"); //I text
        WebUI.clickElement(textBox);
        WebUI.clearText(textBox);
        WebUI.setText(textBox, "test U");
        actions.click(WebUI.getWebElement(textBox)).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        WebUI.clickElement(toolbarU);
        /*The content must be displayed reflecting the selected functions in the toolbar*/
        WebUI.verifyElementText(contentU, "test U"); //U text
        WebUI.clickElement(unorderedlist);
        WebUI.clickElement(orderedlist);
        WebUI.clickElement(paragraph);
        WebUI.clickElement(aligncenter);
        WebUI.clickElement(fontText);
        WebUI.clickElement(specificfontTextArial);
        String font = WebUI.getCssValueElement(fontArial, "font-family");
        /*The content must be displayed reflecting the selected functions in the toolbar*/
        WebUI.verifyEquals(font, "Arial");

    }

    public void checkSendMessage() {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Input User into To/Cc
        5. Enter Message content
        6. Select Send button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        //WebUI.setText(inputTo, excelHelpers.getCellData(2, MessageTeacherModel.getTo()));
        WebUI.setText(inputTo, "Class auto TA");
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownTo);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.clickElement(boxCC);
        WebUI.setText(inputCC, "anh");
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownCC);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.setText(inputSubject, "test send");
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, "test send email");
        //WebUI.scrollToPosition(0,200);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(5);
        /*Send and move the message to Sent item*/
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinSend, "test send");


    }

    public void checkCanNotSendMessage(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Not input Subject
        5. Select Send button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        //WebUI.setText(inputTo, excelHelpers.getCellData(2, MessageTeacherModel.getTo()));
        WebUI.setText(inputTo, "Class auto TA");
        WebUI.clickElement(selectatDropdownTo);
        WebUI.sleep(5);
        WebUI.verifyElementText(boxTo, "Class auto TA (Class)");
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.clickElement(boxCC);
        WebUI.sleep(5);
        WebUI.setText(inputCC, "anh");
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownCC);
        WebUI.verifyElementText(boxCC, "stu1, anh (Student)");
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(MessageTeacherModel.getContent()));
        WebUI.verifyElementText(textBox,"test send email");
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(5);
        /*Show warning message " This field is required" (red) below Subject filed*/
        WebUI.verifyElementText(messageWarrningSubject, FrameworkConstants.REQUIRED_MESSAGE);
        WebUI.sleep(5);


    }
    public void checkCanNotSendMessagewithoutuser(Hashtable<String, String> data) {
       /* 1. Login as Teacher
        2. Select Message icon
        3. Select Plus icon to Compose Message
        4. Not choose user in To field
        5. Select Send button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.sleep(5);
        WebUI.setText(inputSubject, "TA trial");
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox, data.get(MessageTeacherModel.getContent()));
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(5);
        /*Show warning popup" Please input at least one name in the To"*/
       /* WebUI.verifyElementPresent(alertblankTo,"Please input at least one name in the To");*/
        WebUI.verifyElementText(messageinAlertTo,"Please input at least one name in the To");


    }

    public void checkViewMesssage_Reply(Hashtable<String, String> data) {
      /*  1. Login as Teacher
        2. Select Message icon
        3. Select Inbox item
        4. Open Message
        5. Select Reply buttons
        6. Select Send Button in Compose message*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinInbox);
        WebUI.sleep(5);
        WebUI.clickElement(iconReply);
        WebUI.sleep(5);
        WebUI.clickElement(textboxReply);
        WebUI.setText(textboxReply,"reply");
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(5);
        /*6. Sent reply message and this message stay in Sent items*/
        WebUI.verifyElementText(mailinSend, "Re:TA trial");


    }
    public void checkViewMesssage_Replyall(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Inbox item
        4. Open Message
        5. Select Reply_all buttons
        6. Select Send Button in Compose message*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinInbox);
        WebUI.clickElement(iconReplyall);
        WebUI.sleep(5);
        //WebUI.scrollToPosition(0,170);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(5);
       /* 6. Sent reply message and this message stay in Sent items"*/
        WebUI.verifyElementText(mailinSend, "Re:TA trial");


    }
    public void checkViewIboxMesssage_Forward(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Inbox item
        4. Open Message
        5. Select Forward button
        6. Input User in To/Cc
        7. Select Send button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinInbox);
        WebUI.sleep(5);
        WebUI.clickElement(buttonForwardIbox);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.setText(inputTo, data.get(MessageTeacherModel.getTo()));
        WebUI.clickElement(selectatDropdownTo);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.clickElement(boxCC);
        WebUI.setText(inputCC, data.get(MessageTeacherModel.getCc()));
        WebUI.clickElement(selectatDropdownCC);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        /*7. Sent forward message and this message stay in Sent items */
        WebUI.sleep(7);
        WebUI.verifyElementText(mailinSend, "FW:TA trial");

    }
    public void adminsendmessage(Hashtable<String, String> data) {
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.setText(inputToAdmin, "anh2");
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownToadmin);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.setText(inputSubject,"TA trial");
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        WebUI.sleep(7);

    }
    public void checkDeleteMessageinInbox(Hashtable<String, String> data) {
       /* 1. Login as Teacher
        2. Select Message icon
        3. Select Inbox item
        4. Select Trash button on message
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopup);
        /*  Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess, "Message has been deleted successfully");
        // Move deleted messages to trash
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinTrash, "TA trial");
    }
    public void CheckDeleteMessagebySelectTrashbuttononmessageOpenMessageandselectTrashicon(Hashtable<String, String> data) {
       /* 1. Login as Teacher
        2. Select Message icon
        3. Select Inbox item
        4.Open Message and select Trash icon
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinInbox);
        WebUI.sleep(5);
        WebUI.clickElement(iconDeleteinMail);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopupinmail);
       /* 5. Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess, "Message has been deleted successfully");
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinTrash, "TA trial");

    }
    public void checkViewSendMesssage_Forward(Hashtable<String, String> data) {
        /*1. Login as Teacher
        2. Select Message icon
        3. Select Sent item
        4. Open Message
        5. Select Forward button
        6. Input User in To/Cc
        7. Select Send button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonForward);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.setText(inputTo, data.get(MessageTeacherModel.getTo()));
        WebUI.clickElement(selectatDropdownTo);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.sleep(5);
        WebUI.clickElement(boxCC);
        WebUI.setText(inputCC, data.get(MessageTeacherModel.getCc()));
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownCC);
        WebUI.sleep(5);
        WebUI.scrollToElementToBottom(buttonSend);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSend);
        /*7. Sent forward message and this message stay in Sent items "*/
        WebUI.sleep(5);
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessagePageSC.pageUrl_Sent);
        WebUI.verifyElementText(mailinSend, "FW:FW:TA trial");

    }
    public void checkDeleteMessageinSend(Hashtable<String, String> data) {
/*        1. Login as Teacher
        2. Select Message icon
        3. Select Sent item
        4. Select Trash button on message
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopup);
       /* 5. Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess,"Message has been deleted successfully");
        // Move deleted message to trash
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinTrash, "FW:FW:TA trial");



    }
    public void checkDeleteMessageinSendopenMail(Hashtable<String, String> data) {
 /*       1. Login as Teacher
        2. Select Message icon
        3. Select Sent item
        4. Open Message and select Trash icon"
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinSend);
        WebUI.sleep(5);
        WebUI.clickElement(iconDeleteinMail);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopup);
       /* Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess,"Message has been deleted successfully");
        // Move deleted message to trash
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.verifyElementText(mailinTrash, "Re:TA trial");

    }
    public void checkEditmessage(Hashtable<String, String> data) {
  /*    1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message
        5. Select Pen icon
        6. Input Content to Edit
        7. Select Save button*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDrafts);
        WebUI.sleep(5);
        WebUI.clickElement(mailinDraft);
        WebUI.sleep(5);
        WebUI.clickElement(buttonEdit);
        WebUI.sleep(5);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox,"edit");
        WebUI.sleep(5);
       // WebUI.scrollToPosition(0,50);
        WebUI.scrollToElementToBottom(buttonSaveinDraft);
        WebUI.clickElement(buttonSaveinDraft);
        /* Message saved and back to Draft item"*/
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinDraft, "test B");
    }
   /* public void checkSendmessageInDraft(Hashtable<String, String> data) {
 *//*     1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message
        5. Select Send icon
        6. Select Send button on Popup*//*
        WebUI.waitForPageLoaded();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(iconLetter);
        WebUI.clickElement(buttonDrafts);
        WebUI.clickElement(mailinDraft);
        WebUI.clickElement(buttonEdit);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox,"edit");
        WebUI.clickElement(boxTo);
        String valueinTo = WebUI.getTextElement(boxTo);
        if (Objects.equals(valueinTo, "")){
            WebUI.setText(inputTo,data.get(MessageTeacherModel.getTo()));
            WebUI.clickElement(selectatDropdownTo);
            WebUI.clickElement(buttonSend); // message send success
        } else {
            WebUI.clickElement(buttonSend);
        }
 *//*     5. Show popup confirm Send Message
        6.Send and move the message to Sent item"*//*
    }*/
    public void checkSendmessageInDraft(Hashtable<String, String> data) {
 /*     1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message
        5. Select Send icon
        6. Select Send button on Popup*/
        WebUI.waitForPageLoaded();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(boxTo);
        WebUI.setText(inputTo,"Class auto TA");
        WebUI.sleep(5);
        WebUI.clickElement(selectatDropdownTo);
        WebUI.sleep(5);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.setText(inputSubject,"test");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(5);
        WebUI.clickElement(mailinDraft);
        WebUI.sleep(5);
        WebUI.clickElement(iconSendinDraft);
        /*Show popup confirm Send Message*/
        WebUI.verifyElementText(messageconfirmSendDaft,"Are you sure you want to send this draft message?");
        WebUI.clickElement(buttonSendPopupinDraft);
        /*6.Send and move the message to Sent item"*/
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder2);
        WebUI.sleep(5);
        WebUI.verifyElementText(mailinSend, "test");
    }
    public void checkCannotSendmessageInDraft(Hashtable<String, String> data) {
 /*     1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message
        5. Select Send icon
        6. Select Send button on Popup
        7. Select View message button*/
        WebUI.waitForPageLoaded();
        WebUI.waitForPageLoaded();
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(iconPlus);
        WebUI.sleep(5);
        WebUI.clickElement(inputSubject);
        WebUI.setText(inputSubject, "test");
        WebUI.sleep(5);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(5);
        WebUI.clickElement(mailinDraft);
        WebUI.sleep(5);
        WebUI.clickElement(iconSendinDraft);
        WebUI.sleep(5);
        WebUI.clickElement(buttonSendPopupinDraft);
        WebUI.sleep(5);
       /* "6. Show error popup " " Cannot send the draft message"*/
        WebUI.verifyElementText(messageconfirmSendDaft, "Cannot send the draft message.");
        WebUI.clickElement(buttonViewMessage);
        WebUI.sleep(5);
        WebUI.verifyElementVisible(composeMessage);
    }
  /*  public void checkCannotSendmessageInDraft(Hashtable<String, String> data) {
 *//*     1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message
        5. Select Send icon
        6. Select Send button on Popup
        7. Select View message button*//*
        WebUI.clickElement(iconLetter);
        WebUI.clickElement(buttonDrafts);
        WebUI.clickElement(mailinDraft);
        WebUI.clickElement(buttonEdit);
        WebUI.clickElement(textBox);
        WebUI.setText(textBox,"edit");
        WebUI.clickElement(clickTo);
        String textBoxValue = WebUI.getTextElement(boxTo);
        if (Objects.equals(textBoxValue,"")){
            WebUI.clickElement(buttonSend);
        } else {
            WebUI.clickElement(iconXinTo);
            WebUI.clickElement(buttonSend);
        }
        WebUI.verifyElementPresent(alertblankTo,"Please input at least one name in the To");
 *//*
        7. Move to Compose Message page with Keep the entire content before the message is saved "*//*
    }*/
    public void checkDeleteSendmessageInDraft(Hashtable<String, String> data) {
 /*       1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Select Trash button on message
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDrafts);
        WebUI.sleep(5);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopup);
        WebUI.sleep(5);
        /*Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess,"Message has been deleted successfully");

    }
    public void checkDeleteSendmessageInDraftwhenopenmail(Hashtable<String, String> data) {
/*        1. Login as Teacher
        2. Select Message icon
        3. Select Drafts item
        4. Open Message and select Trash icon"
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDrafts);
        WebUI.sleep(5);
        WebUI.clickElement(mailinDraft);
        WebUI.sleep(5);
        WebUI.clickElement(iconDeleteinMail);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopupinmail);
        WebUI.sleep(5);
        /*Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess, "Message has been deleted successfully");
    }

    public void checkUnDeleteSendmessage(Hashtable<String, String> data) {
       /*1. Login as Teacher
        2. Select Message icon
        3. Select Trash item
        4. Open Message
        5. Select unDelete icon
        6. Select Un-Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinTrash);
        WebUI.sleep(5);
        WebUI.clickElement(iconUnDeleteinMail);
        WebUI.sleep(5);
        WebUI.clickElement(buttonUnDeleteinPopup);
        WebUI.sleep(5);
      //  Show message un-delete successfully//
        WebUI.verifyElementText(messageUnDelete,"Message has been un-deleted successfully");

    }
    public void checkDeleteSendMessageinTrash(Hashtable<String, String> data) {
/*      1. Login as Teacher
        2. Select Message icon
        3. Select Trash item
        4. Select Trash button on message
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopup);
        WebUI.sleep(5);
        /*Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess,"Message has been deleted successfully");

    }
    public void checkDeleteSendMessageInTrashOpenMail(Hashtable<String, String> data) {
/*        1. Login as Teacher
        2. Select Message icon
        3. Select Trash item
        4. Open Message and select Trash icon"
        5. Select Delete button on popup confirm*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinTrash);
        WebUI.sleep(5);
        WebUI.clickElement(iconDeleteinMail);
        WebUI.sleep(5);
        WebUI.clickElement(buttonDeletePopupinmail);
        WebUI.sleep(5);
        /*Delete the message and show message delete successfully*/
        WebUI.verifyElementText(messagdelelesuccess,"Message has been deleted successfully");

    }
    public void checkNextPreviousButtonsMessage(Hashtable<String, String> data) {
/*      1. Login as Teacher
        2. Select Message icon
        3. Select items
        4. Open Message
        5. Select Next bụttons
        6. Select Previous bụttons*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        WebUI.clickElement(mailinSend);
     /*   Next button ---> Move to next message*/
        WebUI.clickElement(iconNextinmail);
        WebUI.sleep(5);
        WebUI.verifyElementText(titleMail, "test B");
       /* 6. Previous button --> Move to previous message"*/
        WebUI.clickElement(iconPreviousinmail);
        WebUI.sleep(5);
        WebUI.verifyElementText(titleMail, "test C");
        WebUI.sleep(5);

    }
    public void checkSortMessageWithFrom_To(Hashtable<String, String> data) {
  /*      1. Login as Teacher
        2. Select Message icon
        3. Select items
        4. Select From/To filter
        5. Select Date Received/Sent filter*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        //Check sort by From/To A> Z//
        WebUI.clickElement(iconSortFrom_to);
        WebUI.sleep(5);
        WebUI.verifyElementText(sortMessage, "1, admin");
        //Check sort by From/To Z> A//
        WebUI.clickElement(iconSortFrom_to);
        WebUI.sleep(5);
        WebUI.verifyElementText(sortMessage, "Tran, Dat");
        //Check sort by Recent > Furthest date//
        WebUI.verifyElementText(sortDate, "10/20/2022");
        //Check sort by Furthest > recent date
        WebUI.clickElement(iconSortDate);
        WebUI.sleep(5);
        WebUI.verifyElementText(sortDate, "08/03/2022");

    }
    public void checkSearchMessageInvalid(Hashtable<String, String> data) {
/*        1. Login as Teacher
        2. Select Message icon
        3. Select item want to search
        4. Select Search for Message textbox
        5. Input keyword invalid
        6. Select magnifying glass icon*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(inboxfolder);
        WebUI.sleep(5);
        WebUI.clickElement(boxSearch);
        WebUI.setText(boxSearch,"stuinvalid");
        WebUI.clickElement(iconsearch);
       /* "Show message
        Inbox: Your inbox is currently empty*/
        WebUI.verifyElementText(messagesearchInvalid,"Your inbox is currently empty.");
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.sleep(5);
        WebUI.clickElement(iconsearch);
        /* "Show message
        Inbox:You have not sent any messages.*/
        WebUI.verifyElementText(messagesearchInvalid,"You have not sent any messages.");
        WebUI.sleep(5);
        WebUI.clickElement(buttonDrafts);
        WebUI.sleep(5);
        WebUI.clickElement(iconsearch);
        /* "Show message
        Inbox:You have no draft messages.*/
        WebUI.verifyElementText(messagesearchInvalid,"You have no draft messages.");
        WebUI.sleep(5);
        WebUI.clickElement(trashfolder);
        WebUI.sleep(5);
        WebUI.clickElement(iconsearch);
        /* "Show message
        Inbox:You have no deleted messages.*/
        WebUI.verifyElementText(messagesearchInvalid,"You have no deleted messages.");

    }
    public void checkSearchMessageValid(Hashtable<String, String> data) {
   /*     1. Login as Teacher
        2. Select Message icon
        3. Select item want to search
        4. Select Search for Message textbox
        5. Input keyword valid
        6. Select magnifying glass icon*/
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(sendfolder);
        WebUI.clickElement(boxSearch);
        WebUI.setText(boxSearch,"admin");
        WebUI.clickElement(iconsearch);
        WebUI.sleep(5);
/*        Show messages related with keyword*/
       /* WebUI.verifyElementText(tableMessage,"admin");*/
        String tableText = WebUI.getTextElement(tableMessage);
        WebUI.verifyContains(tableText, "admin");

    }
}