package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Admin id  of the admin
    private Long adminId;

    @Column(nullable = false, length = 50) // Name of the admin
    @NotEmpty(message = "Admin name should not be empty.")
    private String name;

    @Column(nullable = false, length = 50) // Last name of the admin
    @NotEmpty(message = "Admin last name should not be empty.")
    private String lastName;

    @Column(nullable = false, length = 24) // Password of the admin
    @NotEmpty(message = "Password should not be empty.")
    private String password;

    @Column(nullable = false) // Birthdate of the admin
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    @NotEmpty(message = "Birth Date should not be empty")
    private LocalDateTime birthDate;

    @Column(nullable = true)
    private String photoUrl;

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
