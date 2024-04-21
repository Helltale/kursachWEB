package com.example.lab2.Controller;

import com.example.lab2.Objects.Place.Place;
import com.example.lab2.Objects.Place.PlacePojo;
import com.example.lab2.Service.ServicePlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private ServicePlace servicePlace;

    @PostMapping("/create")
    public Place createPlace(@RequestBody PlacePojo placePojo) {
        return servicePlace.createPlace(placePojo);
    }

    @DeleteMapping("/delete")
    public void deletePlace(@RequestParam Long placeId) {
        servicePlace.deletePlace(placeId);
    }

    @PutMapping("/update")
    public Place updatePlace(@RequestParam Long placeId, @RequestBody PlacePojo placePojo) {
        return servicePlace.updatePlace(placeId, placePojo);
    }

    @GetMapping("/findById")
    public Place findPlaceById(@RequestParam Long placeId) {
        return servicePlace.findPlaceById(placeId);
    }
}
