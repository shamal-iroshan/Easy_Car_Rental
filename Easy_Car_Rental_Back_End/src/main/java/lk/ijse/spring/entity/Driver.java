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
@ToString
@Entity
public class Driver {
    @Id
    private String driverID;
    private String name;
    private String contactNo;
    private String nic;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<lk.ijse.spring.entity.Booking> bookings = new ArrayList<>();

}
