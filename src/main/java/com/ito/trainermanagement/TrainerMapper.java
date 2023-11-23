package com.ito.trainermanagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainerMapper {
    @Select("SELECT * FROM names")
    List<Trainer> findAll();

    // prefixは接頭辞という意味
    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Trainer> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM names WHERE name LIKE CONCAT('%', #{query}, '%')")
    List<Trainer> findByQuery(String query);

    @Select("SELECT * FROM names WHERE birthday = #{birthday}")
    List<Trainer> findByBirthday(String birthday);

    // trainerIdを取得する
    @Select("SELECT * FROM names WHERE trainer_id = #{trainerId}")
    Trainer findByTrainerId(int trainerId);

}

