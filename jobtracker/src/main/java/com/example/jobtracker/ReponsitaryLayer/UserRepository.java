package com.example.jobtracker.ReponsitaryLayer;
import com.example.jobtracker.EntityLayer.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
