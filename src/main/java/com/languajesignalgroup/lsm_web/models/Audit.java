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
@Table(name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @Column(nullable = false, length = 50)
    private String actionType;

    @Column(nullable = false, length = 50)
    private String tableName;

    @Column(nullable = false)
    private Integer recordId;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime actionDate;

    @Column(length = 255)
    private String description;
}
