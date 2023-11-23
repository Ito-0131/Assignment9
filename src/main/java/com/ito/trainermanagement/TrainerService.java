package com.ito.trainermanagement;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    private final TrainerMapper trainerMapper;

    public TrainerService(TrainerMapper trainerMapper) {
        this.trainerMapper = trainerMapper;
    }

    public List<Trainer> findByNameStartingWith(String startingWith) {
        return trainerMapper.findByNameStartingWith(startingWith);
    }

    public List<Trainer> findByBirthday(String birthday) {
        return trainerMapper.findByBirthday(birthday);
    }

    public Optional<Trainer> findByTrainerId(int trainerId) {
        return trainerMapper.findByTrainerId(trainerId);
    }

    public List<Trainer> findAll() {
        return trainerMapper.findAll();
    }

    public List<Trainer> findByName(String name) {
        return trainerMapper.findByName(name);
    }

}
