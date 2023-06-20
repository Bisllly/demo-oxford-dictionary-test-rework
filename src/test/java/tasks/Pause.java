package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Pause implements Task {

    public static Performable forNumOfSeconds (int seconds) {
        return Task.where("Pause for " + seconds + " seconds", actor -> {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public <T extends Actor> void performAs(T t) {}
}
