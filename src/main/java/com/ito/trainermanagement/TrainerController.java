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

        List<Trainer> trainers;

        if (startingWith != null) {
            trainers = trainerService.findByNameStartingWith(startingWith);
            if (trainers.isEmpty()) {
                throw new TrainerNotFoundException(startingWith + "で始まる名前のトレーナーは存在していません");
            }
            return trainers;
        }

        if (birthday != null) {
            trainers = trainerService.findByBirthday(birthday);
            if (trainers.isEmpty()) {
                throw new TrainerNotFoundException("生年月日が" + birthday + "のトレーナーはいません");
            }
            return trainers;
        }

        if (name != null) {
            trainers = trainerService.findByName(name);
            if (trainers.isEmpty()) {
                throw new TrainerNotFoundException(name + "という名前のトレーナーはいません");
            }
            return trainers;
        }

        if (trainerId != null) {
            Optional<Trainer> trainer = trainerService.findByTrainerId(trainerId);
            if (!trainer.isPresent()) {
                throw new TrainerNotFoundException("trainerIdが" + trainerId + "のトレーナーはいません");
            }
            return Arrays.asList(trainer.get());
        }

        trainers = trainerService.findAll();
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
