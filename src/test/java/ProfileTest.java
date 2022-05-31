import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfileTest {
    @Test
    public void shouldOpenProfileTest() {
        open("https://github.com/");
        $("[href='/login']").click();
        $("[id='login_field']").sendKeys("Vakavava");
        $("[id='password']").sendKeys("JingleBells1984");
        $(".js-sign-in-button").click();
        $(".Header").shouldBe(Condition.visible);
        $("[aria-label='View profile and more']").click();
        $(byText("Your profile")).click();
        $(".vcard-username").shouldHave(text("Vakavava"));
    }
}
