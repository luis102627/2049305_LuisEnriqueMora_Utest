package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.LogInForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheForgotPasswordButton implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return LogInForm.BTN_FORGOT_PASS.resolveFor(actor).isEnabled();
    }

    public static TheForgotPasswordButton isPresentInTheForm(){
        return new TheForgotPasswordButton();
    }
}
