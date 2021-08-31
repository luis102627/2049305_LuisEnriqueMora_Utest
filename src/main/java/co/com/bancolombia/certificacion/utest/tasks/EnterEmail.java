package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.LogInInformation;
import co.com.bancolombia.certificacion.utest.models.PersonalInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterEmail implements Task {
    private String email;
    public EnterEmail(List<LogInInformation>data){
        this.email=data.get(0).getEmail();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(email).into(LogInForm.TXT_USERNAME),
                Click.on(LogInForm.BTN_SIGN_IN),
                WaitUntil.the(LogInForm.LBL_ERROR_INVALID_USER_PASS, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds());
    }

    public static EnterEmail inTheFormLogIn(List<LogInInformation> data){
        return instrumented(EnterEmail.class,data);
    }
}
