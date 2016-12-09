package application;

import data.People;
import data.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @Autowired
    PeopleRepository repo;

    @RequestMapping("/profile")
    public String profile(Model model){
        //repo.save(new People("Sarah", "Wissocq", "sw@mail.com", "06 66 66 66 66")); -> permet de tester
        People people;
        people = repo.findAll().get(0);
        model.addAttribute("LastName", people.getLastName());
        model.addAttribute("FirstName", people.getFirstName());
        model.addAttribute("Email", people.getEmail());
        model.addAttribute("Phone", people.getPhone());
        return "profile";
    }
}
