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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 24)
    private String password;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = false;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
