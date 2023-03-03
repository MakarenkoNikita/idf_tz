package framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.logger.Logger.*;
import static java.lang.String.*;

public class Browser {

    private static WebDriver driver = null;

    private Browser() {
    }

    public static Browser getBrowser() {
        if (driver == null) {
            infoAction("WebDriver instance not found, create a new");
            driver = newInstance();
        }
        return new Browser();
    }

    private static WebDriver newInstance() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public void deleteBrowser() {
        if (driver != null) {
            infoAction("Deleting the webDriver instance");
            driver.quit();
            driver = null;
        }
    }

    public void goTo(String url) {
        infoAction(format("Navigate to [%s]", url));
        System.out.println(url);
        driver.navigate().to(url);
    }

    public void maximize() {
        infoAction("Maximize browser");
        driver.manage().window().maximize();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void setTimeoutPageLoad(int second) {
        driver.manage().timeouts().pageLoadTimeout(second, TimeUnit.SECONDS);
    }

    public void setImplicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }
}
