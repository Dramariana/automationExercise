package co.com.automationExercise.stepdefinitions;

import co.com.automationExercise.task.GoTo;
import co.com.automationExercise.task.ListProducts;
import co.com.automationExercise.task.SearchProduct;
import co.com.automationExercise.userinterfaces.AutomationExerciseHomePage;
import co.com.automationExercise.userinterfaces.AutomationExerciseProducts;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AutomationExerciseStepdefinitions {

    public static final int CURRENT_PRODUCT = 0;
    AutomationExerciseHomePage automationExerciseHomePage;
    AutomationExerciseProducts automationExerciseProducts;


    @Managed(driver = "firefox", uniqueSession = true)
    public WebDriver hisBrowser;
    private final Actor user = Actor.named("Mariana");


    @Before
    public void actorCanBrowseTheWeb() {
        user.can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().window().maximize();
    }


    @Given("user enters automationExercise site")
    public void userEntersAutomationExerciseSite() {
        user.wasAbleTo(Open.browserOn().the(automationExerciseHomePage));
    }

    @And("user select product button")
    public void userSelectProductButton() {

        user.attemptsTo(GoTo.products(hisBrowser));
    }

    @When("user search {string}")
    public void userSearch(String product) {
        user.attemptsTo(SearchProduct.AutomationExercise(product));
    }

    @Then("user can view all products related to search")
    public void userCanViewAllProductsRelatedToSearch() {
        user.attemptsTo(ListProducts.found());
    }


}
