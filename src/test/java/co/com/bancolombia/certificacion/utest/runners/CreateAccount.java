package co.com.bancolombia.certificacion.utest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\create_account.feature",
glue = "co.com.bancolombia.certificacion.utest.stepdefinitions",
snippets = SnippetType.CAMELCASE,
tags = "@SuccessfulAccount"
)
public class CreateAccount {
}
