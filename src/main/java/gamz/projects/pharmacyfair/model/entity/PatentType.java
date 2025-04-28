package gamz.projects.pharmacyfair.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patent_types")
public class PatentType {
    @Id
    @SequenceGenerator(name = "patent_types_local_seq", sequenceName = "patent_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patent_types_local_seq")
    private long id;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "type_name")
    private String typeName;

    private String description;

    @OneToMany(mappedBy = "patentType")
    private List<Patent> patents;
} 