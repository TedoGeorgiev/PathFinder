package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private Instant created;

    @Column(name = "text_content", nullable = false, columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;


}
