package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSystemDoes implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return RegistrationForm.ALERT_MESSAGE.resolveFor(actor).isVisible();
    }

    public static TheSystemDoes notAllowToContinue() {
        return new TheSystemDoes();
    }
}
