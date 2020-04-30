package Assignment.Lab;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

public class Helper extends SeleniumBase{

	private static Helper _instance = new Helper();
	private static boolean instanceLogged = false;
	
	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By LoginButton = By.cssSelector(".btn_action");
	public static By errorMessageLocator = By.cssSelector("h3[data-test='error']");
	public static By productLabelLocator = By.cssSelector(".product_label");
	
	public static Helper instance() {	
		
		if (!instanceLogged) {
			instanceLogged = true;
			LogHelper.instance().setInfo("Helper::instance(): Singleton created.");

		}
		return _instance;
	}	

	public void enterLoginDetails(String userNameValue, String passwordValue) throws Exception{
		type(userName, userNameValue);
		type(password, passwordValue);
	}
	public void login(String userName, String password) throws Exception{
		enterLoginDetails(userName, password);
		clickLoginLink();
	}
	
	public void clickLoginLink(){
		click(LoginButton);
	}
	
	public void verifyLoginIsSuccessful() {
		assertTrue(isElementPresent(productLabelLocator));
	}
	
	public void verifyErrorMessage(String message) throws Exception {
		assertTrue(isElementPresent(errorMessageLocator));
		assertEquals(getText(errorMessageLocator), message);
	}
}
