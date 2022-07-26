package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.safari.options.SafariOptions;

import java.net.URL;

public class DriverBase {
    private static AppiumDriver driver;

    public static void initializeDriver(URL appiumURL, XCUITestOptions capabilities) {
       initIOSDriver(appiumURL, capabilities);
    }
    public static void initializeDriver(URL appiumURL, SafariOptions capabilities) {
        initIOSDriver(appiumURL, capabilities);
    }
    public static void initializeDriver(URL appiumURL, UiAutomator2Options capabilites) {
        initAndroidDriver(appiumURL, capabilites);
    }

    private static void initAndroidDriver(URL appiumURL, UiAutomator2Options capabilites) {
        driver = new AndroidDriver(appiumURL, capabilites);
    }

    public static AppiumDriver getAppiumDriver() {
        return driver;
    }

    private static void initIOSDriver(URL appiumURL, XCUITestOptions capabilities) {
        driver = new IOSDriver(appiumURL, capabilities);
    }

    private static void initIOSDriver(URL appiumURL, SafariOptions capabilities) {
        driver = new IOSDriver(appiumURL, capabilities);
    }
    public static void closeDriver() {
        driver.quit();
    }
}
