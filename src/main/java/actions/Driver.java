package actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver {
	final static Logger logger = Logger.getLogger(Driver.class);
	public AppiumDriver<MobileElement> driver;
	public static final int DEFAULT_TIMEOUT = 1500;
	public static final int TAP_DURATION = 200;
	public static final int CLICK_WAIT = 1000;

	public Driver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void click(int x, int y, int timeOut) {
		logger.debug("Clicking x: " + x + ",y: " + y);
		driver.tap(1, x, y, TAP_DURATION);
		waitTo(timeOut);
	}

	public void click(Point input) {
		logger.debug("Clicking Point: " + input.getX() + ",y: " + input.getX());
		driver.tap(1, input.getX(), input.getY(), TAP_DURATION);
		waitTo(DEFAULT_TIMEOUT);
	}

	public void click(Point input, int timeWait) {
		logger.debug("Clicking Point: " + input.getX() + ",y: " + input.getX());
		driver.tap(1, input.x, input.y, TAP_DURATION);
		waitTo(timeWait);
	}

	public void click(int x, int y) {
		logger.debug("Clicking x: " + x + ",y: " + y);
		driver.tap(1, x, y, TAP_DURATION);
		waitTo(DEFAULT_TIMEOUT);
	}


	public void swipeDirection(String direction) {
		logger.debug("Swiping to: " + direction.toUpperCase());
		if (direction.toLowerCase().equals("down")) {
			driver.swipe(Locations.CENTER.getX(), Locations.CENTER.getY() - 150, Locations.CENTER.getX(),
					Locations.CENTER.getY() + 150, 200);
		} else {
			driver.swipe(Locations.CENTER.getX(), Locations.CENTER.getY() + 150, Locations.CENTER.getX(),
					Locations.CENTER.getY() - 150, 200);
		}
		waitTo(1000);
	}


	public void screenshot(String savePath) {
		logger.debug("Taking screenshot");
		File file = new File(savePath);
		System.out.println(file.exists());
		try {
			File a = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(a, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitTo(long timeout) {
		logger.debug("waiting...");
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doubleClick(Point input) {
		driver.tap(1, input.getX(), input.getY(), 100);
		driver.tap(1, input.getX(), input.getY(), 100);
		waitTo(DEFAULT_TIMEOUT);
	}
}
