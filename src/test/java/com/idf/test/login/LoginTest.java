package com.idf.test.login;

import com.idf.hook.BrowserHooks;
import com.idf.stepdefinitions.homepage.HomePageSteps;
import com.idf.stepdefinitions.loginpage.LoginPageSteps;
import framework.utilities.RandomUtility;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import structure.api.account.AccountApi;
import structure.configuration.Configuration;

import java.util.HashMap;

import static structure.constant.StringConstant.*;

public class LoginTest extends BrowserHooks {

    private final HashMap<String, Object> map = new HashMap<>();

    @BeforeMethod
    public void createUserAndSave() {
        RestAssured.baseURI = Configuration.getApiUrl();
        map.put(USER_NAME, RandomUtility.getRandomAlphabeticString());
        map.put(PASSWORD, RandomUtility.getRandomCorrectPassword());
        AccountApi.createAccount((String) map.get(USER_NAME), (String) map.get(PASSWORD));
    }

    @Test
    public void loginTest() {
        HomePageSteps.clickLogin();
        LoginPageSteps.isLoginPageDisplayed();

        LoginPageSteps.loginAsSavedUser((String) map.get(USER_NAME), (String) map.get(PASSWORD));
        HomePageSteps.isUserLogged((String) map.get(USER_NAME));
    }
}
