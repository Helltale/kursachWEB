package com.example.lab2.Controller;

import com.example.lab2.Objects.HallFilm.HallFilm;
import com.example.lab2.Objects.HallFilm.HallFilmPojo;
import com.example.lab2.Service.ServiceHallFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/hallfilm")
public class HallFilmController {

    @Autowired
    private ServiceHallFilm serviceHallFilm;

    @PostMapping("/create")
    public HallFilm createHallFilm(@RequestBody HallFilmPojo hallFilmPojo) {
        return serviceHallFilm.createHallFilm(hallFilmPojo);
    }

    @DeleteMapping("/delete")
    public void deleteHallFilm(@RequestParam String filmName,
                                @RequestParam int hallNumber,
                                @RequestParam Long cinemaId,
                                @RequestParam Timestamp hallFilmDatetime) {
        serviceHallFilm.deleteHallFilm(filmName, hallNumber, cinemaId, hallFilmDatetime);
    }

    @PutMapping("/update")
    public HallFilm updateHallFilm(@RequestParam String filmName,
                                    @RequestParam int hallNumber,
                                    @RequestParam Long cinemaId,
                                    @RequestParam Timestamp hallFilmDatetime,
                                    @RequestBody HallFilmPojo hallFilmPojo) {
        return serviceHallFilm.updateHallFilm(filmName, hallNumber, cinemaId, hallFilmDatetime, hallFilmPojo);
    }

    @GetMapping("/findByDate")
    public List<HallFilm> findHallFilmsByDate(@RequestParam Timestamp hallFilmDatetime) {
        return serviceHallFilm.findHallFilmsByDate(hallFilmDatetime);
    }

    @GetMapping("/findByFilmName")
    public List<HallFilm> findAllByFilmName(@RequestParam String filmName) {
        return serviceHallFilm.findAllByFilmName(filmName);
    }

    @GetMapping("/findByDateTime")
    public List<HallFilm> findAllByDateTime(@RequestParam Timestamp dateTime) {
        return serviceHallFilm.findAllByDateTime(dateTime);
    }
}
