package application;

import application.forms.EditProfileForm;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


public class EditProfileController {

    @Autowired
    UserRepository repo;

    @GetMapping(path="/editprofile")
    public String editprofileForm(EditProfileForm signupForm, Model model) {
        return "editprofile";
    }

    @PostMapping(path="/editprofile")
    public String editprofile(@Valid EditProfileForm form, BindingResult results) {
        if (results.hasErrors())
            return "editprofile";
        //TODO update profile
        return "redirect:home";
    }
}
