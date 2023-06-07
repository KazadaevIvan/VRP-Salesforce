package service;

import model.User;

public class UserCreator {
    public static final String USERNAME = TestDataReader.getTestData("username");
    public static final String PASSWORD = TestDataReader.getTestData("password");

    public static User withCredentialsFromProperty() {
        return new User(USERNAME, PASSWORD);
    }
}
