package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.entities.ModuleSubject;
import Haui.StudentManagement.service.ModuleSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleSubjectServiceImpl implements ModuleSubjectService {
    @Autowired
    private ModuleSubjectService moduleSubjectService;
    @Override
    public Optional<ModuleSubject> findByName(String name) {
        return moduleSubjectService.findByName(name);
    }

    @Override
    public List<ModuleSubject> findAll() {
        return moduleSubjectService.findAll();
    }

    @Override
    public Optional<ModuleSubject> findById(Integer id) {
        return moduleSubjectService.findById(id);
    }

    @Override
    public ModuleSubject save(ModuleSubject moduleSubject) {
        return moduleSubjectService.save(moduleSubject);
    }

    @Override
    public void deleteById(Integer id) {
        moduleSubjectService.deleteById(id);
    }
}
