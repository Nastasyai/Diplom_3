package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private WebDriver driver;
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    private static final By VOITI_V_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By LK_LINK = By.xpath("//p[text()= 'Личный Кабинет']");
    private static final By TAB_BUN = By.xpath("//span[@class='text text_type_main-default' and text()='Булки']");
    private static final By TAB_SAUCE = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']");
    private static final By TAB_FILLINGS = By.xpath("//span[text() = 'Начинки']/..");
    private static final By IMG_SAUCE_SPICY_X = By.xpath("//img[@alt='Соус Spicy-X']");
    private static final By IMG_MEAT_IMMORTAL_MOLLUSKS = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    private static final By IMG_FLUORESCENT_BUN = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    public static final String ACTIVE_BUN_SECTION = "//div/main/section[1]/div[1]/div[1]";
    private static final String ACTIVE_SAUCE_SECTION = "//div/main/section[1]/div[1]/div[2]";
    private static final String ACTIVE_FILLING_SECTION = "//div/main/section[1]/div[1]/div[3]";
    public static final String CURRENT_VALUE = "tab_tab_type_current__2BEPc";

    public MainPage open() {
        driver.get(Environment.BASE_URL);
        return this;
    }

    public MainPage enterAccountClick(){
        driver.findElement(VOITI_V_ACCOUNT_BUTTON).click();
        return  this;
    }

    public MainPage lkClick(){
        driver.findElement(LK_LINK).click();
        return this;
    }

    public MainPage waitWithDefaultTimeout(){
        new WebDriverWait(driver, ofSeconds(Environment.DEFAULT_TIMEOUT));
        return this;
    }

    public MainPage bunClick(){
        driver.findElement(TAB_BUN).click();
        return this;
    }
    public MainPage sauceClick(){
        driver.findElement(TAB_SAUCE).click();
        return this;
    }

    public MainPage fillingClick(){
        driver.findElement(TAB_FILLINGS).click();
        return this;
    }

    public MainPage getActiveBunTab(){
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.attributeContains(By.xpath(ACTIVE_BUN_SECTION), "class", CURRENT_VALUE));
        return this;
    }
    public MainPage getActiveSauceTab(){
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.attributeContains(By.xpath(ACTIVE_SAUCE_SECTION), "class", CURRENT_VALUE));
        return this;
    }
    public MainPage getActiveFillingTab(){
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.attributeContains(By.xpath(ACTIVE_FILLING_SECTION), "class", CURRENT_VALUE));
        return this;
    }

    public boolean checkScrollingToFirstPositions(By ingredient) {
        try {
            new WebDriverWait(driver, ofSeconds(10))
                    .until(driver -> {
                        // rectangle 24 x 297
                        return (driver.findElement(ingredient).getRect().y < 300) &&
                                (driver.findElement(ingredient).getRect().y > 100);
                    });
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }
    public By getFirstBunLocator() {
        return IMG_FLUORESCENT_BUN;
    }

    public By getFirstSauseLocator() {
        return IMG_SAUCE_SPICY_X;
    }

    public By getFirstFillingLocator() {
        return IMG_MEAT_IMMORTAL_MOLLUSKS;
    }


}