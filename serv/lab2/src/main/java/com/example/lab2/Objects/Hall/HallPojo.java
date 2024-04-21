package com.example.lab2.Objects.Hall;

import com.example.lab2.Objects.Cinema.CinemaPojo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class HallPojo {
    private int hallNumber;
    private CinemaPojo cinema;
    private int hallSits;

    public static Hall toEntity(HallPojo pojo) {
        Hall hall = new Hall();
        hall.setHallNumber(pojo.getHallNumber());
        hall.setCinema(CinemaPojo.toEntity(pojo.getCinema()));
        hall.setHallSits(pojo.getHallSits());
        return hall;
    }

    public static HallPojo fromEntity(Hall hall) {
        HallPojo pojo = new HallPojo();
        pojo.setHallNumber(hall.getHallNumber());
        pojo.setCinema(CinemaPojo.fromEntity(hall.getCinema()));
        pojo.setHallSits(hall.getHallSits());
        return pojo;
    }
}
