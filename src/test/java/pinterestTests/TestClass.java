package pinterestTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Polina_Panarina on 5/30/2017.
 */
public class TestClass {
    private LoginPage loginPage;
    private PersonalPage personalPage;
    private WebDriver driver;
    private final static String EMAIL = "testmailaccount@i.ua";
    private final static String PASSWORD = "123456qwerty";

    @BeforeClass
    public void driverInitialisation() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        driver.get("https://ru.pinterest.com/login/?referrer=home_page");
    }

    @Test
    public void loginToPinterest() {
        personalPage = loginPage.submitForm(driver, EMAIL, PASSWORD);
        personalPage.verifyPersonalPageOpened(driver);
    }

    @Test
    public void userExit() {
        personalPage = loginPage.submitForm(driver, EMAIL, PASSWORD);
        MainPage mainPage = personalPage.out(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("https://ru.pinterest.com/?logged_out=true"));
        Assert.assertEquals("https://ru.pinterest.com/?logged_out=true", driver.getCurrentUrl());
    }

    @Test
    public void dashBoardAdding() {
        Random r = new Random();
        String DASHBOARD = "RIO" + r.nextInt();
        personalPage = loginPage.submitForm(driver, EMAIL, PASSWORD);
        personalPage.addDashBoard(driver, DASHBOARD);
        personalPage.verifyNewBoardName(driver, DASHBOARD);
    }

    @AfterClass
    public void driverClose() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
