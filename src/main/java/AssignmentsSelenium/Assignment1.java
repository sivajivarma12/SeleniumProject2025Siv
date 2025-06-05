package AssignmentsSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("varma1234");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();


     //   String loginresult = driver.findElement(By.xpath("//h1[@class='title']/following::p[@class='error']")).getText();
       // if(loginresult.equals("The username and password could not be verified.")){
         //   System.out.println("Login failed as expected");
        //}
        driver.findElement(By.xpath("//a[text()='Admin Page']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[contains(text(),'Administration')]"), 0));

        if(!driver.findElement(By.xpath("//input[@type='radio' and @value='soap']")).isSelected())
            driver.findElement(By.xpath("//input[@type='radio' and @value='soap']")).click();

        WebElement element =driver.findElement(By.xpath("//b[text()='Loan Provider:']"));
        viewelement(element, driver);

        Select loanprovider = new Select(driver.findElement(By.xpath("//select[@id='loanProvider']")));
        loanprovider.selectByValue("ws");

        WebElement submitbutton = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        viewelement(submitbutton, driver);
        submitbutton.click();

        WebElement submitmessage = driver.findElement(By.xpath("//*[@id='rightPanel']/p/b"));
        wait.until(ExpectedConditions.visibilityOf(submitmessage));
        String submitmessagevalue = submitmessage.getText();
        System.out.println(submitmessagevalue);

        WebElement services = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));
        services.click();

        WebElement bookstore = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[text()='Bookstore services:']"), 0));

      viewelement(bookstore,driver);

        List<WebElement> cloumn1 = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td"));

        List<WebElement> row = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr"));

        int c = cloumn1.size();
        int r = row.size() - 1;

        //print cloumn name
        for(int i=1; i<=c; i++){
            String cloumnname = driver.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td["+i+"]")).getText();
            System.out.print("              "+cloumnname);
        }
        System.out.println();
        for(int j=2; j<=r; j++) {
            for (int k = 1; k <= c; k++) {
                String columnvalue = driver.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[" + j + "]//td["+k+"]")).getText();
            System.out.print("              " + columnvalue);
            }
            System.out.println();
        }
        //driver.quit();

    }
    public static void viewelement(WebElement element, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
