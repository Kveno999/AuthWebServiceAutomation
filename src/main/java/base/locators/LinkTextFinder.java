package base.locators;

import org.openqa.selenium.By;

public class LinkTextFinder extends FindStrategy {
    public LinkTextFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.linkText(getValue());
    }
}
