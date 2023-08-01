package Steps;

import Pages.HomePage;
import Base.BaseUtil;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C11_CreateOrder {

    @Given("User logged_in")
    public void login() throws InterruptedException {

        LoginPage.LoginSteps(BaseUtil.Email,BaseUtil.Password);
    }

    @When("User add products to cart")
    public void addProducts() throws InterruptedException {
        WebElement category = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] > li:nth-child(7)"));
        WebElement subCategory = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/529-mixeur-plongeant-tunisie\"]"));
        Actions action= new Actions(BaseUtil.Driver);
        action.moveToElement(category).perform();
        subCategory.click();
        Thread.sleep(500);

        BaseUtil.Driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div/div[1]/article/div/div[4]/div[6]/div/div[1]/form/button")).click();
        Thread.sleep(1000);
    }

    @And("User fill her data for make the order")
    public void fillData() throws InterruptedException
    {
        // make an order
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/panier");
        Thread.sleep(2000);
        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/div/div/section/div/div/div[3]/div/a")).click();
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/section/div/div[1]/section[2]/div/div/form/div[1]/article/footer/a[1]")).click();
        Thread.sleep(2000);


        BaseUtil.Driver.findElement(By.name("firstname")).sendKeys("Ahmed");
        BaseUtil.Driver.findElement(By.name("lastname")).sendKeys("Ben Yousssed");
        BaseUtil.Driver.findElement(By.name("address1")).sendKeys("Salah Salem Street");
        BaseUtil.Driver.findElement(By.name("postcode")).sendKeys("7084");
        BaseUtil.Driver.findElement(By.name("city")).sendKeys("sousse");
        BaseUtil.Driver.findElement(By.name("phone")).sendKeys("52625700");

        //Thread.sleep(2000);
        BaseUtil.Driver.findElement(By.name("confirm-addresses")).click();
        Thread.sleep(2000);

        BaseUtil.Driver.findElement(By.name("confirmDeliveryOption")).click();
        Thread.sleep(2000);

        BaseUtil.Driver.findElement(By.id("payment-option-3")).click();
        Thread.sleep(2000);

        BaseUtil.Driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        Thread.sleep(2000);

        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/section/div/div[1]/section[4]/div/div[2]/div[1]/button")).click();
        Thread.sleep(1000);

    }

    @Then("Order should created successfully")
    public void confirmOrder()
    {

        String actualResult = BaseUtil.Driver.findElement(By.cssSelector("div[class=\"col-md-12\"] h3[class=\"h1 card-title\"]")).getText();
        Assert.assertEquals(actualResult,"Votre commande est confirmée\n" +
                "              ");

    }

}
