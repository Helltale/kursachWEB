package com.example.lab2.Repository;

import com.example.lab2.Objects.Cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    // Метод для поиска кинотеатра по его имени
    Cinema findByCinemaName(String cinemaName);
}
