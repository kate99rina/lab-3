package com.example.demo.dao;
import com.example.demo.model.Group;
import com.example.demo.model.Journal;
import com.example.demo.model.Stud_plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JournalJdbc {

    private final JdbcTemplate jdbcTemplate;
    public JournalJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Journal mapJour(ResultSet rs, int i) throws SQLException {
        Journal jour = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getInt("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );
        return jour;
    }
    public Stud_plan  mapPlan(ResultSet rs, int i) throws SQLException{
        Stud_plan stpl = new Stud_plan(
                rs.getInt("id"),
                rs.getInt("subject_id"),
                rs.getInt("exam_type_id")
        );
        return stpl;
    }

    public List<Journal> getJournal(){
        return jdbcTemplate.query("SELECT * FROM journal", this::mapJour);
    }
    public List<Journal> getJournalByStud(int student_id){
        return jdbcTemplate.query("SELECT * FROM journal WHERE student_id = ?", this::mapJour, student_id);
    }
    public List<Stud_plan> getPlan(){return jdbcTemplate.query("SELECT * FROM study_plan", this::mapPlan);}
    public List<Journal> getJournalByGroup(int study_group_id){
        return jdbcTemplate.query( "select * from journal j left join student s on s.id = j.student_id where s.study_group_id = ?", this::mapJour, study_group_id);
    }

    public int updJournal(int id, int mark_id){
        return jdbcTemplate.update("UPDATE  journal SET  mark_id = ?   WHERE id = ?", mark_id, id);
    }


}
