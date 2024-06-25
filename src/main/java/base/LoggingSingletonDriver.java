package base;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingSingletonDriver extends DriverDecorator {
    private static LoggingSingletonDriver instance;

    public LoggingSingletonDriver(Driver driver) {
        super(driver);
    }

    public static LoggingSingletonDriver getInstance() {
        if (instance == null) {
            instance = new LoggingSingletonDriver(new WebCoreDriver());
        }

        return instance;
    }

    @Override
    public void start(Browser browser) {
        log.info(String.format("Starting browser:: %s", browser.name()));
        driver.start(browser);
    }

    @Override
    public void shutDown() {
        log.info("Closing browser");
        driver.shutDown();
    }

    @Override
    public void visit(String url) {
        log.info(String.format("Visiting:: %s", url));
        driver.visit(url);
    }
}
