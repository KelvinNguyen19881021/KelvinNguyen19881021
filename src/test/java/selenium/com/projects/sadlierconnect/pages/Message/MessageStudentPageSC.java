package selenium.com.projects.sadlierconnect.pages.Message;

import net.datafaker.providers.entertainment.BackToTheFuture;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.models.ManageParentModel;
import selenium.com.projects.sadlierconnect.models.MessageStudentModel;
import selenium.com.projects.sadlierconnect.pages.CommonPageSC;
import selenium.com.projects.sadlierconnect.pages.Dashboard.DashboardPageSC;
import selenium.com.projects.sadlierconnect.pages.ManageStudents.ManageStudentsPageSC;
import selenium.com.projects.sadlierconnect.pages.Projects.ProjectPageSC;

import java.util.Hashtable;


public class MessageStudentPageSC extends CommonPageSC {
    private static final ExcelHelpers excelHelpers = new ExcelHelpers();
    public MessageStudentPageSC() {
        super();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_MESSAGE_STUDENT_SC_PATH, "MessageStudent");
    }
    private static final MessageStudentModel messageStudentModel = new MessageStudentModel();
    public static final String pageUrl_Draft = "/messages/listMessage.html?category=DRAFTS";
    public static final String pageUrl_Sent = "/messages/listMessage.html?category=SENT";
    public static final String pageUrl_Compose = "/messages/composeMessage.html";

    public By iconLetter = By.xpath("//a[@class='ant-dropdown-trigger ant-dropdown-link']//*[name()='svg']");
    public By buttonCompose = By.xpath("//span[@aria-label='plus-circle']//*[name()='svg']");
    public By iconInbox = By.xpath("//div[@class='rowIcon textBold']//*[name()='svg']");
    public By iconSent = By.xpath("//li[2]//div[1]//*[name()='svg']");
    public By iconDrafts = By.xpath("(//*[name()='svg'])[10]");
    public By iconTrash = By.xpath("(//*[name()='svg'])[11]");
    public By textBoxTo = By.xpath("(//div[@class='ant-select-selection-overflow'])[1]");
    public By textBoxCc = By.xpath("(//div[@class='ant-select-selection-overflow'])[2]");
    public By inputTo = By.xpath("//input[@id='rc_select_2']");
    public By inputCc = By.xpath("//input[@id='rc_select_3']");
    public By labelTo = By.xpath("//span[normalize-space()='TO:']");
    public By labelCc = By.xpath("//span[normalize-space()='CC:']");
    public By btnAddinlabelTo = By.xpath("(//span[contains(text(),'Add')])[1]");
    public By btnCloseinlabelTo = By.xpath("(//button[normalize-space()='Close'])[1]");
    public By btnAddinlabelCc = By.xpath("(//span[contains(text(),'Add')])[3]");
    public By btnCloseinlabelCc = By.xpath("(//button[contains(text(),'Close')])[2]");
    public By editTo = By.xpath("//span[normalize-space()='1, Teacher (Teacher)']");
    public By editCc = By.xpath("//span[normalize-space()='Tch, Pen (Teacher)']");
    public By inputTextBoxTo  = By.xpath("(//span[@class='ant-select-selection-item'])[1]");
    public By inputTextBoxCc  = By.xpath("(//span[@class='ant-select-selection-item'])[2]");
    public By inputTextBoxSubject  = By.xpath("//input[@name='subject']");
    public By messageRequiredSubject  = By.xpath("//span[normalize-space()='This field is required.']");
    public By iconSave  = By.xpath("//button[@class='absolute cursor-default sc-lkwKjF hqUUwg']");
    public By iconBold  = By.xpath("//i[@class='note-icon-bold']");
    public By iconItalic  = By.xpath("//i[@class='note-icon-italic']");
    public By iconUnderline  = By.xpath("//i[@class='note-icon-underline']");
    public By iconFont  = By.xpath("//span[@class='note-current-fontname']");
    public By fontText  = By.xpath("//span[normalize-space()='Arial']");
    public By iconPointList  = By.xpath("//i[@class='note-icon-unorderedlist']");
    public By iconNumberList  = By.xpath("//i[@class='note-icon-orderedlist']");
    public By iconParagraph  = By.xpath("//button[@aria-label='Paragraph']//i[@class='note-icon-align-left']");
    public By iconCenterInParagraph  = By.xpath("//i[@class='note-icon-align-center']");
    public By inputTextBoxBody  = By.xpath("//div[@role='textbox']");
    public By inputTextBoxBodyInReply  = By.xpath("//div[@role='textbox']//div[1]");
    public By btnSend  = By.xpath("(//span[normalize-space()='Send'])");
    public By popupWarningMissingTo  = By.xpath("//div[@class='ant-modal-confirm-content']");
    public By viewMessage  = By.xpath("(//td[@class='ant-table-cell'])[1]//div[1]");
    public By iconReply  = By.xpath("(//i[@class='icon-reply fs1'])[1]");
    public By iconForwardInMessageInbox  = By.xpath("//button[3]//*[name()='svg']");
    public By iconDelete  = By.xpath("(//*[name()='svg'])[16]");
    public By iconDeleteinDraft  = By.xpath("(//div[@class='flex items-center gap-1 cursor-pointer'])[1]");
    public By iconDeleteInMessage  = By.xpath("//div[@class='actionLeft']//button[1]//*[name()='svg']");
    public By btnDeleteMessage  = By.xpath("//span[normalize-space()='Delete']");
    public By flashMessage  = By.xpath("//div[@role='alert']");
    public By iconForwardInMessageSent  = By.xpath("//div[@class='buttonActions']//button[2]//*[name()='svg']");
    public By iconEdit  = By.xpath("//div[@class='buttonActions']//button[2]//*[name()='svg']");
    public By iconSendinDrafts  = By.xpath("//div[@class='actionRight']//button[@type='button']//*[name()='svg']");
    public By btnSendInDraft  = By.xpath("(//button[normalize-space()='Send'])");
    public By btnViewMessageinDraft  = By.xpath("//button[normalize-space()='View message']");
    public By iconUnDelete  = By.xpath("//div[@class='buttonActions']//button[2]//*[name()='svg']");
    public By btnUnDelete  = By.xpath("//button[@class='ant-btn ant-btn-primary sc-gsnTZi hElntn']");
    public By iconNextMessage  = By.xpath("//div[@class='stepControl']//button[2]//*[name()='svg']");
    public By iconPreviousMessage  = By.xpath("//div[@class='stepControl']//button[1]//*[name()='svg']");
    public By filterFromTo  = By.xpath("(//div[@class='ant-table-column-sorters'])[1]");
    public By filterDate  = By.xpath("(//div[@class='ant-table-column-sorters'])[2]");
    public By inputSearchMessage  = By.xpath("//input[@placeholder='Search for Messages']");
    public By iconSearch  = By.xpath("//div[@class='submit-search']//*[name()='svg']");
    public By notfoundMessage  = By.xpath("//div[@class='text-left']");
    public By tableMessage  = By.xpath("(//div[@class='containInbox'][normalize-space()='save message'])");
    public By contentMessage  = By.xpath("//h4[normalize-space()]");
    public By sortMessagebyUser  = By.xpath("//table/tbody/tr[1]/td[1]/div/div[1]");
    public By sortMessagebyDate  = By.xpath("//tbody/tr[1]/td[2]/div[1]");
    public By firstMessageinTable  = By.xpath("(//div[@class='containInbox'])[1]");




    public void checkAddUserIntoToCCFieldsByKeyword(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(buttonCompose);
        WebUI.sleep(2);
        WebUI.clickElement(textBoxTo);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(3);
        WebUI.clickElement(editTo);
        WebUI.sleep(2);
        WebUI.clickElement(textBoxCc);
        WebUI.sleep(2);
        WebUI.setText(inputCc, data.get(messageStudentModel.getCc()));
        WebUI.sleep(3);
        WebUI.clickElement(editCc);
        //[CP]_Check Add User Into To/Cc Fields by Keyword
        WebUI.verifyElementText(inputTextBoxTo,"1, Teacher (Teacher)");
        WebUI.verifyElementText(inputTextBoxCc,"Tch, Pen (Teacher)");
        WebUI.sleep(2);
    }

    public void checkAddUserIntoToCCFieldsByLabelToCc()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCompose);
        WebUI.sleep(2);
        WebUI.clickElement(labelTo);
        WebUI.sleep(2);
        WebUI.clickElement(btnAddinlabelTo);
        WebUI.sleep(2);
        WebUI.clickElement(btnCloseinlabelTo);
        WebUI.sleep(2);
        WebUI.clickElement(labelCc);
        WebUI.sleep(2);
        WebUI.clickElement(btnAddinlabelCc);
        WebUI.sleep(2);
        WebUI.clickElement(btnCloseinlabelCc);
        WebUI.sleep(2);
        //[CP]_Check Add User Into To/Cc Fields by Label To/Cc
        WebUI.verifyElementText(inputTextBoxTo, "1, Teacher (Teacher)" );
        WebUI.verifyElementText(inputTextBoxCc, "Tch, Pen (Teacher)" );
        WebUI.sleep(5);
    }

    public void checkSaveMessages(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCompose);
        WebUI.setText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.clickElement(iconSave,5);
        WebUI.sleep(3);
        //[CP]_Check Save and move message to Drafts Item
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Draft);
        WebUI.sleep(2);
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(5);
    }

    public void checkCanNotSaveMessages()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCompose);
        WebUI.clickElement(iconSave);
        //[CP]_Check Save Message unSuccess
        WebUI.verifyElementText(messageRequiredSubject, "This field is required.");
        WebUI.sleep(2);
    }
    //[CP]_Check Use Toolbar
    public void checkUseToolbar()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(buttonCompose);
        WebUI.sleep(2);
        WebUI.clickElement(iconBold);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, "bold");
        WebUI.sleep(2);
        //[CP]_Check content when user Bold function
        WebUI.verifyElementText(inputTextBoxBody, "bold");
        WebUI.sleep(2);
        WebUI.clearText(inputTextBoxBody);
        WebUI.sleep(2);
        WebUI.clickElement(iconItalic);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, "italic");
        WebUI.sleep(2);
        //[CP]_Check content when user Italic function
        WebUI.verifyElementText(inputTextBoxBody, "italic");
        WebUI.sleep(2);
        WebUI.clearText(inputTextBoxBody);
        WebUI.sleep(2);
        WebUI.clickElement(iconUnderline);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, "underline");
        WebUI.sleep(2);
        //[CP]_Check content when user Underline function
        WebUI.verifyElementText(inputTextBoxBody, "underline");
        WebUI.sleep(2);
        WebUI.clearText(inputTextBoxBody);
        WebUI.sleep(2);
        WebUI.clickElement(iconFont);
        WebUI.sleep(2);
        WebUI.clickElement(fontText);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody,"font");
        WebUI.sleep(2);
        //Check content when user font function
        WebUI.verifyElementText(inputTextBoxBody, "font");
        WebUI.sleep(2);
        WebUI.clearText(inputTextBoxBody);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, "align");
        WebUI.sleep(2);
        WebUI.clickElement(iconPointList);
        WebUI.sleep(2);
        WebUI.clickElement(iconNumberList);
        WebUI.sleep(2);
        WebUI.clickElement(iconParagraph);
        WebUI.sleep(2);
        WebUI.clickElement(iconCenterInParagraph);
        WebUI.sleep(2);
        //Check content when user align function
        WebUI.verifyElementText(inputTextBoxBody, "align");
        WebUI.sleep(2);
    }

    public void checkSendMessage(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(buttonCompose);
        WebUI.sleep(2);
        WebUI.clickElement(textBoxTo);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(5);
        WebUI.clickElement(editTo);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.sleep(3);
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(3);
        if(WebUI.verifyElementPresent(btnSend,5))
        {
            WebUI.clickElement(btnSend,5);
            WebUI.sleep(5);
        }
        WebUI.sleep(3);
        //[CP]_Check Send Message Success and move message to Sent Item
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Sent);
        WebUI.sleep(2);
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkCanNotSendMessageWithoutSubject(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCompose);
        WebUI.clickElement(textBoxTo);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(2);
        WebUI.clickElement(editTo);
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(3);
        if(WebUI.verifyElementPresent(btnSend,5))
        {
            WebUI.clickElement(btnSend,5);
            WebUI.sleep(5);
        }
        //[CP]_Check Send Message UnSuccess without Subject
        WebUI.verifyElementText(messageRequiredSubject, "This field is required.");
        WebUI.sleep(3);
    }

    public void checkCanNotSendMessageWithoutTo(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCompose);
        WebUI.setText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(3);
        if(WebUI.verifyElementPresent(btnSend,5))
        {
            WebUI.clickElement(btnSend,5);
            WebUI.sleep(5);
        }
        //[CP]_Check Send Message UnSuccess Without To
        WebUI.verifyElementText(popupWarningMissingTo, "Please input at least one name in the To");
        WebUI.sleep(3);
    }

    public void checkViewandReplyMessage(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(2);
        WebUI.clickElement(iconReply);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBodyInReply, data.get(messageStudentModel.getContent()));
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(3);
        //[CP]_Check View and Reply Message
        if(WebUI.verifyElementPresent(btnSend,5))
        {
            WebUI.clickElement(btnSend,5);
            WebUI.sleep(5);
        }
        WebUI.sleep(2);
        //forwarded message stay in Sent items
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Sent);
        WebUI.sleep(2);
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkViewandForwardMessageInInboxItem(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconForwardInMessageInbox);
        WebUI.sleep(3);
        WebUI.clickElement(textBoxTo);
        WebUI.sleep(2);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(3);
        WebUI.clickElement(editTo);
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBodyInReply, data.get(messageStudentModel.getContent()));
        //[CP]_Check View and Forward Message in Inbox item
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(2);
        WebUI.clickElement(btnSend,5);
        WebUI.sleep(2);
        //forwarded message stay in Sent items
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Sent);
        WebUI.sleep(2);
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkDeleteMessageInInboxItemOutsideMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage);
        //[CP]_Check Delete Message in Inbox Item Outside Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[13]"));
        WebUI.sleep(2);
        //Message deleted move to Trash item
        WebUI.verifyElementText(firstMessageinTable,"delete message");
        WebUI.sleep(2);
    }

    public void checkDeleteMessageInInboxItemOnMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(viewMessage);
        WebUI.clickElement(iconDeleteInMessage, 5);
        WebUI.sleep(2);
        WebUI.clickElement(btnDeleteMessage);
        //[CP]_Check Delete Message in Inbox Item On Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[13]"));
        WebUI.sleep(2);
        //Message deleted move to Trash item
        WebUI.verifyElementText(firstMessageinTable,"delete message");
        WebUI.sleep(2);
    }

    public void checkViewandForwardMessageInSentItem(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(2);
        WebUI.clickElement(iconForwardInMessageSent, 1);
        WebUI.sleep(2);
        WebUI.clickElement(textBoxTo);
        WebUI.sleep(2);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(2);
        WebUI.clickElement(editTo);
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBodyInReply, data.get(messageStudentModel.getContent()));
        WebUI.sleep(2);
        WebUI.scrollToElementToBottom(btnSend);
        WebUI.sleep(2);
        WebUI.clickElement(btnSend);
        WebUI.sleep(3);
        //[CP]_Check View and Forward Message in Sent item
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Sent);
        WebUI.sleep(2);
        //forwarded message stay in Sent items
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkDeleteMessageInSentItemOutsideMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(2);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(2);
        WebUI.clickElement(btnDeleteMessage);
        WebUI.sleep(2);
        //[CP]_Check Delete Message in Sent Item OutSide Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[13]"));
        WebUI.sleep(2);
        //Message deleted move to Trash item
        WebUI.verifyElementText(firstMessageinTable,"delete message");
        WebUI.sleep(2);
    }

    public void checkDeleteMessageInSentItemOnMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconDeleteInMessage);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage);
        WebUI.sleep(3);
        //[CP]_Check Delete Message in Sent Item On Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[13]"));
        WebUI.sleep(2);
        //Message deleted move to Trash item
        WebUI.verifyElementText(firstMessageinTable,"delete message");
        WebUI.sleep(2);
    }

    public void checkEditMessageInDraftsItem(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconDrafts);
        WebUI.sleep(3);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconEdit);
        WebUI.sleep(2);
        WebUI.setCtrlAThenFillText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.sleep(3);
        WebUI.clickElement(iconSave);
        WebUI.sleep(2);
        //[CP]_Check Edit Message in Drafts Item Successfully
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Draft);
        //After Save back to Drafts Item
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkSendMessageinDraft(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        //Pre-Condition
        WebUI.clickElement(buttonCompose);
        WebUI.sleep(2);
        WebUI.clickElement(textBoxTo);
        WebUI.sleep(2);
        WebUI.setText(inputTo, data.get(messageStudentModel.getTo()));
        WebUI.sleep(1);
        WebUI.clickElement(editTo);
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(2);
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.sleep(2);
        WebUI.clickElement(iconSave, 2);
        WebUI.sleep(2);
        WebUI.clickElement(iconDrafts);
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(2);
        WebUI.clickElement(iconSendinDrafts);
        WebUI.sleep(2);
        WebUI.clickElement(btnSendInDraft);
        WebUI.sleep(3);
        //[CP]_Check Send Message in Drafts and Move Message tp Sent Item
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Draft);
        //message sent move to Sent items
        WebUI.verifyElementText(firstMessageinTable, data.get(messageStudentModel.getSubject()));
        WebUI.sleep(3);
    }

    public void checkCanNotSendMessageInDraftItem(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        //Pre-Condition
        WebUI.clickElement(buttonCompose);
        WebUI.setText(inputTextBoxSubject, data.get(messageStudentModel.getSubject()));
        WebUI.setText(inputTextBoxBody, data.get(messageStudentModel.getContent()));
        WebUI.clickElement(iconSave, 2);
        WebUI.sleep(2);
        WebUI.clickElement(iconDrafts);
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconSendinDrafts);
        WebUI.sleep(3);
        WebUI.clickElement(btnSendInDraft);
        WebUI.sleep(3);
        WebUI.clickElement(btnViewMessageinDraft);
        WebUI.sleep(3);
        //[CP]_Check Can not send message in Draft Item and Move to Compose Message page
        WebUI.verifyContains(WebUI.getCurrentUrl(), MessageStudentPageSC.pageUrl_Compose);
        WebUI.sleep(3);
    }

    public void checkDeleteMessageInDraftItemOutsideMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconDrafts, 1);
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        WebUI.clickElement(iconDeleteinDraft, 3);
        WebUI.sleep(5);
        WebUI.clickElement(btnDeleteMessage);
        //[CP]_Check Delete Message in Draft Item OutSide Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(3);
    }

    public void checkDeleteMessageInDraftItemOnMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconDrafts);
        WebUI.sleep(3);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconDeleteInMessage, 1);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage);
        //[CP]_Check Delete Message in Draft Item On Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(3);
    }

    public void checkunDeleteMessageInTrashItem()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        //Pre-Condition
        WebUI.clickElement(iconDelete);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage);
        WebUI.sleep(4);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[13]"));
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconUnDelete, 1);
        WebUI.sleep(3);
        WebUI.clickElement(btnUnDelete);
        WebUI.sleep(2);
        //[CP]_Check unDelete Message in Trash Item
        WebUI.verifyElementText(flashMessage, "Message has been un-deleted successfully");
        WebUI.sleep(3);
        WebUI.clickElement(By.xpath("(//*[name()='svg'])[10]"));
        WebUI.sleep(2);
        //Message un-deleted move to Inbox item
        WebUI.verifyElementText(firstMessageinTable,"delete message");
        WebUI.sleep(2);
    }

    public void checkDeleteMessageInTrashItemOutsideMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconTrash);
        WebUI.sleep(2);
        WebUI.clickElement(iconDelete);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage, 1);
        WebUI.sleep(2);
        //[CP]_Check Delete Message in Trash Item Outside Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(3);
    }

    public void checkDeleteMessageInTrashItemOnMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconTrash);
        WebUI.sleep(2);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconDeleteInMessage, 1);
        WebUI.sleep(3);
        WebUI.clickElement(btnDeleteMessage);
        WebUI.sleep(2);
        //[CP]_Check Delete Message in Trash Item On Message
        WebUI.verifyElementText(flashMessage, "Message has been deleted successfully");
        WebUI.sleep(3);
    }

    public void checkNextandPreviousMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(3);
        WebUI.clickElement(viewMessage);
        WebUI.sleep(3);
        WebUI.clickElement(iconNextMessage);
        WebUI.sleep(3);
        //[CP]_Check Next Message
        WebUI.verifyElementText(contentMessage, "ACB");
        WebUI.sleep(3);
        WebUI.clickElement(iconPreviousMessage);
        WebUI.sleep(3);
        //[CP]_Check Previous Message
        WebUI.verifyElementText(contentMessage, "123");
        WebUI.sleep(3);
    }

    public void checkSortMessage()
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(filterFromTo);
        WebUI.sleep(3);
        //[CP]_Check Sort Message by From/To A-Z
        WebUI.verifyElementText(sortMessagebyUser, "1, Teacher");
        WebUI.sleep(3);
        WebUI.clickElement(filterFromTo);
        WebUI.sleep(3);
        //[CP]_Check Sort Message by From/To Z-A
        WebUI.verifyElementText(sortMessagebyUser, "Tch, Pen");
        WebUI.sleep(3);
        WebUI.clickElement(filterDate);
        WebUI.sleep(3);
        //[CP]_Check Sort Message by Recent days
        WebUI.verifyElementText(sortMessagebyDate, "05/12/2023");
        WebUI.sleep(3);
        WebUI.clickElement(filterDate);
        WebUI.sleep(3);
        //[CP]_Check Sort Message Furthest day
        WebUI.verifyElementText(sortMessagebyDate, "06/25/2023");
        WebUI.sleep(3);
    }

    public void checkSearchMessageWithValidKeyword(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(inputSearchMessage);
        WebUI.setText(inputSearchMessage, data.get(messageStudentModel.getSearch()));
        WebUI.clickElement(iconSearch);
        WebUI.sleep(3);
        //[CP]_Check Search Message with Valid keyword
        WebUI.verifyElementText(tableMessage, data.get(messageStudentModel.getSearch()));
        WebUI.sleep(3);
    }

    public void checkSearchMessageWithinValidKeyword(Hashtable<String, String> data)
    {
        WebUI.sleep(5);
        WebUI.clickElement(iconLetter);
        WebUI.sleep(3);
        WebUI.clickElement(iconSent);
        WebUI.sleep(2);
        WebUI.clickElement(inputSearchMessage);
        WebUI.setText(inputSearchMessage, data.get(messageStudentModel.getSearch()));
        WebUI.clickElement(iconSearch);
        WebUI.sleep(3);
        //[CP]_Check Search Message with inValid keyword
        WebUI.verifyElementText(notfoundMessage, "You have not sent any messages.");
        //"Show message
        //Inbox: Your inbox is currently empty.
        //Sent: You have not sent any messages.
        //Drafts: You have no draft messages.
        //Trash: You have no deleted messages."
        WebUI.sleep(3);
    }
}
