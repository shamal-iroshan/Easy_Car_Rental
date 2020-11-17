package lk.ijse.spring.controller;

import lk.ijse.spring.dto.LoginDto;
import lk.ijse.spring.service.LoginService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addLogin(@RequestBody LoginDto dto){
        dto.setPassword(hashPassword(dto.getPassword()));
        loginService.addLogin(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
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
