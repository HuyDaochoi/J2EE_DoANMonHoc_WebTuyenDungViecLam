package com.example.DA_WebTuyenDungViecLam.service;

import com.example.DA_WebTuyenDungViecLam.entity.Candidate;
import com.example.DA_WebTuyenDungViecLam.entity.User;
import com.example.DA_WebTuyenDungViecLam.repository.CandidateRepository;
import com.example.DA_WebTuyenDungViecLam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    // CREATE
    public Candidate create(Long userId, Candidate data) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        data.setUser(user);
        return candidateRepository.save(data);
    }

    // READ ALL
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    // READ ONE
    public Candidate getById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    // UPDATE
    public Candidate update(Long id, Candidate data) {
        Candidate candidate = getById(id);
        candidate.setBio(data.getBio());
        candidate.setCvUrl(data.getCvUrl());
        candidate.setYearsOfExperience(data.getYearsOfExperience());
        return candidateRepository.save(candidate);
    }

    // DELETE
    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }
}
