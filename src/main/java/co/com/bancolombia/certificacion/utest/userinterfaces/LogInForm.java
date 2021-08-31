package co.com.bancolombia.certificacion.utest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LogInForm {
    public static final Target TXT_USERNAME = Target.the("username field").located(By.id("username"));
    public static final Target TXT_PASSWORD = Target.the("password field").located(By.id("password"));
    public static final Target BTN_SIGN_IN = Target.the("sign in button").located(By.id("kc-login"));
    public static final Target BTN_FORGOT_PASS = Target.the("forgot password button").located(By.xpath("//a[contains(text(),'Forgot Password')]"));
    public static final Target BTN_SEND_CONFIRMATION_EMAIL = Target.the("resend confirmation email button").located(By.xpath("//a[contains(text(),'Resend Confirmation Email')]"));
    public static final Target LBL_INFO_USER = Target.the("info name card").located(By.cssSelector(".nav-sidebar-user-card-info__name"));
    public static final Target LBL_ERROR_INVALID_USER_PASS = Target.the("invalid user or password message").located(By.xpath("//span[contains(text(),'Invalid username or password.')]"));
}
