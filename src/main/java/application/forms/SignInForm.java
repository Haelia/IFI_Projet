package application.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by adrien on 10/12/16.
 */
public class SignInForm {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
