package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.entities.Infor;
import Haui.StudentManagement.repository.InforRepository;
import Haui.StudentManagement.service.InforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InforServiceImpl  implements InforService {

    @Autowired
    private InforRepository inforRepository;
    @Override
    public List<Infor> findAll() {
        return inforRepository.findAll();
    }

    @Override
    public Optional<Infor> findById(Integer id) {
        return inforRepository.findById(id);
    }

    @Override
    public Infor save(Infor infor) {
        return inforRepository.save(infor);
    }

    @Override
    public void deleteById(Integer id) {
        inforRepository.deleteById(id);
    }
}
