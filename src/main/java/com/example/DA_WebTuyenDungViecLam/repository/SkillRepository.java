package com.example.DA_WebTuyenDungViecLam.repository;
import com.example.DA_WebTuyenDungViecLam.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    boolean existsByName(String name);
}
