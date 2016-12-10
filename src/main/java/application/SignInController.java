package application;

import application.forms.SignInForm;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by adrien on 10/12/16.
 */
@Controller
@SessionAttributes("currentUser")
public class SignInController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(path="/signin")
    public String signInForm() {
        return "signIn";
    }

    @PostMapping(path="/signin")
    public String signIn(@Valid SignInForm form, Model model) {
        User checkedUser = userRepo.findByUserName(form.getUserName());
        if (checkedUser != null && form.getPassword().equals(checkedUser.getPassword())) {
            model.addAttribute("currentUser", checkedUser);
            return "redirect:/";
        } else
            return "signIn";
    }

    @GetMapping(path="/signout")
    public String signout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "home";
    }
}
