package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateName implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.NAME_FIRST_FORM).viewedBy(actor).asString();
    }

    public static ValidateName ofFormSelected(){
        return new ValidateName();
    }
}
