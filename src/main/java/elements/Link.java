package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class Link extends Element {
    private static final Logger logger = LogManager.getLogger(Link.class);

    public Link(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public void clickOnLink(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        webElement.click();
    }

    public String linkText(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        return webElement.getText();
    }

    public boolean isEnabled(By by, WebDriver driver) {
        WebElement webElement = driver.findElement(by);
        if (webElement.isEnabled()) {
            logger.info("Link is present");
            return true;
        } else {
            logger.info("Link doesn't present");
            return false;
        }
    }
}
