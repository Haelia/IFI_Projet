package application;

import data.Message;
import data.MessageRepository;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null)
            model.addAttribute("currentUser", currentUser);
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        List<Message> messages = messageRepository.findAll();
        model.addAttribute("listPidgeys", messages);
        return "home";
    }

}
