package pages.forms;

import base.Element;
import base.services.ElementFindService;
import base.services.ElementWaitService;
import base.waits.Wait;
import io.qameta.allure.Step;

public class ErrorForm {

    private final ElementFindService elementFindService;

    private final ElementWaitService elementWaitService;

    public ErrorForm(ElementFindService elementFindService, ElementWaitService elementWaitService) {
        this.elementFindService = elementFindService;
        this.elementWaitService = elementWaitService;
    }

    private Element errorMessage() {
        return elementFindService.findById("growlText");
    }

    @Step("Getting Error Message")
    public String getErrorMessage() {
        elementWaitService.wait(errorMessage(), Wait.to().beVisible());
        return errorMessage().getText();
    }

}
