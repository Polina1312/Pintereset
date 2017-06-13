package pages;

import elements.Button;
import elements.Text;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class PersonalPage extends BasePage {

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    private static final By HOME_BUTTON = By.xpath(".//*[@*='Дом']");
    private static final By SAVED = By.xpath(".//*[contains(@class,'userProfile Button')]");
    private static final By OPTIONS = By.xpath(".//*[@aria-label='Пользовательское меню']");
    private static final By EXIT = By.xpath(".//div[contains(text(),'Выход')]");
    private static final By BOARD_NAME = By.id("boardEditName");
    private static final By NEW_BOARD = By.xpath(".//div[contains(text(),'Создать доску')]");
    private static final By NEW_BOARD_NAME = By.xpath(".//*[@class='mb3']");
    private static final By SUBMIT_BUTTON = By.xpath(".//button[contains(text(),'Готово')]");

    public MainPage out(WebDriver driver) {
        Button.clickButton(SAVED, driver);
        Button.clickButton(OPTIONS, driver);
        Button.clickButton(EXIT, driver);
        return new MainPage(driver);
    }

    public void addDashBoard(WebDriver driver, String name) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SAVED));
        Button.clickButton(SAVED, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Button.clickButton(NEW_BOARD, driver);
        TextArea.enterText(BOARD_NAME, driver, name);
        Button.clickButton(SUBMIT_BUTTON, driver);
    }

    public void verifyNewBoardName(WebDriver driver, String expectedName) {
        Assert.assertEquals(expectedName, Text.text(NEW_BOARD_NAME, driver));
    }

    public void verifyPersonalPageOpened(WebDriver driver) {
        Assert.assertTrue(Button.isEnabled(HOME_BUTTON, driver));
    }

}
