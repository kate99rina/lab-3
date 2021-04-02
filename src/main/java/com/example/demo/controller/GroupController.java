package com.example.demo.controller;
import com.example.demo.Request;
import com.example.demo.dao.GroupJdbc;
import com.example.demo.model.FieldName;
import com.example.demo.model.Group;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class GroupController {
    private final GroupJdbc groupJdbc;

    public GroupController(GroupJdbc groupJdbc) {
        this.groupJdbc = groupJdbc;
    }

    // Просмотр группы
    @GetMapping("/groups/{id}")
    public Group getGroup(@PathVariable int id) {
        return groupJdbc.getGroup(id);
    }

    // Просмотр всех групп
    @GetMapping("/groups")
    public ArrayList<Group> getAllGroup() {
        return groupJdbc.getAllGroup();
    }

    // Просмотр всех доступных групп
    @GetMapping("/avaliablegroups/{id}")
    public List<FieldName> getAvailableGroup(@PathVariable int id) {
        return groupJdbc.getAvailableGroup(id);
    }

    // Создание группы
    @PostMapping("/group/insert")
    public void insertGroup(@RequestBody Request request) {
        groupJdbc.insertGroup(request.id, request.name);
    }

    // Редактирование группы
    @PostMapping("/group/update/{id}")
    public void updateGroup(@PathVariable int id, @RequestBody Request request) {
        groupJdbc.updateGroup(id, request.name);
    }

    // Удаление группы
    @DeleteMapping("/group/delete/{id}")
    public void delGroupById(@PathVariable int id) {
        groupJdbc.deleteGroup(id);
    }
}
