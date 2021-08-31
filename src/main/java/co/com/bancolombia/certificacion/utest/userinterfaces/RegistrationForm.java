package co.com.bancolombia.certificacion.utest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class RegistrationForm {
    //FORM Tell us about yourself
    public static final Target TXT_FIRSTNAME = Target.the("user field").located(By.id("firstName"));
    public static final Target TXT_LASTNAME = Target.the("lastname field").located(By.id("lastName"));
    public static final Target TXT_EMAIL = Target.the("email field").located(By.id("email"));
    public static final Target LBL_EMAIL_INCORRECTO = Target.the("incorrect email field").located(By.id("emailError"));
    public static final Target SELECT_MONTH = Target.the("month field").located(By.id("birthMonth"));
    public static final Target SELECT_DAY = Target.the("day field").located(By.id("birthDay"));
    public static final Target SELECT_YEAR = Target.the("day field").located(By.id("birthYear"));
    public static final Target TXT_SEARCH_LANGUAGE = Target.the("languaje field").located(By.xpath("//input[@type='search']"));
    public static final Target BTN_NEXT_LOCATION = Target.the("next button").located(By.cssSelector("a[class^='btn btn-blue']"));
    public static final Target NAME_FIRST_FORM = Target.the("name first form").located(By.xpath("//span[contains(text(),'Tell us about yourself')]"));
    //FORM Add your address
    public static final Target TXT_CITY = Target.the("city field").located(By.id("city"));
    public static final Target SELECT_CITY_FOUND = Target.the("city field").located(By.xpath("//div[@class='pac-item']"));
    public static final Target TXT_POSTAL_CODE = Target.the("postal code field").located(By.id("zip"));
    public static final Target NAME_SECOND_FORM = Target.the("name second form").located(By.xpath("//span[contains(text(),'Add your address')]"));
    public static final Target BTN_BACK = Target.the("back button").located(By.xpath("//span[contains(text(),'Back')]"));
    //FORM Tell us about your devices
    public static final Target DESCRIPTION_FORM = Target.the("description form").located(By.cssSelector(".step-intro"));
    //FORM The last step
    public static final Target TXT_PASSWORD = Target.the("password field").located(By.id("password"));
    public static final Target TXT_CONFIRM_PASSWORD = Target.the("confirm password field").located(By.id("confirmPassword"));
    public static final Target CHECK_STATE_INFORMED = Target.the("state informed field").located(By.name("newsletterOptIn"));
    public static final Target CHECK_TERM_OF_USE = Target.the("term of use field").located(By.id("termOfUse"));
    public static final Target CHECK_PRIVACY_SETTINGS = Target.the("privacy settings field").located(By.id("privacySetting"));
    public static final Target SUCCESSFUL_ACCOUNT_MESSAGE = Target.the("successfull account message").located(By.xpath("//h1[contains(text(),'Welcome')]"));
    public static final Target ALERT_MESSAGE = Target.the("alert terms").located(By.xpath("//span[@class='error-msg']"));
    public static final Target ALERT_DIFFERENT_KEYS = Target.the("alert different keys").located(By.xpath("//span[contains(text(),'Password mismatch')]"));
}
