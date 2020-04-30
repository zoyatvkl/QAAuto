package Assignment.Lab;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Reporter;

public class SeleniumClient {

	private static SeleniumClient _instance = new SeleniumClient();
	private static boolean instanceLogged = false;
	private InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>();
	
	private SeleniumClient() {			

		// do nothing
	}

	public static SeleniumClient instance() {		

		if (!instanceLogged) {
			instanceLogged = true;
			System.out.println("SeleniumClient::instance(): Singleton created.");

		}
		return _instance;
	}			

	public WebDriver getBrowser() {	
		return driver.get();
	}

	public void setBrowser(String browser, String driverPath) throws MalformedURLException  {	
		if(browser.equals("chrome")){
			setBrowserChrome(driverPath);
		}
		else if(browser.equals("safari")){
			setBrowserSafari();
		}else if(browser.equals("firefox")){
			setBrowserFireFox(driverPath);
		}
		else{
			setBrowserChrome(driverPath);
		}
	}

	private void setBrowserFireFox(String path)  {
		System.setProperty("webdriver.gecko.driver",path);
		driver.set(new FirefoxDriver());  	
		driver.get().manage().window().maximize();
	}

	private void setBrowserSafari() throws MalformedURLException {   
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(DesiredCapabilities.safari().getBrowserName());  
		SafariOptions options = new SafariOptions(dc);
		driver.set(new SafariDriver(options));

	}

	private void setBrowserChrome(String driverPath) throws MalformedURLException {    	
		System.setProperty("webdriver.chrome.driver",driverPath); 
		ChromeOptions options = new ChromeOptions();
		driver.set(new ChromeDriver(options));

	}

	public void closeBrowser()  {
		getBrowser().quit();
	}

	public void deleteBrowserCookies() {
		WebDriver.Options wo = getBrowser().manage();
		wo.deleteAllCookies();
	}

	public void goToUrl(String uri) throws Exception {
		getBrowser().get(uri);	
	}

	public void getScreenShot() {    	 	    	

		try {    	
			String	base64_str = ((TakesScreenshot)getBrowser()).getScreenshotAs(OutputType.BASE64);
			String	data_uri = "data:image/png;base64," + base64_str;
			Reporter.log(String.format("SCREENSHOT: <a href='%s'><img border='0', src='%s' width='80' height ='60'/></a>", data_uri, data_uri), false);
		} catch (Exception e) {			
			// do nothing if fails
		}		    
	}
}
