package co.com.bancolombia.certificacion.utest.interactions;

import co.com.bancolombia.certificacion.utest.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Home.BTN_JOIN_TODAY));
    }

    public static SelectThe joinTodayButton() {
        return instrumented(SelectThe.class);
    }
}
