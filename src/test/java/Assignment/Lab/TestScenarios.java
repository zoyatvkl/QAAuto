package Assignment.Lab;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestScenarios {

	@BeforeMethod(alwaysRun = true)
	public void beforeTest() throws Exception {
		SeleniumClient.instance().setBrowser("chrome", "");
		SeleniumClient.instance().deleteBrowserCookies();
		SeleniumClient.instance().getBrowser().get("https://www.saucedemo.com/index.html");
	}

	@Test
	public void testScenario1() throws Exception {
		Helper.instance().login("standard_user", "secret_sauce");
		Helper.instance().verifyLoginIsSuccessful();

	}

	@Test
	public void testScenario2() throws Exception {
		Helper.instance().login("locked_out_user", "secret_sauce");
		Helper.instance().verifyErrorMessage("Epic sadface: Sorry, this user has been locked out");
	} 

	@Test
	public void testScenario3() throws Exception {
		Helper.instance().login("standard_user", "invalidPassword");
		Helper.instance().verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
	} 

	@Test
	public void testScenario4() throws Exception {
		Helper.instance().enterLoginDetails("standard_user_invalid", "");
		Helper.instance().clickLoginLink();
		Helper.instance().verifyErrorMessage("Epic sadface: Password is required");

	} 

	@Test
	public void testScenario5() throws Exception {
		Helper.instance().login("", "");
		Helper.instance().verifyErrorMessage("Epic sadface: Username is required");
		Helper.instance().login("", "secret_sauce");
		Helper.instance().verifyErrorMessage("Epic sadface: Username is required");
	} 

	@AfterMethod(alwaysRun = true)
	protected void afterTest(ITestResult result) throws Exception {
		SeleniumClient.instance().closeBrowser();
	}
}
