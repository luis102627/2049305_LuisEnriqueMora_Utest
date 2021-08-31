package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterMail implements Task {
    private String firstName;
    private String lastName;
    private String email;

    public EnterMail(List<PersonalInformation> data) {
        this.firstName = data.get(0).getFirstName();
        this.lastName = data.get(0).getLastName();
        this.email = data.get(0).getEmail();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(firstName).into(RegistrationForm.TXT_FIRSTNAME),
                Enter.theValue(lastName).into(RegistrationForm.TXT_LASTNAME),
                Enter.theValue(email).into(RegistrationForm.TXT_EMAIL),
                WaitUntil.the(RegistrationForm.LBL_EMAIL_INCORRECTO,
                        WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds());
    }

    public static EnterMail withInvalidFormat(List<PersonalInformation> data) {
        return instrumented(EnterMail.class, data);
    }
}
