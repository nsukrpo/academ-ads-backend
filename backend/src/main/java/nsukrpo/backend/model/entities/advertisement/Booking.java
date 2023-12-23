package nsukrpo.backend.model.entities.advertisement;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nsukrpo.backend.model.entities.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Bookings\"", schema = "academ")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "claimant")
    private User claimant;

    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ads")
    private Advertisement ads;

    @NotNull
    @Column(name = "\"dateStart\"")
    private Timestamp dateStart;

    @NotNull
    @Column(name = "\"dateUntil\"")
    private Timestamp dateUntil;
}
