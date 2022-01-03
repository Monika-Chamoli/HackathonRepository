package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a")
    public WebElement SigninBtn;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
    public WebElement ClickOnUsername;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
    public WebElement enterusername;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
    public WebElement ClickOnPassword;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
    public WebElement enterpassword;

    @FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
    public WebElement SignInSubmit;

    @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
    public WebElement enterSearch;



    @FindBy(xpath="//*[@class='L0Z3Pu']")
    public WebElement ClickSearchbar;

    @FindBy(xpath="//*[contains(text(),'Baby & Kids')")
    public WebElement Babyandkids;

    @FindBy(xpath="//*[contains(text(),'Remote Control Toys')]")
    public WebElement RemoteControlToys;

    public String getPageTitle(){
        return driver.getTitle();
    }

    }


