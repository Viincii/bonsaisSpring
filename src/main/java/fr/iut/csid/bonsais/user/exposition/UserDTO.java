package fr.iut.csid.bonsais.user.exposition;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String username;
    private String authority;

    public UserDTO(UUID id, String username, String authority) {
        this.id = id;
        this.username = username;
        this.authority = authority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
