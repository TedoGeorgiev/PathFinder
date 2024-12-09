package bg.softuni.pathfinder.service;


import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;

import java.util.List;

public interface RouteService {


     RouteShortInfoDTO getRandomRoute ();

     List<RouteShortInfoDTO> getAll ();
}
