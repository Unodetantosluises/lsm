package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Lesson id
    private Long lessonId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)  // Course id this lesson belongs
    private Course course;

    @Column(nullable = false, length = 100) // Title of the lesson
    @NotEmpty(message = "Lesson title should not be empty.")
    private String title;

    @Column(nullable = true, columnDefinition = "TEXT") // Instructions for the lesson
    private String instructions;

    @Column(nullable = false, length = 50) // Lesson type
    @Enumerated(EnumType.STRING)
    private LessonType type;

    @Column(nullable = true, columnDefinition = "TEXT") // Specific content(questions, multiple options, etc.)
    private String content;

    @Column(nullable = true, columnDefinition = "TEXT") // Multimedia (videos, audio, photo, etc.)
    private String media;

    @Column(nullable = false) // Creation date of the lesson
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(nullable = false) // Update date of the lesson
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
