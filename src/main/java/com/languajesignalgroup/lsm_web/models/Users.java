package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // User id
    @Column(name = "id")
    private Long userId;

    @Column(name = "name", nullable = false, length = 50) // User name
    @NotEmpty(message = "User Name should not be empty.")
    private String userName;

    @Column(name = "last_name", nullable = false, length = 50) // User last name
    @NotEmpty(message = "User Last Name should not be empty.")
    private String userLastName;

    @Column(name = "email", nullable = false, length = 150, unique = true) // User email
    @NotEmpty(message = "User Email should not be empty.")
    @Email(message = "Should be a validate email.")
    private String emailUser;

    @Column(name = "password", nullable = false) // User password
    @NotEmpty(message = "User Password should not be empty.")
    private String password;

    @Column(name = "birth_date", nullable = false) // User birthdate
    @NotEmpty(message = "User Birthdate should not be empty.")
    @PastOrPresent(message = "Date of birth can be on the future.")
    private LocalDate birthdateUser;

    @Column(name = "photo_url") // User photo
    private String userPhotoUrl;

    @Column(name = "active", nullable = false) //User status
    private Boolean active = true;

    @Column(name = "registration_date", nullable = false) // User registration date
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(name = "updated_on", nullable = false) // User registration updated
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Course> createdCourses = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Diploma> diplomas = new ArrayList<>();
}
