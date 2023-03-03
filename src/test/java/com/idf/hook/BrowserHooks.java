package com.idf.hook;

import framework.utilities.RandomUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import structure.configuration.Configuration;

import static framework.browser.Browser.*;
import static framework.logger.Logger.infoAction;
import static java.lang.String.format;

public class BrowserHooks {

    @BeforeTest
    public void configBrowser() {
        RandomUtility.getRandomCorrectPassword();
        Configuration.readConfigFile();
        getBrowser().setTimeoutPageLoad(Configuration.getTimeoutPageLoad());
        getBrowser().setImplicitWait(Configuration.getImplicitWait());
    }

    @BeforeMethod
    public void openSite() {
        getBrowser().maximize();
        getBrowser().goTo(Configuration.getStartUrl());
    }

    @AfterMethod
    public void logEndTestAndCloseBrowser() {
        infoAction(format("Current url [%s]", getBrowser().getCurrentUrl()));
        getBrowser().deleteBrowser();
    }
}
