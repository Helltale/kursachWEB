package com.example.lab2.Controller;

import com.example.lab2.Objects.Cinema.Cinema;
import com.example.lab2.Objects.Cinema.CinemaPojo;
import com.example.lab2.Service.ServiceCinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private ServiceCinema serviceCinema;

    @PostMapping("/create")
    public Cinema createCinema(@RequestBody CinemaPojo cinemaPojo) {
        return serviceCinema.createCinema(cinemaPojo);
    }

    @DeleteMapping("/delete/{cinemaId}")
    public void deleteCinema(@PathVariable Long cinemaId) {
        serviceCinema.deleteCinema(cinemaId);
    }

    @PutMapping("/update/{cinemaId}")
    public Cinema updateCinema(@PathVariable Long cinemaId, @RequestBody CinemaPojo cinemaPojo) {
        return serviceCinema.updateCinema(cinemaId, cinemaPojo);
    }

    @GetMapping("/findByName/{cinemaName}")
    public Cinema findCinemaByName(@PathVariable String cinemaName) {
        return serviceCinema.findCinemaByName(cinemaName);
    }

    @GetMapping("/findById/{cinemaId}")
    public Cinema findCinemaById(@PathVariable Long cinemaId) {
        return serviceCinema.findCinemaById(cinemaId);
    }
}
