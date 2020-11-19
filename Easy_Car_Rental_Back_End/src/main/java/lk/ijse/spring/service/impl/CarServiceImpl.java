package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarRepo carRepo;

    @Override
    public void saveCar(CarDto dto) {
        Car car = modelMapper.map(dto, Car.class);
        car.setCarID(getLastID());
        carRepo.save(car);
    }

    @Override
    public void updateCar(CarDto dto) {

    }

    @Override
    public void deleteCar(String id) {

    }

    @Override
    public CarDto searchCar(String id) {
        return null;
    }

    @Override
    public List<CarDto> getAllCars() {
        return null;
    }

    @Override
    public String getLastID() {
        String lastID = carRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("V");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "V00" + id;
            else if (id < 100) return "V0" + id;
            else return "V" + id;
        }else{
            return "V001";
        }
    }
}
