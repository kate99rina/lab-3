package com.example.demo.controller;

import com.example.demo.Request;
import com.example.demo.dao.StudentJdbc;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class StudentController {
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc) {
        this.studentJdbc = studentJdbc;
    }

    // Создание студента
    @PostMapping("/student/insert/")
    public void insertStudent(@RequestBody Request request){
        studentJdbc.insertStudent(request.id,request.name, request.surname, request.secondName, request.studyGroupId);
    }

    // Просмотр студента
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentJdbc.getStudent(id);
    }

    // Просмотр всех студентов
    @GetMapping("/student")
    public ArrayList<Student> getAllStudents(){
        return studentJdbc.getAllStudents();
    }

    // Просмотр всех студентов отсортированный по алфвиту
    @GetMapping("/sort_student")
    public ArrayList<Student> getAllSortStudents(){
        return studentJdbc.getAllSortStudents();
    }

    // Просмотр студентов по группе
    @GetMapping("/group/{group_id}")
    public ArrayList<Student> getAllStudentsByGroup(@PathVariable int group_id){
        return studentJdbc.getAllStudentsByGroup(group_id);
    }

    //Обновление студента с id
    @PutMapping("/student/update/{id}")
    public void updStudById(@PathVariable int id, @RequestBody Request request) {
        studentJdbc.updateStudent(id, request.surname, request.name, request.secondName, request.studyGroupId);
    }

    // Удаление студента
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        studentJdbc.deleteStudent(id);
    }

}

