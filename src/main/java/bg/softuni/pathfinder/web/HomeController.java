package bg.softuni.pathfinder.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Random;

@Controller
public class HomeController {


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mnv = new ModelAndView();
        double sofiaTemp = new Random().nextDouble();

        ModelAndView mvn = new ModelAndView();
        mnv.setViewName("index");
        mnv.addObject("sofiaTemp", sofiaTemp);

        return mnv;
    }

}
