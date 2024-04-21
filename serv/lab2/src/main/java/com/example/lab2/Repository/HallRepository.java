package com.example.lab2.Repository;

import com.example.lab2.Objects.Hall.Hall;
import com.example.lab2.Objects.Hall.HallId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall, HallId> {

    Optional<Hall> findById(HallId hallId);
    
    // Другие методы репозитория
}
