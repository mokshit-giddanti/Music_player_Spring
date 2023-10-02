package com.code.musicapi.V1_REg_and_Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegRepo extends JpaRepository<RegEntity, String> {
    Optional<RegEntity> findByEmail(String email);
}