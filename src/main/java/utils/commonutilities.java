package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import factory.driverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.sql.DriverManager;
import java.util.Properties;

public class commonutilities {
    private driverFactory myFactory;
    private WebDriver driver;
    private configReader FileReader;
    Properties props;


    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clickTo(WebElement element) {
        element.click();
    }

    public void enterDataByCSV() throws InterruptedException, CsvValidationException, IOException
    {
        String CSV_PATH = "C:/dev/credentials.csv";
        CSVReader csvReader;
        String[] csvCell;
        driver=driverFactory.get_driver();
        csvReader = new CSVReader(new FileReader(CSV_PATH));
        while ((csvCell = csvReader.readNext()) != null) {
            String username = csvCell[0];
            String password = csvCell[1];
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(username);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(password);
        }
    }

    public void click_jv(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driverFactory.get_driver();
        jse.executeScript("arguments[0].click();", element);
    }

    public void click_scrolltoview(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    public void elementwait(WebElement element, int seconds) {
//        WebDriverWait wait = new WebDriverWait(driverFactory.get_driver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public static WebElement waitForElementToBeVisible(WebDriver driver,WebElement element,int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement element,int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }

    public void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }
        catch(Exception e)
        {}
    }


}
