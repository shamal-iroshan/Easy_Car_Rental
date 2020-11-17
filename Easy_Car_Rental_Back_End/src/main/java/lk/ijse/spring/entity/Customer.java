package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String customerID;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String drivingLicenceNo;
    private String nicNo;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<lk.ijse.spring.entity.Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userID", nullable = false)
    private lk.ijse.spring.entity.Login login;

}
