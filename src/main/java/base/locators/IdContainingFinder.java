package base.locators;

import org.openqa.selenium.By;

public class IdContainingFinder extends FindStrategy {
    public IdContainingFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.cssSelector(String.format("[id*='%s']", getValue()));
    }
}