package com.booker.herokuapp.models.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDate {

    @JsonProperty("checkin")
    public String checkin;

    @JsonProperty("checkout")
    public String checkout;
}
