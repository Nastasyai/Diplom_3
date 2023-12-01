import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pagesObject.Environment;
import pagesObject.LoginPage;
import pagesObject.MainPage;
import pagesObject.ProfileLK;
import user.User;
import user.UserClient;
import user.UserHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ProfileLKTest {

    public User user;
    public String accessToken = new String();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user = UserHelper.random();

        UserClient.create(user);

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.open()
                .login(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Открытие Личного кабинета в авторизованной зоне")
    public void openLKWhenAuthorized(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        ProfileLK lkPage = new ProfileLK(driverRule.getDriver());
        lkPage.profileLinkClick();
        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.ACCOUNT_URL, actualURL);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @Test
    @DisplayName("Проверка клика на конструктор из личного кабинета")
    public void ConstructorClickTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        ProfileLK lkPage = new ProfileLK(driverRule.getDriver());
        lkPage.constructorClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");

        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.BASE_URL, actualURL);
    }

    @Test
    @DisplayName("Клик по логотипу из личного кабинета")
    public void LogoClick(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        ProfileLK lkPage = new ProfileLK(driverRule.getDriver());
        lkPage.logoClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");

        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.BASE_URL, actualURL);
    }

    @Test
    @DisplayName("Клик на логаут из личного кабинета")
    public void LogoutClick(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        ProfileLK lkPage = new ProfileLK(driverRule.getDriver());
        lkPage.logoutClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        String text = loginPage.findLogButton();
        assertThat("There was no transition to the login page",text, containsString("Войти"));
    }
    @After
    public void deleteUser() {
        UserClient.delete(accessToken);
    }

}