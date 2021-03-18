package com.example.demo.controller;
import com.example.demo.dao.GroupJdbc;
import com.example.demo.dao.StudJdbc;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class GroupController {
    private final GroupJdbc groupJdbc;
    public GroupController(GroupJdbc groupJdbc){
        this.groupJdbc = groupJdbc;
    }

    //Просмотр группы
    @GetMapping("/group/{id}")
    public Group group(@PathVariable int id){
        Group group =groupJdbc.getGroup(id);
        return  group;
    }

    //Просмотр всех групп
    @GetMapping("/group")
    public List<Group> groups(){
        List<Group> group = groupJdbc.getAllGroup();
        return  group;
    }

    //Создание группы
    @PostMapping("/group/insert/")
    public int insGroup(@RequestBody RequestG request){
        int group = groupJdbc.insGroup(request.id, request.name);
        return  group;
    }

    //Обновление группы с id
    @PutMapping("/group/update/{id}")
    public int updGroupById(@PathVariable int id, @RequestBody RequestG request) {
        int group = groupJdbc.updGroup(id,request.name);
        return group;
    }

    //Удалить группу
    @DeleteMapping("/group/delete/{id}")
    public int delGroupById(@PathVariable int id){
        int group = groupJdbc.delGroup(id);
        return group;
    }
}

class RequestG{
    public int id;
    public String name;
}
