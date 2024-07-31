package Haui.StudentManagement.service.impl;


import Haui.StudentManagement.custom.teacher.request.CreateTeacherRequest;
import Haui.StudentManagement.custom.teacher.response.TeacherResponse;
import Haui.StudentManagement.entities.Account;
import Haui.StudentManagement.entities.Infor;
import Haui.StudentManagement.entities.Teacher;
import Haui.StudentManagement.repository.AccountRepository;
import Haui.StudentManagement.repository.InforRepository;
import Haui.StudentManagement.repository.RoleRepository;
import Haui.StudentManagement.repository.TeacherRepository;
import Haui.StudentManagement.service.AccountService;
import Haui.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private InforRepository inforRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Integer id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Optional<Teacher> findByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public Optional<Infor> getTeacherInfor(int id) {
        return teacherRepository.getTeacherInfor(id);
    }

    @Override
    public void createTeacherAccount(CreateTeacherRequest request) {
        Account account=new Account();
        account.setRoleId(2);
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

        Teacher teacher=new Teacher();
        teacher.setAccountId(accountRepository.save(account).getAccountId());
        teacher.setCreateAt(LocalDateTime.now());
        teacher.setUpdatedAt(LocalDateTime.now());
        teacher.setInforId(inforRepository.save(infor).getInforId());
        teacherRepository.save(teacher);
    }

    @Override
    public List<TeacherResponse> findAllForView() {
        List<TeacherResponse> list=new ArrayList<>();
        for (Teacher item: teacherRepository.findAll())
        {
            Infor infor=inforRepository.findById(item.getInforId()).get();
            TeacherResponse teacherResponse=new TeacherResponse(
                    item.getTeacherId(),
                    infor.getFullName(),
                    infor.getDateOfBirth(),
                    infor.getGender(),
                    infor.getAddress(),
                    infor.getPhoneNumber(),
                    infor.getEmail(),
                    roleRepository.findById(accountRepository.findById(item.getAccountId()).get().getRoleId()).get().getRoleName()
            );
            list.add(teacherResponse);
        }
        return list;
    }


}
