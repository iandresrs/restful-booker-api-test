package com.booker.herokuapp.stepDefinitions;

import com.booker.herokuapp.questions.book.ResponseServerCode;
import com.booker.herokuapp.tasks.book.GetBookTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.booker.herokuapp.constant.Constants.URL_BASE_BOOK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetBookStepDefinition {

    private static final String RESTAPI = URL_BASE_BOOK;

    @When("the user insert id book into url service")
    public void theUserInsertIdBookIntoUrlService() {
        Actor user = Actor.named("user")
                .whoCan(CallAnApi.at(RESTAPI));

        user.attemptsTo(
                GetBookTask.get()
        );
    }
    @Then("service response successfully")
    public void serviceResponseSuccessfully() {
        Actor user= Actor.named("user");
        user.should(
                seeThat(
                        "The response server is",
                        ResponseServerCode.was(),
                        equalTo(200)
                )
        );
    }
}
