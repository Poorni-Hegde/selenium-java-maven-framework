package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import base.BaseTest;
import utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import reports.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());

        System.out.println(
                "STARTED : " + result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        System.out.println(
                "PASSED : " + result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "FAILED : " + result.getName()
        );

        test.fail(result.getThrowable());

        String path = ScreenshotUtils.captureScreenshot(
                BaseTest.driver,
                result.getName()
        );

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}