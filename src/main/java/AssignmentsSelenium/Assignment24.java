package AssignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment24 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/frames");

        String mainwindow = driver.getWindowHandle();

        WebElement  frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);
        // Find the element using XPath

        WebElement sampleHeading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));

        //Print frame element text
        System.out.println(sampleHeading.getText());

        //go back to main window
        driver.switchTo().window(mainwindow);
    }
}
