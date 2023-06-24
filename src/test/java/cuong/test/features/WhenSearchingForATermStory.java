package cuong.test.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tasks.*;
import ui.EntryPage;


@RunWith(SerenityRunner.class)
@WithTag("color:blue")
public class WhenSearchingForATermStory {

    @Managed
    WebDriver driver;

    @Steps
    NavigateTo navigateTo;

    Actor bisllly = Actor.named("bisllly")
            .whoCan(BrowseTheWeb.with(driver));

    @Before
    public void setup() {
        bisllly.attemptsTo(
            NavigateTo.url("https://www.oxfordlearnersdictionaries.com/")
        );
    }

    @Test
    public void should_search_for_a_term() {
        bisllly.attemptsTo(
                SearchFor.theTerm("brew"),
                VerifyThat.theResultAt(EntryPage.XPATH_MODEL_FOR_LOCATING_THE_TERM)
                        .looksLike("brew")
                        .execute()
        );
    }
}
