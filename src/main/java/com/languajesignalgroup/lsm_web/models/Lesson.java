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
    @Column(name = "id")
    private Long lessonId;

    @Column(name = "title", nullable = false, length = 100) // Title of the lesson
    @NotEmpty(message = "Lesson title should not be empty.")
    private String title;

    @Column(name = "instructions", nullable = false, columnDefinition = "TEXT") // Instructions for the lesson
    @NotEmpty(message = "Lesson instructions should not be empty.")
    private String instructions;

    @Column(name = "type", nullable = false, length = 50) // Lesson type
    @Enumerated(EnumType.STRING)
    private LessonType type;

    @Column(name = "content", columnDefinition = "TEXT") // Specific content(questions, multiple options, etc.)
    private String content;

    @Column(name = "media", columnDefinition = "TEXT") // Multimedia (videos, audio, photo, etc.)
    private String media;

    @Column(name = "creation_date", nullable = false) // Creation date of the lesson
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "update_date", nullable = false) // Update date of the lesson
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)  // Course id this lesson belongs
    private Course course;
}
