package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column
    private Integer age;

    @Column(unique = true)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;


    @ManyToMany
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
    }
}
