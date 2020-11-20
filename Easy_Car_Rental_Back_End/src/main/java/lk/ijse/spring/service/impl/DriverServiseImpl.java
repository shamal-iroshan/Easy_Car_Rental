package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.dto.LoginDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Login;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.LoginRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiseImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDto dto) {
        Driver driver = mapper.map(dto, Driver.class);
        driver.setDriverID(getLastID());
        driverRepo.save(driver);
    }

    @Override
    public void updateDriver(DriverDto dto) {

    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public DriverDto searchDriver(String id) {
        return null;
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        return null;
    }

    @Override
    public String getLastID() {
        String lastID = driverRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("D");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "D00" + id;
            else if (id < 100) return "D0" + id;
            else return "D" + id;
        }else{
            return "D001";
        }
    }

    @Override
    public DriverDto login(String userName, String password) {
        Driver driver = driverRepo.login(userName, password);
        if (driver == null){
            throw new RuntimeException("Check Login details");
        }

        return mapper.map(driver,DriverDto.class);
    }
}
