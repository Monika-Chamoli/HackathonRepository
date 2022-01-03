package stepDefs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.commonutilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUploadSteps {
    public WebDriver driver;
    commonutilities commonUtilities=new commonutilities();
    pages.LoginPage loginPage=new pages.LoginPage(driverFactory.get_driver());
    private static String title;
//    String CSV_PATH = "C:/dev/credentials.csv";
//    private CSVReader csvReader;
//    String[] csvCell;



    @When("user read credentials from CSV file and signIn")
    public void signin() throws InterruptedException, CsvValidationException, IOException {
        driver=driverFactory.get_driver();
        Thread.sleep(1000);
        commonUtilities.enterDataByCSV();
        commonUtilities.click_jv(loginPage.SignInSubmit);
    }

    @Then("user must be logged in to Flipkart application")
    public void viewPage() {
        System.out.println(driver.getTitle());
    }




}

