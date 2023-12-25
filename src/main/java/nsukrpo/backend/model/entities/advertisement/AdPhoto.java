package nsukrpo.backend.model.entities.advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.BinaryJdbcType;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"AdsPhotos\"", schema = "academ")
public class AdPhoto {

    @Id
    private Long ads;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ads")
    private Advertisement advertisement;

    @ToString.Exclude
    @Lob
    @NotNull
    @JdbcType(BinaryJdbcType.class)
    private byte[] photo;
}
