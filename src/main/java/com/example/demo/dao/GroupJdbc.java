package com.example.demo.dao;
import com.example.demo.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroupJdbc {
    private final JdbcTemplate jdbcTemplate;
    public GroupJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Group mapGr(ResultSet rs, int i) throws SQLException {
        Group grp = new Group(
                rs.getInt("id"),
                rs.getString("name")
        );
        return grp;
    }
    public Group getGroup(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM study_group WHERE id = ?", this::mapGr, id);
    }

    public List<Group> getAllGroup(){
        return jdbcTemplate.query("SELECT * FROM study_group", this::mapGr);
    }

    public int updGroup(int id, String name){
        return jdbcTemplate.update("UPDATE  study_group SET name = ? WHERE id = ?", name, id);
    }

    public int insGroup(int id, String name){
        return jdbcTemplate.update("INSERT into study_group(id, name) values (?,?)", id, name);
    }

    public int delGroup(int id){
        return jdbcTemplate.update("DELETE FROM study_group WHERE id = ?", id);
    }


}
