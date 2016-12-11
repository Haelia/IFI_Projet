package application;

import application.forms.MessageForm;
import data.Message;
import data.MessageRepository;
import data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping(path = "/newpost")
    public String newPost() {
        return "newpost";
    }

    @PostMapping(path = "/newpost")
    public String signIn(@Valid MessageForm form, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            Message message =  new Message(user, form.getMessage(), new Date());
            RestTemplate template = new RestTemplate();
            template.put("http://localhost:8080/api/message/", message);
            return "redirect:/";
        } else
            return "signIn";
    }



}
