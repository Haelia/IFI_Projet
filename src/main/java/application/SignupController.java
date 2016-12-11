package application;

import application.forms.SignUpForm;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * Created by agez on 07/12/16.
 */
@Controller
public class SignupController {

    public static final String PAGE_NAME = "signup";

    @GetMapping(path="/signup")
    public String signupForm(SignUpForm signUpForm, Model model) {
        return PAGE_NAME;
    }

    @PostMapping(path="/signup")
    public String signup(@Valid SignUpForm form, BindingResult results) {
        if (results.hasErrors())
            return PAGE_NAME;
        RestTemplate template = new RestTemplate();
        template.put("http://localhost:8080/api/user/", new User(form));
        return "redirect:/";
    }
}
