package lk.ijse.spring.controller;

import lk.ijse.spring.dto.BookDto;
import lk.ijse.spring.dto.BookingDto;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    @Autowired
    BookingController bookingController;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity book(@RequestBody BookDto dto){
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingID(dto.getBookingID());
        bookingDto.setDate(dto.getDate());
        bookingDto.setPickupDate(dto.getPickupDate());
        bookingDto.setStatus(dto.getStatus());
        bookingDto.setNote(dto.getNote());
        bookingDto.setReturnDate(dto.getReturnDate());
        bookingDto.setCustomerDto(customerService.searchCustomer(dto.getCustomer()));
        bookingDto.setCarDto(carService.searchCar(dto.getCar()));
        bookingDto.setDriverDto(driverService.searchDriver(dto.getDriver()));

        return bookingController.bookCar(bookingDto);
    }

}
