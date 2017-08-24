package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import runner.auto.*;

public class GameActions extends Driver {
	final static Logger logger = Logger.getLogger(GameActions.class);
	public static final int X_MIDDLE = 750;
	public static final int Y_MIDDLE = 450;

	public GameActions(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void farming() {
		logger.debug("Going to DIA LAO");
		// click prepare battle
		click(1335, 817, 3000);

		// click get ready to battle
		click(1077, 787, 3000);

		// click start battle
		click(1217, 787, 10000);

		// wait 3min for fighting
		waitTo(120000);

		// click win first time
		click(737, 491, 10000);

		// click win second time
		click(737, 491, 5000);

		// click exit
		click(1347, 805, 15000);
	}

	public void sellItems() {
		// open inventory
		click(190, 830, 3000);

		// click Sell
		click(1220, 750, 2000);

		// click sell all
		click(825, 750, 2000);

		// click sell
		click(719, 730, 2000);

		// click confirm sell
		click(873, 640, 2000);

		// click close window
		click(1210, 160, 2000);

		// click out inventory
		click(150, 30, 2000);
	}

	public void logIn() {
		logger.debug("Going to logging in");
		waitTo(60000);
		click(710, 701, 2000);// click xac nhan

		waitTo(15000);
		click(1367, 109);// click xac nhan
	}

	public void autoFarming() {
		for (int i = 0; i < 12; i++) {
			farming();
			sellItems();
		}
	}
}
