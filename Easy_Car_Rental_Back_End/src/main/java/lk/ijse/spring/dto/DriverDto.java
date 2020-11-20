package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDto {
    private String driverID;
    private String name;
    private String contactNo;
    private String nic;
    private String userName;
    private String password;
}
