package stepDefs;

import factory.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.commonutilities;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ViewPageSteps {
    public WebDriver driver;
    commonutilities commonUtilities=new commonutilities();
    LoginPage loginPage=new LoginPage(driverFactory.get_driver());
    private static String title;

    @Given("user is on flipkart login page")
    public void userIsOnloginPage(){
        driver=driverFactory.get_driver();
        String title= loginPage.getPageTitle();
        System.out.println(title);

    }

    @When("user clicks on SignIn")
    public void clicksign() throws InterruptedException
    { Thread.sleep(1000);
        commonUtilities.click_jv(loginPage.SigninBtn);
    }

    @When("user enters username {string} and password {string}")
   public void enterUsername(String username,String password)  {
        commonUtilities.waitForElementToBeClickable(driver,loginPage.ClickOnUsername,10).click();
        commonUtilities.enterText(loginPage.enterusername, username);
        commonUtilities.enterText(loginPage.enterpassword, password);
        commonUtilities.click_jv(loginPage.SignInSubmit);
    }

    @When("user navigates to Remote-control toys")
    public void navigateToKidsSection() throws InterruptedException {
        Thread.sleep(1000);
        commonUtilities.enterText(loginPage.enterSearch, "baby and kids");
        commonUtilities.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(".L0Z3Pu")),10).click();
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        WebElement baby = driver.findElement(By.xpath("//*[text()='Baby & Kids']"));
        act.moveToElement(baby).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Remote Control Toys")).click();
    }

        @Then("user view Product Page")
        public void user_view_product_page() {
            System.out.println(driver.getTitle());
        }

}
