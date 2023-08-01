package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class C04_SearchProduct extends BaseUtil{
    private BaseUtil base;

    public C04_SearchProduct(BaseUtil base) {
        this.base = base;
    }

    @Given("User should to be logged in successfully")
    public void login() throws InterruptedException {

        // GO TO LOGIN PAGE
        base.Driver.navigate().to("https://www.tunisianet.com.tn/connexion?back=my-account");
        // ENTER EMAIL
        base.Driver.findElement(By.name("email")).sendKeys(base.Email);
        // ENTER PASSWORD
        base.Driver.findElement(By.name("password")).sendKeys(base.Password);
        // CLICK TO LOGIN BUTTON
        base.Driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
        Thread.sleep(1000);

    }

    @When("^User Write the name of product an Ex:\"(.*)\"$")
    public void enterProductName(String productName)
    {
        base.Driver.findElement(By.id("search_query_top")).sendKeys(productName);
    }

    @And("User clicked to enter button in keyboard")
    public void clickSearchBtn() throws InterruptedException {

        base.Driver.findElement(By.xpath("//*[@id=\"sp-btn-search\"]")).click();
        Thread.sleep(1000);

        Actions action = new Actions(base.Driver);
        WebElement productEle = base.Driver.findElement(By.xpath("//*[@id=\"products\"]"));
        action.moveToElement(productEle).perform();
        Thread.sleep(1000);
    }

    @Then("The website should appear the results related to the product name")
    public void showProductResult() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        // ASSERT NUMBER #1
        String actualResult = base.Driver.getCurrentUrl();
        String expectedResult = "https://www.tunisianet.com.tn/recherche";
        soft.assertTrue(actualResult.contains(expectedResult),"confirm Assert");



    }


}
