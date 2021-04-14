package tests.annotation;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static data.TestData.*;

@DisplayName("Тесты с использованием Allure")
public class AllureAnnotatesStepsTest extends TestBase {

    private WebSteps steps = new WebSteps();

    @DisplayName("Тест с использованием Annotated steps")
    @Feature("Изучение Allure")
    @Story("Работа с Annotated steps")
    @Severity(SeverityLevel.MINOR)
    @Owner("Pavel Yartsev")
    @Test
    public void searchIssue() {
        steps.openMainPage(siteUrl);
        steps.searchForRepository(searchText);
        steps.openRepository(repository);
        steps.openIssuesTab(tabName);
        steps.checkIssueNameExists(issueName);
    }
}
