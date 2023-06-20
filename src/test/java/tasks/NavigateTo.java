package tasks;

import jdk.internal.org.jline.utils.ShutdownHooks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.pages.PageObject;

public class NavigateTo implements Task {

    public static Performable url(String url) {
        return Task.where("navigate to the specified url", actor -> {
           actor.attemptsTo(
                   Open.url(url)
           );
        });
    }

    @Override
    public <T extends Actor> void performAs(T t) {}
}
