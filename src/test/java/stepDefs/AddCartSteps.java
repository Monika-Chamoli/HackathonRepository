package stepDefs;
import factory.driverFactory;
import io.cucumber.java.en.Then;
            import io.cucumber.java.en.When;
            import org.openqa.selenium.By;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.WebElement;
import utils.commonutilities;

import java.util.Iterator;
            import java.util.List;
            import java.util.Set;

public class AddCartSteps {
    public WebDriver driver;
    commonutilities commonUtilities=new commonutilities();
    pages.LoginPage loginPage=new pages.LoginPage(driverFactory.get_driver());
    private static String title;



@When("select toy and add to cart")
        public void addToCart() throws InterruptedException {
    driver=driverFactory.get_driver();
    Thread.sleep(5000);
    List<WebElement> toys = driver.findElements(By.xpath("//*[@class='_396cs4 _3exPp9']"));
    toys.get(0).click();
    String parent = driver.getWindowHandle();
    Set<String> s = driver.getWindowHandles();
    Iterator<String> I1 = s.iterator();
    while (I1.hasNext()) {
        String child_window = I1.next();
        if (!parent.equals(child_window)) {
            driver.switchTo().window(child_window);

        }
    }
    Thread.sleep(10000);
    driver.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
}
@Then("Toy must be added in the cart")
        public void toyAddedToCart() throws InterruptedException
{Thread.sleep(5000);
        String text= driver.findElement(By.xpath("//*[contains(text(),'My Cart (1)')]")).getText();
        System.out.println(text);
    System.out.println("1 Item is added to the cart successfully");

    commonUtilities.click_jv(driver.findElement(By.xpath("//*[text() ='Remove']")));
    //driver.findElement(By.xpath("//*[text() ='Remove']")).click();
    //driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")).click();
    commonUtilities.click_jv(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")));
    System.out.println("Item added in cart is removed successfully");

    }


}

