package com.example.DA_WebTuyenDungViecLam.repository;
import com.example.DA_WebTuyenDungViecLam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
