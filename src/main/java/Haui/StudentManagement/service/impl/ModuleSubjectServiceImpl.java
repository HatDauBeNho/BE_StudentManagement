package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.entities.ModuleSubject;
import Haui.StudentManagement.repository.ModuleSubjectRepository;
import Haui.StudentManagement.service.ModuleSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleSubjectServiceImpl implements ModuleSubjectService {
    @Autowired
    private ModuleSubjectRepository moduleSubjectRepository;
    @Override
    public Optional<ModuleSubject> findByName(String name) {
        return moduleSubjectRepository.findByName(name);
    }

    @Override
    public List<ModuleSubject> findAll() {
        return moduleSubjectRepository.findAll();
    }

    @Override
    public Optional<ModuleSubject> findById(Integer id) {
        return moduleSubjectRepository.findById(id);
    }

    @Override
    public ModuleSubject save(ModuleSubject moduleSubject) {
        return moduleSubjectRepository.save(moduleSubject);
    }

    @Override
    public void deleteById(Integer id) {
        moduleSubjectRepository.deleteById(id);
    }
}
