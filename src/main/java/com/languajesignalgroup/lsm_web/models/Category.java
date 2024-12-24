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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, length = 50)
    private String categoryName;

    @Column(nullable = false)
    private String categoryDescription;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
