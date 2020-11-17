package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDto dto) {
        customerService.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDto dto) {
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDto customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", customerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "Success", allCustomers), HttpStatus.OK);
    }
}
