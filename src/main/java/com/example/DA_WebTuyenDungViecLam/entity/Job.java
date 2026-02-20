package com.example.DA_WebTuyenDungViecLam.entity;

import jakarta.persistence.*;
import com.example.DA_WebTuyenDungViecLam.enums.JobLevel;
import com.example.DA_WebTuyenDungViecLam.enums.JobStatus;
import com.example.DA_WebTuyenDungViecLam.enums.JobType;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ================== RELATION ================== */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /* ================== BASIC INFO ================== */

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    @Column(columnDefinition = "TEXT")
    private String benefits;

    /* ================== ENUM ================== */

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type", nullable = false)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_level")
    private JobLevel jobLevel = JobLevel.ANY;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.DRAFT;

    /* ================== SALARY ================== */

    @Column(name = "salary_min")
    private Long salaryMin;

    @Column(name = "salary_max")
    private Long salaryMax;

    @Column(name = "is_negotiable")
    private Boolean negotiable = false;

    /* ================== LOCATION ================== */

    @Column(nullable = false, length = 500)
    private String location;

    @Column(nullable = false, length = 100)
    private String city;

    /* ================== OTHER ================== */

    private Integer positions = 1;

    private LocalDate deadline;

    private Integer views = 0;

    
}
