package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{

                {"standard_user", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"locked_out_user", "secret_sauce"}

        };
    }
}