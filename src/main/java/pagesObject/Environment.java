package pagesObject;

public class Environment {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/account";
    public static final String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PASSWORD = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String LK = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String USER_CREATE = "api/auth/register";
    public static final String USER_DELETE = "/api/auth/user";
    public static final int DEFAULT_TIMEOUT = 10;
    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary");
}