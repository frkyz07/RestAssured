package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition {

    @Given("^User is on the landing page$")
    public void user_is_on_the_landing_page() throws Throwable {
        System.out.println("User is on the landing page");
    }

    @When("^User login into app with username and password$")
    public void user_login_into_app_with_username_and_password() throws Throwable {
        System.out.println("User login into app with username and password");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Home page is populated");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        System.out.println("Cards are displayed");
    }

}