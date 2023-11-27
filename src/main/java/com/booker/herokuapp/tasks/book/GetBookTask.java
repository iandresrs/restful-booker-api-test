package com.booker.herokuapp.tasks.book;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/booking/1242")
        );
    }

    public static GetBookTask get(){
        return instrumented(GetBookTask.class);
    }
}
