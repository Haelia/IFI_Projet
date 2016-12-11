package application;

import application.forms.EditProfileForm;
import data.User;
import data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;


public class EditProfileController {

    public static final String PAGE_NAME = "editProfile";
    @Autowired
    UserRepository repo;

    @GetMapping(path="/editProfile")
    public String editprofileForm(EditProfileForm signupForm, Model model) {
        return PAGE_NAME;
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
        user.setFacebook(form.getFbId());
        user.setLinkedin(form.getLinkedinId());
        user.setTwitter(form.getTwitterId());
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        template.exchange("http://localhost:8080/api/user/" + user.getUserName(), HttpMethod.PATCH, entity, User.class);
        return "redirect:home";
    }
}
