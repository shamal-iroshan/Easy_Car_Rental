package lk.ijse.easy_car_rental.adwiser;

import lk.ijse.easy_car_rental.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(RuntimeException ex){
        StandardResponse response = new StandardResponse(500, "Error", ex.getMessage());
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
