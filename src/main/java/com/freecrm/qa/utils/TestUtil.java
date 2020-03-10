package com.freecrm.qa.utils;

import com.freecrm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import com.sun.media.sound.InvalidFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
   // public static String TESTDATA_SHEET_PATH =
        //switchToFrame() function is used to change the frame of the
    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    /*public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try{
        //file = new FileInputStream(TESTDATA_SHEET_PATH);
    }catch (FileNotFoundException e){
        e.printStackTrace();
        }*/
       /* try{
            book = WorkbookFactory.create(file);
        }catch(InvalidFormatException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        return data;
    }*/
}
