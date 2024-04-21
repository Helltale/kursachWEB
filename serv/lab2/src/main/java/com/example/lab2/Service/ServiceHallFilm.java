package com.example.lab2.Service;

import com.example.lab2.Objects.HallFilm.HallFilm;
import com.example.lab2.Objects.HallFilm.HallFilmPojo;
import com.example.lab2.Repository.HallFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ServiceHallFilm {

    @Autowired
    private HallFilmRepository hallFilmRepository;

    public HallFilm createHallFilm(HallFilmPojo hallFilmPojo) {
        // Преобразование объекта HallFilmPojo в HallFilm
        HallFilm hallFilm = HallFilmPojo.toEntity(hallFilmPojo);
        return hallFilmRepository.save(hallFilm); // Сохранение фильма в базе данных и возврат сохраненного объекта
    }

    public void deleteHallFilm(String filmName, int hallNumber, Long cinemaId, Timestamp hallFilmDatetime) {
        // Поиск фильма по указанным параметрам
        HallFilm hallFilm = hallFilmRepository.findByFilmNameAndHallNumberAndCinemaIdAndHallFilmDatetime(
                filmName, hallNumber, cinemaId, hallFilmDatetime);
        if (hallFilm != null) {
            hallFilmRepository.delete(hallFilm); // Удаление фильма из базы данных
        } else {
            throw new IllegalArgumentException("Фильм с указанными параметрами не найден");
        }
    }

    public HallFilm updateHallFilm(String filmName, int hallNumber, Long cinemaId, Timestamp hallFilmDatetime,
                                   HallFilmPojo hallFilmPojo) {
        // Поиск фильма по указанным параметрам
        HallFilm existingHallFilm = hallFilmRepository.findByFilmNameAndHallNumberAndCinemaIdAndHallFilmDatetime(
                filmName, hallNumber, cinemaId, hallFilmDatetime);
        if (existingHallFilm == null) {
            throw new IllegalArgumentException("Фильм с указанными параметрами не найден");
        }

        // Обновление данных фильма из объекта HallFilmPojo
        existingHallFilm.setHallFilmTicketPrice(hallFilmPojo.getHallFilmTicketPrice());
        existingHallFilm.setHallFilmTicketCount(hallFilmPojo.getHallFilmTicketCount());

        return hallFilmRepository.save(existingHallFilm); // Сохранение обновленного фильма в базе данных и возврат объекта
    }

    public List<HallFilm> findHallFilmsByDate(Timestamp hallFilmDatetime) {
        return hallFilmRepository.findByHallFilmDatetime(hallFilmDatetime);
    }

    // Метод для поиска всех HallFilm по совпадающему названию фильма
    public List<HallFilm> findAllByFilmName(String filmName) {
        return hallFilmRepository.findAllByFilmFilmName(filmName);
    }

    // Метод для поиска всех HallFilm, у которых была такая же дата в datetime
    public List<HallFilm> findAllByDateTime(Timestamp dateTime) {
        return hallFilmRepository.findAllByHallFilmDatetime(dateTime);
    }
}
