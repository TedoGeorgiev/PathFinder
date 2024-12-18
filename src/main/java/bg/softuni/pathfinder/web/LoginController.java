package bg.softuni.pathfinder.web;


import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/login")
    public ModelAndView viewLogin() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }

    @PostMapping("users/login")
    public String login(UserLoginDTO loginData) {
        userService.login(loginData);

        return "redirect:/";

    }

}
