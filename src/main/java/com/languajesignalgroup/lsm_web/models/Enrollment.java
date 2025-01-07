package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enrollment id of the user
    @Column(name = "id")
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // User id of the user from table user
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) //user
    private Course course;

    @Column(name = "enrollment_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime enrollmentDate;

    @Column(name = "disenrollment_date")
    @UpdateTimestamp
    private LocalDateTime disenrollmentDate;
}
