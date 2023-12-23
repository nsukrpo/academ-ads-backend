package nsukrpo.backend.model.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Messages\"", schema = "academ")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String text;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "from")
    private User from;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "to")
    private User to;

    @NotNull
    private Timestamp date;

}
