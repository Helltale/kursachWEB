package com.example.lab2.Objects.Hall;

import com.example.lab2.Objects.Cinema.Cinema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hall")
@IdClass(HallId.class)
public class Hall {

    @Id
    @Column(name = "hall_number")
    private int hallNumber;

    @Id
    @Column(name = "cinema_id")
    private Long cinemaId;

    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id", insertable = false, updatable = false)
    private Cinema cinema;

    @Column(name = "hall_sits")
    private int hallSits;

    // Геттеры, сеттеры и другие методы класса
}

