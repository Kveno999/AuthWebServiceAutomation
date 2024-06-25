package teststeps;

import data.enums.GeorgianLanguage;
import org.testng.annotations.DataProvider;

public class LanguageProviderSteps {

    @DataProvider(name = "LanguageProvider")
    public static Object[][] provideLanguages() {
        return new Object[][]{
                {GeorgianLanguage.KA},
                {GeorgianLanguage.SVAN},
                {GeorgianLanguage.MINT}
        };
    }

}
