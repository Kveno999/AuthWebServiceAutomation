package base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LogElement extends ElementDecorator {

    protected LogElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        log.info(String.format("Getting Text From Element:: %s", element.getText()));
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        log.info(String.format("Checking if Element is Enabled:: %s", element.isEnabled()));
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        log.info(String.format("Checking if Element is Displayed:: %s", element.isDisplayed()));
        return element.isDisplayed();
    }

    @Override
    public void send(String text) {
        log.info(String.format("Filling with:: %s", text));
        element.send(text);
    }

    @Override
    public void click() {
        log.info("Element Clicked");
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        log.info(String.format("Getting Attribute:: %s", attributeName));
        return element.getAttribute(attributeName);
    }
}
