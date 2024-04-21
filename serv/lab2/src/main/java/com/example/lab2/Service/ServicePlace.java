package com.example.lab2.Service;

import com.example.lab2.Objects.Place.Place;
import com.example.lab2.Objects.Place.PlacePojo;
import com.example.lab2.Repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ServicePlace {

    @Autowired
    private PlaceRepository placeRepository;

    public Place createPlace(PlacePojo placePojo) {
        // Преобразование объекта PlacePojo в Place
        Place place = PlacePojo.toEntity(placePojo);
        return placeRepository.save(place); // Сохранение места в базе данных и возврат сохраненного объекта
    }

    public void deletePlace(Long placeId) {
        // Поиск места по идентификатору
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("Место с идентификатором " + placeId + " не найдено"));
        placeRepository.delete(place); // Удаление места из базы данных
    }

    public Place updatePlace(Long placeId, PlacePojo placePojo) {
        // Поиск места по идентификатору
        Place existingPlace = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("Место с идентификатором " + placeId + " не найдено"));

        // Обновление данных места из объекта PlacePojo
        existingPlace.setPlaceStreet(placePojo.getPlaceStreet());
        existingPlace.setPlaceArea(placePojo.getPlaceArea());
        existingPlace.setPlaceHouse(placePojo.getPlaceHouse());

        return placeRepository.save(existingPlace); // Сохранение обновленного места в базе данных и возврат объекта
    }

    public Place findPlaceById(Long placeId) {
        return placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("Место с указанным идентификатором не найдено"));
    }
}
