package com.example.DA_WebTuyenDungViecLam.Controller;

import com.example.DA_WebTuyenDungViecLam.entity.Job;
import com.example.DA_WebTuyenDungViecLam.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public Job create(@RequestBody Job job) {
        return jobService.create(job);
    }

    @GetMapping
    public List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id) {
        return jobService.getById(id);
    }
    @PutMapping("/{id}")
    public Job update(
            @PathVariable Long id,
            @RequestBody Job job
    ) {
        return jobService.update(id, job);
    }
}
