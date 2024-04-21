package com.example.lab2.Objects.Place;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlacePojo {
    private Long placeId;
    private String placeStreet;
    private String placeArea;
    private String placeHouse;

    public static Place toEntity(PlacePojo pojo) {
        Place place = new Place();
        place.setPlaceId(pojo.getPlaceId());
        place.setPlaceStreet(pojo.getPlaceStreet());
        place.setPlaceArea(pojo.getPlaceArea());
        place.setPlaceHouse(pojo.getPlaceHouse());
        return place;
    }

    public static PlacePojo fromEntity(Place place) {
        PlacePojo pojo = new PlacePojo();
        pojo.setPlaceId(place.getPlaceId());
        pojo.setPlaceStreet(place.getPlaceStreet());
        pojo.setPlaceArea(place.getPlaceArea());
        pojo.setPlaceHouse(place.getPlaceHouse());
        return pojo;
    }
}