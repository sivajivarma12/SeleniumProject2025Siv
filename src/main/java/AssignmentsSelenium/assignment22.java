package AssignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class assignment22 {
    public static void main(String a[]){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/automation-practice-form");
       WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
                firstName.sendKeys("sivaji");

                WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
            lastName.sendKeys("Varma");
        //input[@id='userEmail']
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmail.sendKeys("sivajivarma12@gmail.com");

        WebElement radiobuttonfemale = driver.findElement(By.xpath("//input[@value='Female']"));
        Actions ac = new Actions(driver) ;
        ac.click(radiobuttonfemale).perform();
        WebElement userNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
        userNumber.sendKeys("9876543210");

        WebElement DOB =driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        ac.click(DOB).perform();
        Select monthdropdown = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        monthdropdown.selectByValue("1");
        Select yeardropdown = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        yeardropdown.selectByValue("1991");

        WebElement dateSelection = driver.findElement(By.xpath("//div[@aria-label='Choose Friday, February 1st, 1991']"));
        ac.click(dateSelection).click();

       WebElement subjectInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
       ac.sendKeys(subjectInput,"Ma").perform();

        WebElement SportSelection = driver.findElement(By.xpath("//label[text()='Sports']"));
        ac.click(SportSelection).perform();
        WebElement ReadingSelection = driver.findElement(By.xpath("//label[text()='Sports']"));
        ac.click(ReadingSelection).perform();
        //label[text()='Reading']
        WebElement uploadpic = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        ac.sendKeys(uploadpic,"C:\\Users\\windows\\Pictures\\Screenshots\\Screenshot (9).png").perform();

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        ac.click(submit).perform();
        driver.quit();

    }
}
