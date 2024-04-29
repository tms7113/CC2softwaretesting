package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApptestXL1 {
    @BeforeMethod
    public void before()
    {
        System.out.println("Test case Started Successfully");
    }

    @Test(priority = 0)
    public void testing1() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
         ExtentReports report = new ExtentReports();
        ExtentSparkReporter eReporter = new ExtentSparkReporter("C:\\Users\\91637\\OneDrive\\Documents\\demo\\src\\test\\java\\com\\example\\report\\ExtentReport.html");
        report.attachReporter(eReporter);
        ExtentTest test = report.createTest("Test One1");

        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        Thread.sleep(2000);

        File file = new File("C:\\Users\\91637\\Videos\\dbankdemo.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Sheet1");
        XSSFRow r = sh.getRow(2);
        String x = r.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys(x);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span")).click();
        Thread.sleep(2000);
        WebElement page = driver
                .findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span"));
        String source = page.getText();
        if (source.equals("Chetan Bhagat"))
        {
        test.log(Status.PASS, "text is present");
            System.out.print("Name found");
        }
        else
        {
            System.out.print("Name not found");
            test.log(Status.FAIL, "text is not present");

        }
        driver.quit();
        report.flush();
    }

    @Test(priority = 1)
    public void testing2() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        WebElement clickable = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/a"));
        Thread.sleep(2000);
   
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
        driver.findElement(By.linkText("Audiobooks Top 100")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div/div[2]/div/div[2]/section[2]/ol/li[1]/div/div[2]/div[1]/h3/a"))
                .click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/section/div[2]/div/div[3]/div[2]/ul/li[2]/div/div/label/span")).click();
        // Thread.sleep(2000);
        JavascriptExecutor js10 = (JavascriptExecutor) driver;
        js10.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/section/div[2]/div/div[3]/div[2]/ul/li[2]/div/div/label/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/section/div[2]/div/div[3]/div[2]/div[3]/div[1]/div[1]/form/input[5]")).click();
        Thread.sleep(2000);

     //   driver.quit();
    }

    @Test(priority = 2)
    public void testing3() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.barnesandnoble.com/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,2000)");
        // Thread.sleep(2000);
        driver.navigate().to("https://www.barnesandnoble.com/membership/");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]/a"))
                .click();
        Thread.sleep(2000);
        // WebElement check2=driver.findElement(By.xpath("//*[@id=\"dialog-title\"]"));
        // Assert.assertTrue(check2.getText().contains("Sign in or Create an Account"),
        // "Sign in first!!");
        driver.quit();
    }
    @AfterMethod
    public void after()
    {
        System.out.println("Test Case Runned Successfully");
    
    }

}