package application.forms;


import javax.validation.constraints.NotNull;

public class SignupForm {

    @NotNull
    private String name;
    @NotNull
    private String firstName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
