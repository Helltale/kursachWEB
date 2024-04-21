package com.example.lab2.Objects.Cinema;

import com.example.lab2.Objects.Place.Place;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long cinemaId;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    private Place place;

    @Column(name = "cinema_name")
    private String cinemaName;

    @Column(name = "cinema_phone", unique = true)
    private String cinemaPhone;
}
