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
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by adrien on 10/12/16.
 */
@Controller
public class SignInController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(path="/signin")
    public String signInForm() {
        return "signIn";
    }

    @PostMapping(path="/signin")
    public String signIn(@Valid SignInForm form, HttpSession session) {
        RestTemplate template = new RestTemplate();
        User checkedUser = template.getForObject("http://localhost:8080/api/user/" + form.getUserName(), User.class);
        if (checkedUser != null && form.getPassword().equals(checkedUser.getPassword())) {
            session.setAttribute("currentUser", checkedUser);
            return "redirect:/";
        } else
            return "signIn";
    }

    @GetMapping(path="/signout")
    public String signout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "redirect:/";
    }
}
