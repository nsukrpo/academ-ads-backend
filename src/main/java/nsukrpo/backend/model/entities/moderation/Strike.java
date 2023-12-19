package nsukrpo.backend.model.entities.moderation;

import jakarta.persistence.*;
import lombok.*;
import nsukrpo.backend.model.entities.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Strikes\"", schema = "academ")
public class Strike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "\"user\"")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "reason")
    private Reason reason;
}
