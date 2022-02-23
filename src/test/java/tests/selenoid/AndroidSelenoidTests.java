package tests.selenoid;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
}
