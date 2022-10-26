package framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstUITestRefactored {


    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        // Create the driver object
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        // Act
        String repo = "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        waitForTitle(driver, repo);
        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + "andrejs-ps/" + repo, actualUrl);
    }

    // Fixes a potential race condition if the next page doesn't load before "getCurrentUrl()" is invoked
    private static void waitForTitle(WebDriver driver, String title) {
        // ideally, this should be in a global config, not in a method
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));

        // assuming that if the HTML title becomes visible, so is the URL of the page
        // throws if condition is not met
        wait.until(ExpectedConditions.titleContains(title));
    }

    @Test
    void repositoryCountIsCorrect() {
        // Act
        driver.get(BASE_URL + "andrejs-ps/" + "?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        // expected number of repos will change over time
        assertEquals(7, repos.size());
    }
}
