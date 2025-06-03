package AssignmentsSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Assignment23 {
    //main method to run the test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/alerts");


        // locate alert button and click
        WebElement alertOk = driver.findElement(By.xpath("//button[@id='alertButton']"));
        viewelement(alertOk,driver);
        alertOk.click();
        Alert ac = driver.switchTo().alert();
        ac.accept();

        //locate confirm accept button
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        viewelement(confirmButton,driver);
        confirmButton.click();
        ac.accept();


        confirmButton.click();
        ac.dismiss();

        //promt alert
        WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        viewelement(promptButton, driver);
        promptButton.click();
        ac.sendKeys("sivaji varma is here");
        ac.accept();
        //ac.dismiss();
        viewelement(promptButton, driver);
        promptButton.click();
        ac.dismiss();

        //timer alert
        WebElement timerButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        viewelement(timerButton, driver);
        timerButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ac.getText());
        ac.accept();
    }

    public static void viewelement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
