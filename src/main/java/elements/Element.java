package elements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.List;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public abstract class Element {

    private static final Logger logger = LogManager.getLogger(Element.class);

    public Element (WebDriver driver, WebElement webElement) {
        WebDriver driver1 = driver;
        WebElement webElement1 = webElement;
        System.out.println("web");
    }
}
