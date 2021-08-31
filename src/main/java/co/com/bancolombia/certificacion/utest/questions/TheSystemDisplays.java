package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheSystemDisplays implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.ALERT_DIFFERENT_KEYS).viewedBy(actor).asString();
    }

    public static TheSystemDisplays anErrorMessage() {
        return new TheSystemDisplays();
    }
}
