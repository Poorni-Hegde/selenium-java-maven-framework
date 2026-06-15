package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        ConfigReader config = new ConfigReader();

        loginPage.login(
                config.getUsername(),
                config.getPassword()
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "wrong_password"
        );

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Username and password do not match")
        );
//        Assert.assertTrue(
//                driver.getPageSource()
//                        .contains("Hello")
//        );

    }
}