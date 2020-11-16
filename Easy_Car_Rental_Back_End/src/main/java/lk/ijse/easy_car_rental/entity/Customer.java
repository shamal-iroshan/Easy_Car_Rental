package lk.ijse.easy_car_rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    String customerID;
    String name;
    String contact;
    String email;
    String address;
    String drivingLicenceNo;
    String nicNo;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Request> requests = new ArrayList<>();
}
