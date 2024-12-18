package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.web.dto.UserLoginDTO;
import bg.softuni.pathfinder.web.dto.UserRegisterDTO;

public interface UserService {

    void register(UserRegisterDTO userRegisterDTO);

    void login(UserLoginDTO loginData);
}
