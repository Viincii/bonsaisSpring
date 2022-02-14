package fr.iut.csid.bonsais.user.infrastructure;

public class UserCredentials {
    public String username;
    public String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
