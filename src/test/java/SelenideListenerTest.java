import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest extends TestBase {

    @Test
    @DisplayName("Просто тест на селениде (с Listener)")
    public void selenideNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("RomariQA");
        $("#query-builder-test").submit();
        $(".Box-sc-g0xbh4-0.hTXDNh").$(byText("Users")).click();
        $(".Text__StyledText-sc-17v1xeu-0.ehTXUv").click();
        $(".js-pinned-items-reorder-container").$(byText("lesson_10_HW")).click();
        $("#issues-tab").shouldHave(text("Issue"));
    }
}
