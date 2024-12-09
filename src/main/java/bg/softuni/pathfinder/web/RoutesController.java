package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoutesController {

    private final RouteService routeService;

    @Autowired
    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {

//        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAll();
        model.addAttribute("allRoutes", routes);

        return "routes";
    }

}
