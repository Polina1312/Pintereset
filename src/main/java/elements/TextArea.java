package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class TextArea extends Element {
    private static final Logger logger = LogManager.getLogger(TextArea.class);

    public TextArea(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public static void enterText(By by, WebDriver driver, String submitInformation) {
        WebElement webElement = driver.findElement(by);
        logger.info("Entering text: " + submitInformation);
        webElement.sendKeys(submitInformation);
    }

    public static void clearInputField(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        logger.info("Text area: " + webElement.getText() + " was cleared");
        webElement.clear();
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

    public static boolean isEmpty(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        boolean result = false;
        if (webElement.getText() == null) {
            result = true;
        }
        logger.info("Empty status: " + result);
        return result;
    }
}
