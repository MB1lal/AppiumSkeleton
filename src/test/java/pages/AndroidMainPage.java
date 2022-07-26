package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class AndroidMainPage extends AppiumBaseScreen {

    @AndroidFindBy(accessibility = "Text")
    WebElement optionText;
    @AndroidFindBy(accessibility = "LogTextBox")
    WebElement optionLogTextBox;
    @AndroidFindBy(accessibility = "Add")
    WebElement btnAdd;
    @Step
    public void selectOption(String pageName) {
        switch (pageName) {
            case "Text":
                optionText.click();
                break;

            case "LogTextBox":
                optionLogTextBox.click();
                break;

            default:
                throw new RuntimeException("Invalid sub page option selected");
        }
    }

    public void pressButton(String btnName) {
        switch (btnName) {
            case "ADD":
                btnAdd.click();
                break;
        }
    }

    public Boolean getOnScreenText(String expectedText) {
        return pageContainsText(expectedText);
    }
}
