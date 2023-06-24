package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import ui.DictionaryHomePage;

public class SearchFor {
    public static Performable theTerm (String term) {
        return Task.where("{0} search for " + term, actor -> actor.attemptsTo(
                Enter.theValue(term).into(DictionaryHomePage.SEARCH_BAR),
                SendKeys.of(Keys.ENTER).into(DictionaryHomePage.SEARCH_BAR),
                Pause.forNumOfSeconds(5)
        ));
    }
}
