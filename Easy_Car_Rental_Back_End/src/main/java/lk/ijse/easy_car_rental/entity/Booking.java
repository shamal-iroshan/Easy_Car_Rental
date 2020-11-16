package lk.ijse.easy_car_rental.entity;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cusID", referencedColumnName = "customerID", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carid", referencedColumnName = "carID", nullable = false)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverid", referencedColumnName = "driverID", nullable = false)
    private Driver driver;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private BookingReturn bookingReturn;
}
