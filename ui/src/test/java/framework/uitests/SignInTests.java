package framework.uitests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.framework.StringUtils.generateRandomString;

public class SignInTests extends BaseTestClass {

    @Test
    void invalidLoginFailsToSignIn(){

        driver.get(BASE_URL + "login");

        // enter credentials and click "Sign in"
        driver.findElement(By.id("login_field")).sendKeys("somelogin");
        driver.findElement(By.id("password")).sendKeys(generateRandomString(5));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        boolean isErrorDisplayed = driver.findElement(By.className("flash-error")).isDisplayed();

        assertTrue(isErrorDisplayed);
    }
}
