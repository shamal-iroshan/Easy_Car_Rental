package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationDto {
    private String customerID;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String drivingLicenceNo;
    private String nicNo;
    private String userName;
    private String password;
}
