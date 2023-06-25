package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class VerifyThat {

    public static VerifyThatBuilder theResultAt (Target xpath) {
        return new VerifyThatBuilder(xpath);
    }

    public static class VerifyThatBuilder {
        private Target xpath;
        private String term;

        public VerifyThatBuilder(Target target) {
            this.xpath = target;
        }

        public Performable looksLike(String term) {
            this.term = term;

            return Task.where("{0} verifies that " + term + " exists", actor -> {
                Target xpathModelWithText = xpath.of(term);
                String actualValue = xpathModelWithText.resolveFor(actor).getText();

                actor.attemptsTo(
                    WaitUntil.the(xpathModelWithText, isCurrentlyVisible()),
                    Ensure.that(term).isEqualToIgnoringCase(actualValue)
                );
            });
        }
    }
}