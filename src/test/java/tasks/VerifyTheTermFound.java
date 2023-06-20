package tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class VerifyTheTermFound implements Task {
    public static Performable byXpath (String text, Target xpathModelWithoutText) {
        return Task.where("ensure that " + text + " has appeared", actor -> {
            Target xpathModelWithText = xpathModelWithoutText.of(text);
            WaitUntil.the(xpathModelWithText, isCurrentlyVisible());
            String actualValue = xpathModelWithText.resolveFor(actor).getText();
            Ensure.that(text).isEqualToIgnoringCase(actualValue);
        });
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }
}
