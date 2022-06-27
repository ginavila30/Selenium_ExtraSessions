package com.cydeo.tests.office_hours.day06;

import com.cydeo.tests.office_hours.utility.ConfigPropertiesReader;
import com.cydeo.tests.office_hours.utility.Driver;
import com.cydeo.tests.pages.Herokuapp_UploadFile_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/* Task 1


       - Go to  "https://testpages.herokuapp.com/styled/file-upload-test.html"
       - Upload file into Choose File
             NOTE : Create a file called as UploadTest.txt in project to upload ( I will show how we can )
       - Choose General File
       - Click Upload button
       - Verify Expected message equals "You uploaded a file. This is the result."


*/
public class Task01FileUpload {

    Herokuapp_UploadFile_Page obj = new Herokuapp_UploadFile_Page();

@Test
    public void uploadFileTask() throws AWTException {
    Driver.getDriver().get(ConfigPropertiesReader.getProperty("herokuapp.uploadfile.url"));
    // creating object of Robot class
    Robot rb = new Robot();

    // copying File path to Clipboard
    StringSelection str = new StringSelection("C:\\Users\\majid\\IdeaProjects\\Selenium_ExtraSessions\\Selenium_ExtraSessions\\src\\test\\java\\com\\cydeo\\tests\\office_hours\\day06\\upload.txt");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

    // press Contol+V for pasting
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);

    // release Contol+V for pasting
    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);

    // for pressing and releasing Enter
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);

    obj.generalFileRadioBtn.click();
    obj.uploadBtn.click();
    Assert.assertEquals(obj.confirmMessage.getText(),"You uploaded a file. This is the result.");

    Driver.closeDriver();

}


}

