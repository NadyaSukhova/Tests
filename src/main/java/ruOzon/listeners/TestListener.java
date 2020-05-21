package ruOzon.listeners;

import ruOzon.util.ScreenshotMaker;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        ScreenshotMaker.takeScreenshot();
    }
}