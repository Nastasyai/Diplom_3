package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserHelper {
    public static User generic () {
        User user = new User(RandomStringUtils.randomAlphanumeric(5)+"@example.com", "1234", "SimpleBurger");
        return user;
    }

    public static User random() {
        return new User(RandomStringUtils.randomAlphanumeric(5)+"@example.com", "123497Y", "TheBiggestBurgerFan");
    }

}