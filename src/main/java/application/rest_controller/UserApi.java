package application.rest_controller;

import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adrien on 11/12/16.
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/name/{userName}")
    public User getUserByName(@PathVariable String userName) {
        return userRepo.findByUserName(userName);
    }
}
