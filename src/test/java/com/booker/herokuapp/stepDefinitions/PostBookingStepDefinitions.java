package com.booker.herokuapp.stepDefinitions;

import com.booker.herokuapp.questions.book.ResponseServerCode;
import com.booker.herokuapp.tasks.book.PostBookingTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.booker.herokuapp.constant.Constants.URL_BASE_BOOK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBookingStepDefinitions {

    private static final String RESTAPI = URL_BASE_BOOK;

    @When("I consume the endpoint {string} and I send the booking information firstname {string}, lastname {string}, totalprice {int}, depositpaid {string}, additionalneeds {string}")
    public void iConsumeTheEndpointAndISendTheBookingInformationFirstnameLastnameTotalpriceDepositpaidAdditionalneeds(String endpoint, String firstname, String lastname, Integer totalprice, String depositpaid, String additionalneeds) {
        Actor book = Actor.named("book")
                .whoCan(CallAnApi.at(RESTAPI));

        book.attemptsTo(
                PostBookingTask.fromBook(endpoint, firstname, lastname, totalprice, depositpaid, additionalneeds)
        );
    }

    @Then("I can validate the response service code {int}")
    public void iCanValidateTheResponseServiceCode(Integer code) {
        Actor book = Actor.named("book");

        book.should(
                seeThat(
                        "The response server: ",
                        ResponseServerCode.was(),
                        equalTo(code)
                )
        );

    }

}
