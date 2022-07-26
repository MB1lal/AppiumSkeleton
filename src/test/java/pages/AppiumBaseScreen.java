package pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static driver.DriverBase.getAppiumDriver;

public class AppiumBaseScreen {

    public AppiumBaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    protected void moveFocusOnElement(WebElement element) {
        new Actions(getAppiumDriver()).moveToElement(element).perform();
    }
    protected boolean pageContainsText(String text) {
        return getAppiumDriver().getPageSource().contains(text);
    }
    protected void navigateToURL(String url) {
        getAppiumDriver().get(url);
    }
    protected void waitUntilURLContains(String text) {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(text));
    }
    protected String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    protected void swipeOnElement(WebElement element, String direction) {
        JavascriptExecutor js = getAppiumDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("velocity", 100);
        params.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: swipe", params);
    }
}
