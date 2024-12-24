package com.languajesignalgroup.lsm_web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // User id
    private Long userId;

    @Column(nullable = false, length = 50) // User name
    @NotEmpty(message = "User Name should not be empty.")
    private String userName;

    @Column(nullable = false, length = 50) // User last name
    @NotEmpty(message = "User Last Name should not be empty.")
    private String userLastName;

    @Column(nullable = false, length = 150) // User email
    @NotEmpty(message = "User Email should not be empty.")
    private String emailUser;

    @Column(nullable = false) // User password
    @NotEmpty(message = "User Password should not be empty.")
    private String password;

    @Column(nullable = false) // User birthdate
    @NotEmpty(message = "User Birthdate should not be empty.")
    private LocalDateTime birthdateUser;

    @Column // User photo
    private String userPhotoUrl;

    @Column(nullable = false) //User status
    @Builder.Default
    private boolean active = false;

    @Column(nullable = false) // User registration date
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(nullable = false) // User registration updated
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name ="role_id", referencedColumnName = "rolId")}
    )
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Diploma> diplomas = new ArrayList<>();
}
