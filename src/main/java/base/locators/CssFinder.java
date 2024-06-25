package base.locators;

import org.openqa.selenium.By;

public class CssFinder extends FindStrategy {
    public CssFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.cssSelector(getValue());
    }
}
