package com.example.lab2.Controller;

import com.example.lab2.Objects.Film.Film;
import com.example.lab2.Objects.Film.FilmPojo;
import com.example.lab2.Service.ServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private ServiceFilm serviceFilm;

    @PostMapping("/create")
    public Film createFilm(@RequestBody FilmPojo filmPojo) {
        return serviceFilm.createFilm(filmPojo);
    }

    @DeleteMapping("/delete/{filmName}")
    public void deleteFilm(@PathVariable String filmName) {
        serviceFilm.deleteFilm(filmName);
    }

    @GetMapping("/findByName/{filmName}")
    public Film findFilmByName(@PathVariable String filmName) {
        return serviceFilm.findFilmByName(filmName);
    }
}
