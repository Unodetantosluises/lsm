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
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "student_Id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_Id", nullable = false)
    private Course course;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = true, length = 255)
    private String comment;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;
}
