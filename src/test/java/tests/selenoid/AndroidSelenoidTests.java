package tests.selenoid;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tags({@Tag("android"), @Tag("selenoid")})
public class AndroidSelenoidTests extends SelenoidTestBase {

    @Test
    @DisplayName("Search in Wikipedia mobile application")
    void searchTest() {
        back();
        step("Open search input", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Enter a search query", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Check that search results are not empty", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Check four screens 'Get started'")
    void getStartedTest() {
        step("Check first screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check second screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check third screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check fourth screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/switchView")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        step("Check application main screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);
            $$(MobileBy.id("org.wikipedia.alpha:id/feed_view")).shouldHave(sizeGreaterThan(0));
            $$(MobileBy.className("android.widget.LinearLayout")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void addRussianLanguageTest() {
        step("Press 'ADD LANGUAGE' button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
            $$(MobileBy.id("org.wikipedia.alpha:id/wiki_language_title")).findBy(text("ADD LANGUAGE")).click();
        });
        step("Select Russian language", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Русский")).click());
        step("Check that 'Русский' exists in list", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/wiki_language_title")).shouldHave(texts("English", "Русский", "ADD LANGUAGE")));
    }

    @Test
    @Tag("selenoid")
    void addDarkThemeTest() {
        back();
        step("Open menu item 'More'", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Select 'Settings' item", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click());
        step("Select 'App theme' item in 'Setting' section", () ->
                $$(MobileBy.id("android:id/title")).findBy(text("App theme")).click());
        step("Select Dark theme", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/button_theme_dark")).click());
        back();
        back();
        step("Verify that Dark theme was selected in Settings section", () -> {
            $$(MobileBy.id("android:id/summary")).findBy(text("Dark")).shouldBe(visible);
        });
    }
}
