package com.example.DA_WebTuyenDungViecLam.repository;

import com.example.DA_WebTuyenDungViecLam.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findBySlug(String slug);

    boolean existsBySlug(String slug);
}
