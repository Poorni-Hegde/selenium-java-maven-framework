package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestData;

public class DataProviderLoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
            dataProviderClass = TestData.class)

    public void loginTest(String username,
                          String password) {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                username,
                password
        );

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("inventory")
                        ||

                        driver.getPageSource()
                                .contains("Epic sadface")
        );
    }
}