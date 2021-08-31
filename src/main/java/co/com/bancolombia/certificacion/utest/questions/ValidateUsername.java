package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateUsername implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(LogInForm.LBL_INFO_USER).viewedBy(actor).asString();
    }

    public static ValidateUsername ofCurrentUser(){
        return new ValidateUsername();
    }
}
