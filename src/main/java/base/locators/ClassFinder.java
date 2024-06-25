package base.locators;

import org.openqa.selenium.By;

public class ClassFinder extends FindStrategy {
    public ClassFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.xpath(String.format("//*[@class='%s']", getValue()));
    }
}
