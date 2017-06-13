package pages;

import elements.Button;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL = By.name("id");
    private static final By PASSWORD = By.name("password");
    private static final By SUBMIT = By.xpath(".//div[contains(text(),'Вход')]");

    private void enterEmail(WebDriver driver, String emailToInput) {
        TextArea.enterText(EMAIL, driver, emailToInput);
    }

    private void enterPassword(WebDriver driver, String passwordToInput) {
        TextArea.enterText(PASSWORD, driver, passwordToInput);
    }

    public PersonalPage submitForm(WebDriver driver, String email, String password) {
        enterEmail(driver, email);
        enterPassword(driver, password);
        Button.clickButton(SUBMIT, driver);
        return new PersonalPage(driver);
    }

}
