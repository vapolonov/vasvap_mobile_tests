package tests.browserstack;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tags({@Tag("android"), @Tag("browserstack")})
public class AndroidBrowserstackTests extends BrowserstackTestBase {

    @Test
    @DisplayName("Search in Wikipedia mobile application")
    void searchTest() {
        step("Open search input", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Enter a search query", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Check that search results are not empty", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("")
    void addRussianLanguageTest() {
        step("Tap menu button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click());
        step("Select Setting item", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click());
        step("Tap Wikipedia language item", () ->
                $$(MobileBy.id("android:id/title")).findBy(text("Wikipedia language")).click());
        step("Select Russian language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).sendKeys("Русский");
            $$(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Русский")).click();
        });
        step("Verify that Wiki language = Русский", () ->
                $$(MobileBy.id("android:id/summary")).findBy(text("Русский")).shouldHave(text("Русский")));
    }
}
