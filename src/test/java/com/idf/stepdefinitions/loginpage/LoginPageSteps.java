package com.idf.stepdefinitions.loginpage;

import org.testng.Assert;
import structure.page.LoginPage;

public class LoginPageSteps {

    private static final LoginPage page = new LoginPage();

    public static void isLoginPageDisplayed() {
        Assert.assertTrue(page.isDisplayed(), "Login page ,ust be displayed");
    }

    public static void loginAsSavedUser(String login, String password) {
        page.fillUserName(login)
                .fillPassword(password);
        page.clickLogin();
    }
}
