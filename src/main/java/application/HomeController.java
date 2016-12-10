package application;

import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/")
    public String home(Model model, @SessionAttribute(required=false) User currentUser) {
        if (currentUser != null)
            model.addAttribute("currentUser", currentUser);
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "home";
    }

}
