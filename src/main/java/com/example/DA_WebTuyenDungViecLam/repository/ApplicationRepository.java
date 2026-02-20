package com.example.DA_WebTuyenDungViecLam.repository;

import com.example.DA_WebTuyenDungViecLam.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DA_WebTuyenDungViecLam.enums.ApplicationStatus;
import java.util.Optional;
import java.util.List;
public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    Optional<Application> findByCandidateIdAndJobId(
            Long candidateId,
            Long jobId
    );
//Nhà tuyển dụng xem danh sách ứng viên của job
    List<Application> findByJobId(Long jobId);
//Ứng viên xem các job mình đã nộp
    List<Application> findByCandidateId(Long candidateId);
//Admin / Employer lọc trạng thái
    List<Application> findByStatus(ApplicationStatus status);
}
