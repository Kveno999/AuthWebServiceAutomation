package base;

import base.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebCoreElement extends Element {
    private final WebDriver webDriver;
    private final WebElement webElement;
    private final By by;

    public WebCoreElement(WebDriver webDriver, WebElement webElement, By by) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public void send(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public void click() {
        waitToBeClickable(by);
        webElement.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    @Override
    public void waitToExists() {
        var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getBy()));
    }

    @Override
    public Element findById(String id) {
        return find(new IdFinder(id));
    }

    @Override
    public Element findByXPath(String xpath) {
        return find(new XPathFinder(xpath));
    }

    @Override
    public Element findByTag(String tag) {
        return find(new TagFinder(tag));
    }

    @Override
    public Element findByClass(String cssClass) {
        return find(new ClassFinder(cssClass));
    }

    @Override
    public Element findByCss(String css) {
        return find(new CssFinder(css));
    }

    @Override
    public Element findByLinkText(String linkText) {
        return find(new LinkTextFinder(linkText));
    }

    @Override
    public List<Element> findAllById(String id) {
        return findAll(new IdFinder(id));
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return findAll(new XPathFinder(xpath));
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return findAll(new TagFinder(tag));
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return findAll(new ClassFinder(cssClass));
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return findAll(new CssFinder(css));
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return findAll(new LinkTextFinder(linkText));
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        List<WebElement> nativeWebElements = webElement.findElements(findStrategy.convert());
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement : nativeWebElements) {
            Element element = new WebCoreElement(webDriver, nativeWebElement, findStrategy.convert());
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }

        return elements;
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        var nativeWebElement = webElement.findElement(findStrategy.convert());
        Element element = new WebCoreElement(webDriver, nativeWebElement, findStrategy.convert());

        return new LogElement(element);
    }

    private void waitToBeClickable(By by) {
        var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
