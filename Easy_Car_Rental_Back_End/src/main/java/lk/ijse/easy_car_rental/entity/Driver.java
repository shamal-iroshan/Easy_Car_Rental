package lk.ijse.easy_car_rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver {
    @Id
    String driverID;
    String name;
    String contactNo;
    String nic;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    RequestDetail requestDetail;
}
