package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class OrderPage {
    private WebDriver driver;

    private By loginMenu = By.id("login2");
    private By usernameLogin = org.openqa.selenium.By.id("loginusername");
    private By passwordLogin = org.openqa.selenium.By.id("loginpassword");
    private By loginButton = org.openqa.selenium.By.xpath("//button[text()='Log in']");
    private By item = org.openqa.selenium.By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    private By loginModal = org.openqa.selenium.By.id("logInModalLabel");
    private By addCartButton = org.openqa.selenium.By.xpath("//a[text()='Add to cart']");
    private By cartMenu = org.openqa.selenium.By.id("cartur");
    private By orderButton = org.openqa.selenium.By.xpath("//button[text()='Place Order']");
    private By name = org.openqa.selenium.By.id("name");
    private By country = org.openqa.selenium.By.id("country");
    private By city = org.openqa.selenium.By.id("city");
    private By card = org.openqa.selenium.By.id("card");
    private By month = org.openqa.selenium.By.id("month");
    private By year = org.openqa.selenium.By.id("year");
    private By purchaseButton = org.openqa.selenium.By.xpath("//button[text()='Purchase']");
    //private By deleteButton = org.openqa.selenium.By.xpath("//button[text()='Delete']");
    private By messageSuccess = org.openqa.selenium.By.xpath("//h2[text()='Thank you for your purchase!']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        System.out.println(driver.getCurrentUrl());
    }

    public void login(String username, String password) {
        driver.findElement(loginMenu).click();
        driver.findElement(usernameLogin).sendKeys(username);
        driver.findElement(passwordLogin).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clicksItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginModal));
        driver.findElement(item).click();

    }

    public void addtoCart(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        switch (buttonName) {
            case "Add to cart":
                wait.until(ExpectedConditions.visibilityOfElementLocated(addCartButton));
                driver.findElement(addCartButton).click();
                break;
            case "Place Order":
                wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
                driver.findElement(orderButton).click();
                break;
            case "Purchase":
                wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseButton));
                driver.findElement(purchaseButton).click();
                break;
            default:
                System.out.println("nothing to do");

        }


    }

    public void messageCart(String messageExpected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        Assert.assertEquals("Expected message: " + messageExpected + ", but got: " + actualMessage, messageExpected, actualMessage);
        alert.accept();
        //System.out.println(actualMessage);
    }

    public void cartMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginModal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartMenu));
        driver.findElement(cartMenu).click();
    }

    public void fillOrderForm(Map<String, String> formData) {
        System.out.println(formData);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        if (formData.get("name") != null && !formData.get("name").isEmpty()) {
            driver.findElement(name).sendKeys(formData.get("name"));
        }
        if (formData.get("country") != null && !formData.get("country").isEmpty()) {
            driver.findElement(country).sendKeys(formData.get("country"));
        }
        if (formData.get("city") != null && !formData.get("city").isEmpty()) {
            driver.findElement(city).sendKeys(formData.get("city"));
        }
        if (formData.get("credit card") != null && !formData.get("credit card").isEmpty()) {
            driver.findElement(card).sendKeys(formData.get("credit card"));
        }
        if (formData.get("month") != null && !formData.get("month").isEmpty()) {
            driver.findElement(month).sendKeys(formData.get("month"));
        }
        if (formData.get("year") != null && !formData.get("year").isEmpty()) {
            driver.findElement(year).sendKeys(formData.get("year"));
        }
    }
    public void orderSucces(){
        driver.findElement(messageSuccess).isDisplayed();
        System.out.println(messageSuccess);
    }

}
