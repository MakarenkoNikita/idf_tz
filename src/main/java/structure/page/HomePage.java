package structure.page;

import framework.element.Button;
import framework.element.Label;
import framework.form.BaseForm;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static framework.browser.Browser.*;
import static framework.logger.Logger.*;
import static java.lang.String.*;

public class HomePage extends BaseForm {

    private final By BOOK_TITLE_LOCATOR = By.xpath("//*[contains(@id,'see-book')]");

    private final Button btnLogin = new Button(By.id("login"), "Login page");
    private final Label lblUserName = new Label(By.id("userName-value"), "User name");

    public HomePage() {
        super(By.id("searchBox-wrapper"), "Book Store");
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getUserNameText() {
        return lblUserName.getText();
    }

    public List<String> getBookTitles() {
        List<String> titles = new ArrayList<>();
        getBrowser().findElements(BOOK_TITLE_LOCATOR).forEach(key -> {
            titles.add(key.getText());
            infoElementAction(format("book title [%s]", key.getText()), "getting text from");
        });
        return titles;
    }
}
