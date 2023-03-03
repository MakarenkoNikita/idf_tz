package framework.element;

import org.openqa.selenium.By;

import static java.lang.String.*;

import static framework.logger.Logger.infoElementAction;

public class TextBox extends BaseElement {

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void clearAndType(String value) {
        infoElementAction(getName(), format("clear and type [%s]", value));
        getElement().clear();
        getElement().sendKeys(value);
    }
}
