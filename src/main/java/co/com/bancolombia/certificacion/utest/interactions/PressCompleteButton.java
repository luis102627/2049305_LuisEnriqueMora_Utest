package co.com.bancolombia.certificacion.utest.interactions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PressCompleteButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(RegistrationForm.BTN_NEXT_LOCATION));
    }

    public static PressCompleteButton forCompleteHisRegister(){
        return instrumented(PressCompleteButton.class);
    }
}
