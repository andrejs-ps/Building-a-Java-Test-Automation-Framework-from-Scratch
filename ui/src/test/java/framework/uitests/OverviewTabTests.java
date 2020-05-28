package framework.uitests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabTests extends BaseTestClass {

    String user = "andrejs-ps";

    @BeforeEach
    void overviewTabSetup() {
        // open the browser at a specific URL - https://github.com/andrejs-ps
        driver.get(BASE_URL + user);
    }

    @AfterEach
    void localCleanup() {
        // nothing to do here now, but maybe in the future?
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {
        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();
        // Assert
        assertEquals(user, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        // Act
        String repo = "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + "andrejs-ps/" + repo, actualUrl);
    }
}
