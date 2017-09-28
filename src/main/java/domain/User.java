package domain;

import java.time.LocalDate;

public class User extends Person {
    private String login;
    private String password;
    private UserState state;

    public User() {
        super();
        this.login = "user";
        this.password = "1234";
        this.state = UserState.New;
    }

    public User(String name, String surname, String login, String password) {
        super(name, surname);
        this.login = login;
        this.password = password;
        this.state = UserState.New;
    }

    public User(String name, String surname, LocalDate birthDay, String login, String password) {
        super(name, surname, birthDay);
        this.login = login;
        this.password = password;
        this.state = UserState.New;
    }

    public User(String name, String surname, LocalDate birthDay, String login, String password, UserState state) {
        super(name, surname, birthDay);
        this.login = login;
        this.password = password;
        this.state = state;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                "} " + super.toString();
    }
}
