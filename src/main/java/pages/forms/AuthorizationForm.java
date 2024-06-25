package pages.forms;

import base.Element;
import base.services.ElementFindService;
import data.consts.Attributes;
import data.models.core.Customer;
import io.qameta.allure.Step;

public class AuthorizationForm {

    private final ElementFindService elementFindService;

    public AuthorizationForm(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    private Element username() {
        return elementFindService.findById("userName");
    }

    private Element password() {
        return elementFindService.findById("newPass");
    }

    private Element submit() {
        return elementFindService.findById("submitAuth");
    }


    @Step("Authorizing User")
    public void authorize(Customer customer) {
        username().send(customer.getUsername());
        password().send(customer.getPassword());
        submit().click();
    }

    @Step("Filling Username")
    public void fillUsername(String username) {
        username().send(username);
    }

    @Step("Filling Password")
    public void fillPassword(String password) {
        password().send(password);
    }

    @Step("Getting Username")
    public String getUsername() {
        return username().getAttribute(Attributes.VALUE);
    }

    @Step("Checking if submit btn is enabled")
    public boolean isSubmitButtonEnabled() {
        return submit().isEnabled();
    }
}
