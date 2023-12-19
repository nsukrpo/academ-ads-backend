package nsukrpo.backend.model.entities.advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.entities.user.User;

import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Advertisements\"", schema = "academ")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String header;

    @NotNull
    private String description;

    @NotNull
    private Double price;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @NotNull
    @Column(name = "\"publicationDate\"")
    private Timestamp publicationDate;

    @NotNull
    @Column(name = "\"countWatch\"")
    private Integer countWatch;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "\"status\"")
    private StatusAd status;

    @NotNull
    @Column(name = "\"editDate\"")
    private Timestamp editDate;

    public boolean isBooked(){
        return AdvStatus.valueOf(status.getName()) == AdvStatus.BOOKED;
    }


}
