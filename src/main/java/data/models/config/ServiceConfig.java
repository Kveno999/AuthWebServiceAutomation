package data.models.config;

import lombok.Data;

@Data
public class ServiceConfig {

    private WebsiteConfig website;
    private BrowserConfig browser;

}
