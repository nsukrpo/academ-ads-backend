package nsukrpo.backend.model.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nsukrpo.backend.model.entities.advertisement.Category;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Users\"", schema = "academ")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar")
    private UserAvatar avatar;

    @NotNull
    private Date regDate;

    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "SubscriptionsUser",
            joinColumns = @JoinColumn(name = "userSubject"),
            inverseJoinColumns = @JoinColumn(name = "userObject")
    )
    private Set<User> subscribedTo = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "subscribedTo")
    private Set<User> subscribedBy = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "SubscriptionsCategory",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private Set<Category> categories = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "from" , orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Message> messagesFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "to" , orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Message> messagesTo;

}
