package org.example.listener;

import org.example.logger.Logger;

import java.util.logging.LogManager;

public class TestListener implements ITestListener{
    private final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onTestStart(ITestResult iTestResult){
        LOGGER.info("Start testing");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult){
        LOGGER.info("Success testing");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult){
        LOGGER.error("Step failed. See screenshot.");
        saveScreenshot();
        sendScreenShotToReportPortal();
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult){
        LOGGER.info("Test skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){
    }
    @Override
    public void onStart(ITestContext iTestContext){
    }
    @Override
    public void onFinish(ITestContext iTestContext){
        LOGGER.info("Test finished");
    }
}
