package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Customer {
    @Id
    private String customerID;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String drivingLicenceNo;
    private String nicNo;
    private boolean verified;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<lk.ijse.spring.entity.Booking> bookings = new ArrayList<>();

}
