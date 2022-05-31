package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {
    public SelenideElement accountName() {
        return $(".vcard-username").as("имя пользователя");
    }

}
