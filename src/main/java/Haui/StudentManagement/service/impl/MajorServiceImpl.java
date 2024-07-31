package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.custom.major.response.MajorResponse;
import Haui.StudentManagement.entities.Major;
import Haui.StudentManagement.repository.DepartmentRepository;
import Haui.StudentManagement.repository.InforRepository;
import Haui.StudentManagement.repository.MajorRepository;
import Haui.StudentManagement.repository.TeacherRepository;
import Haui.StudentManagement.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private InforRepository inforRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Optional<Major> findById(Integer id) {
        return majorRepository.findById(id);
    }

    @Override
    public Major save(Major major) {
        return majorRepository.save(major);
    }

    @Override
    public void deleteById(Integer id) {
        majorRepository.deleteById(id);
    }


    @Override
    public Optional<Major> findByName(String name) {
        return majorRepository.findByName(name);
    }

    @Override
    public List<MajorResponse> findAllForView() {
        List<MajorResponse> list=new ArrayList<>();
        for(Major item:majorRepository.findAll())
        {
            MajorResponse majorResponse=new MajorResponse(
                    item.getMajorId(),
                    item.getMajorName(),
                    departmentRepository.findById(item.getDepartmentId()).get().getDepartmentName(),
                    inforRepository.findById(teacherRepository.findById(item.getTeacherId()).get().getInforId()).get().getFullName(),
                    item.getCreateAt(),
                    item.getUpdatedAt()
            );
            list.add(majorResponse);
        }
        return list;
    }
}
