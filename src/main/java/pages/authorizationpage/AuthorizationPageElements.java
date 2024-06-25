package pages.authorizationpage;

import base.Element;
import base.services.ElementFindService;

public class AuthorizationPageElements {
    private final ElementFindService elementFindService;

    public AuthorizationPageElements(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    public Element loginButton() {
        return elementFindService.findById("submitAuth");
    }

}
