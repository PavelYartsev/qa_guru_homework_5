package tests.with.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class AllureLambdaStepsTest {

    private final static String siteUrl = "https://github.com/";
    private final static String repository = "eroshenkoam/allure-example";
    private final static int issueNumber = 68;

    @Test
    public void searchForIssue() {

        step("Открываем главную страницу ", () -> {
            open(siteUrl);
        });
        step ("Ищем нужный репозиторий", () -> {
            $(".input-sm").click();
            $(".input-sm").sendKeys(repository);
            $(".input-sm").submit();
                });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(repository)).click();
        });
        step("Открываем вкладку Issues", () -> {
            $(withText("Issues12")).click();
        });
        step("Проверяем, есть ли issue с нужным номером", () -> {
            $(withText("#" + issueNumber)).should(Condition.exist);
        });
    }
}
