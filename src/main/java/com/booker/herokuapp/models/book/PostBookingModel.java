package com.booker.herokuapp.models.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostBookingModel {

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;

    @JsonProperty("totalprice")
    public Integer totalprice;

    @JsonProperty("depositpaid")
    public String depositpaid;

    @JsonProperty("bookingdates")
    public BookingDate bookingdate;

    @JsonProperty("additionalneeds")
    public String additionalneeds;

}
