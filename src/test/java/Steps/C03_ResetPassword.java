package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class C03_ResetPassword extends BaseUtil {
    private BaseUtil base;

    public C03_ResetPassword(BaseUtil base) {
        this.base = base;
    }

    @Given("User navigate to login page directly")
    public void userNavigateToLoginPageDirectly() {

        base.Driver.navigate().to("https://www.tunisianet.com.tn/connexion?back=my-account");

    }

    @When("User clicked the reset password Link")
    public void userClickedTheResetPasswordLink() {
        base.Driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[3]/a")).click();
    }

    @And("User enter his email to send the key to reset the password")
    public void userEnterHisEmailToSendTheKeyToResetThePassword() {
        base.Driver.findElement(By.name("email")).sendKeys(base.Email);
    }

    @And("User clicked to reset button")
    public void userClickedToResetButton() {
        base.Driver.findElement(By.xpath("//*[@id=\"content\"]/form/section/div/button[1]")).click();
    }

    @Then("The website send to email that has been register")
    public void theWebsiteSendToEmailThatHasBeenRegister() {

        // #1 ACTUAL AND EXPECTED RESULT OF FIRST SOT ASSERT
        String actualResult = base.Driver.findElement(By.cssSelector("ul[class=\"ps-alert-success\"]")).getText();
        String expectedResult = "Si cette adresse e-mail est enregistrée dans notre boutique, vous recevrez un lien pour réinitialiser votre mot de passe sur rimmoussa351@gmail.com.";

        // CREATE NEW OBJECT OF SOFT ASSERT TO USE
        SoftAssert soft = new SoftAssert();

        // FIRST SOFT ASSERT TO CONFIRM THE SUCCESSFUL MESSAGE
        soft.assertTrue(actualResult.contains(expectedResult),"confirm the write message");
    }
}
