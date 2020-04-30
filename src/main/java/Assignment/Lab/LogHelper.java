package Assignment.Lab;

import static org.testng.Assert.fail;

import org.testng.Reporter;

public class LogHelper {

	private static LogHelper _instance = new LogHelper();
	private static boolean instanceLogged = false;

	public static LogHelper instance() {

		if (!instanceLogged) {
			instanceLogged = true;
			_instance.setInfo("LogHelper::instance(): Singleton created.");
		}
		return _instance;
	}

	public void set(String message) {				
		Reporter.log(message, true);		
	}

	public void setInfo(String message) {				
		Reporter.log("INFO: " + message, true);		
	}	

	public void setWarning(String message) {		
		Reporter.log("WARNING: " + message, true);		
	}	

	public void setSuccess(String message) {
		Reporter.log("SUCCEEDED: " + message, true);
	}


	public void setError(String message) {		
		// Take screen shot. Helpful if timeouts occur.
		if (SeleniumClient.instance().getBrowser() != null) {
			SeleniumClient.instance().getScreenShot();
		}

		Reporter.log("ERROR: " + message, true);	
	}

	public void setFailure(String message) {	
		// Take screen shot. Helpful if timeouts occur.
		if (SeleniumClient.instance().getBrowser() != null) {
			SeleniumClient.instance().getScreenShot();
		}
		Reporter.log("FAILED: " + message, true);
		fail(message);	
	}


}
