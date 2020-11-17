package lk.ijse.easy_car_rental.entity;

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
public class Driver {
    @Id
    private String driverID;
    private String name;
    private String contactNo;
    private String nic;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();

}
