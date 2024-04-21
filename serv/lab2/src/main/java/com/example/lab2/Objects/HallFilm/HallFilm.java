package com.example.lab2.Objects.HallFilm;

import com.example.lab2.Objects.Cinema.Cinema;
import com.example.lab2.Objects.Film.Film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "hall_film")
@IdClass(HallFilmId.class)
public class HallFilm {

    @Id
    @ManyToOne
    @JoinColumn(name = "film_name", referencedColumnName = "film_name")
    private Film film;

    @Id
    @Column(name = "hall_number")
    private int hallNumber;

    @Id
    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    private Cinema cinema;

    @Id
    @Column(name = "hall_film_datetime")
    private Timestamp hallFilmDatetime;

    @Column(name = "hall_film_ticket_price")
    private BigDecimal hallFilmTicketPrice;

    @Column(name = "hall_film_ticket_count")
    private int hallFilmTicketCount;

    // Другие поля и методы класса
}
