package tests.annotation;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу {siteUrl}")
    public void openMainPage(String siteUrl) {
        open(siteUrl);
    }

    @Step("Ищем нужный репозиторий {searchText}")
    public void searchForRepository(String searchText) {
        $(".input-sm").click();
        $(".input-sm").sendKeys(searchText);
        $(".input-sm").submit();
    }

    @Step("Открываем репозиторий {repository}")
    public void openRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Открываем вкладку {tabName}")
    public void openIssuesTab(String tabName) {
        $(withText(tabName)).click();
    }

    @Step("Проверяем, есть ли issue с нужным именем {issueName}")
    public void checkIssueNameExists(String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }
}
