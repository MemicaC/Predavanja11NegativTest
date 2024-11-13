package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    private WebElement loggedInUserElement;


    @BeforeTest
    public void setUp() {
        //driver = new ChromeDriver();
        System.out.println("Before test");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("Before class");
    }


    @Test()
    public void test1() {

        System.out.println("Test banner text");
        String expectedText = "Your username is invalid!";
        loggedInUserElement = driver.findElement(By.cssSelector(".flash.error"));
        String actualText = loggedInUserElement.getText();


        String[] actualRegexArray = loggedInUserElement.getText().split("(?<=!)");

        String actualRegexText = actualRegexArray[0];
        softAssert.assertEquals(actualRegexText.trim(), expectedText, "Failed");
        softAssert.assertAll();

    }

    @Test()
    public void test2() {
        System.out.println("Test banner background color");
        String expectedColor = "rgba(198, 15, 19, 1)";
        String actualColor = loggedInUserElement.getCssValue("background-color");
        softAssert.assertEquals(actualColor, expectedColor, "Failed");
        softAssert.assertAll();
    }


    @Test()
    public void test3() {
        System.out.println("Test login page title");
        String expectedTitle = "Login Page";
        loggedInUserElement = driver.findElement(By.xpath("//h2[text()='Login Page']"));
        String actualTitle = loggedInUserElement.getText();
        softAssert.assertEquals(actualTitle.trim(), expectedTitle, "Failed");


        softAssert.assertAll();
    }


    }

