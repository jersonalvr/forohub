package com.alura.challenge.forohub.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectModel> registerSubject(@RequestBody SubjectModel request) {
        SubjectModel subjectModel = this.subjectService.registerSubject(request);
        return ResponseEntity.ok(subjectModel);
    }

    @GetMapping
    public ResponseEntity<ArrayList<SubjectModel>> listSubjects() {
        ArrayList<SubjectModel> arrayList = (ArrayList<SubjectModel>) this.subjectService.listSubjects();
        return ResponseEntity.ok(arrayList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getSubject(@PathVariable("id") Long id) {
        Optional<SubjectModel> subjectModel = this.subjectService.getSubject(id);
        if (subjectModel == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subjectModel);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SubjectModel> updateSubject(@PathVariable("id") Long id, @RequestBody SubjectModel request) {
        SubjectModel subjectModel = this.subjectService.updateSubject(id, request);
        if (subjectModel == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subjectModel);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteSubject(@PathVariable("id") Long id) {
        boolean deleted = this.subjectService.deleteSubject(id);
        if (deleted) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}