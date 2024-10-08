import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть главную страницу")
    public WebSteps openMainPage(){
        open("/");

        return this;
    }

    @Step("Применить поиск по пользователю github в шапке сайта")
    public WebSteps searchUser(){
        $(".header-search-button").click();
        $("#query-builder-test").setValue("RomariQA").submit();

        return this;
    }

    @Step("Выбрать в поисковой выдаче фильтр по пользователям")
    public WebSteps clickOnFilterByUsers(){
        $(".Box-sc-g0xbh4-0.hTXDNh").$(byText("Users")).click();

        return this;
    }

    @Step("Выбрать первого в списке пользователя")
    public WebSteps choseUserFromList(){
        $(".Text__StyledText-sc-17v1xeu-0.ehTXUv").click();

        return this;
    }

    @Step("Открыть репозиторий пользователя по наименованию")
    public WebSteps choseRepoFromList(){
        $(".js-pinned-items-reorder-container").$(byText("lesson_10_HW")).click();

        return this;
    }

    @Step("Проверить что наименование второго таба на странице - Issue")
    public WebSteps checkIssueTabName(){
        $("#issues-tab").shouldHave(text("Issue"));

        return this;
    }
}
