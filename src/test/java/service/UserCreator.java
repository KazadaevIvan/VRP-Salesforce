package service;

import model.User;

public class UserCreator {
    public static User withCredentialsFromProperty() {
        return new User("", "");
    }
}
