package com.example.lab2.Service;

import com.example.lab2.Objects.Film.Film;
import com.example.lab2.Objects.Film.FilmPojo;
import com.example.lab2.Repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ServiceFilm {

    @Autowired
    private FilmRepository filmRepository;

    public Film createFilm(FilmPojo filmPojo) {
        // Преобразование объекта FilmPojo в Film
        Film film = FilmPojo.toEntity(filmPojo);
        return filmRepository.save(film); // Сохранение фильма в базе данных и возврат сохраненного объекта
    }

    public void deleteFilm(String filmName) {
        // Поиск фильма по названию
        Film film = filmRepository.findByFilmName(filmName);
        if (film != null) {
            filmRepository.delete(film); // Удаление фильма из базы данных
        } else {
            throw new IllegalArgumentException("Фильм с названием " + filmName + " не найден");
        }
    }

    public Film findFilmByName(String filmName) {
        return filmRepository.findByFilmName(filmName);
    }
}
