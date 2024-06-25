package tests;

import data.enums.GeorgianLanguage;
import data.enums.Language;
import factories.CustomerFactory;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorizationpage.AuthorizationPage;
import testbase.BaseTest;
import teststeps.LanguageProviderSteps;
import teststeps.WrongCredentialsTranslatorSteps;

@Test
@Log4j2
@Feature("Authentication Feature")
public class AuthenticationTests extends BaseTest {

    @Test(dataProvider = "LanguageProvider", dataProviderClass = LanguageProviderSteps.class)
    public void testCustomerShouldNotBeAuthenticatedIfCredentialsAreIncorrect(Language language) {
        log.info("Test:: Customer should not be authenticated with wrong credentials");
        var authorizationPage = service.visit(AuthorizationPage.class, language);

        var customer = CustomerFactory.buildRandomCustomer();
        authorizationPage.authorizationForm()
                .authorize(customer);

        var actualErrorMessage = authorizationPage.errorForm().getErrorMessage();
        var exceptedErrorMessage = WrongCredentialsTranslatorSteps.
                getErrorMessageByLanguage((GeorgianLanguage) language);

        Assert.assertEquals(actualErrorMessage, exceptedErrorMessage);
    }

    @Test(dataProvider = "LanguageProvider", dataProviderClass = LanguageProviderSteps.class)
    public void testUsernameShouldNotBeFilledWithNonEnglishCharacters(Language language) {
        log.info("Test:: Username should not filled with non english characters");
        var authorizationPage = service.visit(AuthorizationPage.class, language);

        var customer = CustomerFactory.buildRandomCustomerWithGeorgianCredentials();
        var username = customer.getUsername();
        authorizationPage.authorizationForm()
                .fillUsername(username);

        var actualUsername = authorizationPage.authorizationForm().getUsername();
        Assert.assertTrue(actualUsername.isEmpty(),
                String.format("Username input is filled with entered characters:: %s", username));
    }

    @Test(dataProvider = "LanguageProvider", dataProviderClass = LanguageProviderSteps.class)
    public void testLoginButtonShouldNotBeEnabledIfUsernameIsNotFilled(Language language) {
        log.info("Test:: Login button should not be enabled if username is not filled");
        var authorizationPage = service.visit(AuthorizationPage.class, language);

        var customer = CustomerFactory.buildRandomCustomerWithGeorgianCredentials();
        var password = customer.getPassword();
        authorizationPage.authorizationForm()
                .fillPassword(password);

        var isSubmitButtonEnabled = authorizationPage.authorizationForm().isSubmitButtonEnabled();
        Assert.assertFalse(isSubmitButtonEnabled,
                String.format("Submit button is enabled:: %s", isSubmitButtonEnabled));
    }

    @Test(dataProvider = "LanguageProvider", dataProviderClass = LanguageProviderSteps.class)
    public void testLoginButtonShouldNotBeEnabledIfPasswordIsNotFilled(Language language) {
        log.info("Test:: Login button should not be enabled if password is not filled");
        var authorizationPage = service.visit(AuthorizationPage.class, language);

        var customer = CustomerFactory.buildRandomCustomerWithGeorgianCredentials();
        var username = customer.getUsername();
        authorizationPage.authorizationForm()
                .fillUsername(username);

        var isSubmitButtonEnabled = authorizationPage.authorizationForm().isSubmitButtonEnabled();
        Assert.assertFalse(isSubmitButtonEnabled,
                String.format("Submit button is enabled:: %s", isSubmitButtonEnabled));
    }

}
