package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        if (carRepo.existsById(dto.getCarID())){
            carRepo.save(modelMapper.map(dto,Car.class));
        }else{
            throw new RuntimeException("No such car for update..!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such car for delete..!");
        }
    }

    @Override
    public CarDto searchCar(String id) {
        Optional<Car> car = carRepo.findById(id);
        if (car.isPresent()){
            return modelMapper.map(car.get(),CarDto.class);
        }else{
            throw new RuntimeException("No Car for id: " + id);
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepo.findAll();
        return modelMapper.map(cars, new TypeToken<List<CarDto>>(){}.getType());
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

    @Override
    public List<CarDto> getCarByType(String type) {
        List<Car> cars = carRepo.findCarsByType(type);
        return modelMapper.map(cars, new TypeToken<List<Car>>(){}.getType());
    }
}
