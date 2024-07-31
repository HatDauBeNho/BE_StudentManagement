package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.custom.student.request.CreateStudentRequest;
import Haui.StudentManagement.custom.student.response.StudentReponse;
import Haui.StudentManagement.entities.Account;
import Haui.StudentManagement.entities.Infor;
import Haui.StudentManagement.entities.Student;
import Haui.StudentManagement.repository.AccountRepository;
import Haui.StudentManagement.repository.ClassroomRepository;
import Haui.StudentManagement.repository.InforRepository;
import Haui.StudentManagement.repository.StudentRepository;
import Haui.StudentManagement.service.AccountService;
import Haui.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InforRepository inforRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Optional<Infor> getStudentInfor(int id) {
        return studentRepository.getStudentInfor(id);
    }

    @Override
    public void createStudentAccount(CreateStudentRequest request) {
        Account account=new Account();
        account.setRoleId(3);
        account.setUserName(request.getFullName().toLowerCase().replace(" ","")+"@Haui");
        account.setPassword(accountService.randomPassword());
        account.setCreateAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        Infor infor=new Infor();
        infor.setAddress(request.getAddress());
        infor.setEmail(request.getEmail());
        infor.setGender(request.getGender());
        infor.setEmail(request.getEmail());
        infor.setDateOfBirth(request.getDateOfBirth());
        infor.setPhoneNumber(request.getPhoneNumber());
        infor.setFullName(request.getFullName());
        infor.setCreateAt(LocalDateTime.now());
        infor.setUpdatedAt(LocalDateTime.now());

        Student student=new Student();
        student.setAccountId(accountRepository.save(account).getAccountId());
        student.setClassId(classroomRepository.findByName(request.getClassName()).get().getClassId());
        student.setCreateAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setInforId(inforRepository.save(infor).getInforId());

        studentRepository.save(student);

    }

    @Override
    public List<StudentReponse> findAllForView() {
        List<StudentReponse> list=new ArrayList<>();
        for (Student item: studentRepository.findAll())
        {
            Infor infor=studentRepository.getStudentInfor(item.getStudentId()).get();
            StudentReponse studentReponse=new StudentReponse(
                    infor.getFullName(),
                    infor.getDateOfBirth(),
                    infor.getGender(),
                    infor.getAddress(),
                    infor.getPhoneNumber(),
                    infor.getEmail(),
                    item.getGpa(),
                    classroomRepository.findById(item.getClassId()).get().getClassName()
            );
            list.add(studentReponse);
        }
        return list;
    }

}
