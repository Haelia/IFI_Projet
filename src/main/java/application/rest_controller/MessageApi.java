package application.rest_controller;

import data.Message;
import data.MessageRepository;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by adrien on 11/12/16.
 */
@RestController
@RequestMapping("/api/message")
public class MessageApi {

    @Autowired
    MessageRepository messageRepo;
    @Autowired
    UserRepository userRepo;

    private static final PageRequest limit = new PageRequest(0, 30, new Sort(Sort.Direction.DESC, "createdAt"));

    @GetMapping("/")
    public List<Message> getLasts() {
        Page<Message> mess = messageRepo.findAll(limit);
        return mess.getContent();
    }

    @GetMapping("/byUser/{userName}")
    public List<Message> getByUser(@PathVariable String userName) {
        User user = userRepo.findByUserName(userName);
        return messageRepo.findByUser(user);
    }

    @PutMapping("/")
    public boolean postMessage(@RequestBody Message message) {
        User messageUser = message.getUser();
        if (messageUser == null) {
            return false;
        }
        messageRepo.insert(message);
        return true;
    }


}
