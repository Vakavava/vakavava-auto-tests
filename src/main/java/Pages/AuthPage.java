package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    public SelenideElement mainSignInButton() {
        return $("[href='/login']").as("кнопка авторизации");
    }
    public SelenideElement logInInput() {
        return $("[id='login_field']").as("поле ввода логина");
    }
    public SelenideElement passwordInput() {
        return $("[id='password']").as("поле ввода пароля");
    }
    public SelenideElement signInButton() {
        return $(".js-sign-in-button").as("кнопка 'Войти'");
    }
}
