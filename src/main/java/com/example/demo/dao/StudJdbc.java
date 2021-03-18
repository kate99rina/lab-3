package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudJdbc {
    private final JdbcTemplate jdbcTemplate;
    public StudJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Student getStud(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", this::mapStud, id);
    }
    public Student mapStud(ResultSet rs, int i) throws SQLException {

        Student stud = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("name"),
                rs.getString("second_name"),
                rs.getInt("study_group_id")
        );
        return stud;
    }
    public List<Student> getallStud() {
        return jdbcTemplate.query("SELECT * FROM student ", this::mapStud);
    }

    public Student getStudByGroup(int study_group_id){
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE study_group_id = ?", this::mapStud, study_group_id);
    }

    public int insStud(int id, String surname, String name, String second_name, int grid){
        return jdbcTemplate.update("INSERT into student(id, surname, name, second_name, study_group_id) values (?,?,?,?,?)", id,surname ,name, second_name, grid);
    }

    public int updateStud(int id, String surname, String name, String second_name, int grid){
        return jdbcTemplate.update("UPDATE student SET name = ?, surname = ?, second_name = ?, study_group_id = ? where id = ?", name, surname, second_name, grid, id);
    }

    public int delStud(int id){
        return jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }
}
