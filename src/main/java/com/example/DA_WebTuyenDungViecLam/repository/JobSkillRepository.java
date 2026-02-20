package com.example.DA_WebTuyenDungViecLam.repository;

import com.example.DA_WebTuyenDungViecLam.entity.JobSkill;
import com.example.DA_WebTuyenDungViecLam.entity.ids.JobSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository
        extends JpaRepository<JobSkill, JobSkillId> {
}
