package com.example.DA_WebTuyenDungViecLam.Config;

import com.example.DA_WebTuyenDungViecLam.entity.Application;
import com.example.DA_WebTuyenDungViecLam.repository.ApplicationRepository;
import com.example.DA_WebTuyenDungViecLam.repository.CandidateRepository;
import com.example.DA_WebTuyenDungViecLam.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
@Configuration
public class TestDataRunner {

    @Bean
    @Transactional
    CommandLineRunner testDb(
            CandidateRepository candidateRepo,
            JobRepository jobRepo,
            ApplicationRepository applicationRepo
    ) {
        return args -> {
            var candidate = candidateRepo.findById(1L).orElseThrow();
            var job = jobRepo.findById(1L).orElseThrow();

            if (!applicationRepo.existsByCandidateIdAndJobId(1L, 1L)) {
                Application app = new Application();
                app.setCandidate(candidate);
                app.setJob(job);
                applicationRepo.save(app);

                System.out.println("✅ Apply job thành công");
            } else {
                System.out.println("⚠️ Candidate đã apply job này rồi");
            }
        };
    }
}
