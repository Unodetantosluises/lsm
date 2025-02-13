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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Role id
    @Column(name = "id")
    private Long rolId;

    @Column(name = "name", nullable = false, length = 50) // Role name
    @NotEmpty(message = "User Role should not be empty.")
    private String rolName;

    @Column(name = "description", nullable = false, length = 255) // Role description
    @NotEmpty(message = "User Description should not be empty.")
    private String rolDescription;

    @Column(name = "active", nullable = false) // Role status
    @Builder.Default
    private boolean active = false;

    @Column(name = "creation_date", nullable = false) // Role creation date
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "updated_on", nullable = false) // Role update date
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();
}
