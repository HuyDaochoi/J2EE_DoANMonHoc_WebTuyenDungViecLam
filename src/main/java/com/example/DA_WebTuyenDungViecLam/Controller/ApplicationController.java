package com.example.DA_WebTuyenDungViecLam.Controller;

import com.example.DA_WebTuyenDungViecLam.entity.Application;
import com.example.DA_WebTuyenDungViecLam.entity.Candidate;
import com.example.DA_WebTuyenDungViecLam.entity.Job;
import com.example.DA_WebTuyenDungViecLam.enums.ApplicationStatus;
import com.example.DA_WebTuyenDungViecLam.repository.CandidateRepository;
import com.example.DA_WebTuyenDungViecLam.repository.JobRepository;
import com.example.DA_WebTuyenDungViecLam.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;

    @PostMapping("/apply")
    public Application apply(
            @RequestParam Long candidateId,
            @RequestParam Long jobId
    ) {
        Candidate c = candidateRepository.findById(candidateId).orElseThrow();
        Job j = jobRepository.findById(jobId).orElseThrow();
        return applicationService.apply(c, j);
    }

    @PutMapping("/{id}/status")
    public Application updateStatus(
            @PathVariable Long id,
            @RequestParam ApplicationStatus status
    ) {
        return applicationService.updateStatus(id, status);
    }
   @PostMapping("/{id}/cancel")
public Application cancel(@PathVariable Long id) {
    return applicationService.cancel(id);
}

}
