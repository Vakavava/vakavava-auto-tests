package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JUnitPage {
    public SelenideElement repoFixturesButton() {
        return $("[href='https://github.com/junit-team/junit4/tree/fixtures']").as("ветка fixtures");
    }
    public SelenideElement commitsInBranchNotification() {
        return $(byText("This branch is")).as("уведомление о коммитах");
    }
    public SelenideElement releasesButton() {
        return $("[href='/junit-team/junit4/releases']").as("кнопка перехода на страницу релизов");
    }
    public SelenideElement searchInput() {
        return $(".form-control.subnav-search-input.width-full").as("поле ввода");
    }
    public SelenideElement nameOfRelease() {
        return $(".Box-body").as("название релиза");
    }
}
