package application;

import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @Autowired
    UserRepository repo;

    @RequestMapping("/profile")
    public String profile(Model model){
        //repo.save(new User("Sarah", "Wissocq", "sw@mail.com", "06 66 66 66 66")); -> permet de tester
        User user;
        user = repo.findAll().get(0);
        model.addAttribute("LastName", user.getLastName());
        model.addAttribute("FirstName", user.getFirstName());
        model.addAttribute("Email", user.getEmail());
        model.addAttribute("Phone", user.getPhone());
        return "profile";
    }
}
