package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class C01_Registration {

    @Given("User should have an Email to register")
    public void userShouldHaveAnEmailToRegister() throws InterruptedException {
        BaseUtil.Driver.navigate().to("https://tempmail.dev/ar");
        Thread.sleep(6000);
        BaseUtil.Email = BaseUtil.Driver.findElement(By.id("current-mail")).getText();
        Thread.sleep(1000);
    }

    @And("User navigate to register page")
    public void userNavigateToRegisterPage() throws InterruptedException {
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/connexion?create_account=1");
        Thread.sleep(1000);
    }

    @When("User enter valid data to inputs")
    public void userEnterValidDataToInputs() throws InterruptedException {

        BaseUtil.Driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span")).click();
        BaseUtil.Driver.findElement(By.name("firstname")).sendKeys("Ahmed");
        BaseUtil.Driver.findElement(By.name("lastname")).sendKeys("Moussa");

        BaseUtil.Driver.findElement(By.name("email")).sendKeys(BaseUtil.Email);

        BaseUtil.Driver.findElement(By.name("password")).sendKeys(BaseUtil.Password);

        BaseUtil.Driver.findElement(By.name("birthday")).sendKeys("12/11/1995");
        Thread.sleep(1000);

        BaseUtil.Driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button")).click();

    }

    @Then("User could be register successfully")
    public void userCouldBeRegisterSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        String expectedResult="https://www.tunisianet.com.tn/mon-compte";
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

    }
}
