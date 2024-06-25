package pages.authorizationpage;

import base.ConfigParser;
import base.Driver;
import base.services.BrowserService;
import base.services.ElementWaitService;
import pages.BasePage;
import pages.forms.AuthorizationForm;
import pages.forms.ErrorForm;

public class AuthorizationPage extends BasePage {

    public final BrowserService browserService;
    private final ElementWaitService elementWaitService;

    public AuthorizationPage(Driver driver) {
        super(driver, driver);
        browserService = driver;
        elementWaitService = driver;
    }

    public AuthorizationForm authorizationForm() {
        return new AuthorizationForm(elementFindService);
    }

    public ErrorForm errorForm() {
        return new ErrorForm(elementFindService, elementWaitService);
    }

    @Override
    protected String getUrl() {
        var serviceConfig = new ConfigParser().deserialize();
        return serviceConfig.getWebsite().getUrl();
    }

    @Override
    protected void waitForPageLoad() {
        elements().loginButton().waitToExists();
    }

    private AuthorizationPageElements elements() {
        return new AuthorizationPageElements(elementFindService);
    }
}
