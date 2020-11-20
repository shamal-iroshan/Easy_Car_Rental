package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDto;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDto dto);
    void updateDriver(DriverDto dto);
    void deleteDriver(String id);
    DriverDto searchDriver(String id);
    List<DriverDto> getAllDrivers();
    String getLastID();
    DriverDto login(String userName, String password);
}
