package base;

import base.locators.FindStrategy;
import org.openqa.selenium.By;

import java.util.List;

public class ElementDecorator extends Element {
    protected final Element element;

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void send(String text) {
        element.send(text);
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    @Override
    public void waitToExists() {
        element.waitToExists();
    }

    @Override
    public Element findById(String id) {
        return element.findById(id);
    }

    @Override
    public Element findByXPath(String xpath) {
        return element.findByXPath(xpath);
    }

    @Override
    public Element findByTag(String tag) {
        return element.findByTag(tag);
    }

    @Override
    public Element findByClass(String cssClass) {
        return element.findByClass(cssClass);
    }

    @Override
    public Element findByCss(String css) {
        return element.findByCss(css);
    }

    @Override
    public Element findByLinkText(String linkText) {
        return element.findByLinkText(linkText);
    }

    @Override
    public List<Element> findAllById(String id) {
        return element.findAllById(id);
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return element.findAllByXPath(xpath);
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return element.findAllByTag(tag);
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return element.findAllByClass(cssClass);
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return element.findAllByCss(css);
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return element.findAllByLinkText(linkText);
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        return element.findAll(findStrategy);
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        return element.find(findStrategy);
    }
}
