package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("users/register")
    public String viewRegister(Model model) {

        model.addAttribute("registerData", new UserRegisterDTO());
        model.addAttribute("levels", Level.values());
        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            // returns all data in the form
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.UserRegistrationDTO", bindingResult);

            // handle errors
            return "redirect:/users/register";
        }

        userService.register(data);

        return "redirect:/users/login";
    }
}
