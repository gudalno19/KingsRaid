package actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Utils {

	public static void click(AppiumDriver<MobileElement> driver, int x, int y, int timeOut) {
		driver.tap(1, x, y, 150);
		waitTo(timeOut);
	}

	public static void waitTo(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void screenshot(AppiumDriver<MobileElement> driver, String savePath) {
		File file = new File(savePath);
		System.out.println(file.exists());
		try {
			File a = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(a, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
