package application;

import application.forms.MessageForm;
import data.Message;
import data.MessageRepository;
import data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/newPidgey")
    public String newPost() {
        return "newPidgey";
    }

    @PostMapping(path = "/newPidgey")
    public String signIn(@Valid MessageForm form, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            Message message =  new Message(user, form.getMessage());
            messageRepository.save(message);
            return "redirect:/";
        } else
            return "signIn";
    }
}
