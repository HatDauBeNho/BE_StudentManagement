package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.custom.classroom.response.ClassroomResponse;
import Haui.StudentManagement.entities.Classroom;
import Haui.StudentManagement.repository.*;
import Haui.StudentManagement.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private InforRepository inforRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Integer id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Optional<Classroom> findByName(String name) {
        return classroomRepository.findByName(name);
    }

    @Override
    public List<ClassroomResponse> findAllForView() {
        List<ClassroomResponse> list=new ArrayList<>();
        for(Classroom item: classroomRepository.findAll())
        {
            ClassroomResponse classroomResponse=new ClassroomResponse(
                    item.getClassId(),
                    item.getClassName(),
                    item.getQuantity(),
                    majorRepository.findById(item.getMajorId()).get().getMajorName(),
                    departmentRepository.findById(majorRepository.findById(item.getMajorId()).get().getDepartmentId()).get().getDepartmentName(),
                    inforRepository.findById(teacherRepository.findById(item.getTeacherId()).get().getInforId()).get().getFullName(),
                    inforRepository.findById(teacherRepository.findById(item.getTeacherId()).get().getInforId()).get().getPhoneNumber(),
                    item.getCreateAt(),
                    item.getUpdatedAt()
            );
            list.add(classroomResponse);
        }
        return list;
    }
}
