package framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.browser.Browser.*;
import static framework.logger.Logger.*;

import static java.lang.String.*;

public abstract class BaseElement {

    private final By locator;
    private final String name;

    BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement getElement() {
        return getBrowser().findElement(locator);
    }

    public String getName() {
        return name;
    }

    public void click() {
        infoElementAction(name, "click to");
        getElement().click();
    }

    public String getText() {
        infoAction(format("getting [%s] element text", name));
        return getElement().getText();
    }
}
