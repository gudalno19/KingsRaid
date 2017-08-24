package runner.auto;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import actions.GameActions;
import actions.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class Runner {
	public static AppiumDriver<MobileElement> driver;
	public static final int X_MIDDLE = 750;
	public static final int Y_MIDDLE = 450;
	public static final int CLICK_WAIT = 1000;

	static void initDriver() {
		//
		// File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "/Apps/Amazon/");
		// File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "device");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("udid", "127.0.0.1:62001");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("appPackage", "com.vespainteractive.KingsRaid");
		capabilities.setCapability("appActivity", "com.onevcat.uniwebview.AndroidPlugin");
		capabilities.setCapability("newCommandTimeout", 60 * 5);

		driver = new AndroidDriver<MobileElement>(capabilities);
	}

	static void cleanDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		initDriver();
		GameActions action = new GameActions(driver);
		action.logIn();
		action.autoFarming();

		cleanDriver();
	}

}
