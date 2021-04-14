package tests.selenide;

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

@DisplayName("Тесты с использованием Allure")
public class AllureSelenideTest extends TestBase {

    @Test
    @Owner("Pavel Yartsev")
    @DisplayName("Тест с ипользованием Allure и Selenide")
    public void searchForIssue() {
        open(siteUrl);
        $(".input-sm").click();
        $(".input-sm").sendKeys(searchText);
        $(".input-sm").submit();
        $(By.linkText(repository)).click();
        $(withText(tabName)).click();
        $(withText(issueName)).should(Condition.exist);
    }
}
