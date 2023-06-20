package ui;

import net.serenitybdd.screenplay.targets.Target;

public class DictionaryHomePage {

    public static final Target SEARCH_BAR = Target.the("search bar")
            .locatedBy("//input[@placeholder=\"Search Oxford Advanced Learner's Dictionary\"]");
}
