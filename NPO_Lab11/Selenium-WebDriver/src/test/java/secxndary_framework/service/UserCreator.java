package secxndary_framework.service;
import secxndary_framework.model.User;


public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.login";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";


    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyUsername() {
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
