package framework.form;

import org.openqa.selenium.By;

import static framework.browser.Browser.*;

public abstract class BaseForm {

    private final By locator;
    private final String name;

    protected BaseForm(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        return getBrowser().findElement(locator).isDisplayed();
    }
}
