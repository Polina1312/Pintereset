package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN = By.xpath(".//button[contains(text(),'Вход')]");

    public void verifyMainPageOpened(WebDriver driver) {
       Assert.assertTrue(Button.isEnabled(LOGIN, driver));
    }

}
