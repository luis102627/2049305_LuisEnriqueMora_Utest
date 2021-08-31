package co.com.bancolombia.certificacion.utest.tasks;

import co.com.bancolombia.certificacion.utest.models.LogInInformation;
import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterInvalid implements Task {
    private String email;
    private String password;
    public EnterInvalid(List<LogInInformation>data){
        this.email=data.get(0).getEmail();
        this.password=data.get(0).getPassword();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(email).into(LogInForm.TXT_USERNAME),
                Enter.theValue(password).into(LogInForm.TXT_PASSWORD),
                Click.on(LogInForm.BTN_SIGN_IN),
                WaitUntil.the(LogInForm.LBL_ERROR_INVALID_USER_PASS, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds());
    }

    public static EnterInvalid credentials(List<LogInInformation>data){
        return instrumented(EnterInvalid.class,data);
    }
}
