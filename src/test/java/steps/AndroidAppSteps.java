package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.AndroidMainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AndroidAppSteps {


    @Steps
    AndroidMainPage androidMainPage;

    @Given("User navigates to {} page")
    @And("User clicks {} option")
    public void navigateToSubPage(String pageName) {
        androidMainPage.selectOption(pageName);
    }

    @When("User presses the {} button")
    public void pressTheButton(String btnName) {
        androidMainPage.pressButton(btnName);
    }

    @Then("{} should be displayed")
    public void assertTextIsDisplayed(String expectedText) {
        assertThat(androidMainPage.getOnScreenText(expectedText)).isTrue();
    }


}
