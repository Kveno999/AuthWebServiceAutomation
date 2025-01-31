package base.waits;

import org.openqa.selenium.*;

public class ToBeClickable extends WaitStrategy {
    public ToBeClickable(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
        super(timeoutIntervalSeconds, sleepIntervalSeconds);
    }

    @Override
    public void waitUntil(SearchContext searchContext, WebDriver driver, By by) {
        waitUntil((x) -> elementIsClickable(searchContext, by), driver);
    }

    private Boolean elementIsClickable(SearchContext searchContext, By by) {
        var element = findElement(searchContext, by);
        try {
            return element != null && element.isEnabled();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }
}
