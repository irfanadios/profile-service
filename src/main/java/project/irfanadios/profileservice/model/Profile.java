package project.irfanadios.profileservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "profile")
@EntityListeners({AuditingEntityListener.class})
public class Profile {
    @Id
    @Column(name = "user_id", unique = true, nullable = false, updatable = false)
    private UUID userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "bio")
    private String bio;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
