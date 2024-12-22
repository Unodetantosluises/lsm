package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_Id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_Id", nullable = false)
    private Course course;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime enrollmentDate;
}
