package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.custom.department.response.DepartmentResponse;
import Haui.StudentManagement.entities.Department;
import Haui.StudentManagement.repository.DepartmentRepository;
import Haui.StudentManagement.repository.InforRepository;
import Haui.StudentManagement.repository.TeacherRepository;
import Haui.StudentManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private InforRepository inforRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<DepartmentResponse> findAllForView() {
        List<DepartmentResponse> list = new ArrayList<>();
        for (Department item:departmentRepository.findAll())
        {
            DepartmentResponse departmentResponse=new DepartmentResponse(
                    item.getDepartmentId(),
                    item.getDepartmentName(),
                    inforRepository.findById(item.getTeacherId()).get().getFullName(),
                    item.getCreateAt(),
                    item.getUpdatedAt()
            );
            list.add(departmentResponse);
        }
        return list;
    }
}
