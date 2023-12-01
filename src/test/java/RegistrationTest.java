import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pagesObject.LoginPage;
import pagesObject.RegisterPage;
import user.User;
import user.UserHelper;

public class RegistrationTest {
    private User user;
    private User userShortPwd;
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user  = UserHelper.random();
        userShortPwd = UserHelper.generic();
    }

    @Test
    @DisplayName("Проверяем регистрацию с правильными параметрами")
    public void RegistrationSuccessful(){
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());

        LoginPage logPage = new LoginPage(driverRule.getDriver());
        MatcherAssert.assertThat(logPage.findLogButton(), true);
    }

    @Test
    @DisplayName("Проверяем регистрацию с коротким паролем")
    public void RegistrationWithShortPwd()  {
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()
                .fillRegisterForm(userShortPwd.getName(), userShortPwd.getEmail(), userShortPwd.getPassword());
        MatcherAssert.assertThat(regPage.incorrectPasswordTextAppear(), true);
    }
}