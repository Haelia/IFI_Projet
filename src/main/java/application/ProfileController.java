package application;

import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String profile(@SessionAttribute(required=false) User user, Model model){

        if (user == null)
            return "redirect:signup";
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("mail", user.getMail());
        model.addAttribute("phone", user.getPhone());
        return "profile";
    }
}
