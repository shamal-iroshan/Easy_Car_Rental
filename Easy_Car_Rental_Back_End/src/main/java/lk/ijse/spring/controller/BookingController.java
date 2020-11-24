package lk.ijse.spring.controller;

import lk.ijse.spring.dto.BookingDto;
import lk.ijse.spring.service.BookingService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    public ResponseEntity bookCar(BookingDto dto){
        System.out.println("dto.toString()");
        bookingService.saveBooking(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateBooking(@RequestBody BookingDto dto){
        bookingService.saveBooking(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteBooking(@RequestParam String id){
        bookingService.deleteBooking(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getBooking(@PathVariable String id){
        BookingDto booking = bookingService.searchBooking(id);
        StandardResponse response = new StandardResponse(200, "Success", booking);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBookings(){
        List<BookingDto> allBooking = bookingService.getAllBooking();
        StandardResponse response = new StandardResponse(200, "Success", allBooking);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
