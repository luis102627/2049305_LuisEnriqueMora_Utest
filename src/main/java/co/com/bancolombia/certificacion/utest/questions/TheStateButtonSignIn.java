package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheStateButtonSignIn implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return LogInForm.BTN_SIGN_IN.resolveFor(actor).isDisabled();
    }

    public static TheStateButtonSignIn isInactive(){
        return new TheStateButtonSignIn();
    }
}
