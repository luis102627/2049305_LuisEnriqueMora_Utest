package co.com.bancolombia.certificacion.utest.questions;

import co.com.bancolombia.certificacion.utest.userinterfaces.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TheForm implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {
        if (RegistrationForm.ALERT_MESSAGE.resolveAllFor(actor).size()>0){
            return true;
        } else{
            return false;
        }
    }

    public static TheForm isIncomplete() {
        return new TheForm();
    }
}
