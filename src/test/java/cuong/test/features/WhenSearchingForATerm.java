package cuong.test.features;

import io.appium.java_client.android.nativekey.PressesKey;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;
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
import tasks.VerifyTheTermFound;
import ui.DictionaryHomePage;
import ui.EntryPage;

@RunWith(SerenityRunner.class)
@WithTag("color:blue")
public class WhenSearchingForATerm {

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
                Enter.theValue("brew").into(DictionaryHomePage.SEARCH_BAR),
                SendKeys.of(Keys.ENTER).into(DictionaryHomePage.SEARCH_BAR),
                Pause.forNumOfSeconds(5),
                VerifyTheTermFound.byXpath("brew", EntryPage.XPATH_MODEL_FOR_LOCATING_THE_TERM)
        );
    }
}
