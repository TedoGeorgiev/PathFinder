package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @PostMapping("users/logout")
    public String logout() {

        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/users/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profileData", userService.getProfileData());

        return modelAndView;
    }

}
