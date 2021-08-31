package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateDescription implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.DESCRIPTION_FORM).viewedBy(actor).asString();
    }

    public static ValidateDescription ofFormThree(){
        return new ValidateDescription();
    }
}
