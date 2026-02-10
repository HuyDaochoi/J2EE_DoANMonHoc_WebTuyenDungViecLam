package com.example.DA_WebTuyenDungViecLam.repository;

import com.example.DA_WebTuyenDungViecLam.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByCandidateIdAndJobId(Long candidateId, Long jobId);

    boolean existsByCandidateIdAndJobId(Long candidateId, Long jobId);
}
