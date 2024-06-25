package base;

import base.locators.*;
import base.waits.WaitStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebCoreDriver extends Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Override
    public void start(Browser browser) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        var configParser = new ConfigParser();
        var serviceConfig = configParser.deserialize();
        var startMaximized = serviceConfig.getBrowser().isStartMaximized();
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                if (startMaximized)
                    options.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
            case SAFARI -> webDriver = new SafariDriver();
            case INTERNET_EXPLORER -> {
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
            }
            default -> throw new IllegalArgumentException(browser.name());
        }

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Override
    public void shutDown() {
        webDriver.quit();
    }

    @Override
    public void visit(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> (Boolean) javascriptExecutor.executeScript("return window.jQuery !== undefined && jQuery.active === 0"));
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }

    @Override
    public void executeJs(String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript(script);
    }

    @Override
    public void refresh() {
        webDriver.navigate().refresh();
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
        List<WebElement> nativeWebElements =
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findStrategy.convert()));
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
        var nativeWebElement =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(findStrategy.convert()));
        Element element = new WebCoreElement(webDriver, nativeWebElement, findStrategy.convert());

        return new LogElement(element);
    }

    @Override
    public void wait(Element element, WaitStrategy waitStrategy) {
        waitStrategy.waitUntil(webDriver, webDriver, element.getBy());
    }
}
