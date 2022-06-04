import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JUnitTest {
    @BeforeEach
    public void setup(){
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @DisplayName("Переход на ветку fixtures")
    public void shouldOpenFixturesBranch(){
        TestPages.profilePage.branchDropdown().click();
        TestPages.junitPage.repoFixturesButton().click();
        TestPages.junitPage.commitsInBranchNotification().shouldBe(Condition.visible);
    }

    @MethodSource("correctData")
    @ParameterizedTest(name = "по {0}")
    @DisplayName("Поиск релизов")
    public void shouldSearchReleasesByNameAndNumber(String type, String searchData, String searchResults) {
        TestPages.junitPage.releasesButton().click();
        TestPages.junitPage.searchInput().sendKeys(searchData + Keys.ENTER);
        TestPages.junitPage.nameOfRelease().shouldHave(text(searchResults));
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
