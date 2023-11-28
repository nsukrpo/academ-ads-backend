package nsukrpo.backend.model.entities.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Purchases\"", schema = "academ")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ads")
    private Advertisement ads;

    @NotNull
    private Double price;

    @NotNull
    private Timestamp date;
}
