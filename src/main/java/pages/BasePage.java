package pages;

import base.services.ElementFindService;
import base.services.NavigationService;
import io.qameta.allure.Step;

public abstract class BasePage extends CredoWebsite {
    protected final NavigationService navigationService;

    public BasePage(ElementFindService elementFindService, NavigationService navigationService) {
        super(elementFindService);
        this.navigationService = navigationService;
    }

    protected abstract String getUrl();

    @Step("Opening website")
    public void open() {
        navigationService.visit(getUrl());
        waitForPageLoad();
    }

    protected abstract void waitForPageLoad();
}
