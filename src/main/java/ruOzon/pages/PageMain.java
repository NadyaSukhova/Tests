package ruOzon.pages;

import ruOzon.util.SupportTestSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PageMain {

    WebDriver driver;
    WebDriverWait webDriverWait;

    private static final String CityButton = "//*[@id=\"__ozon\"]/div/div[1]/div[1]/div/button";
    private static final String LoginButton = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/button";
    private static final String NumberInput = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input";
    private static final String ConfButton = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[3]/button";
    private static final String CodeInput = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input";
    private static final String Code = "6379";
    private static final String Number = "9270576621";

    private static final String CITY = "Вольск";
    private static final String CITY_FULL = "Вольск, Саратовская область";

    private WebElement cityElement;

    public PageMain(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @Step("Click city button")
    public void clickCity() {
        WebElement element = driver.findElement(By.xpath(CityButton));
        element.click();
    }

    @Step("Change the city")
    public void changeCity() {
        WebElement element = driver.findElement(By.className("ui-au3"));
        element.sendKeys("Вольск");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
        }
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.ENTER);
    }

    @Step("Login")
    public void loginIn() {
        WebElement element = driver.findElement(By.xpath(LoginButton));
        element.click();
    }

    @Step("Input the number")
    public void inNumber() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NumberInput)));
        WebElement element = driver.findElement(By.xpath(NumberInput));
        element.sendKeys(Number);
    }

    @Step("Click the button of the confirmation")
    public void clickNumber() {
        WebElement element = driver.findElement(By.xpath(ConfButton));
        element.click();
    }

    @Step("Input the code")
    public void inCode() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CodeInput)));
        WebElement element = driver.findElement(By.xpath(CodeInput));
        element.sendKeys(Code);
    }

    @Step("Check the city")
    public void checkCity() {
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(CityButton), CITY));
        WebElement element = driver.findElement(By.xpath(CityButton));
        assertEquals(element.getText(), CITY);
    }


}