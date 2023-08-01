package Steps;
import Base.BaseUtil;
import Pages.LoginPage;
import Pages.HomePage;
import Pages.CategoryPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class C08_AddToCart {


    @Given("User logged in successfully")
    public void login() throws InterruptedException {

        LoginPage.LoginSteps(BaseUtil.Email,BaseUtil.Password);

    }

    @And("User go to any product page")
    public void goToHomePage()
    {
        HomePage.goToHomePage();
    }

    @When("User add product to cart")
    public void user_add_product_to_cart() throws InterruptedException {

        BaseUtil.Driver.findElement(HomePage.selectCategory1()).click();
        BaseUtil.Driver.findElement(CategoryPage.categoryBtn1()).click();
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/button")).click();
        Thread.sleep(1000);

    }

    @Then("User should to find the product in shopping cart")
    public void checkAddProducts()
    {
        // Assert Sign
        String expectedResult = BaseUtil.Driver.findElement(By.xpath(("(//span[@class=\"hidden-md-down cartc\"])"))).getText();
        Assert.assertTrue("Shop",expectedResult.contains("DT"));

        //ShoppingCheckoutPage.goToCartPage();
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/panier");
        Assert.assertTrue(BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"cart-items\"] > li[class=\"cart-item\"]")).isDisplayed());
    }

}
