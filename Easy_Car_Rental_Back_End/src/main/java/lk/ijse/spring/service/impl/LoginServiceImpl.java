package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.LoginDto;
import lk.ijse.spring.entity.Login;
import lk.ijse.spring.repo.LoginRepo;
import lk.ijse.spring.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addLogin(LoginDto loginDto) {
        Login login = modelMapper.map(loginDto, Login.class);
        login.setUserID(getLastLoginID());
        loginRepo.save(login);
    }

    @Override
    public void updateLogin(LoginDto loginDto) {

    }

    @Override
    public void deleteLogin(String id) {

    }

    @Override
    public LoginDto searchLogin(String id) {
        return null;
    }

    @Override
    public List<LoginDto> getAllLogin() {
        return null;
    }

    @Override
    public String getLastLoginID() {
        String lastID = loginRepo.getLastID();
        String[] split = lastID.split("U");
        int id = Integer.parseInt(split[1]);
        id++;
        if (id < 10) return "U00" + id;
        else if (id < 100) return "U0" + id;
        else return "U" + id;
    }
}
