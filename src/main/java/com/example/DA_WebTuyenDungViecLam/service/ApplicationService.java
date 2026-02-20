package com.example.DA_WebTuyenDungViecLam.service;

import com.example.DA_WebTuyenDungViecLam.entity.Application;
import com.example.DA_WebTuyenDungViecLam.entity.Candidate;
import com.example.DA_WebTuyenDungViecLam.entity.Job;
import com.example.DA_WebTuyenDungViecLam.enums.ApplicationStatus;
import com.example.DA_WebTuyenDungViecLam.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public Application apply(Candidate candidate, Job job) {

        applicationRepository
                .findByCandidateIdAndJobId(candidate.getId(), job.getId())
                .ifPresent(a -> {
                    throw new RuntimeException("Ứng viên đã ứng tuyển công việc này");
                });

        Application app = new Application();
        app.setCandidate(candidate);
        app.setJob(job);
        app.setStatus(ApplicationStatus.PENDING);

        return applicationRepository.save(app);
    }

    public Application updateStatus(Long id, ApplicationStatus status) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn"));

        app.setStatus(status);
        return applicationRepository.save(app);
    }
    @Transactional
public Application cancel(Long applicationId) {

    Application app = applicationRepository.findById(applicationId)
            .orElseThrow(() -> new RuntimeException("Application not found"));

    if (app.getStatus() == ApplicationStatus.CANCELED) {
        throw new RuntimeException("Application already canceled");
    }

    app.setStatus(ApplicationStatus.CANCELED);

    return applicationRepository.save(app);
}

}
