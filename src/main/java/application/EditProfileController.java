package application;

import application.forms.EditProfileForm;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


public class EditProfileController {

    public static final String PAGE_NAME = "editProfile";
    @Autowired
    UserRepository repo;

    @GetMapping(path="/editProfile")
    public String editprofileForm(EditProfileForm signupForm, Model model) {
        return PAGE_NAME;
    }

    @PostMapping(path="/editProfile")
    public String editprofile(@Valid EditProfileForm form, BindingResult results, HttpSession session) {
        if (results.hasErrors()) {
            return PAGE_NAME;
        }

        final User user = (User) session.getAttribute("currentUser");
        user.setMail(form.getMail());
        user.setPhone(form.getPhone());
        user.setPassword(form.getPassword());
        user.setFacebook(form.getFbId());
        user.setLinkedin(form.getLinkedinId());
        user.setTwitter(form.getTwitterId());
        repo.save(user);
        return "redirect:home";
    }
}
