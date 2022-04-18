package apk.wikipedia.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTestsWiki extends TestBase {
    @Test
    void wikiTest() {
        step("Кликнуть на ADD OR EDIT LANGUAGE", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/addLangContainer")).click()
        );
        step("Кликнуть на ADD LANGUAGE", () ->
                $(MobileBy.xpath("//android.widget.TextView[@text='ADD LANGUAGE']")).click()
        );
        step("Кликнуть на Русский", () ->
                $(MobileBy.xpath("//android.widget.TextView[@text='Русский']")).click()
        );
        step("Проверить, что Русский в списке", () ->
                $(MobileBy.xpath("//android.widget.TextView[@text='Русский']")).shouldBe(Condition.visible)
        );
        step("Нажать стрелочку", () ->
                $(MobileBy.className("android.widget.ImageButton")).click()
        );
        step("Проверить, что в спискок состоит из 2х языков", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/languagesList"))
                    .$$(MobileBy.id("org.wikipedia.alpha:id/option_label")).shouldHave(size(2));
        });

        step("Перейти на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click()
        );

        step("Проверить наличие текста на втором экране", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"))
        );

        step("Перейти на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click()
        );

        step("Проверить наличие текста на третьем экране", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"))
        );

        step("Перейти на следующий экран", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click()
        );

        step("Проверить наличие текста на четвертом экране", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"))
        );

        step("Переключить ползунок", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/switchView")).click()
        );

        step("Проверить, что ползунок не активен", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/switchView")).shouldHave(attribute("checked", "false"))
        );

        step("Кликнуть GET STARTED", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click()
        );

        step("Поиск", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Проверка поисковой выдачи", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0))
        );
    }
}
