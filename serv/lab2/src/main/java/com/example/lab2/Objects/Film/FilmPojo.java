package com.example.lab2.Objects.Film; 

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmPojo {
    private String film_name;

    public static Film toEntity(FilmPojo pojo) {
        Film film = new Film();
        film.setFilmName(pojo.getFilm_name());
        return film;
    }

    public static FilmPojo fromEntity(Film film) {
        FilmPojo pojo = new FilmPojo();
        pojo.setFilm_name(film.getFilmName());
        return pojo;
    }
}