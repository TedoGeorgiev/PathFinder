package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.web.dto.UserRegisterDTO;

public interface UserService {

    void register(UserRegisterDTO userRegisterDTO);
}
