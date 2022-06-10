import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("vakavava")
public class JUnitTest {
    @BeforeEach
    public void setup(){
        open("https://github.com/junit-team/junit4");
    }

    @Feature("Переключение веток")
    @Test
    @DisplayName("Переход на ветку fixtures")
    public void shouldOpenFixturesBranch(){
        step("Нажать на дропдаун для перехода между веток", () -> {
            TestPages.profilePage.branchDropdown()
                    .click();
        });
        step("Выбрать ветку fixtures", () -> {
            TestPages.junitPage.repoFixturesButton()
                    .click();
        });
        step("Проверить, что открылась страница ветки fixtures", () -> {
            TestPages.junitPage.commitsInBranchNotification()
                    .shouldBe(Condition.visible);
        });
    }

    @Feature("Поиск релизов")
    @MethodSource("correctData")
    @ParameterizedTest(name = "по {0}")
    @DisplayName("Поиск релизов")
    public void shouldSearchReleasesByNameAndNumber(String type, String searchData, String searchResults) {
        step("Нажать на кнопку Releases", () -> {
            TestPages.junitPage.releasesButton()
                    .click();
        });
        step("Проверить, что открылась страница с релизами", () -> {
            TestPages.junitPage.tabReleases()
                    .shouldBe(Condition.visible);
        });
        step("Ввести в поле ввода данные и нажать enter", () -> {
            TestPages.junitPage.searchInput()
                    .sendKeys(searchData + Keys.ENTER);
        });
        step("Проверить, что на странице отобразились нужные релизы", () -> {
            TestPages.junitPage.nameOfRelease()
                    .shouldHave(text(searchResults));
        });

    }

    static Stream<Arguments> correctData() {
        return Stream.of(
                arguments(
                        "цифрам и слову",
                        "JUnit 4.13 RC 1",
                        "JUnit 4.13 RC 1"
                ),

                arguments(
                        "цифрам",
                        "4.12",
                        "JUnit 4.12"
                ),

                arguments(
                        "слову",
                        "Beta",
                        "JUnit 4.13 Beta 3"
                )
        );
    }
}
