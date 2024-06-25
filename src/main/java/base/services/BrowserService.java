package base.services;

import base.Browser;

public interface BrowserService {
    void start(Browser browser);

    void shutDown();

    void waitForAjax();

    void waitUntilPageLoadsCompletely();

    void executeJs(String script);

    void refresh();
}
