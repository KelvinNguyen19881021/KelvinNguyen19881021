package selenium.com.projects.sadlierconnect.testcases;


import org.testng.annotations.Test;
import selenium.com.annotations.FrameworkAnnotation;
import selenium.com.common.BaseTest;
import selenium.com.dataprovider.sadlierconnect.DataProviderSCMyLibrary;
import selenium.com.keywords.WebUI;
import selenium.com.projects.sadlierconnect.pages.Login.LoginPageSC;
import selenium.com.projects.sadlierconnect.pages.MyLibrary.MyLibraryPageSC;

import java.util.Hashtable;


public class MyLibraryTest extends BaseTest{

    LoginPageSC loginPageSC;
    MyLibraryPageSC myLibraryPageSC;

    public MyLibraryTest() {
        loginPageSC = new LoginPageSC();
        myLibraryPageSC = new MyLibraryPageSC();

    }

    //Using library DataProvider with read Hashtable
    @Test(priority = 1, description = "chooseProgramNameToView", dataProvider = "getResourcesDataHashTable", dataProviderClass = DataProviderSCMyLibrary.class)
    public void checkProgramNameToView(Hashtable<String, String> data) throws IllegalAccessException {
        loginPageSC.logInWithTeacherRole();
        myLibraryPageSC.openLibraryPage();
        myLibraryPageSC.chooseProgramNameToView(data);

    }



}
