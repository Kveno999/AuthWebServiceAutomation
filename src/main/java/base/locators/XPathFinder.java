package base.locators;

import org.openqa.selenium.By;

public class XPathFinder extends FindStrategy {
    public XPathFinder(String value) {
        super(value);
    }

    @Override
    public By convert() {
        return By.xpath(getValue());
    }

    @Override
    public String toString() {
        return String.format("xpath = %s", getValue());
    }
}
