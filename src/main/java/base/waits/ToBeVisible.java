package base.waits;

import org.openqa.selenium.*;

public class ToBeVisible extends WaitStrategy {
    public ToBeVisible(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
        super(timeoutIntervalSeconds, sleepIntervalSeconds);
    }

    @Override
    public void waitUntil(SearchContext searchContext, WebDriver driver, By by) {
        waitUntil((x) -> elementIsVisible(searchContext, by), driver);
    }

    private Boolean elementIsVisible(SearchContext searchContext, By by) {
        var element = findElement(searchContext, by);
        try {
            return element != null && element.isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }
}
