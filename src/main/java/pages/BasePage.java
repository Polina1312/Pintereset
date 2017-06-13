package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by home on 27.05.2017.
 */

public class BasePage {

    protected WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
