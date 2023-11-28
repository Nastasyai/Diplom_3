import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pagesObject.Environment;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource{
    WebDriver driver;

    @Override

    protected void before()  {

        if ("yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    private void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\aapetuk9\\projects\\Diplom_3\\bin\\WebDriver\\chromedriver-win64\\chromedriver.exe"))
                .build();
        driver = new ChromeDriver(service);
    }
    public void setUpYandex() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(Environment.YANDEX_DRIVER))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(Environment.YANDEX_BINARY);

        driver = new ChromeDriver(service, options);
    }

    @Override
    protected void after(){
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}