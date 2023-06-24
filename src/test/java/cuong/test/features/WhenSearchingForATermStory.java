package cuong.test.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tasks.NavigateTo;
import tasks.Pause;
import tasks.SearchFor;
import tasks.VerifyTheTermFound;
import ui.DictionaryHomePage;
import ui.EntryPage;

@RunWith(SerenityRunner.class)
@WithTag("color:blue")
public class WhenSearchingForATermStory {

    @Managed
    WebDriver driver;

    @Steps
    NavigateTo navigateTo;

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Bisllly").can(BrowseTheWeb.with(driver));
    }

    @Test
    public void should_search_for_a_term() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateTo.url("https://www.oxfordlearnersdictionaries.com/"),
                SearchFor.theTerm("brew"),
                VerifyTheTermFound.byXpath("brew", EntryPage.XPATH_MODEL_FOR_LOCATING_THE_TERM)
        );
    }
}
