package Steps;
import Base.BaseUtil;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.util.ArrayList;

public class C12_FollowUs {

    // Scenario #1 User opens FACEBOOK link
    @Given("User go to home page")
    public void goToHomePage()
    {
        HomePage.goToHomePage();
    }
    ArrayList<String> Tabs ;
    @When("User opens facebook link")
    public void userOpensFacebook() throws InterruptedException {

        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.cssSelector("li[class=\"facebook\"]")).click();
        Thread.sleep(2000);
        Tabs = new ArrayList<>(BaseUtil.Driver.getWindowHandles());
        BaseUtil.Driver.switchTo().window(Tabs.get(1));
        Thread.sleep(1000);

    }

    @Then("^\"(.*)\" facebook page is opened$")
    public void confirmOpenFacebook(String expectedResult) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        BaseUtil.Driver.close();
        BaseUtil.Driver.switchTo().window(Tabs.get(0));
    }




    // Scenario #2 User opens TWITTER link
    @When("User opens twitter link")
    public void openTwitter() throws InterruptedException {
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.cssSelector("li[class=\"twitter\"]")).click();
        Thread.sleep(2000);
        Tabs = new ArrayList<>(BaseUtil.Driver.getWindowHandles());
        BaseUtil.Driver.switchTo().window(Tabs.get(1));
        Thread.sleep(2000);
    }

    @Then("^\"(.*)\" twitter page is opened$")
    public void confirmOpenTwitter(String expectedResult ) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        BaseUtil.Driver.close();
        BaseUtil.Driver.switchTo().window(Tabs.get(0));
    }


    // Scenario #3 User opens pinterest link
    @When("User opens pinterest link")
    public void openPinterest() throws InterruptedException {
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.cssSelector("li[class=\"pinterest\"]")).click();
        Thread.sleep(2000);
        Tabs = new ArrayList<>(BaseUtil.Driver.getWindowHandles());
        BaseUtil.Driver.switchTo().window(Tabs.get(1));
        Thread.sleep(1000);

    }

    @Then("^\"(.*)\" pinterest page is opened$")
    public void confirmOpenPinterest(String expectedResult) throws InterruptedException {

        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        BaseUtil.Driver.close();
        BaseUtil.Driver.switchTo().window(Tabs.get(0));
    }

    // Scenario #4 User opens Youtube link
    @When("User opens youtube link")
    public void openYoutube() throws InterruptedException {
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.cssSelector("li[class=\"youtube\"]")).click();
        Thread.sleep(2000);
        Tabs = new ArrayList<>(BaseUtil.Driver.getWindowHandles());
        BaseUtil.Driver.switchTo().window(Tabs.get(1));
        Thread.sleep(1000);
    }

    @Then("^\"(.*)\" youtube page is opend$")
    public void confirmOpenYoutube(String expectedResult) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        BaseUtil.Driver.close();
        BaseUtil.Driver.switchTo().window(Tabs.get(0));
    }

    // Scenario #5 User opens Instagram link
    @When("User opens instagram link")
    public void openInstagram() throws InterruptedException {
        Thread.sleep(1000);
        BaseUtil.Driver.findElement(By.cssSelector("li[class=\"instagram\"]")).click();
        Thread.sleep(2000);
        Tabs = new ArrayList<>(BaseUtil.Driver.getWindowHandles());
        BaseUtil.Driver.switchTo().window(Tabs.get(1));
        Thread.sleep(2000);
    }

    @Then("^\"(.*)\" instagram page is opend$")
    public void confirmOpenInstagram(String expectedResult) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(BaseUtil.Driver.getCurrentUrl(),expectedResult);

        Thread.sleep(1000);

        BaseUtil.Driver.close();
        BaseUtil.Driver.switchTo().window(Tabs.get(0));
    }

}