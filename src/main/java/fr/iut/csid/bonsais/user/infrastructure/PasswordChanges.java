package fr.iut.csid.bonsais.user.infrastructure;

public class PasswordChanges {

    private String oldPassword;
    private String newPassword;
    private String confirmationNew;

    public PasswordChanges(String oldPassword, String newPassword, String confirmationNew) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmationNew = confirmationNew;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmationNew() {
        return confirmationNew;
    }

    public void setConfirmationNew(String confirmationNew) {
        this.confirmationNew = confirmationNew;
    }

}
