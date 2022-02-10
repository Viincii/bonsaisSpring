package fr.iut.csid.bonsais.user.infrastructure;

public class UserCreationRequest {

    private UserCredentials userCredentials;

    public UserCreationRequest(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public String username() {
        return userCredentials.getUsername();
    }

    public String password() {
        return userCredentials.getPassword();
    }
}
