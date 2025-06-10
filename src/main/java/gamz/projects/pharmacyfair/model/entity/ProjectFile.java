package gamz.projects.pharmacyfair.model.entity;

import gamz.projects.pharmacyfair.model.entity.projects.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_files")
public class ProjectFile {
    @Id
    @SequenceGenerator(name = "project_files_seq", sequenceName = "project_files_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_files_local_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "file_type_id", referencedColumnName = "id")
    private FileType fileType;

    @Column(name = "file_size")
    private Long size;

    @Column(name = "mime_type")
    private String mimeType;

    @Builder.Default
    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;
}