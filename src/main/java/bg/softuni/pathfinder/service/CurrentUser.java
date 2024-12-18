package bg.softuni.pathfinder.service;


import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.UserRoles;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
// N.B.
// Scope_Request means only one instance will be given for every request
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
// SessionScope do the same as upper but for every session
@SessionScope
public class CurrentUser {

    private User user;

    public boolean isLoggedIn() {
        return user != null;
    }

    public boolean isAdmin() {
        return this.user
                .getRoles()
                .stream()
                .anyMatch(r -> r.getName().equals(UserRoles.ADMIN));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
