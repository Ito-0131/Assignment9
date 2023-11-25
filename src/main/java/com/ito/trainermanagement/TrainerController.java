package com.ito.trainermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public List<Trainer> findTrainers(
            @RequestParam(required = false) String startingWith,
            @RequestParam(required = false) String birthday,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer trainerId) {


        if (startingWith != null) {
            return trainerService.findByNameStartingWith(startingWith);
        }

        if (birthday != null) {
            return trainerService.findByBirthday(birthday);
        }

        if (name != null) {
            return trainerService.findByName(name);
        }

        if (trainerId != null) {
            Optional<Trainer> trainer = trainerService.findByTrainerId(trainerId);
            return Arrays.asList(trainer.get());
        }

        List<Trainer> trainers = trainerService.findAll();
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException("No trainers available");
        }
        return trainers;
    }
    //　指定した誕生日のトレーナーを取得する
    // 例：http://localhost:8080/trainers?birthday=1990-01-01

    // 特定のtrainer_idのトレーナーを取得する
    // 例：http://localhost:8080/trainers?trainerId=1

    // 全件取得する
    // http://localhost:8080/trainers

    // クエリ文字列を指定して検索する
    // 例：http://localhost:8080/trainers?name=キハダ

    // 特定の文字から始まる名前を取得する
    // 例：http://localhost:8080/trainers?startingWith=あ
}
