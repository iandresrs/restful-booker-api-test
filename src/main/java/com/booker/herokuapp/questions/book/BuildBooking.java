package com.booker.herokuapp.questions.book;

import com.booker.herokuapp.models.book.BookingDate;
import com.booker.herokuapp.models.book.PostBookingModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildBooking implements Question<PostBookingModel> {

    private final String firstname;
    private final String lastname;
    private final Integer totalprice;
    private final String depositpaid;
    private final String additionalneeds;

    public BuildBooking(String firstname, String lastname, Integer totalprice, String depositpaid, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
    }

    @Override
    public PostBookingModel answeredBy(Actor actor) {



        BookingDate bookingDate = BookingDate.builder()
                .checkin("2023-01-01")
                .checkout("2024-01-01")
                .build();

        PostBookingModel bookingModel = PostBookingModel.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(totalprice)
                .depositpaid(depositpaid)
                .bookingdate(bookingDate)
                .additionalneeds(additionalneeds)
                .build();

        return bookingModel;
    }

    public static BuildBooking was(String firstname, String lastname, Integer totalprice, String depositpaid, String additionalneeds) {
        return new BuildBooking(firstname, lastname, totalprice, depositpaid, additionalneeds);
    }
}
