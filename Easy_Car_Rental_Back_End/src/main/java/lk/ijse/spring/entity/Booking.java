package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Booking {
    @Id
    private String bookingID;
    private String date;
    private String pickupDate;
    private String status;
    private String note;
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "cusID", referencedColumnName = "customerID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carID", nullable = false)
    private lk.ijse.spring.entity.Car car;

    @ManyToOne
    @JoinColumn(name = "driverid", referencedColumnName = "driverID")
    private Driver driver;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private BookingReturn bookingReturn;
}
