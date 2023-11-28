package com.ito.trainermanagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TrainerMapper {
    @Select("SELECT * FROM names")
    List<Trainer> findAll();

    // prefixは接頭辞という意味
    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Trainer> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM names WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Trainer> findByName(String name);

    @Select("SELECT * FROM names WHERE birthday = #{birthday}")
    List<Trainer> findByBirthday(String birthday);

    // trainerIdを取得する
    @Select("SELECT * FROM names WHERE trainer_id = #{trainerId}")
    Optional<Trainer> findByTrainerId(int trainerId);
}
