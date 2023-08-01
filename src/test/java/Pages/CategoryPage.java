package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class CategoryPage extends BaseUtil {
    private static BaseUtil base;
    public CategoryPage(BaseUtil base) {

        this.base = base;
    }
    public static By categoryBtn1()
    {
        return By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div/div/div/div[3]/article/div/div[4]/div[6]/div/div[1]/form/button");


    }

    // access category button number 2
    public static By categoryBtn2()
    {
        return  By.xpath("div>button[class=\"cartb  btn-product add-to-cart wb-bt-cart wb-bt-cart_27811 wb-enable\"]");
    }

    // confirm sign of the product
    public static String confirmSignProducts()
    {
        return base.Driver.findElement(By.xpath("(//span[@class=\"price actual-price\"])[1]")).getText();
    }


}
