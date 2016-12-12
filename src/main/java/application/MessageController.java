package application;

import application.forms.MessageForm;
import data.Message;
import data.MessageRepository;
import data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/newPidgey")
    public String writeNewPidgey(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            model.addAttribute("currentUser", currentUser);
            return "newPidgey";
        } else {
            return "redirect:signin";
        }
    }

    @PostMapping(path = "/newPidgey")
    public String postNewPidgey(@Valid MessageForm form, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            Message message =  new Message(currentUser, form.getMessage(), new Date());
            RestTemplate template = new RestTemplate();
            template.put("http://localhost:8080/api/message/", message);
            return "redirect:/";
        } else
            return "signIn";
    }
}
