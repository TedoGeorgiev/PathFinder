package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller to handle all things route related
 */

@Controller
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * Method to handle the listing of all routes.
     *
     * @return the list routes view
     */

    @GetMapping("/routes")
    public String routes(Model model) {

//        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAll();
        model.addAttribute("allRoutes", routes);

        return "routes";
    }

}
