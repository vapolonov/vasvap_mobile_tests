package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    String username = browserstackConfig.username();
    String password = browserstackConfig.password();
    String appUrl = browserstackConfig.appUrl();
    static String remoteUrl = browserstackConfig.remoteUrl();
    String device = browserstackConfig.device();
    String osVersion = browserstackConfig.osVersion();
    String project = browserstackConfig.project();
    String build = browserstackConfig.build();
    String name = browserstackConfig.name();

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", username);
        desiredCapabilities.setCapability("browserstack.key", password);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", appUrl);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", device);
        desiredCapabilities.setCapability("os_version", osVersion);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", project);
        desiredCapabilities.setCapability("build", build);
        desiredCapabilities.setCapability("name", name);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
