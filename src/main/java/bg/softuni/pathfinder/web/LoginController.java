package bg.softuni.pathfinder.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {



    @GetMapping("users/login")
    public String viewLogin() {
        return "login";
    }

    @PostMapping("users/login")
    public String login() {

        return "login";
    }

}
