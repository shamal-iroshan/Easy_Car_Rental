package lk.ijse.spring.controller;

import lk.ijse.spring.dto.BookingReturnDto;
import lk.ijse.spring.service.BookingReturnService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/bookingReturn")
public class BookingReturnController {

    @Autowired
    BookingReturnService bookingReturnService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveBookingReturn(@RequestBody BookingReturnDto dto){
        bookingReturnService.saveBookingReturn(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateBookingReturn(@RequestBody BookingReturnDto dto){
        bookingReturnService.updateBookingReturn(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteBookingReturn(@RequestParam String id){
        bookingReturnService.deleteBookingReturn(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchBookingReturn(@PathVariable String id){
        BookingReturnDto bookingReturn = bookingReturnService.searchBookingReturn(id);
        StandardResponse response = new StandardResponse(200, "Success", bookingReturn);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBookingReturns(){
        List<BookingReturnDto> allBookingReturn = bookingReturnService.getAllBookingReturn();
        StandardResponse response = new StandardResponse(200, "Success", allBookingReturn);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
