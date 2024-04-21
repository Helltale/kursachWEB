package com.example.lab2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lab2.Objects.Cinema.Cinema;
import com.example.lab2.Objects.Cinema.CinemaPojo;
import com.example.lab2.Repository.CinemaRepository;

@Service
@Transactional
public class ServiceCinema {

    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema createCinema(CinemaPojo cinemaPojo) {
        // Преобразование объекта CinemaPojo в Cinema
        Cinema cinema = CinemaPojo.toEntity(cinemaPojo);
        return cinemaRepository.save(cinema); // Сохранение кинотеатра в базе данных и возврат сохраненного объекта
    }

    public void deleteCinema(Long cinemaId) {
        // Поиск кинотеатра по идентификатору
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new IllegalArgumentException("Кинотеатр с идентификатором " + cinemaId + " не найден"));
        cinemaRepository.delete(cinema); // Удаление кинотеатра из базы данных
    }

    public Cinema updateCinema(Long cinemaId, CinemaPojo cinemaPojo) {
        // Поиск кинотеатра по идентификатору
        Cinema existingCinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new IllegalArgumentException("Кинотеатр с идентификатором " + cinemaId + " не найден"));

        // Обновление данных кинотеатра из объекта CinemaPojo
        existingCinema.setCinemaName(cinemaPojo.getCinemaName());
        existingCinema.setCinemaPhone(cinemaPojo.getCinemaPhone());

        return cinemaRepository.save(existingCinema); // Сохранение обновленного кинотеатра в базе данных и возврат объекта
    }

    public Cinema findCinemaByName(String cinemaName) {
        return cinemaRepository.findByCinemaName(cinemaName);
    }

    public Cinema findCinemaById(Long cinemaId) {
        return cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new IllegalArgumentException("Кинотеатр с указанным идентификатором не найден"));
    }
}