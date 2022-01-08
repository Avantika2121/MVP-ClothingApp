package com.clothingapp.clothingapp.repository;

import com.clothingapp.clothingapp.model.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeasonsRepository extends JpaRepository<Seasons, Long> {
    Optional<Seasons> findByName(String name);
    Optional<Seasons> findById(Long id);
}
