package com.example.DA_WebTuyenDungViecLam.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.DA_WebTuyenDungViecLam.enums.SkillCategory;
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

  
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillCategory category = SkillCategory.OTHER;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getter / setter
}
