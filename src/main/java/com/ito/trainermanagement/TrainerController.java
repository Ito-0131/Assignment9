package com.ito.trainermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerController {
    private final TrainerMapper trainerMapper;

    public TrainerController(TrainerMapper trainerMapper) {
        this.trainerMapper = trainerMapper;
    }

    // 特定の文字から始まる名前を取得する
    // 例：http://localhost:8080/trainers/name?startingWith=あ
    @GetMapping("/trainers/name")
    public List<Trainer> findByNames(@RequestParam String startingWith) {
        List<Trainer> trainers = trainerMapper.findByNameStartingWith(startingWith);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException(startingWith + "で始まる名前のトレーナーは存在していません");
        }
        return trainers;
    }

    //　指定した誕生日のトレーナーを取得する
    // 例：http://localhost:8080/trainers/birthday?birthday=1990-01-01
    @GetMapping("/trainers/birthday")
    public List<Trainer> findByBirthday(@RequestParam String birthday) {
        List<Trainer> trainers = trainerMapper.findByBirthday(birthday);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException("生年月日が" + birthday + "のトレーナーはいません");
        }
        return trainers;
    }

    // 特定のtrainer_idのトレーナーを取得する
    // 例：http://localhost:8080/trainers/1
    @GetMapping("/trainers/{trainerId}")
    public Trainer findByTrainerId(@PathVariable int trainerId) {
        Trainer trainer = trainerMapper.findByTrainerId(trainerId);
        if (trainer == null) {
            throw new TrainerNotFoundException("trainerIdが" + trainerId + "のトレーナーはいません");
        }
        return trainer;
    }


    // 全件取得する
    @GetMapping("/trainers")
    public List<Trainer> findAll() {
        List<Trainer> trainers = trainerMapper.findAll();
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException("No trainers available");
        }
        return trainers;
    }

    // クエリ文字列を指定して検索する
    // 例：http://localhost:8080/trainers/search?query=あ
    @GetMapping("/trainers/search")
    public List<Trainer> searchByQuery(@RequestParam String query) {
        List<Trainer> trainers = trainerMapper.findByQuery(query);
        if (trainers.isEmpty()) {
            throw new TrainerNotFoundException(query + "という名前のトレーナーはいません");
        }
        return trainers;
    }

}