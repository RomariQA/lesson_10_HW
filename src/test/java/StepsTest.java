import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepsTest {

    @Test
    @DisplayName("Steps Lambda тест - название чтоб в отчете красиво было")
    public void stepsLambdaTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("/");
        });

        step("Применить поиск по пользователю github в шапке сайта", () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue("RomariQA");
            $("#query-builder-test").submit();
        });

        step("Выбрать в поисковой выдаче фильтр по пользователям", () -> {
            $(".Box-sc-g0xbh4-0.hTXDNh").$(byText("Users")).click();
        });

        step("Выбрать первого в списке пользователя", () -> {
            $(".Text__StyledText-sc-17v1xeu-0.ehTXUv").click();
        });

        step("Открыть репозиторий пользователя по наименованию", () -> {
            $(".js-pinned-items-reorder-container").$(byText("lesson_10_HW")).click();
        });

        step("Проверить что наименование второго таба на странице - Issue", () -> {
            $("#issues-tab").shouldHave(text("Issue"));
          });
    }


    @Test
    @DisplayName("Наименование таба Issue при открытии репозитория с главной страницы")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Страница репозитория github для неатворизованного")
    public void stepsTest (){

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchUser();
        steps.clickOnFilterByUsers();
        steps.choseUserFromList();
        steps.choseRepoFromList();
        steps.checkIssueTabName();
    }





}
