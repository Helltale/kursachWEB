package com.example.lab2.Objects.HallFilm;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.example.lab2.Objects.Cinema.CinemaPojo; // Импортируем CinemaPojo
import com.example.lab2.Objects.Film.FilmPojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HallFilmPojo {
    private FilmPojo film;
    private int hallNumber;
    private CinemaPojo cinema; // Используем объект CinemaPojo
    private Timestamp hallFilmDatetime;
    private BigDecimal hallFilmTicketPrice;
    private int hallFilmTicketCount;

    public static HallFilm toEntity(HallFilmPojo pojo) {
        HallFilm hallFilm = new HallFilm();
        hallFilm.setFilm(FilmPojo.toEntity(pojo.getFilm()));
        hallFilm.setHallNumber(pojo.getHallNumber());
        hallFilm.setCinema(CinemaPojo.toEntity(pojo.getCinema())); 
        hallFilm.setHallFilmDatetime(pojo.getHallFilmDatetime());
        hallFilm.setHallFilmTicketPrice(pojo.getHallFilmTicketPrice());
        hallFilm.setHallFilmTicketCount(pojo.getHallFilmTicketCount());
        return hallFilm;
    }

    public static HallFilmPojo fromEntity(HallFilm hallFilm) {
        HallFilmPojo pojo = new HallFilmPojo();
        pojo.setFilm(FilmPojo.fromEntity(hallFilm.getFilm()));
        pojo.setHallNumber(hallFilm.getHallNumber());
        pojo.setCinema(CinemaPojo.fromEntity(hallFilm.getCinema())); 
        pojo.setHallFilmDatetime(hallFilm.getHallFilmDatetime());
        pojo.setHallFilmTicketPrice(hallFilm.getHallFilmTicketPrice());
        pojo.setHallFilmTicketCount(hallFilm.getHallFilmTicketCount());
        return pojo;
    }
}
