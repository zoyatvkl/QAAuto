package Assignment.Lab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumBase {


	protected void click(By locator) {

		try {

			WebElement element = SeleniumClient.instance().getBrowser().findElement(locator);
			element.click();
			LogHelper.instance().setInfo(this.getClass().getName() + ": Click on \"" + locator.toString() + "\"");

		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}

	}

	public boolean isElementPresent(By locatorKey) {
		try {
			SeleniumClient.instance().getBrowser().findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	protected WebElement findElement(By locator){

		WebElement element = null;
		try {
			element =  SeleniumClient.instance().getBrowser().findElement(locator);
		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}
		return element;
	}

	protected List<WebElement> findElements(By locator){

		List<WebElement> element = null;
		try {
			element =  SeleniumClient.instance().getBrowser().findElements(locator);
		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}
		return element;
	}

	public String getText(By locator) throws Exception {
		String text = null;
		try {
			text = SeleniumClient.instance().getBrowser().findElement(locator).getText();
			if (text == null) {
				LogHelper.instance().setInfo(this.getClass().getName() + ": Text not found for " + locator.toString());
			} else {
				LogHelper.instance().setInfo(this.getClass().getName() + ": <" + text + "> found for " + locator.toString());
			}
		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}
		return text;
	}


	public String getText(WebElement elm) throws Exception {
		String text = null;
		try {
			text =elm.getText();
			if (text == null) {
				LogHelper.instance().setInfo(this.getClass().getName() + ": Text not found for " + elm.toString());
			} else {
				LogHelper.instance().setInfo(this.getClass().getName() + ": <" + text + "> found for " + elm.toString());
			}
		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}
		return text;
	}

	protected WebElement type(By locator, String newText) {

		WebElement element = null;
		try {

			element = SeleniumClient.instance().getBrowser().findElement(locator);
			element.click();
			element.sendKeys(newText);
			LogHelper.instance().setInfo(this.getClass().getName() + ": Type in \"" + locator.toString() + "\" as"+ newText);
		} catch (Exception e) {
			LogHelper.instance().setFailure(this.getClass().getName() + ": " + e.getMessage());
		}


		return element;
	}
}
