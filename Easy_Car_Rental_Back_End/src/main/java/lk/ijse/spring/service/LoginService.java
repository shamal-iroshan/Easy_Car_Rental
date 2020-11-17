package lk.ijse.spring.service;

import lk.ijse.spring.dto.LoginDto;

import java.util.List;

public interface LoginService {
    void addLogin(LoginDto loginDto);
    void updateLogin(LoginDto loginDto);
    void deleteLogin(String id);
    LoginDto searchLogin(String id);
    List<LoginDto> getAllLogin();
    String getLastLoginID();
}
