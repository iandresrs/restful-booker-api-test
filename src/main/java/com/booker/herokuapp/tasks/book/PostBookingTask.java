package com.booker.herokuapp.tasks.book;

import com.booker.herokuapp.models.book.PostBookingModel;
import com.booker.herokuapp.questions.book.BuildBooking;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostBookingTask implements Task {

    private final String endpoint;
    private final String firstname;
    private final String lastname;
    private final Integer totalprice;
    private final String depositpaid;
    private final String additionalneeds;

    public PostBookingTask(String endpoint, String firstname, String lastname, Integer totalprice, String depositpaid, String additionalneeds) {
        this.endpoint = endpoint;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        PostBookingModel bookInfo = actor.asksFor(BuildBooking.was(firstname, lastname, totalprice, depositpaid, additionalneeds));

        actor.attemptsTo(
                Post.to(endpoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(bookInfo)
                )
        );
    }

    public static PostBookingTask fromBook(String endpoint, String firstname, String lastname, Integer totalprice, String depositpaid, String additionalneeds){
        return instrumented(PostBookingTask.class, endpoint, firstname, lastname, totalprice, depositpaid,additionalneeds);
    }
}
