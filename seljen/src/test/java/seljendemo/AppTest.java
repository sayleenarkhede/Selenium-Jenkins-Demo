package seljendemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppTest {

    @Test
    public void loginTest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username"))
              .sendKeys("tomsmith");

        driver.findElement(By.id("password"))
              .sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']"))
              .click();

        String message = driver.findElement(By.id("flash"))
                             .getText();

        assertEquals(true, message.contains("You logged into a secure area!"));

        driver.quit();
    }
}
