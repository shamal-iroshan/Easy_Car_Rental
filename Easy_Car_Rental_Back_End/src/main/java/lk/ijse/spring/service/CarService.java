package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDto;

import java.util.List;

public interface CarService {
    void saveCar(CarDto dto);
    void updateCar(CarDto dto);
    void deleteCar(String id);
    CarDto searchCar(String id);
    List<CarDto> getAllCars();
    String getLastID();
    List<CarDto> getCarByType(String type);
}
