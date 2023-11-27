package com.booker.herokuapp.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/GetIdBook.feature/",
        glue = "com.booker.herokuapp.stepDefinitions",
        tags = "@GetBook",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GetIdBookRunner {
}
