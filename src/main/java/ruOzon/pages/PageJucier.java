package ruOzon.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ruOzon.util.SupportTestSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageJucier{

    WebDriver driver;
    WebDriverWait webDriverWait;

    private static final String Tech = "//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[1]/div/a[12]/span";
    private static final String Catalog = "//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[2]/div/div[1]/button";
    private static final String Juice = "//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[6]/span";
    private static final String Min =  "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input";
    private static final String Power = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[9]/div[2]/div[2]/div[1]/input";
    private static final String Max = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input";
    private static final By dotsLocator = By.cssSelector("[class=\"dots dots-blue\"]");
    private static final String Cost = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span";
    private static final String OneJuicer = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[2]/div/div/button";
    private static final String OurJuicer ="//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[1]";
    private static final String ClickBut = "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[3]/div[2]/div/div/div/div/div[2]/div/div/div/div/div[5]/div/div/div/div/div/div[2]/button";
    private static final String Court = "[data-widget=\"cart\"]";
    private static final String Cookie = "//*[@id=\"__ozon\"]/div/div[3]/div/button";


    public PageJucier(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @Step("Click catalog button")
    public void clickCatalog() {
        WebElement element = driver.findElement(By.xpath(Catalog));
        element.click();
    }

    @Step("Click to show tech")
    public void clickTech() {
        WebElement element = driver.findElement(By.xpath(Tech));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }


    @Step("Click to show Juice")
    public void clickJuicer() {
        closeCookie();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Juice)));
        WebElement element = driver.findElement(By.xpath(Juice));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }


    @Step("Writes min cost")
    public void minCost() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        closeCookie();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Min)));
        WebElement element = driver.findElement(By.xpath(Min));

        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys("3000");
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(dotsLocator));
        }
        catch(NoSuchElementException e) {}
        element.sendKeys(Keys.ENTER);
    }

    @Step("Writes max cost")
    public void maxCost() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Max)));
        WebElement element = driver.findElement(By.xpath(Max));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys("4000");
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(dotsLocator));
        }
        catch(NoSuchElementException e) {}
        element.sendKeys(Keys.ENTER);
    }

    @Step("Chooses the cheapest")
    public void chooseCheap() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role=\"combobox\"]")));
        WebElement element = driver.findElement(By.cssSelector("[role=\"combobox\"]"));
        element.click();
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);

    }


    @Step("Checks the cost")
    public void checkCost() {
        closeCookie();
        WebElement element = driver.findElement(By.xpath(Cost));
        assertEquals(element.getText(), "Цена: от 3 000 до 4 000");
    }

    @Step("+1 jucier")
    public void oneJuicier() {
        closeCookie();
        WebElement element = driver.findElement(By.xpath(OneJuicer));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }

    @Step("Show our jucier")
    public void goTo() {
        closeCookie();
        WebElement element = driver.findElement(By.xpath(OurJuicer));
        element.click();
    }


    @Step("Show our jucier")
    public void clickBut() {
        closeCookie();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 8);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClickBut)));
        WebElement element = driver.findElement(By.xpath(ClickBut));
        try {
            element.click();
            element.click();
            element.click();
            element.click();
        }
        catch(NoSuchElementException e) {}
    }

    @Step("Show our jucier")
    public void court() {
        WebElement element = driver.findElement(By.cssSelector(Court));
        element.click();

    }


    private void closeCookie() {
        try {
            WebElement element = driver.findElement(By.xpath(Cookie));
            element.click();
        }
        catch(Exception e) {}
    }


}