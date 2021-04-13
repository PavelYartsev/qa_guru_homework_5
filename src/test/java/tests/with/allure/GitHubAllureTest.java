package tests.with.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class GitHubAllureTest {

    private final static String siteUrl = "https://github.com/";
    private final static String repository = "eroshenkoam/allure-example";
    private final static int issueNumber = 68;

    @Test
    public void searchForIssue(){
        open(siteUrl);
        $(".input-sm").click();
        $(".input-sm").sendKeys(repository);
        $(".input-sm").submit();
        $(By.linkText(repository)).click();
        $(withText("Issues12")).click();
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
}
