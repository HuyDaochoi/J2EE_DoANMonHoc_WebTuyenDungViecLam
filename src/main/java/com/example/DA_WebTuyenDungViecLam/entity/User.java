package com.example.DA_WebTuyenDungViecLam.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.example.DA_WebTuyenDungViecLam.enums.UserStatus;
import com.example.DA_WebTuyenDungViecLam.enums.UserRole;
import com.example.DA_WebTuyenDungViecLam.enums.AuthProvider;
import com.example.DA_WebTuyenDungViecLam.entity.BaseEntity;
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(length = 20)
    private String phone;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    // Google OAuth
    @Column(name = "google_id", unique = true, length = 100)
    private String googleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "last_seen")
    private LocalDateTime lastSeen;

   
}
