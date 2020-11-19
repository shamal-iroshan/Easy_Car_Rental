package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
