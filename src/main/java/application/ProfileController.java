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
    private UserRepository userRepo;

    @RequestMapping("/profile")
    public String profile(Model model){
        //repo.save(new User("Sarah", "Wissocq", "sw@mail.com", "06 66 66 66 66")); -> permet de tester
        User user;
        user = userRepo.findAll().get(0);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("mail", user.getMail());
        model.addAttribute("phone", user.getPhone());
        return "profile";
    }
}
