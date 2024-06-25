package base;

import base.locators.FindStrategy;
import base.waits.WaitStrategy;

import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start(Browser browser) {
        driver.start(browser);
    }

    @Override
    public void shutDown() {
        driver.shutDown();
    }

    @Override
    public void visit(String url) {
        driver.visit(url);
    }

    @Override
    public String getUrl() {
        return driver.getUrl();
    }

    @Override
    public void waitForAjax() {
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        driver.waitUntilPageLoadsCompletely();
    }

    @Override
    public void executeJs(String script) {
        driver.executeJs(script);
    }

    @Override
    public void refresh() {
        driver.refresh();
    }

    @Override
    public Element findById(String id) {
        return driver.findById(id);
    }

    @Override
    public Element findByXPath(String xpath) {
        return driver.findByXPath(xpath);
    }

    @Override
    public Element findByTag(String tag) {
        return driver.findByTag(tag);
    }

    @Override
    public Element findByClass(String cssClass) {
        return driver.findByClass(cssClass);
    }

    @Override
    public Element findByCss(String css) {
        return driver.findByCss(css);
    }

    @Override
    public Element findByLinkText(String linkText) {
        return driver.findByLinkText(linkText);
    }

    @Override
    public List<Element> findAllById(String id) {
        return driver.findAllById(id);
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return driver.findAllByXPath(xpath);
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return driver.findAllByTag(tag);
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return driver.findAllByClass(cssClass);
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return driver.findAllByCss(css);
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return driver.findAllByLinkText(linkText);
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        return driver.findAll(findStrategy);
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        return driver.find(findStrategy);
    }

    @Override
    public void wait(Element element, WaitStrategy waitStrategy) {
        driver.wait(element, waitStrategy);
    }
}