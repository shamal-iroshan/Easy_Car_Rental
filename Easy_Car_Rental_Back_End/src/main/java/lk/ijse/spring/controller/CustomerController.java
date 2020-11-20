package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.dto.LoginDto;
import lk.ijse.spring.dto.RegistrationDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.LoginService;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    DriverService driverService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDto dto) {
        dto.setPassword(hashPassword(dto.getPassword()));
        System.out.println(dto.getPassword());
        customerService.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{userName}/{password}")
    public ResponseEntity login(@PathVariable("userName") String val1, @PathVariable("password") String val2){
        val2 = hashPassword(val2);
        CustomerDto customerDto = customerService.login(val1, val2);
        if(customerDto != null){
            customerDto.setPassword("");
            StandardResponse response = new StandardResponse(200, "true", customerDto);
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            DriverDto driverDto = driverService.login(val1, val2);
            driverDto.setPassword("");
            StandardResponse response = new StandardResponse(200, "true", driverDto);
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody CustomerDto dto) {
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDto customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", customerDTO), HttpStatus.OK);
    }


    public ResponseEntity getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "Success", allCustomers), HttpStatus.OK);
    }

    private String hashPassword(String password) {

        String generatedPassword = null;

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, bytes);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            generatedPassword = hashtext;

        }catch (NoSuchAlgorithmException ex){
            System.out.println(ex);
        }

        return generatedPassword;

    }
}
