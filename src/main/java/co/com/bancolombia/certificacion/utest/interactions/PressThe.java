package co.com.bancolombia.certificacion.utest.interactions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm.BTN_BACK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PressThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_BACK, WebElementStateMatchers.isEnabled()),
                Click.on(BTN_BACK));
    }

    public static PressThe backButton(){
        return instrumented(PressThe.class);
    }
}
