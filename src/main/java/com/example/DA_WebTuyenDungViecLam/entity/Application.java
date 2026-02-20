package com.example.DA_WebTuyenDungViecLam.entity;

import com.example.DA_WebTuyenDungViecLam.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(
    name = "applications",
    uniqueConstraints = {
        // tranh 1 don nop lai nhieu lan bi trung lap
        @UniqueConstraint(columnNames = {"candidate_id", "job_id"})
    }
)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
// tranmg thai
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(name = "applied_at", updatable = false)
    private LocalDateTime appliedAt;

    @PrePersist
    protected void onCreate() {
        this.appliedAt = LocalDateTime.now();
    }

}
