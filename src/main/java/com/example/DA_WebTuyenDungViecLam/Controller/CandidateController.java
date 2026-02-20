package com.example.DA_WebTuyenDungViecLam.Controller;

import com.example.DA_WebTuyenDungViecLam.entity.Candidate;
import com.example.DA_WebTuyenDungViecLam.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    // CREATE
    @PostMapping
    public Candidate create(
            @RequestParam Long userId,
            @RequestBody Candidate candidate
    ) {
        return candidateService.create(userId, candidate);
    }

    // READ ALL
    @GetMapping
    public List<Candidate> getAll() {
        return candidateService.getAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Candidate getById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Candidate update(
            @PathVariable Long id,
            @RequestBody Candidate candidate
    ) {
        return candidateService.update(id, candidate);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        candidateService.delete(id);
    }
}
