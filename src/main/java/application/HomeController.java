package application;

import data.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    PeopleRepository peopleRepo;

    @RequestMapping("/")
    public String home(PeopleRepository repo, Model model) {
        model.addAttribute("Name", "Adrien");
        return "home";
    }

}
