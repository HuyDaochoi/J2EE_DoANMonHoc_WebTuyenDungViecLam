package com.example.DA_WebTuyenDungViecLam.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.DA_WebTuyenDungViecLam.entity.Skill;
import com.example.DA_WebTuyenDungViecLam.repository.SkillRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillRepository skillRepository;
        @PostMapping
        //catregory cho enum
    public Skill create(@RequestBody Skill skill) {
        if (skillRepository.existsByName(skill.getName())) {
            throw new RuntimeException("Skill đã tồn tại");
        }
        return skillRepository.save(skill);
    }
    @GetMapping
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
    @GetMapping("/{id}")
    public Skill getById(@PathVariable Integer id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    @PutMapping("/{id}")
    public Skill update(@PathVariable Integer id, @RequestBody Skill skill) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        existing.setName(skill.getName());
        existing.setCategory(skill.getCategory());
        return skillRepository.save(existing);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        skillRepository.deleteById(id);
    }

}
