package Pages;
import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
    WebDriver driver = null ;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "/html/body/main/section/div/div/div/section/section/section/form/section/div[1]/div[1]")
    public static WebElement txtUserName;

    @FindBy(how = How.XPATH, using = "/html/body/main/section/div/div/div/section/section/section/form/section/div[2]/div[1]")
    public static WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"submit-login\"]")
    public static WebElement btnLogin;

    public static void Login(String email, String password)
    {
        txtUserName.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public static void ClickLogin()
    {
        btnLogin.submit();
    }

    public static void LoginSteps(String Email, String password) throws InterruptedException {

        // GO TO LOGIN PAGE
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/connexion?back=my-account");
        // ENTER EMAIL
        BaseUtil.Driver.findElement(By.name("email")).sendKeys(Email);
        // ENTER PASSWORD
        BaseUtil.Driver.findElement(By.name("password")).sendKeys(password);
        // CLICK TO LOGIN BUTTON
        BaseUtil.Driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
        Thread.sleep(1000);
    }


}