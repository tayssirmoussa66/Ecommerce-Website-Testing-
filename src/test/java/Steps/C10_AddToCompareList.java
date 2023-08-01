package Steps;
import Base.BaseUtil;
import Pages.LoginPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;

public class C10_AddToCompareList {
    @Given("User logged in the website ")
    public void login() throws InterruptedException {

        LoginPage.LoginSteps(BaseUtil.Email,BaseUtil.Password);
    }

    @When("User try to compare multiple products")
    public void compareProducts() throws InterruptedException
    {

        BaseUtil.Driver.findElement(HomePage.selectCategory2()).click();
        Thread.sleep(1000);

        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div/div/div/div[1]/article/div/div[4]/div[6]/div/div[3]/a")).click();
        Thread.sleep(1000);

        BaseUtil.Driver.findElement(By.cssSelector("div[class=\"modal-header\"] > button[class=\"close\"]")).click();
        Thread.sleep(1000);

        BaseUtil.Driver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div/div/div/div[2]/article/div/div[4]/div[6]/div/div[3]/a")).click();
        Thread.sleep(2000);

    }


    @Then("Successful message for add products to compare list")
    public void confirmComparison() throws InterruptedException
    {
        WebElement expectedResult = BaseUtil.Driver.findElement(By.cssSelector(("div[class=\"modal-dialog\"] > div[class=\"modal-content\"]")));
        Assert.assertTrue(expectedResult.isDisplayed());
        Thread.sleep(2000);
    }


    @And("Products should to be find into compare list page")
    public void confirmPage() throws InterruptedException
    {
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/module/wbfeature/productscompare");
        Thread.sleep(1000);
        Assert.assertTrue(BaseUtil.Driver.findElement(By.cssSelector("div[class=\"products_block table-responsive\"]")).isDisplayed());
        Thread.sleep(1000);

    }

}
