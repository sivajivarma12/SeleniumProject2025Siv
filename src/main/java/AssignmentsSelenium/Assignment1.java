package AssignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String a[]){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //title validation
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,"ParaBank | Welcome | Online Banking");
        System.out.println(actualtitle);

        //logo validation
        String imagvalue = driver.findElement(By.xpath("//img[@alt='ParaBank']")).getAttribute("title");
        System.out.println(imagvalue);
        Assert.assertEquals(imagvalue,"ParaBank");

        //caption validations
        String capationvalue = driver.findElement(By.xpath("//p[text()='Experience the difference']")).getText();
        System.out.println(capationvalue);
        Assert.assertEquals(capationvalue,"Experience the difference");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sivaji");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sivaji");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        driver.quit();

    }
}
