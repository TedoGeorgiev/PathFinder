package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;

}
