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
        List<Trainer> trainers = trainerMapper.findByNameStartingWith(startingWith);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException(startingWith + "で始まる名前のトレーナーは存在していません");
        }
        return trainers;
    }

    public List<Trainer> findByBirthday(String birthday) {
        List<Trainer> trainers = trainerMapper.findByBirthday(birthday);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException("生年月日が" + birthday + "のトレーナーはいません");
        }
        return trainers;
    }

    public Optional<Trainer> findByTrainerId(int trainerId) {
        Optional<Trainer> trainer = trainerMapper.findByTrainerId(trainerId);
        if (!trainer.isPresent()) {
            throw new TrainerNotFoundException("trainerIdが" + trainerId + "のトレーナーはいません");
        }
        return trainer;
    }

    public List<Trainer> findAll() {
        List<Trainer> trainers = trainerMapper.findAll();
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException("トレーナーはいません");
        }
        return trainers;
    }

    public List<Trainer> findByName(String name) {
        List<Trainer> trainers = trainerMapper.findByName(name);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException(name + "という名前のトレーナーはいません");
        }
        return trainers;
    }

}
