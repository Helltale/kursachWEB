package com.example.lab2.Service;

import com.example.lab2.Objects.Hall.Hall;
import com.example.lab2.Objects.Hall.HallId;
import com.example.lab2.Objects.Hall.HallPojo;
import com.example.lab2.Repository.HallRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceHall {

    @Autowired
    private HallRepository hallRepository;

    public Hall createHall(HallPojo hallPojo) {
        // Преобразование объекта HallPojo в Hall
        Hall hall = HallPojo.toEntity(hallPojo);
        return hallRepository.save(hall); // Сохранение зала в базе данных и возврат сохраненного объекта
    }

    public void deleteHall(HallId hallId) {
        // Поиск зала по номеру
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new IllegalArgumentException("Зал с номером " + hallId.getHallNumber() + " и ID кинотеатра " + hallId.getCinemaId() + " не найден"));
        hallRepository.delete(hall); // Удаление зала из базы данных
    }

    public Hall updateHall(HallId hallId, HallPojo hallPojo) {
        // Поиск зала по номеру
        Hall existingHall = hallRepository.findById(hallId)
                .orElseThrow(() -> new IllegalArgumentException("Зал с номером " + hallId.getHallNumber() + " и ID кинотеатра " + hallId.getCinemaId() + " не найден"));

        // Обновление данных зала из объекта HallPojo
        existingHall.setHallSits(hallPojo.getHallSits());

        return hallRepository.save(existingHall); // Сохранение обновленного зала в базе данных и возврат объекта
    }

    public Hall findHallById(HallId hallId) {
        Optional<Hall> optionalHall = hallRepository.findById(hallId);
        return optionalHall.orElse(null);
    }
}
