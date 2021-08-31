package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterInformationIn implements Task {
    private String firstName;
    private String lastName;
    private String email;
    private String month;
    private String day;
    private String year;
    private String languaje;

    public EnterInformationIn(List<PersonalInformation> data) {
        this.firstName = data.get(0).getFirstName();
        this.lastName = data.get(0).getLastName();
        this.email = data.get(0).getEmail();
        this.month = data.get(0).getMonth();
        this.day = data.get(0).getDay();
        this.year = data.get(0).getYear();
        this.languaje = data.get(0).getLanguaje();
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
                Click.on(RegistrationForm.BTN_NEXT_LOCATION));
    }

    public static EnterInformationIn firtsForm(List<PersonalInformation> data) {
        return instrumented(EnterInformationIn.class, data);
    }
}
