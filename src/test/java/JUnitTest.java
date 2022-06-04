import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

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
}
