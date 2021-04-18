package lib;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class Screenshots {
	public WebDriver driver; 

	// the driver information will be given by selenium test case 
	public Screenshots(WebDriver driver){
		this.driver = driver; 
	}
	public void ScreenShot_US(){

		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\test-output\\Test_Snaps\\US\\");
	}

	public void ScreenShot_UK(){

		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\test-output\\Test_Snaps\\UK\\");
	}

	public void ScreenShot_IN(){

		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\test-output\\Test_Snaps\\IN\\");
	}

}