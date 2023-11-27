package com.booker.herokuapp.questions.book;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseServerCode implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getStatusCode();
    }

    public static Question was(){
        return new ResponseServerCode();
    }
}
