package Assignment.Lab;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;



public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        if(!result.isSuccess()){
        	try {
        		String	base64_str = ((TakesScreenshot)SeleniumClient.instance().getBrowser()).getScreenshotAs(OutputType.BASE64);
    			String	data_uri = "data:image/png;base64," + base64_str;
    			Reporter.log(String.format("SCREENSHOT: <a href='%s'><img border='0', src='%s' width='80' height ='60'/></a>", data_uri, data_uri), false);
               
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


