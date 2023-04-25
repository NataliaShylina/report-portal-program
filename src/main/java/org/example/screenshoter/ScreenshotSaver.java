package org.example.screenshoter;

import org.apache.commons.io.FileUtils;
import org.example.logger.Logger;
import org.example.pages.ReportPortalMainPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.logging.LogManager;

import static org.apache.commons.logging.impl.SimpleLog.LOG_LEVEL_ERROR;

public class ScreenshotSaver {
    public static class Test{}
    private static Logger LOGGER= LogManager.getLogger();
    private static final String TEST_FAIL_MESSAGE = "Test failed";
    private static final String PATH = Paths.get(System.getProperty("user.dir"), "target", "screenshot")
            .toString() + File.separator + DateAndTime.getCurrentTimeAsString() + ".png";
    public static File saveScreenshot(){
        File screenCapture = ((TakesScreenshot) Browser.getDriver)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(PATH));
        }catch (IOException e){
            LOGGER.error("Failed to save screenshot: ", e);
        }
        return screenCapture;
    }
    public static void sendScreenshotToReportPortal(){
        try {
            ReportPortalMessage message = new ReportPortalMessage(saveScreenshot(), TEST_FAIL_MESSAGE);
            ReportPortal.emitLog(message, LOG_LEVEL_ERROR, Calendar.getInstance().getTime());
        }catch (IOException e){
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
}
