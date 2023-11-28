import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pagesObject.ForgotPasswordPage;
import pagesObject.LoginPage;
import pagesObject.MainPage;
import pagesObject.RegisterPage;
import user.User;
import user.UserClient;
import user.UserHelper;

public class LoginTest {
    private User user;
    public String accessToken = new String();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user = UserHelper.random();
        UserClient.create(user);

    }

    @Test
    @DisplayName("Логин по кнопке Войти в аккаунт")
    public void enterAccountButtonLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .enterAccountClick();

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword());

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @Test
    @DisplayName("Логин через ссылку личный кабинет")
    public void enterWithLKLink() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .lkClick();

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword());

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @Test
    @DisplayName("Переход на логин со страницы авторизации")
    public void LoginFromRegisterPage() {
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()
                .loginButtonClick();

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword());

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @Test
    @DisplayName("переход на логин со страницы восстановления пароля и авторизация")
    public void LoginFromForgotPasswordPage() {
        ForgotPasswordPage fgPage = new ForgotPasswordPage(driverRule.getDriver());
        fgPage.open()
                .clickLoginButton();

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword());

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @After
    public void deleteUser() {
        UserClient.delete(accessToken);
    }
}