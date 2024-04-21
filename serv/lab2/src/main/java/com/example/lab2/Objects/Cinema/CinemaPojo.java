package com.example.lab2.Objects.Cinema;

import com.example.lab2.Objects.Place.PlacePojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CinemaPojo {
    private Long cinemaId;
    private PlacePojo place; // Добавлено поле для места (PlacePojo)
    private String cinemaName;
    private String cinemaPhone;

    public static Cinema toEntity(CinemaPojo pojo) {
        Cinema cinema = new Cinema();
        cinema.setCinemaId(pojo.getCinemaId());
        cinema.setPlace(PlacePojo.toEntity(pojo.getPlace())); // Предположим, что у вас есть метод toEntity в классе PlacePojo
        cinema.setCinemaName(pojo.getCinemaName());
        cinema.setCinemaPhone(pojo.getCinemaPhone());
        return cinema;
    }

    public static CinemaPojo fromEntity(Cinema cinema) {
        CinemaPojo pojo = new CinemaPojo();
        pojo.setCinemaId(cinema.getCinemaId());
        pojo.setPlace(PlacePojo.fromEntity(cinema.getPlace())); // Предположим, что у вас есть метод fromEntity в классе PlacePojo
        pojo.setCinemaName(cinema.getCinemaName());
        pojo.setCinemaPhone(cinema.getCinemaPhone());
        return pojo;
    }
}
