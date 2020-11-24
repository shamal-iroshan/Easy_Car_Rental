package lk.ijse.spring.controller;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.service.*;
import lk.ijse.spring.service.impl.CustomerServiceImpl;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    AdminService adminService;

    @Autowired
    FileService fileService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDto dto) {
        System.out.println(dto.toString());
        dto.setPassword(hashPassword(dto.getPassword()));
        customerService.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{userName}/{password}")
    public ResponseEntity login(@PathVariable("userName") String val1, @PathVariable("password") String val2){
        val2 = hashPassword(val2);
        CustomerDto customerDto = customerService.login(val1, val2);
        System.out.println(customerDto);
        if(customerDto != null){
            customerDto.setPassword("");
            StandardResponse response = new StandardResponse(200, "customer", customerDto);
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            DriverDto driverDto = driverService.login(val1, val2);
            System.out.println(driverDto);
            if (driverDto != null){
                driverDto.setPassword("");
                StandardResponse response = new StandardResponse(200, "driver", driverDto);
                return new ResponseEntity(response, HttpStatus.OK);
            }else{
                AdminDto adminDto = adminService.login(val1, val2);
                System.out.println(adminDto);
                if (adminDto != null){
                    adminDto.setPassword("");
                    StandardResponse response = new StandardResponse(200, "admin", adminDto);
                    return new ResponseEntity(response, HttpStatus.OK);
                }else{
                    StandardResponse response = new StandardResponse(500, "Error", null);
                    return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody CustomerDto dto) {
        dto.setPassword(hashPassword(dto.getPassword()));
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity verifyCustomer(@PathVariable String id){
        customerService.verifyCustomer(id);
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

    @PostMapping(path = "/upload")
    public ResponseEntity uploadFiles(@RequestParam(value = "file[]") MultipartFile[] files, @RequestParam("nic") String id, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        for (MultipartFile file : files) {
            fileService.save(file, id, rootPath);
        }
        System.out.println("called");
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(headers = {"Content-Type=application/json","Accept=application/json"})
    public ResponseEntity updateProfile(CustomerDto dto){
        System.out.println(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
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
