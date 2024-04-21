package com.example.lab2.Controller;

import com.example.lab2.Objects.Hall.Hall;
import com.example.lab2.Objects.Hall.HallId;
import com.example.lab2.Objects.Hall.HallPojo;
import com.example.lab2.Service.ServiceHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private ServiceHall serviceHall;

    @PostMapping("/create")
    public Hall createHall(@RequestBody HallPojo hallPojo) {
        return serviceHall.createHall(hallPojo);
    }

    @DeleteMapping("/delete")
    public void deleteHall(@RequestParam int hallNumber, @RequestParam long cinemaId) {
        HallId hallId = new HallId(hallNumber, cinemaId);
        serviceHall.deleteHall(hallId);
    }

    @PutMapping("/update")
    public Hall updateHall(@RequestParam int hallNumber, @RequestBody HallPojo hallPojo, @RequestParam long cinemaId) {
        HallId hallId = new HallId(hallNumber, cinemaId);
        return serviceHall.updateHall(hallId, hallPojo);
    }

    @GetMapping("/findById")
    public Hall findHallById(@RequestParam int hallNumber, @RequestParam Long cinemaId) {
        HallId hallId = new HallId(hallNumber, cinemaId);
        return serviceHall.findHallById(hallId);
    }
}
