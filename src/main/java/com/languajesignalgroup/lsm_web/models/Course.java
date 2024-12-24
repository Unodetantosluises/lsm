package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Course id
    private Long courseId;

    @Column(nullable = false, length = 80) // Course Name
    @NotEmpty(message = "Course name should not be empty.")
    private String courseName;

    @Column(nullable = false, length = 255) // Course Cover
    @NotEmpty(message = "Course cover should not be empty.")
    private String courseCover;

    @Column(nullable = false, length = 255) // Course Description
    @NotEmpty(message = "Course description should not be empty.")
    private String courseDescription;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Course category
    private Category category;

    @Column(nullable = false) // Course creation date
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(nullable = false) // Course update date
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)  // User creation info
    private User user;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Enrollment> enrollments = new ArrayList<>();
}
