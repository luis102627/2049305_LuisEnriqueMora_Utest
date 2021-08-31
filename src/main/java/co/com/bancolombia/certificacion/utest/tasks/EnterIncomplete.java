package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterIncomplete implements Task {
    private String firstName;
    private String lastName;

    public EnterIncomplete(List<PersonalInformation> data) {
        this.firstName = data.get(0).getFirstName();
        this.lastName = data.get(0).getLastName();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(firstName).into(RegistrationForm.TXT_FIRSTNAME),
                Enter.theValue(lastName).into(RegistrationForm.TXT_LASTNAME),
                Click.on(RegistrationForm.BTN_NEXT_LOCATION));
    }

    public static EnterIncomplete informationToRegister(List<PersonalInformation> data) {
        return instrumented(EnterIncomplete.class, data);
    }
}
