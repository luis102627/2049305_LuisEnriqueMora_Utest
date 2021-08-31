package co.com.bancolombia.certificacion.utest.stepdefinitions;

import co.com.bancolombia.certificacion.utest.interactions.PressLogInButton;
import co.com.bancolombia.certificacion.utest.interactions.SelectThe;
import co.com.bancolombia.certificacion.utest.models.LogInInformation;
import co.com.bancolombia.certificacion.utest.questions.AnAlertIsDisplayed;
import co.com.bancolombia.certificacion.utest.questions.TheForgotPasswordButton;
import co.com.bancolombia.certificacion.utest.questions.TheStateButtonSignIn;
import co.com.bancolombia.certificacion.utest.questions.ValidateUsername;
import co.com.bancolombia.certificacion.utest.tasks.EnterEmail;
import co.com.bancolombia.certificacion.utest.tasks.EnterInvalid;
import co.com.bancolombia.certificacion.utest.tasks.EnterUserAndPass;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LogInStepDefinition {
    @Managed
    private WebDriver chrome;

    @Before
    public void setup() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(chrome)));
        OnStage.theActorCalled("Luis");
    }

    //FEATURE BACKGROUND
    @Given("^that the user is located on the utest main page$")
    public void thatTheUserIsLocatedOnTheUtestMainPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.utest.com/"));
    }


    @When("^the user select the Log In button$")
    public void theUserSelectTheLogInButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(PressLogInButton.toLogIntoAccount());
    }

    //FEATURE SUCCESSFULL LOG IN
    @And("^the user enters his email and password$")
    public void theUserEntersHisEmailAndPassword(List<LogInInformation> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterUserAndPass.forLogIn(data));
    }

    @Then("^the user should see an information card with the username (.*)$")
    public void theUserShouldSeeAnInformationCardWithTheUsernameLuisEnriqueMora(String username) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateUsername.ofCurrentUser(), Matchers.equalTo(username)));
    }

    //FEATURE FAILED LOG IN  FOR INVALID PASSWORD
    @And("^the user enters his email and invalid password$")
    public void theUserEntersHisEmailAndInvalidPassword(List<LogInInformation> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterInvalid.credentials(data));
    }

    @Then("^the user should see an alert with the following message (.*)$")
    public void theUserShouldSeeAnAlertWithTheFollowingMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AnAlertIsDisplayed.withTheMessage(),Matchers.equalTo(message)));
    }

    //FEATURE VALIDATE SIGN IN BUTTON INACTIVE
    @And("^the user only enters his email$")
    public void theUserOnlyEntersHisEmail(List<LogInInformation> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterEmail.inTheFormLogIn(data));
    }

    @Then("^the user should see the sign in button inactive$")
    public void theUserShouldSeeTheSignInButtonInactive() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStateButtonSignIn.isInactive(),Matchers.is(true)));
    }

    //FEATURE VALIDATE FORGOT PASSWORD ACTIVE
    @Then("^the user should see the forgot password button$")
    public void theUserShouldSeeTheForgotPasswordButton() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheForgotPasswordButton.isPresentInTheForm(),Matchers.is(true)));
    }
}
