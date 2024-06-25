package base.locators;

import org.openqa.selenium.By;

public class IdFinder extends FindStrategy {
    public IdFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.id(getValue());
    }
}
