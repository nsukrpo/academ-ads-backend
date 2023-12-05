package nsukrpo.backend.model.entities.moderation;

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
@Table(name = "\"Blockings\"", schema = "academ")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "reason")
    private Reason reason;

    @NotNull
    private Integer time;

    @NotNull
    @Column(name = "\"blockDate\"")
    private Timestamp blockDate;
}
