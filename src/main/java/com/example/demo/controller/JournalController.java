package com.example.demo.controller;

import com.example.demo.dao.JournalJdbc;
import com.example.demo.dao.StudJdbc;
import com.example.demo.model.Journal;
import com.example.demo.model.Stud_plan;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
public class JournalController {

    private final JournalJdbc jourJdbc;
    public JournalController(JournalJdbc jourJdbc){
        this.jourJdbc = jourJdbc;
    }

    @GetMapping("/journal/")
    public List<Journal> journals(){
        List<Journal> journal = jourJdbc.getJournal();
        return  journal;
    }
    @GetMapping("/plan/")
    public List<Stud_plan> getStPlan(){
        List<Stud_plan> plan = jourJdbc.getPlan();;
        return plan;
    }
    @GetMapping("/journal/student/{student_id}")
    public List<Journal> journalByStud(@PathVariable int student_id){
        List<Journal> journal = jourJdbc.getJournalByStud(student_id);
        return  journal;
    }

    @GetMapping("/journal/group/{study_group_id}")
    public List<Journal> journalByGr(@PathVariable int study_group_id){
        List<Journal> journal = jourJdbc.getJournalByGroup(study_group_id);
        return  journal;
    }

    @PutMapping("journal/update/{id}")
    public int updateJourn(@PathVariable int id, @RequestBody RequestJ requestJ){
        int journal = jourJdbc.updJournal(id, requestJ.mark);
        return journal;
    }

}

class RequestJ{
    public int mark;
}
