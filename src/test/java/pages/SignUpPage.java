package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;

    private By ontheMainPage = By.xpath("(//a[normalize-space()='PRODUCT STORE'])[1]");
    private By signUpMenu = By.id("signin2");
    private By inputUsername = By.id("sign-username");
    private By inputPassword = By.id("sign-password");
    private By signUpButton = By.xpath("//button[text()='Sign up']");
    private By loginMenu = By.id("login2");
    private  By usernameLogin = By.id("loginusername");
    private By passwordLogin = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By logoutButton = By.id("logout2");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage(){
        driver.findElement(ontheMainPage);
        //System.out.println("Main page opened");
    }

    public void userClickMenu(String nameButton){
        switch (nameButton){
            case "Sign Up":
                driver.findElement(signUpMenu).click();
                //System.out.println("Clicked on Sign up menu");
                break;
            case "Login":
                driver.findElement(loginMenu).click();
                break;
            default:
                System.out.println("Invalid menu clicked");
                break;
        }
    }
    public void enterUserName(String userName){
        driver.findElement(inputUsername).sendKeys(userName);
        //System.out.println(userName);
    }
    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
        //System.out.println(password);
    }
    public void clickOnSignIn(String buttonType){
        switch (buttonType) {
            case "Sign Up":
                driver.findElement(signUpButton).click();
                break;
            case "Login":
                driver.findElement(loginButton).click();
                break;
            default:
                System.out.println("Invalid button clicked");
        }

    }
    public void messagePromp(String messageExpected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        Assert.assertEquals("Expected message: " + messageExpected + ", but got: " + actualMessage, messageExpected, actualMessage);
        //System.out.println(actualMessage);
    }
    public void loginUser(String username, String password){
        driver.findElement(usernameLogin).sendKeys(username);
        driver.findElement(passwordLogin).sendKeys(password);
    }

    public void inHomePage(){
        driver.findElement(logoutButton);
    }
}
