package data.models.config;

import base.Browser;
import lombok.Data;

@Data
public class BrowserConfig {
    private boolean startMaximized;
    private Browser clientBrowser;
}
