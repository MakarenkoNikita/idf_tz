package structure.page;

import framework.element.Button;
import framework.element.TextBox;
import framework.form.BaseForm;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private final TextBox txbUserName = new TextBox(By.id("userName"), "User name");
    private final TextBox txbPassword = new TextBox(By.id("password"), "Password");
    private final Button btnLogin = new Button(By.id("login"), "Login");

    public LoginPage() {
        super(By.id("userForm"), "Login page");
    }

    public LoginPage fillUserName(String value) {
        txbUserName.clearAndType(value);
        return this;
    }

    public LoginPage fillPassword(String value) {
        txbPassword.clearAndType(value);
        return this;
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
