package Steps;

import Base.BaseUtil;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class C02_Login extends BaseUtil {
    private BaseUtil base;

    public C02_Login(BaseUtil base) {

        this.base = base;
    }

    @io.cucumber.java.en.Given("^User navigate to login page$")
    public void userNavigateToLoginPage() {
        System.out.println("Navigate Login Page");
        base.Driver.navigate().to("https://www.tunisianet.com.tn/connexion?back=my-account");

    }

    @When("User enter valid email and valid password")
    public void userEnterValidEmailAndValidPassword() throws InterruptedException {

        //LoginPage page = new LoginPage(base.Driver);

        //LoginPage.Login(base.Email, base.Password);

        base.Driver.findElement(By.name("email")).sendKeys(base.Email);

        base.Driver.findElement(By.name("password")).sendKeys(base.Password);

        Thread.sleep(1000);



    }

    @io.cucumber.java.en.And("^User Click to login button")
    public void userClickToLoginButton() {
        //LoginPage page = new LoginPage(base.Driver);
        //LoginPage.ClickLogin();
        base.Driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();

    }

    @io.cucumber.java.en.Then("^User could be logged in successfully$")
    public void userCouldBeLoggedInSuccessfully() throws InterruptedException {

        Thread.sleep(1000);
        String expectedResult="https://www.tunisianet.com.tn/mon-compte";
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);
    }


}
