package com.example.DA_WebTuyenDungViecLam.service;

import com.example.DA_WebTuyenDungViecLam.entity.Skill;
import com.example.DA_WebTuyenDungViecLam.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    // CREATE
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    // READ ALL
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    // READ ONE
    public Skill getById(Integer id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    // UPDATE
    public Skill update(Integer id, Skill data) {
        Skill skill = getById(id);
        skill.setName(data.getName());
        skill.setCategory(data.getCategory());
        return skillRepository.save(skill);
    }

    // DELETE
    public void delete(Integer id) {
        skillRepository.deleteById(id);
    }
}
