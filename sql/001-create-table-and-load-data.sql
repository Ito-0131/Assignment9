DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 trainer_id int unsigned NOT NULL,
 name VARCHAR(20) NOT NULL,
 birthday DATE NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO names (trainer_id, name, birthday) VALUES (111, "ハルト","1993-01-31");
INSERT INTO names (trainer_id, name, birthday) VALUES (222, "ネモ","1993-05-01");
INSERT INTO names (trainer_id, name, birthday) VALUES (333, "ボタン","1993-08-01");
INSERT INTO names (trainer_id, name, birthday) VALUES (444, "キハダ","1993-04-20");