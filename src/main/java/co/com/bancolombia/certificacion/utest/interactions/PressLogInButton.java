package co.com.bancolombia.certificacion.utest.interactions;

import co.com.bancolombia.certificacion.utest.userinterfaces.Home;
import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PressLogInButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Home.BTN_LOGIN));
    }

    public static PressLogInButton toLogIntoAccount(){
        return instrumented(PressLogInButton.class);
    }
}
