package Pages;
import Base.BaseUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage{
    WebDriver driver = null ;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public static void goToHomePage()
    {
        BaseUtil.Driver.navigate().to("https://www.tunisianet.com.tn/");
    }
    public static By selectCategory1() throws InterruptedException {

        Actions action = new Actions(BaseUtil.Driver);
        // hover on "phones"
        Thread.sleep(1000);
        WebElement tel = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] > li:nth-child(3)"));
        action.moveToElement(tel).perform();
        Thread.sleep(1000);
        //select smartphone

        By smartphone = By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/596-smartphone-tunisie\"]");
        return smartphone;
    }
    public static By selectCategory2() throws InterruptedException {

        Actions action = new Actions(BaseUtil.Driver);
        // hover on "phones"
        Thread.sleep(1000);
        WebElement tel = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] > li:nth-child(6)"));
        action.moveToElement(tel).perform();
        Thread.sleep(1000);
        //select smartphone

        By TV = By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/665-televiseurs\"]");
        return TV;
    }
    /*public static WebElement selectCategory2() throws InterruptedException {   Actions action = new Actions(base.Driver);
        // hover on "informatique"
        Thread.sleep(1000);
        WebElement informatique = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] li[class=\"level-1  parent\"]"));
        action.moveToElement(informatique).perform();
        Thread.sleep(1000);
        //select smartphone

        //select accessoire
        //WebElement tel= base.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] li[class=\"level-1  parent\"]"));
        WebElement accessoire = BaseUtil.Driver.findElement(By.cssSelector("ul[class=\"menu-content top-menu\"] a[href=\"https://www.tunisianet.com.tn/378-accessoire-telephonie-mobile-tunisie\"]"));
        return accessoire;
    }*/

}
