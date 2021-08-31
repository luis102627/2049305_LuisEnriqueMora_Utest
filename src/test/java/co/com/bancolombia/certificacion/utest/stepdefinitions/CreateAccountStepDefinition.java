package co.com.bancolombia.certificacion.utest.stepdefinitions;
import co.com.bancolombia.certificacion.utest.interactions.PressCompleteButton;
import co.com.bancolombia.certificacion.utest.interactions.PressThe;
import co.com.bancolombia.certificacion.utest.interactions.SelectThe;
import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.questions.*;
import co.com.bancolombia.certificacion.utest.tasks.*;
import co.com.bancolombia.certificacion.utest.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.com.bancolombia.certificacion.utest.utils.Constants.*;

public class CreateAccountStepDefinition {
    @Managed
    private WebDriver chrome;

    @Before
    public void setup() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(chrome)));
        OnStage.theActorCalled("Luis");
    }

    //FEATURE BACKGROUND
    @Given("^that the user is located on the main page$")
    public void thatTheUserIsLocatedOnTheMainPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.utest.com/"));
    }

    @When("^the user select the join today button$")
    public void theUserSelectTheJoinTodayButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectThe.joinTodayButton());
    }

    //FEATURE SUCCESSFUL ACCOUNT
    @And("^the user enters their personal information in the registration form$")
    public void theUserEntersTheirPersonalInformationInTheRegistrationForm(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterInformation.toCreateAccount(data));
    }

    @Then("^the user will see the message (.*)$")
    public void theUserWillSeeTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TextOfMessage.isCorrect(),Matchers.equalTo(message)));
    }

    //FEATURE INVALID EMAIL
    @And("^the user enter email with invalid format$")
    public void theUserEnterEmailWithInvalidFormat(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterMail.withInvalidFormat(data));
    }

    @Then("^the user should see the message (.*)$")
    public void theUserShouldSeeTheMessageEnterValidEmail(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateText.ofEmail(), Matchers.equalTo(message)));
    }

    //FEATURE INCOMPLETE FORM
    @And("^the user enter incomplete information in the form$")
    public void theUserEnterIncompleteInformationInTheForm(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterIncomplete.informationToRegister(data));
    }

    @Then("^the user will not be able to continue with the registration$")
    public void theUserWillNotBeAbleToContinueWithTheRegistration() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheForm.isIncomplete(),Matchers.is(true)));
    }

    //FEATURE VALIDATION NAME SECOND FORM
    @And("^the user enter information in the first form$")
    public void theUserEnterInformationInTheFirstForm(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterInformationIn.firtsForm(data));
    }

    @Then("^the user should see the form (.*)$")
    public void theUserShouldSeeTheForm(String formTitle) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateTitle.ofTheSecondForm(),Matchers.equalTo(formTitle)));
    }

    //FEATURE VALIDATION NEXT LOCATION BUTTON ACTIVE
    @And("^the user enter information in some fields$")
    public void theUserEnterInformationInSomeFields(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterSomeInformation.inSomeFields(data));
    }


    @Then("^the user should see the next location button inactive$")
    public void theUserShouldSeeTheNextLocationButtonInactive() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateThat.theButtonIsInactive(),Matchers.is(true)));
    }

    //FEATURE VALIDATION BUTTON BACK
    @And("^the user enter information in the first form of register$")
    public void theUserEnterInformationInTheFirstFormOfRegister(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(TypeInformation.inTheFirtsForm(data));
    }

    @And("^the user select the back button$")
    public void theUserSelectTheBackButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(PressThe.backButton());
    }

    @Then("^the user should see again the form (.*)$")
    public void theUserShouldSeeAgainTheForm(String title) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateName.ofFormSelected(),Matchers.equalTo(title)));
    }

    //FEATURE VALIDATE DESCRIPTION FORM THREE
    @And("^the user enter information in the forms of register$")
    public void theUserEnterInformationInTheFormsOfRegister(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddInformation.theFirstTwoForms(data));
    }

    @Then("^the user will be able to see the description of form three$")
    public void theUserWillBeAbleToSeeTheDescriptionOfFormThree() {
        String descriptionForm = DESCRIPTION_FORM;
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateDescription.ofFormThree(),Matchers.equalTo(descriptionForm)));
    }

    //FEATURE DIFFERENT KEYS
    @And("^the user enters information with different keys$")
    public void theUserEntersInformationWithDifferentKeys(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(EnterInformationWith.differentKeys(data));
    }

    @Then("^the user should see the alert with the message (.*)$")
    public void theUserShouldSeeTheAlertWithTheMessagePasswordMismatch(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheSystemDisplays.anErrorMessage(),Matchers.equalTo(message)));
    }

    //FEATURE VALIDATE TERMS
    @And("^the user enters the complete information$")
    public void theUserEntersTheCompleteInformation(List<PersonalInformation>data) {
        OnStage.theActorInTheSpotlight().attemptsTo(InsertInformation.forHisRegister(data));
    }

    @But("^the user not select terms and policies and select complete setup button$")
    public void theUserNotSelectTermsAndPoliciesAndSelectCompleteSetupButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(PressCompleteButton.forCompleteHisRegister());
    }

    @Then("^the user will not be able to complete their registration$")
    public void theUserWillNotBeAbleToCompleteTheirRegistration() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheSystemDoes.notAllowToContinue(),Matchers.is(true)));
    }
}
