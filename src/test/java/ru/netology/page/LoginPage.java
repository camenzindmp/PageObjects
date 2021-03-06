package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.AuthData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage() { open("http://localhost:9999"); }

    private SelenideElement loginField = $("[class='input__control'][type=text]");
    private SelenideElement passwordField = $("[class='input__control'][type=password]");
    private SelenideElement loginButton = $("[type=button] [class='button__content']");

    public VerificationPage validLogin(AuthData.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
