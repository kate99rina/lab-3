CREATE TABLE study_group (id INT auto_increment , name TEXT, PRIMARY KEY(id));
CREATE TABLE student (id INT auto_increment , surname TEXT, name TEXT, second_name TEXT, study_group_id int, PRIMARY KEY(id), foreign key (study_group_id) references study_group(id));
CREATE TABLE subject (id INT auto_increment , name TEXT, short_name TEXT, PRIMARY KEY(id));
CREATE TABLE exam_type (id INT auto_increment , type TEXT, PRIMARY KEY(id));
CREATE TABLE study_plan (id INT auto_increment , subject_id INT, exam_type_id INT, PRIMARY KEY(id), foreign key (subject_id) references subject(id), foreign key (exam_type_id) references exam_type(id));
CREATE TABLE mark (id INT auto_increment , name TEXT, value text, PRIMARY KEY(id));
CREATE TABLE journal (id INT auto_increment , student_id INT, study_plan_id INT, in_time bit, count INT, mark_id INT , PRIMARY KEY(id), foreign key (student_id) references student(id), foreign key (study_plan_id) references study_plan(id), foreign key (mark_id) references mark(id));
INSERT into subject (name, short_name) values ('Проектирование информационных систем', 'ПрИС');
INSERT into subject (name, short_name)values ('Системы искусственного интеллекта', 'СИИ');
INSERT into subject (name, short_name)values ('Программная инженерия', 'ПИ');
INSERT into subject (name, short_name)values ('Национальная система информационной безопасности', 'НСИБ');
INSERT into subject (name, short_name)values ('Системный анализ', 'СисАнал');
INSERT into subject (name, short_name)values ('Распределенные базы данных', 'РБД');
INSERT into subject (name, short_name)values ('Системное программное обеспечение', 'СПО');
INSERT into exam_type (type) values ('Экзамен');
INSERT into exam_type (type) values ('Зачет');
INSERT into exam_type (type) values ('Зачет с оценкой');
INSERT into exam_type (type) values ('Курсовая');

INSERT into study_plan (subject_id, exam_type_id) values (1, 1);
INSERT into study_plan (subject_id, exam_type_id) values (1, 4);
INSERT into study_plan (subject_id, exam_type_id) values (2, 1);
INSERT into study_plan (subject_id, exam_type_id) values (3, 1);
INSERT into study_plan (subject_id, exam_type_id) values (4, 2);
INSERT into study_plan (subject_id, exam_type_id) values (5, 1);
INSERT into study_plan (subject_id, exam_type_id) values (6, 2);
INSERT into study_plan (subject_id, exam_type_id) values (7, 1);

INSERT into mark (name, value) values( 'Отлично', 5);
INSERT into mark (name, value) values('Хорошо', 4);
INSERT into mark (name, value) values('Удовлетворительно', 3);
INSERT into mark (name, value) values('Неудовлетворительно', 2);
INSERT into mark (name, value) values('Зачет', 'з');
INSERT into mark (name, value) values('Незачет', 'н');
INSERT into mark (name, value) values('Неявка', '');

INSERT into study_group (name) values ( 'ИКБО-11-17' );
INSERT into study_group (name) values ( 'ИКБО-12-17' );
INSERT into study_group (name) values ( 'ИКБО-13-17' );
INSERT into study_group (name) values ( 'ИКБО-10-17' );

INSERT into student(surname, name, second_name, study_group_id) values ( 'Васильев', 'Иван','Сергеевич','1' );
INSERT into student(surname, name, second_name, study_group_id) values ( 'Бузыкин', 'Игорь','Валерьевич','2');
INSERT into student(surname, name, second_name, study_group_id) values ( 'Белоусов', 'Иван','Сергеевич','3' );

INSERT into journal(student_id, study_plan_id, in_time, count, mark_id) values (2, 2 , 1 , 1 , 4);
CREATE TABLE student_local (id INT auto_increment , surname TEXT, name TEXT, second_name TEXT, study_group_id int, PRIMARY KEY(id), foreign key (study_group_id) references study_group(id));
INSERT into student_local (id, surname, name, second_name, study_group_id) values (198413848,'Лепехина', 'Екатерина','Андреевна','2' );
