package co.com.bancolombia.certificacion.utest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Home {
    public static final Target BTN_LOGIN = Target.the("login button")
            .located(By.xpath("//a[@class='unauthenticated-nav-bar__link' and contains(text(),'Log In')]"));
    public static final Target BTN_JOIN_TODAY = Target.the("join today button")
            .located(By.xpath("//a[text()='Join Today' and @class='unauthenticated-nav-bar__sign-up']"));
}
