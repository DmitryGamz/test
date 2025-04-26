package gamz.projects.pharmacyfair.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    private String email;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "job_title")
    private String jobTitle;

    private String phone;

    @Column(name = "contact_sharing_consent")
    @ColumnDefault(value = "false")
    private boolean sharingConsent;

    @Column(name = "participation_status")
    @Enumerated(EnumType.STRING)
    private ParticipationStatus participationStatus;

    @Column(name = "verification_status")
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastLogin;

    @Column(name = "is_active")
    @ColumnDefault(value = "true")
    private boolean isActive;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "last_activity")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastActivity;

    @ManyToMany
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}