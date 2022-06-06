import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class ProfileTest {
    @Test
    @DisplayName("Успешная авторизация")
    public void shouldOpenProfileTest() {
        open("https://github.com/");
        TestPages.authPage.mainSignInButton()
                .click();
        TestPages.authPage.logInInput()
                .sendKeys("Vakavava");
        TestPages.authPage.passwordInput()
                .sendKeys("JingleBells1984");
        TestPages.authPage.signInButton()
                .click();
        TestPages.profilePage.header()
                .shouldBe(Condition.visible);
        TestPages.profilePage.profileDropDown()
                .click();
        TestPages.profilePage.myProfileButton()
                .click();
        TestPages.profilePage.accountName()
                .shouldHave(text("Vakavava"));
    }
}
