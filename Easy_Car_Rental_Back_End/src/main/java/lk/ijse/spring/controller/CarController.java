package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody CarDto dto) {
        carService.saveCar(dto);
        System.out.println(dto.toString());
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCar(@RequestBody CarDto dto){
        carService.updateCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCar(@RequestParam String id){
        carService.deleteCar(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCar(@PathVariable String id){
        System.out.println(id);
        CarDto carDto = carService.searchCar(id);
        StandardResponse response = new StandardResponse(200, "Success", carDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{identity}/{type}")
    public ResponseEntity getCarsByType(@PathVariable("type") String type){
        List<CarDto> list = carService.getCarByType(type);
        StandardResponse response = new StandardResponse(200, "Success", list);
        return new ResponseEntity(response, HttpStatus.OK);
    }
//
//    @GetMapping(params = {"id"})
//    public ResponseEntity getCarByType(@RequestParam String type){
//        System.out.println(type);
////        List<CarDto> cars = carService.getCarByType(type);
//        StandardResponse response = new StandardResponse(200, "Success", null);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity getAllCars(){
        List<CarDto> allCars = carService.getAllCars();
        StandardResponse response = new StandardResponse(200, "Success", allCars);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
