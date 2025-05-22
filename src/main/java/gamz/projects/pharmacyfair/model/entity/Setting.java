package gamz.projects.pharmacyfair.model.entity;

import gamz.projects.pharmacyfair.util.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "settings")
@Getter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Setting {
    @Id
    @SequenceGenerator(name = "settings_local_seq", sequenceName = "settings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settings_local_seq")
    private long id;

    @Column(nullable = false, unique = true)
    private String key;

    @Column(nullable = false)
    private String value;

    private String description;

    @Enumerated(EnumType.STRING)
    private Constants.SettingType type;
}
