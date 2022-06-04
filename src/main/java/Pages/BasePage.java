package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    public SelenideElement header() {
        return $(".Header").as("Хэдер");
    }
    public SelenideElement profileDropDown() {
        return $("[aria-label='View profile and more'").as("Дропдаун профиля");
    }
    public SelenideElement myProfileButton() {
        return $(byText("Your profile")).as("кнопка 'Мой профиль'");
    }
    public SelenideElement branchDropdown() {
        return $("[title='Switch branches or tags']").as("дропдаун для переключения веток");
    }
}
