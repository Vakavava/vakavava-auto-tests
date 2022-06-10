import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ProfileTest {
    @Owner("vakavava")
    @Feature("Авторизация")
    @Story("Успешная авторизация")
    @Test
    @DisplayName("Успешная авторизация")
    public void shouldOpenProfileTest() {
        step("Открыть главную страницу гитхаб", () -> {
            open("https://github.com/");
        });
        step("Нажать на кнопку Sign In", () -> {
            TestPages.authPage.mainSignInButton()
                    .click();
        });
        step("Ввести в поля ввода логина и пароля данные", () -> {
            TestPages.authPage.logInInput()
                    .sendKeys("Vakavava");
            TestPages.authPage.passwordInput()
                    .sendKeys("JingleBells1984");
        });
        step("Нажать на кнопку входа", () -> {
            TestPages.authPage.signInButton()
                    .click();
        });
        step("Проверить, что прошла авторизация", () -> {
            TestPages.profilePage.header()
                    .shouldBe(Condition.visible);
        });
        step("Нажать на дропдаун аккаунта в хэдере", () -> {
            TestPages.profilePage.profileDropDown()
                    .click();
        });
        step("Нажать на кнопку My Profile", () -> {
            TestPages.profilePage.myProfileButton()
                    .click();
        });
        step("Проверить, что на странице появилось имя аккаунта", () -> {
            TestPages.profilePage.accountName()
                    .shouldHave(text("Vakavava"));
        });
    }
}
