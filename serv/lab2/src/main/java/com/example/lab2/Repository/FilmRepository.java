package com.example.lab2.Repository;

import com.example.lab2.Objects.Film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, String> {
    Film findByFilmName(String filmName);
}