package pages;

import base.services.ElementFindService;

public abstract class CredoWebsite {
    protected final ElementFindService elementFindService;

    public CredoWebsite(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

}
