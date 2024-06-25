package base.locators;

import org.openqa.selenium.By;

public class TagFinder extends FindStrategy {
    public TagFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.tagName(getValue());
    }
}
