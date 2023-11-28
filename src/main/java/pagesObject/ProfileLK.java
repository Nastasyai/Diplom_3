package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileLK {

    final WebDriver driver;

    public ProfileLK(WebDriver driver) {
        this.driver = driver;
    }

    public static final By PROFILE = By.xpath("//a[text() = 'Профиль']");
    public static final By CONSTRUCTOR = By.xpath("//p[text()='Конструктор']");
    public static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    public static final By LOGOUT_LINK = By.xpath(".//button[text()='Выход']");

    public ProfileLK open() {
        driver.get(Environment.LK);
        return this;
    }

    public ProfileLK profileLinkClick() {
        driver.findElement(PROFILE).click();
        return this;
    }

    public ProfileLK constructorClick() {
        driver.findElement(CONSTRUCTOR).click();
        return this;
    }

    public ProfileLK logoClick() {
        driver.findElement(LOGO).click();
        return this;
    }

    public ProfileLK logoutClick() {
        driver.findElement(LOGOUT_LINK).click();
        return this;
    }
}