package com.example.lab2.Objects.Film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "film", schema = "public")
@Data
public class Film {
    @Id
    @Column(name = "film_name")
    private String filmName;
}
