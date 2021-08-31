package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TextOfMessage implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(RegistrationForm.SUCCESSFUL_ACCOUNT_MESSAGE).viewedBy(actor).asString();
    }

    public static TextOfMessage isCorrect(){
        return new TextOfMessage();
    }
}
