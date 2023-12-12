package nsukrpo.backend.model.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nsukrpo.backend.model.entities.advertisement.Category;
import nsukrpo.backend.model.entities.moderation.Block;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Users\"", schema = "academ")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar")
    private UserAvatar avatar;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private UserType type;

    @Column(name = "\"regDate\"")
    private Date regDate;

    @Column(name = "\"login\"")
    private String login;

    @Column(name = "\"password_hash\"")
    private Integer passwordHash;

    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "\"SubscriptionsUser\"",
            joinColumns = @JoinColumn(name = "\"userSubject\""),
            inverseJoinColumns = @JoinColumn(name = "\"userObject\"")
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
    @JoinTable(name = "\"SubscriptionsCategory\"",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private Set<Category> categories = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "from" , orphanRemoval = true, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Message> messagesFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "to" , orphanRemoval = true, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Message> messagesTo;

    @ToString.Exclude
    @OneToMany(mappedBy = "seller" , orphanRemoval = true, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Purchase> sales;

    @ToString.Exclude
    @OneToMany(mappedBy = "buyer" , orphanRemoval = true, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Purchase> purchase;

    @ToString.Exclude
    @OneToMany(mappedBy = "user" , orphanRemoval = true, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Block> blocks;

    //  performance bruh moment
    public boolean isBlocked(){
        var now = LocalDateTime.now();
        for (var b : blocks){
            if (b.getBlockDate().toLocalDateTime().plusMinutes(b.getTime()).isAfter(now)){
                return true;
            }
        }
        return false;
    }

}
