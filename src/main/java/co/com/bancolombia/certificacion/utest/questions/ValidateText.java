package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateText implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.LBL_EMAIL_INCORRECTO).viewedBy(actor).asString();
    }

    public static ValidateText ofEmail(){
        return new ValidateText();
    }
}
