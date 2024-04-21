package com.example.lab2.Objects.HallFilm;

import com.example.lab2.Objects.Cinema.Cinema;
import com.example.lab2.Objects.Film.Film;

import java.io.Serializable;
import java.sql.Timestamp;

public class HallFilmId implements Serializable {
    private Film film;
    private int hallNumber;
    private Cinema cinema;
    private Timestamp hallFilmDatetime;

    // Конструктор, геттеры, сеттеры и другие методы
}
