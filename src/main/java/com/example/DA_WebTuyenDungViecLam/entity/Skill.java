package com.example.DA_WebTuyenDungViecLam.entity;

import jakarta.persistence.*;
import com.example.DA_WebTuyenDungViecLam.enums.SkillCategory;
import lombok.Getter;
import lombok.Setter;   
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "skills")

public class Skill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

  
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillCategory category = SkillCategory.OTHER;

}
