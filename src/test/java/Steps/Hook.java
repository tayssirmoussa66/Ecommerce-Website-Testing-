package Steps;
import Base.BaseUtil;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class Hook extends BaseUtil{
    private BaseUtil base;


    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("opening the browser : chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--headless");
        base.Driver = new ChromeDriver();
        base.Driver.manage().window().maximize();
        //base.Driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario) throws InterruptedException {

        System.out.println("Closing the browser : MOCK");
        Thread.sleep(3000);
        base.Driver.quit();

    }



}
