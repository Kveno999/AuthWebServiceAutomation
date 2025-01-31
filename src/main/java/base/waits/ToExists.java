package base.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ToExists extends WaitStrategy {
    public ToExists(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
        super(timeoutIntervalSeconds, sleepIntervalSeconds);
    }

    @Override
    public void waitUntil(SearchContext searchContext, WebDriver driver, By by) {
        waitUntil((x) -> elementExists(searchContext, by), driver);
    }

    private Boolean elementExists(SearchContext searchContext, By by) {
        try {
            var element = findElement(searchContext, by);
            return element != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
