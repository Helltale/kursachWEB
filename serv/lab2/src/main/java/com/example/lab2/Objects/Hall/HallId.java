package com.example.lab2.Objects.Hall;

import java.io.Serializable;

public class HallId implements Serializable {

    private int hallNumber;
    private Long cinemaId;

    public HallId() {
    }

    public HallId(int hallNumber, Long cinemaId) {
        this.hallNumber = hallNumber;
        this.cinemaId = cinemaId;
    }

    // Геттеры и сеттеры
    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallId hallId = (HallId) o;
        return hallNumber == hallId.hallNumber &&
                cinemaId.equals(hallId.cinemaId);
    }

    
}


