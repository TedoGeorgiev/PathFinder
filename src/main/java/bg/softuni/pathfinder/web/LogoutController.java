package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/logout")
    public String logout() {

        userService.logout();
        return "redirect:/";
    }

}
