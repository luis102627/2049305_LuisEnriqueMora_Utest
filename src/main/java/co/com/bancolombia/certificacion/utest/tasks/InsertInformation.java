package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InsertInformation implements Task {
    private String firstName;
    private String lastName;
    private String email;
    private String month;
    private String day;
    private String year;
    private String languaje;
    private String city;
    private String postalCode;
    private String password;
    private String confirmPassword;

    public InsertInformation(List<PersonalInformation>data){
        this.firstName=data.get(0).getFirstName();
        this.lastName=data.get(0).getLastName();
        this.email=data.get(0).getEmail();
        this.month=data.get(0).getMonth();
        this.day=data.get(0).getDay();
        this.year=data.get(0).getYear();
        this.languaje=data.get(0).getLanguaje();
        this.city=data.get(0).getCity();
        this.postalCode=data.get(0).getPostalCode();
        this.password=data.get(0).getPassword();
        this.confirmPassword=data.get(0).getConfirmPassword();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(firstName).into(RegistrationForm.TXT_FIRSTNAME),
                Enter.theValue(lastName).into(RegistrationForm.TXT_LASTNAME),
                Enter.theValue(email).into(RegistrationForm.TXT_EMAIL),
                SelectFromOptions.byVisibleText(month).from(RegistrationForm.SELECT_MONTH),
                SelectFromOptions.byVisibleText(day).from(RegistrationForm.SELECT_DAY),
                SelectFromOptions.byVisibleText(year).from(RegistrationForm.SELECT_YEAR),
                Enter.theValue(languaje + Keys.ENTER).into(RegistrationForm.TXT_SEARCH_LANGUAGE),
                Click.on(RegistrationForm.BTN_NEXT_LOCATION),
                Enter.theValue(city).into(RegistrationForm.TXT_CITY),
                Click.on(RegistrationForm.SELECT_CITY_FOUND),
                Enter.theValue(postalCode).into(RegistrationForm.TXT_POSTAL_CODE),
                Click.on(RegistrationForm.BTN_NEXT_LOCATION),
                Click.on(RegistrationForm.BTN_NEXT_LOCATION),
                Enter.theValue(password).into(RegistrationForm.TXT_PASSWORD),
                Enter.theValue(confirmPassword).into(RegistrationForm.TXT_CONFIRM_PASSWORD),
                Click.on(RegistrationForm.CHECK_STATE_INFORMED));
    }

    public static InsertInformation forHisRegister(List<PersonalInformation>data) {
        return instrumented(InsertInformation.class,data);
    }
}
