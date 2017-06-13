package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class Text extends Element {
    private static final Logger logger = LogManager.getLogger(Text.class);

    public Text(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public static boolean isEnabled(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        logger.info("Enabled status: " + webElement.isDisplayed());
        return webElement.isDisplayed();
    }

    public static String text(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        logger.info("Text: " + webElement.getText());
        return webElement.getText();
    }
}
