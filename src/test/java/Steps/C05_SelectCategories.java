package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class C05_SelectCategories extends BaseUtil{
   // String subCategoryName;
    private BaseUtil base;

    public C05_SelectCategories(BaseUtil base) {

        //this.subCategoryName = subCategoryName;
        this.base = base;
    }

    @Given("User should to be logged in")
    public void Login() throws InterruptedException {

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

    @When("User select any category")
    public void userSelectCategory() throws InterruptedException {

        Actions action = new Actions(base.Driver);
        // hover on "informatique"
        Thread.sleep(1000);
        WebElement informatique = base.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] li[class=\"level-1  parent\"]"));
        action.moveToElement(informatique).perform();
        Thread.sleep(1000);

        // getText() of subCategory before click on it

        WebElement Pc_Portable = base.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/301-pc-portable-tunisie\"]"));


        // click on "Desktops
        Thread.sleep(1000);
        Pc_Portable.click();

    }

    @Then("The website should to appear the products that related to the category selected")
    public void confirmSelectCategory()
    {

        SoftAssert soft = new SoftAssert();
        // ASSERT NUMBER #1
        String actualResult = base.Driver.getCurrentUrl();
        String expectedResult = "https://www.tunisianet.com.tn/301-pc-portable-tunisie";
        soft.assertTrue(actualResult.contains(expectedResult),"Confirm page");

    }


}
