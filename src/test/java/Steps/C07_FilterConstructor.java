package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class C07_FilterConstructor extends BaseUtil {
    private BaseUtil base;

    public C07_FilterConstructor(BaseUtil base) {
        this.base = base;
    }

    @Given("User logged in ")
    public void login() throws InterruptedException {

    }

    @And("User should to select an item ")
    public void selectProduct() throws InterruptedException {
        Thread.sleep(1000);
        base.Driver.navigate().to("https://www.tunisianet.com.tn/596-smartphone-tunisie");

    }


    @When("User filter items by constructor option")
    public void chooseColor() throws InterruptedException {
        Thread.sleep(2000);
        base.Driver.findElement(By.id("m-12")).click();
    }

    @Then("User appear for him the filter items of constructor that he chose")
    public void confirmFilter()
    {
        boolean enableBtn = base.Driver.findElement(By.id("m-12")).isEnabled();
        Assert.assertTrue(enableBtn,"Assert Button");
    }
}
