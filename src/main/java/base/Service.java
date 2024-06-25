package base;

import base.services.BrowserService;
import base.services.CookiesService;
import base.services.DialogService;
import base.services.NavigationService;
import data.enums.Language;
import data.scripts.JavascriptScripts;
import pages.BasePage;
import pages.CredoWebsite;
import pages.authorizationpage.AuthorizationPage;
import utils.YamlSerializerUtils;

import java.util.Objects;

public class Service implements AutoCloseable {
    private Boolean disposed = false;

    public Service() {
        var config = new ConfigParser().deserialize();
        var browser = config.getBrowser().getClientBrowser();
        LoggingSingletonDriver.getInstance().start(browser);
    }

    public NavigationService getNavigationService() {
        return SingletonFactory.getInstance(NavigationService.class);
    }

    public BrowserService getBrowserService() {
        return SingletonFactory.getInstance(BrowserService.class);
    }

    public CookiesService getCookiesService() {
        return SingletonFactory.getInstance(CookiesService.class);
    }

    public DialogService getDialogService() {
        return SingletonFactory.getInstance(DialogService.class);
    }

    public <TPage extends BasePage> TPage visit(Class<TPage> pageOf) {
        var page = SingletonFactory.getInstance(pageOf, LoggingSingletonDriver.getInstance());
        Objects.requireNonNull(page).open();

        return page;
    }

    public <TPage extends AuthorizationPage> TPage visit(Class<TPage> pageOf, Language language) {
        var page = SingletonFactory.getInstance(pageOf, LoggingSingletonDriver.getInstance());
        Objects.requireNonNull(page).open();
        page.browserService.executeJs(String.format(JavascriptScripts.SET_LANGUAGE, language.getValue()));
        page.browserService.refresh();
        return page;
    }

    public <TPage extends CredoWebsite> TPage create(Class<TPage> pageOf) {
        return SingletonFactory.getInstance(pageOf, LoggingSingletonDriver.getInstance());
    }

    @Override
    public void close() {
        if (disposed) {
            return;
        }
        LoggingSingletonDriver.getInstance().shutDown();

        disposed = true;
    }
}
