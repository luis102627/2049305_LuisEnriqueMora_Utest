package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateTitle implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.NAME_SECOND_FORM).viewedBy(actor).asString();
    }

    public static  ValidateTitle ofTheSecondForm(){
        return new ValidateTitle();
    }
}
