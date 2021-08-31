package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm.BTN_NEXT_LOCATION;

public class ValidateThat implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return BTN_NEXT_LOCATION.resolveFor(actor).isDisabled();
    }

    public static ValidateThat theButtonIsInactive() {
        return new ValidateThat();
    }
}
