package accounting;

import java.util.Objects;

public class User {
    private String login;
    private Role role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public User(String login, Role role) {
        this.login = login;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, role);
    }
}
