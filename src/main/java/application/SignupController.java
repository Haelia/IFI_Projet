package application;

import application.forms.SignupForm;
import data.People;
import data.PeopleRepository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by agez on 07/12/16.
 */
@Controller
public class SignupController {

    @Autowired
    PeopleRepository repo;

    @GetMapping(path="/signup")
    public String signupForm(SignupForm signupForm, Model model) {
        return "signup";
    }

    @PostMapping(path="/signup")
    public String signup(@Valid SignupForm form, BindingResult results) {
        if (results.hasErrors())
            return "signup";
        repo.save(new People(form.getFirstName(), form.getName()));
        return "redirect:home";
    }
}
