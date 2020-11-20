package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    private String bookingID;
    private Date date;
    private Date returnDate;
    private int lastKM;
    private double lossDamageWaiver;
    private String status;
    private String note;

    @ManyToOne
    @JoinColumn(name = "cusID", referencedColumnName = "customerID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carID", nullable = false)
    private lk.ijse.spring.entity.Car car;

    @ManyToOne
    @JoinColumn(name = "driverid", referencedColumnName = "driverID", nullable = false)
    private Driver driver;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private BookingReturn bookingReturn;
}
