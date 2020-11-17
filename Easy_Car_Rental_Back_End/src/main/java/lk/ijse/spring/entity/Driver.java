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
public class Driver {
    @Id
    private String driverID;
    private String name;
    private String contactNo;
    private String nic;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<lk.ijse.spring.entity.Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userID", nullable = false)
    private lk.ijse.spring.entity.Login login;

}
