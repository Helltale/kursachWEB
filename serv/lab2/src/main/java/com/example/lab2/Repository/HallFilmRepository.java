package com.example.lab2.Repository;

import com.example.lab2.Objects.HallFilm.HallFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HallFilmRepository extends JpaRepository<HallFilm, Long> {
    // Метод для поиска фильмов по дате в поле hall_film_datetime
    List<HallFilm> findByHallFilmDatetime(Timestamp hallFilmDatetime);

    // Метод для поиска фильма по названию, номеру зала, идентификатору кинотеатра и дате фильма
    @Query("SELECT hf FROM HallFilm hf WHERE hf.film.filmName = :filmName AND hf.hallNumber = :hallNumber AND hf.cinema.id = :cinemaId AND hf.hallFilmDatetime = :hallFilmDatetime")
    HallFilm findByFilmNameAndHallNumberAndCinemaIdAndHallFilmDatetime(@Param("filmName") String filmName, @Param("hallNumber") int hallNumber, @Param("cinemaId") Long cinemaId, @Param("hallFilmDatetime") Timestamp hallFilmDatetime);

    // Метод для поиска всех HallFilm по совпадающему названию фильма
    List<HallFilm> findAllByFilmFilmName(String filmName);

    // Метод для поиска всех HallFilm, у которых была такая же дата в datetime
    List<HallFilm> findAllByHallFilmDatetime(Timestamp hallFilmDatetime);
}
