package Haui.StudentManagement.service;

import Haui.StudentManagement.entities.Account;

public interface AccountService extends Generate<Account> {
    String randomPassword();
}
