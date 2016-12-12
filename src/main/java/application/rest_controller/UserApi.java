package application.rest_controller;

import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PatchMapping("/{userName}")
    public User patchUser(@PathVariable String userName, @RequestBody User updatedUser) {
        User oldUser = userRepo.findByUserName(userName);
        if (oldUser == null || !updatedUser.getUserName().equals(oldUser.getUserName()))
            return null;
        updatedUser.setId(oldUser.getId());
        userRepo.save(updatedUser);
        return updatedUser;
    }

    @GetMapping("/authenticate/{userName}/{password}")
    public User authenticate(@PathVariable String userName, @PathVariable String password) {
        if (userName != null && password != null && !userName.isEmpty() && !password.isEmpty()) {
            final User user = userRepo.findByUserName(userName);
            if (user != null ) {
                if (user.getPassword().equals(password)) {
                    final User connectedUser = new User(user.getUserName(),
                            user.getMail(),
                            user.getPhone(),
                            user.getTwitter(),
                            user.getFacebook(),
                            user.getLinkedin(),
                            null);
                    connectedUser.setId(user.getId());
                    return connectedUser;
                }
            }
        }

        return null;
    }

    @PutMapping("/")
    public User putUser(@RequestBody User user) {
        return userRepo.insert(user);
    }
}
