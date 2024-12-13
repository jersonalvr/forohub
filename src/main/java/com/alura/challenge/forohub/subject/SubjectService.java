package com.alura.challenge.forohub.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectModel registerSubject(SubjectModel request) {
        return subjectRepository.save(request);
    }

    public ArrayList<SubjectModel> listSubjects() {
        return (ArrayList<SubjectModel>) subjectRepository.findAll();
    }

    public Optional<SubjectModel> getSubject(Long id) {
        return subjectRepository.findById(id);
    }

    public SubjectModel updateSubject(Long id, SubjectModel request) {
        SubjectModel subjectModel = subjectRepository.findById(id).get();
        subjectModel.setUser_id(request.getUser_id());
        subjectModel.setCourse(request.getCourse());
        subjectModel.setTitle(request.getTitle());
        subjectModel.setMessage(request.getMessage());
        subjectRepository.save(subjectModel);
        return subjectModel;
    }

    public Boolean deleteSubject(Long id) {
        try {
            subjectRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}