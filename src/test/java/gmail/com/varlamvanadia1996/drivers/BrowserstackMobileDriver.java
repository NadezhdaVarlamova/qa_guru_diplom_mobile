package gmail.com.varlamvanadia1996.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.com.varlamvanadia1996.config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        String user = Credentials.config.user();
        String key = Credentials.config.key();
        String app = Credentials.config.app();

        caps.setCapability("browserstack.user", user);
        caps.setCapability("browserstack.key", key);

//        caps.setCapability("browserstack.user", "varlamovanadezhd_oHdgBW");
//        caps.setCapability("browserstack.key", "rrqcDqNiPBQCMJsK57qJ");

        // Set URL of the application under test
//        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
//        caps.setCapability("app", "bs://18e7b1ebef476a8159aa3c8e93ae8ac31c0f301c");
        caps.setCapability("app", app);

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}
