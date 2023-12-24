package nsukrpo.backend.model.entities.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nsukrpo.backend.model.entities.advertisement.Advertisement;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Favourites\"", schema = "academ")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "\"user\"")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ads")
    private Advertisement ads;

    @NotNull
    @Column(name = "\"dateAdd\"")
    private Timestamp dateAdd;
}
