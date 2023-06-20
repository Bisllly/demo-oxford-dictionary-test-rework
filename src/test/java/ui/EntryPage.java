package ui;

import net.serenitybdd.screenplay.targets.Target;

public class EntryPage {
    public static final Target XPATH_MODEL_FOR_LOCATING_THE_TERM = Target.the("xpath model")
            .locatedBy("//div[@class='webtop']//h1[text()='{0}']");
}
