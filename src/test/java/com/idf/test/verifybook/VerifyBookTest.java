package com.idf.test.verifybook;

import com.idf.hook.BrowserHooks;
import com.idf.stepdefinitions.homepage.HomePageSteps;
import framework.utilities.JsonUtility;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import structure.api.bookstore.BookStoreApi;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static structure.constant.StringConstant.*;

public class VerifyBookTest extends BrowserHooks {

    @Test
    public void verifyBooksTest() {
        List<String> pageTitles = HomePageSteps.gettingBookTitle();
        List<String> apiTitles = new ArrayList<>(JsonUtility.getElementList(new JSONObject(BookStoreApi.getBookList().getBody().asString()).getJSONArray(BOOKS), TITLE));
        Assert.assertEquals(pageTitles, apiTitles, format("Page book titles [%s]) and api book titles [%s] must be equals", pageTitles, apiTitles));
    }
}
