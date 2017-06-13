package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class Button extends Element {
    private static final Logger logger = LogManager.getLogger(Button.class);

    public Button(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public static void clickButton(By by, WebDriver driver){
        WebElement webElement = driver.findElement(by);
        logger.info("Button was clicked " + webElement.getText());
        webElement.click();
    }

    public static boolean isEnabled(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        logger.info("Button displaying: " + webElement.isDisplayed());
        return webElement.isDisplayed();
    }

}
