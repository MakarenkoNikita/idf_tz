package com.idf.stepdefinitions.homepage;

import org.testng.Assert;
import structure.page.HomePage;

import java.util.List;

import static java.lang.String.format;

public class HomePageSteps {

    private static final HomePage page = new HomePage();

    public static void clickLogin() {
        page.clickLogin();
    }

    public static void isUserLogged(String userName) {
        Assert.assertEquals(page.getUserNameText(), userName, format("User with [%s] username must be logged", userName));
    }

    public static List<String> gettingBookTitle() {
        return page.getBookTitles();
    }
}
