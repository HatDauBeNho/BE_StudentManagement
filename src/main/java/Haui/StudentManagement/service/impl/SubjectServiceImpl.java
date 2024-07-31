package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.custom.subject.response.SubjectResponse;
import Haui.StudentManagement.entities.Subject;
import Haui.StudentManagement.repository.DepartmentRepository;
import Haui.StudentManagement.repository.SubjectRepository;
import Haui.StudentManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Optional<Subject> findByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public List<SubjectResponse> findAllForView() {
        List<SubjectResponse> list=new ArrayList<>();
        for (Subject item: subjectRepository.findAll())
        {
            SubjectResponse subjectResponse=new SubjectResponse(
                    item.getSubjectId(),
                    item.getSubjectName(),
                    item.getCredit(),
                    departmentRepository.findByName(item.getSubjectName()).get().getDepartmentName()
            );
            list.add(subjectResponse);
        }
        return list;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Integer id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }
}
