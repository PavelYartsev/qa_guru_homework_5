package tests.lambda;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты с использованием Allure")
public class AllureLambdaStepsTest extends TestBase {

    @Test
    @DisplayName("Тест с использованиея Lambda steps")
    @Owner("Pavel Yartsev")
    public void searchForIssue() {
        step("Открываем главную страницу ", (step) -> {
            step.parameter("url", siteUrl);
            open(siteUrl);
        });
        step("Ищем нужный репозиторий", (step) -> {
            step.parameter("searchText", searchText);
            $(".input-sm").click();
            $(".input-sm").sendKeys(searchText);
            $(".input-sm").submit();
        });
        step("Переходим в репозиторий", (step) -> {
            step.parameter("repository", repository);
            $(By.linkText(repository)).click();
        });
        step("Открываем вкладку Issues", (step) -> {
            step.parameter("tabName", tabName);
            $(withText(tabName)).click();
        });
        step("Проверяем, есть ли issue с нужным номером", (step) -> {
            step.parameter("issueName", issueName);
            $(withText(issueName)).should(Condition.exist);
        });
    }
}
