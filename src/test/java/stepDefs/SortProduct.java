

package stepDefs;
        import factory.driverFactory;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import utils.commonutilities;

        import java.util.Iterator;
        import java.util.List;
        import java.util.Set;

public class SortProduct {
    public WebDriver driver;
    commonutilities commonUtilities=new commonutilities();
    pages.LoginPage loginPage=new pages.LoginPage(driverFactory.get_driver());
    private static String title;



    @When("user click on Men's Tshirt and select brands")
    public void menTshirt() throws InterruptedException {
        driver=driverFactory.get_driver();
        Thread.sleep(1000);
        commonUtilities.enterText(loginPage.enterSearch, "Men's Tshirt");
        commonUtilities.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(".L0Z3Pu")),10).click();
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        WebElement baby = driver.findElement(By.xpath("//*[text()='Men']"));
        act.moveToElement(baby).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("T-Shirts")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[4]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[4]/div[2]/div[1]/div[3]/div/label/div[2]")).click();
    }
    @Then("Selected brands product must be displayed")
    public void viewSortedBrands() throws InterruptedException
    {Thread.sleep(4000);
        String text= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[1]/div[2]/div[1]/div/div[2]")).getText();
        System.out.println(text);

    }


}


