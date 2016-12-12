package application;

import application.forms.EditProfileForm;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EditProfileController {

    public static final String PAGE_NAME = "editProfile";
    @Autowired
    UserRepository repo;

    @GetMapping(path="/editProfile")
    public String editprofileForm(Model model, HttpSession session) {
        final User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            model.addAttribute("currentUser", currentUser);
            return PAGE_NAME;
        } else {
            return "redirect:signin";
        }
    }

    @PostMapping(path="/editProfile")
    public String editprofile(@Valid EditProfileForm form, BindingResult results, HttpSession session) {
        if (results.hasErrors()) {
            return PAGE_NAME;
        }

        final User user = (User) session.getAttribute("currentUser");
        user.setMail(form.getMail());
        user.setPhone(form.getPhone());
        user.setPassword(form.getPassword());
        user.setFacebook(form.getFacebook());
        user.setLinkedin(form.getLinkedin());
        user.setTwitter(form.getTwitter());
        RestTemplate template = new RestTemplate();
        template.put("http://localhost:8080/api/user/" + user.getUserName() + "/" + form.getPassword(), user);
        return "redirect:/";
    }
}
