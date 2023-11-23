package com.ito.trainermanagement;

import java.time.LocalDate;

public class Trainer {
    private int id;
    private String name;
    private LocalDate birthday;
    private int trainerId;

    public Trainer(int id, String name, LocalDate birthday, int trainerId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.trainerId = trainerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getTrainerId() {
        return trainerId;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", trainer_id=" + trainerId +
                '}';
    }
}
