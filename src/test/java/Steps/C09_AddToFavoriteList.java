package Steps;
import Base.BaseUtil;
import Pages.LoginPage;
import Pages.HomePage;
import Pages.CategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

public class C09_AddToFavoriteList {

    @Given("User logged_in ")
    public void login() throws InterruptedException {

        LoginPage.LoginSteps(BaseUtil.Email,BaseUtil.Password);
    }

    @When("User select different products to Favorite list")
    public void userSelectDifferentProductsToWishlist() throws InterruptedException {
        Thread.sleep(500);

        WebElement category = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] > li:nth-child(6)"));
        WebElement subCategory = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/370-appareil-photo-tunisie\"]"));
        Actions action= new Actions(BaseUtil.Driver);
        action.moveToElement(category).perform();
        subCategory.click();
        Thread.sleep(500);

        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div/div/div/div[2]/article/div/div[4]/div[6]/div/div[2]/a")).click();
        Thread.sleep(1000);

    }

    @Then("User show green message for successful add products to Favorite list")
    public void userShowGreenMessageForSuccessfulAddProductsToWishlist() throws InterruptedException {

        Thread.sleep(2000);
        WebElement expectedResult = BaseUtil.Driver.findElement(By.xpath(("//*[@id=\"category\"]/div[3]")));
        Assert.assertTrue(expectedResult.isDisplayed());
    }

    @And("User open Favorite list page and find the items has been selected")
    public void userOpenWishlistPageAndFindTheItemsHasBeenSelected() throws InterruptedException {

        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/module/wbfeature/mywishlist");
        Thread.sleep(1000);
        Assert.assertTrue(BaseUtil.Driver.findElement(By.cssSelector("div[class=\"wb-wishlist-product products row\"]")).isDisplayed());
        Thread.sleep(1000);

    }


}
