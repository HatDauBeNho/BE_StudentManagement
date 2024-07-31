package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.entities.Account;
import Haui.StudentManagement.repository.AccountRepository;
import Haui.StudentManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(Integer id)
    {
        accountRepository.deleteById(id);
    }

    @Override
    public String randomPassword() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 8);
    }
}
